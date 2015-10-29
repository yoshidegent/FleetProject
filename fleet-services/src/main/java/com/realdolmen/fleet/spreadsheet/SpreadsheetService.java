package com.realdolmen.fleet.spreadsheet;

import com.realdolmen.fleet.CarModel;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface SpreadsheetService {
    Map<Integer, String> getSheetNames(InputStream stream);
    List<CarModel> parse(InputStream stream, int sheetIndex);
}
