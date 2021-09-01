package ru.rohtuasad.securityutils.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.NamingStrategy;

@Configuration
public class JdbcConfiguration {
  @Bean
  NamingStrategy namingStrategy() {
    return new NamingStrategy() {
      @Override
      public String getSchema() {
        return "security_utils";
      }
    };
  }
}
