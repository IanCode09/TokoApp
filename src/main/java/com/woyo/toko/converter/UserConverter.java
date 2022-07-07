package com.woyo.toko.converter;

import com.woyo.toko.dto.UserDTO;
import com.woyo.toko.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDTO convertToDTO(UserModel item) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(item.getUserId());
        userDTO.setFirstName(item.getFirstName());
        userDTO.setLastName(item.getLastName());
        userDTO.setEmail(item.getEmail());

        return userDTO;
    }
}
