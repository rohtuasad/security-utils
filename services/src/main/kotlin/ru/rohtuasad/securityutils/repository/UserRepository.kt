package ru.rohtuasad.securityutils.repository

import org.springframework.data.repository.CrudRepository
import ru.rohtuasad.securityutils.model.User

interface UserRepository : CrudRepository<User, Long>
