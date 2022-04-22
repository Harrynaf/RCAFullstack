package com.rcafullstack.service;


import com.rcafullstack.enums.PropertyType;
import com.rcafullstack.enums.RepairStatus;
import com.rcafullstack.enums.RepairType;
import com.rcafullstack.enums.User_Type;
import com.rcafullstack.model.Property;
import com.rcafullstack.model.Repair;
import com.rcafullstack.model.User;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@Slf4j
public class DataPop{

    @Inject
    private UserService userService;
    @Inject
    private RepairService repairService;
    @Inject
    private PropertyService propertyService;

    public void run() {
    createData(userService, propertyService, repairService);}

    public static void createData(UserService userService, PropertyService propertyService, RepairService repairService) {

        User owner1 = new User("123456789", "John", "Psathas", "Athens", "6991234567", "john@mail.com", "john", "11111", User_Type.OWNER);
        User owner2 = new User("123412789", "Harry", "Naf", "Athens", "6991234234", "harry@mail.com", "harry", "11111", User_Type.OWNER);
        User owner3 = new User("123457459", "Aggelos", "Koutsou", "Athens", "6935523423", "aggelos@mail.com", "aggelos", "11111", User_Type.OWNER);

        log.info("This is a sample log!");
        log.info("This is a sample log input date {}", LocalDate.now());

        try {
            userService.create(owner1);
            userService.create(owner2);
            userService.create(owner3);
            log.info("All good with creating owner data");
        } catch (EntityExistsException e) {
            log.error("Something went wrong. Details: {}", e.getMessage());
        }

        Property property1 = new Property("E9_1", "Athens", Date.from(Instant.parse("2022-02-01T13:35:00.00Z")), PropertyType.APARTMENT_BUILDING, userService.get(1L));
        Property property2 = new Property("E9_2", "Athens", Date.from(Instant.parse("2001-02-01T13:35:00.00Z")), PropertyType.MAISONETTE, userService.get(2L));
        Property property3 = new Property("E9_3", "Athens", Date.from(Instant.parse("2002-02-01T13:35:00.00Z")), PropertyType.DETACHED_HOUSE, userService.get(2L));
        Property property4 = new Property("E9_4", "Athens", Date.from(Instant.parse("2003-02-01T13:35:00.00Z")), PropertyType.APARTMENT_BUILDING, userService.get(3L));

        try {
            propertyService.create(property1);
            propertyService.create(property2);
            propertyService.create(property3);
            propertyService.create(property4);
            log.info("All good with creating property data");
        } catch (EntityExistsException e) {
            log.error("Something went wrong. Details: {}", e.getMessage());
        }

        Repair repair1 = new Repair(propertyService.get(1L), Date.from(Instant.parse("2022-02-01T13:35:00.00Z")), "repairDescription1", RepairType.PAINTING, RepairStatus.IN_PROGRESS, new BigDecimal("200.0"), "workToDoDescription1");
        Repair repair2 = new Repair(propertyService.get(2L), Date.from(Instant.parse("2022-02-01T13:35:00.00Z")), "repairDescription2", RepairType.FRAMES, RepairStatus.COMPLETE, new BigDecimal("100.0"), "workToDoDescription2");
        Repair repair3 = new Repair(propertyService.get(3L), Date.from(Instant.parse("2022-02-01T13:35:00.00Z")), "repairDescription3", RepairType.INSULATION, RepairStatus.PENDING, new BigDecimal("300.0"), "workToDoDescription3");
        Repair repair4 = new Repair(propertyService.get(4L), Date.from(Instant.parse("2022-02-01T13:35:00.00Z")), "repairDescription4", RepairType.PLUMPING, RepairStatus.PENDING, new BigDecimal("350.0"), "workToDoDescription4");
        Repair repair5 = new Repair(propertyService.get(1L), Date.from(Instant.parse("2022-02-01T13:35:00.00Z")), "repairDescription5", RepairType.PAINTING, RepairStatus.PENDING, new BigDecimal("450.0"), "workToDoDescription5");
        Repair repair6 = new Repair(propertyService.get(2L), Date.from(Instant.parse("2022-02-01T13:35:00.00Z")), "repairDescription6", RepairType.ELECTRICAL_WORK, RepairStatus.PENDING, new BigDecimal("365.0"), "workToDoDescription6");
        Repair repair7 = new Repair(propertyService.get(3L), Date.from(Instant.parse("2022-02-01T13:35:00.00Z")), "repairDescription7", RepairType.PLUMPING, RepairStatus.PENDING, new BigDecimal("700.0"), "workToDoDescription7");
        Repair repair8 = new Repair(propertyService.get(4L), Date.from(Instant.parse("2022-02-01T13:35:00.00Z")), "repairDescription8", RepairType.PLUMPING, RepairStatus.PENDING, new BigDecimal("130.0"), "workToDoDescription8");

        try {
            repairService.create(repair1);
            repairService.create(repair2);
            repairService.create(repair3);
            repairService.create(repair4);
            repairService.create(repair5);
            repairService.create(repair6);
            repairService.create(repair7);
            repairService.create(repair8);
            log.info("All good with creating repair data");
        } catch (EntityExistsException e) {
            log.error("Something went wrong. Details: {}", e.getMessage());
        }
    }
}