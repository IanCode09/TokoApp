package com.woyo.toko.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
}
