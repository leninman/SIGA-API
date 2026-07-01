package com.tecnodestreza.siga;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class GenBcrypt {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("director: " + encoder.encode("director"));
        System.out.println("administrativo: " + encoder.encode("administrativo"));
    }
}
