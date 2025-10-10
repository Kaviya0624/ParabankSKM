package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {

//public static WebDriver driver; //for capture screenshot make it static other wise remove static
public static WebDriver driver; 
public Logger logger;  //Log4j
public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
				
		logger=LogManager.getLogger(this.getClass());  //lOG4J2
				
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WINDOWS);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
				
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
				
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{

			switch(br.toLowerCase())
			{
			case "chrome" : 
				final Map<String, Object> chromePrefs = new HashMap<>();
				chromePrefs.put("credentials_enable_service", false);
				chromePrefs.put("profile.password_manager_enabled", false);
				chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

				final ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setExperimentalOption("prefs", chromePrefs);
				driver=new ChromeDriver(chromeOptions); 
				break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
			}
		}
		
		
			
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("baseURL")); // reading url from properties file.
		driver.manage().window().maximize();
		
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomeString()
	{

		return RandomStringUtils.secure().nextAlphabetic(6);
	}
	
	public String randomeNumber()
	{
		 return RandomStringUtils.secure().nextNumeric(10);
	}
	
	public String randomeAlphaNumberic()
	{
		 String letters = RandomStringUtils.secure().nextAlphabetic(3);
		    String digits  =RandomStringUtils.secure().nextNumeric(3);
		    return letters + "@" + digits;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshorts\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	public void scrollToBottom() 
	{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
	
	  public void scrollToTop() 
	  {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, 0);");
	  }
	  
	  public void autoHandleCookies() {
		    try {
		        // 1️⃣ Check for cookie banner in main page
		        List<WebElement> buttons = driver.findElements(
		            By.xpath("//button[contains(text(),'Accept') or contains(text(),'I Agree') or contains(text(),'Accept All')]")
		        );
		        if (!buttons.isEmpty()) {
		            buttons.get(0).click();
		            System.out.println("Cookies accepted on main page.");
		            return;
		        }

		        // 2️⃣ Check for cookie banner inside common iframes
//		        String[] possibleFrames = {"cookieFrame", "gdpr-consent-notice", "iframeCookie"};
//		        for (String frameName : possibleFrames) {
//		            try {
//		                driver.switchTo().frame(frameName);
//		                buttons = driver.findElements(
//		                    By.xpath("//button[contains(text(),'Accept All') or contains(text(),'I Agree') or contains(text(),'Accept All')]")
//		                );
//		                if (!buttons.isEmpty()) {
//		                    buttons.get(0).click();
//		                    System.out.println("Cookies accepted inside iframe: " + frameName);
//		                }
//		                driver.switchTo().defaultContent();
//		                break;  // stop after finding one banner
//		            } catch (NoSuchFrameException e) {
//		                // frame not found, continue
//		            }
//		        }

		    } 
		    catch (Exception e) 
		    {
		        System.out.println("No cookies banner found or already handled.");
		    }
		}


}
