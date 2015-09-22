package com.craigstockton.gauntlet;

import com.craigstockton.uinavigator.UiHost;
import com.craigstockton.validator4test.Validator;
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

    public class TestType {

        public static final String EVT = "evt";                 //  Environment Validation Test
        public static final String DEV = "under_development";   //  Test being developed and/or debugged
        public static final String PRODUCTION = "production";   //  Benign (alters NO source data) test executable in Production
        public static final String RELEASE = "rvt";             //  Test critical to validating Release Readiness
        public static final String SPRINT = "sprint";           //  Test verifying acceptance criteria for current sprint
    }

    /**
     * Names of Applications under test
     */
    public class Application {

        //  protected final static String APPLICATION_NAME = "[application name]";
    }

    /**
     * Names of Views from applications under test
     */
    public class View {

        //  protected final static String VIEW_NAME = "[view name]";
    }

    /**
     * Names of Databases supporting applications under test
     */
    public class Database {

        //  protected final static String DATABASE_NAME = "[database name]";
    }

    /**
     * Names of database Tables
     */
    public class Table {

        //  protected static final String TABLE_NAME = "[table name]";
    }

    public class Validatee {

        protected static final String VIEW = "view";
        protected static final String DATA = "data";
    }

    @BeforeMethod(alwaysRun = true)
    public void beginExecution(Method method) {
        testMethodName = method.getName();
        getLogger().info(String.format("EXECUTING %s - %s...", getTestClass(), testMethodName));
        getLogger().info("STEPS:");
    }

    @AfterMethod(alwaysRun = true)
    public void terminateExecution() {
        getLogger().info(String.format("TERMINATING %s - %s%n", getTestClass(), testMethodName));
        UiHost.quitInstance();
    }

    public static UiHost getUiHost() {
        return UiHost.getInstance();
    }

    protected void confirm(String testResult) {
        Assert.assertTrue(testResult.equals(Validator.PASS), testResult);
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
