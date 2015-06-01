package pages.google

import corebase.When

public class WhenGoogle extends When{

	public WhenGoogle(driver){
		super(driver)
	}

	public void typeValueAndClickSearch(String [] searchStrings) {
		String searchString = ""
		searchStrings.each{
			searchString += "$it "
		}
		searchString = searchString.replaceAll(/ $/, "")
		log.info (searchString)
		GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver)
		googleSearchPage.typeSearchField(searchString)
        googleSearchPage.clickSearch()
	}
}
