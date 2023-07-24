package com.uextest.controllers;

import com.uextest.models.Contact;
import com.uextest.models.User;
import com.uextest.repositories.ContactRepository;
import com.uextest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserContactController {

    private final UserRepository userRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public UserContactController(UserRepository userRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }

    @GetMapping("/user/{userId}/contacts")
    public List<Contact> getUserContacts(@PathVariable String userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            return contactRepository.findByUsers(user);
        } else {
            return List.of();
        }
    }
}
