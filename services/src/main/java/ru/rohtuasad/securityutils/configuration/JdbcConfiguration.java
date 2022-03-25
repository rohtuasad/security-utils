package ru.rohtuasad.securityutils.configuration;

import java.util.UUID;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.NamingStrategy;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import ru.rohtuasad.securityutils.user.model.User;

@Configuration
public class JdbcConfiguration {

  @Bean
  public NamingStrategy namingStrategy() {
    return new NamingStrategy() {
      @Override
      public String getSchema() {
        return "security_utils";
      }
    };
  }

  @Bean
  public ApplicationListener<BeforeSaveEvent> idGenerator() {
    return event -> {
      var entity = event.getEntity();
      if (entity instanceof User) {
        ((User) entity).setId(UUID.randomUUID());
      }
    };
  }
}
