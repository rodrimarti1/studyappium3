package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class SettingsScreen extends BasePage {

    public SettingsScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }

    //Sign Out
    @AndroidFindBy(xpath = "//*[contains(@text, 'Sign Out')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Sign Out' AND type == 'XCUIElementTypeStaticText'")
    public WebElement signOut;



    // ********* PIN Stuff *********

    //Change Your PIN - Update Passscode
    @AndroidFindBy(xpath = "//*[contains(@text, 'Create a PIN')]")
    public WebElement createAPIN;



    //Change Your PIN - Update Passscode
    @AndroidFindBy(xpath = "//*[contains(@text, 'Change Your PIN')]")
    @iOSXCUITFindBy(accessibility = "Update Passcode")
    public WebElement changeYourPIN;

    //Update Passcode
    @iOSXCUITFindBy(accessibility = "Update Passcode")
    public WebElement updatePasscodePIN;




    // ********* Calendar *********
    //Months to Show
    @AndroidFindBy(xpath = "//*[contains(@text, 'Months to Show')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'Calendar Months')]")
    public  WebElement monthsToShow;

    // ********* Caller ID *********
    //Enable Simple Caller ID
    @AndroidFindBy(xpath = "//*[contains(@text, 'Enable Simple Caller ID')]")
    public  WebElement enableSimpleCallerID;

    //iOS Reset Caller ID Database
    @iOSXCUITFindBy(accessibility = "Reset Caller ID Database")
    public WebElement resetCallerIDDatabase;

    //Ignore Personal Contacts
    @AndroidFindBy(xpath = "//*[contains(@text, 'Ignore Personal Contacts')]")
    public  WebElement ignorePersonalContacts;

    //Caller ID Check Digits
    @AndroidFindBy(xpath = "//*[contains(@text, 'Caller ID Check Digits')]")
    public  WebElement callerIDCheckDigits;

        //Digits
        @AndroidFindBy(xpath = "//*[@text='4']")
        public  WebElement callerID4;

        @AndroidFindBy(xpath = "//*[@text='5']")
        public  WebElement callerID5;

        @AndroidFindBy(xpath = "//*[@text='6']")
        public  WebElement callerID6;

        @AndroidFindBy(xpath = "//*[@text='7']")
        public  WebElement callerID7;

        @AndroidFindBy(xpath = "//*[@text='8']")
        public  WebElement callerID8;

        @AndroidFindBy(xpath = "//*[@text='9']")
        public  WebElement callerID9;

        @AndroidFindBy(xpath = "//*[@text='10']")
        public  WebElement callerID10;

        @AndroidFindBy(xpath = "//*[@text='11']")
        public  WebElement callerID11;

        @AndroidFindBy(xpath = "//*[@text='12']")
        public  WebElement callerID12;

        @AndroidFindBy(xpath = "//*[@text='13']")
        public  WebElement callerID13;

        @AndroidFindBy(xpath = "//*[@text='14']")
        public  WebElement callerID14;

        @AndroidFindBy(xpath = "//*[@text='15']")
        public  WebElement callerID15;


    // ********* Other *********
    //Download Thumbnails
    @AndroidFindBy(xpath = "//*[contains(@text, 'Download Thumbnails')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Download Photos'")
    public  WebElement downloadThumbnails;

    // ********* Additional Settings *********
    //Featured Apps
    @AndroidFindBy(xpath = "//*[contains(@text, 'Featured Apps')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Featured Apps'")
    public  WebElement featuredApps;

    //About
    @AndroidFindBy(xpath = "//*[@text='About']")
    @iOSXCUITFindBy(accessibility = "About")
    public  WebElement about;

    //Rights and Use Information
    @AndroidFindBy(xpath = "//*[@text='Rights and Use Information']")
    @iOSXCUITFindBy(accessibility = "Rights and Use Information")
    public  WebElement rightsAndUseInformation;

    //Privacy Policy
    @AndroidFindBy(xpath = "//*[@text='Privacy Policy']")
    @iOSXCUITFindBy(accessibility = "Privacy Policy")
    public  WebElement privacyPolicy;

    //Acknowledgements
    @AndroidFindBy(xpath = "//*[@text='Acknowledgements']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Acknowledgements'")
    public  WebElement acknowledgements;

    //About Logo
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/aboutLogo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]")
    public  WebElement aboutLogo;

    // ********* Development *********
    //Ignore Maintenance Mode
    @AndroidFindBy(xpath = "//*[contains(@text, 'Ignore Maintenance Mode')]")
    @iOSXCUITFindBy(accessibility = "Ignore Maintenance Flag")
    public  WebElement ignoreMaintenanceMode;

    //HTTP Log Level
    @AndroidFindBy(xpath = "//*[contains(@text, 'HTTP Log Level')]")
    public  WebElement HTTPLogLevel;

        //NONE
        @AndroidFindBy(xpath = "//*[contains(@text, 'NONE')]")
        public  WebElement HTTPLogLevelNONE;

        //BASIC (Default)
        @AndroidFindBy(xpath = "//*[contains(@text, 'BASIC (Default)')]")
        public  WebElement HTTPLogLevelBASIC;

        //HEADERS
        @AndroidFindBy(xpath = "//*[contains(@text, 'HEADERS')]")
        public  WebElement HTTPLogLevelHEADERS;

        //BODY (Includes Headers)
        @AndroidFindBy(xpath = "//*[contains(@text, 'BODY (Includes Headers)')]")
        public  WebElement HTTPLogLevelBODY;


    //Log Analytics
    @AndroidFindBy(xpath = "//*[contains(@text, 'Log Analytics')]")
    public  WebElement logAnalytics;

    //Log Analytics - Display Time
    @AndroidFindBy(xpath = "//*[contains(@text, 'Log Analytics - Display Time')]")
    public  WebElement logAnalyticsDisplayTime;

    //Convert to Fake Data
    @AndroidFindBy(xpath = "//*[contains(@text, 'Convert to Fake Data')]")
    @iOSXCUITFindBy(accessibility = "Fake Data")
    public  WebElement convertToFakeData;

    //Sync Fake Data
    @AndroidFindBy(xpath = "//*[contains(@text, 'Sync Fake Data')]")
    public  WebElement syncFakeData;

    //Sync Threads
    @AndroidFindBy(xpath = "//*[contains(@text, 'Sync Threads')]")
    public  WebElement syncThreads;

    //Home/Visiting Teaching Months
    @AndroidFindBy(xpath = "//*[contains(@text, 'Home/Visiting Teaching Months')]")
    public  WebElement homeVisitingTeachingMonths;

    //Minutes Between Profile Prompts
    @AndroidFindBy(xpath = "//*[contains(@text, 'Minutes Between Profile Prompts')]")
    public  WebElement minutesBetweenProfilePrompts;

    //Ignore Whats New
    @AndroidFindBy(xpath = "//*[contains(@text, 'Ignore')]")
    public  WebElement ignoreWhatsNew;

    //Reset What's New Prompt
    @AndroidFindBy(xpath = "//*[contains(@text, 'New Prompt')]")
    public  WebElement resetWhatsNewPrompt;

    //Network Environment
    @AndroidFindBy(xpath = "//*[contains(@text, 'Network Environment')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Environment')]")
    public  WebElement networkEnvironment;

        //Production
        @AndroidFindBy(xpath = "//*[contains(@text, 'Production')]")
        @iOSXCUITFindBy(accessibility = "Prod")
        public  WebElement production;

        //UAT - UAT is now Stage
        @AndroidFindBy(xpath = "//*[contains(@text, 'UAT')]")
        @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Stage')]")
        //@iOSXCUITFindBy(accessibility = "UAT")
        public  WebElement UAT;

        //Proxy
        @AndroidFindBy(xpath = "//*[contains(@text, 'Proxy')]")
        @iOSXCUITFindBy(accessibility = "Proxy")
        public  WebElement proxy;

    //Proxy Username
    @AndroidFindBy(xpath = "//*[contains(@text, 'Proxy Username')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Proxy Username')]")
    public  WebElement proxyUsername;


    //Proxy Username Edit Text
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/editText")
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public  WebElement proxyUsernameEditText;

    //Proxy Username Edit Cancel
    @AndroidFindBy(xpath = "//*[@text='CANCEL']")
    public  WebElement proxyUsernameEditCancel;

    //Proxy Username Edit OK
    @AndroidFindBy(xpath = "//*[@text='OK']")
    public  WebElement proxyUsernameEditOK;

    //Select Proxy
    @AndroidFindBy(xpath = "//*[contains(@text, 'Select Proxy')]")
    public  WebElement selectProxy;

    //px_i
    @AndroidFindBy(xpath = "//*[contains(@text, 'px_i')]")
    @iOSXCUITFindBy(accessibility = "Id")
    public  WebElement proxyId;

    //px_u
    @AndroidFindBy(xpath = "//*[contains(@text, 'px_u')]")
    @iOSXCUITFindBy(accessibility = "Units")
    public  WebElement proxyUnits;

    //px_p
    @AndroidFindBy(xpath = "//*[contains(@text, 'px_p')]")
    @iOSXCUITFindBy(accessibility = "Positions")
    public  WebElement proxyPositions;


        //Proxy Edit Field
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/android:id/edit")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
        public WebElement proxyEditField;



        //Done ios OK android
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/android:id/button1")
        @iOSXCUITFindBy(accessibility = "Done")
        public WebElement proxyDone;




    //Prototypes
    @AndroidFindBy(xpath = "//*[contains(@text, 'Prototypes')]")
    public  WebElement prototypes;

    // ********* Development - Additional Units *********
    //Role Based Sync Rights
    @AndroidFindBy(xpath = "//*[contains(@text, 'Role Based Sync Rights')]")
    public  WebElement roleBasedSyncRights;

    //Fingerprint Required
    @AndroidFindBy(xpath = "//*[contains(@text, 'Fingerprint Required')]")
    public  WebElement fingerprintRequired;

    //Additional Unit Role
    @AndroidFindBy(xpath = "//*[contains(@text, 'Additional Unit Role')]")
    public  WebElement additionalUnitRole;

    // ********* Development - Temple *********
    //Reset All Temple Preferences
