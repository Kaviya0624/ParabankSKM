package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.TransferFundsPage;
import testBase.BaseClass;

public class TC004_TransferFundsTest extends BaseClass {

	@Test(priority=1,groups={"Sanity" , "Master"})
	public void TransferFundsWithAmountTest() throws InterruptedException {

		try
		{
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		TransferFundsPage tf = new TransferFundsPage(driver);

		loginToApp();

		tf.clickOnTransferFunds();
		
		tf.setAmount(p.getProperty("Amount"));
		Thread.sleep(2000);
		tf.selectFromAccount(0);
		Thread.sleep(2000);
		tf.selectToAccount(1);
		Thread.sleep(2000);
		tf.clickOnTransferSubmitBtn();
		Thread.sleep(2000);
		
		 String actualMessage = tf.isTransferComplete();
	     String expectedMessage = "Transfer Complete!";
	     Thread.sleep(2000);
	     Assert.assertTrue(actualMessage.contains(expectedMessage),
	                "Transfer failed or confirmation message not found. Actual message: " + actualMessage);
	     
	     lp.clickLogOut();
		
	}
		
		catch(Exception e)

		{
		  Assert.fail();
		}

		logger.info("****test executed*****");

	}
	
	@Test(priority = 2, groups = {"Negative"})
	public void TransferFundsWithoutAmountTest() {
	    try {
	        logger.info("Starting TransferFundsWithoutAmountTest");

	        LoginPage lp = new LoginPage(driver);
	        TransferFundsPage tf = new TransferFundsPage(driver);

	        loginToApp();
	        tf.clickOnTransferFunds();
	        logger.info("User clicked on Transfer Funds link");

	        // Leave amount blank
	        tf.setAmount("");
	        Thread.sleep(1000);

	        tf.selectFromAccount(0);
	        Thread.sleep(1000);
	        tf.selectToAccount(1);
	        Thread.sleep(1000);
	        tf.clickOnTransferSubmitBtn();
	        logger.info("Clicked on Transfer button without amount");

	        String errorMsg = tf.getErrorMessage();
	        Assert.assertTrue(errorMsg.contains("An internal error has occurred and has been logged"),
	                "Expected error message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } 
	    catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****TransferFundsWithoutAmountTest executed successfully****");
	}

	@Test(priority = 3, groups = {"Negative"})
	public void TransferFundsWithInvalidAmountTest() throws InterruptedException {
	    try {
	        logger.info("Starting TransferFundsWithInvalidAmountTest");

	        LoginPage lp = new LoginPage(driver);
	        TransferFundsPage tf = new TransferFundsPage(driver);

	        loginToApp();
	        tf.clickOnTransferFunds();
	        logger.info("User clicked on Transfer Funds link");

	        // Enter invalid amount (non-numeric)
	        tf.setAmount("abc");
	        Thread.sleep(1000);

	        tf.selectFromAccount(0);
	        Thread.sleep(1000);
	        tf.selectToAccount(1);
	        Thread.sleep(1000);
	        tf.clickOnTransferSubmitBtn();
	        logger.info("Clicked on Transfer button with invalid amount");

	        String errorMsg = tf.getErrorMessage();
	        Assert.assertTrue(errorMsg.contains("An internal error has occurred and has been logged"),
	                "Expected error message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } 
	    catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****TransferFundsWithInvalidAmountTest executed successfully****");
	}
	
	@Test(priority = 4, groups = {"Functional", "Sanity"})
	public void TransferFundsWithDecimalAmountTest() throws InterruptedException {
	    try {
	        logger.info("Starting TransferFundsWithDecimalAmountTest");

	        LoginPage lp = new LoginPage(driver);
	        TransferFundsPage tf = new TransferFundsPage(driver);

	        loginToApp();
	        tf.clickOnTransferFunds();
	        logger.info("User clicked on Transfer Funds link");

	        // Enter valid decimal amount
	        tf.setAmount("10.75");
	        Thread.sleep(1000);

	        tf.selectFromAccount(3);
	        Thread.sleep(1000);
	        tf.selectToAccount(1);
	        Thread.sleep(1000);
	        tf.clickOnTransferSubmitBtn();
	        logger.info("Clicked on Transfer button with decimal amount");

	        String actualMessage2 = tf.isTransferComplete();
		     String expectedMessage = "Transfer Complete!";
		     Thread.sleep(2000);
		     Assert.assertTrue(actualMessage2.contains(expectedMessage),
		                "Transfer failed or confirmation message not found. Actual message: " + actualMessage2);

	        lp.clickLogOut();
	    } 
	    catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****TransferFundsWithDecimalAmountTest executed successfully****");
	}

	@Test(priority = 5, groups = {"Negative"})
	public void TransferFundsWithSpecialCharactersTest() throws InterruptedException {
	    try {
	        logger.info("Starting TransferFundsWithSpecialCharactersTest");

	        LoginPage lp = new LoginPage(driver);
	        TransferFundsPage tf = new TransferFundsPage(driver);

	        loginToApp();
	        tf.clickOnTransferFunds();
	        logger.info("User clicked on Transfer Funds link");

	        // Enter invalid special character amount
	        tf.setAmount("@#$%");
	        Thread.sleep(1000);

	        tf.selectFromAccount(3);
	        Thread.sleep(1000);
	        tf.selectToAccount(2);
	        Thread.sleep(1000);
	        tf.clickOnTransferSubmitBtn();
	        logger.info("Clicked on Transfer button with special characters");

	        String errorMsg = tf.getErrorMessage();
	        Assert.assertTrue(errorMsg.contains("An internal error has occurred and has been logged"),
	                "Expected error message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } 
	    catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****TransferFundsWithSpecialCharactersTest executed successfully****");
	}
	
	
	@Test(priority = 6, groups = {"Negative"})
	public void TransferFundsWithExcessiveAmountTest() throws InterruptedException {
	    try {
	        logger.info("Starting TransferFundsWithExcessiveAmountTest");

	        LoginPage lp = new LoginPage(driver);
	        TransferFundsPage tf = new TransferFundsPage(driver);

	        loginToApp();
	        tf.clickOnTransferFunds();
	        logger.info("User clicked on Transfer Funds link");

	        tf.setAmount("99999999977777777787");
	        logger.info("Entered excessive amount");

	        tf.selectFromAccount(0);
	        tf.selectToAccount(1);
	        tf.clickOnTransferSubmitBtn();
	        logger.info("Clicked on Transfer button with excessive amount");

	        String errorMsg = tf.getErrorMessage();
	        logger.info("Error message displayed: " + errorMsg);

	        Assert.assertTrue(errorMsg.contains("An internal error has occurred and has been logged"),
	                "Expected error message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } 
	    catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****TransferFundsWithExcessiveAmountTest executed successfully****");
	}



	
}
