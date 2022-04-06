package ru.rohtuasad.securityutils.user.controller;

public class UserAlreadyExistException extends Exception {
  public UserAlreadyExistException(String s) {
    super(s);
  }
}
