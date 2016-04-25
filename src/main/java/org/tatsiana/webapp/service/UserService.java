package org.tatsiana.webapp.service;

import org.tatsiana.webapp.entity.User;

import java.util.List;

public interface UserService {

    void createUserAccount(String login, String password);

    List<User> getAllUsers();

    User getById(long id);

    void saveUser(User user);

}
