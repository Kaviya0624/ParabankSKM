package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_RegisterTest extends BaseClass {

	@Test(priority=1,groups={"Regression" , "Master"})
	public void RegisterTest()
	{
		try
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
	    
		LoginPage lp = new LoginPage(driver);
		lp.clickLogOut();
		
		}
		
		catch(Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("****test executed*****");
	}


    @Test(priority = 2, groups = {"Negative"})
    public void RegisterWithMissingFirstName() {
        try {
            logger.info("URL is opened");
            RegisterPage rp = new RegisterPage(driver);

            rp.clickOnRegister();
            logger.info("User clicked on Register link");

            
            rp.setCustomerFirstName("");
            logger.info("Left First Name blank");

            rp.setCustomerLastName(randomeString().toUpperCase());
            rp.setCustomerAddress(p.getProperty("CustomerAddress"));
            rp.setCustomerCity(p.getProperty("CustomerCity"));
            rp.setCustomerState(p.getProperty("CustomerState"));
            rp.setCustomerZipCode(p.getProperty("CustomerZipCode"));
            rp.setCustomerPhoneNumber(p.getProperty("CustomerPhoneNumber"));
            rp.setCustomerSsn(p.getProperty("CustomerSsn"));
            rp.setCustomerUsername(randomeString().toUpperCase());

            String password = randomeAlphaNumberic();
            rp.setCustomerPassword(password);
            rp.setCustomerRepeatedPassword(password);

            rp.clickOnRegisterBtn();
            logger.info("Clicked on Register button");

            String errorMsg = rp.getFirstNameErrorMessage(); 

            Assert.assertTrue(errorMsg.toLowerCase().contains("first name"),
                    "Expected 'First Name' validation message but got: " + errorMsg);

            logger.info("Validation message displayed correctly: " + errorMsg);
        } 
        catch (Exception e) {
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }

        logger.info("**** Negative Test Executed: Missing First Name ****");
    }
    
    @Test(priority = 3, groups = {"Negative"})
    public void RegisterWithMissingLastName() {
        try {
            logger.info("URL is opened");
            RegisterPage rp = new RegisterPage(driver);

            rp.clickOnRegister();
            logger.info("User clicked on Register link");

            
            rp.setCustomerFirstName(randomeString().toUpperCase());
            rp.setCustomerLastName("");  // leave blank
            rp.setCustomerAddress(p.getProperty("CustomerAddress"));
            rp.setCustomerCity(p.getProperty("CustomerCity"));
            rp.setCustomerState(p.getProperty("CustomerState"));
            rp.setCustomerZipCode(p.getProperty("CustomerZipCode"));
            rp.setCustomerPhoneNumber(p.getProperty("CustomerPhoneNumber"));
            rp.setCustomerSsn(p.getProperty("CustomerSsn"));
            rp.setCustomerUsername(randomeString().toUpperCase());

            String password = randomeAlphaNumberic();
            rp.setCustomerPassword(password);
            rp.setCustomerRepeatedPassword(password);

            rp.clickOnRegisterBtn();
            logger.info("Clicked on Register button");

            // Fetch error message dynamically
            String errorMsg = rp.getFieldError("customer.lastName");
            System.out.println("Captured error: '" + errorMsg + "'");

            Assert.assertTrue(errorMsg.toLowerCase().contains("last name"),
                    "Expected 'Last Name' validation message but got: " + errorMsg);

            logger.info("Validation message displayed correctly: " + errorMsg);
        } catch (Exception e) {
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }

        logger.info("**** Negative Test Executed: Missing Last Name ****");
    }

    
    @Test(priority = 4, groups = {"Negative"})
    public void RegisterWithMissingAddress() {
        try {
            RegisterPage rp = new RegisterPage(driver);
            rp.clickOnRegister();

            rp.setCustomerFirstName(randomeString());
            rp.setCustomerLastName(randomeString());
            rp.setCustomerAddress("");  // blank
            rp.setCustomerCity(p.getProperty("CustomerCity"));
            rp.setCustomerState(p.getProperty("CustomerState"));
            rp.setCustomerZipCode(p.getProperty("CustomerZipCode"));
            rp.setCustomerPhoneNumber(p.getProperty("CustomerPhoneNumber"));
            rp.setCustomerSsn(p.getProperty("CustomerSsn"));
            rp.setCustomerUsername(randomeString());
            
            String password = randomeAlphaNumberic();
            rp.setCustomerPassword(password);
            rp.setCustomerRepeatedPassword(password);

            rp.clickOnRegisterBtn();

           
            String errorMsg = rp.getFieldError("customer.address.street");
            System.out.println("Captured Error: " + errorMsg);

            Assert.assertTrue(errorMsg.toLowerCase().contains("address"),
                    "Expected 'Address' validation message but got: " + errorMsg);
        } catch (Exception e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }


    @Test(priority = 5, groups = {"Negative"})
    public void RegisterWithMissingCity() {
        try {
            RegisterPage rp = new RegisterPage(driver);
            rp.clickOnRegister();

            rp.setCustomerFirstName(randomeString());
            rp.setCustomerLastName(randomeString());
            rp.setCustomerAddress(p.getProperty("CustomerAddress"));
            rp.setCustomerCity("");  // left blank
            rp.setCustomerState(p.getProperty("CustomerState"));
            rp.setCustomerZipCode(p.getProperty("CustomerZipCode"));
            rp.setCustomerPhoneNumber(p.getProperty("CustomerPhoneNumber"));
            rp.setCustomerSsn(p.getProperty("CustomerSsn"));
            rp.setCustomerUsername(randomeString());
            
            String password = randomeAlphaNumberic();
            rp.setCustomerPassword(password);
            rp.setCustomerRepeatedPassword(password);

            rp.clickOnRegisterBtn();

            
            String errorMsg = rp.getFieldError("customer.address.city");
            System.out.println("Captured Error: " + errorMsg);

            Assert.assertTrue(errorMsg.toLowerCase().contains("city"),
                    "Expected 'City' validation message but got: " + errorMsg);
        } catch (Exception e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }


    @Test(priority = 6, groups = {"Negative"})
    public void RegisterWithMissingState() {
        try {
            RegisterPage rp = new RegisterPage(driver);
            rp.clickOnRegister();

            rp.setCustomerFirstName(randomeString());
            rp.setCustomerLastName(randomeString());
            rp.setCustomerAddress(p.getProperty("CustomerAddress"));
            rp.setCustomerCity(p.getProperty("CustomerCity"));
            rp.setCustomerState("");
            rp.setCustomerZipCode(p.getProperty("CustomerZipCode"));
            rp.setCustomerPhoneNumber(p.getProperty("CustomerPhoneNumber"));
            rp.setCustomerSsn(p.getProperty("CustomerSsn"));
            rp.setCustomerUsername(randomeString());
            String password = randomeAlphaNumberic();
            rp.setCustomerPassword(password);
            rp.setCustomerRepeatedPassword(password);

            rp.clickOnRegisterBtn();

            
            String errorMsg = rp.getFieldError("customer.address.state");
            Assert.assertTrue(errorMsg.toLowerCase().contains("state"),
                    "Expected 'State' validation message but got: " + errorMsg);

            logger.info("Validation message displayed correctly: " + errorMsg);
            
        } catch (Exception e) {
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }


    @Test(priority = 7, groups = {"Negative"})
    public void RegisterWithMissingZipCode() {
        try {
            RegisterPage rp = new RegisterPage(driver);
            rp.clickOnRegister();

            rp.setCustomerFirstName(randomeString());
            rp.setCustomerLastName(randomeString());
            rp.setCustomerAddress(p.getProperty("CustomerAddress"));
            rp.setCustomerCity(p.getProperty("CustomerCity"));
            rp.setCustomerState(p.getProperty("CustomerState"));
            rp.setCustomerZipCode("");
            rp.setCustomerPhoneNumber(p.getProperty("CustomerPhoneNumber"));
            rp.setCustomerSsn(p.getProperty("CustomerSsn"));
            rp.setCustomerUsername(randomeString());
            String password = randomeAlphaNumberic();
            rp.setCustomerPassword(password);
            rp.setCustomerRepeatedPassword(password);

            rp.clickOnRegisterBtn();

            
            String errorMsg = rp.getFieldError("customer.address.zipCode");
            Assert.assertTrue(errorMsg.toLowerCase().contains("zip"),
                    "Expected 'Zip Code' validation message but got: " + errorMsg);

            logger.info("Validation message displayed correctly: " + errorMsg);
        } catch (Exception e) {
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }

    
    @Test(priority = 8, groups = {"Negative"})
    public void RegisterWithMissingSSN() {
        try {
            RegisterPage rp = new RegisterPage(driver);
            rp.clickOnRegister();

            rp.setCustomerFirstName(randomeString());
            rp.setCustomerLastName(randomeString());
            rp.setCustomerAddress(p.getProperty("CustomerAddress"));
            rp.setCustomerCity(p.getProperty("CustomerCity"));
            rp.setCustomerState(p.getProperty("CustomerState"));
            rp.setCustomerZipCode(p.getProperty("CustomerZipCode"));
            rp.setCustomerPhoneNumber(p.getProperty("CustomerPhoneNumber"));
            rp.setCustomerSsn(""); // Missing SSN
            rp.setCustomerUsername(randomeString());
            String password = randomeAlphaNumberic();
            rp.setCustomerPassword(password);
            rp.setCustomerRepeatedPassword(password);

            rp.clickOnRegisterBtn();

            // Add small wait for validation message to appear
            Thread.sleep(1000);

            String errorMsg = rp.getFieldError("customer.ssn");
            logger.info("Fetched SSN error message: " + errorMsg);

            // Check against expected keyword
            Assert.assertTrue(
                errorMsg != null && errorMsg.toLowerCase().contains("required"),
                "Expected 'SSN is required' validation message but got: " + errorMsg
            );

            logger.info("Validation message displayed correctly: " + errorMsg);
        } catch (Exception e) {
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }


    @Test(priority = 9, groups = {"Negative"})
    public void RegisterWithMissingUsername() {
        try {
            RegisterPage rp = new RegisterPage(driver);
            rp.clickOnRegister();

            rp.setCustomerFirstName(randomeString());
            rp.setCustomerLastName(randomeString());
            rp.setCustomerAddress(p.getProperty("CustomerAddress"));
            rp.setCustomerCity(p.getProperty("CustomerCity"));
            rp.setCustomerState(p.getProperty("CustomerState"));
            rp.setCustomerZipCode(p.getProperty("CustomerZipCode"));
            rp.setCustomerPhoneNumber(p.getProperty("CustomerPhoneNumber"));
            rp.setCustomerSsn(p.getProperty("CustomerSsn"));
            rp.setCustomerUsername(""); 

            String password = randomeAlphaNumberic();
            rp.setCustomerPassword(password);
            rp.setCustomerRepeatedPassword(password);

            rp.clickOnRegisterBtn();

            
            String errorMsg = rp.getFieldError("customer.username");
            Assert.assertTrue(errorMsg.toLowerCase().contains("username"),
                    "Expected 'Username' validation message but got: " + errorMsg);

            logger.info("Validation message displayed correctly: " + errorMsg);
        } 
        catch (Exception e) {
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }


    @Test(priority = 10, groups = {"Negative"})
    public void RegisterWithMissingPassword() {
        try {
            RegisterPage rp = new RegisterPage(driver);
            rp.clickOnRegister();

            rp.setCustomerFirstName(randomeString());
            rp.setCustomerLastName(randomeString());
            rp.setCustomerAddress(p.getProperty("CustomerAddress"));
            rp.setCustomerCity(p.getProperty("CustomerCity"));
            rp.setCustomerState(p.getProperty("CustomerState"));
            rp.setCustomerZipCode(p.getProperty("CustomerZipCode"));
            rp.setCustomerPhoneNumber(p.getProperty("CustomerPhoneNumber"));
            rp.setCustomerSsn(p.getProperty("CustomerSsn"));
            rp.setCustomerUsername(randomeString());

            rp.setCustomerPassword(""); 
            rp.setCustomerRepeatedPassword("123456"); 

            rp.clickOnRegisterBtn();

            
            String errorMsg = rp.getFieldError("customer.password");
            Assert.assertTrue(errorMsg.toLowerCase().contains("password"),
                    "Expected 'Password' validation message but got: " + errorMsg);

            logger.info("Validation message displayed correctly: " + errorMsg);
        } 
        catch (Exception e) {
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }

    
    @Test(priority = 11, groups = {"Negative"})
    public void RegisterWithMismatchedPasswords() {
        try {
            RegisterPage rp = new RegisterPage(driver);
            rp.clickOnRegister();

            rp.setCustomerFirstName(randomeString());
            rp.setCustomerLastName(randomeString());
            rp.setCustomerAddress(p.getProperty("CustomerAddress"));
            rp.setCustomerCity(p.getProperty("CustomerCity"));
            rp.setCustomerState(p.getProperty("CustomerState"));
            rp.setCustomerZipCode(p.getProperty("CustomerZipCode"));
            rp.setCustomerPhoneNumber(p.getProperty("CustomerPhoneNumber"));
            rp.setCustomerSsn(p.getProperty("CustomerSsn"));
            rp.setCustomerUsername(randomeString());
            rp.setCustomerPassword("Test123");
            rp.setCustomerRepeatedPassword("Test321"); // mismatched passwords

            rp.clickOnRegisterBtn();

            
            String errorMsg = rp.getFieldError("repeatedPassword");
            Assert.assertTrue(errorMsg.toLowerCase().contains("password"),
                    "Expected password mismatch validation message but got: " + errorMsg);

            logger.info("Validation message displayed correctly for mismatched passwords: " + errorMsg);
        } 
        catch (Exception e) {
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }

    @Test(priority = 12, groups = {"Negative"})
    public void RegisterWithExistingUsername() {
        try {
            RegisterPage rp = new RegisterPage(driver);
            rp.clickOnRegister();

            rp.setCustomerFirstName(randomeString());
            rp.setCustomerLastName(randomeString());
            rp.setCustomerAddress(p.getProperty("CustomerAddress"));
            rp.setCustomerCity(p.getProperty("CustomerCity"));
            rp.setCustomerState(p.getProperty("CustomerState"));
            rp.setCustomerZipCode(p.getProperty("CustomerZipCode"));
            rp.setCustomerPhoneNumber(p.getProperty("CustomerPhoneNumber"));
            rp.setCustomerSsn(p.getProperty("CustomerSsn"));
            
            // Use an existing username from config
            rp.setCustomerUsername(p.getProperty("ExistingUsername"));
            
            String password = randomeAlphaNumberic();
            rp.setCustomerPassword(password);
            rp.setCustomerRepeatedPassword(password);

            rp.clickOnRegisterBtn();

            
            String errorMsg = rp.getFieldError("customer.username");
            Assert.assertTrue(errorMsg.toLowerCase().contains("already exists"),
                    "Expected 'username already exists' message but got: " + errorMsg);

            logger.info("Validation message displayed correctly for existing username: " + errorMsg);
        } 
        catch (Exception e) {
            Assert.fail("Exception occurred during test: " + e.getMessage());
        }
    }


}
