package at.ac.tuwien.inso.swtesten.lab.pages;

import at.ac.tuwien.inso.swtesten.util.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SampleFormConfirmationPage extends PageObject {

	@FindBy(xpath = "//h4[1]")
	private WebElement header;

	public SampleFormConfirmationPage(WebDriver driver) {
		super(driver);
	}

	public String header(){
		return header.getText();
	}
}
