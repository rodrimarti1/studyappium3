package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class CalendarsScreen extends BasePage {

    public CalendarsScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Calendars Main Screen ******************

    //Main Title
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Calendar']")
    @iOSXCUITFindBy(accessibility = "Calendar")
    public WebElement calendarTitle;


    //Edit Button
    @iOSXCUITFindBy(accessibility = "Edit")
    public WebElement calendarEdit;

    //Done Button
    @iOSXCUITFindBy(accessibility = "Done")
    public WebElement calendarDone;


    //Overflow Menu
    @AndroidFindBy(accessibility = "More options")
    public WebElement calendarMoreOptions;


    //Calendars to display
    @AndroidFindBy(xpath = "//*[@text='Manage Calendars']")
    public WebElement calendarsToDisplay;



    //Subscriptions Button
    @AndroidFindBy(id ="menu_calendar_subscriptions")
    @iOSXCUITFindBy(accessibility = "Subscriptions")
    public WebElement calendarSubscriptions;

    //Select None Button
    @AndroidFindBy(id ="menu_calendars_select_all")
    @iOSXCUITFindBy(accessibility = "Select None")
    public WebElement calendarsSelectNone;

    //Select All Button
    @AndroidFindBy(id ="menu_calendars_select_all")
    @iOSXCUITFindBy(accessibility = "Select All")
    public WebElement calendarsSelectAll;



    //Subscriptions Done
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/menu_item_save")
    @iOSXCUITFindBy(accessibility = "Done")
    public WebElement calendarsSubscriptionsDone;

    //Subscriptions Cancel
    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public WebElement calendarsSubscriptionsCancel;










    //Check Calendar to display
    public void checkCalendarToDisplay(String calendarItem, String checkOrUncheck) throws Exception {
        String checkBox = "";
        if (checkOrUncheck.equals("check")) {
            checkBox = "green_check";
        } else {
            checkBox = "no_teach";
        }
        Thread.sleep(8000);

        if (getOS().contains("ios")) {
//            System.out.println(getSourceOfPage());
//            driver.get().findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+ calendarItem + "']/preceding-sibling::XCUIElementTypeImage[@name='" + checkBox +"']")).click();
            driver.get().findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+ calendarItem + "']/preceding-sibling::XCUIElementTypeImage")).click();

        } else {
            driver.get().findElement(By.xpath("//android.widget.TextView[@text='"+ calendarItem + "']/following-sibling::android.widget.CheckBox")).click();
        }
    }




}
