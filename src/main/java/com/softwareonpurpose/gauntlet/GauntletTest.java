/*Copyright 2017 Craig A. Stockton

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.*/
package com.softwareonpurpose.gauntlet;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.coverage4test.CoverageReport;
import com.softwareonpurpose.uinavigator.UiDriver;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GauntletTest {
    private static UiDriver driverInstantiation;
    private final CoverageReport report;
    private Logger logger;
    private String testMethodName;
    private String featureName;
    private String requirements;
    private long updatedVerificationCount;

    protected GauntletTest() {
        report = CoverageReport.getInstance();
        initializeUiHost();
    }

    private void initializeUiHost() {
        if (driverInstantiation == null) {
            driverInstantiation = ChromeUiDriver.getInstance();
        }
        WebUiHost.setUiDriver(driverInstantiation);
    }

    @BeforeClass(alwaysRun = true)
    public void Initialize(){
        featureName = this.getClass().getSimpleName().replace("Tests","");
    }

    @BeforeMethod(alwaysRun = true)
    public void beginExecution(Method method) {
        testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void terminateExecution(ITestResult result) {
        WebUiHost.quitInstance();
        addCoverageEntry(result);
    }

    private void addCoverageEntry(ITestResult result) {
        List<String> requirementList;
        if (requirements == null) {
            requirementList = Collections.singletonList(null);
        } else {
            requirementList = Arrays.stream(requirements.split("\\|")).collect(Collectors.toList());
        }
        Object scenario = compileScenario(result);
        for (String requirement : requirementList) {
            requirement = requirement != null ? requirement.replace(".", "|") : null;
            report.addTestEntry(testMethodName, featureName, null, scenario, requirement);
        }
        setRequirements(null);
    }

    private String compileScenario(ITestResult result) {
        if (result.getParameters().length == 0) {
            return null;
        }
        StringBuilder scenarioBuilder = new StringBuilder();
        for (Object participant : result.getParameters()) {
            String participantDescription = participant.toString();
            String formattedDescription = participantDescription.startsWith("{") ? participantDescription
                    : String.format("{%s}", participantDescription);
            scenarioBuilder.append(formattedDescription);
        }
        String scenario = scenarioBuilder.toString();
        return scenario.lastIndexOf(",") >= 0 ? scenario.substring(0, scenario.lastIndexOf(",")) : scenario;
    }

    @AfterClass(alwaysRun = true)
    public void writeCoverageReport() {
        System.out.println(report.getRequirementsCoverage());
        System.out.printf(report.getSystemCoverage());
    }

    @SuppressWarnings("unused")
    protected void given(Object... testDataDefinitions) {
        String label = "GIVEN";
        for (Object testDataDefinition : testDataDefinitions) {
            getLogger().info(String.format("%s: %s", label, testDataDefinition.toString()));
            label = "  AND";
        }
    }

    @SuppressWarnings("unused")
    protected void when() {
        getLogger().info("");
        getLogger().info("WHEN:");
    }

    @SuppressWarnings("unused")
    protected void then(Calibrator calibrator) {
        String calibration = calibrator.calibrate();
        updatedVerificationCount += calibrator.getVerificationCount();
        confirm(calibration);
    }

    @SuppressWarnings("WeakerAccess")
    protected void confirm(String testResult) {
        Assert.assertEquals(testResult, Calibrator.SUCCESS);
        getLogger().info(String.format("%n==========   '%s' test completed successfully   ==========%n",
                getTestMethodName()));
    }

    private String getTestMethodName() {
        return testMethodName;
    }

    private Logger getLogger() {
        if (logger == null) {
            logger = LoggerFactory.getLogger("");
        }
        return logger;
    }

    protected void setRequirements(@SuppressWarnings("SameParameterValue") String requirements) {
        this.requirements = requirements;
    }

    long getVerificationCount() {
        return updatedVerificationCount;
    }

    @SuppressWarnings("unused")
    protected class TestSuite {
        public static final String SMOKE = "smoke";             //  Smoke Suite
        public static final String DEBUG = "under_development"; //  Test being developed and/or debugged
        public static final String PRODUCTION = "production";   //  Benign (alters NO source data) executable in Production
        public static final String RELEASE = "release";         //  Test critical to validating Release Readiness
        public static final String SPRINT = "sprint";           //  Validates acceptance criteria for current sprint
        public static final String UNIT = "unit";               //  Unit tests of Software Gauntlet classes
    }

    /**
     * Names of Applications under test
     */
    @SuppressWarnings("unused")
    public class Application {
        public static final String ICE_SCRUM = "ice_scrum";

        //  public final static String APPLICATION_NAME = "[application name]";
    }

    /**
     * Names of Views from applications under test
     */
    @SuppressWarnings("unused")
    public class View {
        public static final String LANDING = "landing";
        public static final String LOGIN_USER_PASS = "login_user_pass";
        public static final String MY_ACCOUNT = "my_account";

        //  public final static String VIEW_NAME = "[view name]";
    }

    /**
     * Names of Databases supporting applications under test
     */
    @SuppressWarnings("unused")
    public class Database {

        //  public final static String DATABASE_NAME = "[database name]";
    }
}
