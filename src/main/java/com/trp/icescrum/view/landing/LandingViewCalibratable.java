package com.trp.icescrum.view.landing;

import com.trp.icescrum.view.landing.region.navbarmenu.NavBarPrimaryMenuCalibratable;
import com.trp.icescrum.view.landing.region.hubspotmessages.HubSpotMessagesContainerCalibratable;

public interface LandingViewCalibratable {
    Boolean isTryForFreeDisplayed();

    NavBarPrimaryMenuCalibratable inNavBarPrimaryMenu();

    HubSpotMessagesContainerCalibratable inOverlay();
}
