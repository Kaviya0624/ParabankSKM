package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_RegisterTestCase extends BaseClass {

	@Test
	public void RegisterTest()
	{
		
		logger.info("URL is opened");
		RegisterPage rp=new RegisterPage(driver);
		
		rp.clickOnRegister();
		logger.info("User clicked on register Link");
		
		rp.setCustomerFirstName(randomeString().toUpperCase());
		logger.info("User Entered the First Name.");
		
		rp.setCustomerLastName(randomeString().toUpperCase());
		logger.info("User Entered the Last Name.");
		
		rp.setCustomerAddress(p.getProperty("CustomerAddress"));
		logger.info("User Entered the Address.");
		
		rp.setCustomerCity(p.getProperty("CustomerCity"));
		logger.info("User Entered the City.");

		rp.setCustomerState(p.getProperty("CustomerState"));
		logger.info("User Entered the State.");
		
		rp.setCustomerZipCode(p.getProperty("CustomerZipCode"));
		logger.info("User Entered the ZipCode.");
		
		rp.setCustomerPhoneNumber(p.getProperty("CustomerPhoneNumber"));
		logger.info("User Entered the PhoneNumber.");
		
		rp.setCustomerSsn(p.getProperty("CustomerSsn"));
		logger.info("User Entered the Ssn.");
		
		rp.setCustomerUsername(randomeString().toUpperCase());
		logger.info("User Entered the Username.");
		
		String password = randomeAlphaNumberic();
		
		rp.setCustomerPassword(password);
		logger.info("User Entered the Password.");
		
		rp.setCustomerRepeatedPassword(password);
		logger.info("User Entered the RepeatedPassword.");
		
		rp.clickOnRegisterBtn();
		
		
		String successMsg = rp.getSuccessMessage();
		Assert.assertTrue(successMsg.contains("Your account was created successfully"),
		                  "Account creation failed! Actual message: " + successMsg);

		logger.info("Account created successfully! Message displayed: " + successMsg);
	}
}
