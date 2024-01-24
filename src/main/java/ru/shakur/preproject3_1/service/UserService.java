package ru.shakur.preproject3_1.service;

import ru.shakur.preproject3_1.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void delete(Long id);

    void update(User user);

    User findById(Long id);

    List<User> listUsers();
}
