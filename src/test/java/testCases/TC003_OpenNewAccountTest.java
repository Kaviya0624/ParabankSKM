package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountsOverviewPage;
import pageObjects.LoginPage;
import pageObjects.OpenNewAccountPage;
import testBase.BaseClass;

public class TC003_OpenNewAccountTest extends BaseClass {

	@Test(priority=1,groups={"Functional" , "Master"})
	public void OpenNewAccountTest() throws InterruptedException {
	try
    {
		
		loginToApp();
		OpenNewAccountPage newAcct = new OpenNewAccountPage(driver);
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(2000);

		newAcct.clickOnOpenNewAccount();
		logger.info("user clicked on Open New Account");
		Thread.sleep(1000);
		driver.getPageSource().contains("Open New Account");

        newAcct.selectAccountType("SAVINGS");
     
        newAcct.clickOnOpenNewAccountSubmitBtn();
        logger.info("Clicked on 'Open New Account' submit button");

      
        String confmsg = newAcct.getConfirmationMsg();
        Assert.assertTrue(confmsg.contains("Congratulations, your account is now open."),
                "Expected success message not displayed. Actual: " + confmsg);

        
        lp.clickLogOut();
			
		}catch(Exception e)

		{
		  Assert.fail();
		}

		logger.info("****test executed*****");
	}
	
	@Test(priority=2, groups={"Functional", "Sanity"})
	public void OpenCheckingAccountTest() throws InterruptedException {
	    try {
	        logger.info("URL is opened");
	        LoginPage lp = new LoginPage(driver);
	        OpenNewAccountPage newAcct = new OpenNewAccountPage(driver);

	        loginToApp();

	        newAcct.clickOnOpenNewAccount();
	        logger.info("User clicked on Open New Account");
	        Thread.sleep(1000);
	        driver.getPageSource().contains("Open New Account");

	        newAcct.selectAccountType("CHECKING");
	        logger.info("Selected Account Type: CHECKING");
	        Thread.sleep(2000);
	        newAcct.selectFromAccountByIndex(3); //can change the index
	        Thread.sleep(2000);
	        newAcct.clickOnOpenNewAccountSubmitBtn();
	        logger.info("Clicked on 'Open New Account' submit button");

	        
	        String confmsg = newAcct.getConfirmationMsg();
	        Assert.assertTrue(confmsg.contains("Congratulations, your account is now open."),
	                "Expected success message not displayed. Actual: " + confmsg);

	        lp.clickLogOut();

	    } catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****Test executed successfully for Checking Account****");
	}
	
	@Test(priority = 3, groups = {"Functional", "Regression"})
	public void VerifyAccountDetailsNavigationTest() throws InterruptedException {
	    try {
	        logger.info("URL is opened");
	        LoginPage lp = new LoginPage(driver);
	        OpenNewAccountPage newAcct = new OpenNewAccountPage(driver);

	        loginToApp();

	        newAcct.clickOnOpenNewAccount();
	        logger.info("User clicked on Open New Account");
	        Thread.sleep(1000);
	        driver.getPageSource().contains("Open New Account");

	        newAcct.selectAccountType("SAVINGS");
	        logger.info("Selected Account Type: SAVINGS");
	        Thread.sleep(2000);
	        newAcct.selectFromAccountByIndex(2); // you can change index if needed
	        Thread.sleep(2000);
	        newAcct.clickOnOpenNewAccountSubmitBtn();
	        logger.info("Clicked on 'Open New Account' submit button");

	        // Verify success message
	        String confmsg = newAcct.getConfirmationMsg();
	        Assert.assertTrue(confmsg.contains("Congratulations, your account is now open."),
	                "Expected success message not displayed. Actual: " + confmsg);

	        // Click on new account number link and verify navigation
	        newAcct.clickNewAcc();
	        
	        AccountsOverviewPage aop = new AccountsOverviewPage(driver);
	        
	        Assert.assertEquals(aop.getAccountDetailsHeading(), "Account Details");

	        lp.clickLogOut();
	    } 
	    catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****VerifyAccountDetailsNavigationTest executed successfully****");
	}

	@Test(priority = 4, groups = {"Functional", "Regression"})
	public void VerifyBackButtonAfterAccountCreationTest() throws InterruptedException {
	    try {
	        logger.info("Starting VerifyBackButtonAfterAccountCreationTest");
	        LoginPage lp = new LoginPage(driver);
	        OpenNewAccountPage newAcct = new OpenNewAccountPage(driver);

	        loginToApp();

	        newAcct.clickOnOpenNewAccount();
	        logger.info("User clicked on Open New Account");
	        Thread.sleep(1000);
	        driver.getPageSource().contains("Open New Account");

	        newAcct.selectAccountType("CHECKING");
	        logger.info("Selected Account Type: SAVINGS");
	        Thread.sleep(2000);
	        newAcct.selectFromAccountByIndex(2);
	        Thread.sleep(2000);
	        newAcct.clickOnOpenNewAccountSubmitBtn();
	        logger.info("Clicked on 'Open New Account' submit button");

	        // Verify success message
	        String confmsg = newAcct.getConfirmationMsg();
	        Assert.assertTrue(confmsg.contains("Congratulations, your account is now open."),
	                "Expected success message not displayed. Actual: " + confmsg);

	        // Click on 'Go back' link and verify navigation
	        driver.navigate().back();
	        logger.info("Clicked on Back button");

	        // Verify page title or heading
	        Assert.assertTrue(driver.getPageSource().contains("Open New Account"),
	                "Did not navigate back to 'Open New Account' page after clicking Back button.");

	        lp.clickLogOut();
	    } 
	    catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****VerifyBackButtonAfterAccountCreationTest executed successfully****");
	}

}
