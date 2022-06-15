package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import org.testng.Assert;


public class TemplesScreen extends BasePage {

    public TemplesScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Temple Main Screen ******************
    // Days till expiration
//    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='android:id/input']")
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_input_message")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/editText")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeTextField[@value='Days until expiration']")
    public WebElement templeDaysExpiration;

    //Remind Me Later
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/remindMeLaterTextView")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Remind me later'")
    public WebElement remindMeLater;

    //Contact Bishopric
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/contactBishopricTextView")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Contact bishopric'")
    public WebElement contactBishopric;

    //Got It Thanks
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/gotItThanksTextView")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Got it, thanks'")
    public WebElement gotItThanks;



    //iOS Temple Selector
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, '▾')]")
    public WebElement templePullDown;



    // Search
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterEditText")
    @iOSXCUITFindBy(accessibility = "Search")
    public WebElement searchTemple;




    //No Thanks
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'No thanks'")
    public WebElement noThanks;

    //Yes, remind me
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_button_positive")
    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Yes, remind me'")
    public WebElement yesRemindMe;


    //Temple Tab Mine
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MINE']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'My Temple')]")
    public WebElement mineTab;

    //Temple Tab Nearest
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NEAREST']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Nearest Temples')]")
    public WebElement nearestTab;

    //Temple Tab All
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ALL']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'All Temples')]")
    public WebElement allTab;




    // ******************** Ordinance Schedule ********************
    //Ordinance Schedule Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/ordinanceScheduleButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ordinance Schedule']")
    @iOSXCUITFindBy(accessibility = "Ordinance Schedule")
    public WebElement ordinanceScheduleButton;

    //All Ordinances Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/ordinanceTextView")
    @iOSXCUITFindBy(accessibility = "All Ordinances")
    public WebElement allOrdinancesButton;

        //All Ordinances Selection
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'All Ordinances')]")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'All Ordinances')]")
        public WebElement allOrdinancesSelection;

        //Endowment Selection
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Endowment')]")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Endowment')]")
        public WebElement endowmentSelection;

        //Baptism Selection
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Baptism')]")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Baptism')]")
        public WebElement baptismSelection;

        //Initiatory Selection
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Initiatory')]")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Initiatory')]")
        public WebElement initiatorySelection;

        //Sealing Selection
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Sealing')]")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Sealing')]")
        public WebElement sealingSelection;

    //Date
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/dateTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeButton[2]")
    public WebElement templeDate;

    //Next Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/nextNavigationImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Button'][2]")
    public WebElement nextButton;

    //Previous Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/previousNavigationImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Button']")
    public WebElement previousButton;


    //Prayer Roll Stuff
    //Prayer Roll Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/prayerRollButton")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Prayer Roll')]")
    @iOSXCUITFindBy(accessibility = "Prayer Roll")
    public WebElement prayerRollButton;

    //Prayer Roll 1st Name Field
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[5]")
    public WebElement prayerRoll1stName;

    //Prayer Roll 2nd Name Field
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[1]")
    public WebElement prayerRoll2ndName;

    //Prayer Roll 3rd Name Field
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[2]")
    public WebElement prayerRoll3rdName;

    //Prayer Roll 4th Name Field
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[4]/android.widget.FrameLayout/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[3]")
    public WebElement prayerRoll4thName;

    //Prayer Roll 5th Name Field
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[5]")
    public WebElement prayerRoll5thName;

    //Prayer Roll Submit Names
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/submitButton")
    @iOSXCUITFindBy(accessibility = "Submit Names")
    public WebElement prayerRollSubmitNames;

    //Prayer Roll Cancel Button
