package com.softwareonpurpose.gauntlet;

import com.softwareonpurpose.gauntlet.anobject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class VerifyCountSingleTestSingleExecParCalibratorTest extends GauntletTest{
    public void verificationCount_singleTestMethodExecution() {
        AnObjectExpected expectedObject = AnObjectExpected.getInstance();
        AnObject actualObject = AnObject.getInstance();
        AParentExpected expectedParent = AParentExpected.getInstance(expectedObject);
        AParent actualParent = AParent.getInstance(actualObject);
        AParentCalibrator calibrator = AParentCalibrator.getInstance(expectedParent, actualParent);
        long expected = 6;
        then(calibrator);
        long actual = getVerificationCount();
        Assert.assertEquals(actual, expected, "FAILED to calculate accurate verification count");
    }
}
