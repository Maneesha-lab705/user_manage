package com.example.usermanagement.service.impl;

import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.entity.UserEntity;
import com.example.usermanagement.repo.UserRepository;
import com.example.usermanagement.service.UserService;
import com.example.usermanagement.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public String updsteauader(UserDTO userDTO) {
        try {
            Optional<UserEntity> userOptional = userRepository.findById(userDTO.getId());
            UserEntity user = userOptional.get();

            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setRole(userDTO.getRole());
            return "Saved User";
        } catch (DataIntegrityViolationException exception) {
            return "Not Updated User";
        }
    }

    @Override
    public UserDTO getUser(String id) {
        try {
            Optional<UserEntity> byId = userRepository.findById(id);
            UserEntity user = byId.get();
            return mapping.convertToUserDTO(user);
        } catch (DataIntegrityViolationException exception) {
            return null;
        }
    }

    @Override
    public List<UserDTO> getUserList() {
        List<UserEntity> all = userRepository.findAll();
        return mapping.toUserDTOList(all);
    }

    @Override
    public String deleteUser(String id) {
        try {
            userRepository.deleteById(id);
            return "deleted";
        } catch (DataIntegrityViolationException exception) {
            return "Not deleted User";
        }
    }
}
