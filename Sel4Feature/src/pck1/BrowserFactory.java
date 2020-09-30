package pck1;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class BrowserFactory
 {

	
	private static BrowserFactory intancce=null;
	ThreadLocal<WebDriver> tl= new ThreadLocal<WebDriver>();
	
	 private  BrowserFactory()
	{
		
	}
	public static BrowserFactory getInstance()
	{
	if(intancce==null)
	{
		intancce = new BrowserFactory();
	}
	return intancce;
	}
	
	public void setDriver(String bName) throws FileNotFoundException, IOException
	{
		switch(bName){
		
		case "chrome":
			//System.out.println("seelcted chrome!");
			BaseSetup.baseSetup();
		 break;
		case "mozila":
			BaseSetup.baseSetup1();
			//System.out.println("seelcted mozila!");
			break;
			
			default:
				System.out.println("pls select proper browser");
		}
		}
		
		public WebDriver getDriver()
		{
			return tl.get();
		}
			
		
	
	
}
