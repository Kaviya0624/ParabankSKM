package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferFundsPage extends BasePage {
	
	public TransferFundsPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(partialLinkText = "Transfer Funds")
	WebElement TransferFunds;

	@FindBy(xpath = "//input[@value='Transfer']")
	WebElement TransferBtn;

	@FindBy(id = "amount")
	WebElement txtAmount;

	@FindBy(xpath="//select[@id='fromAccountId']")
	WebElement Frmacc;
	
	@FindBy(xpath="//select[@id='toAccountId']")
	WebElement toacc;
	
	@FindBy(xpath = "//h1[normalize-space()='Transfer Complete!']")
	WebElement transferCompleteMessage;

	@FindBy(xpath = "//p[contains(text(),'An internal error has occurred and has been logged')]")
	WebElement internalErrorMessage;

	
	
	public void clickOnTransferFunds() {
		TransferFunds.click();
	}

	public void setAmount(String Amount) {
		txtAmount.sendKeys(Amount);
	}

	
	 public void selectFromAccount(int index)
	 {
	        Select select = new Select(Frmacc);
	       select.selectByIndex(index);
	 }

	 public void selectToAccount(int index)
	 {
	        Select select = new Select(toacc);
	       select.selectByIndex(index);
	 }

	public void clickOnTransferSubmitBtn() 
	{
		TransferBtn.click();
	}

	
	public String isTransferComplete()
	{
		try {
			return(transferCompleteMessage.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public String getErrorMessage1() {
	    try {
	        return internalErrorMessage.getText();
	    } catch (Exception e) {
	        return "";
	    }
	}
	
	public String getErrorMessage() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOf(internalErrorMessage));
	        return internalErrorMessage.getText().trim();
	    } catch (Exception e) {
	        return "Error message not found or not visible: " + e.getMessage();
	    }

}
}
