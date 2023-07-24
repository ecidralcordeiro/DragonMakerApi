package com.uextest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String address;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
