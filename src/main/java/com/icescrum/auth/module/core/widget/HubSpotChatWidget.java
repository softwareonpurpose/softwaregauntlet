package com.icescrum.auth.module.core.widget;

import com.icescrum.view.landing.LandingView;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;

public class HubSpotChatWidget extends UiView implements HubSpotChatWidgetCalibratable {
    private static final String DESCRIPTION = "'HotSpot Chat' widget";
    private static final String LOCATOR_TYPE = UiLocatorType.TAG;
    private static final String LOCATOR_VALUE = "iframe";

    protected HubSpotChatWidget(UiView parentView) {
        super(parentView.getAddress(), UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static HubSpotChatWidget getInstance(LandingView parentView) {
        return new HubSpotChatWidget(parentView);
    }

    @Override
    protected boolean confirmElementStates() {
        return false;
    }
}
