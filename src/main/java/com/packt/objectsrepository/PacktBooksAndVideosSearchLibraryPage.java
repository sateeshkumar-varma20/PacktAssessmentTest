package com.packt.objectsrepository;

import com.packt.helperapis.ExtendedSeleniunApi;

public class PacktBooksAndVideosSearchLibraryPage extends ExtendedSeleniunApi{
	
	private final String PRODUCT_BOOK_FILTER_CHECKBOX_XPATH = "//li[@id='product_type']//div//label[@for='book']/input";
	private final String CATEGORY_DATA_FILTER_CHECKBOX_XPATH = "//li[@id='category']//div//label[@for='data']/input";
	private String searchResultXpath = "//div[@class='ais-hits--item search-hit']//h2/em[contains(text(),'search_text')]";
	
	
	public String getPRODUCT_BOOK_FILTER_CHECKBOX_XPATH() {
		return PRODUCT_BOOK_FILTER_CHECKBOX_XPATH;
	}
	public String getCATEGORY_DATA_FILTER_CHECKBOX_XPATH() {
		return CATEGORY_DATA_FILTER_CHECKBOX_XPATH;
	}
	
	
	public String getSearchResultXpath(String searchText) {
		searchResultXpath = searchResultXpath.replaceAll("search_text", searchText);
		return searchResultXpath;
	}
	
	
	
	
	
	

}
