package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {


	@FindBy(className="inventory_item_name")
	private WebElement productdetails;
	
	@FindBy(id="checkout")
	private WebElement checkout;
	
	//Create constructor to Initialize
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getProductdetails() {
		return productdetails;
	}
	public WebElement getCheckout() {
		return checkout;
	}	
	
	/**
	 * This method will return the product name
	 * @return
	 */
   public String getProductName()
   {
	   return productdetails.getText();
   }
   /**
    * This method will click on checkout butyton
    */
   public void clickOnCheckout()
   { 
	   checkout.click();
	   
   }
   
   
}
