package com.bridgelabz.bookstorebackend.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

//    private String dateOfBirth;
//
//    private String email;
//
//    private String password;
//
//    private String contact;
//
//    private String kyc;
//
//    private String role;
//
//    private String otp;

    //private Cart cart;

    //private List<Order> orders;

}
