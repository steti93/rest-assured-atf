package com.steti.atf.restassured.action;

public interface UserSearchAction {
    /**
     * Scope is to parse all users and find used ID base on userName
     *
     * @param userName String value
     * @return Integer value that is assigned to user
     */
    Integer searchUserByNameAndReturnUserId(final String userName);
}
