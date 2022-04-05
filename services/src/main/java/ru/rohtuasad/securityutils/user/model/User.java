package ru.rohtuasad.securityutils.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;
import java.util.UUID;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@RequiredArgsConstructor
@Data
@Table("SECURITY_UTILS\".\"USER")
public class User implements UserDetails {
  @Id
  @JsonProperty("user-id")
  @Column("USER_ID")
  private UUID id;
  private final String name;
  private final String login;
  private String password;
  private final String email;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getUsername() {
    return login;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
