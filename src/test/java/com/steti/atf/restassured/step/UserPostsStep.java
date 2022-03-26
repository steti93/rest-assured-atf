package com.steti.atf.restassured.step;

import com.steti.atf.restassured.action.UserPostAction;
import com.steti.atf.restassured.context.ScenarioContext;
import com.steti.atf.restassured.validator.FieldsValidator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.hamcrest.MatcherAssert;

import java.util.List;

import static com.steti.atf.restassured.context.DataUserKeys.*;
import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.is;
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

    @When("system administrator navigates to comments url and change post value with {string}")
    public void systemAdministratorNavigatesToCommentsPathAndReplaceUrl(String newValueInPath) {
        String response = given().get("/{newValueInPath}/1/comments", newValueInPath)
                .then().assertThat()
                .statusCode(HTTP_OK)
                .extract().asString();
        scenarioContext.save(RESPONSE_BODY, response);
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

    @Then("system administrator navigates to an invalid post {string} gets {int}")
    public void systemAdministratorChecksInvalidDataForPostId(String postId, Integer expectedStatusReasonCode) {
        given().get("/posts/{postId}/comments", postId)
                .then().statusCode(expectedStatusReasonCode);

    }

    @Then("system administrator expects to see a empty braces")
    public void expectedResponseIsEmptyBraces() {
        String response = scenarioContext.getData(RESPONSE_BODY);
        MatcherAssert.assertThat(response, is("{}"));
    }
}
