package com.talios;

import base.AnyCCTest;
import com.talios.cucumberng.CucumberFactoryBuilder;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import groovy.lang.MetaClass;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Factory;
import pages.linkedin.LinkedInSearchResultPage;
import pages.linkedin.LinkedInStartPage;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class TestFactoryLinkedIn extends AnyCCTest {

    private LinkedInStartPage linkedInStartPage;
    private LinkedInSearchResultPage linkedInSearchResultPage;
    private final static Logger log = Logger.getLogger("TF   ");

    @Factory
    public Object[] create() {
        return new CucumberFactoryBuilder()
                .addOption("--format", "html:target/cucumber")
                .create(new File("src"));
    }

    @Given("^The user starts (.*)$")
    public void driverIsStarted(String browser) {
        setup(browser, "./");
    }

    @And("^The user visits linkedIn$")
    public void linkedInStartPageIsLoaded() {
        linkedInStartPage = new LinkedInStartPage(driver);
        linkedInStartPage.load();
        reportLog("loading " + LinkedInStartPage.PAGE_URL);
    }

    @When("^The user searches for (.*) (.*)$")
    public void searchingFor(String firstName, String lastName) {
        reportLog("searching for " + firstName + " " + lastName);
        linkedInStartPage.typeSearchFirstName(firstName);
        linkedInStartPage.typeSearchLastName(lastName);
        linkedInStartPage.clickSeacrh();
        linkedInSearchResultPage = new LinkedInSearchResultPage(driver);
    }

    @Then("^The result text should include (.*)$")
    public void resultShouldInclude(String data) {
        reportLog("result should include " + data.trim());
        if(!StringUtils.isBlank(data.trim())){
            linkedInSearchResultPage.getTextOfFoundPersons().contains(data.trim());
        }
    }
    @Then("^The result page hits should at least be (\\d+)$")
    public void resultPageHitsShouldAtLeastBe(int pageHits) {
        reportLog("#######");
        reportLog("");
        reportLog("result page hits should at least be " + pageHits);
        reportLog("");
        reportLog("#######");
        reportLog("");
        tangAssert.assertTrue(linkedInSearchResultPage.getNumberOfFoundPersons() >= pageHits, "Expected pageHits " + pageHits + " got " + linkedInSearchResultPage.getNumberOfFoundPersons());
    }

    @Then("^The user closes the browser$")
    public void quitDriver() {
        linkedInStartPage.driver.quit();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Override
    public Object invokeMethod(String s, Object o) {
        return null;
    }

    @Override
    public Object getProperty(String s) {
        return null;
    }

    @Override
    public void setProperty(String s, Object o) {

    }

    @Override
    public MetaClass getMetaClass() {
        return null;
    }

    @Override
    public void setMetaClass(MetaClass metaClass) {

    }
}
