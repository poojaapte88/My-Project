package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelsheet
{
	public static Workbook book;
	public static org.apache.poi.ss.usermodel.Sheet sheet;
	public static Object[][] readdata(String Sheetname)
	{
		FileInputStream file=null;
		try {
			file=new FileInputStream("C:\\Users\\chintan\\eclipse-workspace\\HR_Management\\src\\test\\java\\testdata\\Details.xlsx");
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try {
				book= WorkbookFactory.create(file);		//Two types of Workbook - HSSF(older version of Windows) and  XSSF(Newer version of Windows)
		} 
		catch (IOException a) {
			
			a.printStackTrace();
		}
		
		sheet=book.getSheet(Sheetname);
		Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
		
	}
}
