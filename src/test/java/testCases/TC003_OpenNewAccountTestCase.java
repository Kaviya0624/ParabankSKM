package testCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.OpenNewAccountPage;
import testBase.BaseClass;

public class TC003_OpenNewAccountTestCase extends BaseClass {

	@Test
	public void OpenNewAccountTest() throws InterruptedException, IOException {

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
		Thread.sleep(10000);
		driver.getPageSource().contains("Open New Account");

		String AccountTypeName = "SAVINGS";
		Select AccontTypes = new Select(newAcct.selectAccountTypes());
		AccontTypes.selectByVisibleText(AccountTypeName);
		AccontTypes.selectByIndex(1);
		logger.info(AccountTypeName);

		newAcct.clickOnOpenNewAccountSubmitBtn();
		logger.info("User Open New Account Successfully!");
		Thread.sleep(3000);
		
		if (driver.getPageSource().contains("Congratulations, your account is now open.")) {
			Assert.assertTrue(true);
			logger.info("account is now open test passed");
		} else {
			
			Assert.assertTrue(false);
			logger.info("account is now open test failed");
		}

	}
}
