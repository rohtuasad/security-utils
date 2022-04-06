package ru.rohtuasad.securityutils.user.service;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rohtuasad.securityutils.user.controller.UserAlreadyExistException;
import ru.rohtuasad.securityutils.user.model.User;
import ru.rohtuasad.securityutils.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

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

  @Override
  public User registerUser(User user) throws UserAlreadyExistException {
    if (emailExist(user.getEmail())) {
      throw new UserAlreadyExistException(
          "There is an account with that email address: " + user.getEmail());
    }
    if (loginExist(user.getLogin())) {
      throw new UserAlreadyExistException(
          "There is an account with that login: " + user.getLogin());
    }

    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }


  private boolean emailExist(String email) {
    return userRepository.findByEmail(email) != null;
  }

  private boolean loginExist(String login) {
    return userRepository.findByLogin(login) != null;
  }
}
