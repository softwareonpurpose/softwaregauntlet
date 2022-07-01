# Software Gauntlet
Automation framework for the testing of any site or service.  The framework is designed to provide comprehensive, reliable, efficient, effective and resilient validation with a reasonably sized test library.

# Onboarding (Windows)
In a PowerShell console, execute 'Install-GauntletWorkstation.ps1' found at the root of the repository.  
It will require restarting the console multiple times to complete each install.
 - PowerShell (5.0)
 - Chocolatey
 - JDK17
 - Git
 - PoshGit (powershell support for Git)
 - IntelliJ

# Onboarding (Mac)
In a Terminal console, execute 'Install-Gauntlet-Mac.sh' found at the root of the repository.  
 - HomeBrew
 - JDK17
 - Git
 - Gradle
 - IntelliJ

Gradle may not be set in the Path so you will need to run: 'sudo chmod 755 gradlew' then ./gradlew clean should work.

# Test Execution
### In local environment
In a console, in the project directory:

    ./gradlew clean [suite]
**EXAMPLE** for Environment Validation Test (SMOKE):

    ./gradlew clean smoke

### In other environments
In a console, in the project directory:

    ./gradlew clean [suite] -Denv=[env]
**EXAMPLE** for Environment Validation Test (SMOKE) in dev:

    ./gradlew clean smoke -Denv=dev
**NOTE:**
On first execution, gradle will install necessary files before executing the build.  This is a one-time install.

# Browsers
The appropriate WebDriver executables MUST be added to main/resources.  By default, IF chromedriver.exe exists in that location, Google Chrome will be used by default.  The following default DriverInstantiation implementations are available:
 - DefaultChromeInstantiation for Google Chrome
 - DefaultHtmlUnitInstantiation for HtmlUnit (headless)
 - DefaultFirefoxInstantiation for Mozilla Firefox
 - DefaultIeInstantiation for Microsoft InternetExplorer

To implement an alternate configuration of any browser, implement a new DriverInstantiation.

For example:
    
    public class CookieFreeFullScreenChromeInstantiation extends DriverInstantiation {

        public static DriverInstantiation getInstance() {
            return new CookieFreeFullScreenChromeInstantiation();
        }

        @Override
        protected ChromeDriver instantiateDriver() {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
            return new ChromeDriver();
        }

        @Override
        protected void configureDriver(WebDriver driver) {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().fullscreen();
        }
    }

# Test Files
 - All tests reside in src/test/java and are organized by the view or data that will be validated
 - All other supporting components reside in src/main/java and are organized by the components they support, in hierarchical fashion
 
# Test Structure
- For each view, region or data model, the following files can be expected
    - Interface
        - all UI or data elements that can be analyzed
        - all 'in[Region]' methods
        - contains NO 'actions' or other methods
    - Calibrator (for validation)
        - reconciles an Actual result with an Expected result
        - all verifications to be executed
        - all 'child' validators to be run
    - View
        - inherits a view interface
        - 'actions' which result in a state or view transition
            - click
            - select
            - login
            - register
            - edit
            - etc.
        - 'expect' called when an action performed that may result in a state change
        - 'directNav' to load a view directly in the browser
        - 'in[Region]' to return a particular 'Region' of a view
            - inHeader
            - inContent
            - inFooter
            - inTopNav
            - etc.
    - Data
        - inherits a test-appropriate data model interface
    - Expected
        - inherits a view or data interface
        - contains the business logic necessary to determine the expected value of all elements, based on provided data scenario
- Each test follows the following format:
    - Test data acquisition
        - via a Test Data Provider
        - either within the test method or via a TestNG DataProvider
        - returns all data for a specific test scenario
    - Expected result determination
        - expected classes contain detailed business logic used to determine specific expected results of all elements to be verified
    - Actual result acquisition
        - includes all steps to be performed
            - shortest path possible to a view to be validated
            - shortest path possible to an action that will cause a data transition
        - as much as possible, all methods are chained for readability

    - Validation
        - always in the form of

      `then(Calibrator.getInstance(expected, actual));`
        - executes all verifications for a given view or data element (e.g. for regions within a view) 
