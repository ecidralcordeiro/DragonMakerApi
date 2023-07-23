package com.uextest.models;

import lombok.*;

import javax.persistence.*;


@Table(name = "contacts")
@Entity(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String cpf;
    private String phone;
    private String address;
    private String zipCode;
    private double latitude;
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
