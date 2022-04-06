package ru.rohtuasad.securityutils.user.controller;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rohtuasad.securityutils.user.model.User;
import ru.rohtuasad.securityutils.user.service.UserService;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "${security-utils.web.cors:http://localhost:3000}")
public class UserController {

  private final UserService userService;

  @GetMapping("/user/{id}")
  public ResponseEntity<User> getUserProfile(@PathVariable UUID id) {
    return ResponseEntity.ok(userService.getUserProfile(id));
  }

  @GetMapping("/user")
  public ResponseEntity<Iterable<User>> getUserProfile() {
    return ResponseEntity.ok(userService.getUserProfile());
  }

  @PostMapping("/user")
  public ResponseEntity<User> registerUser(@RequestBody User user) {
    return ResponseEntity.ok(userService.registerUser(user));
  }
}
