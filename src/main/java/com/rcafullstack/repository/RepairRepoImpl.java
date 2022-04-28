/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rcafullstack.repository;

import com.rcafullstack.model.Repair;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementation of RepairRepo
 *
 * @author Agkoutsou
 */
public class RepairRepoImpl extends RepositoryImpl<Repair> implements RepairRepo {
    private static final String CLASSNAME = "Repair";
    @PersistenceContext(unitName="Persistence")
    private EntityManager entityManager;

    /**
     * Returns a list of repairs with given date
     *
     * @param  date as LocalDateTime
     * @return List of repairs
     */
    @Override
    public List<Repair> getRepairByDate(LocalDateTime date) {
        return entityManager.createQuery("SELECT r FROM Repair r WHERE r.date = :date", Repair.class)
                            .setParameter("date", date)
                            .getResultList();
    }

    /**
     * Returns a list of repairs within a date range
     *
     * @param dateFrom & dateTo as LocalDateTime
     * @return List of repairs
     */
    @Override
    public List<Repair> getRepairByDateRange(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return entityManager.createQuery("SELECT r FROM Repair r WHERE r.date >= :dateFrom and r.date <= :dateTo", Repair.class)
                            .setParameter("dateFrom", dateFrom)
                            .setParameter("dateTo", dateTo)
                            .getResultList();
    }

    /**
     * Returns a list of repairs with given owner id
     *
     * @param  id as long
     * @return List of repairs
     */
    @Override
    public List<Repair> getRepairByOwnerId(long id) {
        return entityManager.createQuery("SELECT r FROM Repair r WHERE r.property.owner.id = :id", Repair.class)
                            .setParameter("id", id)
                            .getResultList();
    }

    /**
     * Returns a list of repairs with given property id
     *
     * @param id as long
     * @return List of repairs
     */
    @Override
    public List<Repair> getRepairByPropertyId(long id) {
        return entityManager.createQuery("SELECT r FROM Repair r WHERE r.property.id = :id", Repair.class)
                            .setParameter("id", id)
                            .getResultList();
    }

    @Override
    public Class<Repair> getClassType() {
        return Repair.class;
    }
    @Override
    public String getClassName() {
        return CLASSNAME;
    }
}