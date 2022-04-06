package ru.rohtuasad.securityutils.user.controller;

import java.util.UUID;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rohtuasad.securityutils.user.model.User;
import ru.rohtuasad.securityutils.user.service.UserServiceImpl;

@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "${security-utils.web.cors:http://localhost:3000}")
public class UserController {

  private final UserServiceImpl userService;

  @GetMapping("/user/{id}")
  public ResponseEntity<User> getUserProfile(@PathVariable UUID id) {
    return ResponseEntity.ok(userService.getUserProfile(id));
  }

  @GetMapping("/user")
  public ResponseEntity<Iterable<User>> getUserProfile() {
    return ResponseEntity.ok(userService.getUserProfile());
  }

  @PostMapping("/user/registration")
  public ResponseEntity<String> registerUser(@RequestBody @Valid User accountDto)
      throws UserAlreadyExistException {
    log.debug("Registering user account with information: {}", accountDto);
    userService.registerUser(accountDto);
    return ResponseEntity.ok("success");
  }
}
