package com.icescrum.view.landing;

import com.icescrum.view.landing.region.navbarmenu.NavBarPrimaryMenuCalibrator;
import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.web.WebUiRegion;

public class LandingViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Landing' view";
    private final LandingViewExpected expected;
    private final LandingView actual;

    private LandingViewCalibrator(LandingViewExpected expected, LandingView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
        WebUiRegion.suppressConstructionLogging(true);
        addChildCalibrator(NavBarPrimaryMenuCalibrator.getInstance(expected.inNavBarPrimaryMenu(), actual.inNavBarPrimaryMenu()));
        WebUiRegion.suppressConstructionLogging(false);
    }

    public static LandingViewCalibrator getInstance(LandingViewExpected expected, LandingView actual) {
        return new LandingViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Try for free' button exists", expected.isTryForFreeDisplayed(), actual.isTryForFreeDisplayed());
    }
}
