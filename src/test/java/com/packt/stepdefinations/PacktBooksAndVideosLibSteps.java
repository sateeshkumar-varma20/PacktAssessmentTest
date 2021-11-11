package com.packt.stepdefinations;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.packt.helperapis.Configuration;
import com.packt.objectsrepository.PacktBooksAndVideosSearchLibraryPage;
import com.packt.utils.Assertions;
import com.packt.utils.ReportGenerator;

import cucumber.api.java.en.Then;

public class PacktBooksAndVideosLibSteps extends PacktBooksAndVideosSearchLibraryPage{
	private Configuration config = null;
	private ReportGenerator report = null;
	private WebDriver driver = null;
	public WebDriverWait wait = null;
	

	public PacktBooksAndVideosLibSteps() {
		config = Configuration.getConfigurationInstance();
		report = ReportGenerator.getReportGenerator();
		driver = config.getDriver();
		wait = config.getWait(driver, 100);
	}
	
	@Then("I will be navigated to search result page of {string} Product and {string} category for {string} page")
	public void iWillBeNavigatedToSearchResultPageOfProductAndCategoryForPage(String productType, String category, String searchText) {

		String currentWindow = driver.getWindowHandle();
		
		
	    Assertions.assertTrue(checkIfElementIsChecked(getWebElementByXpath(getProductCheckXpaths(productType))), "Product type "+productType+" is not checked");
	    Assertions.assertTrue(checkIfElementIsChecked(getWebElementByXpath(getCategoryCheckXpaths(category))), "Category "+category+" is not checked");
	    
	    List<WebElement> searchResultElements = getWebElementsByXpath(getSearchResultXpath(searchText));
	    
	    if (searchResultElements.size()>1)
	    	report.pass("User has navigated to search result for "+searchText+" Product "+productType+" Category "+category, true);
	    else
	    	report.fail("User is not navigated to search result for "+searchText+" Product "+productType+" Category "+category);
	    
	    closeMainWindowsAndSwitchToNewWindow(currentWindow);
	}
}
