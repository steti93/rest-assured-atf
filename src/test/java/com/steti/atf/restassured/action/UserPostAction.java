package com.steti.atf.restassured.action;

import java.util.List;

public interface UserPostAction {
    /**
     * Scope is to find all user posts base on user id
     *
     * @param userId Integer value
     * @return List on Integers that contains all user posts ID's
     */
    List<Integer> getAllPostsIdBaseOnUserId(final Integer userId);

    /**
     * Scope is to return a list of all email used for comments under post
     *
     * @param postId Integer value
     * @return Collection of Strings
     */
    List<String> getAllEmailsFromCommentsBaseOnPostId(final Integer postId);
}
