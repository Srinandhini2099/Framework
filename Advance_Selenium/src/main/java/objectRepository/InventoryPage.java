package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

	
	@FindBy(className="shopping_cart_link")
	private WebElement cardcontainer;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menubtn;
	
	@FindBy(linkText="Logout")
	private WebElement logoutlink;
	
	@FindBy(xpath="\"//select[@class='product_sort_container'\"")
	private WebElement sortDropdown;
	
	//Create constructor to Initialize
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Provide getter to access the webelement
	

	public WebElement getproductName() {
		return productName;
	}
	

	public WebElement getcardcontainer() {
		return cardcontainer;
	}
	
	
	public WebElement getmenubtn() {
		return menubtn;
	}
	
	public WebElement getlogoutlink() {
		return logoutlink;
	}
	
	public WebElement getsortDropdown() {
		return sortDropdown;
	}
	
	
	//bussness Library -Genric method -related 	to Application 
		public String LoginToApp(WebDriver driver,String productname )
		{
		  WebElement ele = driver.findElement(By.xpath("//div[.='"+productname+"']"));
		  String productdetails=ele.getText();
		  ele.click();
		return productdetails;
		  
		}



	

	
}
