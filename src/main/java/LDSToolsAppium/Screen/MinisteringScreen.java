package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class MinisteringScreen extends BasePage {

    public MinisteringScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Ministering Main Screen ******************

    //Ministering
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ministering']")
    @iOSXCUITFindBy(accessibility = "Ministering")
    public WebElement ministeringReport;

    //Ministering Brothers
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ministering Brothers']")
    @iOSXCUITFindBy(accessibility = "Ministering Brothers")
    public WebElement ministeringBrothersReport;

    //Ministering Sisters
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ministering Sisters']")
    @iOSXCUITFindBy(accessibility = "Ministering Sisters")
    public WebElement ministeringSistersReport;


    // ****************** Elders Quorum ******************
    //Unassigned Households
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unassigned Households']")
    @iOSXCUITFindBy(accessibility = "Unassigned Households")
    public WebElement unassignedHouseholds;

    //Assigned Households
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Assigned Households']")
    @iOSXCUITFindBy(accessibility = "Assigned Households")
    public WebElement assignedHouseholds;

    //Households
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Households']")
    @iOSXCUITFindBy(accessibility = "Households")
    public WebElement households;

    //Companionships Brothers
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Elders Quorum']/../following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='Companionships']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Elders Quorum']/../following-sibling::XCUIElementTypeCell//XCUIElementTypeStaticText[@name='Companionships']")
    public WebElement companionshipsBrothers;

    //Potential Ministering Brothers
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Potential Ministering Brothers']")
    @iOSXCUITFindBy(accessibility = "Potential Ministering Brothers")
    public WebElement potentialMinisteringBrothers;

    // ****************** Relief Society ******************
    //Unassigned Sisters
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unassigned Sisters']")
    @iOSXCUITFindBy(accessibility = "Unassigned Sisters")
    public WebElement unassignedSisters;

    //Assigned Sisters
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Assigned Sisters']")
    @iOSXCUITFindBy(accessibility = "Assigned Sisters")
    public WebElement assignedSisters;


    //Sisters
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sisters']")
    @iOSXCUITFindBy(accessibility = "Sisters")
    public WebElement sisters;

    //Companionships Relief Society
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Relief Society']/../following-sibling::android.widget.LinearLayout//android.widget.TextView[@text='Companionships']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Relief Society']/../following-sibling::XCUIElementTypeCell//XCUIElementTypeStaticText[@name='Companionships']")
    public WebElement companionshipsSisters;

    //Potential Ministering Sisters
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Potential Ministering Sisters']")
    @iOSXCUITFindBy(accessibility = "Potential Ministering Sisters")
    public WebElement potentialMinisteringSisters;



    // ****************** Ministering Buttons ******************
    //Share Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/menu_share")
    @iOSXCUITFindBy(accessibility = "Share")
    public WebElement share;

    //Map Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/menu_show_on_map")
    @iOSXCUITFindBy(accessibility = "Map")
    public WebElement map;

    //Filters Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/menu_item_htvt_filter")
    @iOSXCUITFindBy(accessibility = "Filters")
    public WebElement filters;


    // ****************** Filters ******************
    //Assigned Ministering Brothers
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/htvt_filter_assigned")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Assigned Ministering Brothers' AND type == 'XCUIElementTypeSwitch'")
    public WebElement assignedMinisteringBrothers;

    //Not Assigned Ministering Brothers
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/htvt_filter_not_assigned")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Not Assigned Ministering Brothers' AND type == 'XCUIElementTypeSwitch'")
    public WebElement notAssignedMinisteringBrothers;

    //New & Moved-In Members
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/htvt_filter_new_and_moved_in")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'New & Moved-In Members' AND type == 'XCUIElementTypeSwitch'")
    public WebElement newAndMovedInMembers;


    //Single Sisters
    //Ages 18 to 30
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/htvt_filter_single_sisters_eighteen_thirty_years_old")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Single Sisters']/../following-sibling::XCUIElementTypeCell//XCUIElementTypeSwitch[@name='Ages 18 to 30']")
    public WebElement singleSistersAges18to30;

    //Ages 31 and older
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/htvt_filter_single_sisters_thirty_and_over")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Single Sisters']/../following-sibling::XCUIElementTypeCell//XCUIElementTypeSwitch[@name='Age 31 and older']")
    public WebElement singleSistersAge31AndOver;

    //Single Brothers
    //Ages 18 to 30
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/htvt_filter_single_brothers_eighteen_thirty_years_old")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Single Brothers']/../following-sibling::XCUIElementTypeCell//XCUIElementTypeSwitch[@name='Ages 18 to 30']")
    public WebElement singleBrothersAges18to30;

    //Ages 31 and older
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/htvt_filter_single_brothers_thirty_and_over")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Single Brothers']/../following-sibling::XCUIElementTypeCell//XCUIElementTypeSwitch[@name='31 and over']")
    public WebElement singleBrothersAge31AndOver;



    //Assigned Ministering Sisters
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/htvt_filter_assigned")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Assigned Ministering Sisters' AND type == 'XCUIElementTypeSwitch'")
    public WebElement assignedMinisteringSisters;

    //Not Assigned Ministering Sisters
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/htvt_filter_not_assigned")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Not Assigned Ministering Sisters' AND type == 'XCUIElementTypeSwitch'")
    public WebElement notAssignedMinisteringSisters;



    //Save Button for Filter
    @AndroidFindBy(id ="menu_item_save")
    public WebElement ministeringFilterSave;

    //Expand filter button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterHeaderArrow")
    public WebElement ministeringExpandFilter;

    //Remove filter button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/removeFiltersButton")
    public WebElement ministeringRemoveFilter;


    public boolean validateDistrict( String districtToCheck ) throws Exception {
        boolean myCheck;
        BasePage myBase = new BasePage(driver);
        String myPageSource;

        myPageSource = getSourceOfPage();
        if (myBase.getOS().equalsIgnoreCase("android"))  {
            myBase.scrollUpAndroidUIAutomator("0");
            myPageSource = myPageSource + getSourceOfPage();
        }


        myCheck = myPageSource.contains(districtToCheck);

        return myCheck;
    }

    public void selectDistrict(String districtToSelect ) throws Exception {
        BasePage myBase = new BasePage(driver);
        Thread.sleep(2000);
        //String myPageSource;
        if (getOS().equals("ios")) {
//            driver.get().findElementByAccessibilityId(districtToSelect).click();
            driver.get().findElement(AppiumBy.accessibilityId(districtToSelect)).click();
        } else {
            //myPageSource = getSourceOfPage();
            //System.out.println(myPageSource);
            //districtToSelect = districtToSelect.toUpperCase();


            if (myBase.checkElementExists(districtToSelect)) {
                driver.get().findElement(By.xpath("//*[@text='" + districtToSelect + "']")).click();
            } else {
                districtToSelect = districtToSelect.toUpperCase();
                driver.get().findElement(By.xpath("//*[@text='" + districtToSelect + "']")).click();
            }

            //driver.findElement(By.xpath("//*[@text='" + districtToSelect + "']")).click();
            //driver.findElement(By.xpath("//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + districtToSelect + "')]")).click();
        }
    }


    public void saveMissonaryProgressFilter() {
        if (getOS().equals("ios")) {
            backButton.click();
        } else {
            ministeringFilterSave.click();
            ministeringExpandFilter.click();
        }

    }



}
