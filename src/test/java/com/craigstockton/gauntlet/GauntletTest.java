package com.craigstockton.gauntlet;

import org.testng.annotations.Test;

@Test
public class GauntletTest extends BaseTest {

    @Test(groups = TestType.DEV)
    public void loggingTest() {
        confirm(".");
    }
}
