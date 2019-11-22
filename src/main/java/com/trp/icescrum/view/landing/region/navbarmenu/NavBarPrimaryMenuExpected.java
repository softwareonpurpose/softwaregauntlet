package com.trp.icescrum.view.landing.region.navbarmenu;

public class NavBarPrimaryMenuExpected implements NavBarPrimaryMenuCalibratable {
    public static NavBarPrimaryMenuExpected getInstance() {
        return new NavBarPrimaryMenuExpected();
    }

    @Override
    public Boolean isLoginDisplayed() {
        return true;
    }

    @Override
    public Boolean isLanguageSwitcherExpanded() {
        return false;
    }
}
