package com.icescrum.view.myaccount.menu;

import com.icescrum.view.landing.LandingView;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.uinavigator.UiView;

public class MyAccountMenu extends UiRegion implements MyAccountMenuCalibratable {
    private static final String DESCRIPTION = "'My Account' menu";
    private static final String LOCATOR_VALUE = "woocommerce-MyAccount-navigation";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.CLASS;

    protected MyAccountMenu(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static MyAccountMenu getInstance(UiElement parent) {
        return new MyAccountMenu(parent);
    }

    public LandingView  clickLogout() {
        UiElement.getInstance("'Logout' link", UiElement.LocatorType.TAG, "a", getLogoutElement()).click();
        return UiView.expect(LandingView.class);
    }

    private UiElement getLogoutElement() {
        return UiElement.getInstance("'Logout' item", UiElement.LocatorType.CLASS, "woocommerce-MyAccount-navigation-link--customer-logout", this.getElement());
    }
}
