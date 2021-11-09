package com.packt.helperapis;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.packt.utils.ReportGenerator;
/*
 * This class provides extended api to our framework by providing methods to deal with elements that handles expects and reporting as well.
 */

public class ExtendedSeleniunApi {
	private Configuration config = Configuration.getConfigurationInstance();
	private ReportGenerator report = ReportGenerator.getReportGenerator();
	private WebDriver driver = config.getDriver();
	public WebDriverWait wait = config.getWait(driver, 100);

	/**
	 * This method is used to perform the click functionality on the given element
	 * 
	 * @param element, element name and optional parameter to take screenshot(by
	 *                 default it is false.
	 */
	public void clickOnElement(WebElement element, String elementName, boolean... takesceenshot) {
		try {

			element.click();
			if (takesceenshot.length < 1) {
				takesceenshot = new boolean[1];
				takesceenshot[0] = false;
			}

			if (takesceenshot[0])
				report.info("Click on Element: " + elementName, true);
			else
				report.info("Click on Element: " + elementName, false);

		} catch (StaleElementReferenceException e) {
		} catch (Exception e) {
			report.fail(e.getMessage());
		}
	}

	/*
	 * Get element by ID
	 * 
	 * @return type: WebElement
	 */

	public WebElement getWebElementByID(String elementID) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(elementID)));
			return driver.findElement(By.id(elementID));
		} catch (Exception e) {
			report.fail(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * Get element by Xpath
	 * 
	 * @return type: WebElement
	 */
	public WebElement getWebElementByXpath(String elementID) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementID)));
			return driver.findElement(By.xpath(elementID));
		} catch (Exception e) {
			report.fail(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * This method is used to perform the click functionality on the given element
	 * 
	 * @param element, input Text, Element name, and optional parameter to take
	 *                 screenshot(by default it is false.
	 */
	public void inputText(WebElement element, String inputText, String elementName, boolean... takesceenshot) {
		try {

			element.sendKeys(inputText);

			if (takesceenshot.length < 1) {
				takesceenshot = new boolean[1];
				takesceenshot[0] = false;
			}

			if (takesceenshot[0])
				report.info("Input '" + inputText + "' in " + elementName, takesceenshot[0]);
			else
				report.info("Input '" + inputText + "' in " + elementName, takesceenshot[0]);

		} catch (StaleElementReferenceException e) {
		} catch (Exception e) {
			report.fail(e.getMessage());
		}
	}

	/*
	 * Get text of element
	 * 
	 * @return type: String
	 */
	public String getTextOfElement(WebElement element) {
		try {

			return element.getText();

		} catch (StaleElementReferenceException e) {
			return null;
		} catch (Exception e) {
			report.fail(e.getMessage());
			return null;
		}
	}

	public Point getLocationOfElement(WebElement element) {
		try {

			return element.getLocation();

		} catch (StaleElementReferenceException e) {
			return null;
		} catch (Exception e) {
			report.fail(e.getMessage());
			return null;
		}
	}
		
	public String getBackgroundColourOfElement(WebElement element) {
		try {
			return element.getCssValue("background-color");
		} catch (StaleElementReferenceException e) {
			return null;
		} catch (Exception e) {
			report.fail(e.getMessage());
			return null;
		}
	}
	
	public String getColourOfElement(WebElement element) {
		try {
			return element.getCssValue("color");
		} catch (StaleElementReferenceException e) {
			return null;
		} catch (Exception e) {
			report.fail(e.getMessage());
			return null;
		}
	}
	
}
