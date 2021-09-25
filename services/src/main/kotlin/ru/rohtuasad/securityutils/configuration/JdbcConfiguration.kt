package ru.rohtuasad.securityutils.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.relational.core.mapping.NamingStrategy

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
}
