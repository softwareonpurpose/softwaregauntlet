package com.ally.cia.ingestion.sourcefile;

import com.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Database.METADATA})
public class SourceFileTest extends GauntletTest {
    @Test(groups = {TestSuite.EVT})
    public void smoke() {
        SourceFileSchema expected = SourceFileSchema.getInstance();
        SourceFile actual = SourceFile.getInstance(9);
        then(SourceFileCalibrator.getInstance(expected, actual));
    }
}
