package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BillPayPage;
import pageObjects.LoginPage;
import pageObjects.TransferFundsPage;
import testBase.BaseClass;

public class TC005_BillPayTest extends BaseClass {

	@Test
	public void BillPayWithValidDetailsTest() throws InterruptedException {

		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		BillPayPage bp = new BillPayPage(driver);
		
		
		lp.setUsername(p.getProperty("UsernameID"));
		logger.info("User entered the User Name:");

		lp.setPassword(p.getProperty("UserPasswordId"));
		logger.info("User entered the password:");
		Thread.sleep(2000);
		lp.clickSubmit();

		logger.info("User clicked on Login Button");
		Thread.sleep(2000);

		bp.clickOnBillPayMenu();
		logger.info("user clicked on Bill Payament Menu! ");
		Thread.sleep(1000);

		bp.setPayeeName(randomeString().toUpperCase());
		logger.info("User entered the name.");
		bp.setPayeeAddress(p.getProperty("PayeeAddress"));
		logger.info("User entered the Address.");
		bp.setPayeeCity(p.getProperty("PayeeCity"));
		logger.info("User entered the City.");
		bp.setPayeeState(p.getProperty("PayeeState"));
		logger.info("User entered the State.");
		bp.setPayeezipCode(p.getProperty("PayeezipCode"));
		logger.info("User entered the zipCode.");
		Thread.sleep(1000);
		bp.setPayeePhone(p.getProperty("PayeePhone"));
		logger.info("User entered the Phone Number.");
		bp.setPayeeAccountNumber(p.getProperty("PayeeAccountNumber"));
		logger.info("User entered the AccountNumber.");
		bp.setVerifyAccount(p.getProperty("VerifyAccount"));
		logger.info("User Verified the Account.");
		Thread.sleep(1000);
		
		bp.setBillPayAmount(p.getProperty("Amount"));
		
		bp.selectFromAccount(0);
		logger.info("User choose to account from #");

		bp.clickOnSendPaymentSubmitBtn();
		logger.info("User Send Payment!");
		Thread.sleep(1000);

		 String actualMessage = bp.isBillComplete();
	     String expectedMessage = "Bill Payment Complete";
	     Thread.sleep(2000);
	     Assert.assertTrue(actualMessage.contains(expectedMessage),
	                "\"Bill Payment  failed or confirmation message not found. Actual message: " + actualMessage);
	}

	
}
