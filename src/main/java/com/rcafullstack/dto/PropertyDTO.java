/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rcafullstack.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rcafullstack.enums.PropertyType;
import com.rcafullstack.model.User;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Ioannis Psathas
 */
public class PropertyDTO implements Serializable {

    private Long id;
    @NotNull
    private String eCode;
    @NotNull
    private String address;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date constructionYear;
    @NotNull
    private PropertyType type;

    @NotNull
    private UserDTO owner;
    public PropertyDTO() {
    }

    /**
     * Constructor without id
     *
     * @param eCode
     * @param address
     * @param constructionYear
     * @param type
     */
    public PropertyDTO(String eCode, String address, Date constructionYear, PropertyType type, UserDTO owner) {
        this.eCode = eCode;
        this.address = address;
        this.constructionYear = constructionYear;
        this.type = type;
        this.owner = owner;
    }
    public UserDTO getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "PropertyDTO{" +
                "id=" + id +
                ", eCode='" + eCode + '\'' +
                ", address='" + address + '\'' +
                ", constructionYear=" + constructionYear +
                ", type=" + type +
                ", owner=" + owner +
                '}';
    }

    public PropertyDTO(Long id, String eCode, String address, Date constructionYear, PropertyType type, UserDTO owner) {
        this.id = id;
        this.eCode = eCode;
        this.address = address;
        this.constructionYear = constructionYear;
        this.type = type;
        this.owner = owner;
    }

    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Date constructionYear) {
        this.constructionYear = constructionYear;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

}