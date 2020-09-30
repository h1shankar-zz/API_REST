package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pck1.BaseSetup;
import pck1.BrowserFactory;

public class ParTest {
	WebDriver driver;
	/*@BeforeTest
	public void setUp() throws FileNotFoundException, IOException
	{
		BaseSetup.baseSetup();
	}*/
	
	//@Test(threadPoolSize=3,invocationCount=3,timeOut=1000)
	@Test()
	public void gDWTest() throws FileNotFoundException, IOException
	{
		BrowserFactory bf=BrowserFactory.getInstance();
		bf.setDriver("chrome");
		//driver=BrowserFactory.getInstance().getDriver();
		bf.getDriver().get("https://www.google.com/");
		bf.getDriver().findElement(By.xpath("//input[@type=\"text\" and @title=\"Search\"]")).sendKeys("dow jones");
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		bf.getDriver().quit();
	}
	
	@Test
	public void gMoTest() throws InterruptedException, FileNotFoundException, IOException
	{
		BrowserFactory.getInstance().setDriver("mozila");
		driver=BrowserFactory.getInstance().getDriver();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@type='text' and @title='Search']")).sendKeys("moneycontrol");
		Thread.sleep(1000);
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		driver.quit();
	}
	
	@Test
	public void gDJTest() throws InterruptedException, FileNotFoundException, IOException
	{
		BrowserFactory.getInstance().setDriver("chrome");
		driver=BrowserFactory.getInstance().getDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@type='text' and @title='Search']")).sendKeys("dainik jagran epaper");
		Thread.sleep(1000);
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		driver.quit();
	}
	
	//
	//@AfterTest()
	
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
}
