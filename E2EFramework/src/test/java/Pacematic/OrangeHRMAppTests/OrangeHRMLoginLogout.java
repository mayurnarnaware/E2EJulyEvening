package Pacematic.OrangeHRMAppTests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import OrangeHRM_objectRepository.OrangeHRMHomePage;
import OrangeHRM_objectRepository.OrangeHRMLoginPage;
import resources.Base;


public class OrangeHRMLoginLogout extends Base {
	public WebDriver driver;
	OrangeHRMLoginPage lp;
	OrangeHRMHomePage hp;
	
	@BeforeClass
	public void launchOrangeHRM() throws IOException {
		driver = initializeDriver();
		driver.get(getURLOrangeHRM());
		lp = new OrangeHRMLoginPage(driver);
		hp = new OrangeHRMHomePage(driver);
	}
	
	@Test
	public void loginLogoutTest() {
		boolean isOnLogin = lp.getTxtLoginHeading().isDisplayed();
		Assert.assertTrue(isOnLogin, "StepFailed: OrangeHRM failed to launch |");
		System.out.println("StepPass: OrangeHRM launched successfully");
		
		lp.getTxtBoxUsername().sendKeys(getUsername());
		lp.getTxtBoxPassword().sendKeys(getPassword());
		lp.getBtnLogin().click();
		
		boolean isOnHome = hp.getTxtPIMHeader().isDisplayed();
		Assert.assertTrue(isOnHome, "StepFail: Login unsuccessful |");
		System.out.println("StepPass: Login successfull, currently on homepage");
		
		String loggedInUser = hp.getTxtLoggedInUser().getText();
		System.out.println("loggedInUser: " + loggedInUser);
		
		hp.getTxtLoggedInUser().click();
		hp.getLnkLogout().click();
		
		isOnLogin = lp.getTxtLoginHeading().isDisplayed();
		Assert.assertTrue(isOnLogin, "StepFailed: Not on login page after logout |");
		System.out.println("StepPass: Currently on login page after logout");
	}
	
	@AfterClass
	public void closeOrangeHRM() {
		driver.quit();
	}

}
