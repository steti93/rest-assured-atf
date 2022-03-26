package com.steti.atf.restassured.hook;

import com.steti.atf.restassured.config.CucumberSpringTestConfig;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@CucumberContextConfiguration
@ContextConfiguration(classes = {CucumberSpringTestConfig.class},
        loader = AnnotationConfigContextLoader.class)
public class TestGeneralHook {

    @Value("${test.application.base.uri:https://jsonplaceholder.typicode.com/}")
    private String testApplicationBaseURI;

    @AfterAll
    public static void resetRestAssuredconfiguration() {
        RestAssured.reset();
    }

    @Before
    public void setUpApplicationTestBaseURI() {
        RestAssured.baseURI = testApplicationBaseURI;
    }
}
