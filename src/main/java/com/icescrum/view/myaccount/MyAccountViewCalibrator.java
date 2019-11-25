package com.icescrum.view.myaccount;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class MyAccountViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'My Account' view";

    protected MyAccountViewCalibrator(MyAccountViewExpected expected, MyAccountView actual) {
        super(DESCRIPTION, expected, actual);
    }

    public static MyAccountViewCalibrator getInstance(MyAccountViewExpected expected, MyAccountView actual) {
        return new MyAccountViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
