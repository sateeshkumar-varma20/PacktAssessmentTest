package com.packt.helperapis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.packt.objectsrepository.PacktLoginPage;

public class StartUp{
	private Configuration config = null;
	private WebDriver driver = null;
	public  WebDriverWait wait = null ;
	PacktLoginPage loginPage = null;
	
	public StartUp() {
		config = Configuration.getConfigurationInstance();
		driver = config.getDriver();
		wait = config.getWait(driver, 100) ;
		loginPage = new PacktLoginPage();
	}
	
	
	public void loginToPacktApplication(String userName, String password) {
		loginPage.inputUserName(userName);
		loginPage.inputPassword(password);
		loginPage.clickSignInButton();
	}
	
	public void closeDriver(){
		driver.close();
	}
	public void quitDriver(){
		driver.quit();
	}
}
