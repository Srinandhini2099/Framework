package DAY1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SauceLaps_Login {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
				// TODO Auto-generated method stub
		//Sign up with google account sauce Labs for Sauce Mobileproduct

				WebDriver driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get("https://www.saucedemo.com/");
				driver.findElement(By.id("user-name")).sendKeys("standard_user");
				driver.findElement(By.id("password")).sendKeys("secret_sauce");
				driver.findElement(By.id("login-button")).click();
				driver.manage().window().maximize();
				driver.findElement(By.id("react-burger-menu-btn")).click();
				
			    WebElement e1 = driver.findElement(By.id("about_sidebar_link"));
			    e1.click();
			    Actions a=new Actions(driver);
			    WebElement e2 = driver.findElement(By.xpath("//span[.='Products']"));
			    a.moveToElement(e2).perform();
			    WebElement e3 = driver.findElement(By.xpath("//span[.='Sauce Mobile']"));
			    a.moveToElement(e3).click().build().perform();
			    driver.findElement(By.xpath("//button[.='Start testing free']")).click();
			    driver.findElement(By.xpath("//span[.='Sign up with Google']")).click();
			    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("");
			    driver.findElement(By.xpath("//button[@jscontroller='soHxf']")).click();
			    driver.findElement(By.name("firstName")).sendKeys("SRINANDHINI");
			    driver.findElement(By.name("lastName")).sendKeys("PALANISAMY");
			   WebElement month = driver.findElement(By.id("month-label"));
			   Select s=new Select(month);
			    s.selectByContainsVisibleText("August");
			  

			    
			    

			}

	


	}


