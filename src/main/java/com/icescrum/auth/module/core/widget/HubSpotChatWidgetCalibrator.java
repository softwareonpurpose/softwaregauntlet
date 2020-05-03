package com.icescrum.auth.module.core.widget;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class HubSpotChatWidgetCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'HubSpot Chat' widget";

    protected HubSpotChatWidgetCalibrator(HubSpotChatWidgetExpected expected, HubSpotChatWidget actual) {
        super(DESCRIPTION, expected, actual);
    }

    public static HubSpotChatWidgetCalibrator getInstance(HubSpotChatWidgetExpected expected, HubSpotChatWidget actual) {
        return new HubSpotChatWidgetCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
