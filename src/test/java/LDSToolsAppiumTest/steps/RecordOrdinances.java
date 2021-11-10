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

import io.appium.java_client.MobileElement;
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


    @Given("a {string} logs in and is on the Record Ordination page")
    public void aLeaderLogsInAndIsOnTheRecordOrdinationPage(String memberCalling) throws Exception {
        LOGGER.info("a " + memberCalling + " logs in and is on the Record Ordination page");
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
        myReports.ordinancesReport.click();
    }


    @When("a Aaronic Priesthood Ordination is submitted for {string} with {string} and the {string} by {string}")
    public void aAaronicPriesthoodOrdinationIsSubmittedForMemberRecordWithPriesthoodOfficeAndTheDateByOfficiator(String memberRecord, String priesthoodOffice, String ordDate, String officiator) throws Exception {
        LOGGER.info("a Aaronic Priesthood Ordination is submitted for " + memberRecord + " with " + priesthoodOffice + " and the " + ordDate + " by " + officiator);
//Switching to compose might be something like this. 
//        ((JavascriptExecutor) driver.get()).executeScript("mobile: getComposSource");

        System.out.println(myBasePage.getSourceOfPage());
        myReports.ordinancesAdd.click();

        if (priesthoodOffice.equals("Aaronic")) {
            //Search for Member
            myReports.ordinancesAaronicPriesthood.click();
            searchAndClickMember(memberRecord);
            selectPriesthoodOffice(priesthoodOffice);
            //TODO: Ordination Date
            myReports.ordinancesOfficiator.click();
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


    }

    @Then("the Ordination should be updated")
    public void theOrdinationShouldBeUpdated() throws Exception {
        LOGGER.info("the Ordination should be updated");
        //check the info, need the member record and priesthood office. Date maybe?
    }


    public void searchAndClickMember(String memberRecord) throws Exception {
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myReports.ordinancesSearch.setValue(memberRecord);
            driver.get().findElement(By.xpath("//XCUIElementTypeStaticText[@name=" + memberRecord + "]")).click();
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
