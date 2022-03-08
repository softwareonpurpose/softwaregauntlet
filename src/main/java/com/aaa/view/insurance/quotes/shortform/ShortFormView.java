package com.aaa.view.insurance.quotes.shortform;

import com.aaa.view.insurance.quotes.data.user.ShortFormUser;
import com.aaa.view.insurance.quotes.data.user.ShortFormUserCalibratable;
import com.aaa.view.insurance.quotes.shortform.contact.ContactView;
import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import org.softwareonpurpose.gauntlet.Environment;

public class ShortFormView extends UiView implements ShortFormViewCalibratable {
    private static final String DESCRIPTION = "'Short Form' view";
    private static final String VIEW_URI = Environment.getInstance().getDomainUrl();
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "insurance-products-form";

    public ShortFormView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    public ShortFormView setCurrentlyInsured(boolean isInsured) {
        if (isInsured) {
            getCurrentlyInsuredYesElement().click();
        } else {
            getCurrentlyInsuredNoElement().click();
        }
        return UiView.expect(ShortFormView.class);
    }

    private UiElement getCurrentlyInsuredNoElement() {
        String description = "'Currently Ensured - no' radio";
        String classValue = "Radio";
        String attribute = "data-quid";
        String attributeValue = "RadioItem-no";
        return UiElement.getInstance(description, UiLocatorType.CLASS, classValue, attribute, attributeValue, this.getElement());
    }

    private UiElement getCurrentlyInsuredYesElement() {
        String description = "'Currently Ensured - yes' radio";
        String classValue = "Radio";
        String attribute = "data-quid";
        String attributeValue = "RadioItem-yes";
        return UiElement.getInstance(description, UiLocatorType.CLASS, classValue, attribute, attributeValue, this.getElement());
    }

    public ShortFormView setInsuranceType(String insuranceType) {
        UiElement.getInstance("'Universal Life' checkbox", UiLocatorType.ID, "12", this.getElement()).click();
        return UiView.expect(ShortFormView.class);
    }

    public ContactView clickNext() {
        getNextButtonElement().click();
        return UiView.expect(ContactView.class);
    }

    private UiElement getNextButtonElement() {
        return UiElement.getInstance("'Next' button", UiLocatorType.CLASS, "Button", "data-quid", "continue", this.getElement());
    }

    public ContactView submit(ShortFormUserCalibratable shortFormUser) {
        setInsuranceType(shortFormUser.getType());
        setCurrentlyInsured(shortFormUser.isCurrentlyInsured());
        clickNext();
        return UiView.expect(ContactView.class);
    }
}
