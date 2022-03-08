package com.aaa.view.insurance.quotes.shortform.ziprouter;

import com.aaa.view.insurance.quotes.data.user.ShortFormUser;
import com.aaa.view.insurance.quotes.data.user.ShortFormUserDefinition;
import com.aaa.view.insurance.quotes.data.user.ShortFormUserProvider;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.INSURANCE_APPLICATION, GauntletTest.View.ZIP_ROUTER})
public class ZipRouterViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {ShortFormUserDefinition.getInstance().withZipCode("99999")}
                , {ShortFormUserDefinition.getInstance().withZipCode("9")}
                , {ShortFormUserDefinition.getInstance().withZipCode("9999")}
        };
    }

    @Test(groups = {GauntletTest.TestSuite.SMOKE, TestSuite.ACCEPTANCE})
    public void smoke() {
        addRequirements("US-999", "US-756");
        ZipRouterViewExpected expected = ZipRouterViewExpected.getInstance();
        ZipRouterView actual = ZipRouterView.directNav();
        then(ZipRouterViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE}, dependsOnMethods = "smoke")
    public void directNav() {
        addRequirements("US-999");
        ZipRouterViewExpected expected = ZipRouterViewExpected.getInstance();
        ZipRouterView actual = ZipRouterView.directNav();
        then(ZipRouterViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE}, dataProvider = "scenarios", dependsOnMethods = "smoke")
    public void enterInvalidZipCode(ShortFormUserDefinition userDefinition) {
        addRequirements("US-664");
        ShortFormUser user = ShortFormUserProvider.getInstance().get(userDefinition);
        ZipRouterViewExpected expected = ZipRouterViewExpected.getInstance(user.getZipCode());
        ZipRouterView actual = ZipRouterView.directNav().enterZip(user.getZipCode());
        then(ZipRouterViewCalibrator.getInstance(expected, actual));
    }
}
