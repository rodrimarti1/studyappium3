package LDSToolsAppiumTest.steps;

import io.cucumber.java.en.Given;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class RecordOrdinances extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ReportsScreen myReports = new ReportsScreen(driver);
    DirectoryScreen myDirectory = new DirectoryScreen(driver);
    MemberToolsAPI apiTest = new MemberToolsAPI();
    String pageSource;
    String proxyUnit = "21628";
    String proxyLogin = "mbthomas74";


    @Given("a {string} logs in and is on the Record Ordination page")
    public void aLeaderLogsInAndIsOnTheRecordOrdinationPage(String memberCalling) throws Exception {
        LOGGER.info("a " + memberCalling + " logs in and is on the Record Ordination page");
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.manageRecord);
        myReports.ordinancesReport.click();
    }


    @When("a Aaronic Priesthood Ordination is submitted for {string} with {string} and the {string} by {string}")
    public void aAaronicPriesthoodOrdinationIsSubmittedForMemberRecordWithPriesthoodOfficeAndTheDateByOfficiator(String memberRecord, String priesthoodOffice, String ordDate, String officiator) throws Exception {
        LOGGER.info("a Aaronic Priesthood Ordination is submitted for " + memberRecord + " with " + priesthoodOffice + " and the " + ordDate + " by " + officiator);
//Switching to compose might be something like this. 
//        ((JavascriptExecutor) driver.get()).executeScript("mobile: getComposSource");

//        driver.get().setSetting("driver", "compose");
        System.out.println(myBasePage.getSourceOfPage());
        myReports.ordinancesAdd.click();

        if ((priesthoodOffice.equals("Priest")) || (priesthoodOffice.equals("Teacher")) || (priesthoodOffice.equals("Deacon"))) {
            //Search for Member
            myReports.ordinancesAaronicPriesthood.click();
            searchAndClickMember(memberRecord);
            selectPriesthoodOffice(priesthoodOffice);
            //TODO: Ordination Date
            myReports.ordinancesOfficiator.click();
            myReports.ordinancesMemberOfWardOrBranch.click();
            searchAndClickMember(officiator);
            myReports.ordinancesRecord.click();

        } else {
            //Melchizedek
            myReports.ordinancesMelchizedekPriesthood.click();
            searchAndClickMember(memberRecord);
            selectPriesthoodOffice(priesthoodOffice);
            //TODO: Ordination Date
            myReports.ordinancesMemberBishopInterviewSwitch.click();
            myReports.ordinancesSubmit.click();
        }

        myBasePage.waitForText("Success");


    }

    @Then("the Ordination should be updated with {string} , {string} , {string} and {string}")
    public void theOrdinationShouldBeUpdatedWithMemberRecordPriesthoodOfficeDateAndOfficiator(String memberRecord, String priesthoodOffice, String ordDate, String officiator) throws Exception {
        LOGGER.info("the Ordination should be updated with " + memberRecord + ", " + priesthoodOffice + ", " + ordDate + " and " + officiator);
        List<String> memberList = new ArrayList<String>();
        memberList = apiTest.getPersonalInfoFromName( memberRecord, proxyUnit, proxyLogin);
        System.out.println(memberList);
        Assert.assertTrue(memberList.contains(memberRecord));
        Assert.assertTrue(memberList.contains(priesthoodOffice));
        //TODO: Ordination Date
        Assert.assertTrue(memberList.contains(officiator));

        ordinanceCleanUp(memberRecord, proxyUnit, proxyLogin);
    }

    @Then("the Ordination should be updated")
    public void theOrdinationShouldBeUpdated() throws Exception {
        LOGGER.info("the Ordination should be updated");
        //check the info, need the member record and priesthood office. Date maybe?

    }

    public void ordinanceCleanUp(String memberName, String proxyUnit, String proxyLogin) throws Exception {
        apiTest.ordinanceDelete(memberName, proxyUnit, proxyLogin);
    }


    public void searchAndClickMember(String memberRecord) throws Exception {
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myReports.ordinancesSearch.sendKeys(memberRecord);
            driver.get().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + memberRecord + "']")).click();
        } else {
            //Android code goes here
        }

    }

    public void selectPriesthoodOffice(String priesthoodOffice) throws Exception {
        myReports.ordinancesPriesthoodOffice.click();
        switch(priesthoodOffice) {
            case "Deacon":
                myReports.ordinancesDeacon.click();
                break;
            case "Teacher":
                myReports.ordinancesTeacher.click();
                break;
            case "Priest":
                myReports.ordinancesPriest.click();
                break;
            case "Elder":
                myReports.ordinancesElder.click();
                break;
            case "High Priest":
                myReports.ordinancesHighPriest.click();
                break;
            default:
                System.out.println("Office Not Found! ");
        }
    }



}
