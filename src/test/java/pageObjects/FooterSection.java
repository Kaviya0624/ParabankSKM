package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterSection extends BasePage {
	
	public FooterSection(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//a[normalize-space()='Forum']")
	WebElement lnkForum;
	
	@FindBy(xpath="//a[normalize-space()='Site Map']")
	WebElement lnkSiteMap;
	
	@FindBy(xpath="//div[normalize-space()='Posts']")
	WebElement divPosts;
	
	@FindBy(xpath="//div[normalize-space()='Categories']")
	WebElement divCategories;
	
	@FindBy(xpath="//p[@class='copyright']")
	WebElement txtCopyright;
	
	@FindBy(xpath="//div[@id='footermainPanel']//ul[1]//li[2]//a[1]")
	WebElement lnkFooterLink2;
	
	@FindBy(xpath="//div[@id='footermainPanel']//li[3]//a[1]")
	WebElement lnkFooterLink3;
	
	@FindBy(xpath="//div[@id='footermainPanel']//li[4]//a[1]")
	WebElement lnkFooterLink4;
	
	@FindBy(xpath="//div[@id='footermainPanel']//li[5]//a[1]")
	WebElement lnkFooterLink5;
	
	
	public void clickForum()
	{
		lnkForum.click();
	}
	public void clickSiteMap()
	{
		lnkSiteMap.click();
	}
	
	public void clickPosts()
	{
		divPosts.click();
	}
	public void clickCategories()
	{
		divCategories.click();
	}
	
	public String getCopyrightText()
	{
		return txtCopyright.getText();
	}
	
	public void clickFTAboutUs()
	{
		lnkFooterLink2.click();
	}
	public void clickFTServices()
	{
		lnkFooterLink3.click();
	}
	public void clickFTProducts()
	{
		lnkFooterLink4.click();
	}
	public void clickFTLocations()
	{
		lnkFooterLink5.click();
	}
}
