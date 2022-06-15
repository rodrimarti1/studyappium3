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


public class MissionaryScreen extends BasePage {

    public MissionaryScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Missionary Main Screen ******************

    //Send Referral Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fab")
    @iOSXCUITFindBy(accessibility = "Send Referral")
    public WebElement sendReferralButton;

    //Cancel Referral
//    @AndroidFindBy(accessibility = "Navigate up")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'toolbar')]/android.widget.ImageButton")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public WebElement cancelReferralButton;



    // ****************** Missionary Send Referral Screen ******************
    //Help Message
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/personalInformationExplanationTextView")
    @iOSXCUITFindBy(accessibility = "Helps the missionaries know how to contact you to discuss your friend's needs.")
    public WebElement referralHelpMessage;

    //Member Phone Number
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/personalPhoneTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PHONE']/following-sibling::XCUIElementTypeStaticText")
    public WebElement referralMemberPhoneNumber;

    //Member Email
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/personalEmailTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='EMAIL']/following-sibling::XCUIElementTypeStaticText")
    public WebElement referralMemberEmail;

    //Update Individual Information
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addContactInformationNoInfoButton")
    @iOSXCUITFindBy(accessibility = "Update Individual Information")
    public WebElement referralUpdateIndividualInformation;

    //Referral Name
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/nameTextInputEditText")
    @iOSXCUITFindBy(accessibility = "Name")
    public WebElement referralName;

    //Referral Phone
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/phoneTextInputEditText")
    @iOSXCUITFindBy(accessibility = "Phone")
    public WebElement referralPhone;

    //Referral Email
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/emailTextInputEditText")
    @iOSXCUITFindBy(accessibility = "Email")
    public WebElement referralEmail;


    //Referral Locate on Map
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/locateOnMapTextView")
    @iOSXCUITFindBy(accessibility = "Locate on Map")
    public WebElement referralLocateOnMap;

    //Referral Map Search
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterEditText")
    @iOSXCUITFindBy(accessibility = "Search")
    public WebElement referralMapSearch;

    //Referral Add Preferred Language
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/languageTextView")
    @iOSXCUITFindBy(accessibility = "Add Preferred Language")
    public WebElement referralAddPreferredLanguage;

    //Referral Add Message Button iOS only
    @iOSXCUITFindBy(accessibility = "Add a Message")
    public WebElement referralAddMessageButton;

    //Referral Cancel Message Button iOS only
    //@iOSXCUITFindBy(accessibility = "minus")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Message']/following-sibling::XCUIElementTypeImage[@name='minus']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Message']/following-sibling::XCUIElementTypeImage")
    public WebElement referralCancelMessage;




    //Referral Message field
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/helpfulMessageInputEditText")
    @iOSXCUITFindBy(accessibility = "Message")
    public WebElement referralMessageField;

    //Referral Send Referral Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/sendReferralButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@value='Send Referral']")
    public WebElement referralSendReferral;

    //Overflow Button - Android only
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/removeReferralImageButton")
    public WebElement referralOverflowButton;


    //Remove Referral
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Remove from list']")
    @iOSXCUITFindBy(accessibility = "Remove")
    public WebElement referralRemove;

    //Remove from list?
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/button1")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='REMOVE']")
    public WebElement referralRemoveFromList;



    //Android Only
    //Referrals Tab
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"referrals\")]")
    public  WebElement tabReferrals;

    //Tab Assigned
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"assigned\")]")
    public  WebElement tabAssigned;

    //Tab Ward
    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"ward\")]")
    public  WebElement tabWard;

    //Tab Serving
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"serving\")]")
    public  WebElement tabServing;



    //Use This Location
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/useLocationFab")
    public  WebElement referralUseThisLocation;


    //*********** Tool Bar **************
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/drop_arrow")
    @iOSXCUITFindBy(accessibility = "Missionary")
    public WebElement unitSelector;







    public String getMissionaryPage() throws Exception {
        BasePage myBasePage = new BasePage(driver);

        String pageSource = null;
        if (getOS().equals("ios")) {
            pageSource = getSourceOfPage();
            scrollDownIOS();

            pageSource = pageSource + getSourceOfPage();
        } else {


            //Contact Tab
            Thread.sleep(3000);
            pageSource = getSourceOfPage();

            tabAssigned.click();
            Thread.sleep(3000);
            pageSource = pageSource + getSourceOfPage();

            tabWard.click();
            Thread.sleep(3000);
            pageSource = pageSource + getSourceOfPage();

            tabServing.click();
            Thread.sleep(3000);
            pageSource = pageSource + getSourceOfPage();

            tabReferrals.click();
        }

        return pageSource;

    }




}
