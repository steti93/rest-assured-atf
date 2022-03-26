package com.steti.atf.restassured.validator;

public interface FieldsValidator {
    /**
     * Scope is to validate email base on pattern from properties
     *
     * @param email String must not be null
     * @return boolean value
     */
    boolean validateEmail(final String email);
}
