package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.SettingsScreen;
import org.testng.Assert;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;


public class PinScreenTest extends BaseDriver {

    @Test (groups = {"all1", "all", "daily", "daily1", "jft"})
    public void pinRepeatTest() throws Exception {
        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        myHelper.proxyLogin("mbthomas74");
//        myHelper.loginUAT("LDSTools3", "toolstester");

        myHelper.checkForAlertsBeforePin();

        if (myBasePage.checkForElement(myPinScreen.pinAlertDialogOK)) {
            myPinScreen.pinAlertDialogOK.click();
        }
//        if (myPinScreen.pinAlertDialogOK.isDisplayed()) {
//            myPinScreen.pinAlertDialogOK.click();
//        }

        pinRepeatTestData();
    }

    @Test (groups = {"all2", "all"})
    public void pinRepeatTestNonLeader() throws Exception {
        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        myHelper.proxyLogin("dcbryson");
//        myHelper.loginUAT("LDSTools5", "toolstester");


        myHelper.checkForAlertsBeforePin();
        myHelper.dismissWhatsNewPage();

//        if (!getRunningOS().equals("ios")) {
//            if (myPinScreen.pinAlertDialogOK.isDisplayed()) {
//                myPinScreen.pinAlertDialogOK.click();
//            }
//        }

        pinRepeatTestData();
    }



    @Test (groups = {"all3", "all", "daily", "daily2"})
    public void pinNoMatchTest() throws Exception {
        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        myHelper.proxyLogin("mbthomas74");


//        if (!getRunningOS().equals("ios")) {
//            if (myPinScreen.pinAlertDialogOK.isDisplayed()) {
//                myPinScreen.pinAlertDialogOK.click();
//            }
//        }
        myHelper.checkForAlertsBeforePin();
        pinNoMatchTestData();

    }


    @Test (groups = {"all2", "all"})
    public void pinNoMatchTestNonLeader() throws Exception {
        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        myHelper.proxyLogin("dcbryson");
//        myHelper.loginUAT("LDSTools5", "toolstester");

        myHelper.checkForAlertsBeforePin();
        myHelper.dismissWhatsNewPage();

//        if (!getRunningOS().equals("ios")) {
//            if (myPinScreen.pinAlertDialogOK.isDisplayed()) {
//                myPinScreen.pinAlertDialogOK.click();
//            }
//        }
        myHelper.checkForAlertsBeforePin();
        pinNoMatchTestData();

    }

    @Test (groups = {"all4", "all"})
    public void pinSequentialTest() throws Exception {
        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        myHelper.proxyLogin("mbthomas74");
//        myHelper.loginUAT("LDSTools3", "toolstester");
//        myHelper.loginUAT("LDSTools5", "toolstester");

//        if (!getRunningOS().equals("ios")) {
//            myHelper.checkForAlertsBeforePin();
//        }


//        if (myPinScreen.pinAlertDialogOK.isDisplayed()) {
//            myPinScreen.pinAlertDialogOK.click();
//        }
        myHelper.checkForAlertsBeforePin();
        sequentialTestData();


    }

    @Test (groups = {"all1", "all"})
    public void pinSequentialTestNonLeader() throws Exception {
        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        myHelper.proxyLogin("dcbryson");
//        myHelper.loginUAT("LDSTools5", "toolstester");

//        myHelper.checkForAlertsBeforePin();
//        myHelper.dismissWhatsNewPage();

//        if (!getRunningOS().equals("ios")) {
//
//
//            if (myPinScreen.pinAlertDialogOK.isDisplayed()) {
//                myPinScreen.pinAlertDialogOK.click();
//            }
//
//        }

        myHelper.checkForAlertsBeforePin();
        sequentialTestData();


    }

