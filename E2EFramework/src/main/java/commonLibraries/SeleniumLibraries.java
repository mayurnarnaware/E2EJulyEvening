package commonLibraries;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class SeleniumLibraries {
	public static Logger log = LogManager.getLogger(SeleniumLibraries.class.getName());

	public void click(WebElement element) {
		log.debug("clicking element: " + element);
		element.click();
		log.debug("clicked successfully: " + element);
	}
}
