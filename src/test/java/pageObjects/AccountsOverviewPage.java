package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsOverviewPage extends BasePage {
	
	public AccountsOverviewPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//table[@id='accountTable']//tbody/tr[1]/td[1]/a")
	WebElement firstAccount;
	
	@FindBy(xpath="//h1[normalize-space()='Account Details']")
	WebElement headingAccountDetails;
	
	@FindBy(xpath="//select[@id='month']")
	WebElement drpMonth;
	
	@FindBy(xpath="//select[@id='transactionType']")
	WebElement drpTransactionType;
	
	@FindBy(xpath="//input[@value='Go']")
	WebElement btnGo;
	
	@FindBy(xpath = "//h1[normalize-space()='Transaction Details']")
	WebElement headingTransactionDetails;
	
	@FindBy(xpath = "//b[normalize-space()='No transactions found.']")
	WebElement noTransactionsMessage;
	
	 public void clickFirstAccount() 
	 {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement acc = wait.until(ExpectedConditions.elementToBeClickable(firstAccount));
	        acc.click();
	 }

	 public String getFirstAccountNumber() 
	 {
		    return firstAccount.getText();
	 }  
	 
	 public String getAccountDetailsHeading()
	 {
			return headingAccountDetails.getText();
	 }
	   
	 public void selectMonthByValue(String value) 
	 {
	        if (value != null && !value.isEmpty()) 
	        {
	            Select select = new Select(drpMonth);
	            select.selectByValue(value);
	        }
	    }

	    
	    public void selectTransactionTypeByValue(String value) 
	    {
	        if (value != null && !value.isEmpty()) {
	            Select select = new Select(drpTransactionType);
	            select.selectByValue(value);
	        }
	    }

	    
	    public void clickGo() 
	    {
	        btnGo.click();
	    }

	    
	    public void filterTransactions(String monthValue, String transactionTypeValue) 
	    {
	        selectMonthByValue(monthValue);
	        selectTransactionTypeByValue(transactionTypeValue);
	        clickGo();
	    }
	    
	    public void clickFirstTransaction() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        // Dynamically locate the first transaction link
	        WebElement txn = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//table[@id='transactionTable']/tbody/tr[1]/td[2]/a")
	        ));
	        txn.click();
	    }

	    
	    public String getTransactionDetailsHeading() 
	    {
	        return headingTransactionDetails.getText();
	    }

	    // Method to check if heading is displayed
	    public boolean isTransactionDetailsDisplayed() 
	    {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        try {
	            wait.until(ExpectedConditions.visibilityOf(headingTransactionDetails));
	            return headingTransactionDetails.isDisplayed();
	        } 
	        catch (Exception e)
	        {
	            return false;
	        }
         }
	    
	    
	    public int getTransactionCount()
	    {
	        return driver.findElements(By.xpath("//table[@id='transactionTable']/tbody/tr")).size();
	    }

	    public void clickTransactionByIndex(int rowIndex) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement txn = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//table[@id='transactionTable']/tbody/tr[" + rowIndex + "]/td[2]/a")
	        ));
	        txn.click();
	    }
	    
	    public boolean hasTransactions() {
	        try {
	            return !noTransactionsMessage.isDisplayed();
	        } catch (Exception e) {
	            return true; // If element not found, assume transactions exist
	        }
	    }


	    }
