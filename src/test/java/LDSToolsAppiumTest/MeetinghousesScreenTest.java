package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MeetinghousesScreen;
import LDSToolsAppium.Screen.MenuScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class MeetinghousesScreenTest extends BaseDriver {


    //TODO: iOS has problems with this test
    //TODO: Need to update
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"smoke3", "smoke", "all3", "all", "jft"})
    public void meetinghousesSimpleTest() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        MeetinghousesScreen myMeetinghouses = new MeetinghousesScreen(driver);
        BasePage myBasePage = new BasePage(driver);



        //Login and enter in PIN
//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("kroqbandit");
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.meetinghouses);

//        Thread.sleep(2000);

        if (myBasePage.checkForElement(myMeetinghouses.meetinghousesAllow)) {
            myMeetinghouses.meetinghousesAllow.click();
            Thread.sleep(5000);
        }

        if (!getRunningOS().equals("ios")) {
            driver.get().switchTo().alert();

            myMeetinghouses.meetinghousesAllowAndroidPermissions.click();
        }


        Thread.sleep(15000);

        myMeetinghouses.meetinghousesCurrentLocation.click();

        Thread.sleep(5000);

        myMeetinghouses.meetinghouseSearch("12691 South 3600 West Riverton UT");


        Thread.sleep(15000);

//        System.out.println(myBasePage.getSourceOfPage());
        myMeetinghouses.selectMeetinghouse();
        Thread.sleep(6000);

        myMeetinghouses.openMeetinghouseDetails("Meetinghouse, 12691 South 3600 West");
//        myMeetinghouses.openMeetinghouseDetails("12691 3600 West Riverton, Utah 84065 United States");



        Thread.sleep(2000);

        pageSource = myMeetinghouses.getMeetinghouseDetails();

        Assert.assertTrue(myBasePage.checkNoCaseList("1 801-253-7085", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("12691 South 3600 West", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("RIVERTON, Utah", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Wards", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Riverton 24th Ward (Tongan)", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sacrament meeting:", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("9:00 am", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Castlewood Ward", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("10:30 am", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Riverton 19th Ward", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("10:30 am", pageSource, "Contains"));

        myBasePage.checkForElement(myMeetinghouses.directionIcon);


        //Select each Ward
        //Check Riverton 24th Ward (Tongan)
        myBasePage.clickByTextContains("Riverton 24th Ward (Tongan)");
        Thread.sleep(1000);
        pageSource = myMeetinghouses.getMeetinghouseDetails();

        Assert.assertTrue(myBasePage.checkNoCaseList("12691 South 3600 West", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("RIVERTON, Utah", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Riverton", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("24", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Ward", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("(Tongan)", pageSource, "Contains"));


        Assert.assertTrue(myBasePage.checkNoCaseList("Sacrament meeting:", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("10:30 am", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("First meeting:", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Siosifa Tafisi", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("1 801-915-2065", pageSource, "Contains"));
        myBasePage.checkForElement(myMeetinghouses.directionIcon);

        myBasePage.backButton.click();


        //Check Castlewood Ward
        myBasePage.waitForText("Castlewood Ward");
        myBasePage.clickByTextContains("Castlewood Ward");
        Thread.sleep(1000);
        pageSource = myMeetinghouses.getMeetinghouseDetails();

        Assert.assertTrue(myBasePage.checkNoCaseList("12691 South 3600 West", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("RIVERTON, Utah", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Castlewood Ward", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sacrament meeting:", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("10:30 am", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("First meeting:", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mark R. Ludwig", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("1 801-706-3903", pageSource, "Contains"));
        myBasePage.checkForElement(myMeetinghouses.directionIcon);

        myBasePage.backButton.click();

        //Check Riverton 19th Ward
        myBasePage.waitForText("Riverton 19th Ward");
        myBasePage.clickByTextContains("Riverton 19th Ward");
        Thread.sleep(1000);
        pageSource = myMeetinghouses.getMeetinghouseDetails();

        Assert.assertTrue(myBasePage.checkNoCaseList("12691 South 3600 West", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("RIVERTON, Utah", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Riverton 19th Ward", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sacrament meeting:", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("9:00 am", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("First meeting:", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Chad R. Carlson", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("1 801-652-5753", pageSource, "Contains"));
        myBasePage.checkForElement(myMeetinghouses.directionIcon);

        myBasePage.backButton.click();


    }


    @Test(groups = {"NotWorking"})
    public void meetinghousesSearch() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        MeetinghousesScreen myMeetinghouses = new MeetinghousesScreen(driver);
        BasePage myBasePage = new BasePage(driver);



        //Login and enter in PIN
        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.meetinghouses);

        myMeetinghouses.meetinghousesAllow.click();
        Thread.sleep(5000);
        if (!getRunningOS().equals("ios")) {
            driver.get().switchTo().alert();
            myMeetinghouses.meetinghousesAllowAndroidPermissions.click();
        }


        Thread.sleep(15000);

        myMeetinghouses.meetinghousesCurrentLocation.click();

        Thread.sleep(15000);

        myMeetinghouses.meetinghousesCurrentLocation.click();

        Thread.sleep(5000);

        myMeetinghouses.meetinghouseSearch("Paris Lilas");

        myMeetinghouses.meetinghousesSearchResuts.click();

        myBasePage.waitForText("Paris Lilas");
//        Thread.sleep(10000);
//        System.out.println(myBasePage.getSourceOfPage());

//        myBasePage.clickByTextContains("Paris Lilas Ward");
        myMeetinghouses.selectSearchResults("Paris Lilas");
        Thread.sleep(2000);

        if (getRunningOS().equals("ios")) {
            myMeetinghouses.selectMeetinghouse();
            Thread.sleep(3000);

            myMeetinghouses.openMeetinghouseDetails("64 rue de Romainville");

            Thread.sleep(2000);
            myBasePage.clickByTextContains("Paris Lilas Ward");
            Thread.sleep(1000);
        }

        pageSource = myMeetinghouses.getMeetinghouseDetails();

        Assert.assertTrue(myBasePage.checkNoCaseList("64 rue de Romainville", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("PARIS", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Sacrament meeting:", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("9:30 am", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("First meeting:", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("33 1-42-45-28-57", pageSource, "Contains"));

//        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Gilbert A. Cruz", pageSource, "Contains"));
        myBasePage.checkForElement(myMeetinghouses.directionIcon);

        myBasePage.backButton.click();





    }



}
