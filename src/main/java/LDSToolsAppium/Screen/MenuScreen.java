package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class MenuScreen extends BasePage {

    public MenuScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }

    //Directory
    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@resource-id='org.lds.ldstools.alpha:id/drawerComposeView']//android.widget.TextView[@text='Directory']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Directory'")
    public WebElement directory;

    //Organizations
    @AndroidFindBy(xpath = "//*[@text='Organizations']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Organizations'")
    public  WebElement organizations;

    //Calendar
    @AndroidFindBy(xpath = "//*[@text='Calendar']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Calendar'")
    public  WebElement calendar;

    //Reports
    @AndroidFindBy(xpath = "//*[@text='Reports']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Reports'")
    public  WebElement reports;


    //Manage Records
    @AndroidFindBy(xpath = "//*[@text='Manage Records']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Manage Records'")
    public  WebElement manageRecord;

    //Lists
    @AndroidFindBy(xpath = "//*[@text='Lists']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Lists'")
    public  WebElement lists;

    //Missionary
    @AndroidFindBy(xpath = "//*[@text='Missionary']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Missionary'")
    public  WebElement missionary;

    //Meetinghouses
    @AndroidFindBy(xpath = "//*[@text='Meetinghouses']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Meetinghouses'")
    public  WebElement meetinghouses;

    //Temples
    @AndroidFindBy(xpath = "//*[@text='Temples']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Temples'")
    public  WebElement temples;

    //Finance
    @AndroidFindBy(xpath = "//*[@text='Finance']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Finance'")
    public  WebElement finance;

    //Sync
    @AndroidFindBy(xpath = "//*[@text='Sync']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Sync'")
    public  WebElement sync;

    //Update
    @AndroidFindBy(xpath = "//*[@text='Update']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Update'")
    public  WebElement update;

    //Settings
    @AndroidFindBy(xpath = "//*[@text='Settings']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Settings'")
    public  WebElement settings;

    //Life Resources
    @AndroidFindBy(xpath = "//*[@text='Life Resources']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Life Resources'")
    public  WebElement lifeResources;

    //Help
    @AndroidFindBy(xpath = "//*[@text='Help']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Help'")
    public  WebElement help;

    // ********** Android Only **********
    //Later Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/updateLaterButton")
    public  WebElement laterButton;

    //Update My Info Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/drawer_update_info_button")
    public  WebElement updateMyInfo;

    //Drawer Message
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='drawer_update_info_later_layout']/android.widget.TextView")
    public  WebElement drawerMessage;

    // ********** iOS Only **********
    //More Button
//    @iOSXCUITFindBy(iOSNsPredicate = "name == 'More' AND type == 'XCUIElementTypeButton'")
    @iOSXCUITFindBy(accessibility = "More")
//    @iOSXCUITFindBy(iOSNsPredicate = "name == 'More'")
    public  WebElement moreMenu;

    public void selectMenu(WebElement myElement) throws Exception {
        BasePage myBase = new BasePage(driver);
        Thread.sleep(1000);
        if (!getOS().equals("ios")) {
            myBase.waitForElementThenClick(drawerButton);
//            drawerButton.click();
        }
        //Check for Element
        if (checkForElement(myElement)) {
            myElement.click();
        } else {
            if (getOS().equals("ios")) {
//                System.out.println("Clicking More....");
//                System.out.println(myBase.getSourceOfPage());
//                myBase.checkForElement(moreMenu);
                moreMenu.click();
            } else {
//                scrollDownTEST(200);
                scrollDownAndroidUIAutomator("0");
            }
            myBase.waitForElementThenClick(myElement);
//            myElement.click();
        }
    }

    public void menuLogOut() throws Exception {
        SettingsScreen mySettings = new SettingsScreen(driver);
        BasePage myBase = new BasePage(driver);

        if (myBase.getOS().equalsIgnoreCase("ios")) {
//            WebElement cancelButton = driver.get().findElement(AppiumBy.accessibilityId("Cancel"));

            if (myBase.checkForElement(myBase.cancel)) {
                myBase.cancel.click();
                Thread.sleep(500);
            }

            if (myBase.backButton.isDisplayed()) {
                myBase.backButton.click();
            }


        }

        Thread.sleep(1000);
        selectMenu(settings);

        if (getOS().equalsIgnoreCase("android")) {
            newScrollUp();
            newScrollUp();
            newScrollUp();
        }
        myBase.waitForElementThenClick(mySettings.signOut);
//        mySettings.signOut.click();

        if (checkForElement(alertOK)) {
            alertOK.click();
        }


        if (getOS().equals("ios")) {
//            driver.get().resetApp();

        }
    }


}
