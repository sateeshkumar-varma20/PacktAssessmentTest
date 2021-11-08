package com.packt.objectsrepository;

public class PacktHomePage {

	final String MAIN_LOGO_ID = "main-logo";
	final String TOP_SEARCH_BAR_XPATH = "//input[@class='search-bar__input']";
	final String BROWSE_MENU_XPATH = "//li[@class='menu__item']//span[contains(text(),'Browse')]" ;
	final String MYLIBRARY_MENU_XPATH = "//li[@class='menu__item']//span[contains(text(),'Library')]" ;
	final String ACCOUNT_MENU_XPATH = "//li[@class='menu__item']//span[contains(text(),'Account')]" ;
	final String READ_NOW_BUTTON_XPATH = "//button[text()='Read now']";
	final String CHAPTERS_LIST_XPATH = "//div[starts-with(@class,'chapterList shadow')]";
	
	
	public String getMAIN_LOGO_ID() {
		return MAIN_LOGO_ID;
	}
	public String getTOP_SEARCH_BAR_XPATH() {
		return TOP_SEARCH_BAR_XPATH;
	}
	public String getBROWSE_MENU_XPATH() {
		return BROWSE_MENU_XPATH;
	}
	public String getMYLIBRARY_MENU_XPATH() {
		return MYLIBRARY_MENU_XPATH;
	}
	public String getACCOUNT_MENU_XPATH() {
		return ACCOUNT_MENU_XPATH;
	}
	public String getREAD_NOW_BUTTON_XPATH() {
		return READ_NOW_BUTTON_XPATH;
	}
	public String getCHAPTERS_LIST_XPATH() {
		return CHAPTERS_LIST_XPATH;
	}
	
	
}