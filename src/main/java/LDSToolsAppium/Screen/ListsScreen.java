package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;


public class ListsScreen extends BasePage {

    public ListsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver, myDuration), this);
    }

    // ****************** Lists Screen ******************

    //Edit List - iOS Only
    @iOSXCUITFindBy(accessibility = "Edit")
    public MobileElement listsEdit;


    //Add List
    @AndroidFindBy(id = "fab")
    @iOSXCUITFindBy(accessibility = "Add List")
    public MobileElement listsAddList;




    // ****************** Lists Screen ******************

    //New List Dialog - Name
    @AndroidFindBy(id = "android:id/input")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public MobileElement listsName;

    //New List Dialog - Cancel
    @AndroidFindBy(id = "md_buttonDefaultNegative")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement listsCancel;

    //New List Dialog - OK or Done
    @AndroidFindBy(id = "md_buttonDefaultPositive")
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement listsOk;






    //Into Lists - Android and iOS does this differently

    //Android - Edit List Name
    @AndroidFindBy(id = "menu_item_edit_name")
    public MobileElement listsEditName;

    //Android - Add member name text field
    @AndroidFindBy(id = "individualLookupAutoCompleteTextView")
    public MobileElement listsAddMemberName;


    //iOS - Add Member Button
    @iOSXCUITFindBy(accessibility = "Add to List")
    public MobileElement listsAddToListButton;

    //iOS - Search Field
    @iOSXCUITFindBy(accessibility = "Search")
    public MobileElement listsSearch;

    //Back button after addeing user
    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement listsBackButton;




    public void selectListName(String myListName) throws Exception{
        if (getOS().equals("ios")) {
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + myListName + "']")).click();
        } else {
            driver.findElement(By.xpath("//android.widget.TextView[@text='"+ myListName + "']")).click();
        }
    }

    public String getNumberOfListMembers(String myListName) throws Exception{
        String listNumber;
        if (getOS().equals("ios")) {
            listNumber = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + myListName + "']following-sibling::XCUIElementTypeStaticText")).getAttribute("name").toString();
        } else {
            listNumber = driver.findElement(By.xpath("//android.widget.TextView[@text='"+ myListName + "']following-sibling::android.widget.TextView")).getAttribute("text").toString();
            if (listNumber.contains("people")) {
                listNumber.replace(" people", "");
            } else {
                listNumber.replace( " person", "");
            }
        }

        return listNumber;
    }





    public void addMemberToList(String memberToAdd, String memberToClickOn) throws Exception {
        int elementX;
        int elementY;

        if (getOS().equals("ios")) {
            listsAddToListButton.click();
            listsSearch.sendKeys(memberToAdd);
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + memberToClickOn + "']")).click();
            backButton.click();


        } else {
            listsAddMemberName.sendKeys(memberToAdd);
//            driver.findElement(By.xpath("//*[@text='" + memberToClickOn + "']"));
            elementX = listsAddMemberName.getLocation().getX();
            elementY = listsAddMemberName.getLocation().getY();

            TouchAction clickElement = new TouchAction(driver).press(PointOption.point(elementX + 60, elementY + 200)).release();
            clickElement.perform();
        }
    }






}
