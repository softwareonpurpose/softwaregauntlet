package com.ally.cia.ingestion.sourcefile;

import com.ally.cia.ingestion.sourcefile.row.SourceRow;
import com.softwareonpurpose.calibrator4test.Calibrator;

import java.util.ArrayList;
import java.util.List;

public class SourceFileCalibrator extends Calibrator {
    private static final String DESCRIPTION = "Source File";
    private final SourceFileSchema expectedSchema;
    private final SourceFile actual;

    private SourceFileCalibrator(SourceFileSchema expectedSchema, SourceFile actual) {
        super(DESCRIPTION, expectedSchema, actual);
        this.expectedSchema = expectedSchema;
        this.actual = actual;
    }

    public static SourceFileCalibrator getInstance(SourceFileSchema expected, SourceFile actual) {
        return new SourceFileCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        List<String> formatPatterns = new ArrayList<>(expectedSchema.getSchemaMap(9).values());
        int rownum = 0;
        for(SourceRow row:actual.getRows()){
            verify(String.format("Line %d is transformable: %s", ++rownum, row.getRowData()), rownum != 2 && rownum != 5, row.isTransformable(formatPatterns));
        }
    }
}
