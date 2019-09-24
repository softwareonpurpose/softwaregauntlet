package com.softwareonpurpose.gauntlet;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Test
public class EnvironmentUnitTest {
    @Test
    public void getKeyFromUninitializedEnvironment() {
        String expected = null;
        InputStream inputStream = new ByteArrayInputStream("".getBytes());
        String actual = new Environment(inputStream).getProperty("actual_property");
        //noinspection ConstantConditions
        Assert.assertEquals(actual, expected, "Expected Environment.getInstance() to return NULL");
    }

    @Test
    public void getKeyFromInitializedEnvironment() {
        String expected = "actual value";
        InputStream inputStream = new ByteArrayInputStream("actual_property=actual value".getBytes());
        String actual = new Environment(inputStream).getProperty("actual_property");
        Assert.assertEquals(actual, expected, "Expected Environment.getInstance() to return NULL");
    }
}
