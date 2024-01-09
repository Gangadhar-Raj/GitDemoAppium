package MobileAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BowserBaseTest {

	
	public AndroidDriver driver;
	public AppiumDriverLocalService appiumService;
	
	
	public void Config() throws MalformedURLException
	{
		UiAutomator2Options options = new UiAutomator2Options();
    	options.setDeviceName("Oneplus 7 Pro");
        //Need to set chrome driver path 
    	options.setCapability("browserName", "Chrome");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        
	}
	
	public void WaitForElementToVisible(By VisibleOfELement )
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
		wait.until(ExpectedConditions.elementToBeClickable(VisibleOfELement));
				
	}

	
	public Double getFormatedAmount(String displaySum) {
		// TODO Auto-generated method stub
		
			Double price = Double.parseDouble(displaySum.substring(1));
			return price;
		}
		
	
	
}
