package com.hmhco.account.signin;

import com.softwareonpurpose.gauntlet.Environment;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiView;

public class SignIn extends UiView implements SignInCalibratable {
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String VIEW_URI = String.format("%s/%s", DOMAIN_URL, "account/sign-in");
    private static final String DESCRIPTION = "'Sign In' view";
    private static final String LOCATOR_TYPE = UiElement.LocatorType.ID;
    private static final String LOCATOR_VALUE = "bdyMaster";

    public SignIn() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static SignIn directNav() {
        SignIn view = new SignIn();
        view.load();
        return UiView.expect(SignIn.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return getElement().isDisplayed();
    }
}
