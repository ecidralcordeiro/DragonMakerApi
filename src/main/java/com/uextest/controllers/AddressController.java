package com.uextest.controllers;
import com.uextest.models.Address;
import com.uextest.models.Contact;
import com.uextest.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("address")
public class AddressController {

    @Autowired
    AddressRepository repository;



    @PostMapping
    public ResponseEntity<Long> postContact(@RequestBody @Valid Address body) {
        Address savedAddress = repository.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress.getId());
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllContacts() {
        List<Address> contactsList = repository.findAll();
        return ResponseEntity.ok(contactsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getContactById(@PathVariable Long id) {
        Address address = repository.findById(id);
        if (address ==null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(address);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAddress(@PathVariable Long id, @RequestBody @Valid Address updatedAddress) {
        Address existingAdrress = repository.findById (id);
        if (existingAdrress == null) {
            return ResponseEntity.notFound().build();
        }
        existingAdrress.setCity(updatedAddress.getCity());
        existingAdrress.setCountry(updatedAddress.getCountry());
        existingAdrress.setNumber(updatedAddress.getNumber());
        existingAdrress.setPostalCode(updatedAddress.getPostalCode());
        existingAdrress.setState(updatedAddress.getState());
        existingAdrress.setStreet(updatedAddress.getStreet());
        existingAdrress.setLongitude(updatedAddress.getLongitude());
        existingAdrress.setLatitude(updatedAddress.getLatitude());

        repository.save(existingAdrress);

        return ResponseEntity.noContent().build();
    }


}
