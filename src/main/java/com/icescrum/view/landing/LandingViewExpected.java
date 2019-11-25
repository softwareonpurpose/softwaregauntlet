package com.icescrum.view.landing;

import com.icescrum.view.landing.region.hubspotmessages.HubSpotMessagesContainerExpected;
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
    public HubSpotMessagesContainerExpected inHubSpotMessageContainer() {
        return HubSpotMessagesContainerExpected.getInstance();
    }
}
