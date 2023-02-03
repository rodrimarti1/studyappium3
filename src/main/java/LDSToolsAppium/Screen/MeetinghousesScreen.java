package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class MeetinghousesScreen extends BasePage {

    public MeetinghousesScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }

    // ****************** Before Main Screen Loads ******************

    //Allow access to your location
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_button_positive")
    @AndroidFindBy(xpath = "//*[@text='OK']")
//    @iOSXCUITFindBy(accessibility = "Allow")
    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    public WebElement meetinghousesAllow;


    //Deny access to your location
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/permission_deny_button")
    @iOSXCUITFindBy(accessibility = "Deny")
    public WebElement meetinghousesDeny;

    //Allow access to your location - Android Permissions Dialog
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/permission_allow_button")
//    @AndroidFindBy(xpath = "//android.widget.Button[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"allow\")]")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'while using')]")
    public WebElement meetinghousesAllowAndroidPermissions;


    // ****************** Meetinghouses Main Screen ******************


    // ****************** Meetinghouses Toolbar Screen ******************

    //Current Location
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/my_location_fab")
//    @iOSXCUITFindBy(accessibility = "icon current location")
    @iOSXCUITFindBy(accessibility = "location services")
    public WebElement meetinghousesCurrentLocation;


    //More Button - Android Only
    @AndroidFindBy(accessibility = "More options")
    public WebElement meetinghousesMoreOptions;

    //Map Types
    @AndroidFindBy(xpath ="//android.widget.TextView[@text='Map Types']")
    @iOSXCUITFindBy(accessibility = "info")
    public WebElement meetinghousesMapTypes;

        //Map Types - Road
//        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Road']/following-sibling::android.widget.RadioButton")
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Road']")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Road')]")
        public WebElement meetinghousesMapTypesRoad;

        //Map Types - Satellite
//        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Satelite']/following-sibling::android.widget.RadioButton")
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Satellite']")
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Satellite')]")
        public WebElement meetinghousesMapTypesSatellite;

        //Map Types - Hybrid
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Hybrid')]")
        public WebElement meetinghousesMapTypesHybrid;

        //Map Types - Satellite Flyover
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Satellite Flyover')]")
        public WebElement meetinghousesMapTypesSatelliteFlyover;

        //Map Types - Hybrid Flyover
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Hybrid Flyover')]")
        public WebElement meetinghousesMapTypesHybridFlyover;

        //Map Types - Cancel
        @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Cancel')]")
        public WebElement meetinghousesMapTypesHybridCancel;


    //Search Button - Android only
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/menu_map_search")
    public WebElement meetinghousesSearchButton;

    //Search Text Field
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/search_src_text")
    @iOSXCUITFindBy(accessibility = "Search")
    public WebElement meetinghousesSearchField;

    //Search Keyboard Button
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Search']")
    public WebElement keyboardSearchButton;

    //Directions Icon
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/directionsImageView")
    @iOSXCUITFindBy(accessibility = "ic action location directions")
    public WebElement directionIcon;


    //Go into Meetinghouse details
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/map_item_title")
    public WebElement meetinghouseDetails;


    //Search Results
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search results']")
    @iOSXCUITFindBy(accessibility = "Search results")
    public WebElement meetinghousesSearchResuts;







    public void meetinghouseSearch(String searchText) throws Exception {
        if (getOS().equals("ios")) {
            meetinghousesSearchField.sendKeys(searchText);
            Thread.sleep(2000);
            waitForElementThenClick(keyboardSearchButton);
        } else {
            waitForElementThenClick(meetinghousesSearchButton);
            meetinghousesSearchField.sendKeys(searchText);
            driver.get().executeScript("mobile: performEditorAction", ImmutableMap.of("action", "done"));
//            driver.get().getKeyboard().pressKey(Keys.ENTER);

        }




    }

    public void selectMeetinghouse() throws Exception {
        if (getOS().equals("ios")){
            driver.get().findElement(By.xpath("//XCUIElementTypeOther[@name=' '][1]")).click();
        } else {
            driver.get().findElement(By.xpath("//android.view.View[@content-desc='Google Map']/android.view.View[2]")).click();
        }
    }

    public void openMeetinghouseDetails(String meetinghouseAddress) throws Exception {
        WebElement myElement;
        if (getOS().equals("ios")) {
            System.out.println(getSourceOfPage());
//            myElement = driver.findElement(By.name(meetinghouseAddress));
            myElement = (WebElement) driver.get().findElement(By.xpath("//*[contains(@name,'" + meetinghouseAddress + "')]"));
            myElement.click();
            Thread.sleep(2000);
//            driver.findElement(By.name("ic action location directions ")).click();
//            driver.findElement(By.xpath("//XCUIElementTypeButton[@name='ic action location directions ']//following-sibling::XCUIElementTypeOther")).click();
            clickAboveElement(myElement);
        } else {
            meetinghouseDetails.click();
        }
    }

    public String getMeetinghouseDetails() throws Exception {
        String pageSource;
        pageSource = getSourceOfPage();
//        scrollDownTEST(500);
        scrollDownSlow(500);
        pageSource = pageSource + getSourceOfPage();
        return pageSource;
    }

    public void selectSearchResults(String wardToSelect) throws Exception {
        if (getOS().equals("ios")) {
            Thread.sleep(15000);
            System.out.println(getSourceOfPage());
            driver.get().findElement(By.xpath("//XCUIElementTypeTable//XCUIElementTypeStaticText[contains(@name, '" + wardToSelect + "')]" )).click();
//            driver.findElementByCustom("ai:" + wardToSelect);

        } else {
            clickByTextContains(wardToSelect);
        }
    }



}
