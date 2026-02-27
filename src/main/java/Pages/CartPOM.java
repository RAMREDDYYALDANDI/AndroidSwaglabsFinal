package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CartPOM {

	public AndroidDriver driver;
	public WebDriverWait wait;
	
	public CartPOM(AndroidDriver driver) {
		
		this.driver=driver;
		this.wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	By cartpagevalidation = By.xpath("//android.widget.TextView[@text='YOUR CART']");
	// Use this to get ONLY the titles
	// This Targets the title specifically by its unique content-desc
	// This finds EVERY product title without needing the specific name
	By cartItemTitles = By.xpath("//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]");
	
	public void cart()
	{
		 // Wait for the element to be present before checking visibility
	    wait.until(ExpectedConditions.visibilityOfElementLocated(cartpagevalidation));
		boolean cartvisible =driver.findElement(cartpagevalidation).isDisplayed();
		System.out.println("the cart page is visible: " + cartvisible);
		
	}
	
	public List<String> cartitems()
	{
		System.out.println("🔍 Searching for items in Cart...");
		wait.until(ExpectedConditions.presenceOfElementLocated(cartItemTitles));
		List<WebElement> elements = driver.findElements(cartItemTitles);
		List<String> itemnames = new ArrayList<>();
		for(WebElement ele:elements)
		{
			itemnames.add(ele.getText());
		}
		return itemnames;
	}

}
