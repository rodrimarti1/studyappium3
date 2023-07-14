package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppium.Screen.TemplesScreen;
import LDSToolsAppiumTest.HelperMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProgressRecord extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ReportsScreen myReports = new ReportsScreen(driver);
    DirectoryScreen myDirectory = new DirectoryScreen(driver);
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> memberList = new ArrayList<String>();
    String pageSource;


    @Given("a {string} logs in and is on the Progress Record Page")
    public void aLeaderLogsInAndIsOnTheProgressRecordPage(String memberCalling) throws Exception {
        LOGGER.info("a " + memberCalling + " logs in and is on the Progress Record Page");
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Auburn Hills");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
//        System.out.println(myBasePage.getSourceOfPage());
        if (!myBasePage.checkForElement(myReports.progressRecordReport)) {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }
        myBasePage.waitForElementThenClick(myReports.progressRecordReport);
    }

    @When("the New Members tab is selected")
    public void theNewMembersTabIsSelected() throws Exception {
        LOGGER.info("the New Members tab is selected");
        myBasePage.waitForElement(myReports.prNewMembers);
        myReports.prNewMembers.click();
    }

    @Given("a {string} logs in selects a {string} and is on the Progress Record Page")
    public void aLeaderLogsInSelectsAUnitAndIsOnTheProgressRecordPage(String memberCalling, String unit)  throws Exception {
        LOGGER.info("a " + memberCalling + " logs in selects a " + unit + " and is on the Progress Record Page");
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Auburn Hills");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.reports);
        Thread.sleep(500);
        if (!myBasePage.checkForElement(myReports.progressRecordReport)) {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }
        myBasePage.waitForElementThenClick(myReports.progressRecordReport);
        chooseUnit(unit);
    }

    @When("a {string} is selected under the New Members tab")
    public void aMemberRecordIsSelectedUnderTheNewMembersTab(String memberRecord) throws Exception {
        LOGGER.info("a " + memberRecord + " is selected under the New Members tab");
        myBasePage.waitForElement(myReports.prNewMembers);
        Thread.sleep(500);
        myReports.prNewMembers.click();
        searchForMemberAndClick(memberRecord);
    }

    @When("a {string} is selected under the New Members tab for {string}")
    public void aIsSelectedUnderTheNewMembersTabFor(String memberRecord, String singleUnit) throws Exception {
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myReports.prNewMembers.click();
        }
        chooseUnit(singleUnit);
        Thread.sleep(500);
        searchForMemberAndClick(memberRecord);
    }

    @When("a {string} is selected under the People Being Taught tab")
    public void aMemberRecordIsSelectedUnderThePeopleBeingTaughtTab(String memberRecord) throws Exception {
        LOGGER.info("a " + memberRecord + " is selected under the People being taught");
        myBasePage.waitForElement(myReports.prNewMembers);
        myBasePage.waitForElementThenClick(myReports.prPeopleBeingTaught);
        Thread.sleep(500);
        searchForMemberAndClick(memberRecord);
    }



    //Todo: add api call to get the info to check
    @Then("the {string} will be displayed")
    public void theMemberRecordWillBeDisplayed(String memberRecord) throws Exception {
        LOGGER.info("the members record will be displayed");
        pageSource = getProgressRecordDetails();

        Assert.assertTrue(myBasePage.checkNoCaseList(memberRecord, pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Member for", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sacrament Attendance", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("View All", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Calling", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Assignment", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Temple Ordinances", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Principles Taught", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Other Commitments", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Self-Reliance Class", pageSource, "Contains"));

    }

    //Todo: add api call for this
    @And("the members record {string} be edited")
    public void theMembersRecordCanBeEdited(String editable) throws Exception {
        LOGGER.info("the members record " + editable + " be edited");
//        pageSource = getProgressRecordDetails();

        if (editable.equalsIgnoreCase("true")) {
            Assert.assertTrue(myBasePage.checkNoCaseList("Add Friend", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Principles Taught", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("View All", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("OPT OUT", pageSource, "Contains"));
        } else {
            Assert.assertFalse(myBasePage.checkNoCaseList("Add Friend", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Update Principles Taught", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("OPT OUT", pageSource, "Contains"));
        }
    }

    @Then("the {string} for People Being Taught will be displayed")
    public void theMemberRecordForPeopleBeingTaughtWillBeDisplayed(String memberRecord) throws Exception {
        LOGGER.info("the " + memberRecord + " for People Being Taught will be displayed");
        pageSource = getProgressRecordDetails();

        Assert.assertTrue(myBasePage.checkNoCaseList(memberRecord, pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sacrament Attendance", pageSource, "Contains"));
        //View All doesn't show up unless there is something to view
//        Assert.assertTrue(myBasePage.checkNoCaseList("View All", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Calling", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Assignment", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Temple Ordinances", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Principles Taught", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Other Commitments", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Self-Reliance Class", pageSource, "Contains"));
    }

    @And("the members record for People Being Taught {string} be edited")
    public void theMembersRecordForPeopleBeingTaughtCanBeEdited(String editable) throws Exception {
        LOGGER.info("the members record for People Being Taught " + editable + " be edited");
        if (editable.equalsIgnoreCase("true")) {
            Assert.assertTrue(myBasePage.checkNoCaseList("Add Friend", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Principles Taught", pageSource, "Contains"));
//            Assert.assertTrue(myBasePage.checkNoCaseList("View All", pageSource, "Contains"));
//            Assert.assertTrue(myBasePage.checkNoCaseList("OPT OUT", pageSource, "Contains"));
        } else {
            Assert.assertFalse(myBasePage.checkNoCaseList("Add Friend", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Update Principles Taught", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("OPT OUT", pageSource, "Contains"));
        }

    }



    @Then("the members quick card information should be displayed")
    public void theMembersQuickCardInformationShouldBeDisplayed() throws Exception {
        LOGGER.info("the members quick card information should be displayed");
        int sacramentMissed;
        String sacNumber;
        memberList = apiTest.getCovenantPathNames("extractor", "111074", "new member");

        for (String oneUser: memberList) {
            System.out.println(oneUser);
            myReports.prSearchField.sendKeys(oneUser);
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            sacramentMissed = apiTest.getCovenantPathUserSacramentMissed("extractor", "111074", oneUser);
            sacNumber = Integer.toString(sacramentMissed);

            //Todo: member for x years x months
            Assert.assertTrue(myBasePage.checkNoCaseList(oneUser, pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList(sacNumber + " sacrament meetings missed", pageSource, "Contains"));
            //Todo: Friends in the church

            //Cancel Search
            myReports.prClearSearch.click();
            Thread.sleep(2000);
        }
     }






    public void searchForMemberAndClick(String memberRecord) throws Exception {
//        System.out.println(myBasePage.getSourceOfPage());
        Thread.sleep(1000);
        myReports.prSearchField.sendKeys(memberRecord);
        Thread.sleep(2000);
        selectProgressRecordMember(memberRecord);

    }



    public void selectProgressRecordMember(String memberRecord) throws Exception {
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            driver.get().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + memberRecord +"']/.." +
                    "/following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[@name='View Details']")).click();
        } else {
            driver.get().findElement(By.xpath("//android.widget.TextView[@text='"+ memberRecord +"']")).click();
        }
        Thread.sleep(500);
    }

    public String getProgressRecordDetails() throws Exception {
        String pageSource;
        Thread.sleep(500);
        pageSource = myBasePage.getSourceOfPage();
        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myBasePage.scrollUpAndroidUIAutomator("0");
            Thread.sleep(500);
            pageSource = pageSource + myBasePage.getSourceOfPage();
            myBasePage.scrollDownAndroidUIAutomator("0");
            Thread.sleep(500);
            pageSource = pageSource + myBasePage.getSourceOfPage();
            myBasePage.scrollDownAndroidUIAutomator("0");
            Thread.sleep(500);
            pageSource = pageSource + myBasePage.getSourceOfPage();
            myBasePage.scrollDownAndroidUIAutomator("0");
            Thread.sleep(500);
            pageSource = pageSource + myBasePage.getSourceOfPage();
            myBasePage.scrollDownAndroidUIAutomator("0");
            Thread.sleep(500);
            pageSource = pageSource + myBasePage.getSourceOfPage();
            myBasePage.scrollDownAndroidUIAutomator("0");
            Thread.sleep(500);
            pageSource = pageSource + myBasePage.getSourceOfPage();
        }

        return pageSource;
    }

    public void chooseUnit(String unit) throws Exception {
//        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
//            myBasePage.scrollDownIOS();
//        }
//        System.out.println(myBasePage.getSourceOfPage());
        //When they change to Compose this should work
//        myDirectory.directoryDropdown.click();

        myReports.prUnitSelected.click();
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            Thread.sleep(2000);
            driver.get().findElement(By.xpath("//*[contains(@name,'" + unit + "')]")).click();
        } else {
            Thread.sleep(2000);
            driver.get().findElement(By.xpath("//*[contains(@text,'" + unit + "')]")).click();

            //When they change to Compose this should work
//            myBasePage.newScrollUpUnitList();
//            Thread.sleep(2000);
//            driver.get().findElement(By.xpath("//*[contains(@text,'" + unit + "')]/../..")).click();
        }
        Thread.sleep(6000);
    }


    @And("is on the Progress Record page")
    public void isOnTheProgressRecordPage() throws Exception {
        myMenu.selectMenu(myMenu.reports);
//        System.out.println(myBasePage.getSourceOfPage());
        if (!myBasePage.checkForElement(myReports.progressRecordReport)) {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }
        myBasePage.waitForElementThenClick(myReports.progressRecordReport);
    }
}
