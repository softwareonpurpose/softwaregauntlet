package com.icescrum.view.myaccount;

import com.icescrum.auth.module.core.data.user.User;
import com.icescrum.auth.module.core.data.user.UserDefinition;
import com.icescrum.auth.module.core.data.user.UserProvider;
import com.icescrum.view.landing.LandingView;
import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups={GauntletTest.Application.ICE_SCRUM, GauntletTest.View.MY_ACCOUNT})
public class MyAccountViewTest extends GauntletTest{
    @Test(groups={TestSuite.EVT})
    public void smoke(){
        UserDefinition userDefinition = UserDefinition.getInstance();
        User user = UserProvider.getInstance().get(userDefinition);
        MyAccountViewExpected expected = MyAccountViewExpected.getInstance();
        MyAccountView actual = LandingView.directNav().inNavBarPrimaryMenu().clickLogin().login(user);
        then(MyAccountViewCalibrator.getInstance(expected, actual));
    }
}
