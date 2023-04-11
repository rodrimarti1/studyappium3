package LDSToolsAppium;

import LDSToolsAppium.Screen.HelpScreen;
import LDSToolsAppium.Screen.LoginPageScreen;
import LDSToolsAppium.Screen.MenuScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import io.cucumber.testng.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.logging.*;
import org.picocontainer.classname.ClassName;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;


@CucumberOptions()
public class BaseDriver extends AbstractTestNGCucumberTests {
//    public static AppiumDriver<WebElement> driver;
    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

    public static AppiumDriver driver2;
    public String deviceSerial = "";
    public String testOS = "";
    public String testngTestDevice = "";
    public int testngStartSleepTime = 200;

    public AppiumService myAppiumService = new AppiumService();

    public TestNGCucumberRunner testNGCucumberRunner;
    
    protected LDSToolsApp app;
    protected MobileDevApp app2;

    public String myAppPackage;

    public String accessToken = "5b5e50c533cf4e00aa32c8caf1aa1d8fad972f9414a64f71abdce9d06d6a5248";
    public String stfURL = "http://10.109.45.146:7100";
    public String testDevice = "";

    public String memberLogin = "dsoneil";
    public String unitNumber = "39373";

    public String androidAppPackage = "org.lds.ldstools.alpha";

    public ThreadLocal<String> dataTestName = new ThreadLocal<>();

    static AppiumDriver getDriver() {
        return driver.get();
    }


