package com.smartcontactmanager.smartcontactmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Contact {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String nickName;
    @Column(unique = true)
    private String email;
    private String imageUrlString;
    private Long phone;
    @Column(length = 5000)
    private String about;

    @JsonIgnore
    @ManyToOne
    private User user;
    public Contact() {
    }

    public Long getContactId() {
        return contactId;
    }
    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImageUrlString() {
        return imageUrlString;
    }
    public void setImageUrlString(String imageUrlString) {
        this.imageUrlString = imageUrlString;
    }
    public Long getPhone() {
        return phone;
    }
    public void setPhone(Long phone) {
        this.phone = phone;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
