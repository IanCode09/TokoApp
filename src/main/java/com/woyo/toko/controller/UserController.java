package com.woyo.toko.controller;

import com.woyo.toko.dto.UserDTO;
import com.woyo.toko.dto.request.UserRequestDTO;
import com.woyo.toko.dto.request.UserRequestLoginDTO;
import com.woyo.toko.response.DataResponse;
import com.woyo.toko.response.HandlerResponse;
import com.woyo.toko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void userRegister(HttpServletRequest request, HttpServletResponse response, @RequestBody UserRequestDTO userRequestDTO) throws IOException {

        UserDTO userDTO = userService.register(userRequestDTO);

        if (userDTO != null) {
            DataResponse<UserDTO> data = new DataResponse<>();
            data.setData(userDTO);
            HandlerResponse.responseSuccessWithData(response, data);
        } else {
            HandlerResponse.responseBadRequest(response, 400, "Something wrong or email exists");
        }
    }

    @GetMapping("/{userId}")
    public void userDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable int userId) throws IOException {

        UserDTO userDTO = userService.userDetail(userId);

        if (userDTO != null) {
            DataResponse<UserDTO> data = new DataResponse<>();
            data.setData(userDTO);
            HandlerResponse.responseSuccessWithData(response, data);
        } else {
            HandlerResponse.responseNotFound(response, 404, "User not found");
        }
    }
}
