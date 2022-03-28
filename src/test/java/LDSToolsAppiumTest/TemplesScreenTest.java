package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class TemplesScreenTest extends BaseDriver {

    @Test (groups = {"all2", "all", "smoke", "smoke2", "daily", "daily3"})
    public void templeSimple() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);

        //Login
        myHelper.proxyLogin("mykalikat");
        myHelper.enterPin("1", "1", "3", "3");
        //Go to Temple
        myMenu.selectMenu(myMenu.temples);
        myBasePage.waitForElementThenClick(myTemple.yesRemindMe);
        myBasePage.waitForText("Los Angeles");
        pageSource = myBasePage.getSourceOfPage();
        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myBasePage.scrollDownAndroidUIAutomator("1");
            pageSource = pageSource + myBasePage.getSourceOfPage();
        }
        //This is for debug
        Assert.assertTrue(myBasePage.checkNoCaseList("Los Angeles California Temple", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("310-474-5569", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("LANGE-OFF@ChurchofJesusChrist.org", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("10777 Santa Monica Blvd", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Los Angeles CA", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("90025-4718", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("United States", pageSource, "Contains"));
    }


    @Test (groups= {"all", "all1", "daily", "daily4"})
    public void templeRecommendReminder25Days() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);

        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");
        //Bug making this wrong
        myTemple.enableTempleRecommendReminder("25", mySettings.active, mySettings.temple4Weeks);
        //Check the temple reminder
        Thread.sleep(6000);
//        Assert.assertTrue(myBasePage.checkForElement(myTemple.remindMeLater));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.contactBishopric));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.gotItThanks));
        myBasePage.waitForElementThenClick(myTemple.contactBishopric);
        //Verify Bishopric
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Bishopric First Counselor", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
    }

    @Test (groups= { "all", "all2"})
    public void templeRecommendReminder5Days() throws Exception {
        String pageSource;

        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);


//        myHelper.loginUAT("ngibpc1", "password1");
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");


        myTemple.enableTempleRecommendReminder("5", mySettings.active, mySettings.temple6Weeks);

        //Check the temple reminder
        Thread.sleep(6000);
        Assert.assertFalse(myBasePage.checkForElement(myTemple.remindMeLater));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.contactBishopric));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.gotItThanks));

        myTemple.contactBishopric.click();


        //Verify Bishopric
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Bishopric First Counselor", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
    }

    @Test (groups= { "all", "all3"})
    public void templeRecommendReminderRemindLater() throws Exception {
        String pageSource;

        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);


//        myHelper.loginUAT("ngibpc1", "password1");
//        myHelper.loginUAT("LDSTools31", "password1");
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");


        myTemple.enableTempleRecommendReminder("25", mySettings.active, mySettings.temple6Weeks);

        //Check the temple reminder
        Thread.sleep(6000);
        Assert.assertTrue(myBasePage.checkForElement(myTemple.remindMeLater));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.contactBishopric));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.gotItThanks));

        myTemple.remindMeLater.click();


        //Verify Bishopric
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Bishopric First Counselor", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
    }

    @Test (groups= { "all", "all4"})
    public void templeRecommendReminderGoItThanks() throws Exception {
        String pageSource;

        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);


//        myHelper.loginUAT("ngibpc1", "password1");
//        myHelper.loginUAT("LDSTools31", "password1");
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");


        myTemple.enableTempleRecommendReminder("20", mySettings.active, mySettings.temple6Weeks);

        //Check the temple reminder
        Thread.sleep(6000);
        Assert.assertTrue(myBasePage.checkForElement(myTemple.remindMeLater));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.contactBishopric));
        Assert.assertTrue(myBasePage.checkForElement(myTemple.gotItThanks));

        myTemple.gotItThanks.click();


        //Verify Bishopric
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Bishopric First Counselor", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
    }


    @Test (groups= { "all", "all1", "daily", "daily2"})
    public void templeNearestTemples() throws Exception {
        String pageSource;

        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);

//        driver.get().setLocation(new Location(40.61222818077769, -111.95469497658807, 10));
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");

//        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
//            Location loc = new Location(33.3230, -122.0322, 221);
//            driver.get().setLocation(loc);
//        }


        myMenu.selectMenu(myMenu.temples);
        myBasePage.waitForElementThenClick(myTemple.yesRemindMe);
        Thread.sleep(1000);
        myTemple.chooseDifferentTab(myTemple.nearestTab);

        if (!myBasePage.getOS().contains("ios")) {
            myBasePage.waitForElementThenClick(myBasePage.alertOK);
            myBasePage.waitForElementThenClick(myBasePage.allowButton);
        } else {
            myBasePage.waitForElementThenClick(myBasePage.allowWhileUsingApp);
        }

