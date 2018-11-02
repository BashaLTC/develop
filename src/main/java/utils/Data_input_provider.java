package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Data_input_provider {
	@DataProvider(name="fetchData")
	public static String [][] GetData() throws IOException{
		String [][]TestData;
		FileInputStream fis = new FileInputStream("./TestData/TestData_001.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(0).getLastCellNum();
		TestData = new String [rowcount][columncount];
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<columncount;j++)
			{
				String cellValue = row.getCell(j).getStringCellValue();
				System.out.println(cellValue);
				TestData [i-1][j] = cellValue;
			}
			
		}
		
		return TestData;
		
	}

}
