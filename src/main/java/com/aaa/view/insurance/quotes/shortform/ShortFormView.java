package com.aaa.view.insurance.quotes.shortform;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;

public class ShortFormView extends UiView implements ShortFormViewCalibratable {
    private static final String DESCRIPTION = "'Short Form' view";
    private static final String VIEW_URI = "https://appuat1.ace.aaa.com/insurance/quotes/shortform";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "insurance-products-form";

    public ShortFormView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }
}
