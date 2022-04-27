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


public class SettingsScreen extends BasePage {

    public SettingsScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }

    //Sign Out
    @AndroidFindBy(xpath = "//*[contains(@text, 'Sign Out')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Sign Out' AND type == 'XCUIElementTypeStaticText'")
    public  MobileElement signOut;



    // ********* PIN Stuff *********

    //Change Your PIN - Update Passscode
    @AndroidFindBy(xpath = "//*[contains(@text, 'Create a PIN')]")
    public MobileElement createAPIN;



    //Change Your PIN - Update Passscode
    @AndroidFindBy(xpath = "//*[contains(@text, 'Change Your PIN')]")
    @iOSXCUITFindBy(accessibility = "Update Passcode")
    public MobileElement changeYourPIN;

    //Update Passcode
    @iOSXCUITFindBy(accessibility = "Update Passcode")
    public MobileElement updatePasscodePIN;




    // ********* Calendar *********
    //Months to Show
    @AndroidFindBy(xpath = "//*[contains(@text, 'Months to Show')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'Calendar Months')]")
    public  MobileElement monthsToShow;

    // ********* Caller ID *********
    //Enable Simple Caller ID
    @AndroidFindBy(xpath = "//*[contains(@text, 'Enable Simple Caller ID')]")
    public  MobileElement enableSimpleCallerID;

    //iOS Reset Caller ID Database
    @iOSXCUITFindBy(accessibility = "Reset Caller ID Database")
    public MobileElement resetCallerIDDatabase;

    //Ignore Personal Contacts
    @AndroidFindBy(xpath = "//*[contains(@text, 'Ignore Personal Contacts')]")
    public  MobileElement ignorePersonalContacts;

    //Caller ID Check Digits
    @AndroidFindBy(xpath = "//*[contains(@text, 'Caller ID Check Digits')]")
    public  MobileElement callerIDCheckDigits;

        //Digits
        @AndroidFindBy(xpath = "//*[@text='4']")
        public  MobileElement callerID4;

        @AndroidFindBy(xpath = "//*[@text='5']")
        public  MobileElement callerID5;

        @AndroidFindBy(xpath = "//*[@text='6']")
        public  MobileElement callerID6;

        @AndroidFindBy(xpath = "//*[@text='7']")
        public  MobileElement callerID7;

        @AndroidFindBy(xpath = "//*[@text='8']")
        public  MobileElement callerID8;

        @AndroidFindBy(xpath = "//*[@text='9']")
        public  MobileElement callerID9;

        @AndroidFindBy(xpath = "//*[@text='10']")
        public  MobileElement callerID10;

        @AndroidFindBy(xpath = "//*[@text='11']")
        public  MobileElement callerID11;

        @AndroidFindBy(xpath = "//*[@text='12']")
        public  MobileElement callerID12;

        @AndroidFindBy(xpath = "//*[@text='13']")
        public  MobileElement callerID13;

        @AndroidFindBy(xpath = "//*[@text='14']")
        public  MobileElement callerID14;

        @AndroidFindBy(xpath = "//*[@text='15']")
        public  MobileElement callerID15;


    // ********* Other *********
    //Download Thumbnails
    @AndroidFindBy(xpath = "//*[contains(@text, 'Download Thumbnails')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Download Photos'")
    public  MobileElement downloadThumbnails;

    // ********* Additional Settings *********
    //Featured Apps
    @AndroidFindBy(xpath = "//*[contains(@text, 'Featured Apps')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Featured Apps'")
    public  MobileElement featuredApps;

    //About
    @AndroidFindBy(xpath = "//*[@text='About']")
    @iOSXCUITFindBy(accessibility = "About")
    public  MobileElement about;

    //Rights and Use Information
    @AndroidFindBy(xpath = "//*[@text='Rights and Use Information']")
    @iOSXCUITFindBy(accessibility = "Rights and Use Information")
    public  MobileElement rightsAndUseInformation;

    //Privacy Policy
    @AndroidFindBy(xpath = "//*[@text='Privacy Policy']")
    @iOSXCUITFindBy(accessibility = "Privacy Policy")
    public  MobileElement privacyPolicy;

    //Acknowledgements
    @AndroidFindBy(xpath = "//*[@text='Acknowledgements']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Acknowledgements'")
    public  MobileElement acknowledgements;

    //About Logo
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/aboutLogo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]")
    public  MobileElement aboutLogo;

    // ********* Development *********
    //Ignore Maintenance Mode
    @AndroidFindBy(xpath = "//*[contains(@text, 'Ignore Maintenance Mode')]")
    @iOSXCUITFindBy(accessibility = "Ignore Maintenance Flag")
    public  MobileElement ignoreMaintenanceMode;

    //HTTP Log Level
    @AndroidFindBy(xpath = "//*[contains(@text, 'HTTP Log Level')]")
    public  MobileElement HTTPLogLevel;

        //NONE
        @AndroidFindBy(xpath = "//*[contains(@text, 'NONE')]")
        public  MobileElement HTTPLogLevelNONE;

        //BASIC (Default)
        @AndroidFindBy(xpath = "//*[contains(@text, 'BASIC (Default)')]")
        public  MobileElement HTTPLogLevelBASIC;

        //HEADERS
        @AndroidFindBy(xpath = "//*[contains(@text, 'HEADERS')]")
        public  MobileElement HTTPLogLevelHEADERS;

        //BODY (Includes Headers)
        @AndroidFindBy(xpath = "//*[contains(@text, 'BODY (Includes Headers)')]")
        public  MobileElement HTTPLogLevelBODY;


    //Log Analytics
    @AndroidFindBy(xpath = "//*[contains(@text, 'Log Analytics')]")
    public  MobileElement logAnalytics;

    //Log Analytics - Display Time
    @AndroidFindBy(xpath = "//*[contains(@text, 'Log Analytics - Display Time')]")
    public  MobileElement logAnalyticsDisplayTime;

    //Convert to Fake Data
    @AndroidFindBy(xpath = "//*[contains(@text, 'Convert to Fake Data')]")
    @iOSXCUITFindBy(accessibility = "Fake Data")
    public  MobileElement convertToFakeData;

    //Sync Fake Data
    @AndroidFindBy(xpath = "//*[contains(@text, 'Sync Fake Data')]")
    public  MobileElement syncFakeData;

    //Sync Threads
    @AndroidFindBy(xpath = "//*[contains(@text, 'Sync Threads')]")
    public  MobileElement syncThreads;

    //Home/Visiting Teaching Months
    @AndroidFindBy(xpath = "//*[contains(@text, 'Home/Visiting Teaching Months')]")
    public  MobileElement homeVisitingTeachingMonths;

    //Minutes Between Profile Prompts
    @AndroidFindBy(xpath = "//*[contains(@text, 'Minutes Between Profile Prompts')]")
    public  MobileElement minutesBetweenProfilePrompts;

    //Ignore Whats New
    @AndroidFindBy(xpath = "//*[contains(@text, 'Ignore')]")
    public  MobileElement ignoreWhatsNew;

    //Reset What's New Prompt
    @AndroidFindBy(xpath = "//*[contains(@text, 'New Prompt')]")
    public  MobileElement resetWhatsNewPrompt;

    //Network Environment
    @AndroidFindBy(xpath = "//*[contains(@text, 'Network Environment')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Environment')]")
    public  MobileElement networkEnvironment;

        //Production
        @AndroidFindBy(xpath = "//*[contains(@text, 'Production')]")
        @iOSXCUITFindBy(accessibility = "Prod")
        public  MobileElement production;

        //UAT - UAT is now Stage
        @AndroidFindBy(xpath = "//*[contains(@text, 'UAT')]")
        @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Stage')]")
        //@iOSXCUITFindBy(accessibility = "UAT")
        public  MobileElement UAT;

        //Proxy
        @AndroidFindBy(xpath = "//*[contains(@text, 'Proxy')]")
        @iOSXCUITFindBy(accessibility = "Proxy")
        public  MobileElement proxy;

    //Proxy Username
    @AndroidFindBy(xpath = "//*[contains(@text, 'Proxy Username')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Proxy Username')]")
    public  MobileElement proxyUsername;


    //Proxy Username Edit Text
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/editText")
    public  MobileElement proxyUsernameEditText;

    //Proxy Username Edit Cancel
    @AndroidFindBy(id = "android:id/button2")
    public  MobileElement proxyUsernameEditCancel;

    //Proxy Username Edit OK
    @AndroidFindBy(id = "android:id/button1")
    public  MobileElement proxyUsernameEditOK;

    //Select Proxy
    @AndroidFindBy(xpath = "//*[contains(@text, 'Select Proxy')]")
    public  MobileElement selectProxy;

    //px_i
    @AndroidFindBy(xpath = "//*[contains(@text, 'px_i')]")
    @iOSXCUITFindBy(accessibility = "Id")
    public  MobileElement proxyId;

    //px_u
    @AndroidFindBy(xpath = "//*[contains(@text, 'px_u')]")
    @iOSXCUITFindBy(accessibility = "Units")
    public  MobileElement proxyUnits;

    //px_p
    @AndroidFindBy(xpath = "//*[contains(@text, 'px_p')]")
    @iOSXCUITFindBy(accessibility = "Positions")
    public  MobileElement proxyPositions;


        //Proxy Edit Field
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/android:id/edit")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
        public MobileElement proxyEditField;



        //Done ios OK android
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/android:id/button1")
        @iOSXCUITFindBy(accessibility = "Done")
        public MobileElement proxyDone;




    //Prototypes
    @AndroidFindBy(xpath = "//*[contains(@text, 'Prototypes')]")
    public  MobileElement prototypes;

    // ********* Development - Additional Units *********
    //Role Based Sync Rights
    @AndroidFindBy(xpath = "//*[contains(@text, 'Role Based Sync Rights')]")
    public  MobileElement roleBasedSyncRights;

    //Fingerprint Required
    @AndroidFindBy(xpath = "//*[contains(@text, 'Fingerprint Required')]")
    public  MobileElement fingerprintRequired;

    //Additional Unit Role
    @AndroidFindBy(xpath = "//*[contains(@text, 'Additional Unit Role')]")
    public  MobileElement additionalUnitRole;

    // ********* Development - Temple *********
    //Reset All Temple Preferences
