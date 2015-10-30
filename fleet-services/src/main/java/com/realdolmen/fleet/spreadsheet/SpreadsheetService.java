package com.realdolmen.fleet.spreadsheet;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface SpreadsheetService <T> {
    Map<Integer, String> getSheetNames(InputStream stream);
    List<T> parse(InputStream stream, int sheetIndex);
}
