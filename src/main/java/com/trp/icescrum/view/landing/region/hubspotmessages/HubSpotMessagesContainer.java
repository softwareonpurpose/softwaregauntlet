package com.trp.icescrum.view.landing.region.hubspotmessages;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class HubSpotMessagesContainer extends UiRegion implements HubSpotMessagesContainerCalibratable {
    private static final String DESCRIPTION = "'HubSpot Messages' region";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.ID;
    private static final String LOCATOR_VALUE = "hubspot-messages-iframe-container";

    private HubSpotMessagesContainer(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static HubSpotMessagesContainer getInstance(UiElement parent) {
        return new HubSpotMessagesContainer(parent);
    }

    @Override
    public Boolean isHubSpotMessagesButtonDisplayed() {
        return getWidgetLauncherButtonElement().waitUntilVisible();
    }

    @Override
    public Boolean isInitialMessageBubbleDisplayed() {
        return getInitialMessageBubbleElement().waitUntilVisible();
    }

    private UiElement getInitialMessageBubbleElement() {
        return UiElement.getInstance("'Initial Message' bubble", UiElement.LocatorType.TAG, "div", "aria-label", "Hey! Thanks for stopping by! Got any questions? We are happy to help :)", this.getElement());
    }

    private UiElement getWidgetLauncherButtonElement() {
        return UiElement.getInstance("'Widget Launcher Button", UiElement.LocatorType.TAG, "button", "class", "widget-launcher", this.getElement());
    }
}
