package com.example.usermanagement.util;

import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Mapping {

    final private ModelMapper modelMapper;

    public UserEntity convertToUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDTO convertToUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public List<UserDTO> toUserDTOList(List<UserEntity> userEntities) {
        return modelMapper.map(userEntities, List.class);
    }
}
