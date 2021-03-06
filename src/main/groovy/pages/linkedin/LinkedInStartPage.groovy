package pages.linkedin

import base.AnyPage
import corebase.ISeleniumHelper
import org.testng.Assert

public class LinkedInStartPage extends AnyPage{
	public final static String PAGE_URL = "http://www.linkedin.com"
	private final static String SEACRH_FIRST_NAME = "//*[@id='pagekey-uno-reg-guest-home']// input[@name='first']"
	private final static String SEACRH_LAST_NAME = "//*[@id='pagekey-uno-reg-guest-home']// input[@name='last']"
	private final static String SEACRH_BUTTON = "//*[@id='pagekey-uno-reg-guest-home']// input[@name='search']"
	private final static String SEACRHED_PERSON_FIRST_NAME = "//*[@id='name']/span/span[1]"
	private final static String SEACRHED_PERSON_LAST_NAME = "//*[@id='name']/span/span[2]"
	private final static String SEACRHED_PERSONS_LIST= "//*[@id='result-set']/li"
	private final static String HOME_IMG = "pagekey-uno-reg-guest-home"
	 
	public LinkedInStartPage(final ISeleniumHelper driver){
		super(driver)
	}

	public void load(){
		driver.openUrl(PAGE_URL)
		Assert.assertTrue(driver.isTagAvailable(HOME_IMG),"User agreement is not on page " + HOME_IMG)
	}
	
	public void typeSearchFirstName(data){
		driver.type(SEACRH_FIRST_NAME, data)
	}
	
	public void typeSearchLastName(data){
		driver.type(SEACRH_LAST_NAME, data)
	}
	
	public LinkedInSearchResultPage clickSeacrh(){
		driver.click(SEACRH_BUTTON)
        driver.refresh()

        return new LinkedInSearchResultPage(driver)
	}
}
