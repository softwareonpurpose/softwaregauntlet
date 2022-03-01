package org.aaa.view.insurance.quotes.shortform;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ZipRouterViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Zip Router' view";
    private final ZipRouterViewExpected expected;
    private final ZipRouterView actual;

    protected ZipRouterViewCalibrator(ZipRouterViewExpected expected, ZipRouterView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ZipRouterViewCalibrator getInstance(ZipRouterViewExpected expected, ZipRouterView actual) {
        return new ZipRouterViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Is 'Go' button enabled", expected.isGoButtonEnabled(), actual.isGoButtonEnabled());
    }
}
