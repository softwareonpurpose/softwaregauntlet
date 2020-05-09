package com.icescrum.view.landing.region.navbarmenu;

import com.icescrum.auth.module.core.view.loginuserpass.LoginUserPassView;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.uinavigator.UiView;

public class NavBarPrimaryMenu extends UiRegion implements NavBarPrimaryMenuCalibratable {
    private static final String DESCRIPTION = "'Nav Bar Primary Menu' region";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
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

    @Override
    public Boolean isLanguageSwitcherExpanded() {
        return "true".equals(UiElement.getInstance("'Language' switcher", UiLocatorType.CLASS, "language-switcher", this.getElement()).getAttribute("aria-expanded"));
    }

    private UiElement getLoginButtonElement() {
        return UiElement.getInstance("'Login' button", UiLocatorType.TAG, "a", "href", "https://www.icescrum.com/my-account/", this.getElement());
    }

    public LoginUserPassView clickLogin() {
        getLoginButtonElement().click();
        return UiView.expect(LoginUserPassView.class);
    }
}
