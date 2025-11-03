package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BillPayPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC005_BillPayTest extends BaseClass {

	
	@Test(priority=1,groups={"Sanity" , "Master"})
	public void BillPayWithValidDetailsTest() throws InterruptedException {
		
		try
		{

		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		BillPayPage bp = new BillPayPage(driver);
		
		loginToApp();
		
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
	     
	     lp.clickLogOut();
    	}
		
		catch(Exception e)
		{
			 Assert.fail();
		}
		logger.info("****test executed*****");
	}
	
	@Test(priority = 2, groups = {"Negative"})
	public void BillPayWithoutPayeeNameTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithoutPayeeNameTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();
	        logger.info("User clicked on Bill Pay Menu");

	        
	        bp.setPayeeName("");
	        bp.setPayeeAddress(p.getProperty("PayeeAddress"));
	        bp.setPayeeCity(p.getProperty("PayeeCity"));
	        bp.setPayeeState(p.getProperty("PayeeState"));
	        bp.setPayeezipCode(p.getProperty("PayeezipCode"));
	        bp.setPayeePhone(p.getProperty("PayeePhone"));
	        bp.setPayeeAccountNumber(p.getProperty("PayeeAccountNumber"));
	        bp.setVerifyAccount(p.getProperty("VerifyAccount"));
	        bp.setBillPayAmount(p.getProperty("Amount"));
	        bp.selectFromAccount(0);
	        bp.clickOnSendPaymentSubmitBtn();
	        logger.info("Clicked on Send Payment button with blank Payee Name");

	        
	        String errorMsg = bp.getValidationMessage("name");
	        logger.info("Validation message displayed: " + errorMsg);

	        Assert.assertTrue(errorMsg.contains("Payee name is required") , 
	                "Expected validation message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } 
	    catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithoutPayeeNameTest executed successfully****");
	}
	
	@Test(priority = 3, groups = {"Negative"})
	public void BillPayWithoutAddressTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithoutAddressTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();
	        logger.info("User clicked on Bill Pay Menu");

	        bp.setPayeeName("TestUser");
	        bp.setPayeeAddress("");
	        bp.setPayeeCity(p.getProperty("PayeeCity"));
	        bp.setPayeeState(p.getProperty("PayeeState"));
	        bp.setPayeezipCode(p.getProperty("PayeezipCode"));
	        bp.setPayeePhone(p.getProperty("PayeePhone"));
	        bp.setPayeeAccountNumber(p.getProperty("PayeeAccountNumber"));
	        bp.setVerifyAccount(p.getProperty("VerifyAccount"));
	        bp.setBillPayAmount(p.getProperty("Amount"));
	        bp.selectFromAccount(0);
	        bp.clickOnSendPaymentSubmitBtn();
	        logger.info("Clicked on Send Payment button with blank Address");

	        String errorMsg = bp.getValidationMessage("address");
	        logger.info("Validation message displayed: " + errorMsg);

	        Assert.assertTrue(errorMsg.contains("Address is required"),
	                "Expected validation message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithoutAddressTest executed successfully****");
	}

	@Test(priority = 4, groups = {"Negative"})
	public void BillPayWithoutCityTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithoutCityTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();

	        bp.setPayeeName("TestUser");
	        bp.setPayeeAddress(p.getProperty("PayeeAddress"));
	        bp.setPayeeCity("");
	        bp.setPayeeState(p.getProperty("PayeeState"));
	        bp.setPayeezipCode(p.getProperty("PayeezipCode"));
	        bp.setPayeePhone(p.getProperty("PayeePhone"));
	        bp.setPayeeAccountNumber(p.getProperty("PayeeAccountNumber"));
	        bp.setVerifyAccount(p.getProperty("VerifyAccount"));
	        bp.setBillPayAmount(p.getProperty("Amount"));
	        bp.selectFromAccount(0);
	        bp.clickOnSendPaymentSubmitBtn();

	        String errorMsg = bp.getValidationMessage("city");
	        logger.info("Validation message displayed: " + errorMsg);

	        Assert.assertTrue(errorMsg.contains("City is required"),
	                "Expected validation message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithoutCityTest executed successfully****");
	}

	@Test(priority = 5, groups = {"Negative"})
	public void BillPayWithoutStateTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithoutStateTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();

	        bp.setPayeeName("TestUser");
	        bp.setPayeeAddress(p.getProperty("PayeeAddress"));
	        bp.setPayeeCity(p.getProperty("PayeeCity"));
	        bp.setPayeeState("");
	        bp.setPayeezipCode(p.getProperty("PayeezipCode"));
	        bp.setPayeePhone(p.getProperty("PayeePhone"));
	        bp.setPayeeAccountNumber(p.getProperty("PayeeAccountNumber"));
	        bp.setVerifyAccount(p.getProperty("VerifyAccount"));
	        bp.setBillPayAmount(p.getProperty("Amount"));
	        bp.selectFromAccount(0);
	        bp.clickOnSendPaymentSubmitBtn();

	        String errorMsg = bp.getValidationMessage("state");
	        logger.info("Validation message displayed: " + errorMsg);

	        Assert.assertTrue(errorMsg.contains("State is required"),
	                "Expected validation message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithoutStateTest executed successfully****");
	}

	@Test(priority = 6, groups = {"Negative"})
	public void BillPayWithoutPhoneTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithoutPhoneTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();

	        bp.setPayeeName("TestUser");
	        bp.setPayeeAddress(p.getProperty("PayeeAddress"));
	        bp.setPayeeCity(p.getProperty("PayeeCity"));
	        bp.setPayeeState(p.getProperty("PayeeState"));
	        bp.setPayeezipCode(p.getProperty("PayeezipCode"));
	        bp.setPayeePhone("");
	        bp.setPayeeAccountNumber(p.getProperty("PayeeAccountNumber"));
	        bp.setVerifyAccount(p.getProperty("VerifyAccount"));
	        bp.setBillPayAmount(p.getProperty("Amount"));
	        bp.selectFromAccount(0);
	        bp.clickOnSendPaymentSubmitBtn();

	        String errorMsg = bp.getValidationMessage("phoneNumber");
	        logger.info("Validation message displayed: " + errorMsg);

	        Assert.assertTrue(errorMsg.contains("Phone number is required"),
	                "Expected validation message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithoutPhoneTest executed successfully****");
	}

	@Test(priority = 7, groups = {"Negative"})
	public void BillPayWithoutAccountNumberTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithoutAccountNumberTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();

	        bp.setPayeeName("TestUser");
	        bp.setPayeeAddress(p.getProperty("PayeeAddress"));
	        bp.setPayeeCity(p.getProperty("PayeeCity"));
	        bp.setPayeeState(p.getProperty("PayeeState"));
	        bp.setPayeezipCode(p.getProperty("PayeezipCode"));
	        bp.setPayeePhone(p.getProperty("PayeePhone"));
	        bp.setPayeeAccountNumber("");
	        bp.setVerifyAccount(p.getProperty("VerifyAccount"));
	        bp.setBillPayAmount(p.getProperty("Amount"));
	        bp.selectFromAccount(0);
	        bp.clickOnSendPaymentSubmitBtn();

	        String errorMsg = bp.getValidationMessage("account-empty");
	        logger.info("Validation message displayed: " + errorMsg);

	        Assert.assertTrue(errorMsg.contains("Account number is required"),
	                "Expected validation message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithoutAccountNumberTest executed successfully****");
	}

	@Test(priority = 8, groups = {"Negative"})
	public void BillPayWithoutVerifyAccountTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithoutVerifyAccountTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();

	        bp.setPayeeName("TestUser");
	        bp.setPayeeAddress(p.getProperty("PayeeAddress"));
	        bp.setPayeeCity(p.getProperty("PayeeCity"));
	        bp.setPayeeState(p.getProperty("PayeeState"));
	        bp.setPayeezipCode(p.getProperty("PayeezipCode"));
	        bp.setPayeePhone(p.getProperty("PayeePhone"));
	        bp.setPayeeAccountNumber(p.getProperty("PayeeAccountNumber"));
	        bp.setVerifyAccount("");
	        bp.setBillPayAmount(p.getProperty("Amount"));
	        bp.selectFromAccount(0);
	        bp.clickOnSendPaymentSubmitBtn();

	        String errorMsg = bp.getValidationMessage("verifyAccount-empty");
	        logger.info("Validation message displayed: " + errorMsg);

	        Assert.assertTrue(errorMsg.contains("Account number is required."),
	                "Expected validation message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithoutVerifyAccountTest executed successfully****");
	}

	@Test(priority = 9, groups = {"Negative"})
	public void BillPayWithoutAmountTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithoutAmountTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();

	        bp.setPayeeName("TestUser");
	        bp.setPayeeAddress(p.getProperty("PayeeAddress"));
	        bp.setPayeeCity(p.getProperty("PayeeCity"));
	        bp.setPayeeState(p.getProperty("PayeeState"));
	        bp.setPayeezipCode(p.getProperty("PayeezipCode"));
	        bp.setPayeePhone(p.getProperty("PayeePhone"));
	        bp.setPayeeAccountNumber(p.getProperty("PayeeAccountNumber"));
	        bp.setVerifyAccount(p.getProperty("VerifyAccount"));
	        bp.setBillPayAmount("");
	        bp.selectFromAccount(0);
	        bp.clickOnSendPaymentSubmitBtn();

	        String errorMsg = bp.getValidationMessage("amount-empty");
	        logger.info("Validation message displayed: " + errorMsg);

	        Assert.assertTrue(errorMsg.contains("The amount cannot be empty."),
	                "Expected validation message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithoutAmountTest executed successfully****");
	}
	
	
	@Test(priority = 10, groups = {"Negative"})
	public void BillPayWithMismatchedAccountNumbersTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithMismatchedAccountNumbersTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();

	        bp.setPayeeName("TestUser");
	        bp.setPayeeAddress(p.getProperty("PayeeAddress"));
	        bp.setPayeeCity(p.getProperty("PayeeCity"));
	        bp.setPayeeState(p.getProperty("PayeeState"));
	        bp.setPayeezipCode(p.getProperty("PayeezipCode"));
	        bp.setPayeePhone(p.getProperty("PayeePhone"));
	        bp.setPayeeAccountNumber("12345");
	        bp.setVerifyAccount("54321");
	        bp.setBillPayAmount(p.getProperty("Amount"));
	        bp.selectFromAccount(0);
	        bp.clickOnSendPaymentSubmitBtn();

	        String errorMsg = bp.getValidationMessage("verifyAccount-mismatch");
	        logger.info("Validation message displayed: " + errorMsg);

	        Assert.assertTrue(errorMsg.contains("The account numbers do not match."),
	                "Expected validation message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithMismatchedAccountNumbersTest executed successfully****");
	} 
	
	@Test(priority = 11, groups = {"Negative"})
	public void BillPayWithNonNumericAccountNumberTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithNonNumericAccountNumberTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();

	        bp.setPayeeName("TestUser");
	        bp.setPayeeAddress(p.getProperty("PayeeAddress"));
	        bp.setPayeeCity(p.getProperty("PayeeCity"));
	        bp.setPayeeState(p.getProperty("PayeeState"));
	        bp.setPayeezipCode(p.getProperty("PayeezipCode"));
	        bp.setPayeePhone(p.getProperty("PayeePhone"));
	        bp.setPayeeAccountNumber("ABC");
	        bp.setVerifyAccount("ABC");
	        bp.setBillPayAmount(p.getProperty("Amount"));
	        bp.selectFromAccount(0);
	        bp.clickOnSendPaymentSubmitBtn();

	        String errorMsg = bp.getValidationMessage("account-invalid");
	        logger.info("Validation message displayed: " + errorMsg);

	        Assert.assertTrue(errorMsg.contains("Please enter a valid number") ,
	                "Expected validation message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithNonNumericAccountNumberTest executed successfully****");
	}


	@Test(priority = 12, groups = {"Negative"})
	public void BillPayWithNonNumericAmountTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithNonNumericAmountTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();

	        bp.setPayeeName("TestUser");
	        bp.setPayeeAddress(p.getProperty("PayeeAddress"));
	        bp.setPayeeCity(p.getProperty("PayeeCity"));
	        bp.setPayeeState(p.getProperty("PayeeState"));
	        bp.setPayeezipCode(p.getProperty("PayeezipCode"));
	        bp.setPayeePhone(p.getProperty("PayeePhone"));
	        bp.setPayeeAccountNumber(p.getProperty("PayeeAccountNumber"));
	        bp.setVerifyAccount(p.getProperty("VerifyAccount"));
	        bp.setBillPayAmount("ABC");
	        bp.selectFromAccount(0);
	        bp.clickOnSendPaymentSubmitBtn();

	        String errorMsg =  bp.getValidationMessage("amount-invalid");
	        logger.info("Validation message displayed: " + errorMsg);

	        Assert.assertTrue(errorMsg.contains("Please enter a valid amount"),
	                "Expected validation message not displayed. Actual: " + errorMsg);

	        lp.clickLogOut();
	    } catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithNonNumericAmountTest executed successfully****");
	}

	@Test(priority = 13, groups = {"Negative"})
	public void BillPayWithAllFieldsEmptyTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithAllFieldsEmptyTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();

	        // Leave all fields blank
	        bp.setPayeeName("");
	        bp.setPayeeAddress("");
	        bp.setPayeeCity("");
	        bp.setPayeeState("");
	        bp.setPayeezipCode("");
	        bp.setPayeePhone("");
	        bp.setPayeeAccountNumber("");
	        bp.setVerifyAccount("");
	        bp.setBillPayAmount("");
	        bp.selectFromAccount(0);
	        bp.clickOnSendPaymentSubmitBtn();
	        logger.info("Clicked on Send Payment with all blank fields");

	        // Check if any validation message is visible
	        List<WebElement> errors = driver.findElements(By.xpath("//span[contains(@id,'validationModel-') and string-length(text())>0]"));

	        Assert.assertTrue(errors.size() > 0, "No validation messages displayed for empty form submission.");

	        logger.info("Total validation errors displayed: " + errors.size());
	        lp.clickLogOut();
	    } 
	    catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithAllFieldsEmptyTest executed successfully****");
	}

	@Test(priority = 14, groups = {"Positive"})
	public void BillPayWithDecimalAmountTest() throws InterruptedException {
	    try {
	        logger.info("Starting BillPayWithDecimalAmountTest");

	        LoginPage lp = new LoginPage(driver);
	        BillPayPage bp = new BillPayPage(driver);

	        loginToApp();
	        bp.clickOnBillPayMenu();

	        bp.setPayeeName(randomeString().toUpperCase());
	        bp.setPayeeAddress(p.getProperty("PayeeAddress"));
	        bp.setPayeeCity(p.getProperty("PayeeCity"));
	        bp.setPayeeState(p.getProperty("PayeeState"));
	        bp.setPayeezipCode(p.getProperty("PayeezipCode"));
	        bp.setPayeePhone(p.getProperty("PayeePhone"));
	        bp.setPayeeAccountNumber(p.getProperty("PayeeAccountNumber"));
	        bp.setVerifyAccount(p.getProperty("VerifyAccount"));
	        bp.setBillPayAmount("15.45");  // Decimal amount
	        bp.selectFromAccount(2);
	        bp.clickOnSendPaymentSubmitBtn();

	        String successMsg = bp.isBillComplete();
	        Assert.assertTrue(successMsg.contains("Bill Payment Complete"),
	                "Payment failed for decimal amount. Actual: " + successMsg);

	        lp.clickLogOut();
	    } catch (Exception e) {
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }

	    logger.info("****BillPayWithDecimalAmountTest executed successfully****");
	}


}
