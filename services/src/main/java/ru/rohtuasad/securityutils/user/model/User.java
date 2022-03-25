package ru.rohtuasad.securityutils.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@RequiredArgsConstructor
@Data
public class User {
  @Id
  @JsonProperty("user-id")
  @Column("USER_ID")
  private UUID id;
  private final String name;
  private final String login;
  private String password;
  private final String email;
}
