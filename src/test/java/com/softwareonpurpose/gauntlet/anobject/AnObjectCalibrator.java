package com.softwareonpurpose.gauntlet.anobject;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class AnObjectCalibrator extends Calibrator {
    private static final String DESCRIPTION = "An Object";
    private final AnObjectExpected expected;
    private final AnObject actual;

    protected AnObjectCalibrator(AnObjectExpected expected, AnObject actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static AnObjectCalibrator getInstance(AnObjectExpected expected, AnObject actual) {
        return new AnObjectCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("String", expected.getString(), actual.getString());
        verify("Integer", expected.getInteger(), actual.getInteger());
        verify("Boolean", expected.getBoolean(), actual.getBoolean());
    }
}
