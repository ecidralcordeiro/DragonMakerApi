package com.uextest.repositories;

import com.uextest.models.Contact;
import com.uextest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, String> {

    List<Contact> findByUsers(User user);

}
