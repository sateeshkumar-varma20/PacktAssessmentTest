package com.packt.testrunner;

import org.testng.annotations.AfterClass;

import com.packt.helperapis.Configuration;
import com.packt.helperapis.StartUp;
import com.packt.utils.ReportGenerator;
import com.packt.cucumber.CustomAbtractBaseTestNGCucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.SnippetType;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@CucumberOptions(snippets = SnippetType.CAMELCASE,

				plugin = { "json:target/JSON/Smoke_Test_Report.json" }, 
				glue = {"com.packt" }, 
				monochrome = true,
				dryRun = false, 
				tags = { "@tag1" }, 
				features = {
				"src/test/resources/Feature_Files/Packt_Assessment_Feature.feature",

})
public class TestRunner extends CustomAbtractBaseTestNGCucumber {
	private ReportGenerator reporter = null;
	private Configuration config =  Configuration.getConfigurationInstance();
	private StartUp start = null;
	
	@Before
	public void setUpReporting(Scenario scenario) throws InterruptedException, Exception {
		
		reporter = ReportGenerator.getReportGenerator();
		int featureSize = scenario.getId().split("/").length;
		String scenarioID = scenario.getId().split("/")[featureSize-1];
		String featureName = scenarioID.substring(0, scenarioID.indexOf("."));
		System.out.println("Scenario Id: "+scenario.getId());
		System.out.println("Feature:" + featureName);

		reporter.initializeReport(featureName);

		String scenarioName = scenario.getName();
		reporter.startTest("<u><b>" + scenarioName + "</b></u>");
		start= new StartUp();
		start.loginToPacktApplication(config.properties.getProperty("USER_NAME"), config.properties.getProperty("PASSWORD"));
	}
	

	
	@After
	public void endSession() throws InterruptedException {
		config.driver.close();
		
	}

//	@AfterClass
//	public void closeSetup() throws Exception {
//		reporter.closeReport();
//	}
}
