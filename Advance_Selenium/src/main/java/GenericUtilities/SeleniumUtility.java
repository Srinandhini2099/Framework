package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.swing.text.Document;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimizewindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to wait some time 
	 */
	
	public void implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	/**
	 * This method is used to wait perdicular element to be visible 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
    /**
     * This method is explicitly will wait perticular element to be clikable
     * @param driver
     * @param element
     */
	
	public void waitForElementClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to handle dropdown by index
	 * @param element
	 */
	public void selectDropdow(WebElement element,int index) 
	
	{
		Select s=new Select(element);
		s.selectByIndex(index);
		
		
	}
	/**
	 * This method will handle drop down bu text 
	 * @param element
	 * @param text
	 */
    public void selectDropdow(WebElement element,String text) 
	
	{
		Select s=new Select(element);
		s.selectByContainsVisibleText(text);
		
		
	}
    /**
	 * This method will handle drop down by value
	 * @param element
	 * @param text
	 */

   public void selectDropdow(String value,WebElement element) 

  {
	Select s=new Select(element);
	s.selectByValue(value);
	
	
  }
   /**
    * This method is used to handle mouse actions to move webelement to perticular place
    * @param driver
    * @param element
    */
   
   public void handleMouseActions(WebDriver driver,WebElement element)
   {
	  Actions a=new Actions(driver);
	  a.moveToElement(element).perform();
	   
   }
   /**
    * This method is used to right click on element
    * @param driver
    */

   public void actionsUsingContext(WebElement element,WebDriver driver)
   {
	  Actions a=new Actions(driver);
	  a.contextClick(element).perform();
	   
   }
   /**
    * this method is used to duble click the element 
    * @param driver
    * @param element
    */
   

   public void doubleclick(WebElement element,WebDriver driver)
   {
	  Actions a=new Actions(driver);
	  a.doubleClick(element).perform();
	   
   }
   /**
    * This methos is used to Click and hold action
    * @param driver
    * @param element
    */

   public void actionsClickAndHold(WebDriver driver,WebElement element)
   {
	  Actions a=new Actions(driver);
	  a.clickAndHold(element).release(element).build().perform();
	   
	  /**
	   * This method is used to Drag and drop the element
	   */
   }
   
   
   public void actionsDragAndDrop(WebDriver driver,WebElement element,WebElement element1)
   {
		  Actions a=new Actions(driver);
		  a.dragAndDrop(element, element1).perform();
   
   }
   
/**
 * Thismethod is used to handling frames using index
 * @param driver
 * @param index
 */
   
   public void handlingframe(WebDriver driver,int index)
   {
		 driver.switchTo().frame(index);
		 
   
   }
   
   /**
    * this methd is used to handle frame using webelement
    * @param driver
    * @param frameelement
    */
   public void handlingframe(WebDriver driver,WebElement frameelement)
   {
		 driver.switchTo().frame(frameelement);
		 
  
   }
   
   /**
    * This method is used to handle frame using locator
    * @param driver
    * @param locator
    */
   public void handlingframe(WebDriver driver,String locator)
   {
		 driver.switchTo().frame(locator);
		 
   
   }
   /**
    * This method is used to contol back to imediate Main page ignoring all parent frames
    * @param driver
    */
   
   public void switchtoParent(WebDriver driver)
   {
		 driver.switchTo().parentFrame();
		 
   
   }
   /**
    * This method is used to control back to Main page 
    * @param driver
    */
   public void switchtoDefault(WebDriver driver)
   {
		 driver.switchTo().defaultContent();
		 
   
   }
   
   /**
    * This method is used to switch to single window
    * @param driver
    */
   public void switchtowindow(WebDriver driver,String windowHandle)
   {
	     driver.switchTo().window(windowHandle);
   }
      
   /**
    * This method is used to accept the alert popup 
    * @param driver
    */
   public void alertaccept(WebDriver driver)
   {
	    driver.switchTo().alert().accept();
	   
   }
   
   /**
    * This method is used to dismiss the allert pop up
    * @param driver
    */
   public void alertdismiss(WebDriver driver)
   {
	    driver.switchTo().alert().dismiss();;
	    
   
   }
   /**
    * This method is used to return the text present in the alertpopup
    * @param driver
    * @return
    */
   
   public String alergettext(WebDriver driver)
   {
	    String Text=driver.switchTo().alert().getText();
	    return Text;
   
   }
   /**
    * This method is used to enter any text inside the alert popup
    * @param driver
    * @param SENDKEYS
    */
   public void alertSendkeys(WebDriver driver,String AlertData)
   {
	    driver.switchTo().alert().sendKeys(AlertData);;
	  
   
   }
   /**
    * This 4 methods used for scrolling actions
    * @param driver
    */
   public void scrollDown(WebDriver driver)
   {
	   JavascriptExecutor Js=(JavascriptExecutor)driver;
	   Js.executeScript("Window.scrollBy(0,500)", "");
   
   }
   
   public void scrollUp(WebDriver driver)
   {
	   JavascriptExecutor Js=(JavascriptExecutor)driver;
	   Js.executeScript("Window.scrollBy(0,-500)", "");
   
   }
   public void scrollRight(WebDriver driver)
   {
	   JavascriptExecutor Js=(JavascriptExecutor)driver;
	   Js.executeScript("Window.scrollBy(500,0)", "");
   
   }
   public void scrollleft(WebDriver driver)
   {
	   JavascriptExecutor Js=(JavascriptExecutor)driver;
	   Js.executeScript("Window.scrollBy(-500,0)", "");
   
   }
   /**
    * this method is used to take screenshot and save it in a different folder 
    * @param driver
    * @param screenshotName
    * @return
    * @throws IOException
    */
   
   public String captureScreenshort(WebDriver driver,String screenshotName) throws IOException
   {
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File src=ts.getScreenshotAs(OutputType.FILE);
	   File dst=new File(".\\Screenshots\\"+screenshotName+".png");//tsname_datetime
	   FileHandler.copy(src, dst);
	   return dst.getAbsolutePath();//For External report
	   
	   
   }
      
   
   
   
   
   
   
   

   
   
   
   
   
   

	

}
