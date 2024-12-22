package testCases;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.*;

public class Excel {
	
	// Excel FIle=> Workbook => Sheet => Row => Cell
	/*
	 * FileInputStream = Excel File
	 * XSSFWorkbook = Workbook
	 * XSSFSheet = Sheet
	 * XSSFRow = Row
	 * XSSFCell = Cell
	 */
	public static void main(String[] args) throws Exception {
		//Excel File use with Project Directory
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\testData\\TestData.xlsx");
		
		// Use Workbbok with Location path
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// Use Sheet 
		XSSFSheet sheet = workbook.getSheet("Login");
		// Count Total Rows Number
		int totalRows = sheet.getLastRowNum();
		// Count Total Cell number
		int totalCe11 = sheet.getRow(1).getLastCellNum();
		// Print 
		System.out.println("number of rows : " + totalRows); // 5
		System.out.println("number of cells: " + totalCe11);
		// Print Excel Data using For Loop
		for (int r = 0; r <= totalRows; r++) {
			// Read Row Data 
			XSSFRow currentRow = sheet.getRow(r);
			for (int c = 0; c < totalCe11; c++) {
				// Read Cell Data 
				XSSFCell cell = currentRow.getCell(c);
				System.out.print(cell.toString() + "\t");
			}
			System.out.println();

		}
		// Close Excel File 
		workbook.close();
		fis.close();
	}

}
