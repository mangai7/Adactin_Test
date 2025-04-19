package adactingroup;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelReader {

	static String excelFilePath = "./resourses/empdata.xlsx"; // Update path if needed

    public static String getCellValue(String sheetName, int rowNum, int colNum) {
        String cellValue = "";
        try (FileInputStream fis = new FileInputStream(excelFilePath);
        		XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet not found: " + sheetName);
            }

            Row row = sheet.getRow(rowNum);
            if (row == null) {
                return "";
            }

            Cell cell = row.getCell(colNum);
            if (cell == null) {
                return "";
            }

            CellType cellType = cell.getCellType();
            switch (cellType) {
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    cellValue = String.valueOf((int)cell.getNumericCellValue()); // or use `Double.toString()`
                    break;
                case BOOLEAN:
                    cellValue = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    cellValue = cell.getCellFormula();
                    break;
                default:
                    cellValue = "";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cellValue;
    }

}
