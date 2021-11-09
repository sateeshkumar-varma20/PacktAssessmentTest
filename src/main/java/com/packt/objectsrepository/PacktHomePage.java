package com.packt.objectsrepository;

import com.packt.helperapis.ExtendedSeleniunApi;
/*
 * This the page object class for HomePage of the application. 
 * This class has all the elements of the homepage and their action methods.
 */

public class PacktHomePage extends ExtendedSeleniunApi {
	public static  final String ACCOUNT_MENU = "Account";
	public static  final String LIBRARY_MENU = "Library";
	public static final String BROWSE_MENU = "Browse";
	
	private final String MAIN_LOGO_ID = "main-logo";
	private final String TOP_SEARCH_BAR_XPATH = "//input[@class='search-bar__input']";
//	private final String BROWSE_MENU_XPATH = "//li[@class='menu__item']//span[contains(text(),'Browse')]" ;
//	private final String MYLIBRARY_MENU_XPATH = "//li[@class='menu__item']//span[contains(text(),'Library')]" ;
//	private final String ACCOUNT_MENU_XPATH = "//li[@class='menu__item']//span[contains(text(),'Account')]" ;
	private final String READ_NOW_BUTTON_XPATH = "//button[text()='Read now']";
	private final String CHAPTERS_LIST_XPATH = "//div[starts-with(@class,'chapterList shadow')]";
	
	private final String LOGOUT_LIST_BUTTON_XPATH = "//li[text()='Logout']";
	
	private String browseMenuOptions = " //div//span[text()='menu_name']";
	private String topMenuOptions = "//li[@class='menu__item']//span[contains(text(),'top_menu_name')]";
	
	
	public String getMAIN_LOGO_ID() {
		return MAIN_LOGO_ID;
	}
	public String getTOP_SEARCH_BAR_XPATH() {
		return TOP_SEARCH_BAR_XPATH;
	}
//	public String getBROWSE_MENU_XPATH() {
//		return BROWSE_MENU_XPATH;
//	}
//	public String getMYLIBRARY_MENU_XPATH() {
//		return MYLIBRARY_MENU_XPATH;
//	}
//	public String getACCOUNT_MENU_XPATH() {
//		return ACCOUNT_MENU_XPATH;
//	}
	
	
	public String getREAD_NOW_BUTTON_XPATH() {
		return READ_NOW_BUTTON_XPATH;
	}
	public String getCHAPTERS_LIST_XPATH() {
		return CHAPTERS_LIST_XPATH;
	}
	public String getLOGOUT_LIST_BUTTON_XPATH() {
		return LOGOUT_LIST_BUTTON_XPATH;
	}
	
	
//	public void clickAccountMenu() {
//		clickOnElement(getWebElementByXpath(ACCOUNT_MENU_XPATH), "Account Menu",true);
//	}
//	
//	public void clickBrowseMenu() {
//		clickOnElement(getWebElementByXpath(BROWSE_MENU_XPATH), "Browse Menu",true);
//	}
//	
//	public void clickMyLibraryMenu() {
//		clickOnElement(getWebElementByXpath(MYLIBRARY_MENU_XPATH), "My Library Menu",true);
//	}
	
	public void clickLogOut() {
		clickOnElement(getWebElementByXpath(LOGOUT_LIST_BUTTON_XPATH), "Logout");
	}
	public String getBrowseMenuOptionsXpath(String menuName) {
		return browseMenuOptions.replaceAll("menu_name", menuName);
	}
	
	public void clickOnBrowseSubMenu(String browseSubMenuName) {
		clickOnElement(getWebElementByXpath(getBrowseMenuOptionsXpath(browseSubMenuName)), browseSubMenuName+" Submenu of Browse");
	}

	public String getTopMenuOptionsXpath(String topMenuName) {
		return topMenuOptions.replaceAll("top_menu_name", topMenuName);
	}
	
	public void clickTopMenu(String topMenuName) {
		clickOnElement(getWebElementByXpath(getTopMenuOptionsXpath(topMenuName)), topMenuName+" from Top Menu");
	}
	
}
