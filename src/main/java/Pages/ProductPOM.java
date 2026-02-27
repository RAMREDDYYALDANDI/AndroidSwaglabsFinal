package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Guesters;
import io.appium.java_client.android.AndroidDriver;

public class ProductPOM {
	private AndroidDriver driver;
	public WebDriverWait wait;
	public Guesters guest;
	
	public ProductPOM(AndroidDriver driver)
	{
		this.driver=driver;
		this.guest = new Guesters(driver);
		this.wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	By productpage = By.xpath("//android.widget.TextView[@text='PRODUCTS']");
	By addtocart = By.xpath("//android.view.ViewGroup[@content-desc='test-ADD TO CART']");
	By alltext = By.xpath("//android.widget.TextView[@content-desc='test-Item title']");
	By cartpage = By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView");
	
	public void scrolltoproduct(String productname)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(productpage));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(productpage));
		 driver.findElement(productpage).isDisplayed();
		
		 guest.ScrollText(productname);
	}

	public void clicktoproduct(String productname) {
		// Grab all product titles currently on screen
		int productcount = driver.findElements(alltext).size();
		
		for(int i=0; i<productcount; i++)
		{
			String product = driver.findElements(alltext).get(i).getText();
			
			if(product.equalsIgnoreCase(productname))
			{
				// Wait for the buttons to be ready
		        wait.until(ExpectedConditions.visibilityOfElementLocated(addtocart));
		        wait.until(ExpectedConditions.elementToBeClickable(addtocart));

				// Click the button at the SAME index as the found product title
				driver.findElements(addtocart).get(i).click();
				System.out.println("✅ Successfully clicked: " + productname);
				break;
			}
		}
		

	}
	public CartPOM catpage()
	{
		 driver.findElement(cartpage).click();
		
		return new CartPOM(driver);
	}
}
