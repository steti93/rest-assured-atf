package com.steti.atf.restassured.formatter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * SpringContext class is used by CucumberScenarioAppender to retrieve the CucumberScenarioContext bean, as
 * CucumberScenarioAppender is initialized by SpringFramework and CucumberScenarioContext will be handled by
 * Cucumber - we can't autowire it directly
 */
@Component
public class StaticSpringContext implements ApplicationContextAware {
    private static ApplicationContext context;

    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        StaticSpringContext.context = context;
    }
}
