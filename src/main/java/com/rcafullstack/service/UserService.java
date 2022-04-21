package com.rcafullstack.service;


import com.rcafullstack.model.User;

public interface UserService extends Service<User> {
    User getByVat(String s);
    User getByEmail(String s);
    boolean findByUsername(User user);
}