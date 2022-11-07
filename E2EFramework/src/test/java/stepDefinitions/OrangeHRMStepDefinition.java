package stepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import OrangeHRMTestCases.OrangeHRMLoginLogoutTest;
import OrangeHRM_objectRepository.OrangeHRMHomePage;
import OrangeHRM_objectRepository.OrangeHRMLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;

public class OrangeHRMStepDefinition extends Base{
	public static Logger log = LogManager.getLogger(OrangeHRMLoginLogoutTest.class.getName());
	OrangeHRMLoginPage lp;
	OrangeHRMHomePage hp;
	public WebDriver driver;
	@Given("^User is on Login page$")
    public void user_is_on_login_page() throws Throwable {
		driver = initializeDriver();
		driver.get(getURLOrangeHRM());
		lp = new OrangeHRMLoginPage(driver);
		hp = new OrangeHRMHomePage(driver);
		boolean isOnLogin = lp.getTxtLoginHeading().isDisplayed();
		Assert.assertTrue(isOnLogin,"StepFail: Not on login page");
		log.info("StepPass: On Login page");
		
	}

//    @When("^User clicks on login button by entering username and password$")
//    public void user_clicks_on_login_button_by_entering_username_and_password() throws Throwable {
//    	driver.findElement(By.name("username")).sendKeys("admin");
//		driver.findElement(By.name("password")).sendKeys("admin123");
//		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
//    }
	@When("^User clicks on login button by entering username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_clicks_on_login_button_by_entering_username_as_something_and_password_as_something(String username, String password) throws Throwable {
		lp.getTxtBoxUsername().sendKeys(username);
		lp.getTxtBoxPassword().sendKeys(password);
		lp.getBtnLogin().click();
    }
	
/*	
    @Then("^Login is successful$")
    public void login_is_successful() throws Throwable {
       boolean isLoginSuccess = driver.findElement(By.xpath("//h6[text()='PIM']")).isDisplayed();
       if(isLoginSuccess==true) {
    	   System.out.println("StepPass: Login successful");
       }
       else {
    	   System.out.println("StepFail: Login unsuccessful");
       }
    }

    @And("^Username is displayed$")
    public void username_is_displayed() throws Throwable {
      String username =  driver.findElement(By.xpath("//img[@alt='profile picture']/following-sibling::p")).getText();
      System.out.println("Username: " + username);
      
      if(username.equals(null) || username.equals("")) {
    	  System.out.println("StepFail: Username not available");
      }
      else {
    	  System.out.println("StepPass: Username is available");
      }
    }
*/  
	
	@Then("^Login success is \"([^\"]*)\"$")
    public void login_success_is_something(String strArg1) throws Throwable {
		boolean isLoginSuccess;
		if(strArg1.equals("true")) {
		   isLoginSuccess = hp.getTxtPIMHeader().isDisplayed();
	       if(isLoginSuccess==true) {
	    	   System.out.println("StepPass: Login successful");
	       }
	       else {
	    	   System.out.println("StepFail: Login unsuccessful");
	       }
	   }
       else {
    	   
    	try {
			isLoginSuccess = hp.getTxtPIMHeader().isDisplayed();
		} catch (Exception e) {
			isLoginSuccess = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       if(isLoginSuccess==false) {
	    	   System.out.println("StepPass: Login is unsuccessful with invalid credentials");
	       }
	       else {
	    	   System.out.println("StepFail: Login is successful with invalid credentials");
	       }
       }
    }
	
	@And("^Username display is \"([^\"]*)\"$")
	public void username_display_is_something(String strArg1) throws Throwable {
		String username;
		if(strArg1.equals("true")) {
			  username =  hp.getTxtLoggedInUser().getText();
		      System.out.println("Username: " + username);
		      
		      if(username.equals(null) || username.equals("")) {
		    	  System.out.println("StepFail: Username not available");
		      }
		      else {
		    	  System.out.println("StepPass: Username is available");
		      }
		}
		else {
			try {
				username =  hp.getTxtLoggedInUser().getText();
			} catch (Exception e) {
				username = "";
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      System.out.println("Username: " + username);
		      
		      if(username.equals("")) {
		    	  System.out.println("StepPass: Username not available as user is trying to login with invalid credentials");
		      }
		      else {
		    	  System.out.println("StepFail: Username is available as user logged in with invalida credentials");
		      }
		}
	}
	
    @And("^Close application$")
    public void close_application() {
    	driver.quit();
    }
}
