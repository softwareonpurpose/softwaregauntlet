package com.trp.icescrum.view.landing.region.navbarmenu;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class NavBarPrimaryMenuCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Nav Bar Primary Menu' region";
    private final NavBarPrimaryMenuExpected expected;
    private final NavBarPrimaryMenu actual;

    private NavBarPrimaryMenuCalibrator(NavBarPrimaryMenuExpected expected, NavBarPrimaryMenu actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static NavBarPrimaryMenuCalibrator getInstance(NavBarPrimaryMenuExpected expected, NavBarPrimaryMenu actual) {
        return new NavBarPrimaryMenuCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Is 'Login' button displayed", expected.isLoginDisplayed(), actual.isLoginDisplayed());
        verify("Is 'Language Switcher' expanded", expected.isLanguageSwitcherExpanded(), actual.isLanguageSwitcherExpanded());
    }
}
