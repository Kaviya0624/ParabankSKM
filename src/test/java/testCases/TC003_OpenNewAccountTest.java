package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.OpenNewAccountPage;
import testBase.BaseClass;

public class TC003_OpenNewAccountTest extends BaseClass {

	@Test
	public void OpenNewAccountTest() throws InterruptedException {

		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		OpenNewAccountPage newAcct = new OpenNewAccountPage(driver);

		lp.setUsername(p.getProperty("UsernameID"));
		logger.info("User entered the User Name:");

		lp.setPassword(p.getProperty("UserPasswordId"));
		logger.info("User entered the password:");
		Thread.sleep(2000);
		lp.clickSubmit();

		logger.info("User clicked on Login Button");
		Thread.sleep(2000);

		newAcct.clickOnOpenNewAccount();
		logger.info("user clicked on Open New Account");
		Thread.sleep(1000);
		driver.getPageSource().contains("Open New Account");

        newAcct.selectAccountType("SAVINGS");
     
        newAcct.clickOnOpenNewAccountSubmitBtn();
        logger.info("Clicked on 'Open New Account' submit button");

      
        String confmsg = newAcct.getConfirmationMsg();
        Assert.assertFalse(confmsg.equals("Congratulations, your account is now open."), "ACCOUNT CCREATED");
		  
			

	}
}
