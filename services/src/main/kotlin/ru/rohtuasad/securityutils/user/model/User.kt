package ru.rohtuasad.securityutils.user.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.*

data class User(
    @JsonProperty("name")
    var name: String,
    @JsonProperty("login")
    var login: String,
    @JsonProperty("email")
    var email: String
) {
    @Id
    @JsonProperty("user-id")
    var userId: UUID? = null

    @JsonProperty("password")
    var password: String? = null

    fun setEncodedPassword(value: String?) {
        this.password = BCryptPasswordEncoder().encode(value)
    }
}
