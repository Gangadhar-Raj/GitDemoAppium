package MobileAutomation;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcomerceTest extends BaseTest {

	@Test
	public void FillForm() throws MalformedURLException
	{
		Config();
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pinky");
		//use to hide keypad
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioFemale']")).click();
		//dropdown
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']")).click();
		//scroll
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")).click();
		
		//toast or popup message 
		String Message = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(Message, "Please enter your name");
		// https://testng.org/testng-eclipse-update-site https://testng.org/testng-eclipse-update-site https://testng.org/testng-eclipse-update-site https://testng.org/testng-eclipse-update-site
	}
}
