package com.uextest.controllers;

import com.uextest.models.Contact;
import com.uextest.repositories.ContactRepository;
import com.uextest.repositories.UserRepository;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("contact")
public class ContactController {

    @Autowired
    ContactRepository repository;

    @Autowired
    UserRepository userRepository;



    @PostMapping
    public ResponseEntity<Void> postContact(@RequestBody @Valid Contact body) {
        repository.save(body);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contactsList = repository.findAllByOrderByName();

        return ResponseEntity.ok(contactsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Contact contact = repository.findById(id);
        if (contact == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contact);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<Contact>> getContactsByFilter(@RequestParam(required = false) String search) {
        List<Contact> filteredContacts;

        if (search != null && !search.isEmpty()) {
            // Filtrar por nome OU CPF
            filteredContacts = repository.findByNameContainingIgnoreCaseOrCpfContainingIgnoreCase(search, search);
        } else {
            // Se nenhum parâmetro foi fornecido, retornar todos os contatos
            List<Contact> allContacts = repository.findAll();
            return ResponseEntity.ok(allContacts);
        }

        return ResponseEntity.ok(filteredContacts);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Contact>> getContactsByUserId(@PathVariable Long userId) {
        var user = userRepository.findByUserId(userId);
        var contacts = repository.findByUsers(user);
        return ResponseEntity.ok(contacts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateContact(@PathVariable Long id, @RequestBody @Valid Contact updatedContact) {
        Contact existingContact = repository.findById(id);
        if (existingContact == null) {
            return ResponseEntity.notFound().build();
        }
        existingContact.setName(updatedContact.getName());
        existingContact.setCpf(updatedContact.getCpf());
        existingContact.setPhone(updatedContact.getPhone());
        existingContact.setAddress(updatedContact.getAddress());

        repository.save(existingContact);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        if (repository.existsById(String.valueOf(id))) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
