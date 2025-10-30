package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(priority=1,groups={"Sanity" , "Master"})
	public void loginTest() throws InterruptedException 
	{
		try
		{
			
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

		logger.info("User logged out successfully!");
		}
		
		catch(Exception e)
		
		{
			Assert.fail();
		}
		
		logger.info("****test executed*****");
	}
	
	@Test(priority = 2, groups = {"Regression", "Negative"})
	public void loginWithInvalidPassword() {
	    try {
	        logger.info("Starting test: Login with invalid password");
	        LoginPage lp = new LoginPage(driver);

	        lp.setUsername(p.getProperty("UsernameID"));
	        logger.info("Entered username: " + p.getProperty("UsernameID"));

	        lp.setPassword("WrongPassword123!");
	        logger.info("Entered invalid password");

	        lp.clickSubmit();
	        logger.info("Clicked submit button with invalid password");

	        String actualError = lp.getLoginErrorMessage();

	        Assert.assertTrue(!actualError.isEmpty(), "Error message should be displayed");
	        Assert.assertTrue(
	            actualError.toLowerCase().contains("Please enter") ||
	            actualError.toLowerCase().contains("could not be verified") ||
	            actualError.toLowerCase().contains("incorrect"),
	            "Expected error message not displayed. Actual: " + actualError
	        );

	        logger.info("Test passed: Invalid password correctly rejected. Message: " + actualError);

	    } catch (Exception e) {
	        logger.error("Test failed: " + e.getMessage());
	        Assert.fail("Test failed due to: " + e.getMessage());
	    }
	}

	
	@Test(priority = 3, groups = {"Regression", "Negative"})
	public void loginWithBothInvalidCredentials() {
	    try {
	        logger.info("Starting test: Login with both invalid credentials");
	        LoginPage lp = new LoginPage(driver);

	        lp.setUsername("invaliduser@test.com");
	        logger.info("Entered invalid username");

	        lp.setPassword("WrongPassword123!");
	        logger.info("Entered invalid password");

	        lp.clickSubmit();
	        logger.info("Clicked submit with invalid credentials");

	        String actualError =  lp.getLoginErrorMessage();

	        Assert.assertTrue(!actualError.isEmpty(), "Error message should be displayed");
	        Assert.assertTrue(
	            actualError.toLowerCase().contains("invalid") ||
	            actualError.toLowerCase().contains("incorrect") ||
	            actualError.toLowerCase().contains("could not be verified"),
	            "Expected error message not displayed. Actual: " + actualError
	        );

	        logger.info("Test passed: Invalid credentials correctly rejected. Message: " + actualError);

	    } catch (Exception e) {
	        logger.error("Test failed: " + e.getMessage());
	        Assert.fail("Test failed due to: " + e.getMessage());
	    }
	}
	
	@Test(priority = 4, groups = {"Regression", "Negative"})
	public void loginWithEmptyUsername() {
	    try {
	        logger.info("Starting test: Login with empty username");
	        LoginPage lp = new LoginPage(driver);

	        lp.setUsername("");
	        logger.info("Left username field empty");

	        lp.setPassword(p.getProperty("UserPasswordId"));
	        logger.info("Entered valid password");

	        lp.clickSubmit();
	        logger.info("Clicked submit with empty username");

	        String actualError =  lp.getLoginErrorMessage();

	        Assert.assertTrue(!actualError.isEmpty(), "Error message should be displayed");
	        Assert.assertTrue(
	            actualError.toLowerCase().contains("required") ||
	            actualError.toLowerCase().contains("could not be verified") ||
	            actualError.toLowerCase().contains("please enter"),
	            "Expected error message not displayed. Actual: " + actualError
	        );

	        logger.info("Test passed: Empty username correctly rejected. Message: " + actualError);

	    } catch (Exception e) {
	        logger.error("Test failed: " + e.getMessage());
	        Assert.fail("Test failed due to: " + e.getMessage());
	    }
	}
	
	@Test(priority = 5, groups = {"Regression", "Negative"})
	public void loginWithEmptyPassword() {
	    try {
	        logger.info("Starting test: Login with empty password");
	        LoginPage lp = new LoginPage(driver);

	        lp.setUsername(p.getProperty("UsernameID"));
	        logger.info("Entered valid username");

	        lp.setPassword("");
	        logger.info("Left password field empty");

	        lp.clickSubmit();
	        logger.info("Clicked submit with empty password");

	        String actualError =  lp.getLoginErrorMessage();

	        Assert.assertTrue(!actualError.isEmpty(), "Error message should be displayed");
	        Assert.assertTrue(
	            actualError.toLowerCase().contains("required") ||
	            actualError.toLowerCase().contains("could not be verified") ||
	            actualError.toLowerCase().contains("please enter"),
	            "Expected error message not displayed. Actual: " + actualError
	        );

	        logger.info("Test passed: Empty password correctly rejected. Message: " + actualError);

	    } catch (Exception e) {
	        logger.error("Test failed: " + e.getMessage());
	        Assert.fail("Test failed due to: " + e.getMessage());
	    }
	}
	
	@Test(priority = 6, groups = {"Regression", "Negative"})
	public void loginWithBothFieldsEmpty() {
	    try {
	        logger.info("Starting test: Login with both fields empty");
	        LoginPage lp = new LoginPage(driver);

	        lp.setUsername("");
	        logger.info("Left username field empty");

	        lp.setPassword("");
	        logger.info("Left password field empty");

	        lp.clickSubmit();
	        logger.info("Clicked submit with empty fields");

	        String actualError = lp.getLoginErrorMessage();

	        Assert.assertTrue(!actualError.isEmpty(), "Error message should be displayed");
	        Assert.assertTrue(
	            actualError.toLowerCase().contains("required") ||
	            actualError.toLowerCase().contains("could not be verified") ||
	            actualError.toLowerCase().contains("please enter"),
	            "Expected error message not displayed. Actual: " + actualError
	        );

	        logger.info("Test passed: Empty fields correctly rejected. Message: " + actualError);

	    } catch (Exception e) {
	        logger.error("Test failed: " + e.getMessage());
	        Assert.fail("Test failed due to: " + e.getMessage());
	    }
	}
	
	@Test(priority = 7, groups = {"Regression", "Negative"})
	public void loginWithSQLInjection() {
	    try {
	        logger.info("Starting test: Login with SQL injection attempt");
	        LoginPage lp = new LoginPage(driver);

	        lp.setUsername("' OR '1'='1");
	        logger.info("Entered SQL injection in username");

	        lp.setPassword("' OR '1'='1");
	        logger.info("Entered SQL injection in password");

	        lp.clickSubmit();
	        logger.info("Clicked submit with SQL injection");

	        String actualError =  lp.getLoginErrorMessage();

	        Assert.assertTrue(!actualError.isEmpty(), "Error message should be displayed");
	        Assert.assertTrue(
	            actualError.toLowerCase().contains("enter") ||
	            actualError.toLowerCase().contains("invalid") ||
	            actualError.toLowerCase().contains("could not be verified"),
	            "SQL injection not prevented. Actual: " + actualError
	        );

	        logger.info("Test passed: SQL injection prevented. Message: " + actualError);

	    } catch (Exception e) {
	        logger.error("Test failed: " + e.getMessage());
	        Assert.fail("Test failed due to: " + e.getMessage());
	    }
	}
	
	@Test(priority = 8, groups = {"Regression", "Negative"})
	public void loginWithSpecialCharacters() {
	    try {
	        logger.info("Starting test: Login with special characters");
	        LoginPage lp = new LoginPage(driver);

	        lp.setUsername("!@#$%^&*()");
	        logger.info("Entered special characters in username");

	        lp.setPassword("!@#$%^&*()");
	        logger.info("Entered special characters in password");

	        lp.clickSubmit();
	        logger.info("Clicked submit with special characters");

	        String actualError =  lp.getLoginErrorMessage();

	        Assert.assertTrue(!actualError.isEmpty(), "Error message should be displayed");
	        Assert.assertTrue(
	            actualError.toLowerCase().contains("could not be verified") ||
	            actualError.toLowerCase().contains("invalid") ||
	            actualError.toLowerCase().contains("error"),
	            "Expected error message not displayed. Actual: " + actualError
	        );

	        logger.info("Test passed: Special characters correctly rejected. Message: " + actualError);

	    } catch (Exception e) {
	        logger.error("Test failed: " + e.getMessage());
	        Assert.fail("Test failed due to: " + e.getMessage());
	    }
	}
	
	@Test(priority = 9, groups = {"Regression", "Negative"})
	public void loginWithSpacesInCredentials() {
	    try {
	        logger.info("Starting test: Login with spaces in credentials");
	        LoginPage lp = new LoginPage(driver);

	        lp.setUsername("   " + p.getProperty("UsernameID") + "   ");
	        logger.info("Entered username with leading and trailing spaces");

	        lp.setPassword("   " + p.getProperty("UserPasswordId") + "   ");
	        logger.info("Entered password with leading and trailing spaces");

	        lp.clickSubmit();
	        logger.info("Clicked submit with spaces in credentials");

	        String actualError =  lp.getLoginErrorMessage();
	        Assert.assertTrue(!actualError.isEmpty(), "Error message should be displayed");
	        Assert.assertTrue(
	            actualError.toLowerCase().contains("could not be verified") ||
	            actualError.toLowerCase().contains("invalid") ||
	            actualError.toLowerCase().contains("enter"),
	            "Expected error message not displayed. Actual: " + actualError
	        );

	        logger.info("Test passed: Spaces in credentials handled correctly. Message: " + actualError);

	    } catch (Exception e) {
	        logger.error("Test failed: " + e.getMessage());
	        Assert.fail("Test failed due to: " + e.getMessage());
	    }
	}
	
	@Test(priority = 10, groups = {"Regression", "Negative"})
	public void loginWithCaseSensitiveUsername() {
	    try {
	        logger.info("Starting test: Login with case-sensitive username");
	        LoginPage lp = new LoginPage(driver);

	        String username = p.getProperty("UsernameID");
	        lp.setUsername(username.toUpperCase());
	        logger.info("Entered username in uppercase: " + username.toUpperCase());

	        lp.setPassword(p.getProperty("UserPasswordId"));
	        logger.info("Entered valid password");

	        lp.clickSubmit();
	        logger.info("Clicked submit with uppercase username");

	        String actualError =  lp.getLoginErrorMessage();

	        Assert.assertTrue(!actualError.isEmpty(), "Error message should be displayed");
	        Assert.assertTrue(
	            actualError.toLowerCase().contains("enter") ||
	            actualError.toLowerCase().contains("invalid") ||
	            actualError.toLowerCase().contains("could not be verified"),
	            "Case sensitivity not enforced. Actual: " + actualError
	        );

	        logger.info("Test passed: Case sensitivity validated correctly. Message: " + actualError);

	    } catch (Exception e) {
	        logger.error("Test failed: " + e.getMessage());
	        Assert.fail("Test failed due to: " + e.getMessage());
	    }
	}
	
	@Test(priority = 11, groups = {"Regression"})
	public void loginWithExcessivelyLongUsername() {
	    try {
	        logger.info("Starting test: Login with excessively long username");
	        LoginPage lp = new LoginPage(driver);

	        String longUsername = "a".repeat(200) + "@test.com";
	        lp.setUsername(longUsername);
	        logger.info("Entered excessively long username (100+ characters)");

	        lp.setPassword(p.getProperty("UserPasswordId"));
	        logger.info("Entered valid password");

	        lp.clickSubmit();
	        logger.info("Clicked submit with long username");

	        String actualError =  lp.getLoginErrorMessage();

	        Assert.assertTrue(!actualError.isEmpty(), "Error message should be displayed");
	        Assert.assertTrue(
	            actualError.toLowerCase().contains("invalid") ||
	            actualError.toLowerCase().contains("enter") ||
	            actualError.toLowerCase().contains("could not be verified"),
	            "Long username not handled. Actual: " + actualError
	        );

	        logger.info("Test passed: Long username correctly rejected. Message: " + actualError);

	    } catch (Exception e) {
	        logger.error("Test failed: " + e.getMessage());
	        Assert.fail("Test failed due to: " + e.getMessage());
	    }
	}
	
	@Test(priority = 12, groups = {"Regression"})
	public void loginWithScriptTags() {
	    try {
	        logger.info("Starting test: Login with script tags (XSS)");
	        LoginPage lp = new LoginPage(driver);

	        lp.setUsername("<script>alert('XSS')</script>");
	        logger.info("Entered script tag in username");

	        lp.setPassword("<script>alert('XSS')</script>");
	        logger.info("Entered script tag in password");

	        lp.clickSubmit();
	        logger.info("Clicked submit with script tags");

	        String actualError = lp.getLoginErrorMessage();

	        Assert.assertTrue(!actualError.isEmpty(), "Error message should be displayed");
	        Assert.assertTrue(
	            actualError.toLowerCase().contains("error") ||
	            actualError.toLowerCase().contains("enter") ||
	            actualError.toLowerCase().contains("could not be verified"),
	            "XSS not prevented. Actual: " + actualError
	        );

	        logger.info("Test passed: XSS attack prevented. Message: " + actualError);

	    } catch (Exception e) {
	        logger.error("Test failed: " + e.getMessage());
	        Assert.fail("Test failed due to: " + e.getMessage());
	    }
	}
	
}



	

