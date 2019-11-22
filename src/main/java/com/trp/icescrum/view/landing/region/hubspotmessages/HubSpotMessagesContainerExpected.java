package com.trp.icescrum.view.landing.region.hubspotmessages;

public class HubSpotMessagesContainerExpected implements HubSpotMessagesContainerCalibratable {
    public static HubSpotMessagesContainerExpected getInstance() {
        return new HubSpotMessagesContainerExpected();
    }

    @Override
    public Boolean isHubSpotMessagesButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isInitialMessageBubbleDisplayed() {
        return true;
    }
}
