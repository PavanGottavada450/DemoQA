package Nov19;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtil {

	@DataProvider(name = "loginData")
	public Object[][] getdata() throws IOException{
		
		File file = new File("D:\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows - 1][cols];
		
		DataFormatter df = new DataFormatter();
		
		for(int i=1; i < rows; i++) {
			for(int j=0; j < cols; j++) {
				data[i-1][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		
		workbook.close();
		fis.close();
		
		return data;
	}
	
}
