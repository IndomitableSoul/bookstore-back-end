package com.bridgelabz.bookstorebackend.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class UserDTO {

    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First name Invalid")
    private String firstName;

    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First name Invalid")
    private String lastName;

//    private String dateOfBirth;
//
//    @Email(message = "Email must not be Empty")
//    private String email;
//
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[-+(){}_!@#$%^&*., ?]){8,}.*$", message = "Enter Valid password")
//    private String password;
//
//    @Pattern(regexp = "(91 )[1-9]{1}[0-9]{9}", message = "Enter valid mobile number")
//    private String contact;
//
//    private String kyc;
//
//    @Pattern(regexp = "Admin|Normal User|admin|normal user", message = "Role should be admin or normal user")
//    private String role;

    //private String otp;

}
