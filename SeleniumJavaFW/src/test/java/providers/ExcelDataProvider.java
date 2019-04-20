package providers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	
	XSSFWorkbook wb;
	public ExcelDataProvider() {
	
		File file = new File(".\\src\\test\\resources\\TestData\\TestData.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public String getCellData(int index, int row, int column) {
		
		String data = wb.getSheetAt(index).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public String getCellData(String sheetName, int row, int column) {
		
		String data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}

}
