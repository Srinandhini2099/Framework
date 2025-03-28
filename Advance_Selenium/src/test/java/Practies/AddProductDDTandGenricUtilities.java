package Practies;

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

import GenericUtilities.FileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.SeleniumUtility;

public class AddProductDDTandGenricUtilities {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     
		// TODO Auto-generated method stub
				// TODO Auto-generated method stub
		             //Creating object for Utiliy class
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
						driver.findElement(By.id("user-name")).sendKeys(USERNAME);
						driver.findElement(By.id("password")).sendKeys(PASSWORD);
						driver.findElement(By.id("login-button")).click();
						

						
						//Step 4: Click on a Product - Sauce Labs Backpackt
						//PRODUCTNAME-----this value is taking from excel file to avoid the data hot coding
						WebElement productEle = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
						String pAddedToCart = productEle.getText();
						productEle.click();
						//Step 5: Add the Product To Cart
						driver.findElement(By.id("add-to-cart")).click();
						
						//Step 6: Navigate to Cart
						driver.findElement(By.id("shopping_cart_container")).click();
						
						String screenshotname = "Tc_001"+JavaUtil.getSystemdataInFormate();
						String path=SeUtil.captureScreenshort(driver, screenshotname);
						System.out.println(path);
						
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
						
						//Step 8: Logout of App
						driver.findElement(By.id("react-burger-menu-btn")).click();
						driver.findElement(By.linkText("Logout")).click();
						
					}
}

