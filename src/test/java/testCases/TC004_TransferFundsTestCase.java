package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.TransferFundsPage;
import testBase.BaseClass;

public class TC004_TransferFundsTestCase extends BaseClass {

	@Test
	public void TransferFundsWithoutAmountTest() throws InterruptedException {

		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		TransferFundsPage tf = new TransferFundsPage(driver);

		lp.setUsername(p.getProperty("UsernameID"));
		logger.info("User entered the User Name:");

		lp.setPassword(p.getProperty("UserPasswordId"));
		logger.info("User entered the password:");
		Thread.sleep(2000);
		lp.clickSubmit();


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
		
	}

	
}
