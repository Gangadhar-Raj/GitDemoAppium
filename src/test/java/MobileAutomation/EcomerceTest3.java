package MobileAutomation;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class EcomerceTest3 extends BaseTest {

	@Test
	public void FillForm() throws MalformedURLException
	{
		Config();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pinky");
		//use to hide keypad
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioFemale']")).click();
		//dropdown
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']")).click();
		//scroll
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")).click();
		
		driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")).click();
		driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		List<WebElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrice.size();
		double totalsum =0;
		
		for(int i=0; i<count; i++)
		{
			String amount = productPrice.get(i).getText();
			//we need to add the product price to do so we need to remove the dollar sign in the price 
			//$160.97  substring is used to remove dollar
			Double price = Double.parseDouble(amount.substring(1));
			totalsum = totalsum + price;  
			 System.out.println(totalsum);
		}
		
		String SumAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displaysumofAmount= getFormatedAmount(SumAmount);
       // Assert.assertEquals(totalsum, displaysumofAmount);
        
        System.out.println(displaysumofAmount);
        
       WebElement Ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        
       LongPress(Ele);
		
       driver.findElement(By.id("android:id/button1")).click();
       driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
       driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	}

	
	}

