package com.uextest.controllers;
import com.uextest.models.Contact;
import com.uextest.repositories.ContactRepository;
import com.uextest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        List<Contact> contactsList = repository.findAll();
        return ResponseEntity.ok(contactsList);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Contact>> getContactsByUserId(@PathVariable Long userId) {
        var user = userRepository.findByUserId(userId);
        var contacts = repository.findByUsers(user);
        return ResponseEntity.ok(contacts);
    }
}
