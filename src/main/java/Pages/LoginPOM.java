package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class LoginPOM {
	
	private AndroidDriver driver;
	public WebDriverWait wait;
	
	public LoginPOM(AndroidDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}


	By username = AppiumBy.accessibilityId("test-Username");
	By password = AppiumBy.accessibilityId("test-Password");
	By login = By.xpath("//android.widget.TextView[@text='LOGIN']");
	//By login = By.xpath("//android.widget.TextView[@text='WRONG_BUTTON']");
	By Error = By.xpath("//android.widget.TextView[@text='Username and password do not match any user in this service.']");
	
	
	public void login(String user,String pass)
	{
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));----> this line should be at once in the base class 
		
	}
	public ProductPOM clicklogin()
	{
		if(driver.isKeyboardShown())
		{
			driver.hideKeyboard();
		}
				
		// 2. Wait until the LOGIN button is actually ready
	    wait.until(ExpectedConditions.elementToBeClickable(login));

		driver.findElement(login).click();
	    // ADD THIS LINE - This is the bridge
	    return new ProductPOM(driver); 
	}
	public boolean error()
	{
		return driver.findElements(Error).size() > 0;
	}
	
	
	

}
