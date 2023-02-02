package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginPageTest extends BaseDriver {



    @Test (groups = {"deprecated"})
    public void validateLoginPage() throws Exception {
        String myPageSource;
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLogin = new LoginPageScreen(driver);

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }

        myBasePage.waitForElement(myLogin.loginName);
        myPageSource = myBasePage.getSourceOfPage();

        if (myBasePage.getOS().equals("ios")) {
            Assert.assertTrue(myPageSource.contains("Account"));
            Assert.assertTrue(myPageSource.contains("Help"));
            Assert.assertTrue(myPageSource.contains("Sign In"));
        } else {
            Assert.assertTrue(myPageSource.contains("Tools"));
            //Have to do a case-insensitive test for Android 5.0 doesn't handle case correctly
            Assert.assertTrue(myPageSource.toLowerCase().contains("sign in"));
            Assert.assertTrue(myPageSource.toLowerCase().contains("having trouble signing in"));
            Assert.assertTrue(myPageSource.toLowerCase().contains("create an account"));
        }

        Assert.assertTrue(myPageSource.contains("Username"));
        Assert.assertTrue(myPageSource.contains("Password"));

    }

    @Test (groups = {"deprecated"})
    public void validateLoginPageLinks() throws Exception {
        String myPageSource;
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }
        myBasePage.waitForElement(myLoginPage.loginName);
//        Thread.sleep(2000);

        myLoginPage.troubleSigningIn.click();
        Thread.sleep(4000);
        myBasePage.waitForText("Account");
        myLoginPage.accountRecoveryPage.isDisplayed();
        myPageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myPageSource.contains("Account"));
        Assert.assertTrue(myPageSource.contains("Church Account"));


        Assert.assertTrue(myPageSource.contains("Account Recovery"));
//        System.out.println(myPageSource);



        //Appium cannot select the links on Android
        if (getRunningOS().equals("ios")) {
            myLoginPage.doneButton.click();
//            myLoginPage.privacyNotice.click();
            myBasePage.clickEndOfElementByCords(myLoginPage.privacyNotice);
            Thread.sleep(2000);
            myBasePage.waitForText("Privacy Notice");
//        myBasePage.waitForText("Privacy Notice");
            myPageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myPageSource.contains("Privacy Notice"));
            Assert.assertTrue(myPageSource.contains("Updated 2021-04-06"));
//        Assert.assertTrue(myPageSource.contains("In this Notice"));

            if (myBasePage.getOS().equals("ios")) {
//                myLoginPage.doneButton.click();
            } else {
                driver.get().navigate().back();
            }

//            myLoginPage.termsOfUse.click();
            myBasePage.clickElementByCords(myLoginPage.termsOfUse);
//            Thread.sleep(3000);
            myBasePage.waitForText("Terms of Use");
            myPageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myPageSource.contains("Terms of Use"));
            Assert.assertTrue(myPageSource.contains("Updated 2021-04-13"));
//            Assert.assertTrue(myPageSource.contains("By using this site"));


