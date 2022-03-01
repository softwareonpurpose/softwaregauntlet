package com.aaa.view.insurance.quotes.shortform;

import com.aaa.view.insurance.quotes.shortform.ziprouter.ZipRouterView;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.INSURANCE_APPLICATION, GauntletTest.View.SHORT_FORM})
public class ShortFormTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE, TestSuite.ACCEPTANCE})
    public void smoke() {
        ShortFormViewExpected expected = ShortFormViewExpected.getInstance();
        ShortFormView actual = ZipRouterView.directNav().submit("90018");
        then(ShortFormViewCalibrator.getInstance(expected, actual));
    }
}
