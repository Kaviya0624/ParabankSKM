package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	 @FindBy(xpath = "//ul[@class='leftmenu']//li//a[@href='about.htm'][normalize-space()='About Us']")
	 WebElement aboutUsLink;
	 
	 @FindBy(xpath = "//h1[normalize-space()='ParaSoft Demo Website']")
	 WebElement mainHeading;


	  @FindBy(xpath = "//ul[@class='leftmenu']//li//a[@href='services.htm'][normalize-space()='Services']")
	  WebElement servicesLink;
	  
	  @FindBy(xpath = "//span[normalize-space()='Available RESTful services:']")
	  WebElement availableRestServicesText;


	  @FindBy(xpath = "//ul[@class='leftmenu']//a[normalize-space()='Products']")
	  WebElement productsLink;
	  
	  @FindBy(xpath = "//span[normalize-space()='Products']")
	    WebElement productsSection;

	    @FindBy(xpath = "//span[normalize-space()='Solutions']")
	    WebElement solutionsSection;

	    @FindBy(xpath = "//span[normalize-space()='Industries']")
	    WebElement industriesSection;

	    @FindBy(xpath = "//span[normalize-space()='Customer Success']")
	    WebElement customerSuccessSection;

	    @FindBy(xpath = "//span[normalize-space()='Resources']")
	    WebElement resourcesSection;

	  @FindBy(xpath = "//ul[@class='leftmenu']//a[normalize-space()='Locations']")
	  WebElement locationsLink;

	  @FindBy(xpath = "//a[normalize-space()='Admin Page']")
	  WebElement adminPageLink;
	  
	  @FindBy(xpath = "//a[normalize-space()='home']")
	    WebElement homeLink;

	    @FindBy(xpath = "//a[normalize-space()='about']")
	    WebElement aboutLink;

	    @FindBy(xpath = "//a[normalize-space()='contact']")
	    WebElement contactLink;

	    @FindBy(css = "button[aria-label='Close messenger prompt']")
	    WebElement close;
	    
	    public void clickAboutUs()
	    {
	        aboutUsLink.click();
	    }
	    
	    public String getMainHeadingText() 
	    {
	        return mainHeading.getText();
	    }

	    public void clickServices() 
	    {
	        servicesLink.click();
	    }

	    public void clickProducts()
	    {
	        productsLink.click();
	    }
	    
	    public void clickClose()
	    {
	    	close.click();
	    }
	    
	    public void clickProductsSec() {
	        productsSection.click();
	    }

	    public void clickSolutions() {
	        solutionsSection.click();
	    }

	    public void clickIndustries() {
	        industriesSection.click();
	    }

	    public void clickCustomerSuccess() {
	        customerSuccessSection.click();
	    }

	    public void clickResources() {
	        resourcesSection.click();
	    }

	    public void clickLocations() 
	    {
	        locationsLink.click();
	    }

	    public void clickAdminPage()
	    {
	        adminPageLink.click();
	    }
	    
	    public void clickHome() {
	        homeLink.click();
	    }

	    public void clickAbout() {
	        aboutLink.click();
	    }

	    public void clickContact() {
	        contactLink.click();
	    }
	    
	    
	    public String getAvailableRestServicesText() {
	        return availableRestServicesText.getText();
	    }
	    

}
