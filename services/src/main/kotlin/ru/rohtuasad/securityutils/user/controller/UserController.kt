package ru.rohtuasad.securityutils.user.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.rohtuasad.securityutils.user.model.User
import ru.rohtuasad.securityutils.user.repository.UserRepository
import java.util.*

@RestController
@RequestMapping("/v1")
class UserController(val userRepository: UserRepository) {
    @GetMapping("/user/{id}")
    fun getUserProfile(@PathVariable id: UUID): ResponseEntity<Optional<User>> {
        return ResponseEntity(userRepository.findById(id), HttpStatus.OK)
    }

    @GetMapping("/user")
    fun getUserProfile(): MutableIterable<User> {
        return userRepository.findAll()
    }

    @PostMapping("/user")
    fun registerUser(@RequestBody user: User) {
        user.setEncodedPassword(user.password)
        userRepository.save(user)
    }
}
