package com.uextest.controllers;
import com.uextest.models.Contact;
import com.uextest.repositories.ContactRepository;
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

    @PostMapping
    public ResponseEntity postContact(@RequestBody @Valid Contact body) {
        this.repository.save(body);
        return ResponseEntity.status(201).build();
    }


    @GetMapping
    public ResponseEntity getAllContacts(){
        List<Contact> contactsList = this.repository.findAll().stream().toList();

        return ResponseEntity.ok(contactsList);
    }
}
