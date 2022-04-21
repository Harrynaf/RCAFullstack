package com.rcafullstack.service;

import com.rcafullstack.model.User;
import com.rcafullstack.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

public class UserServiceImpl implements UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Inject
    private UserRepo userRepo;


    @Override
    public User create(User user) throws EntityExistsException{
        if (!findByUsername(user)) {
            userRepo.save(user);
            return user;
        } else {
            logger.error("Something went wrong. EntityExistsException");
            throw new EntityExistsException();
        }
    }

    @Override
    public void delete(User user) throws EntityNotFoundException{
        if (get(user.getId())!=null) {
            userRepo.delete(user);
        } else {
            logger.error("Something went wrong. EntityNotFoundException");
            throw new EntityNotFoundException();
        }
    }

    @Override
    public User update(User user) throws EntityNotFoundException{
        if (get(user.getId())!=null) {
            userRepo.save(user);
            return user;
        } else {
            logger.error("Something went wrong. EntityNotFoundException");
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<User> getAll() {
        return userRepo.getAll();
    }

    @Override

    public User get(long id) {
        return userRepo.get(id);
    }

    @Override
    public boolean findByUsername(User user) {
        return userRepo.findByUsername(user);
    }

    @Override
    public User getByVat(String vat) {
        return userRepo.getByVat(vat);
    }

    @Override
    public User getByEmail(String email) {
        return userRepo.getByEmail(email);
    }
}