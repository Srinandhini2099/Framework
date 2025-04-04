package inventoryTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;

public class AddProductToCartTest extends BaseClass{

	@Test
	public void tc_001_AddProductToCartTest() throws IOException
	{
		
        
		

		//Read test data from Excel sheet 
		FileInputStream file1=new FileInputStream("C:\\Users\\KARTHIKEYAN\\git\\repository\\Advance_Selenium\\testdata.xlsx");
		Workbook wb=WorkbookFactory.create(file1) ;
		Sheet s=wb.getSheet("Sheet1");
		Row r=s.getRow(1);
		Cell c=r.getCell(2);
		String PRODUCTNAME=c.getStringCellValue();
		
		//Step 4: Click on a Product - Sauce Labs Backpackt
		//PRODUCTNAME-----this value is taking from excel file to avoid the data hot coding
		WebElement productEle = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String pAddedToCart = productEle.getText();
		productEle.click();
		//Step 5: Add the Product To Cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Step 6: Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Step 7: Validate the product in Cart
		String pInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if(pInCart.equals(pAddedToCart))
		{
			System.out.println("PASS");
			System.out.println(pInCart);
		}
		else
		{
			System.out.println("FAIL");
		}
		
	}
}
