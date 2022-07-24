package com.akbar.user.service;

import com.akbar.user.entity.User;
import com.akbar.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String saveOrUpdate(User user) {
        User saveUser = userRepository.save(user);
        return saveUser != null ? "success" : "error";
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUserId(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String deleteById(Long userId) {
        userRepository.deleteById(userId);
        return "success";
    }
}
