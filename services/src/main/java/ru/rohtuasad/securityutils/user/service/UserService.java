package ru.rohtuasad.securityutils.user.service;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rohtuasad.securityutils.user.model.User;
import ru.rohtuasad.securityutils.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public User getUserProfile(UUID id) {
    final Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
      return user.get();
    }
    throw new RuntimeException("Не удалось найти пользователя с uuid = " + id);
  }

  public Iterable<User> getUserProfile() {
    return userRepository.findAll();
  }

  public User registerUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }
}
