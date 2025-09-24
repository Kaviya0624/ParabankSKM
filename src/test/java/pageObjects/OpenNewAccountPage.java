package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccountPage extends BasePage  {
	
	
	public OpenNewAccountPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(partialLinkText="Open New Account")
	WebElement OpenNewAccountLink;
	
	@FindBy(id = "type")
    public WebElement SelectAccountType;
	
	@FindBy(xpath ="//input[@value='Open New Account']")
	WebElement OpenNewAccountBtn;
	
	
	
	//Action Method 
	public void clickOnOpenNewAccount() {
		OpenNewAccountLink.click();
	}
	
    public WebElement selectAccountTypes() {
    	SelectAccountType.click();
    	return SelectAccountType;
    }
    
	public void clickOnOpenNewAccountSubmitBtn() {
		OpenNewAccountBtn.click();
	}
}
