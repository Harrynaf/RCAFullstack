/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rcafullstack.service;


import com.rcafullstack.model.Property;

import java.util.List;

/**
 *
 * @author Ioannis Psathas
 */
public interface PropertyService extends Service<Property> {
    List<Property> getByVat(String vat);
    boolean foundByECode(Property property);
    List<Property> getByUser(long id);
}