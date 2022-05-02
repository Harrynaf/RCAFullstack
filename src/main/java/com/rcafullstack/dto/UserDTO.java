/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rcafullstack.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rcafullstack.enums.User_Type;

import java.io.Serializable;
import java.util.List;

/**
 * @author hnafp
 */

public class UserDTO implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String vat;
    private String name;
    private String surname;
    private String address;
    private String phone_number;
    private String email;
    private User_Type user_Type;

    @JsonManagedReference(value="userRef")
    private List<PropertyDTO> properties;

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User_Type getUser_Type() {
        return user_Type;
    }

    public void setUser_Type(User_Type user_Type) {
        this.user_Type = user_Type;
    }

    public List<PropertyDTO> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyDTO> properties) {
        this.properties = properties;
    }

    public UserDTO(String vat, String name, String surname, String address, String phone_number, String email, String username, String password, User_Type user_Type) {
        this.username = username;
        this.password = password;
        this.vat = vat;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.user_Type = user_Type;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", vat='" + vat + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", user_Type=" + user_Type +
                ", properties=" + properties +
                '}';
    }
}