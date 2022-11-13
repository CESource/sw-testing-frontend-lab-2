package at.ac.tuwien.inso.swtesten.lab.pages;

import at.ac.tuwien.inso.swtesten.util.PageObject;
import org.openqa.selenium.WebDriver;

public class TissSamplePage extends PageObject {

	public TissSamplePage(WebDriver driver) {
		super(driver);
	}

	public String getUrl(){
		return driver.getCurrentUrl();
	}
}
