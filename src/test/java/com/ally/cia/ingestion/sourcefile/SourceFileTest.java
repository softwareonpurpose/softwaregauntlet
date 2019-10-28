package com.ally.cia.ingestion.sourcefile;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Database.METADATA})
public class SourceFileTest extends GauntletTest {
    @Test(groups = {TestSuite.EVT})
    public void smoke() {
        NOTE:
        /*  The 'ENV' property is expected to be the development/testing environment being tested against
            (e.g. 'Dev', 'Test', 'Stage', 'Production').

            When we get on the phone again, I'll confirm I understand your use, and we can do appropriate refactoring.

            It's VERY good to see you jumping right in and solving things; I've had other people be so hesitant,
            which just prolongs their being familiar with the framework,
            and the SOLID development principles and patterns which is informs and supports.
         */
        System.setProperty("env", "sourceFiletest");

        SourceFileSchema expected = SourceFileSchema.getSourceFileSchema(9);
        SourceFile actual = SourceFile.getInstance(9);

        then(SourceFileCalibrator.getInstance(expected, actual));
    }
}
