package com.rcafullstack.repository;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

@Slf4j
public abstract class RepositoryImpl<T> implements Repository<T> {
    @PersistenceContext(unitName="Persistence")
    private EntityManager entityManager;

    @Resource
    private UserTransaction transaction;

    @Override
    public void save(T t) {
        try{
        transaction.begin();
        entityManager.persist(entityManager.contains(t) ? t : entityManager.merge(t));
        transaction.commit();}
        catch (Exception e)
        {log.error(e.getMessage());}
    }
    @Override
    public void delete(T t) {
        try{
            transaction.begin();
            entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
            transaction.commit();}
        catch (Exception e)
        {log.error(e.getMessage());}
    }
    @Override
    public T get(long id) {
        return entityManager.find( getClassType() , id);
    }
    public abstract Class<T> getClassType();

    public abstract String getClassName();

    @Override
    public List<T> getAll() {
        return entityManager.createQuery("from " + getClassName()).getResultList();
    }

}