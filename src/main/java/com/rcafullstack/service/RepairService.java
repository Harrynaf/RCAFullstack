/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rcafullstack.service;


import com.rcafullstack.model.Repair;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Agkoutsou
 */
public interface RepairService extends Service<Repair> {
    List<Repair> getRepairByDate(LocalDateTime date);
    List<Repair> getRepairByDateRange(LocalDateTime dateFrom, LocalDateTime dateTo);
    List<Repair> getRepairByOwnerId(long id);
    List<Repair> getRepairByPropertyId(long id);
}