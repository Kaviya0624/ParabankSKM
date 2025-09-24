package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(id = "fromAccountId")
	WebElement SelectFromAccnt;

	@FindBy(id = "toAccountId")
	WebElement SelectToAccnt;

	// Action Method
	public void clickOnTransferFunds() {
		TransferFunds.click();
	}

	public void setAmount(String Amount) {
		txtAmount.sendKeys(Amount);
	}

	public WebElement selectFromAccount() {
		SelectFromAccnt.click();
		return SelectFromAccnt;
	}

	public WebElement selectToAccount() {
		SelectToAccnt.click();
		return SelectToAccnt;
	}

	public void clickOnTransferSubmitBtn() {
		TransferBtn.click();
	}

}
