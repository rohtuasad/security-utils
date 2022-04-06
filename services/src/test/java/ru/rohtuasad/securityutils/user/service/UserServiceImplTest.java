package ru.rohtuasad.securityutils.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.rohtuasad.securityutils.SecurityUtilsServicesConfig;
import ru.rohtuasad.securityutils.user.model.User;

@SpringBootTest(classes = {SecurityUtilsServicesConfig.class})
class UserServiceImplTest {

  @Autowired
  private UserServiceImpl userService;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Test
  public void getUserProfile() {
    User user = userService.getUserProfile().iterator().next();
    assertEquals("Name", user.getName());
    assertEquals("login", user.getLogin());
    assertEquals("user@user.com", user.getEmail());
    assertTrue(passwordEncoder.matches("password", user.getPassword()));
  }

  @Test
  public void testGetUserProfile() {
    Iterable<User> userProfileList = userService.getUserProfile();
    User userProfile = userService.getUserProfile(userProfileList.iterator().next().getId());
    assertEquals("Name", userProfile.getName());
    assertTrue(passwordEncoder.matches("password", userProfile.getPassword()));
  }

  @SneakyThrows
  @Test
  public void registerUser() {
    User user = new User("NewUser", "newlogin", "newuser@user.com");
    user.setPassword("newpassword");
    assertNull(user.getId());
    assertFalse(passwordEncoder.matches("newpassword", user.getPassword()));

    userService.registerUser(user);
    assertNotNull(user.getId());
    assertTrue(passwordEncoder.matches("newpassword", user.getPassword()));
  }
}