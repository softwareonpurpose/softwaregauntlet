package com.icescrum.view.landing;

import com.icescrum.view.landing.region.navbarmenu.NavBarPrimaryMenuCalibratable;
import com.icescrum.view.landing.region.hubspotmessages.HubSpotMessagesContainerCalibratable;

public interface LandingViewCalibratable {
    Boolean isTryForFreeDisplayed();

    NavBarPrimaryMenuCalibratable inNavBarPrimaryMenu();

    HubSpotMessagesContainerCalibratable inHubSpotMessageContainer();
}
