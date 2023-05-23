package LDSToolsAppium;


import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MissionaryScreen;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.*;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.Assert;

import java.awt.desktop.SystemEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class BasePage extends BaseDriver {
//    public ThreadLocal<AppiumDriver> driver;

    public BasePage(ThreadLocal<AppiumDriver> driver) {
//        BaseDriver.driver = driver;

        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }



    //Universal Elements
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'toolbar')]/android.widget.ImageButton")
//    @AndroidFindBy(xpath = "//*[@content-desc='Navigate up']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public WebElement backButton;

    //Navigate up
    @AndroidFindBy(xpath = "//*[@content-desc='Navigate up']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public WebElement navigateUp;

//    @AndroidFindBy(accessibility = "Navigate up")
//    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'toolbar')]/android.widget.ImageButton")
    @AndroidFindBy(xpath = "//*[@content-desc='Navigate up']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public WebElement backAltButton;

//    @AndroidFindBy(accessibility = "Navigate up")
//    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'toolbar')]/android.widget.ImageButton")
    @AndroidFindBy(xpath = "//*[@content-desc='Open navigation drawer']")
    public WebElement drawerButton;

    @AndroidFindBy(xpath = "//*[@content-desc='Open navigation drawer']")
    public WebElement drawerButtonNew;

    @AndroidFindBy(id = "clearTextImageButton")
    public WebElement searchCollapse;

    @iOSXCUITFindBy(accessibility = "More")
    public WebElement moreButton;

    //OK
    @AndroidFindBy(xpath = "//*[@text=\"OK\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'OK'")
    public WebElement alertOK;

    //OK
    @AndroidFindBy(xpath = "//*[@text=\"OK\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Enter'")
    public WebElement alertOKEnter;

    //Cancel
    @AndroidFindBy(accessibility = "Cancel")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public WebElement cancel;

    //CANCEL
    @AndroidFindBy(xpath = "//*[@text=\"CANCEL\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'CANCEL'")
    public WebElement alertCANCEL;

    //Cancel
    @AndroidFindBy(xpath = "//*[@text=\"Cancel\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Cancel'")
    public WebElement alertCancel;

    //Allow button
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
//    @AndroidFindBy(id = "permission_allow_foreground_only_button")
    @iOSXCUITFindBy(accessibility = "Allow")
    public WebElement allowButton;


    //Allow While Using App
    @AndroidFindBy(xpath = "//*[@text=\"Allow only while using the app\"]")
    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    public WebElement allowWhileUsingApp;


    //Alert check
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//UIAAlert")
    public WebElement alertCheck;

    //Menu Title
//    @AndroidFindBy(xpath = "//*[@resource-id=\"ab_toolbar\"]//android.widget.TextView")
    @AndroidFindBy(xpath = "//*[@resource-id='org.lds.ldstools.alpha:id/toolbar']//android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar//XCUIElementTypeStaticText")
    public WebElement menuTitle;

    //Return Key
    @iOSXCUITFindBy(accessibility = "Return")
    public WebElement keyboardReturn;

    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/drop_arrow" )
    @iOSXCUITFindBy(xpath = "//*[@name='LDS_Tools.DirectoryView']//XCUIElementTypeStaticText[2]")
    public WebElement unitSelected;


    //Drag Handle
    @AndroidFindBy(xpath ="//android.view.View[@content-desc='Drag handle']")
    public  WebElement dragHandle;




    public BasePage(AppiumDriver driver) {

    }


    //Scrolling Methods

    public void scrollToTextiOS(String myElement) throws Exception {
        int myCounter = 1;
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement elementToScrollTo = driver.get().findElement(By.xpath("//*[@name='" + myElement + "']"));
        HashMap scrollObject = new HashMap();

        while (myCounter < 3) {
            if (!checkForElement(elementToScrollTo)) {
                scrollObject.put("direction", "up");
                js.executeScript("mobile: swipe", scrollObject);
                myCounter++;
            } else {
                System.out.println("Found: " + myElement);
                myCounter = 10;
            }

        }


    }

    public void scrollToTextGeneral(String myElement) throws Exception {
        flingUp();
        if (getOS().contains("ios")) {
            scrollToTextiOS(myElement);
        } else {
            newScrollToText(myElement);
        }
    }

    public void scrollToText(String myElement) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;
        flingUp();

        if (getOS().contains("ios")) {
            scrollToTextiOS(myElement);

        } else {
            if (!checkTextOnPage(myElement)) {
                WebElement list = (WebElement) driver.get().findElement(By.id("org.lds.ldstools.alpha:id/list"));
                WebElement radioGroup = (WebElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\"" + myElement + "\"));"));

                while (myLoopStatus == 0) {
                    System.out.println("OVERFLOW SCROLL: " + myCounter);
                    radioGroup = (WebElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                            + "new UiSelector().text(\"" + myElement + "\"));"));


                    if (radioGroup.isDisplayed()) {
                        myLoopStatus = 1;
                    }

                    if (myCounter > 5) {
                        myLoopStatus = 1;
                    }

                    myCounter++;
                }
                Assert.assertNotNull(radioGroup.getLocation());
            }
        }


    }

    public void flingUp() throws Exception {
        try {
            driver.get().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).flingBackward();"));
        } catch (Exception ignored) {

        }
    }

    public void scrollToTextScollArea(String myElement) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;

        if (!checkTextOnPage(myElement)) {
            WebElement list = (WebElement) driver.get().findElement(By.id("org.lds.ldstools.alpha:id/scroll_area"));
            WebElement radioGroup = (WebElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                    + "new UiSelector().text(\"" + myElement + "\"));"));

            while (myLoopStatus == 0) {
                System.out.println("OVERFLOW SCROLL: " + myCounter);
                radioGroup = (WebElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\"" + myElement + "\"));"));


                if (radioGroup.isDisplayed()) {
                    myLoopStatus = 1;
                }

                if (myCounter > 5) {
                    myLoopStatus = 1;
                }

                myCounter++;
            }
            Assert.assertNotNull(radioGroup.getLocation());
        }
    }

    public void scrollToTextTopLayout(String myElement) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;

        if (!checkTextOnPage(myElement)) {
            WebElement list = (WebElement) driver.get().findElement(By.id("top_layout"));
            WebElement radioGroup = (WebElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                    + "new UiSelector().text(\"" + myElement + "\"));"));

            while (myLoopStatus == 0) {
                System.out.println("OVERFLOW SCROLL: " + myCounter);
                radioGroup = (WebElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\"" + myElement + "\"));"));


                if (radioGroup.isDisplayed()) {
                    myLoopStatus = 1;
                }

                if (myCounter > 5) {
                    myLoopStatus = 1;
                }

                myCounter++;
            }
            Assert.assertNotNull(radioGroup.getLocation());
        }
    }

    public void scrollToTextRecyclerView(String myElement) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;

        if (!checkTextOnPage(myElement)) {
//            System.out.println(getSourceOfPage());
            WebElement list = (WebElement) driver.get().findElement(By.id("org.lds.ldstools.alpha:id/recycler_view"));
            WebElement radioGroup = (WebElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                    + "new UiSelector().text(\"" + myElement + "\"));"));

            while (myLoopStatus == 0) {
                System.out.println("OVERFLOW SCROLL: " + myCounter);
                radioGroup = (WebElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\"" + myElement + "\"));"));


                if (radioGroup.isDisplayed()) {
                    myLoopStatus = 1;
                }

                if (myCounter > 5) {
                    myLoopStatus = 1;
                }

                myCounter++;
            }
            Assert.assertNotNull(radioGroup.getLocation());
        }
    }

    public void scrollToTextRecyclerViewSettings(String myElement) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;

        if (!checkTextOnPage(myElement)) {
//            System.out.println(getSourceOfPage());
            WebElement list = (WebElement) driver.get().findElement(By.id("org.lds.ldstools.alpha:id/recyclerView"));
            WebElement radioGroup = (WebElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                    + "new UiSelector().text(\"" + myElement + "\"));"));

            while (myLoopStatus == 0) {
                System.out.println("OVERFLOW SCROLL: " + myCounter);
                radioGroup = (WebElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\"" + myElement + "\"));"));


                if (radioGroup.isDisplayed()) {
                    myLoopStatus = 1;
                }

                if (myCounter > 5) {
                    myLoopStatus = 1;
                }

                myCounter++;
            }
            Assert.assertNotNull(radioGroup.getLocation());
        }
    }


    public void scrollTextIntoViewAndroid(String myText, int numberOfScrolls) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;

        if (!checkForTextPageSource(myText)) {

            while (myLoopStatus == 0) {
//                System.out.println("Scroll Text Into View Android Counter: " + myCounter);

                try {
                    driver.get().findElement(MobileBy.AndroidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
                } catch (InvalidSelectorException e) {
                    // ignore
                }


                Thread.sleep(500);

                if (checkForTextPageSource(myText)) {
                    myLoopStatus = 1;
                }

                if (myCounter > numberOfScrolls) {
                    myLoopStatus = 1;
                }

                myCounter++;
            }

        }
    }




    public void scrollToTextNavMenu(String myElement) throws Exception {
        int myCounter = 1;
        int myLoopStatus = 0;

        if (!checkTextOnPage(myElement)) {
            WebElement list = (WebElement) driver.get().findElement(By.id("org.lds.ldstools.alpha:id/navigation_menu"));
            WebElement radioGroup = (WebElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                    + "new UiSelector().text(\"" + myElement + "\"));"));

            while (myLoopStatus == 0) {
                System.out.println("OVERFLOW SCROLL: " + myCounter);
                radioGroup = (WebElement) list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\"" + myElement + "\"));"));


                if (radioGroup.isDisplayed()) {
                    myLoopStatus = 1;
                }

                if (myCounter > 5) {
                    myLoopStatus = 1;
                }

                myCounter++;
            }
            Assert.assertNotNull(radioGroup.getLocation());
        }
    }

    public boolean newScrollDown() throws Exception {
        System.out.println("Scrolling down");
        boolean canScrollMore;
        Dimension deviceSize = driver.get().manage().window().getSize();
        int deviceWidth = deviceSize.getWidth();
        int deviceHeight = deviceSize.getHeight();
        int left = deviceWidth / 5;
        int top = deviceHeight / 5; //6
//        int width = deviceWidth / 8;
        int width = 1;
        int height = deviceHeight / 3; //4

//        System.out.println("Device Width: " + deviceWidth);
//        System.out.println("Device Height: " + deviceHeight);
//        System.out.println("left: " + left + " top: " + top + " width: " + width + " height: " + height);

        canScrollMore = (Boolean) ((JavascriptExecutor) driver.get()).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", left, "top", top, "width", width, "height", height,
                "direction", "down",
                "percent", 3.0
        ));

