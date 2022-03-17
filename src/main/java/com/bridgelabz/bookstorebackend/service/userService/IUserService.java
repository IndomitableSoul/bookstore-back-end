package com.bridgelabz.bookstorebackend.service.userService;

import com.bridgelabz.bookstorebackend.dto.UserDTO;
import com.bridgelabz.bookstorebackend.entity.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUsers();

    User addUser(UserDTO userDTO);

    User getUserById(Long id);

    List<User> updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
}
