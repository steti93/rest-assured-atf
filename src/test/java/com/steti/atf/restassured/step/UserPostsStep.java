package com.steti.atf.restassured.step;

import com.steti.atf.restassured.action.UserPostAction;
import com.steti.atf.restassured.context.ScenarioContext;
import com.steti.atf.restassured.validator.FieldsValidator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.steti.atf.restassured.context.DataUserKeys.USER_ID;
import static com.steti.atf.restassured.context.DataUserKeys.USER_POSTS_IDS;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor
public class UserPostsStep {

    private final ScenarioContext scenarioContext;

    private final UserPostAction userPostAction;

    private final FieldsValidator fieldsValidator;

    @When("system administrator is searching for all user posts")
    public void systemAdministratorIsSearchingForAllUserPosts() {
        List<Integer> userPostsIds = userPostAction.getAllPostsIdBaseOnUserId(scenarioContext.getData(USER_ID));
        scenarioContext.save(USER_POSTS_IDS, userPostsIds);
    }

    @Then("system administrator validates all email from comments under posts written by user")
    public void systemAdministratorValidatesAllEmailFromCommentsUnderPostsWrittenByUser() {
        List<Integer> userPostsIds = scenarioContext.getData(USER_POSTS_IDS);
        userPostsIds.forEach(postId -> {
            List<String> allCommentsEmails = userPostAction.getAllEmailsFromCommentsBaseOnPostId(postId);
            allCommentsEmails.forEach(emailFromComment ->
                    assertTrue(fieldsValidator.validateEmail(emailFromComment), "Email validation failed!"));
        });
    }
}
