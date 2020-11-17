package com.lambdaschool.bwafricanmarket.services;

import com.lambdaschool.bwafricanmarket.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findUserById(long id);
    User findByName(String name);
    void delete(long id);
    User save(User user);
    User update(User user, long id);
}
