package at.ac.tuwien.inso.swtesten.lab.pages;

import at.ac.tuwien.inso.swtesten.util.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SampleFormRegistrationPage extends PageObject {

	@FindBy(name = "firstname")
	private WebElement firstNameInputField;

	@FindBy(name = "lastname")
	private WebElement lastNameInputField;

	@FindBy(id = "dayOfBirthPicker")
	private WebElement dayOfBirthPicker;

	@FindBy(name = "gender")
	private WebElement genderRadioButton;

	@FindBy(name = "uni")
	private WebElement universityDropDown;

	@FindBy(name = "student")
	private WebElement studentCheckBox;

	@FindBy(id = "btn-submit")
	private WebElement submitButton;

	public SampleFormRegistrationPage(WebDriver driver) {
		super(driver);
	}

	public String getFirstName(){
		return firstNameInputField.getAttribute("value");
	}

	public void visit() {
		driver.get("http://localhost:8080");
	}

	public void enterFirstName(String text){
		firstNameInputField.clear();
		firstNameInputField.sendKeys(text);
	}

	public void enterLastName(String text){
		lastNameInputField.clear();
		lastNameInputField.sendKeys(text);
	}
}
