package com.packt.stepdefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.packt.helperapis.Configuration;
import com.packt.objectsrepository.PacktHomePage;
import com.packt.utils.Assertions;
import com.packt.utils.ReportGenerator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PacktHomePageSteps extends PacktHomePage{
	private Configuration config = Configuration.getConfigurationInstance();
	private ReportGenerator report = ReportGenerator.getReportGenerator();
	private WebDriver driver = config.getDriver();
	public  WebDriverWait wait = config.getWait(driver, 100) ;

	public PacktHomePageSteps() {
		config = Configuration.getConfigurationInstance();
		ReportGenerator report = ReportGenerator.getReportGenerator();
		WebDriver driver = config.getDriver();
		WebDriverWait wait = config.getWait(driver, 100) ;
	}

	@Given("I am on home page of packt application")
	public void iAmOnHomePageOfPacktApplication() {
	    // Write code here that turns the phrase above into concrete actions
	   String title = driver.getTitle();
	   Assertions.assertEquals(title, "Packt Subscription | Advance your knowledge in tech", 
			   "Expected Title of page is 'Packt Subscription | Advance your knowledge in tech' but recieved :"+title );
	}

	@When("I verify the elements on homepage")
	public void iVerifyTheElementsOnHomepage() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("verification should be successfull")
	public void verificationShouldBeSuccessfull() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}




}

