package pck1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseSetup {

	 static WebDriver driver;
	public static WebDriverWait wait = null;

	public static void baseSetup() throws FileNotFoundException, IOException {

		System.out.println("launching chrome browser");
		
		 DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setAcceptInsecureCerts(true);//for selenium 4
		// cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		  ChromeOptions option = new ChromeOptions(); 
		  option.addArguments("--start-maximized");
		  option.addArguments("--incognito");
		 
		// System.setProperty("webdriver.chrome.driver",
		// "//D:///Browsers//chromedriver.exe");
		  option.merge(cap);
         WebDriverManager.chromedriver().setup();
       
		driver = new ChromeDriver(option);// D:\test
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// wait = new WebDriverWait(driver, 60);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		//driver.manage().window().maximize();
		// driver.get("http://www.bhu.ac.in/");
	}

	public static void baseSetup1()
	{
		
	}

}
