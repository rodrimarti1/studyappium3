package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;


public class LifeResources extends BasePage {

    public LifeResources(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Life Resources Main Screen ******************
    //Search field
    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Search'")
    public WebElement lifeResourceSearch;

    //Category pull down
    @AndroidFindBy(xpath = "//*[@text='Category']")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Category')]")
    public WebElement lifeResourceCategory;

    //Distance pull down
    @AndroidFindBy(xpath = "//*[@text='Distance']")
    @iOSXCUITFindBy(iOSNsPredicate =  "label == 'Distance ▾'")
    public WebElement lifeResourceDistance;

    //Help
    @AndroidFindBy(xpath = "//*[@content-desc='Life Resource Help']")
    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeButton[@name='questionmark.circle']")
    public WebElement lifeResourceHelp;

   // iOS Map options
    @iOSXCUITFindBy(accessibility = "Allow Once")
    public WebElement allowOnce;

    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    public WebElement allowWhileUsingApp;

    @iOSXCUITFindBy(accessibility = "Don't Allow")
    public WebElement dontAllow;


}
