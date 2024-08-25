package com.example.usermanagement.service;

import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.entity.UserEntity;

import java.util.List;

public interface UserService {
    String createUser(UserDTO userDTO);

    String updsteauader(UserDTO userDTO);

    UserDTO getUser(String id);

    List<UserDTO> getUserList();

    String deleteUser(String id);
}
