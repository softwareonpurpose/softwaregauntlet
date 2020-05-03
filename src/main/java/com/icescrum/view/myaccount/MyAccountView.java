package com.icescrum.view.myaccount;


import com.icescrum.view.myaccount.menu.MyAccountMenu;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.web.WebUiElement;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import com.softwareonpurpose.uinavigator.web.WebUiView;

public class MyAccountView extends WebUiView implements MyAccountViewCalibratable {
    private static final String VIEW_URI = "https://www.icescrum.com/my-account/";
    private static final String DESCRIPTION = "'My Account' view";
    private static final String LOCATOR_TYPE = UiLocatorType.TAG;
    private static final String LOCATOR_VALUE = "body";

    public MyAccountView() {
        super(VIEW_URI, WebUiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = WebUiHost.getInstance().getUri().contains(VIEW_URI);
        confirmed &= this.getElement().waitUntilVisible();
        return confirmed;
    }

    @Override
    public MyAccountMenu inMyAccountMenu() {
        return MyAccountMenu.getInstance(this.getElement());
    }
}
