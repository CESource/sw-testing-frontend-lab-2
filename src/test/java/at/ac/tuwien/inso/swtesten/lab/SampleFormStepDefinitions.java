package at.ac.tuwien.inso.swtesten.lab;

import at.ac.tuwien.inso.swtesten.lab.pages.SampleFormConfirmationPage;
import at.ac.tuwien.inso.swtesten.lab.pages.SampleFormRegistrationPage;
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

		When("I enter the first name {string}", (String searchTerm) ->{
			sampleFormRegistrationPage.enterFirstName(searchTerm);
		});

		Then("the confirmation page with header {string} is shown", (String header) -> {
			Assert.assertEquals(header, sampleFormConfirmationPage.header());
		});

		Then("{string} is displayed in input field", (String text) -> {
			Assert.assertEquals(text, sampleFormRegistrationPage.getFirstName());
		});

		After(SeleniumWebDriver::closeDriver);
	}
}
