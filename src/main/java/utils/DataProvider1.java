package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProvider1 {
	
	@DataProvider

	public static String[][] fetchData() throws IOException{
		
		FileInputStream fis = new FileInputStream(".//TestData/TestData_001.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		int coulmncount = sheet.getRow(0).getLastCellNum();
		String [][] TestData = new String[rowcount][coulmncount];
		for (int i=1;i<=rowcount;i++){
			XSSFRow row = sheet.getRow(i);
			for (int j=0;j<coulmncount;j++){
				String cellvalue = row.getCell(j).getStringCellValue();
				System.out.println(cellvalue);
				TestData[i-1][j] = cellvalue;
			}		
		}
		return TestData;
			
	}
	




	 public static String[][] getData() throws IOException{
		String[][] Testdata;
		FileInputStream fis = new FileInputStream("./data/dtaprovier.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		int coulmncount = sheet.getRow(0).getLastCellNum();
		Testdata = new String[rowcount][coulmncount];
			for(int i=1;i<=rowcount;i++){
				XSSFRow row = sheet.getRow(i);
				for(int j=0;j<coulmncount;j++){
					String coulmnvalue = row.getCell(j).getStringCellValue();
					Testdata[i-1][j] = coulmnvalue;
	}
	}
			return Testdata;
	}
	
}

