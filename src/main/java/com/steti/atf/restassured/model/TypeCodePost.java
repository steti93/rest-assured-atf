package com.steti.atf.restassured.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Expectation that testing framework has access to application resources
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TypeCodePost {

    private Integer userId;

    private Integer id;

}
