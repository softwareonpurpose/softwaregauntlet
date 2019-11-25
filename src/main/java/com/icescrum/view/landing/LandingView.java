package com.icescrum.view.landing;

import com.icescrum.view.landing.region.hubspotmessages.HubSpotMessagesContainer;
import com.icescrum.view.landing.region.navbarmenu.NavBarPrimaryMenu;
import com.softwareonpurpose.gauntlet.Environment;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.uinavigator.UiView;

public class LandingView extends UiView implements LandingViewCalibratable {
    private static final String VIEW_URI = Environment.getInstance().getDomainUrl();
    private static final String DESCRIPTION = "'Landing' view";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.TAG;
    private static final String LOCATOR_VALUE = "body";

    @SuppressWarnings("WeakerAccess")
    public LandingView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static LandingView directNav() {
        new LandingView().load();
        return UiView.expect(LandingView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        UiRegion.suppressConstructionLogging(true);
        boolean confirmed = UiHost.getInstance().getUri().contains(VIEW_URI);
        confirmed &= this.getElement().waitUntilVisible();
        confirmed &= inNavBarPrimaryMenu().isVisible();
        confirmed &= inNavBarPrimaryMenu().isLoginDisplayed();
        confirmed &= inHubSpotMessageContainer().isVisible();
        UiRegion.suppressConstructionLogging(false);
        return confirmed;
    }

    @Override
    public Boolean isTryForFreeDisplayed() {
        return getTryForFreeButtonElement().waitUntilVisible();
    }

    @Override
    public NavBarPrimaryMenu inNavBarPrimaryMenu() {
        return NavBarPrimaryMenu.getInstance(this.getElement());
    }

    @Override
    public HubSpotMessagesContainer inHubSpotMessageContainer() {
        return HubSpotMessagesContainer.getInstance(this.getElement());
    }

    private UiElement getTryForFreeButtonElement() {
        return UiElement.getInstance("'Try for free' button", UiElement.LocatorType.CLASS, "try-free-button", this.getElement());
    }
}
