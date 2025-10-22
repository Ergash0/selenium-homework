 Selenium Homework: Automation Testing Project

This repository contains automated tests developed for practical assignments in the Selenium WebDriver course, utilizing Java, Maven, and the TestNG framework.

Technologies

Programming Language: Java

Build Tool: Apache Maven

Testing Framework: TestNG

Driver Management: WebDriverManager

Browser: Google Chrome

 Setup and Running the Project

To run the tests, follow these steps:

Clone the Repository:

git clone [https://github.com/Ergash0/selenium-homework.git](https://github.com/Ergash0/selenium-homework.git)
cd selenium-homework


Load Maven Dependencies:
Ensure your IDE (e.g., IntelliJ IDEA) automatically loads all dependencies specified in the pom.xml file.

Run the Tests:
Tests can be executed directly from your IDE (IntelliJ IDEA, Eclipse, etc.) by right-clicking the test class or method and selecting 'Run'. Alternatively, you can use the Maven command:

mvn clean test

 Completed Assignments

Day 1: Commands

Status: COMPLETED

The tests for Day 1 are implemented in the file src/test/java/CommandsTest.java.

Functionality:

Verification of dynamic elements on the /dynamic_controls page (using isEnabled(), clear(), sendKeys(), and explicit waits).

Verification of horizontal alignment of elements on the /drag_and_drop page (comparing Y-coordinates).
