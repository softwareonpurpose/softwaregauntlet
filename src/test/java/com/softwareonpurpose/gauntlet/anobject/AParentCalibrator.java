package com.softwareonpurpose.gauntlet.anobject;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class AParentCalibrator extends Calibrator {
    private static final String DESCRIPTION = "A Parent";
    private final AParentExpected expected;
    private final AParent actual;

    private AParentCalibrator(AParentExpected expected, AParent actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
        addChildCalibrator(AnObjectCalibrator.getInstance(expected.getChildObject(), actual.getChildObject()));
    }

    public static AParentCalibrator getInstance(AParentExpected expected, AParent actual) {
        return new AParentCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("String", expected.getString(), actual.getString());
        verify("Integer", expected.getInteger(), actual.getInteger());
        verify("Boolean", expected.getBoolean(), actual.getBoolean());
    }
}