    @BeforeSuite(alwaysRun = true)
    public void removeFilesBeforeTest() throws Exception {
        //Turn off logging
//        LogManager.getLogManager().reset();
//        LOGGER.severe("Severe Message");
//        LOGGER.warning("Warning Message");
//        LOGGER.info("Info Message");
//        LOGGER.config("Config Message");
//        LOGGER.fine("Fine Message");
//        LOGGER.finer("Finer Message");
//        LOGGER.finest("Finest Message");
        LOGGER.info("Killing all appium nodes");
        killProcess("main.js");

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//        File reportsDirectory = new File ("/Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports");
//        File screenshotDirectory = new File ("/Users/zmaxfield/Documents/workspace/qa-membertools-all/screenshot");

        File reportsDirectory = new File ("src/test/java/Reports");
        File screenshotDirectory = new File ("screenshot");
        File configFiles = new File ("ConfigFiles");

        Path reportsAndroidDirectory = Paths.get("src/test/java/Reports/Android");
        Path reportsiOSDirectory = Paths.get("src/test/java/Reports/iOS");

        LOGGER.info("LOGGER: Start clean directories");
        System.out.println("Start clean directories");
        try {
            FileUtils.cleanDirectory(reportsDirectory);
            FileUtils.cleanDirectory(screenshotDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File[] configFileList = configFiles.listFiles();

        if (configFileList != null) {
            for (File oneFile : configFileList ) {
                if (oneFile.getName().endsWith(".json")) {
                    oneFile.delete();
                }
            }
        }
        Files.createDirectories(reportsAndroidDirectory);
        Files.createDirectories(reportsiOSDirectory);

    }

    //    @BeforeTest(alwaysRun = true)
    @BeforeClass(alwaysRun = true)
    @Parameters({"os", "fileName", "testDevice", "startSleepTime", "systemPort"})
    public void setUp(String os, String fileName, String testDevice, int startSleepTime, int systemPort) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        int myPort;
        testOS = os;
        testngTestDevice = testDevice;
        testngStartSleepTime = startSleepTime;



        System.out.println("Start of Setup");
//        //Sleep so when multiple tests start they don't break
//        System.out.println("Sleep Time: " + startSleepTime);
//        System.out.println("File Name: " + fileName);
//        System.out.println("Test Device: " + testDevice);
//        System.out.println("Test Device2: " + testngTestDevice);
        Thread.sleep(startSleepTime);

        //Get Random Port Number
        myPort = getRandomPort(4500, 4999);


        //System.out.println("OS: " + os);
        //System.out.println("Port: " + myPort);
        //Start Appium Server for iOS or Android with the Random Port
        //myAppiumService.startAppiumService(os, myPort);
//        AppiumService.startAppiumService(os, myPort);
        AppiumService.startAppiumService(testOS, myPort);


        //AppiumService.startAppiumService(os, myPort);


        if (fileName.contains("android-mobile-dev")) {
//            System.out.println("File Name: " + fileName);
//            driver2 = appiumCapabilities(os, fileName, testDevice, myPort);
            app2 = new MobileDevApp(driver2);
        } else {
//            driver = appiumCapabilities(os, fileName, testDevice, myPort);
            appiumCapabilities(os, fileName, testDevice, myPort, systemPort);
            app = new LDSToolsApp(driver);
        }

        System.out.println("End of Setup");
        
    }

//    @BeforeMethod(alwaysRun = true)
//    public void BeforeMethodTestName (Method method, Object[] testData, ITestContext ctx) {
//        if (testData.length > 0) {
//            dataTestName.set(method.getName() + "_" + testData[3]);
//            ctx.setAttribute("testName", dataTestName.get());
////            ctx.setAttribute("name", dataTestName.get());
////            System.out.println(Arrays.toString(ctx.getAttributeNames().toArray()));
//        } else {
//            ctx.setAttribute("testName", method.getName());
//        }
//
//    }

//    @Override
//    public String getTestName() {
//        return dataTestName.get();
//
//    }


    @DataProvider(name = "Members")
    public Iterator<Object []> provider(ITestContext context) throws InterruptedException {
        String myGroup;
        String myFileName = "src/main/java/LDSToolsAppium/membersOne.csv";
        List<String> includedGroups = Arrays.asList(context.getIncludedGroups());
        myGroup = includedGroups.toString();
        System.out.println("GROUP: " + myGroup);
        if (myGroup.contains("smoke")) {
            System.out.println("Found smoke ");
            myFileName = "src/main/java/LDSToolsAppium/membersSmall.csv";
//            myFileName = "src/main/java/LDSToolsAppium/membersOne.csv";
        } else if (myGroup.contains("all")) {
            System.out.println("Found all ");
            myFileName = "src/main/java/LDSToolsAppium/members.csv";
        }



        //String myFileName = "src/main/java/LDSToolsAppium/membersOne.csv";
        BufferedReader br = null;
        String line;
        String splitBy = ",";
        String[] data = null;
        List<Object []> testCases = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(myFileName));
            while ((line = br.readLine()) != null) {
                data = line.split(splitBy);
                testCases.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testCases.iterator();
    }

    @DataProvider(name = "Header")
    public Iterator<Object []> providerHeader(ITestContext context) throws InterruptedException {
        String myFileName = "src/main/java/LDSToolsAppium/header.csv";

        BufferedReader br = null;
        String line;
        String splitBy = ",";
        String[] data = null;
        List<Object []> testCases = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(myFileName));
            while ((line = br.readLine()) != null) {
                data = line.split(splitBy);
                testCases.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testCases.iterator();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        String testName;

        System.out.println("After Method - Start teardown");
        // Here will compare if test is failing then only it will enter into if condition
        if(ITestResult.FAILURE==result.getStatus()) {
            //printPageSource();
            testName = result.getName();
            //System.out.println("getName " + result.getName());



            screenshotAndLogs(testName);


        }

        //Trying to figure out why my tests are getting skipped.
        if (ITestResult.SKIP==result.getStatus()) {
            Throwable t = result.getThrowable();
            t.printStackTrace();

        }

        if(getRunningOS().equals("ios")) {

            Thread.sleep(4000);
            System.out.println("Start Reset App");
//            driver.removeApp("org.lds.ldstools");
////            driver.installApp(driver.getCapabilities().getCapability("app").toString());
//            driver.launchApp();

//            getDriver().resetApp();
//            driver.resetApp();

            Map<String, Object> myArgs = new HashMap<>();
            myArgs.put("bundleId", myAppPackage);
            driver.get().executeScript("mobile: removeApp", myArgs);
            Map<String, String> installArgs = new HashMap<>();
            installArgs.put("app", driver.get().getCapabilities().getCapability("app").toString());
            driver.get().executeScript("mobile: installApp", installArgs);
            driver.get().executeScript("mobile: launchApp", myArgs);


//            myMenu.menuLogOut();

            System.out.println("End Reset App");
            Thread.sleep(5000);

            if (myBasePage.checkForElement(myBasePage.allowWhileUsingApp)) {
                myBasePage.allowWhileUsingApp.click();
                Thread.sleep(500);
            }

            if (myBasePage.checkForElement(myBasePage.allowButton)) {
                myBasePage.allowButton.click();
            }

        } else {
            Thread.sleep(2000);
            System.out.println("Rest App");

            //Not the best way to do this but Appium changed stuff and reset doesn't work anymore.
//            myMenu.menuLogOut();

            Map<String, Object> myArgs = new HashMap<>();
            myArgs.put("appId", myAppPackage);
            driver.get().executeScript("mobile: clearApp", myArgs);


            Map<String, String> installArgs = new HashMap<>();
            installArgs.put("appId", myAppPackage);
//            installArgs.put("intent", driver.get().getCapabilities().getCapability("appWaitActivity").toString());
            installArgs.put("intent", "org.lds.ldstools.alpha/org.lds.ldstools.ux.main.MainActivity");
            driver.get().executeScript("mobile: startActivity", installArgs);



//            driver.get().executeScript("mobile: launchApp");
//            getDriver().resetApp();

//            getDriver().quit();
//            getDriver().resetApp();
//            System.out.println("Clear App");
//            adbCommand("clearApp");
//            Thread.sleep(5000);
//            getDriver().launchApp();
//            getDriver().resetApp();
            Thread.sleep(5000);
            System.out.println("SERIAL NUMBER: " + deviceSerial);
        }

//        System.out.println("Check to see if web is running");
//        if (myWeb.isRunning() == null) {
//            System.out.println("Web is not running!");
//        } else {
//            myWeb.tearDown();
//        }


        System.out.println("End teardown");
    }

//    @AfterClass(alwaysRun = true)
//    public void afterClass() throws Exception {
//        if (!getRunningOS().equals("ios")) {
//            driver.quit();
//            if (!deviceSerial.equals("")) {
//
//                STFService mySTFService = new STFService(stfURL, accessToken);
//                DeviceApi myDevice = new DeviceApi(mySTFService);
//                System.out.println("After Class - SERIAL NUMBER: " + deviceSerial);
//                myDevice.releaseDevice(deviceSerial);
//                Thread.sleep(3000);
//                adbRemoteDisconnect(testDevice);
//                myDevice.releaseDevice(deviceSerial);
//
//            }
//        }
//    }



    @AfterSuite(alwaysRun = true)
    public void afterAllTests() throws Exception {
        System.out.println("After Suite - Stopping the driver");
        if (getRunningOS().equals("android")) {
            STFService mySTFService = new STFService(stfURL, accessToken);
            DeviceApi myDevice = new DeviceApi(mySTFService);

            System.out.println("After All Tests - SERIAL NUMBER: " + deviceSerial);
            if (!deviceSerial.isEmpty()) {

                System.out.println("After All Tests - SERIAL NUMBER: " + deviceSerial);
                adbUninstallChurchMobileDev();
                myDevice.releaseDevice(deviceSerial);
                Thread.sleep(3000);
                killProcess("adb");
                myDevice.releaseDevice(deviceSerial);

            }
        }

        System.out.println("Stopping the Appium Service");
        myAppiumService.stopAppiumService();

        Thread.sleep(1000);

    }

//    private AppiumDriver<WebElement> appiumCapabilities(String os, String fileName, String testDevice, int myPort) throws Exception {
    private void appiumCapabilities(String os, String fileName, String testDevice, int myPort, int systemPort) throws Exception {
//        String myAppPackage;
        String myUdid = null;
        int mySystemPort;

        //Android Setup
        if (os.equals("android")) {
            List<String> deviceList;

//            if (testDevice.contains("STFZade")) {
//                accessToken = "c6c814d0122047ab98c2af2a84eb09022a3dd0e82e944526896e9016eb121844";
//                stfURL = "http://10.109.45.162:7100";
//            }
//
//            if (testDevice.contains("STFMain")) {
//                accessToken = "7a51e3b2af8d4cdca761035facd677569b8c3fa4f04f491ca3ed7591372361c1";
//                stfURL = "https://serenity.ldschurch.org";
//            }





            if (testDevice.contains("STF")) {
                accessToken = "8f12579578684a2ba0ebdae08c1800c20c6c5b591c49433884200657ca59fd69";
                stfURL = "https://stf.churchofjesuschrist.org/";

                String deviceIPPort;


                String[] parts = testDevice.split("-");
               // String part1 = parts[0];


                deviceSerial = parts[1];
                System.out.println("SERIAL NUMBER: " + deviceSerial);

                LDSToolsAppium.STFService mySTFService = new LDSToolsAppium.STFService(stfURL, accessToken);
                LDSToolsAppium.DeviceApi myDevice = new LDSToolsAppium.DeviceApi(mySTFService);


                if (deviceSerial.equals("Pool")) {

                    deviceList = myDevice.getAvalibleDevices();
                    deviceSerial = deviceList.get(new Random().nextInt(deviceList.size()));
                    System.out.println("DEVICE TO USE: " + deviceSerial);
                    deviceSerial = deviceSerial.replace("\"", "");
                    System.out.println("SERIAL NUMBER: " + deviceSerial);
                }


                myDevice.connectDevice(deviceSerial);
                deviceIPPort = myDevice.remoteControl(deviceSerial);
                testDevice = getRemoteIPPort(deviceIPPort);

                //Need to do this twice the first one lies and says it failed.
                adbRemoteConnect(testDevice);
                adbRemoteConnect(testDevice);

                adbInstallChurchMobileDev();
                adbStartChurchMobileDev();

            }

            if (testDevice.contains("WIRELESS")) {

                String deviceIPPort;


                String[] parts = testDevice.split("-");
                // String part1 = parts[0];


                deviceSerial = parts[1];
                System.out.println("SERIAL NUMBER: " + deviceSerial);
                testDevice = deviceSerial;

                adbRemoteConnect(testDevice);
            }



            mySystemPort = systemPort;
            mySystemPort = getRandomPort(8500, 8999);

            // set up appium
            File classpathRoot = new File(System.getProperty("user.dir"));
//            File appDir = new File(classpathRoot, "../../../Selenium");
            File appDir = new File(classpathRoot, "/AppUnderTest");
            File app = new File(appDir, fileName);

            DesiredCapabilities capabilities = new DesiredCapabilities();

            if (testDevice.contains("HEADLESS")) {
                String[] parts = testDevice.split(",");
                //String part1 = parts[0];
                //Remove all whitespace
                //part1 = part1.trim();
                //part2 = part2.trim();
                testDevice = parts[1];
                capabilities.setCapability("isHeadless", true);
            }

//            System.out.println("TEST DEVICE: " + testDevice);

            capabilities.setCapability("app", app.getAbsolutePath());
            myAppPackage = "org.lds.ldstools.alpha";


//            if (fileName.contains("android-mobile-dev")) {
//                capabilities.setCapability("appPackage", "org.lds.dev"); // *** ALPHA ***
//                myAppPackage = "org.lds.dev";
//            } else {
//                if (fileName.contains("master")) {
//                    capabilities.setCapability("appPackage", "org.lds.ldstools.alpha"); // *** ALPHA ***
////                    capabilities.setCapability("appPackage", "io.appium.espressoserver.test"); // *** ALPHA ***
//                    myAppPackage = "org.lds.ldstools.alpha";
//                } else {
//                    capabilities.setCapability("appPackage", "org.lds.ldstools"); //*** BETA and RELEASE ***
//                    myAppPackage = "org.lds.ldstools";
//                }
//            }

//            capabilities.setCapability("appPackage", "io.appium.espressoserver.test"); // *** ALPHA ***
//            myAppPackage = "org.lds.ldstools.alpha";

            androidAppPackage = myAppPackage;

            capabilities.setCapability("deviceName", testDevice);
            capabilities.setCapability("udid", testDevice);
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("automationName","uiautomator2");
            capabilities.setCapability("noSign", true);
//            capabilities.setCapability("automationName","espresso");
//            capabilities.setCapability("forceEspressoRebuild",true);
//            capabilities.setCapability("espressoServerLaunchTimeout",500000);
//            capabilities.setCapability("espressoBuildConfig","/Users/zmaxfield/Documents/workspace/qa-membertools-all/AppUnderTest/espressConfig.json");

            capabilities.setCapability("fullReset", false);
//            capabilities.setCapability("autoLaunch", false);
//            capabilities.setCapability("noReset", false);
//            capabilities.setCapability("appPackage", myAppPackage);
            capabilities.setCapability("newCommandTimeout", 5000);


//            capabilities.setCapability("appWaitActivity", "org.lds.ldstools.ux.auth.AuthenticationSignInActivity");
            capabilities.setCapability("appWaitActivity", "org.lds.ldstools.ux.auth.SignInActivity");

//            capabilities.setCapability("appWaitActivity", "org.lds.ldstools.ux.main.MainActivity");
            capabilities.setCapability("appWaitDuration", 300000);
//            capabilities.setCapability("normalizeTagNames", true);

            capabilities.setCapability("deviceReadyTimeout", 60);

//            capabilities.setCapability("gpsEnabled", true);



            capabilities.setCapability("appium:dontStopAppOnReset", true);


            capabilities.setCapability("appium:clearDeviceLogsOnStart", true);

//            capabilities.setCapability("appium:unlockType", "pin");
//            capabilities.setCapability("appium:unlockKey", "1133");

//            capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
//            capabilities.setCapability("maxTypingFrequency", "8");
//            capabilities.setCapability("appActivity", "org.lds.ldstools.alpha.org.lds.ldstools.ui.activity.StartupActivity");
            capabilities.setCapability("androidInstallTimeout", 90000);

            capabilities.setCapability("unicodeKeyboard", true);
            capabilities.setCapability("resetKeyboard", true);

            capabilities.setCapability("systemPort", mySystemPort);


//            driver.set(new AndroidDriver(new URL("http://127.0.0.1:" + myPort + "/"), capabilities));
            driver.set(new AndroidDriver(new URL("http://127.0.0.1:" + myPort + "/wd/hub"), capabilities));
//            driver.set(new AndroidDriver(new URL("http://127.0.0.1:" + myPort ), capabilities));

            Thread.sleep(2000);

        }

        //Setup for iOS
        if (os.equals("ios")) {
            //String webDriverURL = "http://localhost:";
            //String webDriverPort;
            int tempPort;

            tempPort = myPort + 1000;
            tempPort = getRandomPort(8500, 8999);
            //webDriverPort = String.valueOf(tempPort);
            //webDriverURL = webDriverURL + webDriverPort;

            if (testDevice.contains("REAL")) {

                String[] parts = testDevice.split("-");
               // String part1 = parts[0];

                testDevice = parts[1];
                System.out.println("TEST DEVICE: " + testDevice);

                myUdid = getUDIDfromDeviceName(testDevice);


                //myUdid = deviceUDID();
            }

            if (testDevice.contains("FBSIM")) {

                String[] parts = testDevice.split("-");
                //String part1 = parts[0];
                //Remove all whitespace
                //part1 = part1.trim();
                //part2 = part2.trim();

                testDevice = parts[1];

                myUdid = getUDIDfromDeviceNameFBSIM(testDevice);

                System.out.println("MY UDID: " + myUdid);

                //Start Simulator
                startFbSim(myUdid, tempPort);

                //Just a test
                Thread.sleep(6000);

            }

            DesiredCapabilities capabilities = new DesiredCapabilities();

            if (testDevice.contains("HEADLESS")) {
                String[] parts = testDevice.split("-");
                //String part1 = parts[0];
                //Remove all whitespace
                //part1 = part1.trim();
                //part2 = part2.trim();
                testDevice = parts[1];
                capabilities.setCapability("isHeadless", true);
            }

            System.out.println("Device Name: " + testDevice + " UDID: " + myUdid);


            // set up appium
            File classpathRoot = new File(System.getProperty("user.dir"));
//            File appDir = new File(classpathRoot, "../../../Selenium");
            File appDir = new File(classpathRoot, "/AppUnderTest");
            File app = new File(appDir, fileName);
            myAppPackage = "org.lds.ldstools";
            


            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "Safari");
            capabilities.setCapability("appium:deviceName",testDevice);
            capabilities.setCapability("appium:automationName","XCUITest");
            capabilities.setCapability("browserName","");

            capabilities.setCapability("appium:noReset", false);
            capabilities.setCapability("appium:newCommandTimeout", 90);
            capabilities.setCapability("appium:app", app.getAbsolutePath());
            capabilities.setCapability("launchTimeout", 900000);
            capabilities.setCapability("appium:platformVersion", "16.4");
            capabilities.setCapability("nativeInstrumentsLib", false);
            capabilities.setCapability("appium:clearSystemFiles", true);
            //capabilities.setCapability("allowTouchIdEnroll", true);
            capabilities.setCapability("appium:maxTypingFrequency", 20);
//            capabilities.setCapability("sendKeyStrategy", "grouped");

//            capabilities.setCapability("interKeyDelay", 50);
            //capabilities.setCapability("appPackage", myAppPackage);
            //capabilities.setCapability("simpleIsVisibleCheck", true);
//            capabilities.setCapability("connectHardwareKeyboard", false);
            capabilities.setCapability("appium:customSnapshotTimeout", 500);
            capabilities.setCapability("appium:snapshotMaxDepth", 100);
//            capabilities.setCapability("fullReset", true);
//            capabilities.setCapability("appium:resetLocationService", true);


//            capabilities.setCapability("wdaConnectionTimeout", 5000000);
//            capabilities.setCapability("appium:waitForQuiescence", false);

            capabilities.setCapability("appium:waitForQuiescence", false);


            //Change this to true for more debug
//            capabilities.setCapability("showIOSLog", true);



//            capabilities.setCapability("includeNonModalElements", true);
//            capabilities.setCapability("shouldUseTestManagerForVisibilityDetection", true);
//            capabilities.setCapability("simpleIsVisibleCheck", true);

            capabilities.setCapability("wdaLocalPort", tempPort);
            capabilities.setCapability("showXcodeLog", false);

//            capabilities.setCapability("appium:useNewWDA", true);

            //This is needed so HEADLESS will have a location set.
            capabilities.setCapability("locationServicesEnabled", true);
            capabilities.setCapability("locationServicesAuthorized", true);

            if (myUdid != null) {
                capabilities.setCapability("xcodeOrgId", "U3SP4KMCK6");
                capabilities.setCapability("xcodeSigningId", "iPhone Developer");
                capabilities.setCapability("udid", myUdid);
                capabilities.setCapability("wdaLocalPort", tempPort);
                capabilities.setCapability("appium:waitForQuiescence", false);
            }

            driver.set(new IOSDriver(new URL("http://127.0.0.1:" + myPort + "/wd/hub"),capabilities));
//            driver = new IOSDriver<>(new URL("http://127.0.0.1:" + myPort + "/wd/hub"),capabilities);
        }

//        return driver;
    }

