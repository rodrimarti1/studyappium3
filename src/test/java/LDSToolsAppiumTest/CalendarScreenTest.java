package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.CalendarsScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.WhatsNewScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.ArrayList;


public class CalendarScreenTest extends BaseDriver {

    @Test (groups = {"all3", "all", "smoke", "smoke4", "daily", "daily3", "jft"})
    public void calendarScreenCheck() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        CalendarsScreen myCalendar = new CalendarsScreen(driver);
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList("BISHOP", "Centinela 1st");

        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");


        myMenu.selectMenu(myMenu.calendar);
        Thread.sleep(500);
        myBasePage.waitForElement(myCalendar.calendarTitle);
        Assert.assertTrue(myCalendar.calendarTitle.isDisplayed());

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.waitForElementThenClick(myCalendar.calendarEdit);
        } else {
            myBasePage.waitForElementThenClick(myCalendar.calendarMoreOptions);
            myBasePage.waitForElementThenClick(myCalendar.calendarsToDisplay);
        }
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Calendars to display"));
        Assert.assertTrue(pageSource.contains("All calendars"));
        Assert.assertTrue(myCalendar.calendarSubscriptions.isDisplayed());

        myBasePage.waitForElementThenClick(myCalendar.calendarSubscriptions);
        Thread.sleep(2000);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.waitUnitlTextIsGone("Downloading");
        }
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("All calendars"));
        Assert.assertTrue(myCalendar.calendarsSubscriptionsDone.isDisplayed());
        Assert.assertTrue(myCalendar.calendarsSubscriptionsCancel.isDisplayed());
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            Assert.assertTrue(pageSource.contains("Subscriptions"));
        } else {
            Assert.assertTrue(pageSource.contains("Calendar"));
        }
    }


    @Test (groups = {"all4", "all", "smoke", "smoke4", "daily", "daily1"})
    public void calendarSimple_BISHOP() throws Exception {
        calendarSimpleSub("BISHOP");
    }

    @Test (groups = {"all3", "all"})
    public void calendarSimple_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        calendarSimpleSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test (groups = {"all2", "all"})
    public void calendarSimple_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        calendarSimpleSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test (groups = {"all1", "all"})
    public void calendarSimple_WARD_CLERK() throws Exception {
        calendarSimpleSub("WARD_CLERK");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_WARD_ASSISTANT_CLERK() throws Exception {
        calendarSimpleSub("WARD_ASSISTANT_CLERK");
    }

    @Test (groups = {"all3", "all"})
    public void calendarSimple_WARD_EXECUTIVE_SECRETARY() throws Exception {
        calendarSimpleSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test (groups = {"all2", "all"})
    public void calendarSimple_MEMBER1() throws Exception {
        calendarSimpleSub("MEMBER1");
    }

    @Test (groups = {"all1", "all", "daily", "daily2"})
    public void calendarSimple_ELDERS_QUORUM_PRESIDENT() throws Exception {
        calendarSimpleSub("ELDERS_QUORUM_PRESIDENT");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        calendarSimpleSub("ELDERS_QUORUM_FIRST_COUNSELOR");
    }

    @Test (groups = {"all3", "all"})
    public void calendarSimple_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        calendarSimpleSub("ELDERS_QUORUM_SECOND_COUNSELOR");
    }

    @Test (groups = {"all2", "all"})
    public void calendarSimple_ELDERS_QUORUM_SECRETARY() throws Exception {
        calendarSimpleSub("ELDERS_QUORUM_SECRETARY");
    }

    @Test (groups = {"all1", "all", "daily", "daily3"})
    public void calendarSimple_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        calendarSimpleSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        calendarSimpleSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test (groups = {"all3", "all"})
    public void calendarSimple_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        calendarSimpleSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test (groups = {"all2", "all", "daily", "daily4"})
    public void calendarSimple_YOUNG_WOMEN_PRESIDENT() throws Exception {
        calendarSimpleSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test (groups = {"all1", "all"})
    public void calendarSimple_YOUNG_WOMEN_SECOND_COUNSELOR() throws Exception {
        calendarSimpleSub("YOUNG_WOMEN_SECOND_COUNSELOR");
    }

    @Test (groups = {"all4", "all"})
    public void calendarSimple_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
        calendarSimpleSub("SUNDAY_SCHOOL_FIRST_COUNSELOR");
    }

    @Test (groups = {"all3", "all"})
    public void calendarSimple_WARD_MISSION_LEADER() throws Exception {
        calendarSimpleSub("WARD_MISSION_LEADER");
    }

    public void calendarCheck() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);

        myMenu.selectMenu(myMenu.calendar);
        Thread.sleep(2000);

