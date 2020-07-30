package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.SearchContext;
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
//    @AndroidFindBy(id = "md_input_message")
    @AndroidFindBy(id = "editText")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeTextField[@value='Days until expiration']")
    public MobileElement templeDaysExpiration;

    //Remind Me Later
    @AndroidFindBy(id = "remindMeLaterTextView")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Remind me later'")
    public MobileElement remindMeLater;

    //Contact Bishopric
    @AndroidFindBy(id = "contactBishopricTextView")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Contact bishopric'")
    public MobileElement contactBishopric;

    //Got It Thanks
    @AndroidFindBy(id = "gotItThanksTextView")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Got it, thanks'")
    public MobileElement gotItThanks;



    //iOS Temple Selector
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, '▾')]")
    public MobileElement templePullDown;



    // Search
    @AndroidFindBy(id = "filterEditText")
    @iOSXCUITFindBy(accessibility = "Search")
    public MobileElement searchTemple;




    //No Thanks
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'No thanks'")
    public MobileElement noThanks;

    //Yes, remind me
    @AndroidFindBy(id = "md_button_positive")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Yes, remind me'")
    public MobileElement yesRemindMe;


    //Temple Tab Mine
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MINE']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'My Temple')]")
    public MobileElement mineTab;

    //Temple Tab Nearest
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NEAREST']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Nearest Temples')]")
    public MobileElement nearestTab;

    //Temple Tab All
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ALL']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'All Temples')]")
    public MobileElement allTab;




    // ******************** Ordinance Schedule ********************
    //Ordinance Schedule Button
    @AndroidFindBy(id = "ordinanceScheduleButton")
    @iOSXCUITFindBy(accessibility = "Ordinance Schedule")
    public MobileElement ordinanceScheduleButton;

    //All Ordinances Button
    @AndroidFindBy(id = "ordinanceTextView")
    @iOSXCUITFindBy(accessibility = "All Ordinances")
    public MobileElement allOrdinancesButton;

        //All Ordinances Selection
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'All Ordinances')]")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'All Ordinances')]")
        public MobileElement allOrdinancesSelection;

        //Endowment Selection
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Endowment')]")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Endowment')]")
        public MobileElement endowmentSelection;

        //Baptism Selection
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Baptism')]")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Baptism')]")
        public MobileElement baptismSelection;

        //Initiatory Selection
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Initiatory')]")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Initiatory')]")
        public MobileElement initiatorySelection;

        //Sealing Selection
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Sealing')]")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Sealing')]")
        public MobileElement sealingSelection;

    //Date
    @AndroidFindBy(id = "dateTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeButton[2]")
    public MobileElement templeDate;

    //Next Button
    @AndroidFindBy(id = "nextNavigationImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Button'][2]")
    public MobileElement nextButton;

    //Previous Button
    @AndroidFindBy(id = "previousNavigationImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Button']")
    public MobileElement previousButton;




    public void chooseDifferentTab(MobileElement myElement ) throws Exception {
        BasePage myBasePage = new BasePage(driver);

        if (myBasePage.getOS().contains("ios")) {

            templePullDown.click();
        }

        myElement.click();

    }


    public void enableTempleRecommendReminder(String numberOfDays, MobileElement recommendStatus, MobileElement numberOfWeeks) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        SettingsScreen mySettings = new SettingsScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ScannerScreen myScanner = new ScannerScreen(driver);
        LoginPageScreen myLoginPage = new LoginPageScreen(driver);

        if (myBasePage.getOS().equals("ios")) {
            //Go to Developer Settings
            myMenu.selectMenu(myMenu.help);

            if (myScanner.scannerCheckForText("Developer Settings") ) {
                myLoginPage.developerButton.click();
            } else {
                for (int x = 1; x <= 5; x++) {
                    myLoginPage.enterDeveloperButton.click();
                }
            }

            //Thread.sleep(2000);

            //Set the Temple Recommend Status
            mySettings.templeRecommendStatus.click();
            ///Thread.sleep(2000);
            recommendStatus.click();
            Thread.sleep(2000);


            //Set the number of Days until expired
            myBasePage.scrollDownToTextIOS("Set Temple Recommend Expiration");
            mySettings.overrideTempleRecommendExpiration.click();
            mySettings.templeDaysUntilExpiration.setValue(numberOfDays);
            mySettings.alertOK.click();

            myBasePage.backButton.click();
            myBasePage.backButton.click();


            //Open Settings
            myMenu.selectMenu(myMenu.settings);
            mySettings.templeRecommendReminder.click();

            numberOfWeeks.click();

            myMenu.selectMenu(myMenu.temples);

            Thread.sleep(10000);
            Assert.assertTrue(myBasePage.checkTextOnPage("Set a Temple Recommend Expiration Reminder"));
            Assert.assertTrue(myBasePage.checkTextOnPage("Would you like to be reminded before your temple recommend expires?"));

            yesRemindMe.click();

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
            myMenu.scrollToTextRecyclerView("Temple Recommend Status");
//            myMenu.scrollToText("Temple Recommend Status");
            mySettings.resetAllTempelPreferences.click();
            Thread.sleep(2000);

            //Set the Recommend Status
            mySettings.templeRecommendStatus.click();
            recommendStatus.click();
            Thread.sleep(2000);


            //Set the Number of days for the expiration
            mySettings.overrideTempleRecommendExpiration.click();
            Thread.sleep(3000);
//            System.out.println(myBasePage.getSourceOfPage());
            templeDaysExpiration.setValue(numberOfDays);
            mySettings.alertOK.click();
            myBasePage.backButton.click();

            //Open Settings and enable Recommend
            Thread.sleep(2000);
            myMenu.selectMenu(myMenu.settings);

            myBasePage.scrollToTextGeneral("Show Temple Recommend Expiration");
            mySettings.templeShowTempleRecommendExpiration.click();
            mySettings.templeRecommendReminder.click();

            numberOfWeeks.click();

            myBasePage.backButton.click();
            myMenu.selectMenu(myMenu.temples);


        }
    }

}
