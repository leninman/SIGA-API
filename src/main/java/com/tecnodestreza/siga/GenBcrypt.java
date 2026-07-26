package com.tecnodestreza.siga;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenBcrypt {
    public static void main(String[] args) {
        String password = args.length > 0 ? args[0] : "director";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode(password));
    }
}
