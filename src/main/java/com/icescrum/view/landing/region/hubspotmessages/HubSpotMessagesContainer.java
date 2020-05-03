package com.icescrum.view.landing.region.hubspotmessages;

import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.web.WebUiElement;
import com.softwareonpurpose.uinavigator.web.WebUiRegion;

public class HubSpotMessagesContainer extends WebUiRegion implements HubSpotMessagesContainerCalibratable {
    private static final String DESCRIPTION = "'HubSpot Messages' region";
    private static final String LOCATOR_TYPE = UiLocatorType.TAG;
    private static final String LOCATOR_VALUE = "iframe";

    private HubSpotMessagesContainer(WebUiElement parent) {
        super(WebUiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static HubSpotMessagesContainer getInstance(WebUiElement parent) {
        return new HubSpotMessagesContainer(parent);
    }

    @Override
    public Boolean isInitialMessageBubbleDisplayed() {
        return getInitialMessageBubbleElement().waitUntilVisible();
    }

    private WebUiElement getInitialMessageBubbleElement() {
        return WebUiElement.getInstance("'Initial Message' bubble", UiLocatorType.CLASS, "widget",  this.getElement());
    }
}
