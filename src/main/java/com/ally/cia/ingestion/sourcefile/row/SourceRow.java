package com.ally.cia.ingestion.sourcefile.row;

import com.softwareonpurpose.gauntlet.Environment;

import java.util.ArrayList;
import java.util.List;

public class SourceRow {

    private String rowData;
    private static char SEPARATOR;

    public SourceRow(String data) {
        SEPARATOR = Environment.getInstance().getProperty("separator").toCharArray()[0];
        rowData = data;
    }

    public Boolean isTransformable(List<String> formatPatterns) {
        boolean isTransformable = false;
        String[] values = splitDelimitedValues(rowData);
        for (int i = 0; i < formatPatterns.size(); i++) {
            if (i <= values.length) {
                try {
                    // removing leading and trailing quote
                    values[i] = values[i].trim().replaceAll("^\"|\"$", "");
                    formatPatterns.set(i,formatPatterns.get(i).trim().replaceAll("^\"|\"$", ""));

                    isTransformable = values[i].matches(formatPatterns.get(i));
                } catch (NumberFormatException e) {
                    // will return false
                }
            }
        }
        return isTransformable;
    }

    private static String[] splitDelimitedValues(String line)
    {
        List<String> result = new ArrayList<>();
        StringBuilder currentStr = new StringBuilder();
        boolean inQuotes = false;
        // For each character
        for (char b : line.toCharArray()) {
            if (b == '\"') // Quotes are closing or opening
                inQuotes = !inQuotes;
            else if (b == SEPARATOR) // Comma
            {
                if (!inQuotes) // If not in quotes, end of current string, add it to result
                {
                    result.add(currentStr.toString());
                    currentStr = new StringBuilder();
                } else
                    currentStr.append(b); // If in quotes, just add it
            } else // Add any other character to current string
                currentStr.append(b);
        }
        result.add(currentStr.toString().replaceAll("^\"|\"$", ""));

        return result.toArray(new String[0]);
    }

}