//    @AndroidFindBy(xpath = "//*[contains(@text, 'Reset All Temple Preferences')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Reset Temple Dev Settings')]")
    @iOSXCUITFindBy(accessibility = "Reset Temple Databases")
    public  MobileElement resetAllTempelPreferences;

    //Override temple recommend expiration
//    @AndroidFindBy(xpath = "//*[contains(@text, 'Override temple recommend expiration')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Temple Recommend Expiration')]")
    @iOSXCUITFindBy(accessibility = "Set Temple Recommend Expiration")
    public  MobileElement overrideTempleRecommendExpiration;

    //Temple Recommend Status
    @AndroidFindBy(xpath = "//*[contains(@text, 'Temple Recommend Status')]")
    @iOSXCUITFindBy(accessibility = "Set Temple Recommend Status")
    public  MobileElement templeRecommendStatus;

        //UNKNOWN
        @AndroidFindBy(xpath = "//*[contains(@text, 'UNKNOWN')]")
        public  MobileElement unknown;

        //ACTIVE
        @AndroidFindBy(xpath = "//*[contains(@text, 'ACTIVE')]")
        @iOSXCUITFindBy(accessibility = "Active/Expired")
        public  MobileElement active;

        //LOST_OR_STOLEN
        @AndroidFindBy(xpath = "//*[contains(@text, 'LOST_OR_STOLEN')]")
        @iOSXCUITFindBy(accessibility = "Lost or Stolen")
        public  MobileElement lostOrStolen;

        //CANCELED
        @AndroidFindBy(xpath = "//*[contains(@text, 'CANCELED')]")
        @iOSXCUITFindBy(accessibility = "Canceled")
        public  MobileElement canceled;

        //EXPIRED
        @AndroidFindBy(xpath = "//*[contains(@text, 'EXPIRED')]")
        @iOSXCUITFindBy(accessibility = "Expired")
        public  MobileElement expired;

        //Nonexpiring
        @iOSXCUITFindBy(accessibility = "Nonexpiring")
        public  MobileElement nonExpiring;

        //Ignore
        @iOSXCUITFindBy(accessibility = "Ignore")
        public  MobileElement ignore;


    //Enter Days until recommend expires
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='android:id/input']")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Days until expiration'")
    public MobileElement templeDaysUntilExpiration;


    // Android Show Temple Recommend Expiration
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Show Temple Recommend Expiration']")
    public MobileElement templeShowTempleRecommendExpiration;

    //Temple Weeks
    // 2 Weeks
    @AndroidFindBy(xpath = "//*[contains(@text, \"2 weeks\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == '2 weeks before expiration'")
    public MobileElement temple2Weeks;

    // 4 Weeks
    @AndroidFindBy(xpath = "//*[contains(@text, \"4 weeks\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == '4 weeks before expiration'")
    public MobileElement temple4Weeks;

    // 6 Weeks
    @AndroidFindBy(xpath = "//*[contains(@text, \"6 weeks\")]")
//    @iOSXCUITFindBy(iOSNsPredicate = "name == '6 weeks before expiration'")
    @iOSXCUITFindBy(accessibility = "6 weeks before expiration")
    public MobileElement temple6Weeks;

    // 8 Weeks
    @AndroidFindBy(xpath = "//*[contains(@text, \"8 weeks\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == '8 weeks before expiration'")
    public MobileElement temple8Weeks;




    //Temple Recommend Reminder
    @AndroidFindBy(xpath = "//*[@text='Remind me']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, \"Temple Recommend Reminder\")]")
    public MobileElement templeRecommendReminder;


    //Cancel
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/button2")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement dialogCancel;

    // ******************** Mission Leader Limited Visibility ***************************

    //Mission Leader Limited Visibility
    @iOSXCUITFindBy(accessibility = "Mission Leader Limited Visibility")
    public  MobileElement missionLeaderLimitedVisibility;


}
