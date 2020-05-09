package com.icescrum.view.landing.region.hubspotmessages;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;

public class HubSpotMessagesContainer extends UiRegion implements HubSpotMessagesContainerCalibratable {
    private static final String DESCRIPTION = "'HubSpot Messages' region";
    private static final String LOCATOR_TYPE = UiLocatorType.TAG;
    private static final String LOCATOR_VALUE = "iframe";

    private HubSpotMessagesContainer(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static HubSpotMessagesContainer getInstance(UiElement parent) {
        return new HubSpotMessagesContainer(parent);
    }

    @Override
    public Boolean isInitialMessageBubbleDisplayed() {
        return getInitialMessageBubbleElement().waitUntilVisible();
    }

    private UiElement getInitialMessageBubbleElement() {
        return UiElement.getInstance("'Initial Message' bubble", UiLocatorType.CLASS, "widget", this.getElement());
    }
}
