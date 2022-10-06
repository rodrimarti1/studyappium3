package LDSToolsAppiumTest;


import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.codec.binary.Base64;

import org.jsoup.nodes.Element;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.*;
import java.util.*;


public class HelperMethods extends BaseDriver {



//    public HelperMethods(AppiumDriver<WebElement> driver) {
//
//    }


    public void loginUAT(String userName, String password) throws Exception {
        //Enable Developer Settings and set the Network Environment to UAT
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String myTemp = "";

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }

        setupUAT(myTemp);

        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();

        myLoginPage.loginName.sendKeys(userName);
        myLoginPage.passWord.sendKeys(password);
        myLoginPage.signInButton.click();
        Thread.sleep(1000);

        long startTime = System.nanoTime();

        System.out.println("Check for Sign In");
        myBasePage.waitUnitlTextIsGone("Sign In");
        System.out.println("Check for Sign In over ------ Check for Sync");

        Thread.sleep(2000);

        if (myBasePage.getOS().equals("ios")) {
            System.out.println("Wait for text to appear: UAT");
            myBasePage.waitForText("UAT");
            System.out.println("Text found: UAT");
            myBasePage.waitUnitlTextIsGone("UAT");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("UAT");
        } else {
            myBasePage.waitUnitlTextIsGone("Authenticating");
            myBasePage.waitForText("Updating");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Updating");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Updating");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        duration = duration / 1000000;
        System.out.println("Done waiting for Text to disappear: Sync Took: " + duration);


        Thread.sleep(1000);
    }

    private void iosDeepLink(String proxyUserName) throws Exception {
        setupUAT(proxyUserName);
//        deepLinkSelector(proxyUserName);
    }

    private void iosDeepLinkProd(String proxyUserName) throws Exception {
        setupProdProxy(proxyUserName);
    }



    private void deepLinkSelector(String proxyUserName) throws Exception {
        String appName;
        appName = driver.get().getCapabilities().getCapability("app").toString();
        System.out.println("App: "  + appName);

        if (appName.contains(".ipa")) {
            driver.get().executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
            //            //May need to replace -u with -U in 12.2
            List args = new ArrayList();
//            args.add("-U");
            args.add("https://www.google.com");

            Map<String, Object> params = new HashMap<>();
            params.put("bundleId", "com.apple.mobilesafari");
            params.put("arguments", args);
            driver.get().executeScript("mobile: launchApp", params);
            Thread.sleep(10000);

            driver.get().findElement(By.xpath("//XCUIElementTypeOther[@label='Address']")).click();
            Thread.sleep(6000);

            driver.get().findElement(By.xpath("//XCUIElementTypeButton[@name='Clear text']")).click();
            Thread.sleep(6000);

            driver.get().findElement(By.xpath("//XCUIElementTypeTextField[@label='Address']")).sendKeys("membertools://user/" + proxyUserName);
            Thread.sleep(2000);
            driver.get().findElement(By.xpath("//*[@name='Go']")).click();
            Thread.sleep(6000);
            driver.get().findElement(By.xpath("//*[@name='Open']")).click();
        } else {
            driver.get().get("https://www.google.com");
            Thread.sleep(2000);
            driver.get().get("membertools://user/" + proxyUserName);
            Thread.sleep(3000);
        }
    }


    public void proxyLogin(String proxyUserName) throws Exception {
        // ********* Constructor **********
        BasePage myBasePage = new BasePage(driver);
        BaseDriver myBaseDriver = new BaseDriver();
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        String loginName = "zmaxfield";


        String deviceName;
        String pageSource;
        int myCounter = 1;

        LOGGER.info("Start Proxy Login");

        if (myBasePage.checkForElement(myBasePage.allowWhileUsingApp)) {
//            System.out.println(myBasePage.getSourceOfPage());
//            Thread.sleep(2000);
            myBasePage.allowWhileUsingApp.click();
            Thread.sleep(500);
        }

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
//            System.out.println(myBasePage.getSourceOfPage());
//            Thread.sleep(2000);
            myBasePage.allowButton.click();
        }

        byte[] decodeBytes = Base64.decodeBase64("U25AazNTcDE3MjAyMg==");
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            iosDeepLink(proxyUserName);
//            loginName = "zmaxfield/stage/" + proxyUserName;
        } else {
            while(!myBasePage.checkForElement(myLoginPage.titleMemberToolsSTAGE)|| myCounter > 4) {
//                System.out.println(myBasePage.getSourceOfPage());
                myLoginPage.titleMemberTools.click();
                myCounter++;
            }


            myLoginPage.overflowMenu.click();
            myLoginPage.overflowSettings.click();
            myBasePage.scrollToTextGeneral("Proxy Username");
            mySettings.proxyUsername.click();
            myBasePage.waitForElement(mySettings.proxyUsernameEditText);
            mySettings.proxyUsernameEditText.sendKeys(proxyUserName);
            mySettings.proxyUsernameEditOK.click();
            myBasePage.navigateUp.click();



//            System.out.println("Get the device name");
//            deviceName = driver.get().getCapabilities().getCapability("deviceName").toString();
//            System.out.println("adb - proxy start");
//            myBaseDriver.adbProxyStart(deviceName, proxyUserName);
//            Thread.sleep(2000);
        }
        if (myBasePage.checkForElement(myLoginPage.cancelPass)){
            myLoginPage.cancelPass.click();
        }

        LOGGER.info("Clear login and password");
        myBasePage.waitForElement(myLoginPage.loginName);
        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();


        myLoginPage.loginName.sendKeys(loginName);
        myLoginPage.passWord.sendKeys(new String(decodeBytes));
        myLoginPage.signInButton.click();
        Thread.sleep(500);

        long startTime = System.nanoTime();

        LOGGER.info("Check for Sign In");
        myBasePage.waitUnitlTextIsGone("Sign In");
        LOGGER.info("Check for Sign In over ------ Check for Sync");

