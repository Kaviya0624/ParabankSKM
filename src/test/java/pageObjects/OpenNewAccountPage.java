package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath = "//select[@id='fromAccountId']")
	WebElement fromAccountDropdown;
	
	@FindBy(xpath = "//a[@id='newAccountId']")
	WebElement newAcc;
	
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
	
	
	public String getConfirmationMsg() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement msg = wait.until(ExpectedConditions.visibilityOf(successMessage));
	        return msg.getText().trim();
	    } catch (Exception e) {
	        return "";
	    }
	}

  public void clickNewAcc()
  {
	  newAcc.click();
  }
	
	public void selectFromAccountByIndex(int index) {
	    Select select = new Select(fromAccountDropdown);
	    select.selectByIndex(index);
	}
}
