package Practies;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import objectRepository.LoginPage;

public class AddProductPOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     


		//Step 1: Launch the browser
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//Step 2: Load the Application
		driver.get("https://www.saucedemo.com/");
		
	
		//Using pom class we are creating object and call 
		LoginPage lp=new LoginPage(driver);
    	//Instead of calling getter hear we are using Busness library Genric method 
		lp.LoginToApp("standard_user", "secret_sauce");
		
		//Step 4: Click on a Product - Sauce Labs Bolt T-shirt
		WebElement productEle = driver.findElement(By.xpath("//dive[.='Sauce Labs Backpack']"));
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
		
		//Step 8: Logout of App
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("test commit");
		
	}

}
