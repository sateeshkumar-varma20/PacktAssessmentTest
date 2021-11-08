package com.packt.helperapis;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.packt.utils.ReportGenerator;


public class ExtendedSeleniunApi{
	private Configuration config = Configuration.getConfigurationInstance();
	private ReportGenerator report = ReportGenerator.getReportGenerator();
	private WebDriver driver = config.getDriver();
	public  WebDriverWait wait = config.getWait(driver, 100) ;

	/**
	 * This method is used to perform the click functionality on the given
	 * element
	 * 
	 * @param element
	 */
	public void clickOnElement(WebElement element, String elementName, boolean... takesceenshot) {
		try {

				element.click();
				if(takesceenshot.length<1) {
					takesceenshot = new boolean[1];
					takesceenshot[0] = false;
				}
				
				if(takesceenshot[0])
					report.info("Click on Element: " +elementName , true);	
				else
					report.info("Click on Element: " +elementName , true);

		}catch (StaleElementReferenceException e) {
		} 		
		catch (Exception e) {
			report.fail(e.getMessage());
		}
	}
	
	
	
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

	public void inputText(WebElement element,String inputText, String elementName, boolean... takesceenshot) {
		try {

			element.sendKeys(inputText);
			
			if(takesceenshot.length<1) {
				takesceenshot = new boolean[1];
				takesceenshot[0] = false;
			}
			
			if(takesceenshot[0])
				report.info("Input '" +inputText+"' in "+elementName , takesceenshot[0]);	
			else
				report.info("Input '" +inputText+"' in "+elementName , takesceenshot[0]);

	}catch (StaleElementReferenceException e) {
	} 		
	catch (Exception e) {
		report.fail(e.getMessage());
	}
	}
	
	public String getTextOfElement(WebElement element) {
		try {

			return element.getText();

	}catch (StaleElementReferenceException e) {
		return null;
	} 		
	catch (Exception e) {
		report.fail(e.getMessage());
		return null;
	}
	}
}
