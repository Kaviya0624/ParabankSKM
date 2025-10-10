package testCases;

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
	  
	        hp.clickProducts();
	        logger.info("Clicked Products link");
	        autoHandleCookies();
	        Thread.sleep(1000);
	        scrollToBottom();
	        Thread.sleep(1000);
	        scrollToTop(); 
	        Thread.sleep(1000);
	        hp.clickProductsSec();
	        Thread.sleep(1000);
	        hp.clickSolutions();
	        Thread.sleep(1000);
	        hp.clickIndustries();
	        Thread.sleep(1000);
	        hp.clickCustomerSuccess();
	        Thread.sleep(1000);
	        hp.clickResources();
	        Thread.sleep(1000);

	        
	        driver.navigate().back();
	        hp.clickLocations();
	        logger.info("Clicked Locations link");
	        driver.navigate().back();
	        
	        hp.clickAdminPage();
	        logger.info("Clicked Admin Page link");
	        
	        String actualHeading2 = hp.getAdministrationHeading();
	    	Assert.assertEquals(actualHeading2, "Administration");
	        

	        hp.clickHome();
	        logger.info("Clicked Home link");

	        hp.clickAbout();
	        logger.info("Clicked About link");

	        hp.clickContact();
	        logger.info("Clicked Contact link");

	        hp.enterName(randomeString().toUpperCase());
	        hp.enterEmail(randomeString()+"@gmail.com");
	        hp.enterPhone(randomeNumber());
	        hp.enterMessage("good");
	        hp.clickSendToCustomerCare();
	        
	       
	        logger.info("All homepage verifications completed successfully!");
	        
	    }
		
	}


