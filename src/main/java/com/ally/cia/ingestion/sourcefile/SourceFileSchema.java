package com.ally.cia.ingestion.sourcefile;

import java.util.Map;
import java.util.TreeMap;

public class SourceFileSchema implements SourceFileCalibratable{
    private final TreeMap<String, String> schema = new TreeMap<>();
    private SourceFileSchema(){
        schema.put("Key", "Value");
    }
    public static SourceFileSchema getInstance() {
        return new SourceFileSchema();
    }

    public Map<String, String> getSchemaMap() {
        return schema;
    }

    @Override
    public Object getType(String key) {
        return schema.get(key);
    }
}
