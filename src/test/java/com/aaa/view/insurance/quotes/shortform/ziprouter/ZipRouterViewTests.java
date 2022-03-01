package com.aaa.view.insurance.quotes.shortform.ziprouter;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.INSURANCE_APPLICATION, GauntletTest.View.ZIP_ROUTER})
public class ZipRouterViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {"99999"}
                ,{"9"}
                ,{"9999"}
        };
    }

    @Test(groups = {GauntletTest.TestSuite.SMOKE, TestSuite.ACCEPTANCE})
    public void smoke() {
        ZipRouterViewExpected expected = ZipRouterViewExpected.getInstance();
        ZipRouterView actual = ZipRouterView.directNav();
        then(ZipRouterViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE}, dependsOnMethods = "smoke")
    public void directNav() {
        ZipRouterViewExpected expected = ZipRouterViewExpected.getInstance();
        ZipRouterView actual = ZipRouterView.directNav();
        then(ZipRouterViewCalibrator.getInstance(expected, actual));
    }

//    @Test(groups = {TestSuite.ACCEPTANCE}, dataProvider = "scenarios", dependsOnMethods = "smoke")
//    public void enterZipCode(String zipCode) {
//        ZipRouterViewExpected expected = ZipRouterViewExpected.getInstance(zipCode);
//        ZipRouterView actual = ZipRouterView.directNav().enterZip(zipCode);
//        then(ZipRouterViewCalibrator.getInstance(expected, actual));
//    }
}
