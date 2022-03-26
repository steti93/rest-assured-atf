### Rest Assured Basic ATF
#### Preconditions
- Maven
- Java 8 or higher

#### CI/CD Set Up
Before Executing all test a best practice is to validate System Under Test if is up an running.
Two profiles has been created for CI:
- unit-tests that requires `-Dtest.application.base.uri` and command to execute is following: `-Dtest.application.base.uri=https://jsonplaceholder.typicode.com test -Punit-tests`
- e2e-tests that will execute cucumber tests with following command: `-Pe2e-tests test -Dtest=CucumberRunner`

Includes Features:
- SUT Application Health Check
- Cucumber 7 integrated with Spring Boot Test
- Cucumber auto report generation and pretty report