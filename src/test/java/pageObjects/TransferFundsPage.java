package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
}
