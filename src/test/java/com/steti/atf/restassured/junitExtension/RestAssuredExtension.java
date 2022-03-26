package com.steti.atf.restassured.junitExtension;

import io.restassured.RestAssured;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

public class RestAssuredExtension extends SpringExtension {

    private static final String TEST_APPLICATION_BASE_URI = "test.application.base.uri";

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        Optional<String> baseUri = getSystemProperty(TEST_APPLICATION_BASE_URI);
        RestAssured.baseURI = baseUri.orElse(RestAssured.DEFAULT_URI);
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        RestAssured.reset();
    }

    private Optional<String> getSystemProperty(final String propertyName) {
        return Optional.ofNullable(System.getProperty(propertyName));
    }


}
