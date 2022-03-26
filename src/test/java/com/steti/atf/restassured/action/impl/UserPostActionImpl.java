package com.steti.atf.restassured.action.impl;

import com.steti.atf.restassured.action.UserPostAction;
import com.steti.atf.restassured.model.TypeCodeComment;
import com.steti.atf.restassured.model.TypeCodePost;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class UserPostActionImpl implements UserPostAction {

    @Override
    public List<Integer> getAllPostsIdBaseOnUserId(final Integer userId) {
        List<Integer> allPostsIds;
        if (Objects.nonNull(userId)) {
            log.info("Searching all posts for user with id: {}", userId);
            TypeCodePost[] allPosts = given()
                    .get("/posts")
                    .then().statusCode(HTTP_OK)
                    .extract().as(TypeCodePost[].class);
            assertNotNull(allPosts);
            allPostsIds = Arrays.stream(allPosts)
                    .filter(post -> userId.equals(post.getUserId())).map(TypeCodePost::getId)
                    .collect(Collectors.toList());
            assertNotNull(allPostsIds);
        } else throw new RuntimeException("userId parameter is null");
        return allPostsIds;
    }

    @Override
    public List<String> getAllEmailsFromCommentsBaseOnPostId(final Integer postId) {
        List<String> allEmailFromComments;
        if (Objects.nonNull(postId)) {
            log.info("Evaluating all comment from post with id: {}", postId);
            TypeCodeComment[] allCommentsFromPost = given()
                    .get("/posts/{postId}/comments", postId)
                    .then().statusCode(HTTP_OK)
                    .extract().as(TypeCodeComment[].class);
            assertNotNull(allCommentsFromPost);
            allEmailFromComments = Arrays.stream(allCommentsFromPost)
                    .filter(comment -> postId.equals(comment.getPostId()))
                    .map(TypeCodeComment::getEmail).collect(Collectors.toList());
        } else throw new RuntimeException("postId parameter is null");
        return allEmailFromComments;
    }

}