    private int getRandomPort(int lowPort, int highPort) throws Exception {
        //System.out.println("OS: " + os );
        //System.out.println("File Name: " + fileName);
        //String myUdid = "";
        Random randomPort = new Random();
        int myPort;
//        int lowPort = 4500;
//        int highPort = 4999;
        //Random randomSleep = new Random();
        //int sleepTime = 1000;
        //int lowSleep = 1000;
        //int highSleep = 9999;

        Boolean portOpen;

        //Check to see if the random port is open
        //If the port is in use try a different port
        do {
            myPort = randomPort.nextInt(highPort - lowPort) + lowPort;
            portOpen = portCheck(myPort);
        } while (portOpen.equals(false));


        //System.out.println("OS: " + os);
        //System.out.println("PORT: " + myPort);

        return myPort;

    }

    private int getRandomPortSystemPort() throws Exception {
        Random randomPort = new Random();
        int myPort;
        int lowPort = 8201;
        int highPort = 8299;

        Boolean portOpen;

        //Check to see if the random port is open
        //If the port is in use try a different port
        do {
            myPort = randomPort.nextInt(highPort - lowPort) + lowPort;
            portOpen = portCheck(myPort);
        } while (portOpen.equals(false));

        return myPort;

    }


    private String getRemoteIPPort(String myText) {
        String myIPPort;
        System.out.println("MY PORT: " + myText);
        String[] ipArray = StringUtils.substringsBetween(myText, "\"", "\"");

        for (String getIP : ipArray) {
            System.out.println("GET IP: " + getIP);
        }

        myIPPort = ipArray[ipArray.length -1];

        return myIPPort;
    }

