package com.woyo.toko.service;

import com.woyo.toko.dto.UserDTO;
import com.woyo.toko.dto.request.UserRequestDTO;
import com.woyo.toko.dto.request.UserRequestLoginDTO;

public interface UserService {
    UserDTO register(UserRequestDTO userRequestDTO);
    UserDTO userDetail(int userId);
    UserDTO userLogin(UserRequestLoginDTO userRequestLoginDTO);
}
