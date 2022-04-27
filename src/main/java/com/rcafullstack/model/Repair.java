/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rcafullstack.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rcafullstack.enums.RepairStatus;
import com.rcafullstack.enums.RepairType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Agkoutsou
 */
@Entity
@Table(name = "repair")
public class Repair implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonBackReference
    private Property property;
    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date date;
    @Column(name = "repairDescription")
    private String description;
    @Column(name = "repairType")
    @Enumerated(value = EnumType.STRING)
    private RepairType type;
    @Column(name = "repairStatus")
    @Enumerated(value = EnumType.STRING)
    private RepairStatus status = RepairStatus.STANDBY_MODE;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "workToDoDescription")
    private String toDoDesc;

    /**
     * NoArgs Constructor
     */
    public Repair() {}

    /**
     * Constructor without id
     *
     * @param property
     * @param date
     * @param description
     * @param type
     * @param status
     * @param cost
     * @param toDoDesc
     */
    public Repair(Property property, Date date, String description, RepairType type, RepairStatus status, BigDecimal cost, String toDoDesc) {
        this.property = property;
        this.date = date;
        this.description = description;
        this.type = type;
        this.status = status;
        this.cost = cost;
        this.toDoDesc = toDoDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RepairType getType() {
        return type;
    }

    public void setType(RepairType type) {
        this.type = type;
    }

    public RepairStatus getStatus() {
        return status;
    }

    public void setStatus(RepairStatus status) {
        this.status = status;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getToDoDesc() {
        return toDoDesc;
    }

    public void setToDoDesc(String toDoDesc) {
        this.toDoDesc = toDoDesc;
    }

    @Override
    public String toString() {
        return "Repair{" + "repairId=" + id +
                ", ownerId=" + property.getOwner().getId() +
                ", propertyId=" + property.getId() + 
                ", date=" + date + 
                ", description=" + description + 
                ", type=" + type + 
                ", status=" + status + 
                ", cost=" + cost + 
                ", toDoDesc=" + toDoDesc + '}';
    }
}