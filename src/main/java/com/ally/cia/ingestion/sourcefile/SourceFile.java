package com.ally.cia.ingestion.sourcefile;

import com.ally.cia.ingestion.sourcefile.row.SourceRow;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class SourceFile implements SourceFileCalibratable {
    private SourceFile(Integer jobId) {
        File schemaFile = new File(String.format("jobNumber%d.txt", jobId));
    }

    public static SourceFile getInstance(Integer jobId) {
        return new SourceFile(jobId);
    }

    @Override
    public Object getType(String key) {
        return "Value";
    }

    List getRows() {
        List sourceRows = Arrays.asList(SourceRow.getInstance());
        return sourceRows;
    }
}
