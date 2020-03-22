package mmp;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Scheduleappointment  {
	
	@Test(priority=1)	
	public void Loginpagetest ()throws Exception  {  // valid login
    	WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
    Utilities utils=new Utilities(driver);
    utils.validateLoginPage("ria1", "Ria12345");
    Assert.assertEquals(driver.getTitle(),"home");
    driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
        WebElement current = driver.findElement(By.className("panel-title"));
        boolean title = current.isDisplayed();
        Assert.assertEquals(title, true);
     List<WebElement> Listdetails = driver.findElements(By.xpath("//div[@class='list-group list-statistics']//a"));
     int size = Listdetails.size();
     Assert.assertEquals(size,4 );
     driver.findElement(By.xpath("//input[@type='submit']")).click();
 TakesScreenshot ts =  (TakesScreenshot)driver;
 File file = ts.getScreenshotAs(OutputType.FILE);
File destfile = new File("./target.png");
FileUtils.copyFile(file, destfile);
   driver.findElement(By.xpath("//h4[text()='Dr.Beth']//ancestor::ul/following-sibling::button")).click();
  
 
	}

 

	 }
	

 