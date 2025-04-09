package inventoryTest;

import static org.testng.Assert.assertEquals;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.FileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddProductToCartTest extends BaseClass{

	@Test(groups = "smokesuit")
	public void tc_001_AddProductToCartTest() throws IOException
	{
		 FileUtility Fileutil=new FileUtility();
	        JavaUtility JavaUtil=new JavaUtility();
	        SeleniumUtility SeUtil=new SeleniumUtility();
	        
        
		
		//reading data from property file 
		String URL=Fileutil.readDataFromPropertyFile("url");
		String USERNAME=Fileutil.readDataFromPropertyFile("username");
		String PASSWORD=Fileutil.readDataFromPropertyFile("password");

		//Read test data from Excel sheet 
		String PRODUCTNAME=Fileutil.readDataFromExcel("Sheet1", 1, 2);
		
		
		

		//Step 1: Launch the browser
		ChromeDriver driver =new ChromeDriver();
		SeUtil.maximizewindow(driver);
		SeUtil.implicitwait(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
		
		//Step 2: Load the Application
		driver.get(URL);
		
		//Step 3: login To Application
		LoginPage lp=new LoginPage(driver);
    	//Instead of calling getter hear we are using Busness library Genric method 
		lp.LoginToApp("standard_user", "secret_sauce");
  
		
		//Step 4: Click on a Product - Sauce Labs Backpackt
		
		InventoryPage Ip=new InventoryPage(driver);
		String pAddedToCart=Ip.clickOnproduct(driver, PRODUCTNAME);
		
		//Step 5: Add the Product To Cart
		InventoryItemPage itp=new InventoryItemPage(driver);
		itp.clickOnaddtocardbtn();
		
		
		//Step 6: Navigate to Cart
		Ip.clickOncardcontainer();
		
		
		//Step 7: Validate the product in Cart
		CartPage Cp=new CartPage(driver);
		String pInCart = Cp.getProductName();
	    Assert.assertEquals(pAddedToCart, pInCart);
	    
	  //Step 8: Logout of App
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		
	
//		if(pInCart.equals(pAddedToCart))
//		{
//			System.out.println("PASS");
//			System.out.println(pInCart);
//		}
//		else
//		{
//			System.out.println("FAIL");
//		}
//		
	}
}
