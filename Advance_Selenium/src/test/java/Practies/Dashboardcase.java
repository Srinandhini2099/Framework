package Practies;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Dashboardcase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//Sign up with google account in sauce Labs Dashboard page
				//to disable browser notification
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("disable-notifications");
				WebDriver driver=new ChromeDriver(opt);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get("https://www.saucedemo.com/");
				driver.findElement(By.id("user-name")).sendKeys("standard_user");
				driver.findElement(By.id("password")).sendKeys("secret_sauce");
				driver.findElement(By.id("login-button")).click();
				driver.manage().window().maximize();
				driver.findElement(By.id("react-burger-menu-btn")).click();
//				Alert a=driver.switchTo().alert();
//				a.accept();
//				
			    WebElement e1 = driver.findElement(By.id("about_sidebar_link"));
			    e1.click();
			    driver.findElement(By.xpath("//button[.='Go to Dashboard']")).click();
			    driver.findElement(By.xpath("//a[@title='Authenticate with Google'")).click();
			}

	}


