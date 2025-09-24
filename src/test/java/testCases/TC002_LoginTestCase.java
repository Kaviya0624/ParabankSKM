package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTestCase extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException {

		logger.info("URL is opened");

		LoginPage lp = new LoginPage(driver);

		lp.setUsername(p.getProperty("UsernameID"));
		logger.info("User entered the User Name:");
		lp.setPassword(p.getProperty("UserPasswordId"));
		logger.info("User entered the password:");
		Thread.sleep(2000);
		lp.clickSubmit();
		logger.info("User clicked on Login Button");
		Thread.sleep(2000);

		String successMsg =lp.getSuccessLogin();
		Assert.assertTrue(successMsg.contains("Accounts Overview"),
		                  "Account Loggedin Actual message: " + successMsg);


		lp.clickLogOut();


			
		 logger.info("User not able to logout!");
		}

	}



	

