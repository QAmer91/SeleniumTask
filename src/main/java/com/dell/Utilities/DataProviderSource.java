package com.dell.Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviderSource {

    XSSFSheet ExcelWSheet;
    XSSFWorkbook ExcelWBook;
    XSSFCell Cell;
    XSSFRow Row;

    @DataProvider(name = "NewValidUserAccount")
    public Object[][] getNewUserData(Method method) throws IOException {

        String tcName = method.getName();
        Object[][] extractedData = getDataFromExcel(tcName , 11 , "ValidNewUser");
        return extractedData;
    }

    @DataProvider(name = "NewInvalidUserAccount")
    public Object[][] getNewInvalidUserData(Method method) throws IOException {

        String tcName = method.getName();
        Object[][] extractedData = getDataFromExcel(tcName , 11 , "InvalidNewUser");
        return extractedData;
    }

    public Object[][] getDataFromExcel(String testName , int colCount , String sheetName) throws IOException {

        FileInputStream ExcelFile = new FileInputStream("src/main/resources/DataSource.xlsx");
        DataFormatter formatter = new DataFormatter();

        ExcelWBook = new XSSFWorkbook(ExcelFile);
        ExcelWSheet = ExcelWBook.getSheet(sheetName);
        int rowsCount = ExcelWSheet.getLastRowNum() + 1;
        Object[][] excelData = new String [rowsCount - 1][colCount];
        int colIndex;

        for (int rowIndex = 1 ; rowIndex < rowsCount ; rowIndex++ )
        {
            colIndex = 1;

            if (ExcelWSheet.getRow(rowIndex).getCell(0).getStringCellValue().equalsIgnoreCase(testName))
            {
                while (colIndex <= colCount)
                {

                    excelData[rowIndex - 1][colIndex - 1] = formatter.formatCellValue
                            (ExcelWSheet.getRow(rowIndex).getCell(colIndex));
                    colIndex += 1;
                }
            }

        }
        return excelData;
    }

}
