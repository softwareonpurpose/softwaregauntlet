package com.icescrum.auth.module.core.view.loginuserpass;

import com.icescrum.auth.module.core.data.user.User;
import com.icescrum.view.myaccount.MyAccountView;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.softwareonpurpose.uinavigator.web.WebUiElement;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import com.softwareonpurpose.uinavigator.web.WebUiView;

public class LoginUserPassView extends WebUiView implements LoginUserPassViewCalibratable {
    private static final String URI_VIEW = "https://www.icescrum.com/auth/module.php/core/loginuserpass.php";
    private static final String DESCRIPTION = "'Login User Pass' view";
    private static final String LOCATOR_TYPE = UiLocatorType.TAG;
    private static final String LOCATOR_VALUE = "body";

    public LoginUserPassView() {
        super(URI_VIEW, WebUiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    @Override
    protected boolean confirmElementStates() {
        boolean confirmed = WebUiHost.getInstance().getUri().contains(URI_VIEW);
        confirmed &= this.getElement().waitUntilVisible();
        return confirmed;
    }

    public MyAccountView login(User user) {
        getUsernameElement().set(user.getUsername());
        getPasswordElement().set(user.getPassword());
        getLoginButtonElement().click();
        return UiView.expect(MyAccountView.class);
    }

    private WebUiElement getUsernameElement() {
        return WebUiElement.getInstance("'Username' field", UiLocatorType.ID, "username", this.getElement());
    }

    private WebUiElement getPasswordElement() {
        return WebUiElement.getInstance("'Password' field", UiLocatorType.ID, "user_pass", this.getElement());
    }

    private WebUiElement getLoginButtonElement() {
        return WebUiElement.getInstance("'Login' button", UiLocatorType.NAME, "login", this.getElement());
    }
}
