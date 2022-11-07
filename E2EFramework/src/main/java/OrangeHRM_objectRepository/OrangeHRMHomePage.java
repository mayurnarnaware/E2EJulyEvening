package OrangeHRM_objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMHomePage {
	
	WebDriver driver;
	
	//private By txtPIMHeader = By.xpath("//h6[text()='PIM']");
	@FindBy(xpath="//h6[text()='PIM']")
	private WebElement txtPIMHeader;
	
	//private By txtLoggedInUser = By.xpath("//img[@alt='profile picture']/following-sibling::p");
	@FindBy(xpath="//img[@alt='profile picture']/following-sibling::p")
	private WebElement txtLoggedInUser;
	
	//private By lnkLogout = By.linkText("Logout");
	@FindBy(linkText="Logout")
	private WebElement lnkLogout;
	
	public OrangeHRMHomePage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getTxtPIMHeader() {
		return txtPIMHeader;
	}
	public WebElement getTxtLoggedInUser() {
		return txtLoggedInUser;
	}
	public WebElement getLnkLogout() {
		return lnkLogout;
	}
	
	
}
