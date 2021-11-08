package com.packt.objectsrepository;

import com.packt.helperapis.ExtendedSeleniunApi;

public class PacktLoginPage extends ExtendedSeleniunApi {
	
	final String USERNAME_INPUT_ID = "login-input-email";
	final String PASSWORD_INPUT_ID = "login-input-password";
	final String SIGNIN_BUTTON_XPATH = "//button//span[contains(text(),'Sign In')]";
	
	
	public void inputUserName(String userName) {
		inputText(getWebElementByID(USERNAME_INPUT_ID), userName, "User name");
	}
	
	public void inputPassword(String password) {
		inputText(getWebElementByID(PASSWORD_INPUT_ID), password, "Password");
	}
	
	public void clickSignInButton() {
		clickOnElement(getWebElementByXpath(SIGNIN_BUTTON_XPATH), "Sign In Button");
	}

}
