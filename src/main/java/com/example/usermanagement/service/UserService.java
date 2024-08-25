package com.example.usermanagement.service;

import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.entity.UserEntity;

public interface UserService {
    String createUser(UserDTO userDTO);
}
