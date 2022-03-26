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
     * @param postId
     * @return
     */
    List<String> getAllEmailsFromCommentsBaseOnPostId(final Integer postId);
}
