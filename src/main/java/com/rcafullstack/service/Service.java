package com.rcafullstack.service;

import javax.transaction.Transactional;
import java.util.List;

public interface Service<T> {
    T create(T t);
    void delete(T t);
    T update(T t);
    List<T> getAll();
    T get(long id);
}