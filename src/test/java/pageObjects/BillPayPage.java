package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPayPage extends BasePage  {
	

	public BillPayPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//a[normalize-space()='Bill Pay']")
	
	WebElement BillPayMenu;

	@FindBy(xpath ="//input[@name='payee.name']")
	
	WebElement txtPayeeName;
	
	@FindBy(xpath ="//input[@name='payee.address.street']")
	
	WebElement txtPayeeAddress;
	
	@FindBy(xpath ="//input[@name='payee.address.city']")
	
	WebElement txtPayeeCity;
	
	@FindBy(xpath ="//input[@name='payee.address.state']")
	
	WebElement txtPayeeState;
	
	@FindBy(xpath ="//input[@name='payee.address.zipCode']")
	
	WebElement txtPayeezipCode;
	
	@FindBy(xpath ="/html/body/div[1]/div[3]/div[2]/div/div[1]/form/table/tbody/tr[6]/td[2]/input")
	
	WebElement txtPayeePhone;
	
	@FindBy(xpath ="//input[@name='payee.accountNumber']")
	
	WebElement txtPayeeAccountNumber;

	@FindBy(xpath="//input[@name='verifyAccount']")
	
	WebElement txtVerifyAccount;

	@FindBy(xpath="//input[@name='amount']")
	
	WebElement txtBillPayAmount;

	@FindBy(xpath = "//select[@name='fromAccountId']")
	
	WebElement SelectFromAccnt;
	
	@FindBy(xpath = "//input[@value='Send Payment']")
	
	WebElement SendPaymentSubmitBtn;
	

	// Action Method
	public void clickOnBillPayMenu() {
		BillPayMenu.click();
	}

	public void setPayeeName(String PayeeName) {
		txtPayeeName.sendKeys(PayeeName);
	}

	public void setPayeeAddress(String PayeeAddress) {
		txtPayeeAddress.sendKeys(PayeeAddress);
	}
	
	public void setPayeeCity(String PayeeCity) {
		txtPayeeCity.sendKeys(PayeeCity);
	}
	
	public void setPayeeState(String PayeeState) {
		txtPayeeState.sendKeys(PayeeState);
	}
	
	public void setPayeezipCode(String PayeezipCode) {
		txtPayeezipCode.sendKeys(PayeezipCode);
	}
	
	public void setPayeePhone(String PayeePhone) {
		txtPayeePhone.sendKeys(PayeePhone);
	}
	
	public void setPayeeAccountNumber(String PayeeAccountNumber) {
		txtPayeeAccountNumber.sendKeys(PayeeAccountNumber);
	}
	
	public void setVerifyAccount(String VerifyAccount) {
		txtVerifyAccount.sendKeys(VerifyAccount);
	}
	
	public void setBillPayAmount(String Amount) {
		txtBillPayAmount.sendKeys(Amount);
	}
	
	public WebElement selectFromAccount() {
		SelectFromAccnt.click();
		return SelectFromAccnt;
	}
	
	public void clickOnSendPaymentSubmitBtn() {
		SendPaymentSubmitBtn.click();
	}

}