//        Thread.sleep(2000);

//        unavailableCheck();



        if (myBasePage.getOS().equals("ios")) {
            unavailableCheck();

//            pageSource = myBasePage.getSourceOfPage();
//            if (pageSource.contains("passcode")) {
//                LOGGER.info("Found Passcode");
//
//            } else {
//                LOGGER.info("Waiting for Updating.... ");
//                myBasePage.waitForTextPopUp("Updating");
//
//                LOGGER.info("Found Updating waiting for Updating to go away.");
//                myBasePage.waitUntilTextIsGonePopUp("Updating");
//
//
//            }
            Thread.sleep(1000);

            myBasePage.waitForText("passcode");
            LOGGER.info("Text found: Passcode");

        } else {
            myBasePage.waitUnitlTextIsGone("Authenticating");
            unavailableCheck();

            myBasePage.waitUnitlTextIsGone("Updating");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Updating");
//            unavailableCheck();
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        duration = duration / 1000000;
        LOGGER.info("Done waiting for Text to disappear: Sync Took: " + duration);

        syncTimeWriter(duration);



        Thread.sleep(1000);
    }

    public void syncTimeWriter( long duration) throws Exception {
        try(FileWriter fw = new FileWriter("screenshot/syncTime.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            out.println(duration);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void unavailableCheck() throws Exception {
        BasePage myBasePage = new BasePage(driver);
        String pageSource;
        boolean syncChecker = true;
        int syncCounter = 1;
        LOGGER.info("Check for failed to download");

        while (syncChecker) {
            LOGGER.info("Sync Checker: " + syncCounter);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(pageSource.contains("Failed to download."));
            Assert.assertFalse(pageSource.contains("Member Tools Services are unavailable"));
            Assert.assertFalse(pageSource.contains("Error"));

            if (pageSource.contains("passcode")) {
                LOGGER.info("Found Passcode");
                syncChecker = false;
            }

            if (pageSource.contains("PIN")) {
                LOGGER.info("Found PIN");
                syncChecker = false;
            }

            if (syncCounter >= 3 ) {
                syncChecker = false;
            }
            syncCounter++;

            Thread.sleep(500);

        }

        LOGGER.info("Done checking for failed to download");


    }


    public void proxyLoginProd(String proxyUserName) throws Exception {
        // ********* Constructor **********
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        String pageSource;
        int myCounter = 1;

        LOGGER.info("Start Proxy Login");
        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }
        byte[] decodeBytes = Base64.decodeBase64("U25AazNTcDE3MjAyMg==");
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            iosDeepLinkProd(proxyUserName);
        } else {

            while(!myBasePage.checkForElement(myLoginPage.titleMemberTools)|| myCounter > 4) {
                myLoginPage.titleMemberTools.click();
                myCounter++;
            }


            myLoginPage.overflowMenu.click();
            myLoginPage.overflowSettings.click();
            myBasePage.scrollToTextGeneral("Proxy Username");
            mySettings.proxyUsername.click();
            mySettings.proxyUsernameEditText.sendKeys(proxyUserName);
            mySettings.proxyUsernameEditOK.click();
            myBasePage.backButton.click();
        }
        if (myBasePage.checkForElement(myLoginPage.cancelPass)){
            myLoginPage.cancelPass.click();
        }

        LOGGER.info("Clear login and password");
        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();


        myLoginPage.loginName.sendKeys("zmaxfield");
        myLoginPage.passWord.sendKeys(new String(decodeBytes));
        myLoginPage.signInButton.click();
        Thread.sleep(1000);

        long startTime = System.nanoTime();

        LOGGER.info("Check for Sign In");
        myBasePage.waitUnitlTextIsGone("Sign In");
        LOGGER.info("Check for Sign In over ------ Check for Sync");

        Thread.sleep(2000);

        if (myBasePage.getOS().equals("ios")) {
            //Check for Failed to download
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(pageSource.contains("Failed to download."));
            Assert.assertFalse(pageSource.contains("Member Tools Services are unavailable"));

            //May not need this
//            if (pageSource.contains("Updat")) {
//                LOGGER.info("Wait for text to appear: Updat");
//                myBasePage.waitForText("Updat");
//                LOGGER.info("Text found: Update");
//            }

            Thread.sleep(4000);
            myBasePage.waitForText("passcode");
            LOGGER.info("Text found: Passcode");
        } else {
            myBasePage.waitUnitlTextIsGone("Authenticating");
            myBasePage. waitForText("Updating");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Updating");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Updating");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        duration = duration / 1000000;
        LOGGER.info("Done waiting for Text to disappear: Sync Took: " + duration);


        Thread.sleep(1000);
    }





    public void loginProduction(String userName, String password) throws Exception {
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }

        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();

        myLoginPage.loginName.sendKeys(userName);
        myLoginPage.passWord.sendKeys(password);
        myLoginPage.signInButton.click();
        Thread.sleep(1000);

        long startTime = System.nanoTime();

        System.out.println("Check for Sign In");
        myBasePage.waitUnitlTextIsGone("Sign In");
        System.out.println("Check for Sign In over ------ Check for Sync");

        Thread.sleep(2000);

        if (myBasePage.getOS().equals("ios")) {
//            Thread.sleep(5000);
            myBasePage.waitUnitlTextIsGone("Stop Sync");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Stop Sync");
        } else {
            myBasePage.waitUnitlTextIsGone("Authenticating");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Sync");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Sync");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        duration = duration / 1000000;
        System.out.println("Done waiting for Text to disappear: Sync Took: " + duration);


        Thread.sleep(1000);
    }

    public void syncTools() throws Exception {
        BasePage myBasePage = new BasePage(driver);
        SyncScreen mySync = new SyncScreen(driver);

        if (myBasePage.getOS().equals("ios")) {
            mySync.syncNowButton.click();
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Sync");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Sync");
        } else {
            mySync.syncOKButton.click();
            Thread.sleep(2000);
            myBasePage.waitUnitlTextIsGone("Stop Sync");
            Thread.sleep(1000);
            myBasePage.waitUnitlTextIsGone("Stop Sync");
        }

    }




    public void loginProxy(String myId, String myUnit, String myPosition) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        //Enable Developer Settings and set the Network Environment to Proxy
        String userName = "paigekrebs";
        String password = "sweets2005";
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }
        setupProxy(myId, myUnit, myPosition);

        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();

        myLoginPage.loginName.sendKeys(userName);
        myLoginPage.passWord.sendKeys(password);
        myLoginPage.signInButton.click();
        Thread.sleep(10000);

        long startTime = System.nanoTime();


        if (myBasePage.getOS().equals("ios")) {
            myBasePage.waitUnitlTextIsGone("Stop Sync");
        } else {
            myBasePage.waitUnitlTextIsGone("Sync Progress");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        duration = duration / 1000000;
        System.out.println("Done waiting for Text to disappear: Sync Took: " + duration);


        Thread.sleep(6000);
    }

    public void setupUAT(String proxyUserName) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        ScannerScreen myScanner = new ScannerScreen(driver);
