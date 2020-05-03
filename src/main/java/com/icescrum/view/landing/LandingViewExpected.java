package com.icescrum.view.landing;

import com.icescrum.auth.module.core.widget.HubSpotChatWidgetExpected;
import com.icescrum.view.landing.region.navbarmenu.NavBarPrimaryMenuExpected;

public class LandingViewExpected implements LandingViewCalibratable {
    public static LandingViewExpected getInstance() {
        return new LandingViewExpected();
    }

    @Override
    public Boolean isTryForFreeDisplayed() {
        return true;
    }

    @Override
    public NavBarPrimaryMenuExpected inNavBarPrimaryMenu() {
        return NavBarPrimaryMenuExpected.getInstance();
    }

    @Override
    public HubSpotChatWidgetExpected inHubSpotChatWidget() {
        return HubSpotChatWidgetExpected.getInstance();
    }
}
