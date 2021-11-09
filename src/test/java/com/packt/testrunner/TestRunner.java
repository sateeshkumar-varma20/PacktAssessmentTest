package com.packt.testrunner;

import com.packt.cucumber.CustomAbtractBaseTestNGCucumber;
import com.packt.helperapis.Configuration;
import com.packt.helperapis.StartUp;
import com.packt.utils.ReportGenerator;

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
	
	/*
	 * This Method will be executed before each scenario in feature file.
	 * This method ill set up the reporting based on Feature and Scenario name.
	 */
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
		start.loginToPacktApplication(config.properties.getProperty("URL"),
				config.properties.getProperty("USER_NAME"), 
				config.properties.getProperty("PASSWORD"));
	}
	

	/*
	 * This will be executed after each scenario in feature file.
	 * This will flush all the reporting of the scenario to html file and logout.
	 */
	@After
	public void endSession() throws InterruptedException {
        start.logOut();
        reporter.endTest();
	}

}