//        BaseDriver myBaseDriver = new BaseDriver();
//        String os = "android";
//        String fileName = "android-mobile-dev-release.apk";
//        String testDeviceX = myBaseDriver.getTestngTestDevice();
//        String testDeviceX = driver.getCapabilities().getCapability("deviceName").toString();
//        int startSleepTime = 200;
//        SessionId toolsSessionId;


        if (myBasePage.getOS().equals("ios")) {
            myBasePage.waitForElementThenClick(myLoginPage.overflowMenu);
//            myLoginPage.overflowMenu.click();

            if (myScanner.scannerCheckForText("Developer Settings") ) {
                myBasePage.waitForElementThenClick(myLoginPage.developerButton);
//                myLoginPage.developerButton.click();
            } else {
                for (int x = 1; x <= 5; x++) {
                    myBasePage.waitForElementThenClick(myLoginPage.enterDeveloperButton);
//                    myLoginPage.enterDeveloperButton.click();
                }
            }


            myBasePage.waitForElementThenClick(mySettings.proxyUsername);
//            mySettings.proxyUsername.click();
            myBasePage.waitForElement(mySettings.proxyEditField);
            mySettings.proxyEditField.sendKeys(proxyUserName);
            mySettings.proxyDone.click();
            myBasePage.waitForElementThenClick(mySettings.networkEnvironment);
            myBasePage.waitForElementThenClick(mySettings.UAT);
            Thread.sleep(1000);
//            myBasePage.waitForElementThenClick(myBasePage.backButton);
//            Thread.sleep(500);
////            System.out.println(myBasePage.getSourceOfPage());
//            myBasePage.waitForElementThenClick(myBasePage.backAltButton);


        } else {

//            System.out.println("Helper Method: " + testDeviceX);
//            System.out.println("Session ID: " + driver.getSessionId());
//            String myAppPackage = driver.getCapabilities().getCapability("appPackage").toString();
//
//            MobileDevMain myMobileDevMain = new MobileDevMain(os, fileName, testDeviceX, startSleepTime, "UAT");
//            driver.navigate().back();
//            driver.closeApp();
//            driver.launchApp();
//            Thread.sleep(9000);
//
////            driver.activateApp(myAppPackage);
//            driver.runAppInBackground(Duration.ofSeconds(2));


//            TouchAction myTap = new TouchAction(driver);
//            myTap.press(PointOption.point(100, 100))
//                    .release()
//                    .perform();
//
//            myTap.press(PointOption.point(100, 100))
//                    .release()
//                    .perform();
//
//            Thread.sleep(1000);


//            myLoginPage.overflowMenu.click();
//            myLoginPage.overflowSettings.click();
//            scrollToTextRecyclerView("About");
//            mySettings.about.click();
//
//            for (int x = 1 ; x <= 7 ; x++ ) {
//                mySettings.aboutLogo.click();
//            }
//
//            backButton.click();
//            scrollUpAndroidUIAutomator("0");
////            scrollToTextRecyclerView("Network Environment");
//            scrollToTextSwipe("Network Environment");
//
//
//            mySettings.networkEnvironment.click();
//            mySettings.UAT.click();
//
//            backButton.click();

        }

    }


    public void setupProdProxy(String proxyUserName) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        ScannerScreen myScanner = new ScannerScreen(driver);

        myLoginPage.overflowMenu.click();
        if (myScanner.scannerCheckForText("Developer Settings") ) {
            myLoginPage.developerButton.click();
        } else {
            for (int x = 1; x <= 5; x++) {
                myLoginPage.enterDeveloperButton.click();
            }
        }
        myBasePage.waitForElement(mySettings.proxyUsername);
        mySettings.proxyUsername.click();
        myBasePage.waitForElement(mySettings.proxyEditField);
        mySettings.proxyEditField.sendKeys(proxyUserName);
        mySettings.proxyDone.click();
        Thread.sleep(1000);
        myBasePage.waitForElementThenClick(myBasePage.backButton);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
    }


    private void setupProxy(String myId, String myUnit, String myPosition) throws Exception {
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        ScannerScreen myScanner = new ScannerScreen(driver);

        BasePage myBasePage = new BasePage(driver);
        if (myBasePage.getOS().equals("ios")) {
            myLoginPage.overflowMenu.click();

            if (myScanner.scannerCheckForText("Developer Settings") ) {
                myLoginPage.developerButton.click();
            } else {
                for (int x = 1; x <= 5; x++) {
                    myLoginPage.enterDeveloperButton.click();
                }
            }

            mySettings.networkEnvironment.click();
            mySettings.proxy.click();
            Thread.sleep(1000);
            myBasePage.backButton.click();

            myBasePage.scrollDownIOS();
            mySettings.proxyId.click();
            mySettings.proxyEditField.sendKeys(myId);
            mySettings.proxyDone.click();

            myBasePage.scrollDownIOS();

            mySettings.proxyUnits.click();
            mySettings.proxyEditField.sendKeys(myUnit);
            mySettings.proxyDone.click();

            mySettings.proxyPositions.click();
            mySettings.proxyEditField.sendKeys(myPosition);
            mySettings.proxyDone.click();
            Thread.sleep(1000);

            myBasePage.backButton.click();
            Thread.sleep(1000);
            myBasePage.backButton.click();

        } else {
            myLoginPage.overflowMenu.click();
            myLoginPage.overflowSettings.click();
            myBasePage.scrollToTextRecyclerView("About");
            mySettings.about.click();
            for (int x = 1 ; x <= 7 ; x++ ) {
                mySettings.aboutLogo.click();
            }
            myBasePage.backButton.click();
            myBasePage.scrollToTextRecyclerView("Network Environment");
            //mySettings.resetWhatsNewPrompt.click();

            mySettings.networkEnvironment.click();
            mySettings.proxy.click();

            myBasePage.scrollToTextRecyclerView("px_i");
            //scrollToText("px_u");

            mySettings.proxyId.click();
            mySettings.proxyEditField.sendKeys(myId);
            mySettings.proxyDone.click();

            myBasePage.scrollToTextRecyclerView("px_u");

            mySettings.proxyUnits.click();
            mySettings.proxyEditField.sendKeys(myUnit);
            mySettings.proxyDone.click();

            myBasePage.scrollToTextRecyclerView("px_p");

            mySettings.proxyPositions.click();
            mySettings.proxyEditField.sendKeys(myPosition);
            mySettings.proxyDone.click();

            myBasePage.backButton.click();
        }

    }

    public void enterPin(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        // ********** Page Instantiations **********
        //HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPin = new PinScreen(driver);
        MenuScreen myMenuScreen = new MenuScreen(driver);
        BaseDriver myBaseDriver = new BaseDriver();

        String deviceName;
        Boolean pinCheck = false;
        String pageSource;
        int myCounter = 1;


        Thread.sleep(4000);

        while (!pinCheck) {
            LOGGER.info("Check for non leader PIN prompt");
            nonLeaderPinCheck();

            LOGGER.info("Dismiss Whats New Page");
            dismissWhatsNewPage();

            LOGGER.info("Check for PIN or Touch ID");
            pageSource = myBasePage.getSourceOfPage();
            if (pageSource.contains("Choose your PIN")) {
                pinCheck = true;
            }
            if (pageSource.contains("Would you like to use")) {
                pinCheck = true;
//                System.out.println(myBasePage.getSourceOfPage());
                myPin.pinDisableTouchID.click();
                Thread.sleep(1000);
                myBasePage.waitForElementThenClick(myPin.alertOK);
//                myPin.alertOK.click();
            }

            if (myCounter >= 3) {
                pinCheck = true;
            }
            myCounter++;
        }



        //Android needs this.
//        LOGGER.info("Check for MORE Alerts after whats new page");
//        checkForAlertsAfterPin();

        Thread.sleep(2000);

        pressPinKeys(firstNumber);
        pressPinKeys(secondNumber);
        pressPinKeys(thirdNumber);
        pressPinKeys(fourthNumber);

        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myPin.pinKeyEnter.click();
        }

        Thread.sleep(2000);

        pressPinKeys(firstNumber);
        pressPinKeys(secondNumber);
        pressPinKeys(thirdNumber);
        pressPinKeys(fourthNumber);

        Thread.sleep(2000);

        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myPin.pinKeyEnter.click();
        }





        //Sometimes there is a warning before the Whats new screen
        LOGGER.info("Check for Alerts AFTER PIN");
        if (!myBasePage.getOS().equalsIgnoreCase("ios")) {
//            //Android needs this.
//            checkForAlertsAfterPin();
            Thread.sleep(2000);
//
//            //Android needs this.
            dismissWhatsNewPage();
//
//            //Android needs this.
//            checkForAlertsAfterPin();
        }

        //iOS may need this.
        dismissWhatsNewPage();





