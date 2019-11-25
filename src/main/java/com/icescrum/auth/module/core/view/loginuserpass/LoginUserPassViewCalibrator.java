package com.icescrum.auth.module.core.view.loginuserpass;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class LoginUserPassViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Login User Pass' view";

    protected LoginUserPassViewCalibrator(LoginUserPassViewExpected expected, LoginUserPassView actual) {
        super(DESCRIPTION, expected, actual);
    }

    public static LoginUserPassViewCalibrator getInstance(LoginUserPassViewExpected expected, LoginUserPassView actual) {
        return new LoginUserPassViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
