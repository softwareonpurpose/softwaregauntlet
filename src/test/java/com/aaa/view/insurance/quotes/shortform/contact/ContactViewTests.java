package com.aaa.view.insurance.quotes.shortform.contact;

import com.aaa.view.insurance.quotes.data.user.ShortFormUser;
import com.aaa.view.insurance.quotes.data.user.ShortFormUserDefinition;
import com.aaa.view.insurance.quotes.data.user.ShortFormUserProvider;
import com.aaa.view.insurance.quotes.shortform.ziprouter.ZipRouterView;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.INSURANCE_APPLICATION, GauntletTest.View.CONTACT})
public class ContactViewTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE, TestSuite.ACCEPTANCE})
    public void smoke() {
        String zipCode = "90018";
        ShortFormUserDefinition userDefinition = ShortFormUserDefinition.getInstance().withZipCode("90018").withType("Universal Life").withIsCurrentlyInsured(true);
        ShortFormUser shortFormUser = ShortFormUserProvider.getInstance().get(userDefinition);
        ContactViewExpected expected = ContactViewExpected.getInstance();
        ContactView actual = ZipRouterView.directNav()
                .submit(zipCode).submit(shortFormUser);
        then(ContactViewCalibrator.getInstance(expected, actual));
    }
}
