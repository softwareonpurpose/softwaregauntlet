package com.ally.cia.ingestion.sourcefile.row;

import com.ally.cia.ingestion.sourcefile.SourceFileSchema;

import java.util.Map;

public class SourceRow {
    public static SourceRow getInstance() {
        return new SourceRow();
    }

    public Boolean isTransformable(SourceFileSchema schema) {
        Map<String, String> map = schema.getSchemaMap();
        boolean isTransformable = false;
        for(var key:map.keySet()){
            isTransformable = true;
        }
        return isTransformable;
    }
}
