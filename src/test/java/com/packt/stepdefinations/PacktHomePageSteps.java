package com.packt.stepdefinations;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.packt.helperapis.Configuration;
import com.packt.objectsrepository.PacktHomePage;
import com.packt.utils.Assertions;
import com.packt.utils.ReportGenerator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PacktHomePageSteps extends PacktHomePage{
	private Configuration config = null;
	private ReportGenerator report = null;
	private WebDriver driver = null;
	public  WebDriverWait wait = null;

	public PacktHomePageSteps() {
		config = Configuration.getConfigurationInstance();
		report = ReportGenerator.getReportGenerator();
		driver = config.getDriver();
		wait = config.getWait(driver, 100) ;
	}

	@Given("I am on home page of packt application")
	public void iAmOnHomePageOfPacktApplication() throws InterruptedException {
		
	   wait.until(ExpectedConditions.titleContains("Packt Subscription | Advance your knowledge in tech"));
	   
	   String title = driver.getTitle();
	   Assertions.assertEquals(title, "Packt Subscription | Advance your knowledge in tech", 
			   "Expected Title of page is 'Packt Subscription | Advance your knowledge in tech' but recieved :"+title );
	
	   report.pass("USer in on homepage.!", true);
	}

	@When("I verify the elements on homepage")
	public void iVerifyTheElementsOnHomepage() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("Yet to implement Step def");
	}

	@Then("verification should be successfull")
	public void verificationShouldBeSuccessfull() {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Yet to implement Step def");
	}




}