//        // Click on Later then Directory
//        if (!myBasePage.getOS().equals("ios")) {
////            Thread.sleep(2000);
////            checkForLater();
//            Thread.sleep(500);
//
//            //Todo: may not need this anymore
//            if (!myBasePage.checkForElement(myMenuScreen.directory)) {
//                myMenuScreen.drawerButton.click();
//            }
//            myBasePage.waitForElement(myMenuScreen.directory);
//            myMenuScreen.organizations.click();
//            Thread.sleep(1000);
//            myMenuScreen.selectMenu(myMenuScreen.directory);
//            Thread.sleep(2000);
//        }

    }

    public void changePIN(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) throws Exception {
        // ********** Page Instantiations **********
        //HelperMethods myHelper = new HelperMethods(driver);
//        PinScreen myPin = new PinScreen(driver);
//        MenuScreen myMenuScreen = new MenuScreen(driver);

        Thread.sleep(4000);
        checkForAlertsBeforePin();


        Thread.sleep(2000);

        pressPinKeys(firstNumber);
        pressPinKeys(secondNumber);
        pressPinKeys(thirdNumber);
        pressPinKeys(fourthNumber);

        Thread.sleep(2000);

        pressPinKeys(firstNumber);
        pressPinKeys(secondNumber);
        pressPinKeys(thirdNumber);
        pressPinKeys(fourthNumber);

        Thread.sleep(2000);


    }



    public void nonLeaderNoPin() throws Exception {
        // ********** Page Instantiations **********
        //HelperMethods myHelper = new HelperMethods(driver);
        PinScreen myPin = new PinScreen(driver);
        MenuScreen myMenuScreen = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        Thread.sleep(4000);
//        checkForAlertsBeforePin();

        //Android needs this.
        if (!myBasePage.getOS().equals("ios")) {
            checkForAlertsAfterPin();
        }

        dismissWhatsNewPage();

//        //Sometimes there is a warning before the Whats new screen
//        checkForAlertsAfterPin();


        Thread.sleep(2000);
        myPin.pinAlertDialogNotNow.click();


        Thread.sleep(2000);

        //Sometimes there is a warning before the Whats new screen
        checkForAlertsAfterPin();

        Thread.sleep(2000);

        dismissWhatsNewPage();

        checkForAlertsAfterPin();



        // Click on Later then Directory
        if (!myBasePage.getOS().equals("ios")) {
            Thread.sleep(2000);
            checkForLater();
            Thread.sleep(2000);
            myMenuScreen.directory.click();
            Thread.sleep(2000);
        }
    }

    public void enterPinKeepWhatsNew(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) throws Exception {
        // ********** Page Instantiations **********
        PinScreen myPin = new PinScreen(driver);
        BaseDriver myBaseDriver = new BaseDriver();
        BasePage myBasePage = new BasePage(driver);

        Thread.sleep(4000);

        System.out.println("Check for Alerts Before PIN");
        checkForAlertsBeforePin();

        //Android needs this.
        System.out.println("Check for MORE Alerts after whats new page");
        checkForAlertsAfterPin();

        Thread.sleep(2000);

        pressPinKeys(firstNumber);
        pressPinKeys(secondNumber);
        pressPinKeys(thirdNumber);
        pressPinKeys(fourthNumber);

        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myPin.pinKeyEnter.click();
        }

        Thread.sleep(2000);

        pressPinKeys(firstNumber);
        pressPinKeys(secondNumber);
        pressPinKeys(thirdNumber);
        pressPinKeys(fourthNumber);

        Thread.sleep(2000);

        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myPin.pinKeyEnter.click();
        }


