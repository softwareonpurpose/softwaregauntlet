package com.icescrum.view.landing;

import com.icescrum.auth.module.core.widget.HubSpotChatWidget;
import com.icescrum.view.landing.region.navbarmenu.NavBarPrimaryMenu;
import com.softwareonpurpose.gauntlet.Environment;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.uinavigator.UiView;
import com.softwareonpurpose.uinavigator.web.WebUiHost;

public class LandingView extends UiView implements LandingViewCalibratable {
    private static final String VIEW_URI = Environment.getInstance().getDomainUrl();
    private static final String DESCRIPTION = "'Landing' view";
    private static final String LOCATOR_TYPE = UiLocatorType.TAG;
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
        boolean confirmed = WebUiHost.getInstance().getAddress().contains(VIEW_URI);
        confirmed &= this.getElement().waitUntilVisible();
        confirmed &= inNavBarPrimaryMenu().isVisible();
        confirmed &= inNavBarPrimaryMenu().isLoginDisplayed();
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
    public HubSpotChatWidget inHubSpotChatWidget() {
        return HubSpotChatWidget.getInstance(this);
    }

    private UiElement getTryForFreeButtonElement() {
        return UiElement.getInstance("'Try for free' button", UiLocatorType.CLASS, "try-free-button", this.getElement());
    }
}
