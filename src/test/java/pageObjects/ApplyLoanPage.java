package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ApplyLoanPage extends BasePage {
	
	public ApplyLoanPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Request Loan']")
	WebElement Loan;
	
	
	 @FindBy(id = "amount")
	 WebElement txtAmount;

	    @FindBy(id = "downPayment")
	   WebElement txtDownPayment;

	    @FindBy(id = "fromAccountId")
	    WebElement fromAccountDropdown;

	    @FindBy(xpath = "//input[@value='Apply Now']")
	    WebElement btnApplyNow;

	    @FindBy(xpath = "//p[normalize-space()='Congratulations, your loan has been approved.']")
	    WebElement loanApprovalMessage;

	    @FindBy(xpath = "//td[@id='loanStatus']")
	    WebElement loanStatusValue;

	    public void clickApplyLoan()
	    {
	    	Loan.click();
	    }
	    
	    public void setAmount(String amount) 
	    {
	        txtAmount.clear();
	        txtAmount.sendKeys(amount);
	    }



	    public void setDownPayment(String downPayment)
	    {
	        txtDownPayment.clear();
	        txtDownPayment.sendKeys(downPayment);
	    }


	    public void selectFromAccount(int index) {
	        Select select = new Select(fromAccountDropdown);
	        select.selectByIndex(index);
	    }



	    public void clickApplyNow()
	    {
	        btnApplyNow.click();
	    }
	    
	    public String getLoanApprovalMessage() {
	        try {
	            return loanApprovalMessage.getText();
	        } catch (Exception e) {
	            return e.getMessage();
	        }
	    }

	    public boolean isLoanApproved() {
	        try {
	            return loanApprovalMessage.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public String getLoanStatus() {
	        try {
	            return loanStatusValue.getText();
	        } catch (Exception e) 
	        {
	            return e.getMessage();
	        }
	    }

	    public boolean isLoanStatus(String expectedStatus) {
	        try {
	            return loanStatusValue.getText().equalsIgnoreCase(expectedStatus);
	        } 
	        catch (Exception e) {
	            return false;
	        }
	    }

}
