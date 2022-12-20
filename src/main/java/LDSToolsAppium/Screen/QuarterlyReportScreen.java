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
    @AndroidFindBy(xpath = "//*[@text='Indicators of Conversion and Church Growth']")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Indicators of Conversion and Church Growth\"]")
    public WebElement quarterlyReportIndicatorsOfConversionAndChurchGrowth;

    // ****************** Members / Families ******************
    //Members / Famailes
    @AndroidFindBy(xpath = "//*[@text='Members / Families']")
    @iOSXCUITFindBy(xpath = "//*[@name='Members / Families']")
    public WebElement quarterlyReportMembersFamilies;

    //Adults
    @AndroidFindBy(xpath = "//*[@text='Adults']")
    @iOSXCUITFindBy(xpath = "//*[@name='Adults']")
    public WebElement quarterlyReportAdults;

    //Youth
    @AndroidFindBy(xpath = "//*[@text='Youth']")
    @iOSXCUITFindBy(xpath = "//*[@name='Youth']")
    public WebElement quarterlyReportYouth;

    //Children
    @AndroidFindBy(xpath = "//*[@text='Children']")
    @iOSXCUITFindBy(xpath = "//*[@text='Children']")
    public WebElement quarterlyReportChildren;

    //Converts
    @AndroidFindBy(xpath = "//*[@text=\"Converts\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Converts\"]")
    public WebElement quarterlyReportConverts;


    //Review and Submit button
    @AndroidFindBy(xpath = "//*[@content-desc=\"Review and Submit\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Review and Submit\"]")
    public WebElement quarterlyReportReviewAndSubmit;

    //Todo: search for quarter then get the year and quarter number

    //Todo: get name of report then get info from that - using API?

}
