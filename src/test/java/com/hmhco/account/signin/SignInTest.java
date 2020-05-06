package com.hmhco.account.signin;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.HMHCO, GauntletTest.View.SIGN_IN})
public class SignInTest extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE, TestSuite.DEBUG})
    public void smoke() {
        setRequirements("US-0001");
        SignInExpected expected = SignInExpected.getInstance();
        SignIn actual = SignIn.directNav();
        then(SignInCalibrator.getInstance(expected, actual));
    }
}
