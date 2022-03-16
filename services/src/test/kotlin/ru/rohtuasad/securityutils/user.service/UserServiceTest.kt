package ru.rohtuasad.securityutils.user.service

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import ru.rohtuasad.securityutils.user.model.User

@SpringBootTest
internal class UserServiceTest {
    @Autowired
    private lateinit var userService: UserService

    @Test
    fun getUserProfile() {
        val user = userService.getUserProfile().first()
        assertEquals("Name", user.name)
        assertEquals("login", user.login)
        assertEquals("user@user.com", user.email)
        assertTrue(BCryptPasswordEncoder().matches("password", user.password))
    }

    @Test
    fun testGetUserProfile() {
        val userProfileList = userService.getUserProfile()
        val userProfile = userService.getUserProfile(userProfileList.first().userId!!)
        assertEquals("Name", userProfile.name)
        assertTrue(BCryptPasswordEncoder().matches("password", userProfile.password))
    }

    @Test
    fun registerUser() {
        val user = User("NewUser", "newlogin", "newuser@user.com")
        user.password = "newpassword"
        assertNull(user.userId)
        assertFalse(BCryptPasswordEncoder().matches("newpassword", user.password))

        userService.registerUser(user)
        assertNotNull(user.userId)
        assertTrue(BCryptPasswordEncoder().matches("newpassword", user.password))
    }
}