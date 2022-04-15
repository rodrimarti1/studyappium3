package LDSToolsAppium.Screen;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;


public class LoginPageScreen extends BasePage {

    public LoginPageScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }




    //Member Tools Heading
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Member Tools']")
//    @AndroidFindBy(xpath = "//*[@text='Member Tools']")
    public MobileElement titleMemberTools;

    //Member Tools Heading STAGE
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Member Tools - STAGE']")
    public MobileElement titleMemberToolsSTAGE;


    //Member Tools Heading TEST
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Member Tools - TEST']")
    public MobileElement titleMemberToolsTEST;


    //Login Name
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/usernameEditText")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/usernameEditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTextField")
    public  MobileElement loginName;

    //Password
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/passwordEditText")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/passwordEditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeSecureTextField")
    public  MobileElement passWord;

    //Sign In Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/ldsAccountSignInButton")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/ldsAccountSignInButton")
    @iOSXCUITFindBy(accessibility = "Sign In")
    public  MobileElement signInButton;

    //Sync Message
    @AndroidFindBy(xpath = "//*[@text='Sync Progress']")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Stop Sync'")
    public  MobileElement syncMessage;

    //Menu
    @AndroidFindBy(xpath = "//*[@content-desc='More options']")
    @iOSXCUITFindBy(accessibility = "Help")
    public  MobileElement overflowMenu;

    //Overflow Settings
    @AndroidFindBy(xpath = "//*[@text='Settings']")
    public  MobileElement overflowSettings;

    //Enter Developer Button
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[7]")
    public  MobileElement enterDeveloperButton;

    //Developer Button Displayed
    @iOSXCUITFindBy(accessibility = "Developer Settings")
    public MobileElement developerButton;


    //Error Message Service
    @AndroidFindBy(xpath = "//*[@text='Error']")
    @iOSXCUITFindBy(xpath = "//*[value='Error']")
    public MobileElement errorMessageService;

    //Error Message
    @AndroidFindBy(xpath = "//*[@text='Sign-in failed. Verify your username or password.']")
    @iOSXCUITFindBy(xpath = "//*[@value='Sign-In Failed']")
    public MobileElement loginErrorMessage;

    //Trouble Signing In?
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/ldsAccountLoginForgotCredentialsButton")
//    @iOSXCUITFindBy(accessibility = "Having trouble signing in?")
    @iOSXCUITFindBy(accessibility = "Need help signing in?")
    public  MobileElement troubleSigningIn;

    //Privacy Notice
//    @AndroidFindBy(xpath = "//*[contains(@text, 'Privacy Policy (Updated 2018-09-01)')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Privacy Policy')]")
//    @iOSXCUITFindBy(accessibility = "Privacy Notice (Updated 2018-09-01)")
    @iOSXCUITFindBy(accessibility = "Privacy Notice (Updated 2021-04-06)")
    public  MobileElement privacyNotice;

    //Terms of Use
    @AndroidFindBy(xpath = "//*[contains(@text, 'Terms of Use (Updated 2018-09-01)')]")
//    @iOSXCUITFindBy(accessibility = "Terms of Use (Updated 2018-09-01)")
    @iOSXCUITFindBy(accessibility = "Terms of Use (Updated 2021-04-13)")
    public  MobileElement termsOfUse;

    //Cancel Button
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement cancelButton;

    //Done Button
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "Done")
    public  MobileElement doneButton;

    //Account Recovery
    @AndroidFindBy(xpath = "//*[contains(@text, 'Church Account')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Church Account')]")
    public  MobileElement accountRecoveryPage;

   //Samsung Pass
    @AndroidFindBy(accessibility = "Settings")
    public MobileElement cancelPass;
}
