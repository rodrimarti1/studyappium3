package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.API.QuarterlyReport.Entry;
import LDSToolsAppium.API.QuarterlyReport.QuarterlyReport;
import LDSToolsAppium.API.QuarterlyReport.Section;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.List;

public class QuarterlyReportSteps extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ReportsScreen myReports = new ReportsScreen(driver);
    MemberToolsAPI apiTest = new MemberToolsAPI();
    String userName;
    String pageSource;
    QuarterlyReport myQR = new QuarterlyReport();

    @Given("a {string} logs in")
    public void aLogsIn(String memberCalling) throws Exception {
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Maplewood 2nd");
        userName = callingRights[1];
        myHelper.proxyLogin(userName);
        myHelper.enterPin("1", "1", "3", "3");
    }

    @And("is on the Quarterly Report page")
    public void isOnTheQuarterlyReportPage() throws Exception {
        myMenu.selectMenu(myMenu.reports);
        myBasePage.waitForElementThenClick(myReports.quarterlyReport);
    }


    @When("the Quarterly Report info is received for {string}")
    public void theQuarterlyReportInfoIsReceivedFor(String unit) throws Exception {
        getQRdata(unit);
    }

    @Then("the Quarterly Report info will match")
    public void theQuarterlyReportInfoWillMatch() throws Exception {
        for (Section mySection: myQR.getSections()) {
            System.out.println( mySection.getName());
            myBasePage.clickByText(mySection.getName());
            pageSource = myBasePage.getSourceOfPage();
            if (myBasePage.getOS().equalsIgnoreCase("android")) {
                pageSource = pageSource + myBasePage.getSourceOfPage();
            }
            for (Entry myEntry : mySection.getEntries()) {
                if (myEntry.getPotential().equals(null)) {
                    String myActual = String.valueOf(myEntry.getActual());
                    Assert.assertTrue(pageSource.contains(myActual));
                } else {
                    String myActual = String.valueOf(myEntry.getActual());
                    String myPotential = String.valueOf(myEntry.getPotential());
                    String actPot = myActual + " / " + myPotential + " Potential";
                    Assert.assertTrue(pageSource.contains(actPot));
                }

                System.out.println(myEntry.getName());
                System.out.println("Actual: "+ myEntry.getActual());
                System.out.println("Potential: " + myEntry.getPotential());
            }
            System.out.println("******************************************");
        }
    }








    public void getQRdata(String unit) throws Exception {
        //Find the previous quarter
        //Get current quarter
        LocalDate myDate = LocalDate.now();
        int quarter = myDate.get(IsoFields.QUARTER_OF_YEAR);
        int year = myDate.getYear();

        //Change to the previous quarter
        if (quarter == 1) {
            year = year - 1;
            quarter = 4;
        } else {
            quarter = quarter - 1;
        }
        String yearString = String.valueOf(year);

        System.out.println("Year: " + yearString);
        System.out.println("Quarter: " + quarter);

        myQR = apiTest.getQuarterlyReport(userName, unit, yearString, quarter);

//        return myQR;

    }



}
