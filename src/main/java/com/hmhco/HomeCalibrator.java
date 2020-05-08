/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmhco;

import com.softwareonpurpose.calibrator4test.Calibrator;

/**
 *
 * @author Frederick Bloom
 */
public class HomeCalibrator extends Calibrator {

    private static final String DESCRIPTION = "homepage";

    private HomeCalibrator(HomeExpected expected, Home actual) {

        super(DESCRIPTION, expected, actual);
    }

    public static HomeCalibrator getInstance(HomeExpected expected, Home actual) {
        return new HomeCalibrator(expected, actual);
    }
    
    @Override
    protected void executeVerifications() {

    }

}
