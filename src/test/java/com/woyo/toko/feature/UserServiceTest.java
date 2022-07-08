package com.woyo.toko.feature;

import com.woyo.toko.dto.request.UserRequestDTO;
import com.woyo.toko.repository.UserRepository;
import com.woyo.toko.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setFirstName("Dadang");
        userRequestDTO.setLastName("Iskandar");
        userRequestDTO.setEmail("dadang@gmail.com");
        userRequestDTO.setPassword("dadang123");

        userService.register(userRequestDTO);
    }

    @Test
    void testUserCount() {
        int userCount = userRepository.findAll().size();
        assertThat(userCount).isGreaterThan(1);
    }
}
