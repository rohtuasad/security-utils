package ru.rohtuasad.securityutils.user.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.rohtuasad.securityutils.user.model.User
import ru.rohtuasad.securityutils.user.service.UserService
import java.util.*

@RestController
@RequestMapping("/v1")
class UserController(val userService: UserService) {
    @GetMapping("/user/{id}")
    fun getUserProfile(@PathVariable id: UUID): ResponseEntity<User> {
        return ResponseEntity.ok(userService.getUserProfile(id))
    }

    @GetMapping("/user")
    fun getUserProfile(): ResponseEntity<MutableIterable<User>> {
        return ResponseEntity.ok(userService.getUserProfile())
    }

    @PostMapping("/user")
    fun registerUser(@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity.ok(userService.registerUser(user))
    }
}
