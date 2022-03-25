package ru.rohtuasad.securityutils.configuration;

import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.NamingStrategy;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import ru.rohtuasad.securityutils.user.model.User;

@Configuration("SecurityUtilsJdbcConfiguration")
public class JdbcConfiguration {

  @Bean(name = "securityUtilsNamingStrategy")
  public NamingStrategy namingStrategy() {
    return new NamingStrategy() {
      @Override
      public String getSchema() {
        return "security_utils";
      }
    };
  }

  @Bean
  public ApplicationListener<BeforeSaveEvent<?>> idGenerator() {
    return event -> {
      var entity = event.getEntity();
      if (entity instanceof User) {
        ((User) entity).setId(UUID.randomUUID());
      }
    };
  }

  @Bean("SecurityUtilsDatasource")
  public DataSource dataSource() {
    final DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.h2.Driver");
    dataSourceBuilder.url("jdbc:h2:mem:test");
    dataSourceBuilder.username("SA");
    dataSourceBuilder.password("password");
    return dataSourceBuilder.build();
  }
}
