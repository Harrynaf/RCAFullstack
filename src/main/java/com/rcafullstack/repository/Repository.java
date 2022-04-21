/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rcafullstack.repository;

import java.util.List;

/**
 * @author Ioannis Psathas
 */
public interface Repository<T> {
    void save(T t);
    void delete(T t);
    List<T> getAll();
    T get(long id);
}