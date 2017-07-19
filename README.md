# Software Gauntlet
Automation framework for the testing of any site or service.  The framework is designed to provide comprehensive, reliable, efficient, effective and resilient validation with a reasonably sized test library.

# Onboarding (Windows)
In a PowerShell console, execute 'onboarding.ps1' found at the root of the repository.  
It will require restarting the console multiple times to complete each install.
 - PowerShell (5.0)
 - Chocolatey
 - JDK8 (Java 1.8)
 - Git
 - PoshGit (powershell support for Git)
 - IntelliJ

# Test Execution
In a console, in the project directory:

    .\gradlew.bat clean [suite]
**EXAMPLE** for Environment Validation Test (EVT):

    .\gradlew.bat clean evt
**NOTE:**
On first execution, gradle will install necessary files before executing the build.  This is a one-time install.

# Test Files
 - All tests reside in src/test/java and are organized by the view or data that will be validated
 - All other supporting components reside in src/main/java and are organized by the components they support, in hierarchical fashion
 
# Test Structure
 - For each view, region or data model, the following files can be expected
   - Interface
     - all UI or data elements that can be analyzed
     - all 'in[Region]' methods
     - contains NO 'actions' or other methods
   - Validator
     - reconciles an Actual result with an Expected result
     - all verifications to be executed
     - all 'child' validators to be run
   - View
     - inherits a view interface
     - 'actions' which result in a state or view transition
       - set
       - click
       - select
       - etc.
     - 'expect' called when an action is expected to load the view
     - 'directNav' to load the view directly in the browser
     - 'in[Region]' to return a particular 'Region' of the view
        - inHeader
        - inContent
        - inFooter
        - inTopNav
        - etc.
    - Data
      - inherits a data interface
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
      
      `confirm(Validator.getInstance(expected, actual).validate());`
      - executes all verifications for a given view or data element (e.g. for regions within a view)