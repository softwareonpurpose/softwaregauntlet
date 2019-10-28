package com.ally.cia.ingestion.sourcefile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SourceFileSchema {

    private Map<String, String> schemaMap;

    private SourceFileSchema(int schemaId) {
        final String filePath = String.format("/schemaFile%d.txt", schemaId);
        final InputStream resourceAsStream = getClass().getResourceAsStream(filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));

        schemaMap = new HashMap<>();
        try {
            final String line = bufferedReader.readLine();
            String[] parts = line.split(",");
            schemaMap.put(parts[0], parts[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SourceFileSchema getSourceFileSchema(int schemaId) {
        return new SourceFileSchema(schemaId);
    }

    Map<String, String> getSchemaMap(int schemaId) {
        return schemaMap;
    }
}
