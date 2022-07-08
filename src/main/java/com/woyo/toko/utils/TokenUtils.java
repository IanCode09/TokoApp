package com.woyo.toko.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenUtils {

    public static String generateToken(String subject) {
        return JWT.create()
                .withSubject(subject)
                .sign(Algorithm.HMAC512(SecurityUtils.SECRET.getBytes()));
    }
}
