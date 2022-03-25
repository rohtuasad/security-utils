package ru.rohtuasad.securityutils.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.rohtuasad.securityutils.user.model.User;
import ru.rohtuasad.securityutils.user.service.UserService;

@Component
@RequiredArgsConstructor
class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private final UserService userService;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent refreshedEvent) {
    User user = new User("Name", "login", "user@user.com");
    user.setPassword("password");
    userService.registerUser(user);
  }
}
