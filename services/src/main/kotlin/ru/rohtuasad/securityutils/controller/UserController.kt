package ru.rohtuasad.securityutils.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.rohtuasad.securityutils.model.User
import ru.rohtuasad.securityutils.repository.UserRepository
import java.util.*

@RestController
@RequestMapping("/v1")
class UserController(val userRepository: UserRepository) {
    @GetMapping("/user/{id}")
    fun getUserProfile(@PathVariable id: Long): ResponseEntity<Optional<User>> {
        return ResponseEntity(userRepository.findById(id), HttpStatus.OK)
    }

    @GetMapping("/user")
    fun getUserProfile(): MutableIterable<User> {
        return userRepository.findAll()
    }
}
