package com.trp.icescrum.view.landing.region.navbarmenu;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;

public class NavBarPrimaryMenu extends UiRegion implements NavBarPrimaryMenuCalibratable {
    private static final String DESCRIPTION = "'Nav Bar Primary Menu' region";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.ID;
    private static final String LOCATOR_VALUE = "navbar-primary-menu";

    private NavBarPrimaryMenu(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static NavBarPrimaryMenu getInstance(UiElement parent) {
        return new NavBarPrimaryMenu(parent);
    }

    @Override
    public Boolean isLoginDisplayed() {
        return getLoginButtonElement().waitUntilVisible();
    }

    private UiElement getLoginButtonElement() {
        return UiElement.getInstance("'Login' button", UiElement.LocatorType.TAG, "a", "href", "https://www.icescrum.com/my-account/", this.getElement());
    }
}
