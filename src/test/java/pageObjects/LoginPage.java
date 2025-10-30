package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {


	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(name = "username")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Log In']")
	WebElement btnLogin;

	@FindBy(xpath = "//p[@class='smallText']")
	WebElement UsresNameOnDeskBoard;

	@FindBy(xpath = "//a[contains(text(), 'Log Out')]")
	WebElement logoutLink;

	@FindBy(xpath = "//p[contains(text(), 'An internal error has occurred and has been logged.')]")
	WebElement InvalidCredentialErrorMsg;

	@FindBy(xpath = "//p[contains(text(), 'Please enter a username and password.')]")
	WebElement errorMessageForCredential;
	
	@FindBy(xpath="//h1[normalize-space()='Accounts Overview']")
	WebElement loginscu;
	
	@FindBy(xpath = "//p[@class='error']")
    WebElement errorMessage;

	public void setUsername(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String userPassword) {
		txtPassword.sendKeys(userPassword);
	}

	public String getErrorMessage() {
		return InvalidCredentialErrorMsg.getText();
	}

	public void clickSubmit() {
		btnLogin.click();
	}

	public String getUserNameDeskBoard() {
		return UsresNameOnDeskBoard.getText();
	}

	public void clickLogOut() {
		logoutLink.click();
	}

	public String getErrorMessageForEnterIdAndPassword() {
		return errorMessageForCredential.getText();
	}
	
	public String getSuccessLogin() {
	    return loginscu.getText();
	}
	
	public boolean isAccountPageExixts()
	{
		try
		{
			return (loginscu.isDisplayed()) ;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public String getLoginErrorMessage() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='error']")));
	        return errorElement.getText().trim();
	    } catch (Exception e) {
	        System.out.println("No error message displayed.");
	        return "";
	    }
	}

}
