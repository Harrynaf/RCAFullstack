/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rcafullstack.repository;

import com.rcafullstack.model.Property;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * An implementation of PropertyRepo
 *
 * @author Ioannis Psathas
 */
public class PropertyRepoImpl extends RepositoryImpl<Property> implements PropertyRepo {
    private static final String CLASSNAME = "Property";
    @PersistenceContext(unitName="Persistence")
    private EntityManager entityManager;

    @Override
    public Class<Property> getClassType() {
        return Property.class;
    }

    /**
     * Returns a list of properties with given vat
     * @param vat
     * @return
     */
    @Override
    public List<Property> getByVat(String vat) {
        return entityManager.createQuery("SELECT p FROM Property p WHERE p.owner.vat = :vat", Property.class).setParameter("vat", vat).getResultList();
    }

    /**
     * Returns a list of properties with given eCode
     *
     * @param eCode
     * @return List of properties
     */
    @Override
    public List<Property> getByECode(String eCode) {
        return entityManager.createQuery("SELECT p FROM Property p WHERE p.eCode = :ecode", Property.class).setParameter("ecode", eCode).getResultList();
    }

    /**
     * Retuns a list with all properties
     *
     * @return List of properties
     */
    @Override
    public String getClassName() {
        return CLASSNAME;
    }
}