package ru.rohtuasad.securityutils.configuration

import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.relational.core.mapping.NamingStrategy
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent
import ru.rohtuasad.securityutils.user.model.User
import java.util.*


@Configuration
class JdbcConfiguration {
    @Bean
    fun namingStrategy(): NamingStrategy {
        return object : NamingStrategy {
            override fun getSchema(): String {
                return "security_utils"
            }
        }
    }

    @Bean
    fun idGenerator(): ApplicationListener<BeforeSaveEvent<*>>? {
        return ApplicationListener { event: BeforeSaveEvent<*> ->
            val entity = event.entity
            if (entity is User) {
                entity.userId = UUID.randomUUID()
            }
        }
    }
}
