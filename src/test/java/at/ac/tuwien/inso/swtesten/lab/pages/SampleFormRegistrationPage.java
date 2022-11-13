package at.ac.tuwien.inso.swtesten.lab.pages;

import static at.ac.tuwien.inso.swtesten.util.SeleniumWebDriver.waitUntil;

import at.ac.tuwien.inso.swtesten.util.PageObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SampleFormRegistrationPage extends PageObject {

	@FindBy(name = "firstname")
	private WebElement firstNameInputField;

	@FindBy(name = "lastname")
	private WebElement lastNameInputField;

	@FindBy(id = "dayOfBirthPicker")
	private WebElement dayOfBirthPicker;

	@FindBy(xpath = "//label[contains(text(),'Unspecified')]//input[@type='radio']")
	private WebElement unspecifiedGenderRadioButton;

	@FindBy(xpath = "//label[contains(text(),'Female')]//input[@type='radio']")
	private WebElement femaleGenderRadioButton;

	@FindBy(xpath = "//label[contains(text(),'Male')]//input[@type='radio']")
	private WebElement maleGenderRadioButton;

	@FindBy(name = "uni")
	private WebElement universityDropDown;

	@FindBy(name = "student")
	private WebElement studentCheckBox;

	@FindBy(id = "btn-submit")
	private WebElement submitButton;

	@FindBy(xpath = "//ul[@class='dropdown menu']")
	private WebElement menuDropDown;

	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}

	public SampleFormRegistrationPage(WebDriver driver) {
		super(driver);
	}

	public String getFirstName(){
		return firstNameInputField.getAttribute("value");
	}

	public String getLastName(){
		return lastNameInputField.getAttribute("value");
	}

	public String getBirthday(){
		return dayOfBirthPicker.getAttribute("value");
	}

	public boolean genderIsSelected(String gender){
		return switch (gender) {
			case "Female" -> femaleGenderRadioButton.isSelected();
			case "Male" -> maleGenderRadioButton.isSelected();
			case "Unspecified" -> unspecifiedGenderRadioButton.isSelected();
			default -> false;
		};
	}

	public boolean studentIsSelected(){
		return studentCheckBox.isSelected();
	}

	public boolean universityIsSelected(String university){
		String universityValueName = getStringConvertedToCamelCase(university);
		WebElement option = universityDropDown.findElement(By.xpath("//option[@value='" + universityValueName +"']"));
		return option.isSelected();
	}

	public boolean showsAlert(){
		WebElement element = driver.findElement(By.xpath("//div[@class='alert callout']"));
		return element.isDisplayed();
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

	public void enterDayOfBirth(String birthday) throws ParseException {
		Calendar birthdayDate = getParsedDate(birthday);
		dayOfBirthPicker.click();
		WebElement element = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		waitUntil(ExpectedConditions.elementToBeClickable(element));

		WebElement selectorMonth = driver.findElement(
				By.xpath("//select[@class='ui-datepicker-month']/option[@value='" + (birthdayDate.get(Calendar.MONTH))+ "']"));
		selectorMonth.click();

		WebElement selectorYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']/option[@value='" + birthdayDate.get(Calendar.YEAR) + "']"));
		selectorYear.click();

		WebElement dayPicker = driver.findElement(By.xpath("//a[contains(text(),'" + birthdayDate.get(Calendar.DAY_OF_MONTH) + "')]"));
		dayPicker.click();
	}

	public void typeDateOfBirth(String birthday) {
		dayOfBirthPicker.clear();
		dayOfBirthPicker.sendKeys(birthday);
	}

	public void selectGender(String gender){
		WebElement radioOption = driver.findElement(By.xpath("//label[contains(text(),'" + gender  + "')]//input[@type='radio']"));
		waitUntil(ExpectedConditions.elementToBeClickable(radioOption));
		radioOption.click();
	}

	public void selectUniversity(String university){
		String universityValueName = getStringConvertedToCamelCase(university);
		universityDropDown.click();
		WebElement dropDownOption = driver.findElement(By.xpath("//option[@value='" + universityValueName +"']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", dropDownOption);
		dropDownOption.click();
	}

	public void selectStudent(){
		studentCheckBox.click();
	}

	public SampleFormConfirmationPage signUp(){
		submitButton.click();

		return initPage(SampleFormConfirmationPage.class);
	}

	public TissSamplePage clickTISS(){
		menuDropDown.click();
		WebElement dropDownOption = driver.findElement(By.xpath("//a[contains(text(),'TISS')]"));
		waitUntil(ExpectedConditions.elementToBeClickable(dropDownOption));
		dropDownOption.click();

		return initPage(TissSamplePage.class);
	}

	public TuwelSamplePage clickTUWEL(){
		menuDropDown.click();
		WebElement dropDownOption = driver.findElement(By.xpath("//a[contains(text(),'TUWEL')]"));
		waitUntil(ExpectedConditions.elementToBeClickable(dropDownOption));
		dropDownOption.click();

		return initPage(TuwelSamplePage.class);
	}

	private String getStringConvertedToCamelCase(String string){
		String[] words = string.split("[„“ -]");
		words[0] = words[0].toLowerCase();

		return String.join("", words);
	}

	private Calendar getParsedDate(String date) throws ParseException{
		Date birthdayDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthdayDate);

		return cal;
	}
}
