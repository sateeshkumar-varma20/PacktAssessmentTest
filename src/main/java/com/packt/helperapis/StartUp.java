package com.packt.helperapis;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.packt.objectsrepository.PacktHomePage;
import com.packt.objectsrepository.PacktLoginPage;
import com.packt.utils.ReportGenerator;
/*
 * This class has methods to perform the initial and ending acicities for the application like launch url, login, logout etc.
 */
public class StartUp extends ExtendedSeleniunApi{
	private Configuration config = null;
	private WebDriver driver = null;
	public  WebDriverWait wait = null ;
	private PacktLoginPage loginPage = null;
	private PacktHomePage homePage = null;
	private ReportGenerator report = null;
	
	@FindBy(xpath="//settings-ui")
	private WebElement chromeSetting;
	
	public StartUp(){
		config = Configuration.getConfigurationInstance();
		driver = config.getDriver();
		wait = config.getWait(driver, 100) ;
		loginPage = new PacktLoginPage();
		homePage = new  PacktHomePage();
		report = ReportGenerator.getReportGenerator();
	}
	
	
	public void loginToPacktApplication(String url,String userName, String password) {
		try {

			driver.get("chrome://settings/clearBrowserData");
			driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);	 // This will clear the cache of application to avoid any failure in case of session is not stopped from previous execution.
			report.info("Launch URL: "+url, false);
			driver.navigate().to(url);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
			report.fail("Unable to Open Browser" + e.toString());
		}
		loginPage.inputUserName(userName);
		loginPage.inputPassword(password);
		loginPage.clickSignInButton();
	}
	
	public void logOut() {
		String parrentWindow = driver.getWindowHandle();
		homePage.clickTopMenu(PacktHomePage.ACCOUNT_MENU);
		homePage.clickLogOut();
		closeMainWindowsAndSwitchToNewWindow(parrentWindow);

	}
	public void closeDriver(){
		driver.close();
	}
	public void quitDriver(){
		driver.quit();
	}
}
