package com.woyo.toko.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestLoginDTO {
    private String email;
    private String password;
}