//    @AndroidFindBy(xpath = "//*[contains(@text, 'Reset All Temple Preferences')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Reset Temple Dev Settings')]")
    @iOSXCUITFindBy(accessibility = "Reset Temple Databases")
    public  WebElement resetAllTempelPreferences;

    //Override temple recommend expiration
//    @AndroidFindBy(xpath = "//*[contains(@text, 'Override temple recommend expiration')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Temple Recommend Expiration')]")
    @iOSXCUITFindBy(accessibility = "Set Temple Recommend Expiration")
    public  WebElement overrideTempleRecommendExpiration;

    //Temple Recommend Status
    @AndroidFindBy(xpath = "//*[contains(@text, 'Temple Recommend Status')]")
    @iOSXCUITFindBy(accessibility = "Set Temple Recommend Status")
    public  WebElement templeRecommendStatus;

        //UNKNOWN
        @AndroidFindBy(xpath = "//*[contains(@text, 'UNKNOWN')]")
        public  WebElement unknown;

        //ACTIVE
        @AndroidFindBy(xpath = "//*[contains(@text, 'ACTIVE')]")
        @iOSXCUITFindBy(accessibility = "Active/Expired")
        public  WebElement active;

        //LOST_OR_STOLEN
        @AndroidFindBy(xpath = "//*[contains(@text, 'LOST_OR_STOLEN')]")
        @iOSXCUITFindBy(accessibility = "Lost or Stolen")
        public  WebElement lostOrStolen;

        //CANCELED
        @AndroidFindBy(xpath = "//*[contains(@text, 'CANCELED')]")
        @iOSXCUITFindBy(accessibility = "Canceled")
        public  WebElement canceled;

        //EXPIRED
        @AndroidFindBy(xpath = "//*[contains(@text, 'EXPIRED')]")
        @iOSXCUITFindBy(accessibility = "Expired")
        public  WebElement expired;

        //Nonexpiring
        @iOSXCUITFindBy(accessibility = "Nonexpiring")
        public  WebElement nonExpiring;

        //Ignore
        @iOSXCUITFindBy(accessibility = "Ignore")
        public  WebElement ignore;


    //Enter Days until recommend expires
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='android:id/input']")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Days until expiration'")
    public WebElement templeDaysUntilExpiration;


    // Android Show Temple Recommend Expiration
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Show Temple Recommend Expiration']")
    public WebElement templeShowTempleRecommendExpiration;

    //Temple Weeks
    // 2 Weeks
    @AndroidFindBy(xpath = "//*[contains(@text, \"2 weeks\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == '2 weeks before expiration'")
    public WebElement temple2Weeks;

    // 4 Weeks
    @AndroidFindBy(xpath = "//*[contains(@text, \"4 weeks\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == '4 weeks before expiration'")
    public WebElement temple4Weeks;

    // 6 Weeks
    @AndroidFindBy(xpath = "//*[contains(@text, \"6 weeks\")]")
//    @iOSXCUITFindBy(iOSNsPredicate = "name == '6 weeks before expiration'")
    @iOSXCUITFindBy(accessibility = "6 weeks before expiration")
    public WebElement temple6Weeks;

    // 8 Weeks
    @AndroidFindBy(xpath = "//*[contains(@text, \"8 weeks\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == '8 weeks before expiration'")
    public WebElement temple8Weeks;




    //Temple Recommend Reminder
    @AndroidFindBy(xpath = "//*[@text='Remind me']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, \"Temple Recommend Reminder\")]")
    public WebElement templeRecommendReminder;


    //Cancel
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/button2")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  WebElement dialogCancel;

    // ******************** Mission Leader Limited Visibility ***************************

    //Mission Leader Limited Visibility
    @iOSXCUITFindBy(accessibility = "Mission Leader Limited Visibility")
    public  WebElement missionLeaderLimitedVisibility;


}
