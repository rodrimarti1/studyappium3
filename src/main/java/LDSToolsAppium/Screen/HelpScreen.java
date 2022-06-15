package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class HelpScreen extends BasePage {

    public HelpScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }

    //Send Feedback
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/feedback_submit")
    public WebElement helpSendFeedback;




    //What's New
    @AndroidFindBy(xpath = "//*[contains(@text, 'What's New')]")
    public  WebElement helpWhatsNew;

    //Release Notes
    @AndroidFindBy(xpath = "//*[contains(@text, 'Release Notes')]")
    public  WebElement helpReleaseNotes;

    //Frequently Asked Questions
    @AndroidFindBy(xpath = "//*[contains(@text, 'Frequently Asked Questions')]")
    public  WebElement helpFrequentlyAskedQuestions;

    //Contact Us
    @AndroidFindBy(xpath = "//*[contains(@text, 'Contact Us')]")
    public  WebElement helpContactUs;

        //Name
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/feedbackNameTextInputEditText")
        public  WebElement contactUsName;

        //Email
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/feedbackEmailTextInputEditText")
        public  WebElement contactUsEmail;

        //Category
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/feedbackCategoryDropdownTextView")
        public  WebElement contactUsCategory;

            //Other
            @AndroidFindBy(xpath = "//*[contains(@text, 'Other')]")
            public  WebElement contactUsOther;


        //Category
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/feedbackDescriptionEditText")
        public  WebElement contactUsDescription;
}
