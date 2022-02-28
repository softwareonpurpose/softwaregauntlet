package org.aaa.view.insurance.quotes.shortform;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;

public class ShortFormView extends UiView implements ShortFormViewCalibratable {
    private static final String DESCRIPTION = "'Welcome' view";
    private static final String LOCATOR_TYPE = UiLocatorType.CLASS;
    private static final String LOCATOR_VALUE = "zip-modal-content";
    private static final String VIEW_URI = "https://appuat1.ace.aaa.com/insurance/quotes/shortform";

    public ShortFormView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static ShortFormView directNav() {
        new ShortFormView().load();
        return UiView.expect(ShortFormView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return false;
    }
}
