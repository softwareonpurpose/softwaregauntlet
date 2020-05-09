package com.icescrum.auth.module.core.view.loginuserpass;

import com.icescrum.view.landing.LandingView;
import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups={GauntletTest.Application.ICE_SCRUM, GauntletTest.View.LOGIN_USER_PASS})
public class LoginUserPassViewTests extends GauntletTest{
    @Test(groups={TestSuite.SMOKE})
    public void smoke(){
        LoginUserPassViewExpected expected = LoginUserPassViewExpected.getInstance();
        LoginUserPassView actual = LandingView.directNav().inNavBarPrimaryMenu().clickLogin();
        then(LoginUserPassViewCalibrator.getInstance(expected, actual));
    }
}
