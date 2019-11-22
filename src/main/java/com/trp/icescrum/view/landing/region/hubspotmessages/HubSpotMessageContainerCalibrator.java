package com.trp.icescrum.view.landing.region.hubspotmessages;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class HubSpotMessageContainerCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Landing Overlay' region";
    private final HubSpotMessagesContainerExpected expected;
    private final HubSpotMessagesContainer actual;

    private HubSpotMessageContainerCalibrator(HubSpotMessagesContainerExpected expected, HubSpotMessagesContainer actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static HubSpotMessageContainerCalibrator getInstance(HubSpotMessagesContainerExpected expected, HubSpotMessagesContainer actual) {
        return new HubSpotMessageContainerCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Initial Message' bubble displayed", expected.isInitialMessageBubbleDisplayed(), actual.isInitialMessageBubbleDisplayed());
        verify("'HubSpot Widget' launcher displayed", expected.isHubSpotMessagesButtonDisplayed(), actual.isHubSpotMessagesButtonDisplayed());
    }
}