//            if (myBasePage.getOS().equals("ios")) {
//                myLoginPage.doneButton.click();
//            }
        } else {
            driver.get().navigate().back();
        }



    }

    // ******************* Invalid Password Tests *******************
    @Test (groups = {"deprecated"})
    public void invalidPasswordTest1() throws Exception {
        invalidCheck("zmaxfield", "<login>");
    }

    @Test ( groups = {"deprecated"})
    public void invalidPasswordTest2() throws Exception {
        invalidCheck("zmaxfield", "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }

    @Test ( groups = {"deprecated"})
    public void invalidPasswordTest3() throws Exception {
        invalidCheck("zmaxfield", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    @Test ( groups = {"deprecated"})
    public void invalidPasswordTest4() throws Exception {
        invalidCheck("zmaxfield", "/password/");
    }

    @Test ( groups = {"deprecated"})
    public void invalidPasswordTest5() throws Exception {
        invalidCheck("zmaxfield", "!@#$%%^&**())__+_!@@!#!$%#@%^*&%&*(^*()(&(&*(%^&$#%@$!#$%$#^#$%^^&*(^%}|{|{|}{|}{|}{}|{|}{}|{|}{||||}|{}{|}{");
    }

    @Test ( groups = {"deprecated"})
    public void invalidPasswordTest6() throws Exception {
        invalidCheck("zmaxfield", "select * from directory");
    }

    @Test ( groups = {"deprecated"})
    public void invalidPasswordTest7() throws Exception {
        invalidCheck("zmaxfield", " toolstester");
    }


    // ******************* Invalid Username Tests *******************


    @Test ( groups = {"deprecated"})
    public void invalidUsernameTest1() throws Exception {
        invalidCheck("Invalidtest1234", "toolstester");
    }



    @Test ( groups = {"deprecated"})
    public void invalidUsernameTest2() throws Exception {
        invalidCheck("Invalidtest1234123123", "password1");
    }



    @Test ( groups = {"deprecated"})
    public void invalidUsernameTest3() throws Exception {
        invalidCheck("********", "isjlsdkj");
    }



    @Test ( groups = {"deprecated"})
    public void invalidUsernameTest4() throws Exception {
        invalidCheck("select * from directory", "password1");
    }


    @Test ( groups = {"deprecated"})
    public void invalidUsernameTest5() throws Exception {
        invalidCheck("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&", "password1");
    }



    @Test ( groups = {"deprecated"})
    public void invalidUsernameTest6() throws Exception {
        invalidCheck("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%", "password1");
    }



//    @Test ( groups = {"all2", "all", "login"})
//    public void invalidUsernameTest7() throws Exception {
//        invalidCheck(" LDSTools3", "toolstester");
//    }





    // ******************* Invalid Username and Password Tests *******************
    @Test ( groups = {"deprecated"})
    public void invalidUsernameAndPasswordTest1() throws Exception {
        invalidCheck("sfjksdjissldjskldjslfjslfj", "toolste@#@$#^#$&%*%*&ster");
    }

    @Test ( groups = {"deprecated"})
    public void invalidUsernameAndPasswordTest2() throws Exception {
        invalidCheck("HanSolo", "<><><><><><><><><>");
    }

    @Test ( groups = {"deprecated"})
    public void invalidUsernameAndPasswordTest3() throws Exception {
        invalidCheck("This is a bad username test", "This is a bad password test");
    }

    @Test ( groups = {"deprecated"})
    public void invalidUsernameAndPasswordTest4() throws Exception {
        invalidCheck("select * from directory", "^^^^^^^^^^^^");
    }

    @Test ( groups = {"deprecated"})
    public void invalidUsernameAndPasswordTest5() throws Exception {
        invalidCheck("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&", "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }

    @Test ( groups = {"deprecated"})
    public void invalidUsernameAndPasswordTest6() throws Exception {
        invalidCheck("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }




    //Todo: This is broken for iOS
    //Todo: Need a way to force close the app without logging out
    //This is an iOS only test now.
//    @Test ( groups = {"all4", "all", "login", "jft"})
    @Test ( groups = {"noworking"})
    public void changePIN() throws Exception {
        String myPinMessage;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        PinScreen myPin = new PinScreen(driver);

        if (getRunningOS().equalsIgnoreCase("ios")) {
            //Login and enter in PIN
//        myHelper.loginUAT("LDSTools3", "toolstester");
            myHelper.proxyLogin("gabrielsmith");
            myHelper.enterPin("1", "1", "3", "3");

            myMenu.selectMenu(myMenu.settings);
            myBasePage.waitForElementThenClick(mySettings.changeYourPIN);
//        mySettings.changeYourPIN.click();
            //This is needed for iOS
            if (getRunningOS().equals("ios")) {
                myBasePage.waitForElementThenClick(mySettings.updatePasscodePIN);
//            mySettings.changeYourPIN.click();
            }

            myPinMessage = myPin.pinMessage.getText();

            if (myPinMessage.equals("Enter Current Passcode") || (myPinMessage.equals("Enter your PIN"))) {
                myPin.pinKey1.click();
                myPin.pinKey1.click();
                myPin.pinKey3.click();
                myPin.pinKey3.click();
            }

            myHelper.changePIN("4", "4", "6", "6");

            if (getRunningOS().equalsIgnoreCase("ios")) {
//                driver.get().closeApp();
//                driver.get().launchApp();

            } else {
                myBasePage.backButton.click();
//                driver.get().closeApp();
//                driver.get().launchApp();
            }




            myHelper.enterCurrentPin("4", "4", "6", "6");

            //This is a bug. The Whats new page should not be displayed here
            myHelper.dismissWhatsNewPage();
//            myMenu.menuLogOut();
//        myHelper.loginUAT("LDSTools3", "toolstester");
//            myHelper.proxyLogin("gabrielsmith");
//            myHelper.enterPin("4", "4", "6", "6");



            myMenu.selectMenu(myMenu.settings);
        } else {
            System.out.println("Not Valid for Android!");
        }




    }



    private void invalidCheck(String userName, String passWord) throws Exception {
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }
        clearLoginPassword();

//        myHelper.loginUAT(userName, passWord);
        myHelper.uatInvalidLogin(userName, passWord);
//        Thread.sleep(6000);
        checkInvalidAlert();
    }


    private void checkInvalidAlert() {
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        if (getRunningOS().equalsIgnoreCase("ios")) {
//            myBasePage.waitForText("Having trouble signing in");
            myBasePage.waitForText("Sign-In Failed");
        } else {
            myBasePage.waitForText("your username");
        }


        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }

        if (myBasePage.checkForElement(myLoginPage.errorMessageService)) {
            Assert.assertTrue(myBasePage.checkForElement(myLoginPage.loginErrorMessage));
        }

        if (myBasePage.checkForElement(myBasePage.alertOK)) {
            myBasePage.alertOK.click();
        }

    }

    private void clearLoginPassword() throws Exception {
        //Clear the login and password fields

        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        Thread.sleep(2000);
        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();
        Thread.sleep(2000);
    }




/*
    @Test (groups = { "NotWorking"})
    public void loginPageJustForTesting() throws Exception {
        String myPageSource;
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        long startTime;
        long stopTime;
        long myTime;

        myPageSource = myBasePage.getSourceOfPage();
        Thread.sleep(2000);

        startTime = System.currentTimeMillis();
        myBasePage.checkForElement(myLoginPage.loginName);
        stopTime = System.currentTimeMillis();
        myTime = stopTime - startTime;

        System.out.println("Check For Element (BasePage): " + myTime);

        startTime = System.currentTimeMillis();
        myBasePage.checkForElement(myLoginPage.alertOK);
        stopTime = System.currentTimeMillis();
        myTime = stopTime - startTime;

        System.out.println("Check For Element (BasePage not found): " + myTime);

        startTime = System.currentTimeMillis();
        assert myLoginPage.loginName.isDisplayed();
        stopTime = System.currentTimeMillis();
        myTime = stopTime - startTime;

        System.out.println("Check For Element (isDisplayed): " + myTime);

        startTime = System.currentTimeMillis();
        myLoginPage.loginName.isDisplayed();
        stopTime = System.currentTimeMillis();
        myTime = stopTime - startTime;

        System.out.println("Check For Element ( no assert isDisplayed): " + myTime);

        startTime = System.currentTimeMillis();
        assert myLoginPage.loginName.isEnabled();
        stopTime = System.currentTimeMillis();
        myTime = stopTime - startTime;

        System.out.println("Check For Element (isEnabled): " + myTime);
    }*/



}
