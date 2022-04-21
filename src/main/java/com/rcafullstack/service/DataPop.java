package com.rcafullstack.service;


import com.rcafullstack.enums.PropertyType;
import com.rcafullstack.enums.RepairStatus;
import com.rcafullstack.enums.RepairType;
import com.rcafullstack.enums.User_Type;
import com.rcafullstack.model.Property;
import com.rcafullstack.model.Repair;
import com.rcafullstack.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataPop{

    @Inject
    private UserService userService;
    @Inject
    private RepairService repairService;
    @Inject
    private PropertyService propertyService;
    private static final Logger logger = LoggerFactory.getLogger(DataPop.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    public void run() {
    createData(userService, propertyService, repairService);}

    public static void createData(UserService userService, PropertyService propertyService, RepairService repairService) {

        User owner1 = new User("123456789", "John", "Psathas", "Athens", "6991234567", "john@mail.com", "john", "11111", User_Type.OWNER);
        User owner2 = new User("123412789", "Harry", "Naf", "Athens", "6991234234", "harry@mail.com", "harry", "11111", User_Type.OWNER);
        User owner3 = new User("123457459", "Aggelos", "Koutsou", "Athens", "6935523423", "aggelos@mail.com", "aggelos", "11111", User_Type.OWNER);

        logger.info("This is a sample log!");
        logger.info("This is a sample log input date {}", LocalDate.now());

        try {
            userService.create(owner1);
            userService.create(owner2);
            userService.create(owner3);
            logger.info("All good with creating owner data");
        } catch (EntityExistsException e) {
            logger.error("Something went wrong. Details: {}", e.getMessage());
        }

        Property property1 = new Property("E9_1", "Athens", LocalDate.of(2021, 1, 1), PropertyType.APARTMENT_BUILDING, userService.get(1L));
        Property property2 = new Property("E9_2", "Athens", LocalDate.of(1987, 1, 1), PropertyType.MAISONETTE, userService.get(2L));
        Property property3 = new Property("E9_3", "Athens", LocalDate.of(2005, 1, 1), PropertyType.DETACHED_HOUSE, userService.get(2L));
        Property property4 = new Property("E9_4", "Athens", LocalDate.of(2001, 1, 1), PropertyType.APARTMENT_BUILDING, userService.get(3L));

        try {
            propertyService.create(property1);
            propertyService.create(property2);
            propertyService.create(property3);
            propertyService.create(property4);
            logger.info("All good with creating property data");
        } catch (EntityExistsException e) {
            logger.error("Something went wrong. Details: {}", e.getMessage());
        }

        Repair repair1 = new Repair(propertyService.get(1L), LocalDateTime.parse("2022-02-01 15:30", formatter), "repairDescription1", RepairType.PAINTING, RepairStatus.IN_PROGRESS, new BigDecimal("200.0"), "workToDoDescription1");
        Repair repair2 = new Repair(propertyService.get(2L), LocalDateTime.parse("2022-02-15 10:30", formatter), "repairDescription2", RepairType.FRAMES, RepairStatus.COMPLETE, new BigDecimal("100.0"), "workToDoDescription2");
        Repair repair3 = new Repair(propertyService.get(3L), LocalDateTime.parse("2022-03-20 10:30", formatter), "repairDescription3", RepairType.INSULATION, RepairStatus.PENDING, new BigDecimal("300.0"), "workToDoDescription3");
        Repair repair4 = new Repair(propertyService.get(4L), LocalDateTime.parse("2022-03-20 10:30", formatter), "repairDescription4", RepairType.PLUMPING, RepairStatus.PENDING, new BigDecimal("350.0"), "workToDoDescription4");
        Repair repair5 = new Repair(propertyService.get(1L), LocalDateTime.parse("2022-03-20 10:30", formatter), "repairDescription5", RepairType.PAINTING, RepairStatus.PENDING, new BigDecimal("450.0"), "workToDoDescription5");
        Repair repair6 = new Repair(propertyService.get(2L), LocalDateTime.parse("2022-03-20 10:30", formatter), "repairDescription6", RepairType.ELECTRICAL_WORK, RepairStatus.PENDING, new BigDecimal("365.0"), "workToDoDescription6");
        Repair repair7 = new Repair(propertyService.get(3L), LocalDateTime.parse("2022-03-20 10:30", formatter), "repairDescription7", RepairType.PLUMPING, RepairStatus.PENDING, new BigDecimal("700.0"), "workToDoDescription7");
        Repair repair8 = new Repair(propertyService.get(4L), LocalDateTime.parse("2022-03-20 10:30", formatter), "repairDescription8", RepairType.PLUMPING, RepairStatus.PENDING, new BigDecimal("130.0"), "workToDoDescription8");

        try {
            repairService.create(repair1);
            repairService.create(repair2);
            repairService.create(repair3);
            repairService.create(repair4);
            repairService.create(repair5);
            repairService.create(repair6);
            repairService.create(repair7);
            repairService.create(repair8);
            logger.info("All good with creating repair data");
        } catch (EntityExistsException e) {
            logger.error("Something went wrong. Details: {}", e.getMessage());
        }
    }
}