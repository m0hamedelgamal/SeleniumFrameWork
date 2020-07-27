package testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilites.Helper;

public class TestBase 
{
	public static WebDriver driver ; 
	public static String downloadPath= System.getProperty("user.dir")+"\\Downloads" ;

	public static ChromeOptions chromeOption()
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}

	public static FirefoxOptions fireFoxOption()
	{

		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("firefox") String browserType)
	{	
		if (browserType.equalsIgnoreCase("chrome")) 

		{
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");	
			driver= new ChromeDriver(chromeOption()); 
		}

		else if (browserType.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver= new FirefoxDriver(fireFoxOption()); 
		}

		else if (browserType.equalsIgnoreCase("IE")) 
		{
			System.setProperty("webdriver.ie.driver", 
					System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		else if (browserType.equalsIgnoreCase("edge")) 
		{
			System.setProperty("webdriver.edge.driver", 
					System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.navigate().to("https://demo.nopcommerce.com/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@AfterSuite
	public void CloseDriver()
	{
		//driver.quit();
	}
	public void clearCookies()
	{

	}	
	@AfterClass 
	public void navigateToHome()
	{

		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	@AfterMethod
	public void screenshootonfailure(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			System.out.println("please wait taking screenshoot ");
			Helper.takeScreenShoot(driver, result.getName());
			System.out.println("Ready ");
		}
	}
}
