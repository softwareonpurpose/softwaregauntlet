package com.trp.icescrum.view.landing;

import com.trp.icescrum.view.landing.region.navbarmenu.NavBarPrimaryMenuExpected;

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
    public Boolean isHubSpotMessagesButtonDisplayed() {
        return true;
    }
}
