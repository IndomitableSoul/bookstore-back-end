package com.bridgelabz.bookstorebackend.controller;


import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.dto.UserDTO;
import com.bridgelabz.bookstorebackend.entity.User;
import com.bridgelabz.bookstorebackend.service.userService.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bookstore")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getUsers")
    @ApiOperation(value = "Finds all the Users",
            notes= "No need to provide any input",
            response = ResponseEntity.class )
    public ResponseEntity<ResponseDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        ResponseDTO responseDTO = new ResponseDTO("Got all users Successfully", users);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Finds the User specific to the id",
            notes= "Provide an id to look up the specific user from the database",
            response = ResponseEntity.class )
    public ResponseEntity<ResponseDTO> getUserById(@PathVariable Long id){
        User userById = userService.getUserById(id);
        ResponseDTO responseDTO = new ResponseDTO("Got user whose id is " + userById.getId(), userById);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "Adds a User",
            notes= "Provide User details to add in",
            response = ResponseEntity.class )
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO){
        User  user = userService.addUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added User Successfully", user);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation(value = "Updates the User specific to the id",
            notes= "Provide an id to edit the details of the specific user",
            response = ResponseEntity.class )
    public ResponseEntity<ResponseDTO> editUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO){
        List<User> user = userService.updateUser(id, userDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated User Successfully", user);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    @ApiOperation(value = "Deletes the User specific to the id",
            notes= "Provide an id to delete the details of the specific user",
            response = ResponseEntity.class )
    public  void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    //login

    //send-otp to mail

    //verify-otp sent to mail

    //reset-password


}
