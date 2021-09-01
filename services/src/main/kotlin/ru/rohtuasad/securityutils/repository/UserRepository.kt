package ru.rohtuasad.securityutils.repository

import org.springframework.data.repository.CrudRepository
import ru.rohtuasad.securityutils.model.User
import java.util.*

interface UserRepository : CrudRepository<User, UUID>
