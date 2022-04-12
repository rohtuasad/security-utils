package ru.rohtuasad.securityutils.user.service;

import org.springframework.stereotype.Service;
import ru.rohtuasad.securityutils.user.controller.UserAlreadyExistException;
import ru.rohtuasad.securityutils.user.model.User;

@Service
public interface UserService {
  User registerUser(User userDto) throws UserAlreadyExistException;
}
