package com.woyo.toko.utils;

public class SecurityUtils {
    public static final String SECRET = "5FB9F4E53CE3A83D17B1CB4B71AC7535C4E184C18EDC5704C988C38BF4B756CE";
    public static final long EXPIRATION_TIME = 60_000 * 60 * 24 * 2; // 2days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
