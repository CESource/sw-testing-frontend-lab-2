package at.ac.tuwien.inso.swtesten.lab.pages;

import at.ac.tuwien.inso.swtesten.util.PageObject;
import org.openqa.selenium.WebDriver;

public class TuwelSamplePage extends PageObject
{

	public TuwelSamplePage(WebDriver driver) {
		super(driver);
	}

	public String getUrl(){
		return driver.getCurrentUrl();
	}
}
