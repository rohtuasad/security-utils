package ru.rohtuasad.securityutils.user.repository

import org.springframework.data.repository.CrudRepository
import ru.rohtuasad.securityutils.user.model.User
import java.util.*

interface UserRepository : CrudRepository<User, UUID>
