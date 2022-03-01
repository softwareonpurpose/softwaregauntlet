package com.aaa.view.insurance.quotes.shortform.contact;

import com.aaa.view.insurance.quotes.data.request.InsuranceRequest;
import com.aaa.view.insurance.quotes.shortform.ziprouter.ZipRouterView;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.INSURANCE_APPLICATION, GauntletTest.View.CONTACT})
public class ContactViewTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE, TestSuite.ACCEPTANCE})
    public void smoke() {
        String zipCode = "90018";
        InsuranceRequest insuranceRequest = InsuranceRequest.getInstance("Universal Life", true);
        ContactViewExpected expected = ContactViewExpected.getInstance();
        ContactView actual = ZipRouterView.directNav()
                .submit(zipCode).submit(insuranceRequest);
        then(ContactViewCalibrator.getInstance(expected, actual));
    }
}
