package ru.rohtuasad.securityutils.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import ru.rohtuasad.securityutils.model.User
import ru.rohtuasad.securityutils.repository.UserRepository

@Component
class DevBootstrap
@Autowired
constructor(private val userRepository: UserRepository) : ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(p0: ContextRefreshedEvent) {
        val user = User("Name", "login", "user@user.com")
        userRepository.save(user)
    }
}
