package ru.rohtuasad.securityutils.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.*

class User() : Persistable<UUID> {
    fun setEncodedPassword(value: String) {
        this.password = BCryptPasswordEncoder().encode(value)
    }

    constructor(name: String, login: String, email: String) : this(null, name, login, email)

    constructor(userId: UUID?, name: String, login: String, email: String) : this() {
        this.userId = userId
        this.name = name
        this.email = email
        this.login = login
    }

    @Id
    @JsonProperty("user-id")
    private var userId: UUID? = UUID.randomUUID()

    @JsonProperty("name")
    lateinit var name: String

    @JsonProperty("login")
    private lateinit var login: String

    @JsonProperty("email")
    private lateinit var email: String

    @JsonProperty("password")
    lateinit var password: String

    override fun getId(): UUID? {
        return UUID.randomUUID()
    }

    override fun isNew(): Boolean {
        return this.userId == null
    }
}
