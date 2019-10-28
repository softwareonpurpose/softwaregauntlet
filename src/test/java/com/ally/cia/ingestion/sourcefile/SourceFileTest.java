package com.ally.cia.ingestion.sourcefile;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Database.METADATA})
public class SourceFileTest extends GauntletTest {
    @Test(groups = {TestSuite.EVT})
    public void smoke() {
        System.setProperty("env", "sourceFiletest");

        SourceFileSchema expected = SourceFileSchema.getSourceFileSchema(9);
        SourceFile actual = SourceFile.getInstance(9);

        then(SourceFileCalibrator.getInstance(expected, actual));
    }
}
