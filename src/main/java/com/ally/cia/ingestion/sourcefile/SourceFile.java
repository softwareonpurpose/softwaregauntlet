package com.ally.cia.ingestion.sourcefile;

import com.ally.cia.ingestion.sourcefile.row.SourceRow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SourceFile {

    private final BufferedReader bufferedReader;

    private SourceFile(Integer jobId) {
        final String filePath = String.format("/jobNumber%d.txt", jobId);
        final InputStream resourceAsStream = getClass().getResourceAsStream(filePath);
        bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
    }

    public static SourceFile getInstance(Integer jobId) {
        return new SourceFile(jobId);
    }

    List<SourceRow> getRows() {
        List<SourceRow> sourceRows = new ArrayList<>();
        try {
            final String line = bufferedReader.readLine();
            sourceRows.add(new SourceRow(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceRows;
    }
}
