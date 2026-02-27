package Utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Guesters {
	public AndroidDriver driver;
	
	public Guesters(AndroidDriver driver)
	{
		this.driver=driver;
	}
	
	public void ScrollText(String text)
	{
		 // Corrected Syntax: UiSelector().scrollable(true) 
	    // Simplified: No need for .fromParent() for a basic text scroll
	    driver.findElement(AppiumBy.androidUIAutomator(
	        "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"
	    ));
	}

}
