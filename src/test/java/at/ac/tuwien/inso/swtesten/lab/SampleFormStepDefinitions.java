package at.ac.tuwien.inso.swtesten.lab;

import at.ac.tuwien.inso.swtesten.lab.pages.SampleFormConfirmationPage;
import at.ac.tuwien.inso.swtesten.lab.pages.SampleFormRegistrationPage;
import at.ac.tuwien.inso.swtesten.lab.pages.TissSamplePage;
import at.ac.tuwien.inso.swtesten.lab.pages.TuwelSamplePage;
import at.ac.tuwien.inso.swtesten.util.SeleniumWebDriver;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SampleFormStepDefinitions implements En {

	private WebDriver driver;

	private SampleFormRegistrationPage sampleFormRegistrationPage;
	private SampleFormConfirmationPage sampleFormConfirmationPage;
	private TuwelSamplePage tuwelSamplePage;
	private TissSamplePage tissSamplePage;

	public SampleFormStepDefinitions() {
		Before(() -> {
			driver = SeleniumWebDriver.getDriver();
		});

		AfterStep(scenario -> {
			if (scenario.isFailed()) {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "failed_" + scenario.getName());
			}
		});

		Given("I am on registration page", () -> {
			sampleFormRegistrationPage = PageFactory.initElements(driver, SampleFormRegistrationPage.class
			);
			sampleFormRegistrationPage.visit();
		});

		When("I enter the first name {string}", (String firstName) -> {
			sampleFormRegistrationPage.enterFirstName(firstName);
		});

		When("I enter the last name {string}", (String lastName) -> {
			sampleFormRegistrationPage.enterLastName(lastName);
		});

		When("I enter birthday {string}", (String birthday) -> {
			sampleFormRegistrationPage.enterDayOfBirth(birthday);
		});

		When("I select {string} as gender", (String gender) -> {
			sampleFormRegistrationPage.selectGender(gender);
		});

		When("I select {string} as university", (String university) -> {
			sampleFormRegistrationPage.selectUniversity(university);
		});

		When("I select student", () -> {
			sampleFormRegistrationPage.selectStudent();
		});

		When("I click sign up", () ->{
			sampleFormConfirmationPage = sampleFormRegistrationPage.signUp();
		});

		When("I type birthday {string}", (String date) -> {
			sampleFormRegistrationPage.typeDateOfBirth(date);
		});

		When("I click TISS", () -> {
			tissSamplePage = sampleFormRegistrationPage.clickTISS();
		});

		When("I click TUWEL", () -> {
			tuwelSamplePage = sampleFormRegistrationPage.clickTUWEL();
		});

		Then("I am on TISS", () -> {
			Assert.assertEquals("https://tiss.tuwien.ac.at/", tissSamplePage.getUrl());
		});

		Then("I am on TUWEL", () -> {
			Assert.assertEquals("https://tuwel.tuwien.ac.at/theme/university_boost/login/index.php", tuwelSamplePage.getUrl());
		});

		Then("{string} is displayed in first name input field", (String firstName) -> {
			Assert.assertEquals(firstName, sampleFormRegistrationPage.getFirstName());
		});

		Then("{string} is displayed in last name input field", (String lastName) -> {
			Assert.assertEquals(lastName, sampleFormRegistrationPage.getLastName());
		});

		Then("{string} is displayed in birthday input field", (String birthday) -> {
			Assert.assertEquals(birthday, sampleFormRegistrationPage.getBirthday());
		});

		Then("{string} is selected as gender", (String gender) -> {
			Assert.assertTrue(sampleFormRegistrationPage.genderIsSelected(gender));
		});

		Then("{string} is selected as university", (String university) -> {
			Assert.assertTrue(sampleFormRegistrationPage.universityIsSelected(university));
		});

		Then("student is selected", ()-> {
			Assert.assertTrue(sampleFormRegistrationPage.studentIsSelected());
		});

		Then("the confirmation page is shown", () -> {
			Assert.assertEquals("http://localhost:8080/echo.jsp", sampleFormConfirmationPage.getUrl());
		});

		Then("throws error", () -> {
			Assert.assertTrue(sampleFormRegistrationPage.showsAlert());
		});

		After(SeleniumWebDriver::closeDriver);
	}
}
