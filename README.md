# Challenge from Mercedes-Benz.io
This project was created to solve a challenge that requested to automate the following test case “Validate A Class models prices are between £15,000 and £60,000"

## Technologies
- Build tool: **Maven**
- Framework: **Springboot**
- Test Framework: **jUnit**

## Project structure
- `ChallengeApplicationTests.java` in `src/test/java/com.mbio.challenge` contain the main challenge application.
- `AClassHatchbackPage.java` and `BasePage.java` in `src/test/java/pages` contain the base methods and the locators for each page.
- In `src/test/java/resources` contain the resources like drivers, screenshots and text files generated from the tests.
- `BaseUtils.java` in `src/test/java/utils`contains the webdriver management.

## How to run the challenge
- From CLI, in the project folder, run command `mvn clean test`.