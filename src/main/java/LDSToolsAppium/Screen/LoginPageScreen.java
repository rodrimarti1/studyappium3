package LDSToolsAppium.Screen;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;


public class LoginPageScreen extends BasePage {

    public LoginPageScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }




    //Member Tools Heading
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Member Tools']")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/lane_change")
//    @AndroidFindBy(xpath = "//*[@text='Member Tools']")
    public WebElement titleMemberTools;

    //Member Tools Heading PROD
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"PROD\"]")
    public WebElement titleMemberToolsPROD;

    //Member Tools Heading STAGE
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"STAGE\"]")
    public WebElement titleMemberToolsSTAGE;

    //Member Tools Heading TEST
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"TEST\"]")
    public WebElement titleMemberToolsTEST;

    //Start Page Sign In Button
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton/XCUIElementTypeStaticText[@name=\" Sign In \"]")
    public WebElement startPageSignInButton;




    //Login Name
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/usernameEditText")
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Username']/following-sibling::android.view.View")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Username']/..")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTextField")
    public  WebElement loginName;

    //Password
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/passwordEditText")
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/passwordEditText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Password']/following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeSecureTextField")
    public  WebElement passWord;

    //Next Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/nextButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Next']/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next\"]")
    public  WebElement nextButton;

    //2Factor Edit Field
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/codeEditText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='2-Step Verification']/following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
    public  WebElement twoFactorEdit;

    //2Factory Back Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/backButton")
    public WebElement twoFactorBack;

    //Deep Link Open
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Open']")
    public  WebElement deepLinkOpen;

    //Sign In Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/ldsAccountSignInButton")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/ldsAccountSignInButton")
    @iOSXCUITFindBy(accessibility = "Sign In")
    public  WebElement signInButton;

    //Sync Message
    @AndroidFindBy(xpath = "//*[@text='Sync Progress']")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Stop Sync'")
    public  WebElement syncMessage;

    //Menu
    @AndroidFindBy(xpath = "//*[@content-desc='More options']")
    @iOSXCUITFindBy(accessibility = "Help")
    public  WebElement overflowMenu;

    //Overflow Settings
    @AndroidFindBy(xpath = "//*[@text='Settings']")
    public  WebElement overflowSettings;

    //Enter Developer Button
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[7]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Press me to reveal developer settings')]")
    public  WebElement enterDeveloperButton;

    //Developer Button Displayed
//    @iOSXCUITFindBy(accessibility = "Developer Settings")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Developer Settings\"])[2]")
    public WebElement developerButton;


    //Error Message Service
    @AndroidFindBy(xpath = "//*[@text='Error']")
    @iOSXCUITFindBy(xpath = "//*[value='Error']")
    public WebElement errorMessageService;

    //Error Message
    @AndroidFindBy(xpath = "//*[@text='Sign-in failed. Verify your username or password.']")
    @iOSXCUITFindBy(xpath = "//*[@value='Sign-In Failed']")
    public WebElement loginErrorMessage;

    //Trouble Signing In?
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/forgotButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forgot your username?']")
//    @iOSXCUITFindBy(accessibility = "Having trouble signing in?")
    @iOSXCUITFindBy(accessibility = "Need help signing in?")
    public  WebElement troubleSigningIn;

    //Privacy Notice
//    @AndroidFindBy(xpath = "//*[contains(@text, 'Privacy Policy (Updated 2018-09-01)')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Privacy Notice')]")
//    @iOSXCUITFindBy(accessibility = "Privacy Notice (Updated 2018-09-01)")
    @iOSXCUITFindBy(accessibility = "Privacy Notice (Updated 2021-04-06)")
    public  WebElement privacyNotice;

    //Terms of Use
    @AndroidFindBy(xpath = "//*[contains(@text, 'Terms of Use')]")
//    @iOSXCUITFindBy(accessibility = "Terms of Use (Updated 2021-04-13)")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Terms of Use')]")
    public  WebElement termsOfUse;

    //Cancel Button
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  WebElement cancelButton;

    //Done Button
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "Done")
    public  WebElement doneButton;

    //Account Recovery
    @AndroidFindBy(xpath = "//*[contains(@text, 'Church Account')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Church Account')]")
    public  WebElement accountRecoveryPage;

   //Samsung Pass
    @AndroidFindBy(accessibility = "Settings")
    public WebElement cancelPass;

    //iOS Deep Link elements
    //Address Label
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@label='Address']")
    public  WebElement addressLabel;

    //Clear Text Button
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Clear text']")
    public  WebElement clearTextButton;

    //Address field
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@label='Address']")
    public  WebElement iOSAddressField;

    //Go Button
    @iOSXCUITFindBy(xpath = "//*[@name='Go']")
    public  WebElement deepLinkGo;

    //Open Button
    @iOSXCUITFindBy(xpath = "//*[@name='Open']")
    public  WebElement deepLinkOpenButton;


    //Android invalid password OK button
    @AndroidFindBy(xpath = "//*[@text='OK']")
    public  WebElement invalidPasswordOK;


}
