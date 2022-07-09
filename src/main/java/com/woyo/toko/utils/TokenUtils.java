package com.woyo.toko.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenUtils {

    public static String generateToken(String subject) {
        return JWT.create()
                .withSubject(subject)
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityUtils.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityUtils.SECRET.getBytes()));
    }
}
