package com.ed.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ed.apirest.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
    
} 