//        pageSource = myBasePage.getSourceOfPage();
//        System.out.println(pageSource);

        if (getRunningOS().equalsIgnoreCase("ios")) {
//            myBasePage.scrollDownIOS();
//            pageSource = myBasePage.getSourceOfPageIDB();
            pageSource = myBasePage.getSourceOfPage();
            System.out.println(pageSource);
            Assert.assertTrue(pageSource.contains("Calendar"));
        } else {
            pageSource = myBasePage.getSourceOfPage();
            System.out.println(pageSource);
            Assert.assertTrue(myBasePage.checkNoCaseList("Calendar", pageSource, "Contains"));
        }
    }

    @Test (groups = {"all", "all3", "daily", "daily2"})
    public void calenderDisplayType() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);

        myHelper.proxyLogin("mahina_12006");
        myHelper.enterPin("1", "1", "3", "3");
        //Go to Calendar
        myMenu.selectMenu(myMenu.calendar);
        Thread.sleep(2000);
        selectAllCalendar();
        Thread.sleep(2000);
        //Scroll to Stake Presidency Interviews in case it is off the screen
        myBasePage.scrollToTextGeneral("High Council");
        //Check the page source to see Stake Presidency Interviews
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("High Council", pageSource, "contains"));
        //Turn off West Jordan YSA Stake Calendar
        checkOrUncheckCalendarItem("Stake Calendar", "check");
        //Search for Stake Presidency Interviews - Should not be found.
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("High Council", pageSource, "contains"));
        //Turn on West Jordan YSA Stake Calendar
        checkOrUncheckCalendarItem("Stake Calendar", "uncheck");
        //Search for Stake Presidency Interviews - make sure it is displayed
        myBasePage.scrollToTextGeneral("High Council");
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("High Council", pageSource, "contains"));
    }


    @Test (groups = {"all", "all4", "daily", "daily3"})
    public void calenderSubscriptions() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        CalendarsScreen myCalendar = new CalendarsScreen(driver);

        //Login
        myHelper.proxyLogin("sungah");
        myHelper.enterPin("1", "1", "3", "3");
        //Go to Calendar
        myMenu.selectMenu(myMenu.calendar);
        Thread.sleep(2000);
        //Check for a Stake Calendar Item
        myBasePage.scrollToTextGeneral("High Council");
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("High Council", pageSource, "contains"));
        //Edit the Calendar
        editCalendar();
        Thread.sleep(1000);
        //Edit the Subscriptions and uncheck Stake Calendar
        myBasePage.waitForElementThenClick(myCalendar.calendarSubscriptions);
        myBasePage.scrollDownAndroidUIAutomator("0");
        myCalendar.checkCalendarToDisplay("Stake Calendar", "check");
        myBasePage.waitForElementThenClick(myCalendar.calendarsSubscriptionsDone);
        myBasePage.waitUnitlTextIsGone("Syncing");
        myBasePage.waitUnitlTextIsGone("Saving");
        //Go back to the Calendar Main Page
        if (getRunningOS().equals("ios")) {
            myBasePage.waitForElementThenClick(myCalendar.calendarDone);
            Thread.sleep(2000);
        } else {
            myBasePage.waitForElementThenClick(myBasePage.backButton);
        }
        //Scroll up to refresh the calendar
        myBasePage.scrollUp(500);
        //Check the page source for Stake Event
        Thread.sleep(5000);

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            pageSource = myBasePage.getSourceOfPage();
        } else {
            pageSource = scrollAndGetText();
        }
        Assert.assertFalse(myBasePage.checkNoCaseList("High Council", pageSource, "contains"));


        //Clean up
        editCalendar();
        Thread.sleep(1000);
        myBasePage.waitForElementThenClick(myCalendar.calendarSubscriptions);
        myBasePage.scrollDownAndroidUIAutomator("0");
        myCalendar.checkCalendarToDisplay("Stake Calendar", "uncheck");
        myBasePage.waitForElementThenClick(myCalendar.calendarsSubscriptionsDone);


        myBasePage.waitUnitlTextIsGone("Syncing");
        if (getRunningOS().equals("ios")) {
            myBasePage.waitForElementThenClick(myCalendar.calendarDone);
            Thread.sleep(1000);
            myBasePage.scrollUpIOS();
            Thread.sleep(1000);
            myBasePage.scrollUpIOS();
            Thread.sleep(1000);
            myBasePage.scrollUpIOS();
        } else {
            myBasePage.waitForElementThenClick(myBasePage.backButton);
        }

        Thread.sleep(2000);
        //Check the page source to see Stake Presidency Interviews
        myBasePage.scrollToTextGeneral("High Council");
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("High Council", pageSource, "contains"));


    }

    private String scrollAndGetText() throws Exception {
        BasePage myBasePage = new BasePage(driver);
        String pageSource = null;
        int myCounter;

        for (myCounter = 1; myCounter < 5; myCounter++) {
            pageSource = myBasePage.getSourceOfPage();
            myBasePage.scrollDownAndroidUIAutomator("0");
        }
        return pageSource;
    }


    private void editCalendar() throws Exception {
        CalendarsScreen myCalendar = new CalendarsScreen(driver);

        if (getRunningOS().contains("ios")) {
            myCalendar.calendarEdit.click();
        } else {
            myCalendar.calendarMoreOptions.click();
            myCalendar.calendarsToDisplay.click();
        }
    }

    private void selectAllCalendar() throws Exception {
        CalendarsScreen myCalendar = new CalendarsScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        editCalendar();

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            if (myBasePage.checkForElement(myCalendar.calendarsSelectAll)) {
                myCalendar.calendarsSelectAll.click();
            }
        } else {
            List<WebElement> checkBox = driver.get().findElements(By.xpath("//android.widget.CheckBox"));
            for (WebElement boxStatus : checkBox ) {
                if (boxStatus.getAttribute("checked").equals(false)) {
                    boxStatus.click();
                }
            }
        }



        if (getRunningOS().contains("ios")) {
            myCalendar.calendarDone.click();
        } else {
            myBasePage.backButton.click();
        }

        Thread.sleep(2000);
    }





    private void checkOrUncheckCalendarItem(String calendarItem, String checkOrUncheck) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        CalendarsScreen myCalendar = new CalendarsScreen(driver);

        editCalendar();


        myBasePage.scrollDownAndroidUIAutomator("0");
        myCalendar.checkCalendarToDisplay(calendarItem, checkOrUncheck);

        if (getRunningOS().contains("ios")) {
            myCalendar.calendarDone.click();
        } else {
            myBasePage.backButton.click();
        }

        Thread.sleep(2000);
    }

    public void calendarSimpleSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");

        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        calendarCheck();
    }



}
