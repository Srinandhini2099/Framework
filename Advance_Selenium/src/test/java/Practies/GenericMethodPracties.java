package Practies;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericMethodPracties {
	/**
	 * This method will provide data from propery file for the key provided by the caller 
	 * @param Key
	 * @return
	 * @throws IOException
	 */

	public String readDatafromPropertyFile(String Key) throws IOException
	{
		FileInputStream file=new FileInputStream("/C:\\Seleniumwebdriver\\Advance_Selenium\\src\\test\\resources\\DATA.properties");
		Properties p=new Properties();
		p.load(file);
		String value = p.getProperty(Key);
		
		return value;
		
	}
	/**
	 * This method is used to get data from Excel sheet
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDatafromExcelfile(String sheetname,int row, int cell) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream file1=new FileInputStream("C:\\Seleniumwebdriver\\Advance_Selenium\\testdata.xlsx");
		Workbook wb=WorkbookFactory.create(file1) ;
		Sheet s1=wb.getSheet("sheetname");
		Row r=s1.getRow(row);
		Cell c=r.getCell(cell);
		String value=c.getStringCellValue();
	//method chaining
		//	String value1=wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		
		return value ;	
    
	}
}


