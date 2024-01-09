package MobileAutomation;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcomerceTest2 extends BaseTest {

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
		
		//product screen
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

		int ProductCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for (int i=0; i<ProductCount; i++)
		{
			String ProductName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(ProductName.equalsIgnoreCase("Jordan 6 Rings"))
				{
				  driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		String Productneeded = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(Productneeded, "Jordan 6");
		
	}
}
