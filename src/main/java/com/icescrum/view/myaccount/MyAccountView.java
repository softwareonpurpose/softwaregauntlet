package com.icescrum.view.myaccount;

import com.icescrum.view.myaccount.menu.MyAccountMenu;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;

public class MyAccountView extends UiView implements MyAccountViewCalibratable {
    private static final String VIEW_URI = "https://www.icescrum.com/my-account/";
    private static final String DESCRIPTION = "'My Account' view";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.TAG;
    private static final String LOCATOR_VALUE = "body";

    public MyAccountView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().contains(VIEW_URI);
        confirmed &= this.getElement().waitUntilVisible();
        return confirmed;
    }

    @Override
    public MyAccountMenu inMyAccountMenu() {
        return MyAccountMenu.getInstance(this.getElement());
    }
}