    private String getAndroidHomePath() throws Exception {
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[] {"/bin/echo $ANDROID_HOME"});
        //Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;

        line = buf.readLine();
        System.out.println(line);

        return line;
    }


    private void adbRemoteConnect(String ipPort) throws Exception {
        //String pathToADB = "../../../android-sdks/platform-tools/adb";
        //String androidHome = getAndroidHomePath();
        String androidHome = System.getenv("ANDROID_HOME");
        String pathToADB = androidHome + "/platform-tools/adb";

        //String cmd
        // = "adb shell am force-stop org.lds.ldstools.alpha";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[] {pathToADB, "connect", ipPort});
        //Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;

        while ((line=buf.readLine())!=null) {
            System.out.println(line);
        }
    }



    private void adbRemoteDisconnect(String ipPort) throws Exception {
        //String pathToADB = "../../../android-sdks/platform-tools/adb";
        //String androidHome = getAndroidHomePath();
        String androidHome = System.getenv("ANDROID_HOME");
        String pathToADB = androidHome + "/platform-tools/adb";

        //String cmd
        // = "adb shell am force-stop org.lds.ldstools.alpha";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[] {pathToADB, "disconnect", ipPort});
        //Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;

        while ((line=buf.readLine())!=null) {
            System.out.println(line);
        }
    }

    public void adbInstallChurchMobileDev() throws Exception {
        //String pathToADB = "../../../android-sdks/platform-tools/adb";
        //String androidHome = getAndroidHomePath();
        System.out.println("Install church mobile dev app");
        String androidHome = System.getenv("ANDROID_HOME");
        String pathToADB = androidHome + "/platform-tools/adb";

        //String cmd
        // = "adb shell am force-stop org.lds.ldstools.alpha";
        Runtime run = Runtime.getRuntime();

        Process pr = run.exec(new String[] { pathToADB, "-s", deviceSerial, "install", "AppUnderTest/app-debug.apk" });
        //Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;

        while ((line=buf.readLine())!=null) {
            System.out.println(line);
        }
    }

    public void adbStartChurchMobileDev() throws Exception {
        //String pathToADB = "../../../android-sdks/platform-tools/adb";
        //String androidHome = getAndroidHomePath();
        String androidHome = System.getenv("ANDROID_HOME");
        String pathToADB = androidHome + "/platform-tools/adb";

        //String cmd
        // = "adb shell am force-stop org.lds.ldstools.alpha";
        Runtime run = Runtime.getRuntime();

        Process pr = run.exec(new String[] { pathToADB, "-s", deviceSerial, "shell", "am","start", "-n", "org.lds.dev/org.lds.dev.ux.main.MainActivity" });
        //Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;

        while ((line=buf.readLine())!=null) {
            System.out.println(line);
        }
    }

    public void adbUninstallChurchMobileDev() throws Exception {
        //String pathToADB = "../../../android-sdks/platform-tools/adb";
        //String androidHome = getAndroidHomePath();
        String androidHome = System.getenv("ANDROID_HOME");
        String pathToADB = androidHome + "/platform-tools/adb";

        //String cmd
        // = "adb shell am force-stop org.lds.ldstools.alpha";
        Runtime run = Runtime.getRuntime();

        Process pr = run.exec(new String[] { pathToADB, "-s", deviceSerial, "uninstall", "org.lds.dev" });
        //Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;

        while ((line=buf.readLine())!=null) {
            System.out.println(line);
        }
    }


    public void adbProxyStart(String deviceSerial, String proxyUserName) throws Exception {
        //String pathToADB = "../../../android-sdks/platform-tools/adb";
        //String androidHome = getAndroidHomePath();
        String androidHome = System.getenv("ANDROID_HOME");
        String pathToADB = androidHome + "/platform-tools/adb";

        //String cmd
        // = "adb shell am force-stop org.lds.ldstools.alpha";
        Runtime run = Runtime.getRuntime();

        Process pr = run.exec(new String[] { pathToADB, "-s", deviceSerial, "shell", "am", "start", "-a", "android.intent.action.VIEW", "-d", "\"membertools://proxy/" + proxyUserName + "\"" });
        //Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;

        while ((line=buf.readLine())!=null) {
            System.out.println(line);
        }
    }

    public void adbEnterPIN(String deviceSerial) throws Exception {
        //String pathToADB = "../../../android-sdks/platform-tools/adb";
        //String androidHome = getAndroidHomePath();
        String androidHome = System.getenv("ANDROID_HOME");
        String pathToADB = androidHome + "/platform-tools/adb";

        //String cmd
        // = "adb shell am force-stop org.lds.ldstools.alpha";
        Runtime run = Runtime.getRuntime();

        Process pr = run.exec(new String[] { pathToADB, "-s", deviceSerial, "shell", "input", "text", "1133" });
        //Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;

        while ((line=buf.readLine())!=null) {
            System.out.println(line);
        }


        pr = run.exec(new String[] { pathToADB, "-s", deviceSerial, "shell", "input", "keyevent", "66" });
        pr.waitFor();
        buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));



        while ((line=buf.readLine())!=null) {
            System.out.println(line);
        }
    }

    private String getUDIDfbsim(String deviceNameSearch) throws Exception {
        String line;

        //System.out.println("UDID to Test: " + myUDID);
        Runtime run = Runtime.getRuntime();
        deviceNameSearch = "'" + deviceNameSearch + "'";
        System.out.println("EDIT TO SEARCH " + deviceNameSearch);

        //Process pr = run.exec(new String[] {"/bin/bash", "-c", "fbsimctl list ", " | grep", deviceNameSearch});
//        Process pr = run.exec(new String[] {"/bin/bash", "-c", "fbsimctl list | grep " + deviceNameSearch});
        Process pr = run.exec(new String[] {"/bin/bash", "-c", "idb list-targets | grep " + deviceNameSearch});
        pr.waitFor();

        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        line = buf.readLine();
        System.out.println(line);


        String[] parts = line.split(" | ");
        String simUDID = parts[0];
        String simName = parts[1];
        String simStatus = parts[2];
        String simModel = parts[3]; //This is the udid now
        String simOSVersion = parts[4];
//        System.out.println("Part 0: " + simUDID);
//        System.out.println("Part 1: " + simName);
//        System.out.println("Part 2: " + simStatus);
//        System.out.println("Part 3: " + simModel);
//        System.out.println("Part 4: " + simOSVersion);

        return simModel;
    }

    private String getUDIDfromDeviceName(String deviceName) throws Exception {
        List<String> connectedUDID;
        String checkDeviceName;
        String returnUDID = "Not Found!";
        //Get UDID from devices
        connectedUDID = multipleDeviceUDID();

        //Match deviceName to UDID
        for(String oneUDID : connectedUDID){
            checkDeviceName = getDeviceName(oneUDID);
            if (checkDeviceName.equals(deviceName))	{
                returnUDID = oneUDID;
            }
        }

        return returnUDID;
    }


    private String deviceUDID() throws IOException{
        ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", "/usr/local/bin/idevice_id -l");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        line = r.readLine();
        System.out.println(line);
        return line;
    }

    private List<String> multipleDeviceUDID() throws Exception {
        List<String> line = new ArrayList<String>();
        String myLine;

        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[] {"/usr/local/bin/idevice_id", "-l"});
        pr.waitFor();

        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        while ((myLine=buf.readLine())!=null) {
            //System.out.println(myLine);
            line.add(myLine);

        }

        return line;
    }

    private String getDeviceName(String myUDID) throws Exception {
        String deviceName;
        String line;

        System.out.println("UDID to Test: " + myUDID);
        Runtime run = Runtime.getRuntime();
        //Process pr = run.exec(new String[] {"/usr/local/bin/ideviceinfo", "--udid", myUDID, "|", "grep", "DeviceName"});
        Process pr = run.exec(new String[] {"/bin/bash", "-c", "/usr/local/bin/ideviceinfo --udid " + myUDID + " | grep DeviceName"});
        pr.waitFor();

        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        line = buf.readLine();
        System.out.println(line);


        String[] parts = line.split(" ");
        String part1 = parts[0];

        deviceName = parts[1];

        //System.out.println(deviceName);

        return deviceName;
    }


    private String getUDIDfromDeviceNameFBSIM(String deviceName) throws Exception {
        String simUDID;
//        String deviceNameSearch = "| " + deviceName + " |";
        String deviceNameSearch = deviceName + " |";
        System.out.println("TO SEARCH: " + deviceNameSearch);

        simUDID = getUDIDfbsim(deviceNameSearch) ;

        return simUDID;
    }

    private void startFbSim(String myUdid, int tempPort) throws Exception {
        String line;
        String listenPort = Integer.toString(tempPort);
        Runtime run = Runtime.getRuntime();
//        Process pr = run.exec(new String[] {"/bin/bash", "-c", "fbsimctl ", myUdid, " boot"});
        Process pr = run.exec(new String[] {"/bin/bash", "-c", "idb", "boot", "--udid", myUdid});
        //Process pr = run.exec(new String[] {"/bin/bash", "-c", "fbsimctl ", myUdid, " boot",  "--", "listen", "--http ", listenPort});
        //Process pr = run.exec(new String[] {"/bin/bash", "-c", "fbsimctl ", myUdid });
        pr.waitFor();

        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        line = buf.readLine();
        //System.out.println(line);
    }




    private void stopFbSim() throws Exception {
        String line;
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[] {"/bin/bash", "-c", "fbsimctl shutdown" });
        pr.waitFor();

        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        line = buf.readLine();
