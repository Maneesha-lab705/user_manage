package com.example.usermanagement.service.impl;

import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.repo.UserRepository;
import com.example.usermanagement.service.UserService;
import com.example.usermanagement.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final Mapping mapping;
    @Override
    public String createUser(UserDTO userDTO) {
        try {
            userRepository.save(mapping.convertToUserEntity(userDTO));
            return "Saved User";
        } catch (DataIntegrityViolationException exception) {
            return "Not Saved User";
        }
    }
}
