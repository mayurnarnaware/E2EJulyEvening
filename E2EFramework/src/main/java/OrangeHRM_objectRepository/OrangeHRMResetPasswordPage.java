package OrangeHRM_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMResetPasswordPage {
	WebDriver driver;
	
	//private By txtResetPasswordHeading = By.xpath("//h6[text()='Reset Password']");
	//private By txtBoxUsername = By.name("username");
	//private By btnResetPassword = By.xpath("//button[text()=' Reset Password ']");
	//private By txtSuccessHeading = By.xpath("//h6[contains(normalize-space(),'successfully')]");
	
	@FindBy(xpath="//h6[text()='Reset Password']")
	private WebElement txtResetPasswordHeading;
	
	@FindBy(name="username")
	private WebElement txtBoxUsername;
	
	@FindBy(xpath="//button[text()=' Reset Password ']")
	private WebElement btnResetPassword;
	
	@FindBy(xpath="//h6[contains(normalize-space(),'successfully')]")
	private WebElement txtSuccessHeading;
	
	public OrangeHRMResetPasswordPage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getTxtResetPasswordHeading() {
		return txtResetPasswordHeading;
	}
	public WebElement getTxtBoxUsername() {
		return txtBoxUsername;
	}
	public WebElement getBtnResetPassword() {
		return btnResetPassword;
	}
	public WebElement getTxtSuccessHeading() {
		return txtSuccessHeading;
	}
	
}
