package com.smartcontactmanager.smartcontactmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartcontactmanager.smartcontactmanager.entities.Contact;
import com.smartcontactmanager.smartcontactmanager.entities.User;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long>{
    
}
