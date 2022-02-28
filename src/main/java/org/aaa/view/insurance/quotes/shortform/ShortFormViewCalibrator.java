package org.aaa.view.insurance.quotes.shortform;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ShortFormViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Welcome' view";

    protected ShortFormViewCalibrator(ShortFormViewExpected expected, ShortFormView actual) {
        super(DESCRIPTION, expected, actual);
    }

    public static ShortFormViewCalibrator getInstance(ShortFormViewExpected expected, ShortFormView actual) {
        return new ShortFormViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
