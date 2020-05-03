package com.icescrum.auth.module.core.widget;

import com.icescrum.view.landing.LandingView;
import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test
public class HubSpotChatTests extends GauntletTest {
    @Test
    public void smoke(){
        HubSpotChatWidgetExpected expected = HubSpotChatWidgetExpected.getInstance();
        HubSpotChatWidget actual = LandingView.directNav().inHubSpotChatWidget();
        then(HubSpotChatWidgetCalibrator.getInstance(expected, actual));
    }
}
