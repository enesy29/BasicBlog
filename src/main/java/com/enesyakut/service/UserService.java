package com.enesyakut.service;

import com.enesyakut.model.User;
import com.enesyakut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        User saveUser = userRepository.findByUsername(user.getUsername());
        saveUser = userRepository.save(user);
        return saveUser;
    }

    public User login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        User findByUsername = userRepository.findByUsernameAndPassword(username, password);
        return findByUsername;
    }

    public User getUser(Long id){
        return userRepository.findById(id).get();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
