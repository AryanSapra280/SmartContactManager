package com.smartcontactmanager.smartcontactmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartcontactmanager.smartcontactmanager.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("select u from User u where u.email = :email")
    public User getUserByEmail(@Param("email") String email);
}
