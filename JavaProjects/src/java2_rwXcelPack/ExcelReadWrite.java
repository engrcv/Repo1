package java2_rwXcelPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReadWrite {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		writeIntoExcel("birthdays.xls");
		readFromExcel("birthdays.xls");
	}

	// Java method to read data from Excel(.xls) file in Java.
	public static void readFromExcel(String file) throws IOException {
		HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
		HSSFSheet myExcelSheet = myExcelBook.getSheet("Birthdays");
		HSSFRow row = myExcelSheet.getRow(0);

		if (row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING) {
			String name = row.getCell(0).getStringCellValue();
			System.out.println("name : " + name);
		}

		if (row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			Date birthdate = row.getCell(1).getDateCellValue();
			System.out.println("birthdate :" + birthdate);
		}

		myExcelBook.close();

	}

	// Java method to write data to Excel(.xls) file
	@SuppressWarnings("deprecation")
	public static void writeIntoExcel(String file) throws FileNotFoundException, IOException {
		Workbook book = new HSSFWorkbook();
		Sheet sheet = book.createSheet("Birthdays");

		// first row start with zero
		Row row = sheet.createRow(0);

		// we will write name and birthdates in two columns
		// name will be String and birthday would be Date
		// formatted as dd.mm.yyyy
		Cell name = row.createCell(0);
		name.setCellValue("John");

		Cell birthdate = row.createCell(1);

		// steps to format a cell to display date value in Excel
		// 1. Create a DataFormat
		// 2. Create a CellStyle
		// 3. Set format into CellStyle
		// 4. Set CellStyle into Cell
		// 5. Write java.util.Date into Cell
		DataFormat format = book.createDataFormat();
		CellStyle dateStyle = book.createCellStyle();
		dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
		birthdate.setCellStyle(dateStyle);

		// It's very trick method, deprecated, don't use
		// year is from 1900, month starts with zero
		birthdate.setCellValue(new Date(110, 10, 10));

		// auto-resizing columns
		sheet.autoSizeColumn(1);

		// Now, its time to write content of Excel into File
		book.write(new FileOutputStream(file));
		book.close();
	}
}
