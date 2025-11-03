package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ApplyLoanPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC006_ApplyLoanTest extends BaseClass{
	
	@Test(priority=1,groups={"Sanity" , "Master"})
	public void VerifyApplyLoan() throws InterruptedException 
	{
		try
		{
		
		        LoginPage lp = new LoginPage(driver);
		        ApplyLoanPage loanPage = new ApplyLoanPage(driver);
		        
	            loginToApp();

		        loanPage.clickApplyLoan();
		        loanPage.setAmount("10");
		        loanPage.setDownPayment("5");
		        loanPage.selectFromAccount(1); 
		        loanPage.clickApplyNow();

		        Thread.sleep(3000);

		       
		        String approvalMessage = loanPage.getLoanApprovalMessage();
		        Assert.assertTrue(approvalMessage.contains("Congratulations, your loan has been approved."),
		                "Loan approval message not found! Actual: " + approvalMessage);
		        logger.info("Loan approval message verified");

		        
		        String status = loanPage.getLoanStatus();
		        Assert.assertEquals(status, "Approved", "Loan status verification failed!");
		        logger.info("Loan status is Approved. Test Passed!");
		        
		        lp.clickLogOut();
		    }
		
		catch(Exception e)
		{
			 Assert.fail();
		}
		
		logger.info("****test executed*****");
	}
	
	 @Test(priority = 2, groups = {"Negative"})
	    public void ApplyLoanWithoutAmountTest() throws InterruptedException {
	        try {
	            logger.info("Starting ApplyLoanWithoutAmountTest");
	            LoginPage lp = new LoginPage(driver);
	            ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	            loginToApp();
	            loanPage.clickApplyLoan();
	            loanPage.setAmount("");
	            loanPage.setDownPayment("100");
	            loanPage.selectFromAccount(0);
	            loanPage.clickApplyNow();

	            String errorMsg = loanPage.getErrorMessage();
		        logger.info("Error message displayed: " + errorMsg);

		        Assert.assertTrue(errorMsg.contains("An internal error has occurred and has been logged"),
		                "Expected error message not displayed. Actual: " + errorMsg);

		        lp.clickLogOut();
	        } catch (Exception e) {
	            Assert.fail("Exception occurred: " + e.getMessage());
	        }
	    }
	 
	 @Test(priority = 3, groups = {"Negative"})
	 public void ApplyLoanWithoutDownPaymentTest() throws InterruptedException {
	     try {
	         logger.info("Starting ApplyLoanWithoutDownPaymentTest");

	         LoginPage lp = new LoginPage(driver);
	         ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	         loginToApp();
	         loanPage.clickApplyLoan();

	         loanPage.setAmount("1000");
	         loanPage.setDownPayment("");
	         loanPage.selectFromAccount(0);
	         loanPage.clickApplyNow();

	         String errorMsg = loanPage.getErrorMessage();
	         logger.info("Error message displayed: " + errorMsg);

	         Assert.assertTrue(errorMsg.contains("An internal error has occurred and has been logged"),
	                 "Expected validation message not displayed. Actual: " + errorMsg);

	         lp.clickLogOut();
	     } catch (Exception e) {
	         Assert.fail("Exception occurred: " + e.getMessage());
	     }
	     logger.info("****ApplyLoanWithoutDownPaymentTest executed successfully****");
	 }

	 @Test(priority = 4, groups = {"Negative"})
	 public void ApplyLoanWithNonNumericAmountTest() throws InterruptedException {
	     try {
	         logger.info("Starting ApplyLoanWithNonNumericAmountTest");

	         LoginPage lp = new LoginPage(driver);
	         ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	         loginToApp();
	         loanPage.clickApplyLoan();

	         loanPage.setAmount("abc");
	         loanPage.setDownPayment("100");
	         loanPage.selectFromAccount(0);
	         loanPage.clickApplyNow();

	         String errorMsg = loanPage.getErrorMessage();
	         logger.info("Error message displayed: " + errorMsg);

	         Assert.assertTrue(errorMsg.contains("An internal error has occurred and has been logged"),
	                 "Expected validation message not displayed. Actual: " + errorMsg);

	         lp.clickLogOut();
	     } catch (Exception e) {
	         Assert.fail("Exception occurred: " + e.getMessage());
	     }
	     logger.info("****ApplyLoanWithNonNumericAmountTest executed successfully****");
	 }
	 
	 @Test(priority = 5, groups = {"Negative"})
	 public void ApplyLoanWithNonNumericDownPaymentTest() throws InterruptedException {
	     try {
	         logger.info("Starting ApplyLoanWithNonNumericDownPaymentTest");

	         LoginPage lp = new LoginPage(driver);
	         ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	         loginToApp();
	         loanPage.clickApplyLoan();

	         loanPage.setAmount("1000");
	         loanPage.setDownPayment("abc");
	         loanPage.selectFromAccount(0);
	         loanPage.clickApplyNow();

	         String errorMsg = loanPage.getErrorMessage();
	         logger.info("Error message displayed: " + errorMsg);

	         Assert.assertTrue(errorMsg.contains("An internal error has occurred and has been logged"),
	                 "Expected validation message not displayed. Actual: " + errorMsg);

	         lp.clickLogOut();
	     } catch (Exception e) {
	         Assert.fail("Exception occurred: " + e.getMessage());
	     }
	     logger.info("****ApplyLoanWithNonNumericDownPaymentTest executed successfully****");
	 }

	 @Test(priority = 6, groups = {"Negative"})
	 public void ApplyLoanWithExcessiveAmountTest() throws InterruptedException {
	     try {
	         logger.info("Starting ApplyLoanWithExcessiveAmountTest");

	         LoginPage lp = new LoginPage(driver);
	         ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	         loginToApp();
	         loanPage.clickApplyLoan();

	         loanPage.setAmount("9999999999");
	         loanPage.setDownPayment("100");
	         loanPage.selectFromAccount(0);
	         loanPage.clickApplyNow();

	         String errorMsg = loanPage.getExcessiveLoanErrorMsg();
	         logger.info("Error message displayed: " + errorMsg);

	         Assert.assertTrue(errorMsg.contains("We cannot grant a loan in that amount with your available funds."),
	                 "Expected validation message not displayed. Actual: " + errorMsg);

	         lp.clickLogOut();
	     } catch (Exception e) {
	         Assert.fail("Exception occurred: " + e.getMessage());
	     }

	     logger.info("****ApplyLoanWithExcessiveAmountTest executed successfully****");
	 }

	 
	 @Test(priority = 7, groups = {"Negative"})
	 public void ApplyLoanWithSpecialCharactersInAmountTest() throws InterruptedException {
	     try {
	         logger.info("Starting ApplyLoanWithSpecialCharactersInAmountTest");

	         LoginPage lp = new LoginPage(driver);
	         ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	         loginToApp();
	         loanPage.clickApplyLoan();

	         loanPage.setAmount("@#$%");
	         loanPage.setDownPayment("100");
	         loanPage.selectFromAccount(0);
	         loanPage.clickApplyNow();

	         String errorMsg = loanPage.getErrorMessage();
	         logger.info("Error message displayed: " + errorMsg);

	         Assert.assertTrue(errorMsg.contains("An internal error has occurred and has been logged"),
	                 "Expected validation message not displayed. Actual: " + errorMsg);

	         lp.clickLogOut();
	     } catch (Exception e) {
	         Assert.fail("Exception occurred: " + e.getMessage());
	     }
	     logger.info("****ApplyLoanWithSpecialCharactersInAmountTest executed successfully****");
	 }

	 @Test(priority = 8, groups = {"Negative"})
	 public void ApplyLoanWithEmptySubmissionTest() throws InterruptedException {
	     try {
	         logger.info("Starting ApplyLoanWithEmptySubmissionTest");

	         LoginPage lp = new LoginPage(driver);
	         ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	         loginToApp();
	         loanPage.clickApplyLoan();

	         loanPage.setAmount("");
	         loanPage.setDownPayment("");
	         loanPage.clickApplyNow();

	         String errorMsg = loanPage.getErrorMessage();
	         logger.info("Error message displayed: " + errorMsg);

	         Assert.assertTrue(errorMsg.contains("An internal error has occurred and has been logged"),
	                 "Expected validation message not displayed. Actual: " + errorMsg);

	         lp.clickLogOut();
	     } catch (Exception e) {
	         Assert.fail("Exception occurred: " + e.getMessage());
	     }
	     logger.info("****ApplyLoanWithEmptySubmissionTest executed successfully****");
	 }
	 
	 @Test(priority = 9, groups = {"Negative"})
	 public void ApplyLoanWithAmountLessThanDownPaymentTest() throws InterruptedException {
	     try {
	         logger.info("Starting ApplyLoanWithAmountLessThanDownPaymentTest");

	         LoginPage lp = new LoginPage(driver);
	         ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	         loginToApp();
	         loanPage.clickApplyLoan();

	         loanPage.setAmount("1000");
	         loanPage.setDownPayment("1500");
	         loanPage.selectFromAccount(0);
	         loanPage.clickApplyNow();

	         String errorMsg = loanPage.getInsufficientFundsMessage();
	         logger.info("Error message displayed: " + errorMsg);

	         Assert.assertTrue(errorMsg.contains("You do not have sufficient funds for the given down payment."),
	                 "Expected logical/insufficient funds message not displayed. Actual: " + errorMsg);

	         lp.clickLogOut();
	     } catch (Exception e) {
	         Assert.fail("Exception occurred: " + e.getMessage());
	     }
	     logger.info("****ApplyLoanWithAmountLessThanDownPaymentTest executed successfully****");
	 }

	 @Test(priority = 10, groups = {"Negative"})
	 public void ApplyLoanWithZeroAmountTest() throws InterruptedException {
	     try {
	         logger.info("Starting ApplyLoanWithZeroAmountTest");

	         LoginPage lp = new LoginPage(driver);
	         ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	         loginToApp();
	         loanPage.clickApplyLoan();

	         loanPage.setAmount("0");
	         loanPage.setDownPayment("100");
	         loanPage.selectFromAccount(0);
	         loanPage.clickApplyNow();

	         String errorMsg = loanPage.getErrorMessage();
	         logger.info("Error message displayed: " + errorMsg);

	         Assert.assertTrue(errorMsg.contains("An internal error has occurred and has been logged"),
	                 "Expected validation message not displayed. Actual: " + errorMsg);

	         lp.clickLogOut();
	     } catch (Exception e) {
	         Assert.fail("Exception occurred: " + e.getMessage());
	     }
	     logger.info("****ApplyLoanWithZeroAmountTest executed successfully****");
	 }


	 @Test(priority = 11, groups = {"Negative"})
	 public void ApplyLoanWithNegativeAmountTest() throws InterruptedException {
	     try {
	         logger.info("Starting ApplyLoanWithNegativeAmountTest");

	         LoginPage lp = new LoginPage(driver);
	         ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	         loginToApp();
	         loanPage.clickApplyLoan();

	         loanPage.setAmount("-1000");
	         loanPage.setDownPayment("100");
	         loanPage.selectFromAccount(0);
	         loanPage.clickApplyNow();
	         logger.info("Clicked Apply Now with negative loan amount");

	         String errorMsg = loanPage.getExcessiveLoanErrorMsg();
	         logger.info("Error message displayed: " + errorMsg);

	         Assert.assertTrue(errorMsg.contains("We cannot grant a loan in that amount with your available funds."),
	                 "Expected validation message not displayed. Actual: " + errorMsg);

	         lp.clickLogOut();
	     } 
	     catch (Exception e) {
	         Assert.fail("Exception occurred: " + e.getMessage());
	     }

	     logger.info("****ApplyLoanWithNegativeAmountTest executed successfully****");
	 }

	 
	 @Test(priority = 12, groups = {"Negative"})
	 public void ApplyLoanWithUnrealisticCombinationTest() throws InterruptedException {
	     try {
	         logger.info("Starting ApplyLoanWithUnrealisticCombinationTest");

	         LoginPage lp = new LoginPage(driver);
	         ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	         loginToApp();
	         loanPage.clickApplyLoan();

	         loanPage.setAmount("100");
	         loanPage.setDownPayment("5000");
	         loanPage.selectFromAccount(0);
	         loanPage.clickApplyNow();

	         String errorMsg = loanPage.getInsufficientFundsMessage();
	         logger.info("Error message displayed: " + errorMsg);

	         Assert.assertTrue(errorMsg.contains("You do not have sufficient funds for the given down payment."),
	                 "Expected logical/insufficient funds message not displayed. Actual: " + errorMsg);
	         
	         lp.clickLogOut();
	     } catch (Exception e) {
	         Assert.fail("Exception occurred: " + e.getMessage());
	     }
	     logger.info("****ApplyLoanWithUnrealisticCombinationTest executed successfully****");
	 }
	 
	 
	 @Test(priority = 13, groups = {"Negative"})
	 public void ApplyLoanWithInsufficientBalanceTest() throws InterruptedException {
	     try {
	         logger.info("Starting ApplyLoanWithInsufficientBalanceTest");

	         LoginPage lp = new LoginPage(driver);
	         ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	         loginToApp();
	         loanPage.clickApplyLoan();

	         loanPage.setAmount("5000");
	         loanPage.setDownPayment("4000");
	         loanPage.selectFromAccount(0);
	         loanPage.clickApplyNow();

	         String errorMsg = loanPage.getInsufficientFundsMessage();
	         logger.info("Error message displayed: " + errorMsg);

	         Assert.assertTrue(errorMsg.contains("You do not have sufficient funds for the given down payment."),
	                 "Expected insufficient funds message not displayed. Actual: " + errorMsg);

	         lp.clickLogOut();
	     } catch (Exception e) {
	         Assert.fail("Exception occurred: " + e.getMessage());
	     }
	     logger.info("****ApplyLoanWithInsufficientBalanceTest executed successfully****");
	 }
	 
	 @Test(priority = 14, groups = {"Sanity", "Master"})
	 public void VerifyApplyLoanWithDecimalAmountTest() throws InterruptedException {
	     try {
	         logger.info("Starting VerifyApplyLoanWithDecimalAmountTest");

	         LoginPage lp = new LoginPage(driver);
	         ApplyLoanPage loanPage = new ApplyLoanPage(driver);

	         loginToApp();
	         loanPage.clickApplyLoan();

	         loanPage.setAmount("10.75");
	         loanPage.setDownPayment("2");
	         loanPage.selectFromAccount(2);
	         loanPage.clickApplyNow();

	         Thread.sleep(3000);

	         String approvalMessage = loanPage.getLoanApprovalMessage();
		        Assert.assertTrue(approvalMessage.contains("Congratulations, your loan has been approved."),
		                "Loan approval message not found! Actual: " + approvalMessage);
		        logger.info("Loan approval message verified");

		        
		        String status = loanPage.getLoanStatus();
		        Assert.assertEquals(status, "Approved", "Loan status verification failed!");
		        logger.info("Loan status is Approved. Test Passed!");
		        
		        lp.clickLogOut();
	     } 
	     catch (Exception e) {
	         Assert.fail("Exception occurred: " + e.getMessage());
	     }

	     logger.info("****VerifyApplyLoanWithDecimalAmountTest executed successfully****");
	 }

	 

}


