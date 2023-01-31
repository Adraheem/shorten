package com.shortenServer.utils;

public class RegexPattern {

    public static final String SLUG = "^[A-Za-z0-9-]{3,30}$";

    public static final String PASSWORD = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,64})$";

}