//        System.out.println("Can Scroll More: " + canScrollMore);

        return canScrollMore;
    }

    public boolean newScrollDownSlow() throws Exception {
        System.out.println("Scrolling down");
        boolean canScrollMore = false;

        if (getOS().equalsIgnoreCase("ios")) {
            scrollDownIOS();
        } else {
            Dimension deviceSize = driver.get().manage().window().getSize();
            int deviceWidth = deviceSize.getWidth();
            int deviceHeight = deviceSize.getHeight();
            int left = deviceWidth / 5;
            int top = deviceHeight / 5; //6
//        int width = deviceWidth / 8;
            int width = 1;
            int height = deviceHeight / 3; //4

//        System.out.println("Device Width: " + deviceWidth);
//        System.out.println("Device Height: " + deviceHeight);
//        System.out.println("left: " + left + " top: " + top + " width: " + width + " height: " + height);

            canScrollMore = (Boolean) ((JavascriptExecutor) driver.get()).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", left, "top", top, "width", width, "height", height,
                    "direction", "down",
                    "percent", 1.0,
                    "speed", 600
            ));

//        System.out.println("Can Scroll More: " + canScrollMore);
        }

        return canScrollMore;
    }

    public boolean newScrollIosAndroid() throws Exception {
        System.out.println("Scrolling down");
        boolean canScrollMore = false;

        if (getOS().equalsIgnoreCase("ios")) {
            scrollDownIOS();
        } else {
            Dimension deviceSize = driver.get().manage().window().getSize();
            int deviceWidth = deviceSize.getWidth();
            int deviceHeight = deviceSize.getHeight();
            int left = deviceWidth / 5;
            int top = deviceHeight / 5; //6
//        int width = deviceWidth / 8;
            int width = 1;
            int height = deviceHeight / 3; //4

//        System.out.println("Device Width: " + deviceWidth);
//        System.out.println("Device Height: " + deviceHeight);
//        System.out.println("left: " + left + " top: " + top + " width: " + width + " height: " + height);

            canScrollMore = (Boolean) ((JavascriptExecutor) driver.get()).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", left, "top", top, "width", width, "height", height,
                    "direction", "down",
                    "percent", 1.0,
                    "speed", 600
            ));

