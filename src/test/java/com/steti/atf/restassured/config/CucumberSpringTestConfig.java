package com.steti.atf.restassured.config;

import com.steti.atf.restassured.action.UserSearchAction;
import com.steti.atf.restassured.action.impl.UserSearchActionImpl;
import com.steti.atf.restassured.context.ScenarioContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CucumberSpringTestConfig {

    @Bean
    public ScenarioContext scenarioContext() {
        return new ScenarioContext();
    }

    @Bean
    public UserSearchAction userSearchAction() {
        return new UserSearchActionImpl();
    }
}
