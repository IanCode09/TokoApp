package com.woyo.toko.service.impl;

import com.woyo.toko.converter.UserConverter;
import com.woyo.toko.dto.UserDTO;
import com.woyo.toko.dto.request.UserRequestDTO;
import com.woyo.toko.dto.request.UserRequestLoginDTO;
import com.woyo.toko.model.UserModel;
import com.woyo.toko.repository.UserRepository;
import com.woyo.toko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO register(UserRequestDTO userRequestDTO) {

        Optional<UserModel> user = userRepository.findByEmail(userRequestDTO.getEmail());

        if (user.isEmpty()) {
            String passwordEncoder = bCryptPasswordEncoder.encode(userRequestDTO.getPassword());

            UserModel userModel = new UserModel();
            userModel.setFirstName(userRequestDTO.getFirstName());
            userModel.setLastName(userRequestDTO.getLastName());
            userModel.setEmail(userRequestDTO.getEmail());
            userModel.setPassword(passwordEncoder);
            userModel.setCreatedAt(LocalDateTime.now());

            return userConverter.convertToDTO(userRepository.save(userModel));
        } else {
            return null;
        }
    }

    @Override
    public UserDTO userDetail(int userId) {
        Optional<UserModel> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return userConverter.convertToDTO(user.get());
        } else {
            return null;
        }
    }
}
