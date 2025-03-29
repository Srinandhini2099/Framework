package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Create class name with page nama
	//Identify all web element using @FindBy Annotation
	
	@FindBy(id="user-name")
	private WebElement usernametxt;
	
	@FindBy(id="password")
	private WebElement passwordtxt;
	
	@FindBy(id="login-button")
	private WebElement Loginbut;
	
	//Create constructo to inialize the webelemt 
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Provide getter to access yhe webelement


	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getLoginbut() {
		return Loginbut;
	}
	
	



}
