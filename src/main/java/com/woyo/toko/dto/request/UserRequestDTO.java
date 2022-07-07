package com.woyo.toko.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
