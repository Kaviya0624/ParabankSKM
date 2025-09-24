package testCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.TransferFundsPage;
import testBase.BaseClass;

public class TC004_TransferFundsTestCase extends BaseClass {

	@Test(priority = 1)
	public void TransferFundsWithoutAmountTest() throws InterruptedException, IOException {

		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		TransferFundsPage tF = new TransferFundsPage(driver);

		lp.setUsername(p.getProperty("UsernameID"));
		logger.info("User entered the User Name:");

		lp.setPassword(p.getProperty("UserPasswordId"));
		logger.info("User entered the password:");
		Thread.sleep(2000);
		lp.clickSubmit();

		logger.info("User clicked on Login Button");
		Thread.sleep(2000);

		if (driver.getTitle().equals("ParaBank | Accounts Overview")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
		
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}

		tF.clickOnTransferFunds();
		logger.info("user clicked on Transfer Funds Menu for Transfer money! ");
		Thread.sleep(3000);

		tF.clickOnTransferSubmitBtn();
		logger.info("User Submited the Transfer !");
		Thread.sleep(3000);

		if (driver.getPageSource().contains("The amount cannot be empty.")) {
			Assert.assertTrue(true);
			logger.info("The amount cannot be empty. test passed!");
		} else {
			
			Assert.assertTrue(false);
			logger.info("Funds is Tranfer test failed");
		}

	}

	@Test(priority = 2)
	public void TransferFundsWithValidDetailsTest() throws InterruptedException, IOException {

		logger.info("URL is opened");
		TransferFundsPage tF = new TransferFundsPage(driver);

		tF.clickOnTransferFunds();
		logger.info("user clicked on Transfer Funds Menu for Transfer money! ");
		Thread.sleep(3000);

		tF.setAmount(p.getProperty("Amount"));
		logger.info("user entered the Amount for transfer funds!");

		Select FromAccount = new Select(tF.selectFromAccount());
		FromAccount.selectByIndex(1);
		logger.info("User choose from account number#");

		Select ToAccount = new Select(tF.selectToAccount());
		ToAccount.selectByIndex(1);
		logger.info("User choose to account number#");

		tF.clickOnTransferSubmitBtn();
		logger.info("User Clicked on The amount cannot be empty. Menu!");
		Thread.sleep(3000);
		
		if (driver.getPageSource().contains("Transfer Complete!")) {
			Assert.assertTrue(true);
			logger.info("Transfer Complete! test passed");
		} else {
			
			Assert.assertTrue(false);
			logger.info("Transfer not Complete! test failed");
		}

	}
}
