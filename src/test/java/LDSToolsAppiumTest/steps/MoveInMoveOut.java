package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class MoveInMoveOut extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ReportsScreen myReports = new ReportsScreen(driver);
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> memberList = new ArrayList<String>();
    String pageSource;


    @Given("a {string} logs in and is on Move Records In and Out page for {string}")
    public void aLogsInAndIsOnMoveRecordsInAndOutPageFor(String memberCalling, String moveNotes) throws Exception {
        LOGGER.info("Given a " + memberCalling + " logs in and is on Move Records In and Out page for " + moveNotes);
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
//        myMenu.selectMenu(myMenu.reports);
        myMenu.selectMenu(myMenu.manageRecord);
        myBasePage.waitForElementThenClick(myReports.moveRecordsInAndOut);
    }


    @When("move in is selected")
    public void moveInIsSelected() throws Exception {
        LOGGER.info("When move in is selected");
        myBasePage.waitForElementThenClick(myReports.moveRecordsInTab);
        myBasePage.waitForElementThenClick(myReports.moveRecordsInButton);
    }


    @Then("the move in elements should be correct")
    public void theMoveInElementsShouldBeCorrect() throws Exception {
        LOGGER.info("Then the move in elements should be correct");
        //Move Records In - MRN
        Thread.sleep(500);
//        System.out.println(myBasePage.getSourceOfPage());
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsMRNField));
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsCancelButton));
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsMoreSearchOptions));
        //Move Records In - More Search Options
//        System.out.println(myBasePage.getSourceOfPage());
        myBasePage.waitForElementThenClick(myReports.moveRecordsMoreSearchOptions);
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsName));
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsBirthDate));
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsGender));
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsCountry));
        //Enter in a MRN
        myBasePage.waitForElementThenClick(myReports.moveRecordsMoreSearchOptions);
//        Thread.sleep(1000);
        myBasePage.waitForElementThenClick(myReports.moveRecordsMRNField);
        myReports.moveRecordsMRNField.sendKeys("00004179234");
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsNext));
        myBasePage.waitForElementThenClick(myReports.moveRecordsNext);

        //iOS has a select household member's page for one member - this may go away or Android might use this.
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            Thread.sleep(3000);
            Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsNext));
            Thread.sleep(1000);
            myBasePage.waitForElementThenClick(myReports.moveRecordsNext);
        }
        //Moving Records In
        myBasePage.waitForText("Wydner, Bruce Jr.");
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Wydner, Bruce Jr."));
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsAddressSelector));
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsLocateOnMap));
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsCountry2));
//        System.out.println(myBasePage.getSourceOfPage());
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsAddress1));
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsAddress2));
        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsCity));
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsStateOrProvince));
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsPostalCode));
        //Select
        myBasePage.waitForElementThenClick(myReports.moveRecordsAddressSelector);
        myBasePage.waitForElementThenClick(myReports.moveRecordsAddressUnchanging);
        myBasePage.waitForElementThenClick(myReports.moveRecordsNext);
        //Review
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Wydner, Bruce Jr."));
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            Assert.assertTrue(pageSource.contains("ADDRESS UNCHANGING"));
        } else {
            Assert.assertTrue(pageSource.contains("000-0417-9234"));
            Assert.assertTrue(pageSource.contains("Male - 43"));
            Assert.assertTrue(pageSource.contains("Head of Household"));
            Assert.assertTrue(pageSource.contains("Address will remain the same after the move"));
        }



        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsMoveRecordsIn));
        Assert.assertTrue(myBasePage.checkForElement(myReports.moveRecordsDiscardMove));
        myBasePage.waitForElementThenClick(myReports.moveRecordsDiscardMove);
        Thread.sleep(500);
        myBasePage.waitForElementThenClick(myReports.moveRecordsDiscardButton);
    }
}
