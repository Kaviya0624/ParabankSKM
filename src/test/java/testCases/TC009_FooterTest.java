package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FooterSection;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC009_FooterTest extends BaseClass {
	
	
	@Test
	public void VerifyFooterSection() throws InterruptedException
	{
		FooterSection fp = new FooterSection(driver);
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(p.getProperty("UsernameID"));
		logger.info("User entered the User Name:");
		lp.setPassword(p.getProperty("UserPasswordId"));
		logger.info("User entered the password:");
		Thread.sleep(2000);
		lp.clickSubmit();
		
		scrollToBottom();
		Thread.sleep(2000);
		
		String actualHeading = fp.getCopyrightText();
    	Assert.assertEquals(actualHeading, "© Parasoft. All rights reserved.");
    	
    	
		hp.clickHome();
		
		fp.clickFTAboutUs();
		fp.clickFTServices();
		
		fp.clickFTProducts();
		driver.navigate().back();
		fp.clickFTLocations();
		driver.navigate().back();
		
		fp.clickForum();
		Thread.sleep(2000);
		scrollToBottom();
		scrollToTop();
		//fp.clickPosts();
		fp.clickCategories();
		
		driver.get(p.getProperty("baseURL"));

		fp.clickSiteMap();
		
		 hp.clickContact();
	     logger.info("Clicked Contact link");

	        hp.enterName(randomeString().toUpperCase());
	        hp.enterEmail(randomeString()+"@gmail.com");
	        hp.enterPhone(randomeNumber());
	        hp.enterMessage("good");
	        hp.clickSendToCustomerCare();
	
	}

}
