package com.example.config;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DefaultPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return DigestUtils.sha256Hex(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        String rawPasswordStr = DigestUtils.sha256Hex(rawPassword.toString());

        return StringUtils.equals(rawPasswordStr, encodedPassword);
    }

    /**
     * Get the singleton
     */
    public static PasswordEncoder getInstance() {
        return INSTANCE;
    }

    private static final PasswordEncoder INSTANCE = new DefaultPasswordEncoder();

    private DefaultPasswordEncoder() {

    }
}
