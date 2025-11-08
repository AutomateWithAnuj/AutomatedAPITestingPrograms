````markdown name=read.md url=https://github.com/AutomateWithAnuj/AutomatedAPITestingPrograms/blob/4d6c36f15fec54710fe8cb0bc435b1d309e7b70a/src/test/java/com/APIAutomation/read.md
# API Automation Tests (src/test/java/com/APIAutomation)

## Overview
This folder contains the automated API tests for the project. Tests are organized under the Java package `com.APIAutomation`. The tests exercise endpoints of the target API, validate responses, and are intended to run as part of the project's CI pipeline or locally during development.

## Location
`src/test/java/com/APIAutomation`

## Prerequisites
- JDK 8+ installed and `JAVA_HOME` configured.
- Maven or Gradle available (commands below assume Maven; adjust for Gradle if used).
- Network access to the API under test (or a running mock/staging instance).
- Optional: authentication credentials or API token if endpoints require auth.

## Configuration
Tests should be configured via one of the following approaches (choose what your project uses):
- System properties (recommended for CI):
  - Example: `-DbaseUrl=https://api.example.com -DauthToken=abc123`
- Environment variables:
  - `BASE_URL`, `AUTH_TOKEN`, etc.
- A properties/config file under `src/test/resources` (if present in the repo).

The tests will read configuration from system properties or environment variables. If you add a properties file, document its expected keys and provide an example in `src/test/resources`.

## How to run
From the repository root:

- Run the full test suite (Maven):
  - mvn test -DbaseUrl="https://api.example.com" -DauthToken="your_token_here"
- Run a single test class:
  - mvn -Dtest=MyEndpointTests test -DbaseUrl="https://api.example.com"
- Run a single test method:
  - mvn -Dtest=MyEndpointTests#shouldReturn200 test -DbaseUrl="https://api.example.com"

Or run tests from your IDE (IntelliJ, Eclipse) by executing test classes or methods directly.

CI tips:
- Pass secrets/tokens via secure CI variables and inject them as environment variables or JVM properties.
- Use Maven profiles to separate environments (dev/stage/prod) if helpful.

## Project structure (typical)
- BaseTest / TestBase: common setup/teardown, base URL handling, auth setup.
- utils/: helper methods for building requests, common assertions, response parsers.
- models/: POJOs to deserialize JSON responses.
- tests/: endpoint test classes (one per resource or feature).
- data/: test data providers or JSON templates (if present).
- resources/: configuration files used by tests.

Adjust names according to actual files in this folder.

## Adding a new test
1. Create a new test class under `com.APIAutomation.tests` (or consistent package).
2. Reuse utility methods and models where possible.
3. Keep tests independent and idempotent.
4. Parameterize tests with data providers for variations.
5. Add necessary configuration keys to documentation if introducing new ones.

## Reporting & Logs
- Maven Surefire/Failsafe reports are generated under `target/surefire-reports` (or `target/failsafe-reports`).
- Capture request/response logs in test output or dedicated logs for easier troubleshooting.

## Troubleshooting
- If tests fail due to connectivity, verify `BASE_URL` and network access.
- For authentication failures, confirm tokens/credentials and headers being sent.
- Inspect the surefire reports and printed logs for stack traces and request/response payloads.

## Contributing / Contact
- Follow existing test patterns when adding new tests.
- Keep tests small and focused on one behavior per test.
- For questions about these tests, contact the repository owner: @AutomateWithAnuj

````
