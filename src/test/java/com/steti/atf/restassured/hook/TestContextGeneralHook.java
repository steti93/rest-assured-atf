package com.steti.atf.restassured.hook;

import com.steti.atf.restassured.config.CucumberSpringTestConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@CucumberContextConfiguration
@ContextConfiguration(classes = {CucumberSpringTestConfig.class},
        loader = AnnotationConfigContextLoader.class)
public class TestContextGeneralHook {
}