//        System.out.println("Can Scroll More: " + canScrollMore);
        }



        return canScrollMore;
    }

    public boolean newScrollUp() throws Exception {
//        System.out.println("Scrolling up");
        boolean canScrollMore;
        Dimension deviceSize = driver.get().manage().window().getSize();
        int deviceWidth = deviceSize.getWidth();
        int deviceHeight = deviceSize.getHeight();
        int left = deviceWidth / 4;
        int top = deviceHeight / 3;
        int width = deviceWidth - 200;
        int height = deviceHeight - 200;

//        System.out.println("Device Width: " + deviceWidth);
//        System.out.println("Device Height: " + deviceHeight);
//        System.out.println("left: " + left + " top: " + top + " width: " + width + " height: " + height);

        canScrollMore = (Boolean) ((JavascriptExecutor) driver.get()).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", left, "top", top, "width", width, "height", height,
                "direction", "up",
                "percent", 3.0
        ));

        return canScrollMore;
    }

    public void newScrollUpUnitList() throws Exception {
        WebElement dragHandel = driver.get().findElement(By.xpath("//android.view.View[@content-desc=\"Drag handle\"]"));
        Dimension deviceSize = driver.get().manage().window().getSize();
        int deviceWidth = deviceSize.getWidth();
        int width = deviceWidth / 2;
        ((JavascriptExecutor) driver.get()).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", dragHandel,
                "endX", width,
                "endY", 100
        ));
    }

    public void dragHandleScrollAway() throws Exception {

        Dimension deviceSize = driver.get().manage().window().getSize();
        int deviceWidth = deviceSize.getWidth();
        int deviceHeight = deviceSize.getHeight();
        int width = deviceWidth / 2;
        ((JavascriptExecutor) driver.get()).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", dragHandle,
                "endX", width,
                "endY", deviceHeight
        ));
    }


    public void swipeByElement(WebElement myElement) throws Exception {

        ((JavascriptExecutor) driver.get()).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", myElement,
                "endX", 100,
                "endY", 100
        ));
    }


    public void newScrollToText(String myText) throws Exception {
        String pageSource;
        boolean textCheck = false;
        int myCounter = 1;

        if (getSourceOfPage().equalsIgnoreCase("ios")) {
            scrollDownToTextIOS(myText);
        } else {
            do {
                pageSource = getSourceOfPage();
                textCheck = pageSource.contains(myText);
//            textCheck = checkTextOnPage(myText);
//            System.out.println("Check: " + textCheck);
                if (!textCheck) {
                    newScrollDownSlow();
                }
                if (myCounter > 9) {
                    textCheck = true;
                    System.out.println("TEXT: " + myText + " Not Found!");
                }
                myCounter++;

            } while (!textCheck) ;
        }
    }

    public void scrollDownAndroidUIAutomator(String myInstance) throws Exception {
        if (getOS().equals("ios")) {
            scrollDownIOS();
        } else {
            try {
                driver.get().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(" + myInstance + ")).scrollForward(70);"));
            } catch (Exception ignored) {

            }
        }
    }

    public void scrollUpAndroidUIAutomator(String myInstance) throws Exception {
        try {
            driver.get().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(" + myInstance + ")).flingBackward();"));
//            driver.get().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(" + myInstance + ")).scrollBackward(45);"));
        } catch (Exception ignored) {

        }

    }


    public void scrollDownIOS() throws Exception {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);

    }

    public void swipeDownIOS() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: swipe", scrollObject);

    }

    public void swipeUpIOS() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "up");
        js.executeScript("mobile: swipe", scrollObject);

    }

    public void scrollDownToTextIOS(String myText) throws Exception {

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("predicateString", "value == '" + myText + "'");
        js.executeScript("mobile: scroll", scrollObject);

    }

    public void scrollDownTEST(int scrollDistance ) throws Exception {
        if (getOS().equals("ios")) {
            scrollDownIOS();
        } else {
            Dimension dimensions = driver.get().manage().window().getSize();
            int screenWidth = dimensions.getWidth();
            int screenHeight = dimensions.getHeight();

            screenWidth = screenWidth / 3;
            screenHeight = screenHeight - 100;
            scrollDistance = screenHeight / 2;
            scrollDistance = scrollDistance / 2;
            //scrollDistance = -scrollDistance;
            //scrollDistance = 0;

            System.out.println("Width: " + screenWidth);
            System.out.println("Height: " + screenHeight);
            System.out.println("Distance: " + scrollDistance);


            TouchAction actions = new TouchAction((PerformsTouchActions) driver.get());
            actions.press(PointOption.point(screenWidth, screenHeight))
                    .moveTo(PointOption.point(screenWidth, scrollDistance))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .release()
                    .perform();

            Thread.sleep(5000);
        }
    }

    public void scrollUp(int scrollDistance ) throws Exception {
        if (getOS().equals("ios")) {
            scrollUpIOS();
        } else {
            Dimension dimensions = driver.get().manage().window().getSize();
            int screenWidth = dimensions.getWidth();
            int screenHeight = dimensions.getHeight();

            screenWidth = screenWidth / 2;
            scrollDistance = screenHeight - 20;
            screenHeight = screenHeight / 2;

            //scrollDistance = -scrollDistance;

            TouchAction actions = new TouchAction((PerformsTouchActions) driver.get());
            actions.press(PointOption.point(screenWidth, screenHeight))
                    .moveTo(PointOption.point(screenWidth, scrollDistance))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .release()
                    .perform();

            Thread.sleep(5000);
        }
    }

    public void scrollToTextSwipe(String myText) throws Exception {
        String pageSource;
        boolean textCheck = false;
        int myCounter = 1;

        do {
            pageSource = getSourceOfPage();
            textCheck = pageSource.contains(myText);
//            textCheck = checkTextOnPage(myText);
//            System.out.println("Check: " + textCheck);
            if (!textCheck) {
//                scrollDownSlow(1500);
                newScrollDownSlow();
            }
            if (myCounter > 5) {
                textCheck = true;
                System.out.println("TEXT: " + myText + " Not Found!");
            }
            myCounter++;

        } while (!textCheck) ;


    }

    public void scrollDownSlow(int scrollDistance) throws Exception {
        Dimension dimensions = driver.get().manage().window().getSize();
        int screenWidth = dimensions.getWidth();
        int screenHeight = dimensions.getHeight();


        screenWidth = screenWidth / 3;
        screenHeight = screenHeight - 70;
//        scrollDistance = screenHeight - scrollDistance;
        scrollDistance = screenHeight / 2;

//        System.out.println("Width: " + screenWidth);
//        System.out.println("Height: " + screenHeight);
//        System.out.println("Distance: " + scrollDistance);

        TouchAction mySwipe = new TouchAction((PerformsTouchActions) driver.get());
        //mySwipe.tap(screenWidth,screenHeight).moveTo(screenWidth, scrollDistance).waitAction(Duration.ofMillis(2000)).release().perform();
        //mySwipe.press(screenWidth,screenHeight).moveTo(screenWidth, scrollDistance).release().perform();

        mySwipe.press(PointOption.point(screenWidth, screenHeight))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(screenWidth, scrollDistance))
                .release()
                .perform();

        //driver.get().swipe(screenWidth, screenHeight, screenWidth, scrollDistance, 2000);

        Thread.sleep(2000);

    }


    public void scrollUpIOS() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "up");
        js.executeScript("mobile: scroll", scrollObject);

    }

    public boolean checkForTextPageSource(String textToCheck) throws Exception {
        String pageSource;
        boolean found;
        pageSource = getSourceOfPage();
        if (pageSource.contains(textToCheck)) {
            found = true;
        } else {
            found = false;
        }
        return found;
    }





    public boolean checkTextOnPage(String myElement) {
        boolean myReturnStatus;
        List<WebElement> options = null;
        options = driver.get().findElements(By.xpath("//*[contains(@text, '" + myElement + "')]"));

        if (options.isEmpty()) {
            myReturnStatus = false;
            //Sometimes iOS doesn't have text but has text under value
            options = driver.get().findElements(By.xpath("//*[contains(@value, '" + myElement + "')]"));
            if (!options.isEmpty()) {
                myReturnStatus = true;
            }
        } else {
            myReturnStatus = true;
        }

        return myReturnStatus;
    }


    public boolean checkNoCaseList(String textToCheck, String pageSource, String containEqual){
        Document doc = Jsoup.parse(pageSource);
        Elements myTest = doc.getAllElements();
        String foundText;
        String myOs;
        textToCheck = textToCheck.toLowerCase();
        myOs = getOS();
        if (myOs.equals("ios")){
            for (Element myElement : myTest ) {
                //if (myElement.attributes().get("shown").equals("true")) {
                //System.out.println("Name: ");
                //System.out.println(myElement.attributes().get("name"));
                //System.out.println("Value: ");
                ///System.out.println(myElement.attributes().get("value"));
                foundText = myElement.attributes().get("name");
                foundText = foundText.toLowerCase();
                foundText = foundText.trim();
                //System.out.println("******************************");
                //System.out.println("   Found Text: " + foundText);
                //System.out.println("Text To Check: " + textToCheck);
                //System.out.println("******************************");
                if (containEqual.equals("Equals")) {
                    if (foundText.equals(textToCheck)) {
                        return true;
                    }
                } else {
                    if (foundText.contains(textToCheck)) {
                        return true;
                    }
                }

            }

        } else {
            for (Element myElement : myTest ) {
                //System.out.println(myElement.attributes().get("value"));
                if (!myElement.attributes().get("text").equals("")) {
                    //foundText = myElement.attributes().get("value");
                    foundText = myElement.attributes().get("text");
                    foundText = foundText.toLowerCase();
                    //System.out.println("******************************");
                    //System.out.println("Found Text:" + foundText);
                    //System.out.println("Text To Check: " + textToCheck);
                    //System.out.println("******************************");
                    if (containEqual.equals("Equals")) {
                        if (foundText.equals(textToCheck)) {
                            return true;
                        }
                    } else {
                        if (foundText.contains(textToCheck)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    public Elements getAllElementsOnPage(String myPageSource ) {
        Document doc = Jsoup.parse(myPageSource);
        Elements myTest = doc.getAllElements();
        List<Attribute> elementAttributes = new ArrayList<Attribute>();

//        for (Element myElement : myTest ) {
//
//            System.out.println("*********************************************************************");
//            elementAttributes = myElement.attributes().asList();
//            for (Attribute myAttribute : elementAttributes ) {
//                System.out.println("To String: " + myAttribute.toString());
//                System.out.println("Get Key: " + myAttribute.getKey());
//                System.out.println("Get Value: " + myAttribute.getValue());
//                System.out.println("Get HTML: " + myAttribute.html());
//                System.out.println("Get Class: " + myAttribute.getClass());
//            }
//
//            System.out.println("*********************************************************************");
//
//        }

        return myTest;
    }



    public void rightsCheck(String myItem, int itemVisibility, int rights, String pageSource) {
        //This is just for testing
//        SoftAssert sa = new SoftAssert();
        System.out.println("Checking: " + myItem);
        if (rights <= itemVisibility) {
            Assert.assertTrue(checkNoCaseList(myItem, pageSource, "Contains"));
//            sa.assertTrue(checkNoCaseList(myItem, pageSource, "Contains"));
        } else {
            Assert.assertFalse(checkNoCaseList(myItem, pageSource, "Contains"));
//            sa.assertFalse(checkNoCaseList(myItem, pageSource, "Contains"));
        }
//        sa.assertAll();
    }

    public void rightsCheckNewRights(String myItem, int itemVisibility, int rights, String pageSource) {
        //This is just for testing
//        SoftAssert sa = new SoftAssert();
        System.out.println("Checking: " + myItem);
        if (rights >= itemVisibility) {
            Assert.assertTrue(checkNoCaseList(myItem, pageSource, "Contains"));
//            sa.assertTrue(checkNoCaseList(myItem, pageSource, "Contains"));
        } else {
            Assert.assertFalse(checkNoCaseList(myItem, pageSource, "Contains"));
//            sa.assertFalse(checkNoCaseList(myItem, pageSource, "Contains"));
        }
//        sa.assertAll();
    }

    public void waitForElementToDisappear(WebElement myElement) {
        System.out.println("Start Checking for Element");
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(90));
        wait.until(ExpectedConditions.invisibilityOf(myElement));
        System.out.println("Stop Checking for Element");
    }

//    public void switchToContext(String context) {
//        RemoteExecuteMethod executeMethod = new RemoteExecuteMethod(getDriver());
//        executeMethod.execute(DriverCommand.SWITCH_TO_CONTEXT, ImmutableMap.of("name", context));
//    }




    public void waitUnitlTextIsGone(String myText) {
        //System.out.println("Start Checking for Element");
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(240));

        if(getOS().equals("ios")) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@value, '" + myText + "')]")));
        } else {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@text, '" + myText + "')]")));
        }

        //System.out.println("Stop Checking for Element");
    }

    public void waitUntilTextIsGonePopUp(String myText) {
        //System.out.println("Start Checking for Element");
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(180));

        if(getOS().equals("ios")) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@label, '" + myText + "')]")));
        } else {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@text, '" + myText + "')]")));
        }

        //System.out.println("Stop Checking for Element");
    }







    public void waitForText(String myText) {
        //System.out.println("Start Checking for Element");
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(120));
        if(getOS().equals("ios")) {
//            WebElement iosElement = driver.get().findElement(By.xpath("//*[contains(@value, '" + myText + "')]"));
//            wait.until(ExpectedConditions.textToBePresentInElement(iosElement, myText));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@value, '" + myText + "')]")));
        } else {
//            WebElement androidElement = driver.get().findElement(By.xpath("//*[contains(@text, '" + myText + "')]"));
//            wait.until(ExpectedConditions.textToBePresentInElement(androidElement, myText));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, '" + myText + "')]")));
        }

        //System.out.println("Stop Checking for Element");
    }

    public void waitForTextPopUp(String myText) {
        //System.out.println("Start Checking for Element");
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(300));
        if(getOS().equals("ios")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@label, '" + myText + "')]")));
        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, '" + myText + "')]")));
        }
    }

    public void waitForElementThenClick(WebElement myElement) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(60));
        Thread.sleep(200);
        wait.until(ExpectedConditions.elementToBeClickable(myElement));
        myElement.click();
    }

    public void waitForElement(WebElement myElement) {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(myElement));
    }

    public void clickByText(String myText) {
        if(getOS().equals("ios")) {
            driver.get().findElement(By.xpath("//*[@label='" + myText + "']")).click();
        } else {
            driver.get().findElement(By.xpath("//*[@text='" + myText + "']")).click();
        }
    }

    public void clickByTextName(String myText) {
        if(getOS().equals("ios")) {
            driver.get().findElement(By.xpath("//*[@name='" + myText + "']")).click();
        } else {
            driver.get().findElement(By.xpath("//*[@text='" + myText + "']")).click();
        }
    }

    public void clickByTextContains(String myText) {
        if(getOS().equals("ios")) {
            driver.get().findElement(By.xpath("//*[contains(@name, '" + myText + "')]")).click();
        } else {
            driver.get().findElement(By.xpath("//*[contains(@text, '" + myText + "')]")).click();
        }

    }

    public boolean checkForElement(WebElement myElement ) {
        try {
            WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(6));
            wait.until(ExpectedConditions.elementToBeClickable(myElement));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Boolean checkElementExists(String textElement) {
        Boolean myReturnStatus;
        List<WebElement> options = null;
        if (getOS().equals("ios")) {
            //options = driver.get().findElements(By.xpath("//*[@value='" + textElement + "']"));
            options = driver.get().findElements(MobileBy.AccessibilityId(textElement));
        } else {
            options = driver.get().findElements(By.xpath("//*[@text='" + textElement + "']"));
        }

        if (options != null) {
            if (options.isEmpty()) {
                myReturnStatus = false;
            } else {
                myReturnStatus = true;
            }
        } else {
            myReturnStatus = false;
        }

        //System.out.println("Searching for " + textElement + " Found: " + myReturnStatus);

        return myReturnStatus;
    }

    public Boolean checkForText(String textElement) throws Exception {
        Boolean myReturnStatus;
        String pageSource;
        pageSource = getSourceOfPage();
        pageSource = pageSource.toLowerCase();
        textElement = textElement.toLowerCase();

        if (pageSource.contains(textElement)) {
            myReturnStatus = true;
        } else {
            myReturnStatus = false;
        }

        return myReturnStatus;
    }


    public String getOS() {
        String osName = "test";
        //System.out.println("Context: " + driver.get().getContext());
        //System.out.println("OS: " + osName);
        osName = driver.get().getCapabilities().getCapability("platformName").toString();
        osName = osName.toLowerCase();
        //System.out.println("OS: " + osName);
        return osName;
    }

    public String getSourceOfPage() throws Exception {
//        System.out.println("Start Get Source of Page");
        String myString;
        Thread.sleep(2000);
        myString = driver.get().getPageSource();

//        System.out.println("****************************************************");
//        System.out.println("Page Source: " + myString);
//        System.out.println("****************************************************");
//        System.out.println("End Get Source of Page");

        return myString;
    }

    public void printPageSource() throws Exception {
        System.out.println(driver.get().getPageSource());
    }

    public String getSourceOfPageIDB() throws Exception {
//        System.out.println("Start Get Source of Page");
        String myString;
        String myUdid;

        //Get the udid of the connected device
        myUdid = driver.get().getCapabilities().getCapability("udid").toString();

        myString = idbConnectDescribeAll(myUdid);
//        idbConnect(myUdid);
//        myString = idbDescribeAll();

        System.out.println(myString);

        return myString;
    }

    public void checkSourceString(String pageSource, String textToCheck) throws Exception {
        if (pageSource.contains(textToCheck)){
            Assert.assertTrue(true);
        } else {
            System.out.println("Not Found: " + textToCheck);
            Assert.assertTrue(false);
        }
    }

    public void checkSource(String pageSource, List<String> myList) throws Exception {
        for(String oneLine : myList){
            //System.out.println("TEXT: " + oneLine);
            checkSourceString(pageSource, oneLine);
        }
    }

    public void apiCheckDataPageSource(List<String> jsonList, String pageSource) throws Exception {

        for (String apiUser : jsonList) {
            System.out.println("API Data: "  + apiUser);
            Assert.assertTrue(checkNoCaseList(apiUser, pageSource, "Contains"));
        }

    }

    public void apiCheckData(List<String> jsonList) throws Exception {
        String pageSource = null;
        pageSource = getSourceOfPage();
//        newScrollIosAndroid();
//        pageSource = pageSource + getSourceOfPage();
//        System.out.println(pageSource);

        for (String apiUser : jsonList) {
            System.out.println("API Data: "  + apiUser);
            Assert.assertTrue(checkNoCaseList(apiUser, pageSource, "Contains"));
        }

    }

    public void compareWebData(List<String> myList, List<String> androidList, Boolean onePage) throws Exception {
        String pageSource = null;
        int pageSize;
        String lastMember;
        String lastMemberCheck;

        String memberToSelect;

        if (getOS().equals("ios")){
            pageSource = getSourceOfPage();
            scrollDownIOS();
            pageSource = pageSource + getSourceOfPage();
            //System.out.println("*************************************");
            //System.out.println(pageSource);
            //System.out.println("*************************************");
            for(String oneUser : myList){
                System.out.println("USER: " + oneUser);
                if ((oneUser.contains("Jr")) || (oneUser.contains("Salvador")) || (oneUser.contains("Junior") || (oneUser.contains("Farley")
                        || (oneUser.contains("Raymundo") || (oneUser.contains("Sarwar") ||(oneUser.contains("Dylan") || (oneUser.contains("Siteni")
                        || (oneUser.contains("Ah Kam") || (oneUser.contains("Peterson") || (oneUser.contains("Latu") ||(oneUser.contains("Morgan")
                        || (oneUser.contains("Nouata") || (oneUser.contains("Lili") || (oneUser.contains("Hyppolito") || (oneUser.contains("Wilson, Tina")))))))))))))))){
                    System.out.println("Skipping: " + oneUser);
                } else {
                    Assert.assertTrue(checkNoCaseList(oneUser, pageSource, "Contains"));
                }

            }

        } else {

            if (onePage == false ) {
                pageSize = driver.get().manage().window().getSize().getHeight();
                //System.out.println("Page Size: " + pageSize);
                //pageSize = pageSize - 20;
                //System.out.println("Orig Page Size: " + pageSize);
                //pageSize = pageSize / 2;
                pageSize = pageSize / 2;
                //System.out.println("Page Size: " + pageSize);
                //pageSize = (pageSize / 2 ) + pageSize;
                //System.out.println("3/4 Page Size: " + pageSize);
                //pageSize = -pageSize;



                //This will scroll through the android pages and get all of the data.
                do {
                    pageSource = getSourceOfPage();
                    androidList = createUserList(androidList, pageSource);
                    if (androidList.size() == 0) {
                        lastMember = "none";
                        lastMemberCheck = "none";
                    } else {
                        lastMember = androidList.get(androidList.size() - 1 );

                        scrollDownSlow(pageSize);
                        Thread.sleep(1000);
                        pageSource = pageSource + getSourceOfPage();
                        androidList = createUserList(androidList, pageSource);
                        lastMemberCheck = androidList.get(androidList.size() - 1 );
                        //System.out.println("Last Member: " + lastMember);
                        //System.out.println("Last Member Check: " + lastMemberCheck);
                    }

                } while (!lastMember.equals(lastMemberCheck));


                //System.out.println("***************************");
                //pageSource = getSourceOfPage();
                //androidList = createUserList(androidList, pageSource);
                //System.out.println("***************************");

                for(String oneUser : myList) {
                    System.out.println("USER: " + oneUser);
                    if ((oneUser.contains("Jr")) || (oneUser.contains("Salvador")) || (oneUser.contains("Junior") || (oneUser.contains("Farley")
                            || (oneUser.contains("Raymundo") || (oneUser.contains("Dylan") || (oneUser.contains("Siteni")
                            || (oneUser.contains("Morgan") || (oneUser.contains("Lott")|| (oneUser.contains("Wilson, Tina")))))))))){
                        System.out.println("Skipping: " + oneUser);
                    } else {
                        Assert.assertTrue(androidList.contains(oneUser));
                    }
                }
            } else {
                //driver.get().getPageSource();
                pageSource = getSourceOfPage();
                androidList.clear();
                androidList = createUserList(androidList, pageSource);
                //androidList = getAllText();
				/*
				for(String oneUser : androidList) {
					System.out.println("USER: " + oneUser);
					if ((oneUser.contains("Jr")) || (oneUser.contains("Salvador")) || (oneUser.contains("Junior"))){
						System.out.println("Skipping: " + oneUser);
					} else {
						Assert.assertTrue(myList.contains(oneUser));
					}
				}
				*/
                //System.out.println("###### Printing List #######");
                //for (int x = 0 ; x < myList.size() ; x++ )	{
                //	System.out.println(myList.get(x));
                //}
                //System.out.println("###### Done Printing List #######");
                System.out.println("****** Android Users ******");
                if(!myList.isEmpty()) {
                    for(int myCounter = 0 ; myCounter < androidList.size() ; myCounter++) {
                        if ((myList.get(myCounter).contains("Jr")) || (myList.get(myCounter).contains("Salvador"))
                                || (myList.get(myCounter).contains("Joseph")) || (myList.get(myCounter).contains("Junior"))) {
                            System.out.println("Skipping: " + myList.get(myCounter));
                        } else {
                            System.out.println("Android USER: " + androidList.get(myCounter));
                            Assert.assertTrue(myList.contains(androidList.get(myCounter)));
                        }
                    }
                }
                System.out.println("****** Done Android Users ******");
            }


        }
    }

    public List<String> createUserList(List<String> userList, String pageSource){
        Document doc = Jsoup.parse(pageSource);
        Elements myTest = doc.getAllElements();
        String foundText;

        for (Element myElement : myTest ) {
            //System.out.println("Searching for user: ");
            //System.out.println(myElement.attributes().get("value"));
            if (!myElement.attributes().get("text").equals("")) {
                foundText = myElement.attributes().get("text");
                //foundText = foundText.toLowerCase();
                if ((!foundText.isEmpty()) && (foundText.contains(","))){
                    if ((foundText.contains("2015")) || (foundText.contains("2016"))){
                        //System.out.println("Date? :" + foundText);
                    } else {
                        userList.add(foundText);
                        System.out.println("Adding User: " + foundText);
                    }

                }


                //System.out.println("******************************");
                //System.out.println("Found Text:" + foundText);
                //System.out.println("Text To Check: " + textToCheck);
                //System.out.println("******************************");
            }
        }
        return userList;
    }

    public List<String> swapLastName(List<String> listToSwitch) throws Exception {
        String userSwitch;

        for (int myCounter = 0; myCounter < listToSwitch.size(); myCounter++) {
            String[] parts = listToSwitch.get(myCounter).split(" ");
            if (parts.length == 1) {
                listToSwitch.set(myCounter, parts[0]);
            } else {
                String part1 = parts[0];
                //part1 = part1.replace(",", "");
                String part2 = parts[1];
                userSwitch = part2 + ", " + part1;
                System.out.println("SWITCH: " + userSwitch);
                listToSwitch.set(myCounter, userSwitch);
            }

        }

        return listToSwitch;

    }

    public boolean checkForAlert() throws Exception {
        //Check to see if we are getting a warning
        if (checkForElement(alertCheck)) {
            return true;
        }
        return false;
    }

    public void backToDirectory() throws Exception {
        Thread.sleep(2000);
        if (getOS().equals("ios")) {
            System.out.println("BACK TO DIRECTORY!");
            pressBackToRoot();
            Thread.sleep(2000);

//            System.out.println("Try to clear text");
//            clickByCords("Clear text");
//            clickByCords("Cancel");
            Thread.sleep(2000);
            if (checkForElement(cancel)) {
                cancel.click();
            }


        } else {
            //System.out.println("Start of Back To Root");
            pressBackToRoot();
            //System.out.println("End of Back To Root");
            Thread.sleep(3000);
            //System.out.println("Start of Search Collapse");
            if (checkForElement(searchCollapse)) {
                searchCollapse.click();
            }

            //System.out.println("End of Search Collapse");
        }
        Thread.sleep(2000);
    }

    public void pressBackToRoot() throws Exception {
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        Boolean backButtonCheck;
        String myMenuTitle;

        int myCounter = 1;
        //backButtonCheck = checkElementExistsByXpath("TopBack");
        //Android could have two different back buttons for now.
        if (getOS().equalsIgnoreCase("android")) {
            if (checkForElement(backAltButton)) {
                backButtonCheck = checkForElement(backAltButton);
            } else {
                backButtonCheck = checkForElement(backButton);
            }
        } else {
            backButtonCheck = checkForElement(backButton);
        }



        System.out.println("Back Button Check - before loop: " + backButtonCheck);

        while (backButtonCheck)  {
            Thread.sleep(1000);

//            System.out.println(getSourceOfPage());
            if (checkForElement(myDirectory.searchCancel)) {
                System.out.println("Hitting Cancel!");
                waitForElementThenClick(myDirectory.searchCancel);
            } else {
                System.out.println("Pressing Back Key " + myCounter);
                if (getOS().equalsIgnoreCase("android")) {
                    if (checkForElement(backAltButton)) {
                        backAltButton.click();
                    }
                    if (checkForElement(backButton)) {
                        backButton.click();
                    }
                } else {
                    backButton.click();
                }
                Thread.sleep(2000);
                System.out.println("Back Key pressed");
            }


            if (checkForElement(menuTitle)) {
                myMenuTitle = menuTitle.getText();
            } else {
                myMenuTitle = "No Title";
            }

            System.out.println("MENU TITLE: " + myMenuTitle);

            switch (myMenuTitle) {
                case "Directory" :
                    backButtonCheck = false;
                    break;
                case "Organizations" :
                    backButtonCheck = false;
                    break;
                case "Calendar" :
                    backButtonCheck = false;
                    break;
                case "Reports" :
                    backButtonCheck = false;
                    break;
                case "Lists" :
                    backButtonCheck = false;
                    break;
                case "Missionary" :
                    backButtonCheck = false;
                    break;
                case "Meetinghouses" :
                    backButtonCheck = false;
                    break;
                case "Temples" :
                    backButtonCheck = false;
                    break;
                case "More" :
                    backButtonCheck = false;
                    break;
                case "Finance" :
                    backButtonCheck = false;
                    break;
                default :
                    backButtonCheck = true;
            }

            if (checkForElement(searchCollapse)) {
                backButtonCheck = false;
            }

            if (checkForElement(drawerButtonNew)) {
                backButtonCheck = false;
            }

            if (myCounter > 6) {
                backButtonCheck = false;
            }

            Thread.sleep(2000);
            System.out.println("Back Button Check in loop: "+ myCounter + " Check: " + backButtonCheck);
            myCounter++;
        }

        //System.out.println("Press Back Key Done");

    }

    public void clickByCords(String elementName) throws Exception {
        WebElement myElement = null;
        TouchAction myAction = new TouchAction((PerformsTouchActions) driver.get());
//        Thread.sleep(2000);

        System.out.println("Start Click by Cords");
        System.out.println(getSourceOfPage());
        myElement = (WebElement) driver.get().findElement(By.name(elementName));
        Point myPoint = myElement.getLocation();
        myAction.press(PointOption.point(myPoint.x, myPoint.y)).release();
        ((PerformsTouchActions) driver.get()).performTouchAction(myAction);
        System.out.println("End Click by Cords");
    }

    public void clickEndOfElementByCords(WebElement elementName) throws Exception {
        WebElement myElement = null;
        TouchAction myAction = new TouchAction((PerformsTouchActions) driver.get());
        int pointToClickX;
        int pointToClickY;

//        System.out.println("Start Click by Cords");
        Point myPoint = elementName.getLocation();
        Dimension myDimension = elementName.getSize();
//        System.out.println("X: " + myPoint.x);
//        System.out.println("Y: " + myPoint.y);
//        System.out.println("Width: " + myDimension.width);
//        System.out.println("Width: " + myDimension.height);

        pointToClickX = myPoint.x + myDimension.width;
        pointToClickY = myPoint.y + myDimension.height;
//        System.out.println("Point To Click X: " + pointToClickX);
//        System.out.println("Point To Click Y: " + pointToClickY);
        myAction.press(PointOption.point( pointToClickX, pointToClickY )).release();
        ((PerformsTouchActions) driver.get()).performTouchAction(myAction);
//        System.out.println("End Click by Cords");
    }

    public void clickElementByCords(WebElement elementName) throws Exception {
        WebElement myElement = null;
        TouchAction myAction = new TouchAction((PerformsTouchActions) driver.get());


//        System.out.println("Start Click by Cords");
        Point myPoint = elementName.getLocation();
//        System.out.println("X: " + myPoint.x);
//        System.out.println("Y: " + myPoint.y);
//        System.out.println("Width: " + myDimension.width);
//        System.out.println("Width: " + myDimension.height);
//        System.out.println("Point To Click X: " + pointToClickX);
//        System.out.println("Point To Click Y: " + pointToClickY);
        myAction.press(PointOption.point( myPoint.x, myPoint.y )).release();
        ((PerformsTouchActions) driver.get()).performTouchAction(myAction);
//        System.out.println("End Click by Cords");
    }




    public void  iosClickUseThisLocation() throws Exception {
        int useThisLocationX;
        int useThisLocationY;
        int useThisLocationWidth;
        int useThisLocationHeight;
        //useThisLocationX = driver.get().findElement(MobileBy.iOSNsPredicateString("name == 'Legal'")).getLocation().getX();
        //useThisLocationY = driver.get().findElement(MobileBy.iOSNsPredicateString("name == 'Legal'")).getLocation().getY();
        //useThisLocationWidth = driver.get().findElement(MobileBy.iOSNsPredicateString("name == 'Legal'")).getSize().getWidth();

        useThisLocationX = driver.get().findElement(MobileBy.iOSNsPredicateString("name == 'Search results'")).getLocation().getX();
        useThisLocationY = driver.get().findElement(MobileBy.iOSNsPredicateString("name == 'Search results'")).getLocation().getY();
        useThisLocationWidth = driver.get().findElement(MobileBy.iOSNsPredicateString("name == 'Search results'")).getSize().getWidth();
        useThisLocationHeight = driver.get().findElement(MobileBy.iOSNsPredicateString("name == 'Search results'")).getSize().getHeight();

        //System.out.println("X: " + useThisLocationX);
        //System.out.println("Y: " + useThisLocationY);
        //System.out.println("W: " + useThisLocationWidth);

        //new TouchAction(driver).tap(useThisLocationX+ useThisLocationWidth + 20, useThisLocationY ).release().perform();
        //new TouchAction(driver).tap(useThisLocationX, useThisLocationY - 50 ).release().perform();
        new TouchAction((PerformsTouchActions) driver.get()).press(PointOption.point(useThisLocationX, useThisLocationY - 50)).release().perform();
    }

    public void clickAboveElement(WebElement myElement) throws Exception {
        int useThisLocationX;
        int useThisLocationY;

        useThisLocationX = myElement.getLocation().getX();
        useThisLocationY = myElement.getLocation().getY();

        System.out.println("Click above element - X: "  + useThisLocationX + " Y: " + useThisLocationY);

        new TouchAction((PerformsTouchActions) driver.get()).press(PointOption.point(useThisLocationX, useThisLocationY - 50)).release().perform(); //50
    }

    public String idbConnectDescribeAll(String myUdid) throws Exception {
        String line;
        Runtime run = Runtime.getRuntime();
        Process pr;
        BufferedReader buf;
        System.out.println("UDID: "  + myUdid);

//        System.out.println("START idb kill: ");
//        pr = run.exec(new String[] {"/bin/bash", "-c", "idb kill"});
//        pr.waitFor();
//        buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//        line = buf.readLine();
//        System.out.println("idb kill: " + line);

        Thread.sleep(2000);

        System.out.println("START idb_companion: ");
        pr = run.exec(new String[] {"/bin/bash", "-c", "idb_companion"});
        pr.waitFor();
        buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        line = buf.readLine();
        System.out.println("idb_companion: " + line);

        Thread.sleep(2000);

        System.out.println("START idb list-targets: ");
        pr = run.exec(new String[] {"/bin/bash", "-c", "idb list-targets"});
        pr.waitFor();
        buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        line = buf.readLine();
        System.out.println("idb list-targets: " + line);

        Thread.sleep(2000);

        System.out.println("START idb connect: ");
        pr = run.exec(new String[] {"/bin/bash", "-c", "idb connect " + myUdid});
        pr.waitFor();
        buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        line = buf.readLine();
        System.out.println("idb connect: " + line);

        Thread.sleep(8000);

        System.out.println("START idb ui describe-all ");
        pr = run.exec(new String[] {"/bin/bash", "-c", "idb ui describe-all"});
        pr.waitFor();
        buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        line = buf.readLine();

        return line;
    }

    public String idbDescribeAll() throws Exception {
        String line;
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(new String[] {"/bin/bash", "-c", "idb", "ui", "describe-all"});
        pr.waitFor();

        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        line = buf.readLine();
        //System.out.println(line);
        return line;
    }

    public List<String> swapLastNameCommaFirstName (List<String> memberList) {
        List<String> memberListIos = new ArrayList<String>();
        String memberFirstName;
        String memberLastName;
        for (String fullName : memberList) {
            String[] myMemberName = fullName.split(",");
            memberLastName = myMemberName[0].trim();
            memberFirstName = myMemberName[1].trim();
            memberListIos.add(memberFirstName + " " + memberLastName);
        }
        return memberListIos;

    }

    public void androidSpinnerList() throws Exception {
        int counter = 0;
        List<WebElement> spinnerList = driver.get().findElements(By.id("org.lds.ldstools.alpha:id/categoryAutoCompleteTextView"));
        for (WebElement spinnerText : spinnerList) {
            spinnerText = spinnerList.get(counter);
            System.out.println(spinnerText.getText());
            counter++;
        }
     }


    public void changeUnit(String myUnit) throws Exception {
        BasePage myBase = new BasePage(driver);

        //Choose different Unit
        unitSelected.click();
        Thread.sleep(2000);
        if (myBase.getOS().equalsIgnoreCase("ios")) {
            driver.get().findElement(By.xpath("//*[contains(@name,'" + myUnit + "')]")).click();
        } else {
            driver.get().findElement(By.xpath("//*[contains(@text,'" + myUnit + "')]")).click();
        }

    }


}
