package LDSToolsAppiumTest.steps;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppium.Screen.TemplesScreen;
import LDSToolsAppiumTest.HelperMethods;


import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class PrayerRoll extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ReportsScreen myReports = new ReportsScreen(driver);
    TemplesScreen myTemple = new TemplesScreen(driver);
    String pageSource;

    @Given("a member is on their Temple Page")
    public void aMemberIsOnTheirTemplePage() throws Exception {
        LOGGER.info("a member is on their Temple Page");
        myHelper.proxyLogin("mbthomas74");
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.temples);
        Thread.sleep(1000);
        if(myBasePage.checkForElement(myTemple.yesRemindMe)) {
            myBasePage.waitForElementThenClick(myTemple.yesRemindMe);
        }

        myBasePage.waitForText("Los Angeles");
        Thread.sleep(2000);
    }

    @When("the prayer roll button is pressed")
    public void thePrayerRollButtonIsPressed() throws Exception {
        LOGGER.info("the prayer roll button is pressed");
        //Need a sleep here to wait for the popup to go away.
        Thread.sleep(2000);
        if (!myBasePage.checkForElement(myTemple.prayerRollButton)) {
            myBasePage.scrollToTextGeneral("Prayer Roll");
        }

        Thread.sleep(1000);
//        System.out.println(myBasePage.getSourceOfPage());
        myBasePage.waitForElementThenClick(myTemple.prayerRollButton);
//        myTemple.prayerRollButton.click();
        Thread.sleep(500);
    }

    @Then("I should see the prayer roll page")
    public void iShouldSeeThePrayerRollPage() throws Exception {
        LOGGER.info("I should see the prayer roll page");
        myBasePage.waitForText("relationship or interest");
    }

    @And("the member enters in a name")
    public void theMemberEntersInAName() throws Exception {
        LOGGER.info("the member enters in a name");
        myTemple.prayerRoll1stName.sendKeys("Test One");
        myTemple.prayerRollSubmitNames.click();
    }

    @Then("the name should be submitted")
    public void theNameShouldBeSubmitted() throws Exception {
        LOGGER.info("the name should be submitted");
        pageSource = myBasePage.getSourceOfPage();
        Thread.sleep(500);
        pageSource = pageSource + myBasePage.getSourceOfPage();
        Thread.sleep(500);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            System.out.println("Skipping iOS for now. There is a bug. ");
        } else {
            Assert.assertTrue(pageSource.contains("submitted"));
        }

    }

    @Given("a member is on the prayer roll page")
    public void aMemberIsOnThePrayerRollPage() throws Exception {
        LOGGER.info("a member is on the prayer roll page");
        myHelper.proxyLogin("mbthomas74");
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.temples);
        if (myBasePage.checkForElement(myTemple.yesRemindMe)) {
            myBasePage.waitForElementThenClick(myTemple.yesRemindMe);
        }
        myBasePage.waitForText("Los Angeles");
        if (!myBasePage.checkForElement(myTemple.prayerRollButton)) {
            myBasePage.newScrollDownSlow();
        }
        myTemple.prayerRollButton.click();
    }

    @When("the member enters in five names")
    public void theMemberEntersInFiveNames() throws Exception {
        LOGGER.info("the member enters in five names");
        myTemple.prayerRoll1stName.sendKeys("Test One");
        myTemple.prayerRoll2ndName.sendKeys("Test Two");
        myTemple.prayerRoll3rdName.sendKeys("Test Three");
        myTemple.prayerRoll4thName.sendKeys("Test Four");
        myTemple.prayerRoll5thName.sendKeys("Test Five");
        myTemple.prayerRollSubmitNames.click();
    }


    @When("the member enters in five names then cancels")
    public void theMemberEntersInFiveNamesThenCancels() throws Exception  {
        LOGGER.info("the member enters in five names then cancels");
        myTemple.prayerRoll1stName.sendKeys("Test One");
        myTemple.prayerRoll2ndName.sendKeys("Test Two");
        myTemple.prayerRoll3rdName.sendKeys("Test Three");
        myTemple.prayerRoll4thName.sendKeys("Test Four");
        myTemple.prayerRoll5thName.sendKeys("Test Five");
//        System.out.println(myBasePage.getSourceOfPage());
        myTemple.prayerRollCancelButton.click();
    }

    @Then("the names should not be submitted")
    public void theNamesShouldNotBeSubmitted() throws Exception {
        LOGGER.info("the names should not be submitted");
        pageSource = myBasePage.getSourceOfPage();
        Thread.sleep(500);
        pageSource = pageSource + myBasePage.getSourceOfPage();
        Thread.sleep(500);
        Assert.assertFalse(pageSource.contains("submitted"));
    }
}
