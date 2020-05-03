package com.icescrum.view.landing;

import com.icescrum.auth.module.core.widget.HubSpotChatWidgetCalibratable;
import com.icescrum.view.landing.region.navbarmenu.NavBarPrimaryMenuCalibratable;

public interface LandingViewCalibratable {
    Boolean isTryForFreeDisplayed();

    NavBarPrimaryMenuCalibratable inNavBarPrimaryMenu();

    HubSpotChatWidgetCalibratable inHubSpotChatWidget();
}
