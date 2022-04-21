package com.rcafullstack.repository;


import com.rcafullstack.model.User;

public interface UserRepo extends Repository<User> {
    User getByVat(String s);
    User getByEmail(String s);
    boolean findByUsername(User user);
}