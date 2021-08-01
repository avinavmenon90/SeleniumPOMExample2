import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadTest {
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File src = new File("C:\\Users\\Avinav\\eclipse-workspace\\SeleniumPOMExample2\\src\\test\\java\\com\\testautomation\\utilities\\TestDataFiles\\TestData.xlsx");
		System.out.println("excel exists?"+src.exists());
		FileInputStream fis = new FileInputStream(src); //open file
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		System.out.println(sh.getRow(1).getCell(0).getStringCellValue());
		System.out.println(sh.getRow(1).getCell(1).getStringCellValue());
		wb.close();

	}

}
