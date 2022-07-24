package com.akbar.user.service;

import com.akbar.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String saveOrUpdate(User user);
    List<User> findAll();
    Optional<User> findByUserId(Long userId);
    Optional<User> findByEmail(String email);
    String deleteById(Long userId);
}
