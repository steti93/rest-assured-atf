package com.steti.atf.restassured.action;

public interface UserSearchAction {
    Integer searchUserByNameAndReturnUserId(final String userName);
}
