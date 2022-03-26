package com.steti.atf.restassured.config;

import com.steti.atf.restassured.context.ScenarioContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CucumberSpringTestConfig {

    @Bean
    public ScenarioContext scenarioContext() {
        return new ScenarioContext();
    }
}
