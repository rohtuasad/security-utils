package ru.rohtuasad.securityutils.user.service;

import ru.rohtuasad.securityutils.user.controller.UserAlreadyExistException;
import ru.rohtuasad.securityutils.user.model.User;

public interface UserService {
  User registerUser(User userDto) throws UserAlreadyExistException;
}
