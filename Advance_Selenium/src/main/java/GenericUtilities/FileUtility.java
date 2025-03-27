package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Generic method related to file opertion
 * @author SRINANDHINI
 */

public class FileUtility {
	public static void main(String[] args) {//calling function 
		// TODO Auto-generated method stub
		int sum=add(10, 20);
		System.out.println(sum);
		System.out.println(add(sum,50));
		System.out.println(add(sum,60));
		int SUB=sub(20,50);
		System.out.println(SUB);


		
		

	}
	public static int add(int a,int b)//called function generic function
	{
		int c=a+b;
		return c;
	}
	public static int sub(int d,int e)//called function generic function
	{
		int f=d-e;
		return f;
	}
}