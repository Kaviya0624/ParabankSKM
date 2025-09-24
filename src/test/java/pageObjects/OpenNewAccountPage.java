package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends BasePage  {
	
	
	public OpenNewAccountPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(partialLinkText="Open New Account")
	WebElement OpenNewAccountLink;
	
	@FindBy(id = "type")
    WebElement SelectAccountType;
	
	@FindBy(xpath ="//input[@value='Open New Account']")
	WebElement OpenNewAccountBtn;
	
	@FindBy(xpath = "//p[normalize-space()='Congratulations, your account is now open.']")
	WebElement successMessage;
	
	public void clickOnOpenNewAccount()
	{
		OpenNewAccountLink.click();
	}
	
	 public void selectAccountType(String accountType)
	 {
	        Select select = new Select(SelectAccountType);
	        select.selectByVisibleText(accountType);
	 }

    
	public void clickOnOpenNewAccountSubmitBtn() 
	{
		OpenNewAccountBtn.click();
	}
	
	
	public String getConfirmationMsg()
	{
		try {
			return(successMessage.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
}
