package com.softwareonpurpose.gauntlet;

import com.softwareonpurpose.gauntlet.anobject.AnObject;
import com.softwareonpurpose.gauntlet.anobject.AnObjectCalibrator;
import com.softwareonpurpose.gauntlet.anobject.AnObjectExpected;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups={GauntletTest.TestSuite.UNIT})
public class VerifyCountMultiTestMultiExecNodeCalibratorTest extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios_test1() {
        return new Object[][]{
                {3},
                {6},
                {9}
        };
    }

    @DataProvider
    public static Object[][] scenarios_test2() {
        return new Object[][]{
                {12},
                {15},
                {18}
        };
    }

    @Test(dataProvider = "scenarios_test1")
    public void verificationCount_multipleExecutions_test1(long expected) {
        AnObjectExpected expectedObject = AnObjectExpected.getInstance();
        AnObject actualObject = AnObject.getInstance();
        AnObjectCalibrator calibrator = AnObjectCalibrator.getInstance(expectedObject, actualObject);
        then(calibrator);
        long actual = getVerificationCount();
        Assert.assertEquals(actual, expected, "FAILED to calculate accurate verification count");
    }

    @Test(dataProvider = "scenarios_test2")
    public void verificationCount_multipleExecutions_test2(long expected) {
        AnObjectExpected expectedObject = AnObjectExpected.getInstance();
        AnObject actualObject = AnObject.getInstance();
        AnObjectCalibrator calibrator = AnObjectCalibrator.getInstance(expectedObject, actualObject);
        then(calibrator);
        long actual = getVerificationCount();
        Assert.assertEquals(actual, expected, "FAILED to calculate accurate verification count");
    }
}
