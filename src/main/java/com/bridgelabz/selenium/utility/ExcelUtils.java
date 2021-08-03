package com.bridgelabz.selenium.utility;

import com.bridgelabz.selenium.base.BaseClass;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils extends BaseClass {

    static String projectPath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    //constructor
    public ExcelUtils(String excelPath, String sheetName){
        try {
            projectPath = System.getProperty("user.dir");
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public  int getRowCount() {
        int Row_Count = 0;
        try {

            Row_Count = sheet.getPhysicalNumberOfRows();
            System.out.println("Number of rows : "+Row_Count);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Row_Count;
    }

    public  int getColumnCount() {
        int Column_Count = 0;
        try {

            Column_Count = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("Number of columns : "+Column_Count);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Column_Count;
    }

    public  String getCellData(int rowNum,int colNum) {
        XSSFCell cellData = sheet.getRow(rowNum).getCell(colNum);
        DataFormatter formatter = new DataFormatter();

        String data = "";
        try {
            data = formatter.formatCellValue(cellData); //Returns the formatted value of a cell as a String regardless of the cell type.

            //System.out.println("Data is : "+cellData);
        } catch (Exception e){
            e.printStackTrace();

        }
        return data;
    }

}
