package org.aaa.view.insurance.quotes.shortform;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.INSURANCE_APPLICATION, GauntletTest.View.ZIP_ROUTER})
public class ZipRouterViewTests extends GauntletTest {
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
}
