package ru.rohtuasad.securityutils.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User() {
    constructor(name: String, login: String, email: String) : this() {
        this.name = name
        this.email = email
        this.login = login
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private var id: Long = 0

    @JsonProperty("name")
    private lateinit var name: String
    @JsonProperty("login")
    private lateinit var login: String
    @JsonProperty("email")
    private lateinit var email: String
}
