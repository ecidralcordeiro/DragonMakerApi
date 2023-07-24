package com.uextest.repositories;

import com.uextest.models.Contact;
import com.uextest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, String> {

    List<Contact> findByUsers(User user);
    Contact findById(long id);
    List<Contact> findAllByOrderByName();
    List<Contact> findByNameContainingIgnoreCaseOrCpfContainingIgnoreCase(String name, String cpf);

    @Modifying
    @Query("DELETE FROM Contact c WHERE c.id = ?1")
    void deleteById(Long id);


}
