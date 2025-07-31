package com.mic.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mic.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    
}
