package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class QuarterlyReportScreen extends BasePage {

    public QuarterlyReportScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


// ****************** Quarterly Report Main Screen ******************

    //	Indicators of Conversion and Church Growth
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Indicators of Conversion and Church Growth']")
    @iOSXCUITFindBy(accessibility = "Indicators of Conversion and Church Growth")
    public WebElement indicatorsOfConversionAndChurchGrowth;

    // ****************** Members / Families ******************
    //Unassigned Households
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members / Families']")
    @iOSXCUITFindBy(accessibility = "Members / Families")
    public WebElement membersFamilies;

    //Adults
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Adults']")
    @iOSXCUITFindBy(accessibility = "Adults")
    public WebElement adults;

    //Youth
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Youth']")
    @iOSXCUITFindBy(accessibility = "Youth")
    public WebElement youth;

    //Children
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Children']")
    @iOSXCUITFindBy(accessibility = "Children")
    public WebElement children;

    //Converts (past 12 months)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Converts (past 12 months)']")
    @iOSXCUITFindBy(accessibility = "Converts (past 12 months)")
    public WebElement convertsPast12Months;






}
