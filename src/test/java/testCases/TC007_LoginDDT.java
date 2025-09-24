package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  - logout
	login failed - test fail

Data is invalid - login success - test fail  - logout
	login failed - test pass
*/

public class TC007_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData" , dataProviderClass = DataProviders.class,groups ="Datadriven")
	public void verify_Loginddt(String email, String pwd, String exp)
	{
		
	try
			
	{
		logger.info("***login started******");
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(email);
		lp.setPassword(pwd);
		Thread.sleep(2000);
		lp.clickSubmit();
		
		
		boolean targetpage = lp.isAccountPageExixts();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				Assert.assertTrue(true);
				lp.clickLogOut();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				lp.clickLogOut();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
			}
			
			catch(Exception e)
			{
				Assert.fail();
			}
		
	}

}
