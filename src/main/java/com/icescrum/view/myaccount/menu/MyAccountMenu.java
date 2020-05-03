package com.icescrum.view.myaccount.menu;

import com.icescrum.view.landing.LandingView;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.softwareonpurpose.uinavigator.web.WebUiElement;
import com.softwareonpurpose.uinavigator.web.WebUiRegion;

public class MyAccountMenu extends WebUiRegion implements MyAccountMenuCalibratable {
    private static final String DESCRIPTION = "'My Account' menu";
    private static final String LOCATOR_VALUE = "woocommerce-MyAccount-navigation";
    private static final String LOCATOR_TYPE = UiLocatorType.CLASS;

    protected MyAccountMenu(WebUiElement parent) {
        super(WebUiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static MyAccountMenu getInstance(WebUiElement parent) {
        return new MyAccountMenu(parent);
    }

    public LandingView clickLogout() {
        WebUiElement.getInstance("'Logout' link", UiLocatorType.TAG, "a", getLogoutElement()).click();
        return UiView.expect(LandingView.class);
    }

    private WebUiElement getLogoutElement() {
        return WebUiElement.getInstance("'Logout' item", UiLocatorType.CLASS, "woocommerce-MyAccount-navigation-link--customer-logout", this.getElement());
    }
}
