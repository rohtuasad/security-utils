package ru.rohtuasad.securityutils.configuration;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityUtilsFlywayConfiguration {

  private final DataSource securityUtilsDataSource;

  public SecurityUtilsFlywayConfiguration(DataSource securityUtilsDataSource) {
    this.securityUtilsDataSource = securityUtilsDataSource;
  }

  @Bean(initMethod = "migrate")
  public Flyway securityUtilsFlyway() {
    return Flyway.configure().dataSource(securityUtilsDataSource)
        .locations("db/security_utils_migration")
        .table("security_utils_schema_version")
        .baselineOnMigrate(true)
        .schemas("security_utils")
        .defaultSchema("security_utils")
        .load();
  }
}
