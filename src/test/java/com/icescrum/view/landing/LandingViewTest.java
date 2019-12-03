package com.icescrum.view.landing;

import com.icescrum.auth.module.core.data.user.User;
import com.icescrum.auth.module.core.data.user.UserProvider;
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

    @Test(groups = {TestSuite.RELEASE}, dependsOnGroups = {TestSuite.EVT})
    public void logout() {
        LandingViewExpected expected = LandingViewExpected.getInstance();
        User user = UserProvider.getInstance().get();
        LandingView actual = LandingView.directNav().inNavBarPrimaryMenu().clickLogin().login(user).inMyAccountMenu().clickLogout();
        then(LandingViewCalibrator.getInstance(expected, actual));
    }
}