//        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
//            Thread.sleep(2000);
//
//            pressPinKeys(firstNumber);
//            pressPinKeys(secondNumber);
//            pressPinKeys(thirdNumber);
//            pressPinKeys(fourthNumber);
//
//            Thread.sleep(2000);
//
//            pressPinKeys(firstNumber);
//            pressPinKeys(secondNumber);
//            pressPinKeys(thirdNumber);
//            pressPinKeys(fourthNumber);
//
//            Thread.sleep(2000);
//        } else {
//            Thread.sleep(4000);
//            System.out.println("Enter PIN!!!");
//            deviceName = driver.get().getCapabilities().getCapability("deviceName").toString();
//            myBaseDriver.adbEnterPIN(deviceName);
//
//
//        }
    }

    public void checkForLater() {
        MenuScreen myMenuScreen = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        if (myBasePage.checkForElement(myMenuScreen.laterButton)) {
            myMenuScreen.laterButton.click();
        }
    }

    public void enterCurrentPin(String firstNumber, String secondNumber, String thirdNumber, String fourthNumber) throws Exception {

        pressPinKeys(firstNumber);
        pressPinKeys(secondNumber);
        pressPinKeys(thirdNumber);
        pressPinKeys(fourthNumber);

        Thread.sleep(2000);

    }

    public void whatsNewPressDone() {
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        myWhatsNew.whatsNewDone.click();

        if(myBasePage.getOS().equals("android")) {
            myMenu.laterButton.click();
        }
        myMenu.directory.click();
    }


    public void pressPinKeys(String keyNumber) {
        PinScreen myPin = new PinScreen(driver);
        switch (keyNumber) {
            case "1" :
                myPin.pinKey1.click();
                break;
            case "2" :
                myPin.pinKey2.click();
                break;
            case "3" :
                myPin.pinKey3.click();
                break;
            case "4" :
                myPin.pinKey4.click();
                break;
            case "5" :
                myPin.pinKey5.click();
                break;
            case "6" :
                myPin.pinKey6.click();
                break;
            case "7" :
                myPin.pinKey7.click();
                break;
            case "8" :
                myPin.pinKey8.click();
                break;
            case "9" :
                myPin.pinKey9.click();
                break;
            case "0" :
                myPin.pinKey0.click();
                break;
            case "Delete" :
                myPin.pinKeyDelete.click();
                break;
        }
    }


    public void runSync() throws Exception {
        // ********* Constructor **********
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        SyncScreen mySyncScreen = new SyncScreen(driver);


        if (myBasePage.getOS().equals("ios")) {
            myMenu.moreButton.click();

            //Check to see if the sync page is displayed
            if (myBasePage.checkTextOnPage("Sync Now")) {
                myBasePage.backButton.click();
            }

            if (myBasePage.checkTextOnPage("Update")) {
                mySyncScreen.updateButton.click();
            } else {
                mySyncScreen.syncButton.click();
            }

            //This will probably change
            Thread.sleep(1000);
            mySyncScreen.syncNowButton.click();
            Thread.sleep(3000);

            //waitForTextToDisappear("DownloadingSync", 500 );
            //waitForTextToDisappear("connection", 500 );
            myBasePage.waitUnitlTextIsGone("UAT");

            Thread.sleep(4000);

            if (myBasePage.checkTextOnPage("Enter Current Passcode")) {

                System.out.println("Enter Current Passcode Found!");
                enterCurrentPin("1", "1", "3", "3");
            }


        } else {
            myMenu.drawerButton.click();
            if (myBasePage.checkTextOnPage("Later")) {
                myMenu.laterButton.click();
            }
            myBasePage.scrollToTextNavMenu("Sync");

            Thread.sleep(4000);
            if (myBasePage.checkForElement(myBasePage.alertOK)) {
                myBasePage.alertOK.click();
            }


            Thread.sleep(4000);
            myBasePage.waitUnitlTextIsGone("UAT");
            Thread.sleep(4000);
        }

        if (myBasePage.checkForAlert()) {
            myBasePage.alertOK.click();
        }

    }

    public void dismissWhatsNewPage() throws Exception {
        // ********* Constructor **********
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        BasePage myBasePage = new BasePage(driver);
//        ScannerScreen myScanner = new ScannerScreen(driver);

        //Check for Whats New Page
//      if (myBasePage.checkForElement(myWhatsNew.whatsNewDone)) {
        if (myBasePage.checkElementExists("Done") || (myBasePage.checkElementExists("DONE")) ){
//            System.out.println(myBasePage.getSourceOfPage());
            myBasePage.waitForElementThenClick(myWhatsNew.whatsNewDone);
//            myWhatsNew.whatsNewDone.click();
            if (!myBasePage.getOS().equals("ios")) {
                if (myBasePage.checkForElement(myBasePage.allowButton)) {
                    myBasePage.allowButton.click();
                    myBasePage.allowButton.click();
                    if (myBasePage.checkForElement(myBasePage.allowButton)) {
                        myBasePage.allowButton.click();
                    }

                }
            }
        }

    }


    private void checkForAlertsBeforePinTEST() throws Exception {
        ScannerScreen myScanner = new ScannerScreen(driver) ;
        PinScreen myPin = new PinScreen(driver);
//        BasePage myBase = new BasePage(driver);

        Boolean myCheck = false;


        List<Element> myUsableElements = new ArrayList<Element>();


        //System.out.println(myBase.getSourceOfPage());
        myUsableElements = myScanner.getClickableElements();
        //myCheck = myScanner.checkForElementsTEST("md_buttonDefaultPositive");
        myCheck = myScanner.quickCheckForElements(myUsableElements, "md_buttonDefaultPositive");
        if (myCheck) {
            myPin.pinAlertDialogOK.click();
            myUsableElements = myScanner.getClickableElements();
        }

        myCheck = myScanner.quickCheckForElements(myUsableElements, "OK");
        if (myCheck) {
            myPin.pinAlertDialogOK.click();
            myUsableElements = myScanner.getClickableElements();
        }

        myCheck = myScanner.quickCheckForElements(myUsableElements, "md_buttonDefaultPositive");
        if (myCheck) {
            myPin.pinAlertDialogYes.click();
            myUsableElements = myScanner.getClickableElements();
        }

        myCheck = myScanner.quickCheckForElements(myUsableElements, "Yes");
        if (myCheck) {
            myPin.pinAlertDialogYes.click();
            myUsableElements = myScanner.getClickableElements();
        }

        System.out.println("Checking for Face ID");
        myCheck = myScanner.quickCheckForElements(myUsableElements, "Face ID");
        if (myCheck) {
            System.out.println("Face ID found hitting disable");
            myPin.pinDisableFaceID.click();
            Thread.sleep(2000);
            myPin.pinAlertDialogOK.click();
            myUsableElements = myScanner.getClickableElements();
        }

        System.out.println("Checking for Touch ID");
        myCheck = myScanner.quickCheckForElements(myUsableElements, "Touch ID");
        if (myCheck) {
            System.out.println("Enable Touch ID Button found, hitting the button");
            myPin.pinDisableTouchID.click();
            Thread.sleep(2000);
            myPin.pinAlertDialogOK.click();
        }


    }

    public void nonLeaderPinCheck() throws Exception {
        PinScreen myPin = new PinScreen(driver);
        BasePage myBase = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);

        Boolean myCheck = false;
        String pageSource;

        pageSource = myBase.getSourceOfPage();

        Assert.assertFalse(pageSource.contains("Member Tools Services are unavailable."));

        myCheck = pageSource.contains("Member Tools Passcode");
        if (myCheck) {
            myPin.pinAlertDialogYes.click();
        }
    }

    public void checkForAlertsBeforePin() throws Exception {
        PinScreen myPin = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);

        Boolean myCheck = false;
        String pageSource;

        pageSource = myBasePage.getSourceOfPage();

        Assert.assertFalse(pageSource.contains("Member Tools Services are unavailable."));

