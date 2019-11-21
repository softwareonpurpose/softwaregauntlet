package com.softwareonpurpose.gauntlet;

import com.softwareonpurpose.gauntlet.anobject.AnObject;
import com.softwareonpurpose.gauntlet.anobject.AnObjectCalibrator;
import com.softwareonpurpose.gauntlet.anobject.AnObjectExpected;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups={GauntletTest.TestSuite.UNIT})
public class VerifyCountSingleTestSingleExecNodeCalibratorTest extends GauntletTest {
    public void verificationCount_singleTestMethodExecution() {
        AnObjectExpected expectedObject = AnObjectExpected.getInstance();
        AnObject actualObject = AnObject.getInstance();
        AnObjectCalibrator calibrator = AnObjectCalibrator.getInstance(expectedObject, actualObject);
        long expected = 3;
        then(calibrator);
        long actual = getVerificationCount();
        Assert.assertEquals(actual, expected, "FAILED to calculate accurate verification count");
    }
}
