package com.hmhco.account.signin;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class SignInCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Sign In' view";

    private SignInCalibrator(SignInExpected expected, SignIn actual) {
        super(DESCRIPTION, expected, actual);
    }

    public static SignInCalibrator getInstance(SignInExpected expected, SignIn actual) {
        return new SignInCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
