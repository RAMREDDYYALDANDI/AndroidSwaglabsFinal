package Base;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	protected Properties prop;
	public static AndroidDriver driver;
	
	@BeforeClass
	public void AppiumSetup() throws IOException
	{
		if(driver == null) {
		prop = new Properties();
		prop.load(getClass().getClassLoader().getResourceAsStream("Config.properties"));
		System.out.println("Loaded Keys: "+ prop.keySet());
		System.out.println("APPIUM APP OPENED:[" +prop.getProperty("appiumURL")+ "]");
		
		 // 1. Use UiAutomator2Options (Modern Appium 2.0 way)
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(prop.getProperty("platformName"));
        options.setDeviceName(prop.getProperty("deviceName"));
        options.setAutomationName(prop.getProperty("automationName"));
        options.setAppPackage(prop.getProperty("appPackage"));
        options.setAppActivity(prop.getProperty("appActivity"));
        options.setNoReset(Boolean.parseBoolean(prop.getProperty("noReset")));
        
        URL url = new URL(prop.getProperty("appiumURL"));
        driver =new AndroidDriver(url,options);
        
        System.out.println("✅ APPIUM SESSION STARTED SUCCESSFULLY");	
				
	}
		
	}
	public String screenshotfailure(String testcaseName,AndroidDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
		
		FileUtils.copyFile(source, new File(destination));
		return destination;
		
	}
}
