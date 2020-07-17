package utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {

	private static XSSFWorkbook myExcelBook;
	private static XSSFSheet myExcelSheet;
	private static XSSFRow row1;
	private static XSSFRow row2;
	private static XSSFRow row3;
	private static XSSFRow row4;
	
	public static void createXcel() throws Throwable {
		myExcelBook = new XSSFWorkbook();
		myExcelSheet = myExcelBook.createSheet("ProductService");
	}

	public static XSSFCell wLevel1(int rowNum, int cellNum, String str) throws Exception {
		row1 = myExcelSheet.getRow(rowNum);
		if(row1==null) {
		row1 = myExcelSheet.createRow(rowNum);}
		XSSFCell Level1 = row1.getCell(cellNum);
		if(Level1 == null) {
		Level1 = row1.createCell(cellNum);}
		Level1.setCellValue(str); 
		return Level1;
	}
	public static XSSFCell wLevel2(int rowNum, int cellNum, String str) throws Exception {
		row2 = myExcelSheet.getRow(rowNum);
		if(row2==null) {
		row2 = myExcelSheet.createRow(rowNum);}
		XSSFCell Level2 = row2.getCell(cellNum);
		if(Level2==null) {
		Level2 = row2.createCell(cellNum);}
		Level2.setCellValue(str);
		return Level2;
	}
	public static XSSFCell wLevel3(int rowNum, int cellNum, String str) throws Exception {
		row3 = myExcelSheet.createRow(rowNum);
		XSSFCell Level3 = row3.createCell(cellNum);
		Level3.setCellValue(str);
		return Level3;
	}
	public static XSSFCell wLevel4(int rowNum, int cellNum, String str) throws Exception {
		row4 = myExcelSheet.createRow(rowNum);
		XSSFCell Level4 = row4.createCell(cellNum);
		Level4.setCellValue(str);
		return Level4;
	}
	
	public static void writeXcel() throws IOException {
		FileOutputStream out  = new  FileOutputStream(new File("Attra.xls"));
		// auto-resizing columns
		for (int i=0; i<5;i++){
			myExcelSheet.autoSizeColumn(i);
			}
		myExcelBook.write(out); 
	       
	}
	
	public static void closeXcel() throws IOException {
	      	myExcelBook.close();
	}

}
	
	
	
	
	
	/*public static void writeIntoExcel(String file) throws FileNotFoundException, IOException{
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Attra_ProductsServices");

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
}*/

