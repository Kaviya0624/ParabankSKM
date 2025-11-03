package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FooterSection;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC009_FooterTest extends BaseClass {
	
	
	@Test(priority=1,groups={"Sanity" , "Master"})
	public void VerifyFooterSection() throws InterruptedException
	{
		try
		{
		FooterSection fp = new FooterSection(driver);
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		loginToApp();
		
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
		catch(Exception e)
		{
			 Assert.fail();
		}
		
	
	}

}
