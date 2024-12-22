package testCases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	// Excel File => Workbook => Sheet => Row => Cell
	public static void main(String[] args) throws Exception {
		
		// Create A Excel file for using FileOutputStream 
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testData\\createdExcel.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");
		
		XSSFRow row1 = sheet.createRow(0);
		// Heading Details
		row1.createCell(0).setCellValue("Name");
		row1.createCell(1).setCellValue("Last Name");
		row1.createCell(2).setCellValue("Course");
		
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Sanket");
		row2.createCell(1).setCellValue("Naik");
		row2.createCell(2).setCellValue("JAVA Selenium");

		XSSFRow row3 = sheet.createRow(2);
		row2.createCell(0).setCellValue("Santosh");
		row2.createCell(1).setCellValue("Naik");
		row2.createCell(2).setCellValue("Python Selenium");

		
		// Write all details in a Excel File 
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is created....");
		
	}

}
