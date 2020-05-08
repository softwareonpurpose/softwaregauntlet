/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmhco;

import org.testng.annotations.Test;
import com.softwareonpurpose.gauntlet.GauntletTest;

/**
 *
 * @author Frederick Bloom
 */
@Test(groups = {GauntletTest.Application.HMHCO, GauntletTest.View.HOME})
public class HomeTests extends GauntletTest {

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        setRequirements("2");
        HomeExpected expected = HomeExpected.getInstance();
        Home actual = Home.directNav();
        then(HomeCalibrator.getInstance(expected, actual));
    }
}
