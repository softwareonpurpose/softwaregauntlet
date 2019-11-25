package com.icescrum.auth.module.core.view.loginuserpass;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiHost;
import com.softwareonpurpose.uinavigator.UiView;

public class LoginUserPassView extends UiView implements LoginUserPassViewCalibratable {
    private static final String URI_VIEW = "https://www.icescrum.com/auth/module.php/core/loginuserpass.php";
    private static final String DESCRIPTION = "'Login User Pass' view";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.TAG;
    private static final String LOCATOR_VALUE = "body";

    public LoginUserPassView() {
        super(URI_VIEW, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = UiHost.getInstance().getUri().contains(URI_VIEW);
        confirmed &= this.getElement().waitUntilVisible();
        return confirmed;
    }
}
