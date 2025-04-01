package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	@FindBy(id="add-to-cart")
	private WebElement addtocardbtn;
	
	@FindBy(xpath="(\"//dive[@class='inventory_details_price']\"")
	private WebElement price;
	
	//Create constructor to Initialize
		public InventoryItemPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getAddtocardbtn() {
			return addtocardbtn;
		}

		public WebElement getPrice() {
			return price;
		}



}
