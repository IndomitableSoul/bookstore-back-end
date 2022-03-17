package com.bridgelabz.bookstorebackend.service.userService;

import com.bridgelabz.bookstorebackend.dto.UserDTO;
import com.bridgelabz.bookstorebackend.entity.User;
import com.bridgelabz.bookstorebackend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public User addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id).get();
    }

    @Override
    public List<User> updateUser(Long id, UserDTO userDTO) {
        User userById = this.getUserById(id);
        modelMapper.map(userDTO, userById);
        userRepository.save(userById);
        return this.getAllUsers();
    }

    @Override
    public void deleteUser(Long id) {
        User user = this.getUserById(id);
        userRepository.delete(user);
    }
}
