package QAClickTestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import QAClick_objectRepository.QAClickLandingPage;
import QAClick_objectRepository.QAClickLoginPage;
import resources.Base;
import resources.ExcelHandler;

public class QAClickLoginDDTTest extends Base{
	public static Logger log = LogManager.getLogger(QAClickLoginDDTTest.class.getName());
	public WebDriver driver;
	QAClickLandingPage QAlap;
	QAClickLoginPage QAlop;
	
	@BeforeMethod
	public void launchQAClickApp() throws IOException {
		log.debug("Initializing Driver");
		driver=initializeDriver();
		log.debug("Driver initialization successful");
		driver.get(getURLQAClick());
		
		QAlap = new QAClickLandingPage(driver);
		QAlop = new QAClickLoginPage(driver);
		
		boolean isOnLanding = QAlap.getHeadingfeaturedCourses().isDisplayed();
		Assert.assertTrue(isOnLanding,"StepFail: Not on landing page | ");
		log.info("StepPass: Currently on landing page");
	}
	
	@Test(dataProvider="dataMethod")
	public void DDTLoginTest(String username, String password) {
		if(QAlap.getBtnNoThanks()!=null) {
			log.info("StepPass: Pop is present");
			QAlap.getBtnNoThanks().click();
		}
		else {
			log.warn("No thanks popup not visible");
		}
		QAlap.getBtnLogin().click();
		boolean isOnLogin = QAlop.getHeadingLogin().isDisplayed();
		Assert.assertTrue(isOnLogin,"StepFail: Not on Login");
		log.info("StepPass: Currently on login page");
		QAlop.getTxtUserEmail().sendKeys(username);
		QAlop.getTxtUserPassword().sendKeys(password);
		QAlop.getBtnLogin().click();
		isOnLogin = QAlop.getHeadingLogin().isDisplayed();
		Assert.assertTrue(isOnLogin,"StepFail: login successful with invalid credentials");
		log.info("StepPass: Login unsuccessful using invalid credentials");
		
	}
	
	@AfterMethod
	public void closeOrangeHRM() {
		driver.quit();
	}
	
	@DataProvider
	public String[][] dataMethod() throws EncryptedDocumentException, IOException{
		ExcelHandler handler = new ExcelHandler();
		handler.handleExcel();
		int rows = handler.getUsernames().size();
		int columns = 2;
		String[][] data = new String[rows][columns];
		for(int i=0;i<=rows-1;i++) {
			data[i][0] = handler.getUsernames().get(i);
			data[i][1]= handler.getPasswords().get(i);
		}
		return data;
	}
}
