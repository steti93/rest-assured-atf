package com.steti.atf.restassured.step;

import com.steti.atf.restassured.formatter.CucumberScenarioContext;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * LoggerSetupSteps contains the CucumberScenarioContext initialization step that should be
 * trigger before each step.
 */
public class LoggerSetupSteps {
    @Autowired
    private CucumberScenarioContext scenarioContext;

    @Before(order = 0)
    public void loggerSetup(Scenario scenario) {
        scenarioContext.setCurrentScenario(scenario);
    }
}
