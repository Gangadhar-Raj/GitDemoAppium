package MobileAutomation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	
	public AndroidDriver driver;
	public AppiumDriverLocalService appiumService;
	
	
	public void Config() throws MalformedURLException
	{
		//Automate for running appium server and mention main.js file
		//appiumService = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\gangadhar.rajashekar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(200)).build();
		//appiumService.start();
		
		// Other capabilities...

		//appiumService = new AppiumServiceBuilder().withAppiumJS(new File("C:\\\\Users\\\\gangadhar.rajashekar\\\\AppData\\\\Roaming\\\\npm\\\\node_modules\\\\appium\\\\build\\\\lib\\\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(200)).build();
		//appiumService = AppiumDriverLocalService.buildService(builder);
		//appiumService.start();
		UiAutomator2Options options = new UiAutomator2Options();
    	options.setDeviceName("Oneplus 7 Pro");
    	options.setApp("E:\\Udemy\\Selenium\\downloads\\My_workplace\\MobileTest\\src\\test\\java\\Resource\\General-Store.apk");    	
    	
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
		
	
	public void LongPress(WebElement Ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
        	    "elementId", ((RemoteWebElement) Ele).getId(),"Duration",2000));
	}
	
	public List<HashMap<String, String >> getJsonData(String jsonFilePath) throws IOException
	{
		//Converting jsonfile to json string 
		String JsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Ecommerce\\testData\\eCommerce.json"));
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>(){
			
		});
		return data;
		
		}
	
	public String GetScreenShotPath(String TestCaseName, AndroidDriver driver) throws IOException
	{
		//getting screenshot if file format
		File Source = driver.getScreenshotAs(OutputType.FILE);
		//Place path in project for screenshot
		String DestinationFile = System.getProperty("user.dir")+"//reports"+TestCaseName+".png";
		FileUtils.copyFile(Source, new File(DestinationFile));
		return DestinationFile;
	}
	
}

