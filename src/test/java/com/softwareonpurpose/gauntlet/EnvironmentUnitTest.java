package com.softwareonpurpose.gauntlet;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Test(groups={GauntletTest.TestSuite.UNIT})
public class EnvironmentUnitTest {
    public void getKeyFromUninitializedEnvironment() {
        String expected = null;
        InputStream inputStream = new ByteArrayInputStream("".getBytes());
        String actual = new Environment(inputStream).getProperty("actual_property");
        //noinspection ConstantConditions
        Assert.assertEquals(actual, expected, "Expected Environment.getInstance() to return NULL");
    }

    public void getKeyFromInitializedEnvironment() {
        String expected = "actual value";
        InputStream inputStream = new ByteArrayInputStream("actual_property=actual value".getBytes());
        String actual = new Environment(inputStream).getProperty("actual_property");
        Assert.assertEquals(actual, expected, "Expected Environment.getInstance() to return NULL");
    }
}
