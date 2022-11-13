package at.ac.tuwien.inso.swtesten.lab.pages;

import at.ac.tuwien.inso.swtesten.util.PageObject;
import org.openqa.selenium.WebDriver;

public class SampleFormConfirmationPage extends PageObject {

	public SampleFormConfirmationPage(WebDriver driver) {
		super(driver);
	}

	public String getUrl(){
		return driver.getCurrentUrl();
	}
}
