
package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pck1.BaseSetup;

public class Test1 extends BaseSetup {

	
	WebDriver driver ;
	@BeforeTest
	public void setUp() throws FileNotFoundException, IOException
	{
		BaseSetup.baseSetup();
	}
	
	@Test()
	public void f1()
	{
		//driver.navigate().to("");
		driver.get("https://www.lambdatest.com/blog/desired-capabilities-in-selenium-testing/");
		
		List<WebElement> ele = driver.findElements(By.tagName("img"));//to find all image on page.
		
		int l=ele.size();
		System.out.println("size  :"+ l);
		for(int i=0 ;i<l;i++)
		{
			System.out.println(ele.get(i).getAttribute("src")+"  : "+ ele.get(i).getAttribute("href"));
		}
	}
	@Test
	public void getWHandle()
	{
		Set<String> st = driver.getWindowHandles();
		//driver.switchTo().wi
	}
	
	@AfterTest()
	
		public void tearDown() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.quit();
		}
	
}

