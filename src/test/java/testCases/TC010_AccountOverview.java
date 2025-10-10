package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountsOverviewPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC010_AccountOverview extends BaseClass {
	
	@Test
	public void VerifyAccountOverview() throws InterruptedException
	{
		 LoginPage lp = new LoginPage(driver);
	     AccountsOverviewPage aop = new AccountsOverviewPage(driver);

	        lp.setUsername(p.getProperty("UsernameID"));
	        lp.setPassword(p.getProperty("UserPasswordId"));
	        lp.clickSubmit();
	        logger.info("Logged in successfully");


	        String accountNum = aop.getFirstAccountNumber();
	        logger.info("First account found: " + accountNum);

	        aop.clickFirstAccount();
	        logger.info("Clicked on first account successfully");
	        
	        String actualHeading = aop.getAccountDetailsHeading();
	    	Assert.assertEquals(actualHeading, "Account Details");
	    	
	    	aop.filterTransactions("September", "Debit");
	    	Thread.sleep(2000);
	    	aop.clickFirstTransaction(); //clicking the frst one by default
	    	Thread.sleep(1000);
	    	
	    	Assert.assertTrue(aop.isTransactionDetailsDisplayed(), "Transaction Details page not displayed");
	    	System.out.println("Transaction Details page verified: " + aop.getTransactionDetailsHeading());
	    	
	    	driver.navigate().back();
	    	
	    	aop.clickTransactionByIndex(5); //randomly click any index
	    	
	    	Thread.sleep(1000);
	    }
	}


