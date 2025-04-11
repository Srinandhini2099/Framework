package GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

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
	//For Listener
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun =true)
	public void dBConnection()
	{
		System.out.println("Data base connection successfully done");
	}
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun =true)
	public void launchbrowser() throws IOException
	{
		driver=new EdgeDriver();
		sdriver=driver;
		
		//For cross Browser Execution Run time polymorphisam
//		if(pvalue.equalsIgnoreCase("chrome"))
//		{
//			driver=new ChromeDriver();
//		}
//		else if(pvalue.equalsIgnoreCase("Firefox"))
//		{
//			driver=new FirefoxDriver();
//
//		}
//		else
//		{
//			driver=new ChromeDriver();
//
//		}
		
		SUtil.maximizewindow(driver);
		SUtil.implicitwait(driver);
		String URL=Futil.readDataFromPropertyFile("url");
		driver.get(URL);
		System.out.println("Browser open successfully");
	}
	@BeforeMethod(alwaysRun =true)
	public void LoginApp() throws IOException
	{
		String USERNAME=Futil.readDataFromPropertyFile("username");
	    String PASSWORD=Futil.readDataFromPropertyFile("password");
	    //to login using POM class
	    LoginPage lp=new LoginPage(driver);
	    lp.LoginToApp(USERNAME, PASSWORD);
	    System.out.println("Login to the App Successfuly");
	}
    @AfterMethod(alwaysRun =true)
    public void LogoutApp()
    {
    	InventoryPage Ip=new InventoryPage(driver);
    	Ip.clickLogout();
    	System.out.println("Logout to the App successfully");
    }
    @AfterClass(alwaysRun =true)
    public void closeBrowser()
    {
    	driver.quit();
    	System.out.println("Browser closed successfuly");
    }
    @AfterSuite(alwaysRun =true)
    public void dBConnectionclose()
    {
    	System.out.println("Data base connection successfully closed");
    }
}
