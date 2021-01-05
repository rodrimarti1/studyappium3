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


public class WhatsNewScreen extends BasePage {

    public WhatsNewScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Whats New Screen ******************

    //Title
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishopric']")  //NEED TO CHANGE
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText/XCUIElementTypeStaticText[1]")
    public MobileElement whatsNewTitle;

    //Title Sub
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishopric']")  //NEED TO CHANGE
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText/XCUIElementTypeStaticText[2]")
    public MobileElement whatsNewTitleSub;

    // Use Password button for Note8
    @AndroidFindBy(className = "android.widget.Button")
    public MobileElement usePassword;

    // Auto update button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/autoUpdateSwitch")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='Automatic update, Ward and Stake data can now be automatically updated.']")
    public MobileElement autoUpdate;

    // Use Wi-Fi only
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/wifiSwitch")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Update automatically only on Wi-Fi, Reduces data usage\"]")

    public MobileElement wifiButton;

    // Help tab What's New
    @AndroidFindBy(xpath ="//android.widget.TextView[@text=\"What's New\"]")
    @iOSXCUITFindBy(accessibility = "What's New")
    public MobileElement helpWhatsNew;

    //Done Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/done")
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/doneButton")
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement whatsNewDone;






}

