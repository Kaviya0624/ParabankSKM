package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath ="//a[normalize-space()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath="//input[@id='customer.firstName']")
	WebElement txtUserFirstName;
	
	@FindBy(xpath="//input[@id='customer.lastName']")
	WebElement txtUserLastName;
	
	@FindBy(xpath="//input[@id='customer.address.street']")
	WebElement txtUserAddress;
	
	@FindBy(xpath="//input[@id='customer.address.city']")
	WebElement txtUserCity;
	
	@FindBy(xpath="//form/table/tbody/tr[5]/td[2]/input")
	WebElement txtUserState;
	
	@FindBy(xpath="//form/table/tbody/tr[6]/td[2]/input")
	WebElement txtUserZipCode;
	
	@FindBy(xpath="//input[@id='customer.phoneNumber']")
	WebElement txtUserPhoneNumber;
	
	@FindBy(xpath="//input[@id='customer.ssn']")
	WebElement txtUserSsn;
	
	@FindBy(xpath="//input[@id='customer.username']")
	WebElement txtCustomerUsername;
	
	@FindBy(xpath="//input[@id='customer.password']")
	WebElement txtCustomerPassword;
	
	@FindBy(xpath="//input[@id='repeatedPassword']")
	WebElement txtCustomerRepeatedPassword;
	
	@FindBy(xpath ="//input[@value='Register']")
	WebElement Register;
	
	@FindBy(xpath="//p[contains(text(),'Your account was created successfully. You are now')]")
	WebElement msg;
	

	public void clickOnRegister() {
		registerLink.click();
	}
	
	public void setCustomerFirstName(String CustomerFirstName) {
		txtUserFirstName.sendKeys(CustomerFirstName);
	}
	
	public void setCustomerLastName(String CustomerLastName) {
		txtUserLastName.sendKeys(CustomerLastName);
	}
	
	public void setCustomerAddress(String CustomerAddress) {
		txtUserAddress.sendKeys(CustomerAddress);
	}
	
	public void setCustomerCity(String CustomerCity) {
		txtUserCity.sendKeys(CustomerCity);
	}
	
	public void setCustomerState(String CustomerState) {
		txtUserState.sendKeys(CustomerState);
	}
	
	public void setCustomerZipCode(String CustomerZipCode) {
		txtUserZipCode.sendKeys(CustomerZipCode);
	}
	
	public void setCustomerPhoneNumber(String CustomerPhoneNumber) {
		txtUserPhoneNumber.sendKeys(CustomerPhoneNumber);
	}
	
	public void setCustomerSsn(String CustomerSsn) {
		txtUserSsn.sendKeys(CustomerSsn);
	}
	
	public void setCustomerUsername(String CustomerUsername) {
		txtCustomerUsername.sendKeys(CustomerUsername);
	}
	
	public void setCustomerPassword(String CustomerPassword) {
		txtCustomerPassword.sendKeys(CustomerPassword);
	}
	
	public void setCustomerRepeatedPassword(String CustomerRepeatedPassword) {
		txtCustomerRepeatedPassword.sendKeys(CustomerRepeatedPassword);
	}
	
	public void clickOnRegisterBtn() {
		Register.click();;
	}
	
	public String getSuccessMessage() {
	    return msg.getText();
	}
}
