package com.smartcontactmanager.smartcontactmanager.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotEmpty(message = "name can't be empty")
    @NotNull(message = "name can't be null")
    private String name;
    @Column(unique = true)
    @NotNull(message = "email can't be null")
    @NotEmpty(message = "email can't be empty")
    private String email;
    @NotEmpty(message = "passowrd can't be empty")
    @NotNull(message = "password can't be null")
    private String password;
    private Boolean active = true;
    private String role;
    private String imageUrlString;
    @Column(length = 500)
    private String about;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Contact>contacts = new ArrayList<>();
    public User() {
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getImageUrlString() {
        return imageUrlString;
    }
    public void setImageUrlString(String imageUrlString) {
        this.imageUrlString = imageUrlString;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    public List<Contact> getContacts() {
        return contacts;
    }
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", active="
                + active + ", role=" + role + ", imageUrlString=" + imageUrlString + ", about=" + about + ", contacts="
                + contacts + "]";
    }

    
}
