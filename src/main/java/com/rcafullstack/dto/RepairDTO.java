/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rcafullstack.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rcafullstack.enums.RepairStatus;
import com.rcafullstack.enums.RepairType;
import com.rcafullstack.model.User;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Agkoutsou
 */
public class RepairDTO implements Serializable {


    private Long id;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date date;
    @NotNull
    private String description;
    @NotNull
    private RepairType type;
    @NotNull
    private RepairStatus status = RepairStatus.STANDBY_MODE;
    @NotNull
    private BigDecimal cost;
    @NotNull
    private String toDoDesc;
    @NotNull
    private PropertyDTO property;

    /**
     * NoArgs Constructor
     */
    public RepairDTO() {}

    /**
     * Constructor without id
     *
     * @param date
     * @param description
     * @param type
     * @param status
     * @param cost
     * @param toDoDesc
     */
    public RepairDTO(Date date, String description, RepairType type, RepairStatus status, BigDecimal cost, String toDoDesc, PropertyDTO property) {
        this.date = date;
        this.description = description;
        this.type = type;
        this.status = status;
        this.cost = cost;
        this.toDoDesc = toDoDesc;
        this.property = property;
    }

    public RepairDTO(Long id, Date date, String description, RepairType type, RepairStatus status, BigDecimal cost, String toDoDesc, PropertyDTO property) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.type = type;
        this.status = status;
        this.cost = cost;
        this.toDoDesc = toDoDesc;
        this.property = property;
    }

    public Long getId() {
        return id;
    }

    public PropertyDTO getProperty() {
        return property;
    }

    public void setProperty(PropertyDTO property) {
        this.property = property;
    }

    public void setId(Long repairId) {
        this.id = repairId;
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
        return "RepairDTO{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", cost=" + cost +
                ", toDoDesc='" + toDoDesc + '\'' +
                ", property=" + property +
                '}';
    }
}