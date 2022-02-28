package org.aaa.view.insurance.quotes.shortform;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test
public class ShortFormViewTests extends GauntletTest {
    @Test
    public void smoke() {
        ShortFormViewExpected expected = ShortFormViewExpected.getInstance();
        ShortFormView actual = ShortFormView.directNav();
        then(ShortFormViewCalibrator.getInstance(expected, actual));
    }
}
