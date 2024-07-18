package Tasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pellisambandhalu.Library.Utility;
import com.pellisambandhalu.screenshots.GetScreenShot;

public class FaceBookCreateAccountFunctionality {
	
	
	
	@Test
	public void createFaceBook() {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.facebook.com/");
		
		WebElement linkTest = driver.findElement(By.linkText("Create new account"));
		linkTest.click();
		//driver.findElement(By.xpath("//div[text() = 'Sign Up']"));
		Utility.waitForElementPresent(driver, By.xpath("//div[text() = 'Sign Up']"), 30);
		GetScreenShot.getScreenShot(driver, "CreateNewAccountPage");
		
		WebElement female = driver.findElement(By.xpath("//span[@data-type = 'radio']/span[1]/label/following-sibling :: input"));
	    WebElement male = driver.findElement(By.xpath("//span[@data-type = 'radio']/span[2]/label/following-sibling :: input"));
	    WebElement custom = driver.findElement(By.xpath("//span[@data-type = 'radio']/span[1]/label/following-sibling :: input"));
	    
	    female.click();
	    
	    Assert.assertEquals(female.isSelected(), true);
	    Assert.assertEquals(male.isSelected(), false);
	    
	}
	

}