//        System.out.println(line);
    }




    private boolean portCheck(int port) throws IOException {
        // Assume no connection is possible.
        boolean result = false;

        try {
            Socket s = new Socket("localhost", port);
            s.close();
            System.out.println("Port " + port + " is in use.");
            result = false;
        }
        catch(SocketException e) {
            // Could not connect.
            //System.out.println("Port " + port + " is open.");
            result = true;
        }

        return result;
    }


    public void killProcess(String processToKill) throws Exception {
        String line = "";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[] {"/usr/bin/pkill", "-9", "-f", "-l", processToKill});
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        while ((line=buf.readLine())!=null) {
            System.out.println(line);
        }
    }


    public String getRunningOS() {
        String myOs = "";

        if (testOS.equalsIgnoreCase("android")) {
            myOs = "android";
        }

        if (testOS.equalsIgnoreCase("ios")) {
            myOs = "ios";
        }

        myOs = myOs.toLowerCase();
        //System.out.println("MY OS: "  + myOs);
        return myOs;
    }

    private void adbCommand(String myCommand) throws Exception {
        String androidHome = System.getenv("ANDROID_HOME");
        String pathToADB = androidHome + "/platform-tools/adb";



        if (myCommand.equals("stopApp")) {
            //String cmd = "adb shell am force-stop org.lds.ldstools.alpha";
            Runtime run = Runtime.getRuntime();
//            Process pr = run.exec(new String[] {pathToADB, "shell", "am", "force-stop", "org.lds.ldstools.alpha"});
            Process pr = run.exec(new String[] {pathToADB, "shell", "am", "force-stop", androidAppPackage});
            //Process pr = run.exec(cmd);
            pr.waitFor();
            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = "";
            while ((line=buf.readLine())!=null) {
                System.out.println(line);
            }
        }

        if (myCommand.equals("clearApp")) {
            //String cmd = "adb shell am force-stop org.lds.ldstools.alpha";
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(new String[] { pathToADB, "shell", "pm", "clear", androidAppPackage});
            //Process pr = run.exec(cmd);
            pr.waitFor();
            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = "";
            while ((line=buf.readLine())!=null) {
                System.out.println(line);
            }
        }
    }

    public void takeScreenShot() {
        String imagesLocation = "screenshot/";
        new File(imagesLocation).mkdirs(); // Insure directory is there

        try {
//            File srcFile=driver.getScreenshotAs(OutputType.FILE);
            File srcFile=getDriver().getScreenshotAs(OutputType.FILE);
            String filename= UUID.randomUUID().toString();
            System.out.println("Screenshot File: " + filename);
            File targetFile=new File(imagesLocation + filename +".png");
            FileUtils.copyFile(srcFile,targetFile);
        }
        catch(Exception e){
            System.out.println("Warning: Some Other exception");
        }

    }

    private void takeScreenShotDirectory(String filename, String imagesLocation) {
        try {
//            File srcFile=driver.getScreenshotAs(OutputType.FILE);
            File srcFile=getDriver().getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot File: " + filename);
            File targetFile=new File(imagesLocation + filename +".png");
            FileUtils.copyFile(srcFile,targetFile);
        }
        catch(Exception e){
            System.out.println("Warning: Some Other exception");
        }

    }


    private void screenshotAndLogs(String testName) throws Exception {
        //Get Random UUID
        String filename= UUID.randomUUID().toString();
        //Make DIR for random UUID
        String imagesLocation = "screenshot/" + filename +"/";

        new File(imagesLocation).mkdirs(); // Insure directory is there


        //Take Screen shot
        takeScreenShotDirectory(filename, imagesLocation);

        //Broken in v8 of java-client
//        getLogData(testName, filename);


    }

    private void getLogData(String testName, String filename) throws Exception {
        LogEntries logEntries;
        List<String> myLogData = new ArrayList<String>();
        List<String> logTypes = new ArrayList<String>();
        String imagesLocation = "screenshot/" + filename +"/";
        String logFile = imagesLocation + testName + ".txt";
        myLogData.add(testName);
        myLogData.add("******************* LOGS *********************");

//        Set<String> sourceSet = getDriver().manage().logs().getAvailableLogTypes();
//        logTypes = new ArrayList<>(sourceSet);

        if (getRunningOS().contains("ios")) {
            //logTypes.add("syslog");
            logTypes.add("crashlog");
            logTypes.add("server");
        } else {
            logTypes.add("logcat");
//            logTypes.add("bugreport");
            logTypes.add("server");
            logTypes.add("client");

//            sendAndroidLog();
        }


        for(String myLog : logTypes) {
            if (!myLog.contains("performance")) {
                System.out.println(myLog);
                myLogData.add(" ******************* " + myLog +  " ******************* " );
//                logEntries = getDriver().manage().logs().get(myLog);
                logEntries = driver.get().manage().logs().get(myLog);
                for (LogEntry entry : logEntries) {
                    myLogData.add(entry.getMessage());
                    //System.out.println(entry.getMessage());
                }
            }


        }

        myLogData.add("******************* END LOGS *********************");



        PrintWriter pw = new PrintWriter(new FileOutputStream(logFile));
        for (String logItem : myLogData) {
            pw.println(logItem);
        }
        pw.close();
    }

    private String getIOSToolsLog() throws Exception {
        String myLogs = null;
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBase = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        myMenu.selectMenu(myMenu.help);
        myLoginPage.developerButton.click();

        return myLogs;
    }

    public void sendAndroidLog() throws Exception {
        MenuScreen myMenu = new MenuScreen(driver);
        HelpScreen myHelp = new HelpScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        if (myBasePage.checkForElement(myBasePage.alertOK)) {
            myBasePage.alertOK.click();
            Thread.sleep(4000);
//            driver.get().launchApp();
//            Thread.sleep(4000);
            myLoginPage.overflowMenu.click();
        } else {
            myMenu.selectMenu(myMenu.help);
        }


        myHelp.helpContactUs.click();

        myHelp.contactUsName.sendKeys("Zade");
        myHelp.contactUsEmail.sendKeys("zmaxfield@churchofjesuschrist.org");
        myHelp.contactUsCategory.click();
        myHelp.contactUsDescription.click();
        myHelp.contactUsDescription.sendKeys("sendto:zmaxfield@churchofjesuschrist.org");
        myHelp.helpSendFeedback.click();

    }

    public String getTestOS() {
        return testOS;
    }

    public String getTestngTestDevice() {
        System.out.println("Get Testng Test Device: " + testngTestDevice);
        return testngTestDevice;
    }

    public int getTestngStartSleepTime() {
        return testngStartSleepTime;
    }







}
