package com.softwareonpurpose.gauntlet;

import com.softwareonpurpose.gauntlet.anobject.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(enabled = false)
public class VerifyCountMultiTestMultiExecParCalibratorTest extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios_test1() {
        return new Object[][]{
                {6},
                {12},
                {18}
        };
    }

    @DataProvider
    public static Object[][] scenarios_test2() {
        return new Object[][]{
                {24},
                {30},
                {36}
        };
    }

    @Test(enabled = false, dataProvider = "scenarios_test1")
    public void verificationCount_multipleExecutionsTest1(long expected) {
        AnObjectExpected expectedObject = AnObjectExpected.getInstance();
        AnObject actualObject = AnObject.getInstance();
        AParentExpected expectedParent = AParentExpected.getInstance(expectedObject);
        AParent actualParent = AParent.getInstance(actualObject);
        AParentCalibrator calibrator = AParentCalibrator.getInstance(expectedParent, actualParent);
        then(calibrator);
        long actual = getVerificationCount();
        Assert.assertEquals(actual, expected, "FAILED to calculate accurate verification count");
    }

    @Test(enabled = false, dataProvider = "scenarios_test2")
    public void verificationCount_multipleExecutionsTest2(long expected) {
        AnObjectExpected expectedObject = AnObjectExpected.getInstance();
        AnObject actualObject = AnObject.getInstance();
        AParentExpected expectedParent = AParentExpected.getInstance(expectedObject);
        AParent actualParent = AParent.getInstance(actualObject);
        AParentCalibrator calibrator = AParentCalibrator.getInstance(expectedParent, actualParent);
        then(calibrator);
        long actual = getVerificationCount();
        Assert.assertEquals(actual, expected, "FAILED to calculate accurate verification count");
    }
}
