package com.aaa.view.insurance.quotes.shortform.ziprouter;

import com.aaa.view.insurance.quotes.shortform.ShortFormView;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import org.softwareonpurpose.gauntlet.Environment;

public class ZipRouterView extends UiView implements ZipRouterViewCalibratable {
    private static final String VIEW_URI = Environment.getInstance().getDomainUrl();
    private static final String DESCRIPTION = "'Zip Router' view";
    private static final String LOCATOR_TYPE = UiLocatorType.CLASS;
    private static final String LOCATOR_VALUE = "zip-modal-open";

    public ZipRouterView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static ZipRouterView directNav() {
        new ZipRouterView().load();
        return UiView.expect(ZipRouterView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    @Override
    public Boolean isGoButtonEnabled() {
        return getGoButtonElement().getAttribute("class").contains("btn-color-blue");
    }

    private UiElement getGoButtonElement() {
        return UiElement.getInstance("'Go' button", UiLocatorType.ID, "goButton", this.getElement());
    }

    private UiElement getZipCodeElement() {
        return UiElement.getInstance("'Zip Code' textbox", UiLocatorType.NAME, "zipCode", this.getElement());
    }

    public ShortFormView submit(String zipCode) {
        getZipCodeElement().set(zipCode);
        getGoButtonElement().click();
        return UiView.expect(ShortFormView.class);
    }

    public ZipRouterView enterZip(String zipCode) {
        getZipCodeElement().set(zipCode);
        return UiView.expect(ZipRouterView.class);
    }
}
