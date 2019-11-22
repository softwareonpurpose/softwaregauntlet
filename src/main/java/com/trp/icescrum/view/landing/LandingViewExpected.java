package com.trp.icescrum.view.landing;

import com.trp.icescrum.view.landing.region.navbarmenu.NavBarPrimaryMenuExpected;
import com.trp.icescrum.view.landing.region.hubspotmessages.HubSpotMessagesContainerExpected;

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
    public HubSpotMessagesContainerExpected inOverlay() {
        return HubSpotMessagesContainerExpected.getInstance();
    }
}
