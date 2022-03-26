package com.steti.atf.restassured.action.impl;

import com.steti.atf.restassured.action.UserSearchAction;
import com.steti.atf.restassured.model.TypeCodeUser;

import java.util.Arrays;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserSearchActionImpl implements UserSearchAction {

    @Override
    public Integer searchUserByNameAndReturnUserId(final String userName) {
        Integer userId;
        if (Objects.nonNull(userName)) {
            TypeCodeUser[] allUsers = given()
                    .get("/users")
                    .then().statusCode(HTTP_OK)
                    .extract().as(TypeCodeUser[].class);
            assertNotNull(allUsers);
            userId = Arrays.stream(allUsers)
                    .filter(typeCodeUser -> typeCodeUser.getUsername().equals(userName))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException(format("Can't find user with username: %s", userName)))
                    .getId();
        } else {
            throw new RuntimeException("Username parameter is null");
        }
        return userId;
    }
}
