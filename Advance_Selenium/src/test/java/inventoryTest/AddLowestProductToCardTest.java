package inventoryTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import objectRepository.InventoryPage;

public class AddLowestProductToCardTest extends BaseClass {
	@Test
	public void tc_001_AddProductToCartTest() throws IOException
	{
		// Read Test Data From Excel File
				String SORTOPTION = Futil.readDataFromExcel("Product", 4, 2);
				String PRODUCTNAME = Futil.readDataFromExcel("Product", 4, 3);
	
	//Step 4: Click on a Product - Sauce Labs Backpackt
	//PRODUCTNAME-----this value is taking from excel file to avoid the data hot coding
	InventoryPage ip = new InventoryPage(driver);
	String pAddedToCart = ip.clickOnLowestPriceProduct(driver, PRODUCTNAME, SORTOPTION);
	//Step 5: Add the Product To Cart
	driver.findElement(By.id("add-to-cart")).click();
	
	//Step 6: Navigate to Cart
	driver.findElement(By.id("shopping_cart_container")).click();
	
	//Step 7: Validate the product in Cart
	String pInCart = driver.findElement(By.className("inventory_item_name")).getText();
    Assert.assertEquals(pAddedToCart, pInCart);
    System.out.println(pInCart);

}
}
