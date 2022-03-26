package com.steti.atf.restassured.action.impl;

import com.steti.atf.restassured.action.UserSearchAction;
import io.restassured.response.Response;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class UserSearchActionImpl implements UserSearchAction {

    @Override
    public Integer searchUserByNameAndReturnUserId(final String userName) {
        if (Objects.nonNull(userName)) {
            Response allUsers = given().get("/users");
        } else throw new RuntimeException("Username parameter is null");
        return null;
    }
}
