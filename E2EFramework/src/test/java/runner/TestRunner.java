package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features/QAClickLogin.feature",
		glue="stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {

}
