package com.trp.icescrum.view.landing;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.ICE_SCRUM, GauntletTest.View.LANDING})
public class LandingViewTest extends GauntletTest {
    @Test(groups = {TestSuite.EVT})
    public void smoke() {
        setRequirements("US0001|US0002|US0003|US0004");
        LandingViewExpected expected = LandingViewExpected.getInstance();
        LandingView actual = LandingView.directNav();
        then(LandingViewCalibrator.getInstance(expected, actual));
    }
}