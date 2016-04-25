package org.tatsiana.webapp.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tatsiana.webapp.entity.Role;
import org.tatsiana.webapp.entity.User;
import org.tatsiana.webapp.repository.RoleRepository;
import org.tatsiana.webapp.repository.UserRepository;
import org.tatsiana.webapp.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private static final Logger log = Logger.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            String msg = "User with login = '" + login + "' was not found!";
            log.debug(msg);
            throw new UsernameNotFoundException(msg);
        }
        return user;
    }

    @Override
    @Transactional
    public void createUserAccount(String login, String password) {
        User user = new User();
        Role role = roleRepository.findByName(Role.ROLE_USER_CODE);
        log.debug("Saving user account with role '" + role + "'.");

        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);

        log.debug("Saving user '" + login + "' into database.");
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void saveUser(User user) {
        User old = userRepository.findOne(user.getId());
        Role role = roleRepository.findOne(user.getRole().getId());
        old.setRole(role);
        userRepository.save(old);
    }

}
