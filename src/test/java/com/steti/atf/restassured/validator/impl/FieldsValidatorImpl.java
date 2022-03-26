package com.steti.atf.restassured.validator.impl;

import com.steti.atf.restassured.validator.FieldsValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.regex.Pattern;

@Slf4j
public class FieldsValidatorImpl implements FieldsValidator {
    @Value("${test.email.pattern:^(.+)@(.+)$}")
    private String testEmailPattern;

    @Override
    public boolean validateEmail(String email) {
        log.info("Validating following email: {}", email);
        Pattern pattern = Pattern.compile(testEmailPattern);
        return pattern.matcher(email).matches();
    }
}