//        myCheck = myBase.checkElementExists("OK");
        myCheck = pageSource.contains("OK");
//        System.out.println(pageSource);
        if (myCheck) {
            myPin.pinAlertDialogOK.click();
            pageSource = myBasePage.getSourceOfPage();
        }

//        myCheck = myBase.checkElementExists("Yes");
        myCheck = pageSource.contains("Yes");
        if (myCheck) {
            myPin.pinAlertDialogYes.click();
            pageSource = myBasePage.getSourceOfPage();
        }

        System.out.println("Checking for Face ID");
//        myCheck = myBase.checkElementExists("Disable Face ID");
        myCheck = pageSource.contains("Disable Face ID");
        if (myCheck) {
            System.out.println("Face ID found hitting disable");
            myPin.pinDisableFaceID.click();
            Thread.sleep(2000);
            myPin.pinAlertDialogOK.click();
            pageSource = myBasePage.getSourceOfPage();
        }

        System.out.println("Checking for Touch ID");
//        myCheck = myBase.checkElementExists("Disable Touch ID");
//        myCheck = pageSource.contains("Disable Touch ID");
        myCheck = pageSource.contains("Disable Security");
//        if (myBasePage.checkForElement(myWhatsNew.usePassword)) //Samsung phones need this
//            myWhatsNew.usePassword.click();

        if (myCheck) {
            System.out.println("Enable Touch ID Button found, hitting the button");
            myPin.pinDisableTouchID.click();
            Thread.sleep(2000);
            myPin.pinAlertDialogOK.click();
        }


    }


    public void checkForAlertsAfterPin() throws Exception {
        PinScreen myPin = new PinScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        String pageSource;
        Boolean myCheck = false;

        pageSource = myBasePage.getSourceOfPage();

        myCheck = pageSource.contains("OK");
        if (myCheck) {
            myPin.pinAlertDialogOK.click();
            pageSource = myBasePage.getSourceOfPage();
        }

        myCheck = pageSource.contains("Yes");
        if (myCheck) {
            myPin.pinAlertDialogYes.click();
            pageSource = myBasePage.getSourceOfPage();
        }

        if (!myBasePage.getOS().equalsIgnoreCase("ios")) {
//            myCheck = pageSource.contains("Allow");
            myCheck = myBasePage.checkForElement(myPin.pinAlertDialogAllow);
            if (myCheck) {
                myPin.pinAlertDialogAllow.click();
                pageSource = myBasePage.getSourceOfPage();
            }

            myCheck = myBasePage.checkForElement(myPin.pinAlertDialogAllow);
            if (myCheck) {
                myPin.pinAlertDialogAllow.click();
            }

        }

    }



    public void uatInvalidLogin(String userName, String password) throws Exception {
        //Enable Developer Settings and set the Network Environment to UAT
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String myTemp = "mbthomas74";

        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }

        setupUAT(myTemp);

        myLoginPage.loginName.clear();
        myLoginPage.passWord.clear();

        myLoginPage.loginName.sendKeys(userName);
        myLoginPage.passWord.sendKeys(password);
        myLoginPage.signInButton.click();
        Thread.sleep(1000);
    }


    public String[] getMemberNameFromList(String memberCalling, String unit) throws Exception {
        String calling = null;
        String loginName = null;
        String rights = null;
        String[] membersArray = new String[0];
        memberCalling = memberCalling + ",";
        List<String> fileList = openCallingsMembersFile(unit);
        for (String callingLine : fileList) {
            if (callingLine.contains(memberCalling)) {
                membersArray = callingLine.split(",");
                calling = membersArray[0];
                loginName = membersArray[1];
                rights = membersArray[2];

                LOGGER.info("Calling: " + calling);
                LOGGER.info("Login Name: " + loginName);
                LOGGER.info("rights: " + rights);
                memberLogin = loginName;
            }
        }

        return membersArray;
    }
    

    public List<String> openCallingsMembersFile(String unit) throws Exception {
        List<String> memberList = new ArrayList<>();
        //Default if unit is not found
        Scanner sc = new Scanner(new File("src/main/java/LDSToolsAppium/callings_members.csv"));

        if (unit.equalsIgnoreCase("Centinela 1st")) {
            sc = new Scanner(new File("src/main/java/LDSToolsAppium/Units/callings_members_Centinela1st.csv"));
            unitNumber = "21628";
        }

        if (unit.equalsIgnoreCase("Auburn Hills")) {
            sc = new Scanner(new File("src/main/java/LDSToolsAppium/Units/callings_members_AuburnHills.csv"));
            unitNumber = "111074";
        }

        if (unit.equalsIgnoreCase("Maplewood 2nd")) {
            sc = new Scanner(new File("src/main/java/LDSToolsAppium/Units/callings_members_Maplewood2nd.csv"));
            unitNumber = "39373";
        }


        while (sc.hasNext()) {
            memberList.add(sc.nextLine());
//            System.out.println(sc.next());
        }
        
        sc.close();
        return memberList;
    }



}
