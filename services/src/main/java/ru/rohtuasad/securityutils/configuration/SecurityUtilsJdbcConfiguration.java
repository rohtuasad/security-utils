package ru.rohtuasad.securityutils.configuration;

import java.util.UUID;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import ru.rohtuasad.securityutils.user.model.User;

@Configuration
@EnableJdbcRepositories(basePackages = {"ru.rohtuasad.securityutils"})
public class SecurityUtilsJdbcConfiguration {
  @Bean
  public ApplicationListener<BeforeSaveEvent<?>> securityUtilsIdGenerator() {
    return event -> {
      var entity = event.getEntity();
      if (entity instanceof User) {
        ((User) entity).setId(UUID.randomUUID());
      }
    };
  }
}
