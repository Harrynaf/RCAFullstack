/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rcafullstack.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rcafullstack.enums.PropertyType;

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

    private String eCode;

    private String address;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date constructionYear;

    private PropertyType type;

    @JsonBackReference
    private UserDTO owner;

    @JsonManagedReference
    private List<RepairDTO> repairDTOS;

    public PropertyDTO() {
    }

    /**
     * Constructor without id
     *
     * @param eCode
     * @param address
     * @param constructionYear
     * @param type
     * @param owner
     */
    public PropertyDTO(String eCode, String address, Date constructionYear, PropertyType type, UserDTO owner) {
        this.eCode = eCode;
        this.address = address;
        this.constructionYear = constructionYear;
        this.type = type;
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

    public UserDTO getOwner() {
        return owner;
    }

    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }

    public List<RepairDTO> getRepairs() {
        return repairDTOS;
    }

    public void setRepairs(List<RepairDTO> repairDTOS) {
        this.repairDTOS = repairDTOS;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.eCode);
        hash = 43 * hash + Objects.hashCode(this.address);
        hash = 43 * hash + Objects.hashCode(this.constructionYear);
        hash = 43 * hash + Objects.hashCode(this.type);
        hash = 43 * hash + Objects.hashCode(this.owner);
        hash = 43 * hash + Objects.hashCode(this.repairDTOS);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PropertyDTO other = (PropertyDTO) obj;
        if (!Objects.equals(this.eCode, other.eCode)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.constructionYear, other.constructionYear)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        return Objects.equals(this.repairDTOS, other.repairDTOS);
    }

    @Override
    public String toString() {
        return "Property{" + "id=" + id + 
                ", eCode=" + eCode + 
                ", address=" + address + 
                ", constructionYear=" + constructionYear + 
                ", type=" + type + 
                ", ownerId=" + owner.getId() + 
                ", repairs=" + repairDTOS + '}';
    }
}