package com.steti.atf.restassured.config;

import com.steti.atf.restassured.action.UserPostAction;
import com.steti.atf.restassured.action.UserSearchAction;
import com.steti.atf.restassured.action.impl.UserPostActionImpl;
import com.steti.atf.restassured.action.impl.UserSearchActionImpl;
import com.steti.atf.restassured.context.ScenarioContext;
import com.steti.atf.restassured.validator.FieldsValidator;
import com.steti.atf.restassured.validator.impl.FieldsValidatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class CucumberSpringTestConfig {

    @Bean
    public ScenarioContext scenarioContext() {
        return new ScenarioContext();
    }

    @Bean
    public UserSearchAction userSearchAction() {
        return new UserSearchActionImpl();
    }

    @Bean
    public UserPostAction userPostAction() {
        return new UserPostActionImpl();
    }

    @Bean
    public FieldsValidator fieldsValidator() {
        return new FieldsValidatorImpl();
    }
}
