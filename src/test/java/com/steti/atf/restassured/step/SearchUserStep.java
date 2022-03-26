package com.steti.atf.restassured.step;

import com.steti.atf.restassured.action.UserSearchAction;
import com.steti.atf.restassured.context.ScenarioContext;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SearchUserStep {

    private final ScenarioContext scenarioContext;

    private final UserSearchAction userSearchAction;

    @Given("system administrator is searching for user following {string}")
    public void theSystemAdministratorIsSearchingForUserName(String userName) {
        log.info("Retrieving data for following user {}", userName);
        userSearchAction.searchUserByNameAndReturnUserId(userName);
    }
}
