package com.aaa.view.insurance.quotes.shortform.contact;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ContactViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Contact' view";

    protected ContactViewCalibrator(ContactViewExpected expected, ContactView actual) {
        super(DESCRIPTION, expected, actual);
    }

    public static ContactViewCalibrator getInstance(ContactViewExpected expected, ContactView actual) {
        return new ContactViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
