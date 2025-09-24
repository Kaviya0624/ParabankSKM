package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ApplyLoanPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC006_ApplyLoanTest extends BaseClass{
	
	@Test
	public void VerifyApplyLoan() throws InterruptedException 
	{
		        LoginPage lp = new LoginPage(driver);
		        ApplyLoanPage loanPage = new ApplyLoanPage(driver);
		        
		       
		        lp.setUsername(p.getProperty("UsernameID"));
		        lp.setPassword(p.getProperty("UserPasswordId"));
		        Thread.sleep(2000); // demo only
		        lp.clickSubmit();
		        
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
		       
		    }
	}


