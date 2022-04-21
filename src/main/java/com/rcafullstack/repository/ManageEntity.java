package com.rcafullstack.repository;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@Slf4j
public abstract class ManageEntity {
    @PersistenceContext(unitName="Persistence")
    private EntityManager entityManager;

    @Resource
    private UserTransaction transaction;

    public void saveEntity(Object t) {
        try{
        transaction.begin();
        entityManager.persist(entityManager.contains(t) ? t : entityManager.merge(t));
        transaction.commit();}
        catch (Exception e)
        {log.error(e.getMessage());}
    }

    public void deleteEntity(Object t) {
        try{
            transaction.begin();
            entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
            transaction.commit();}
        catch (Exception e)
        {log.error(e.getMessage());}
    }
}