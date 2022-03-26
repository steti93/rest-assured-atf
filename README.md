### Rest Assured Basic ATF

#### CI/CD Set Up
Before Executing all test a best practice is to validate System Under Test if is up an running.
In order to do this following system parameter needs to be set on test phase `-Dtest.application.base.uri`

Includes Features:
- SUT Application Health Check
- Cucumber 7 integrated with Spring Boot Test