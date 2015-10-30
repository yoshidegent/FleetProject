package com.realdolmen.fleet.spreadsheet.mapper;

import java.util.List;

public interface SpreadsheetMapper <T> {
    T mapRow(List<String> values);
}
