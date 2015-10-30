package com.realdolmen.fleet.spreadsheet;

import com.realdolmen.fleet.CarModel;
import com.realdolmen.fleet.spreadsheet.mapper.ExcelCarModelSpreadsheetMapperImpl;
import com.realdolmen.fleet.spreadsheet.mapper.SpreadsheetMapper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ExcelSpreadsheetServiceImpl implements SpreadsheetService<CarModel> {
    private SpreadsheetMapper<CarModel> excelCarModelSpreadsheetMapperImpl = new ExcelCarModelSpreadsheetMapperImpl();

    @Override
    public Map<Integer, String> getSheetNames(InputStream stream) {

        Workbook workbook = getWorkbookFromStream(stream);

        Map<Integer, String> names = new HashMap<>();
        int amountOfSheets = workbook.getNumberOfSheets();
        for(int i = 0; i < amountOfSheets; i++) {
            names.put(i, workbook.getSheetName(i));
        }

        return names;
    }

    @Override
    public List<CarModel> parse(InputStream stream, int sheetIndex) {
        List<CarModel> carModels = new ArrayList<>();

        Workbook workbook = getWorkbookFromStream(stream);
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Iterator<Row> rowIterator = sheet.rowIterator();

        boolean tableFound = false;
        while(rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if(!tableFound) {
                String firstCellValue = row.getCell(0).getStringCellValue();
                // Start of car model table.
                if(firstCellValue.equals("Cat")) {
                    tableFound = true;
                }
            } else {
                Iterator<Cell> cellIterator = row.cellIterator();

                // Iterate the cells of each row in the table and parse the values to a CarModel.
                List<String> cellValues = new ArrayList<>();
                while(cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    Object value;
                    if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
                        value = cell.getNumericCellValue();
                    else
                        value = cell.getStringCellValue();

                    cellValues.add(String.valueOf(value));
                }

                CarModel carModel = excelCarModelSpreadsheetMapperImpl.mapRow(cellValues);
                if(carModel != null)
                    carModels.add(excelCarModelSpreadsheetMapperImpl.mapRow(cellValues));
            }
        }

        return carModels;
    }

    private Workbook getWorkbookFromStream(InputStream stream) {
        Workbook workbook;

        try {
            workbook = WorkbookFactory.create(stream);
        } catch (IOException | InvalidFormatException e) {
            throw new IllegalArgumentException("The provided stream was not valid.");
        }

        return workbook;
    }
}
