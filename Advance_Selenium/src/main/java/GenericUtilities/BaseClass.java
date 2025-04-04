package GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;
/**
 * This class consists of basic configuration annotations of TestNG
 * @author SRINANDHINI
 */

public class BaseClass {
	//creating objects for utilities to do baseic operations
	public FileUtility Futil=new FileUtility();
	public JavaUtility JUtil=new JavaUtility();
	public SeleniumUtility SUtil=new SeleniumUtility();
	
	//Initializing webdriver
	public WebDriver driver;
	@BeforeSuite
	public void dBConnection()
	{
		System.out.println("Data base connection successfully done");
	}
	
	@BeforeClass
	public void launchbrowser() throws IOException
	{
		driver=new ChromeDriver();
		SUtil.maximizewindow(driver);
		SUtil.implicitwait(driver);
		String URL=Futil.readDataFromPropertyFile("url");
		driver.get(URL);
	}
	@BeforeMethod
	public void LoginApp() throws IOException
	{
		String USERNAME=Futil.readDataFromPropertyFile("username");
	    String PASSWORD=Futil.readDataFromPropertyFile("password");
	    //to login using POM class
	    LoginPage lp=new LoginPage(driver);
	    lp.LoginToApp(USERNAME, PASSWORD);
	    System.out.println("Login to the App Successfuly");
	}
    @AfterMethod
    public void LogoutApp()
    {
    	InventoryPage Ip=new InventoryPage(driver);
    	Ip.clickLogout();
    }
    @AfterClass
    public void closeBrowser()
    {
    	driver.quit();
    }
    @AfterSuite
    public void dBConnectionclose()
    {
    	System.out.println("Data base connection successfully closed");
    }
}