//        Thread.sleep(12000);
//        pageSource = myBasePage.getSourceOfPage();

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.waitForText("Oakland");
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Oakland", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Sacramento", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Fresno", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Reno", pageSource, "Contains"));
        } else {
            myBasePage.waitForText("Oquirrh");
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Oquirrh", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Jordan", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Draper", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Timpanogos", pageSource, "Contains"));
        }
    }

    @Test (groups= { "all", "all2", "daily", "daily3"})
    public void templeAllTemples() throws Exception {
        String pageSource;

        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);



//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");


        myMenu.selectMenu(myMenu.temples);
        myTemple.yesRemindMe.click();
        Thread.sleep(2000);
        myTemple.chooseDifferentTab(myTemple.allTab);





        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            Thread.sleep(10000);
            System.out.println("Scroll UP!!!!");
            myBasePage.scrollUpAndroidUIAutomator("2");
            myBasePage.scrollUpAndroidUIAutomator("2");
            myBasePage.scrollUpAndroidUIAutomator("2");
            myBasePage.scrollUpAndroidUIAutomator("2");

        }

        Thread.sleep(2000);

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.scrollDownIOS();
            myBasePage.scrollUpIOS();
        }


        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Aba", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Abidjan", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Accra", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Adelaide", pageSource, "Contains"));


    }

    @Test (groups= { "all", "all3", "daily", "daily4"})
    public void templeSearch() throws Exception {
        String pageSource;

        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);



//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");


        myMenu.selectMenu(myMenu.temples);
        myTemple.yesRemindMe.click();
        myTemple.chooseDifferentTab(myTemple.allTab);

        myTemple.searchTemple.setValue("Cedar City");


        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();


        Assert.assertTrue(myBasePage.checkNoCaseList("Cedar City Utah Temple", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Abidjan", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Accra", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Adelaide", pageSource, "Contains"));


    }

    @Test (groups= { "all", "all4", "daily", "daily1"})
    public void templeSearchNewYork() throws Exception {
        String pageSource;

        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);



//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");


        myMenu.selectMenu(myMenu.temples);
//        System.out.println(myBasePage.getSourceOfPage());
        myBasePage.waitForElementThenClick(myTemple.yesRemindMe);
        Thread.sleep(2000);
        myTemple.chooseDifferentTab(myTemple.allTab);

        myTemple.searchTemple.setValue("New York");


        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();


        Assert.assertTrue(myBasePage.checkNoCaseList("Manhattan New York Temple", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Palmyra New York Temple", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Abidjan", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Accra", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("Adelaide", pageSource, "Contains"));


    }


    @Test (groups= { "all", "all4", "daily", "daily2", "jft"})
    public void templeOrdinanceSchedule() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        TemplesScreen myTemple = new TemplesScreen(driver);

        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");


        myMenu.selectMenu(myMenu.temples);
        myBasePage.waitForElementThenClick(myTemple.yesRemindMe);



        if (myBasePage.checkForElement(myTemple.gotItThanks)) {
            myBasePage.waitForElementThenClick(myTemple.gotItThanks);
        }

        //Ordinance schedule is off for COVID
//        System.out.println(myBasePage.getSourceOfPage());
//        myTemple.ordinanceScheduleButton.click();
//
//        checkOrdinanceDate();
//        checkTempleDates(10);


    }


    private void checkTempleDates(int myCounter) throws Exception {
        String pageSource;
        int startCounter;

        TemplesScreen myTemple = new TemplesScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        if (myCounter <= 1) {
            myCounter = 2;
        }


        for (startCounter = 1; startCounter <= myCounter; startCounter++) {
            myTemple.nextButton.click();
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();

            Assert.assertTrue(myBasePage.checkNoCaseList("schedule", pageSource, "Contains"));
            //All temple are closed right now so this is not working right
//            if (pageSource.contains("AM")) {
//                Assert.assertTrue(myBasePage.checkNoCaseList("AM", pageSource, "Contains"));
//            } else {
//                Assert.assertTrue(myBasePage.checkNoCaseList("Temple closed", pageSource, "Contains"));
//            }
        }

    }




    private void checkOrdinanceDate() throws Exception {
        String dateFromApp;
        String formattedDate;

        TemplesScreen myTemple = new TemplesScreen(driver);
        java.util.Date myDate = new java.util.Date();
        SimpleDateFormat myFormat = new SimpleDateFormat("E, MMM dd");

//        System.out.println("System Date: " + myDate);
        dateFromApp = myTemple.templeDate.getText();
//        System.out.println("Temple Date: " + dateFromApp);

        formattedDate = myFormat.format(myDate);
//        System.out.println("Formatted Date: " + formattedDate);

        String[] parts = formattedDate.split(" ");

        String part1 = parts[0];
        part1 = part1.replace(",", "");
        String part2 = parts[1];
        String part3 = parts[2];

//        System.out.println("Part 1: " + part1);
//        System.out.println("Part 2: " + part2);
//        System.out.println("Part 3: " + part3);

        Assert.assertTrue(dateFromApp.contains(part1));
        Assert.assertTrue(dateFromApp.contains(part2));
        Assert.assertTrue(dateFromApp.contains(part3));

    }




}
