package MobileAutomation;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BowserBaseTest{

	@Test
	public void browserTest() throws MalformedURLException
	{
		Config();
		//driver.get("http://google.com");
		//System.out.println(driver.getTitle());
		//driver.findElement(By.name("q")).sendKeys("Rahul Shetty Academy");
	    //driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		//use to scroll the browser
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
		String productName = driver.findElement(By.cssSelector("a[href*='/products/3']")).getText();
		Assert.assertEquals(productName, "Devops");
		
	}
}
