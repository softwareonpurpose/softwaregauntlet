package com.softwareonpurpose.gauntlet.environment;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class EnvironmentTest {
    @Test
    public void getInstanceNullEnvironmentVariable() {
        Environment expected = null;
        Environment actual = null;
        try {
            actual = Environment.getInstance();
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), NullPointerException.class, "Expected 'Null Pointer' exception");
            e.printStackTrace();
        }
        //noinspection ConstantConditions
        Assert.assertEquals(actual, expected, "Expected Environment.getInstance() to return NULL");
    }
}
