package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility{

	
	@FindBy(id="shopping_cart_container")
	private WebElement cardcontainer;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menubtn;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logoutlink;
	
	@FindBy(className="product_sort_container")
	private WebElement sortDropdown;
	
	//Create constructor to Initialize
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Provide getter to access the webelement
	


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
	/**
	 * This method will used to clik on product
	 * @param driver
	 * @param productname
	 * @return
	 */
	
	//bussness Library -Genric method -related 	to Application 
		public String clickOnproduct(WebDriver driver,String productname )
		{
		  WebElement ele = driver.findElement(By.xpath("//div[.='"+productname+"']"));
		  String productdetails=ele.getText();
		  ele.click();
		return productdetails;
		  
		}
		/**
		 * This method is used to select the lowest drop down 
		 * @param driver
		 * @param productname
		 * @param sortoptions
		 * @return
		 */
		
	  public String clickOnLowestPriceProduct(WebDriver driver ,String productname, String sortoptions )
	  {
		  selectDropdow(sortDropdown,sortoptions);
		  WebElement ele = driver.findElement(By.xpath("//div[.='"+productname+"']"));
		  String ProductDetails = ele.getText();
		  ele.click();
		  return ProductDetails;
		  
		  
	  }
	  public void clickLogout()
	  {
		  menubtn.click();
		  logoutlink.click();
	  }
	  public void clickOncardcontainer()
	  {
		  cardcontainer.click();
	  }
		



	

	
}
