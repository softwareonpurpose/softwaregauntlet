package com.softwareonpurpose.gauntlet;

import com.softwareonpurpose.gauntlet.anobject.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(enabled = true)
public class VerifyCountSingleTestMultiExecParCalibratorTest extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {6},
                {12},
                {18}
        };
    }

    @Test(enabled = true, dataProvider = "scenarios")
    public void verificationCount_multipleExecutions(long expected) {
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
