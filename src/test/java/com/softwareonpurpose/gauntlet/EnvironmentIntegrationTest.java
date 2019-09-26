package com.softwareonpurpose.gauntlet;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test(enabled = false)
public class EnvironmentIntegrationTest {
    public void smoke() {
        Environment.clear();
        System.setProperty("env", "integrationtest");
        String expected = "http://bogus.domain.com";
        String actual = Environment.getInstance().getProperty("domain_url");
        Assert.assertEquals(actual, expected, "Failed to load/return expected property");
    }

    public void noEnvironmentSpecified() {
        Environment.clear();
        System.clearProperty("env");
        String expected = null;
        String actual = Environment.getInstance().getProperty("domain_url");
        Assert.assertEquals(actual, expected, "Failed to load/return expected property");
    }
}
