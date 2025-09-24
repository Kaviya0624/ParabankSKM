package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterSection extends BasePage {
	
	public FooterSection(WebDriver driver)
	{
		super(driver);
	}

	  @FindBy(xpath = "//a[normalize-space()='Home']")
	    WebElement footerHome;

	    @FindBy(xpath = "//a[normalize-space()='Forum']")
	    WebElement footerForum;

	    @FindBy(xpath = "//a[normalize-space()='Site Map']")
	    WebElement footerSiteMap;

	    @FindBy(xpath = "//a[normalize-space()='Contact Us']")
	    WebElement footerContactUs;

	    @FindBy(xpath = "//p[@class='copyright']")
	    WebElement footerCopyright;

	    @FindBy(xpath = "//a[normalize-space()='www.parasoft.com']")
	    WebElement footerParasoftLink;

	    // Action Methods
	    public void clickFooterHome() {
	        footerHome.click();
	    }

	    public void clickFooterForum() {
	        footerForum.click();
	    }

	    public void clickFooterSiteMap() {
	        footerSiteMap.click();
	    }

	    public void clickFooterContactUs() {
	        footerContactUs.click();
	    }

	    public String getCopyrightText() {
	        return footerCopyright.getText();
	    }

	    public void clickParasoftLink() {
	        footerParasoftLink.click();
	    }
}
