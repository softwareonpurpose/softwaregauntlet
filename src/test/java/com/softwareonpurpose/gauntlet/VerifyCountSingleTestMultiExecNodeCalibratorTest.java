package com.softwareonpurpose.gauntlet;

import com.softwareonpurpose.gauntlet.anobject.AnObject;
import com.softwareonpurpose.gauntlet.anobject.AnObjectCalibrator;
import com.softwareonpurpose.gauntlet.anobject.AnObjectExpected;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(enabled = false)
public class VerifyCountSingleTestMultiExecNodeCalibratorTest extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {3},
                {6},
                {9}
        };
    }

    @Test(enabled = false, dataProvider = "scenarios")
    public void verificationCount_multipleExecutions(long expected) {
        AnObjectExpected expectedObject = AnObjectExpected.getInstance();
        AnObject actualObject = AnObject.getInstance();
        AnObjectCalibrator calibrator = AnObjectCalibrator.getInstance(expectedObject, actualObject);
        then(calibrator);
        long actual = getVerificationCount();
        Assert.assertEquals(actual, expected, "FAILED to calculate accurate verification count");
    }
}
