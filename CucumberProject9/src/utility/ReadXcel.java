package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXcel {
	private static XSSFWorkbook myExcelBook;
	private static XSSFSheet myExcelSheet;
	private static XSSFRow row;

	public static void readXcel(String file) throws Throwable {
		myExcelBook = new XSSFWorkbook(new FileInputStream(file));
		myExcelSheet = myExcelBook.getSheet("Users");
	}

	public static String getUser(int rowNum) throws Exception {
		row = myExcelSheet.getRow(rowNum);
		String UserID = row.getCell(0).getStringCellValue();
		return UserID;
	}

	public static String getPwd() throws Exception {
		String Passwrd = row.getCell(1).getStringCellValue();
		return Passwrd;
	}

	public static void closeXcel() throws IOException {
		myExcelBook.close();
	}

}
