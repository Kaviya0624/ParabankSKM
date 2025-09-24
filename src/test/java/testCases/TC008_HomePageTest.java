package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC008_HomePageTest extends BaseClass {
	
	
	@Test
	public void VerifyHomePage() throws InterruptedException
	{
		
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);

		lp.setUsername(p.getProperty("UsernameID"));
		logger.info("User entered the User Name:");
		lp.setPassword(p.getProperty("UserPasswordId"));
		logger.info("User entered the password:");
		Thread.sleep(2000);
		lp.clickSubmit();
		
			hp.clickAboutUs();
	        logger.info("Clicked About Us link");
	        
	        String actualHeading = hp.getMainHeadingText();
			String expectedHeading = "ParaSoft Demo Website";

			
			Assert.assertEquals(actualHeading, expectedHeading, "Main heading text does not match!");
			System.out.println("Heading verified: " + actualHeading);


	        hp.clickServices();
	        logger.info("Clicked Services link");
	        scrollToBottom();
	        Thread.sleep(2000);
	        Assert.assertEquals(
	        		hp.getAvailableRestServicesText(), 
	        	    "Available RESTful services:", 
	        	    "RESTful services text does not match!");
	        System.out.println("RESTful services text verified.");
	        scrollToTop(); 
	        Thread.sleep(2000);
	        
	        hp.clickProducts();
	        logger.info("Clicked Products link");
	        scrollToBottom();
	        Thread.sleep(2000);
	        scrollToTop(); 
	        hp.clickClose();
	        hp.clickProducts();
	        hp.clickSolutions();
	        hp.clickIndustries();
	        hp.clickCustomerSuccess();
	        hp.clickResources();
	        
	        driver.navigate().back();
	        hp.clickLocations();
	        logger.info("Clicked Locations link");

	        hp.clickAdminPage();
	        logger.info("Clicked Admin Page link");

	        // 3️⃣ Click and verify quick links
	        hp.clickHome();
	        logger.info("Clicked Home link");

	        hp.clickAbout();
	        logger.info("Clicked About link");

	        hp.clickContact();
	        logger.info("Clicked Contact link");

	        logger.info("All homepage verifications completed successfully!");
	        System.out.println("Homepage heading and all links clicked successfully.");
	    }
		
	}


