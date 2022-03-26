package com.steti.atf.restassured;

import com.steti.atf.restassured.junitExtension.RestAssuredExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;

@ExtendWith({RestAssuredExtension.class,})
public class ApplicationHealthCheckTest {

    @Test
    void apiResponsesWithOkStatus() {
        given()
                .get()
                .then()
                .statusCode(200);
    }
}
