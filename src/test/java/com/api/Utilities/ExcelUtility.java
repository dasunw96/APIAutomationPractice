package com.api.Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	
	public ExcelUtility(String path) {
		this.path= path;
		
	}
	
	public int getRowCount(String sheetName) throws IOException {
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
	
	}
	
	public int getCellCount(String sheetName, int rowNum) throws IOException {
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
	
	}
	
	public String getCellData(String shetName, int rowNum, int colnum) throws IOException {
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(shetName);
		row=sheet.getRow(rowNum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		
		try {
			data = formatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data="";
		}
		
		workbook.close();
		fi.close();
		return data;
	
	}

	public String getCellDataOfSpecificColumn(String sheetName,String colName,int rowNum){
		try {
			sheet = workbook.getSheet(sheetName); // Get the sheet based on the sheet name

			if (sheet == null) {
				return "Sheet not found";
			}

			// Get the header row (assumed to be the first row)
			Row headerRow = sheet.getRow(0);
			if (headerRow == null) {
				return "Header row not found";
			}

			// Find the column index based on the column name
			int colNum = -1;
			for (int i = 0; i < headerRow.getLastCellNum(); i++) {
				Cell cell = headerRow.getCell(i);
				if (cell != null && cell.getStringCellValue().equalsIgnoreCase(colName)) {
					colNum = i;
					break;
				}
			}

			if (colNum == -1) {
				return "Column not found";
			}

			// Get the data row based on the rowNum
			Row dataRow = sheet.getRow(rowNum);
			if (dataRow == null) {
				return "Row not found";
			}

			// Get the cell data from the specified row and column
			Cell cell = dataRow.getCell(colNum);
			if (cell == null) {
				return "Cell not found";
			}

			// Check the cell type and return the appropriate value
			switch (cell.getCellType()) {
				case STRING:
					return cell.getStringCellValue();
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						return cell.getDateCellValue().toString(); // Return date as string
					} else {
						return String.valueOf(cell.getNumericCellValue()); // Return numeric value as string
					}
				case BOOLEAN:
					return String.valueOf(cell.getBooleanCellValue());
				case FORMULA:
					return cell.getCellFormula(); // Return formula if any
				default:
					return "Unsupported cell type";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error reading cell data";
		}
	}
	
	
	

	
	
	
	
}


