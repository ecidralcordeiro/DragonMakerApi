package com.uextest.repositories;

import com.uextest.models.Address;
import com.uextest.models.Contact;
import com.uextest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {


    Address findById(long id);

}
