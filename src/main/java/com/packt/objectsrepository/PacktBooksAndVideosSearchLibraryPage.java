package com.packt.objectsrepository;

import java.util.HashMap;
import java.util.Map;

import com.packt.helperapis.ExtendedSeleniunApi;

public class PacktBooksAndVideosSearchLibraryPage extends ExtendedSeleniunApi{
	
	private final String PRODUCT_BOOK_FILTER_CHECKBOX_XPATH = "//li[@id='product_type']//div//label[@for='book']/input";
	private final String CATEGORY_DATA_FILTER_CHECKBOX_XPATH = "//li[@id='category']//div//label[@for='data']/input";
	private String searchResultXpath = "//div[@class='ais-hits--item search-hit']//h2/em[contains(text(),'search_text')]";
	
	private Map<String, String> productCheckXpaths = new HashMap<String, String>()
	{{
		put("Book","//li[@id='product_type']//div//label[@for='book']/input");
		put("Video","//li[@id='product_type']//div//label[@for='video']/input");
		put("Path","//li[@id='product_type']//div//label[@for='learning-path']/input");
	}};
	
	private Map<String, String> categoryCheckXpaths = new HashMap<String, String>()
	{{
		put("Data","//li[@id='category']//div//label[@for='data']/input");
		put("Web development","//li[@id='category']//div//label[@for='web-development']/input");
		put("Programming","//li[@id='category']//div//label[@for='programming']/input");
		put("Mobile","//li[@id='category']//div//label[@for='mobile']/input");
		put("Business & other","//li[@id='category']//div//label[@for='business-and-other']/input");
		put("Cloud & networking ","//li[@id='category']//div//label[@for='cloud-and-networking']/input");
		
	}};
	
	
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

	public String  getProductCheckXpaths(String productName) {	
		return productCheckXpaths.get(productName);
	}
	public String getCategoryCheckXpaths(String categoryName) {
		return categoryCheckXpaths.get(categoryName);
	}
	
	
	
	
	
	

}
