package ru.rohtuasad.securityutils.user.service

import org.springframework.stereotype.Service
import ru.rohtuasad.securityutils.user.model.User
import ru.rohtuasad.securityutils.user.repository.UserRepository
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUserProfile(id: UUID): User {
        val user = userRepository.findById(id)
        if (user.isPresent) {
            return user.get()
        }
        throw RuntimeException("Не удалось найти пользователя с uuid = $id")
    }

    fun getUserProfile(): MutableIterable<User> {
        return userRepository.findAll()
    }

    fun registerUser(user: User): User {
        user.setEncodedPassword(user.password)
        return userRepository.save(user)
    }
}