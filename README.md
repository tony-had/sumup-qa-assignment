# SumUp QA Demo

Basic automated test framework using Kotlin, Selenium, TestNG and Browserstack.

The implemented page objects allow a simple login test to be executed that verifies no transactions can be present for an incomplete account.

## Getting Started

### Prerequisites

- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) with default plugins (Maven, TestNG, etc.)
- [Java JDK 1.8 (e.g. 8u251)](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- Joining the [SumUp QA Assignment team](https://accounts.browserstack.com/jointeam/998c1774bbd1801d6bfcb2df4eaad7d7) in Browserstack

### Installing

1. Clone the repo
    ```
    git clone https://github.com/tony-had/sumup-qa-assignment.git
    ```

2. Import the project into IntelliJ IDEA:
    1. `File > New > Project from Existing Sources`
    2. Select the directory containing the repo.
    3. Select `Import project from external model` and choose Maven.
    4. `Finish`

## Running the tests

Right-click on `testng.xml` in the Project panel and Run it. This will run the following suites:
- Windows 10 Smoke Test - login test on IE 11, Edge latest, Chrome latest, Firefox latest
- macOS Catalina Smoke Test - login test on Safari 13.1, Edge latest, Chrome latest, Firefox latest

Result details will be available under Build 1 on the [Browserstack dashboard](https://automate.browserstack.com/dashboard/v2/).

## Project Structure
- `src/main/kotlin`
    - `base` - base page classes
    - `page` - concrete page classes
    - `util` - utilities, constants
- `src/test/kotlin`
    - `base` - base test classes
    - `page` - concrete page test classes
- `suites` - TestNG test suite files

## Known Issues
- The IE 11 test fails, because users cannot log in to the SumUp web app from IE 11
- The Safari 13.1 test will sometimes randomly navigate to Dashboard instead of Sales page

## TODO
- [ ] Add support for testing at different windows sizes (e.g. where the nav bar is collapsed)
- [ ] Create custom locator strategy for locating elements by their `data-selector` attribute
- [ ] Initialize page objects differently depending on whether the test is running on desktop or mobile app