//    @AndroidFindBy(accessibility = "Navigate up")
    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    @iOSXCUITFindBy(accessibility = "Back")
    public WebElement prayerRollCancelButton;




    public void chooseDifferentTab(WebElement myElement ) throws Exception {
        BasePage myBasePage = new BasePage(driver);

        if (myBasePage.getOS().contains("ios")) {
            waitForElementThenClick(templePullDown);
        }
        waitForElementThenClick(myElement);
    }


    public void enableTempleRecommendReminder(String numberOfDays, WebElement recommendStatus, WebElement numberOfWeeks) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ScannerScreen myScanner = new ScannerScreen(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        if (myBasePage.getOS().equals("ios")) {
            //Go to Developer Settings
            myMenu.selectMenu(myMenu.help);
            if (myScanner.scannerCheckForText("Developer Settings") ) {
                myBasePage.waitForElementThenClick(myLoginPage.developerButton);
            } else {
                for (int x = 1; x <= 5; x++) {
                    myBasePage.waitForElementThenClick(myLoginPage.enterDeveloperButton);
                }
            }
            //Set the Temple Recommend Status
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                myBasePage.scrollDownToTextIOS("Set Temple Recommend Status");
            }
            myBasePage.waitForElementThenClick(mySettings.templeRecommendStatus);
            Thread.sleep(500);
            myBasePage.waitForElementThenClick(recommendStatus);
            Thread.sleep(500);
            //Set the number of Days until expired
            myBasePage.waitForElementThenClick(mySettings.overrideTempleRecommendExpiration);
            mySettings.templeDaysUntilExpiration.sendKeys(numberOfDays);
            myBasePage.waitForElementThenClick(mySettings.alertOK);
            myBasePage.waitForElementThenClick(myBasePage.backButton);
            Thread.sleep(1000);
            myBasePage.waitForElementThenClick(myBasePage.backButton);
            //Open Settings
            Thread.sleep(2000);
            myMenu.selectMenu(myMenu.settings);
            myBasePage.waitForElementThenClick(mySettings.templeRecommendReminder);
            Thread.sleep(2000);
            numberOfWeeks.click();
            myMenu.selectMenu(myMenu.temples);
            Thread.sleep(10000);
            myBasePage.waitForText("Set a Temple Recommend Expiration Reminder");
            Assert.assertTrue(myBasePage.checkTextOnPage("Set a Temple Recommend Expiration Reminder"));
            Assert.assertTrue(myBasePage.checkTextOnPage("Would you like to be reminded before your temple recommend expires?"));
            myBasePage.waitForElementThenClick(yesRemindMe);
            if (myBasePage.getOS().equals("ios")) {
                Thread.sleep(4000);
                myBasePage.backButton.click();
            }
            myMenu.selectMenu(myMenu.directory);
            myMenu.selectMenu(myMenu.temples);
        } else {
            //Open Settings
            myMenu.selectMenu(myMenu.settings);
            //Scroll down and Reset Temple Preferences
            myMenu.scrollToTextRecyclerViewSettings("Temple Recommend Status");
//            myMenu.scrollToText("Temple Recommend Status");
            mySettings.resetAllTempelPreferences.click();
            Thread.sleep(500);
            //Set the Recommend Status
            myBasePage.waitForElementThenClick(mySettings.templeRecommendStatus);
            Thread.sleep(500);
            myBasePage.waitForElement(recommendStatus);
            recommendStatus.click();
            Thread.sleep(500);
            //Set the Number of days for the expiration
            myBasePage.waitForElementThenClick(mySettings.overrideTempleRecommendExpiration);
            Thread.sleep(3000);
            templeDaysExpiration.sendKeys(numberOfDays);
            mySettings.alertOK.click();
            myBasePage.backButton.click();
            //Open Settings and enable Recommend
            Thread.sleep(2000);
            myMenu.selectMenu(myMenu.settings);
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                myBasePage.scrollTextIntoViewAndroid("Remind me", 4);
            } else {
                myBasePage.scrollTextIntoViewAndroid("Show Temple Recommend Expiration", 4);
            }

            myBasePage.waitForElementThenClick(mySettings.templeShowTempleRecommendExpiration);
            myBasePage.scrollTextIntoViewAndroid("Remind me", 4);
            myBasePage.waitForElementThenClick(mySettings.templeRecommendReminder);
            myBasePage.checkForElement(numberOfWeeks);
            numberOfWeeks.click();
            myBasePage.backButton.click();
            myMenu.selectMenu(myMenu.temples);
        }
    }
}
