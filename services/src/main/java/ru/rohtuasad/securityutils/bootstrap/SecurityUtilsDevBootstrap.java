package ru.rohtuasad.securityutils.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.rohtuasad.securityutils.user.model.User;
import ru.rohtuasad.securityutils.user.service.UserServiceImpl;

@Component
@RequiredArgsConstructor
class SecurityUtilsDevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private final UserServiceImpl userService;

  @SneakyThrows
  @Override
  public void onApplicationEvent(ContextRefreshedEvent refreshedEvent) {
    User user = new User("Name", "login", "user@user.com");
    user.setPassword("password");
    userService.registerUser(user);
  }
}