    private void sequentialTestData() throws Exception {
        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        BasePage myBasePage = new BasePage(driver);

//        if (getRunningOS().equalsIgnoreCase("android")) {
//            myHelper.enterPin("1", "1", "3", "3");
//            myMenu.selectMenu(myMenu.settings);
//            mySettings.createAPIN.click();
//        }



        //Sequential Numbers
        myHelper.pressPinKeys("1");
        myHelper.pressPinKeys("2");
        myHelper.pressPinKeys("3");
        myHelper.pressPinKeys("4");

        if (getRunningOS().equalsIgnoreCase("android")) {
            myPinScreen.pinKeyEnter.click();
            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", myPinScreen.pinKeyErrorMessage.getText());
//            System.out.println(myBasePage.getSourceOfPage());
            for (int x = 1; x <= 4; x++) {
                myPinScreen.pinKeyDelete.click();
            }
        } else {
            Assert.assertEquals("Passcode can't have sequential numbers.", myPinScreen.pinAlertDialogMessage.getText());
            myPinScreen.pinAlertDialogOK.click();
        }


//        //Should get an error on iOS .... Android needs to enter in the digits again to get an error
//        if (getRunningOS().equals("android")) {
////            myHelper.pressPinKeys("1");
////            myHelper.pressPinKeys("2");
////            myHelper.pressPinKeys("3");
////            myHelper.pressPinKeys("4");
////
////
////            myPinScreen.pinKeyEnter.click();
//
//
////            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", myPinScreen.pinKeyErrorMessage.getText());
//
//        } else {
//            Assert.assertEquals("Passcode can't have sequential numbers.", myPinScreen.pinAlertDialogMessage.getText());
//            myPinScreen.pinAlertDialogOK.click();
//        }

        //Sequential Numbers
        myHelper.pressPinKeys("9");
        myHelper.pressPinKeys("8");
        myHelper.pressPinKeys("7");
        myHelper.pressPinKeys("6");

        if (getRunningOS().equalsIgnoreCase("android")) {
            myPinScreen.pinKeyEnter.click();
            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", myPinScreen.pinKeyErrorMessage.getText());
//            System.out.println(myBasePage.getSourceOfPage());
            for (int x = 1; x <= 4; x++) {
                myPinScreen.pinKeyDelete.click();
            }
        } else {
            Assert.assertEquals("Passcode can't have sequential numbers.", myPinScreen.pinAlertDialogMessage.getText());
            myPinScreen.pinAlertDialogOK.click();
        }


//        //Should get an error on iOS .... Android needs to enter in the digits again to get an error
//        if (getRunningOS().equals("android")) {
////            myHelper.pressPinKeys("9");
////            myHelper.pressPinKeys("8");
////            myHelper.pressPinKeys("7");
////            myHelper.pressPinKeys("6");
////
////            Thread.sleep(1000);
////            myPinScreen.pinKeyEnter.click();
//
//
//            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", myPinScreen.pinKeyErrorMessage.getText());
//
//        } else {
//            Assert.assertEquals("Passcode can't have sequential numbers.", myPinScreen.pinAlertDialogMessage.getText());
//            myPinScreen.pinAlertDialogOK.click();
//        }
    }

    private void pinNoMatchTestData() throws Exception {
        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBase = new BasePage(driver);
        String pageSource;



//        if (getRunningOS().equalsIgnoreCase("android")) {
//            myHelper.enterPin("1", "1", "3", "3");
//            myMenu.selectMenu(myMenu.settings);
//            mySettings.createAPIN.click();
//        }


        myHelper.pressPinKeys("3");
        myHelper.pressPinKeys("5");
        myHelper.pressPinKeys("9");
        myHelper.pressPinKeys("1");

        if (getRunningOS().equalsIgnoreCase("android")) {
            myPinScreen.pinKeyEnter.click();
        }


        myHelper.pressPinKeys("7");
        myHelper.pressPinKeys("4");
        myHelper.pressPinKeys("1");
        myHelper.pressPinKeys("8");

        if (getRunningOS().equalsIgnoreCase("android")) {
            myPinScreen.pinKeyEnter.click();
        }


        if (getRunningOS().equals("android")) {
            pageSource = myBase.getSourceOfPage();
            Assert.assertTrue(myBase.checkNoCaseList("PINs do not match.", pageSource, "Contains"));
//            Assert.assertEquals("PINs do not match.", myPinScreen.pinKeyErrorMessage.getText());
        } else {
            Assert.assertEquals("Passcodes do not match.", myPinScreen.pinAlertDialogMessage.getText());
            myPinScreen.pinAlertDialogOK.click();
        }
    }

    private void pinRepeatTestData() throws Exception {
        HelperMethods myHelper = new HelperMethods();
        PinScreen myPinScreen = new PinScreen(driver);
        BasePage myBase = new BasePage(driver);
        String pageSource;

        //All four of the same number
        myHelper.pressPinKeys("1");
        Thread.sleep(2000);
        myHelper.pressPinKeys("1");
        Thread.sleep(2000);
        myHelper.pressPinKeys("1");
        Thread.sleep(2000);
        myHelper.pressPinKeys("1");
        Thread.sleep(2000);


        if (getRunningOS().equalsIgnoreCase("android")) {
            myPinScreen.pinKeyEnter.click();
            pageSource = myBase.getSourceOfPage();
            Assert.assertTrue(myBase.checkNoCaseList("PIN cannot have sequential or repeating numbers.", pageSource, "Contains"));
//            Assert.assertEquals("PIN cannot have sequential or repeating numbers.", myPinScreen.pinKeyErrorMessage.getText());
//            System.out.println(myBasePage.getSourceOfPage());
            for (int x = 1; x <= 4; x++) {
                myPinScreen.pinKeyDelete.click();
            }
        } else {
            Assert.assertEquals("Passcode must not repeat a number three times.", myPinScreen.pinAlertDialogMessage.getText());
            myPinScreen.pinAlertDialogOK.click();
        }
    }


}
