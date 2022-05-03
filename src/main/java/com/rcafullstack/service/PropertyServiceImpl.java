/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rcafullstack.service;

import com.rcafullstack.model.Property;
import com.rcafullstack.repository.PropertyRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * An implementation of PropertyService
 *
 * @author Ioannis Psathas
 */
public class PropertyServiceImpl implements PropertyService {
    
    private static final Logger logger = LoggerFactory.getLogger(PropertyServiceImpl.class);
    @Inject
    private PropertyRepo propertyRepo;

    /**
     * Check if ECode of property exist in repo and if it does throws
     * EntityExistsException else save property
     *
     * @param property
     * @return property
     */
    @Override
    public Property create(Property property) {
        if (!foundByECode(property)) {
            propertyRepo.save(property);
            return property;
        } else {
            logger.error("Something went wrong. EntityExistsException");
            throw new EntityExistsException();
        }
    }

    /**
     * Check if property exist in repo and if it does throws
     * EntityNotFoundException else delete property
     *
     * @param property
     */
    @Override
    public void delete(Property property) {
        if (get(property.getId()) != null) {
            propertyRepo. delete(property);
        } else {
            logger.error("Something went wrong. EntityNotFoundException");
            throw new EntityNotFoundException();
        }
    }

    /**
     * Check if id of property exist in repo and if it does not throws
     * EntityNotFoundException else update property
     *
     * @param property
     * @return property
     */
    @Override
    public Property update(Property property) {
        if (get(property.getId()) != null) {
            propertyRepo.save(property);
            return property;
        } else {
            logger.error("Something went wrong. EntityNotFoundException");
            throw new EntityNotFoundException();
        }
    }

    /**
     * Returns a property with given id
     *
     * @param id as long
     * @return property
     */
    @Override
    public Property get(long id) {
        return propertyRepo.get(id);
    }

    /**
     * Retuns a list with all properties
     *
     * @return List of propeties
     */
    @Override
    public List<Property> getAll() {
        return propertyRepo.getAll();
    }

    /**
     * Returns a list of properties with given vat
     *
     * @param vat number as String
     * @return List of properties
     */
    @Override
    public List<Property> getByVat(String vat) {
        return propertyRepo.getByVat(vat);
    }

    /**
     * Check if ECode of property exist in repo and returns boolean
     *
     * @param property
     * @return boolean
     */
    @Override
    public boolean foundByECode(Property property) {
        return !propertyRepo.getByECode(property.geteCode()).isEmpty();
    }

    @Override
    public List<Property> getByUser(long id) {
        return propertyRepo.getByUser(id);
    }
}