package com.aaa.view.insurance.quotes.shortform.contact;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;

public class ContactView extends UiView implements ContactViewCalibratable  {
    private static final String VIEW_URI = "https://appuat1.ace.aaa.com/insurance/quotes/shortform/contact";
    private static final String DESCRIPTION = "'Contact' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "root";

    public ContactView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }
}
