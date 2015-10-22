/*Copyright 2015 Craig A. Stockton

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

import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.validator4test.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class GauntletTest {

    private final String className;
    private Logger logger;
    private String testMethodName;
    private static final int oneSecond = 1000;
    private static final int oneMinute = oneSecond * 60;
    protected static final int defaultTimeout = oneMinute * 1;  //  move the multiplier to a properties file

    protected GauntletTest() {
        this.className = this.getClass().toString().replace("class ", "");
    }

    protected class TestType {

        public static final String EVT = "evt";                 //  Environment Validation Test
        public static final String DEV = "under_development";   //  Test being developed and/or debugged
        public static final String PRODUCTION = "production";   //  Benign (alters NO source data) test executable in Production
        public static final String RELEASE = "release";         //  Test critical to validating Release Readiness
        public static final String SPRINT = "sprint";           //  Test verifying acceptance criteria for current sprint
    }

    /**
     * Names of Applications under test
     */
    public class Application {

        //  public final static String APPLICATION_NAME = "[application name]";
    }

    /**
     * Names of Views from applications under test
     */
    public class View {

        //  public final static String VIEW_NAME = "[view name]";
    }

    /**
     * Names of Databases supporting applications under test
     */
    public class Database {

        //  public final static String DATABASE_NAME = "[database name]";
    }

    /**
     * Validation targets
     */
    public class Validatee {

        public static final String VIEW = "view";
        public static final String DATA_ENTITY = "[data_entity_name]";
    }

    @BeforeMethod(alwaysRun = true)
    public void beginExecution(Method method) {
        testMethodName = method.getName();
        getLogger().info(String.format("EXECUTING %s - %s...", getTestClass(), getTestMethodName()));
        getLogger().info("STEPS:");
    }

    @AfterMethod(alwaysRun = true)
    public void terminateExecution() {
        getLogger().info(String.format("TERMINATING %s - %s%n", getTestClass(), getTestMethodName()));
        UiHost.quitInstance();
    }

    protected void confirm(String testResult) {
        Assert.assertTrue(testResult.equals(Validator.PASS), testResult);
        getLogger().info(String.format("%n==========   '%s' test completed successfully   ==========%n", getTestMethodName()));
    }

    private String getTestMethodName() {
        return testMethodName;
    }

    private Logger getLogger() {
        if (logger == null) {
            logger = LogManager.getLogger(getTestClass());
        }
        return logger;
    }

    private String getTestClass() {
        return className;
    }

}
