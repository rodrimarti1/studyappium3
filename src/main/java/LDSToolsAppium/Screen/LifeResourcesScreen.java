package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class LifeResourcesScreen extends BasePage {

    public LifeResourcesScreen(ThreadLocal<AppiumDriver> driver) {
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

    //Add Button
    @AndroidFindBy(xpath = "//*[@content-desc='Enter new life resource']")
    @iOSXCUITFindBy(accessibility =  "Add")
    public WebElement lifeResourceAddButton;

    //Certify Switch
    @AndroidFindBy(xpath = "//*[@text='I certify that I will add only information that is publicly available about organizations that provide community support or resources']")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='I certify that I will add only information that is publicly available about organizations that provide community support or resources']/XCUIElementTypeSwitch")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
    public WebElement lifeResourceCertifySwitch;

    //Organization's Name
    @AndroidFindBy(xpath = "//*[@text='Organization's Name']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Organization's Name\"]/following-sibling::XCUIElementTypeTextView[1]" )
    public WebElement lifeResourceOrgName;


    //Sort Description
    @AndroidFindBy(xpath = "//*[@text='Short description of services']")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Description'" )
    public WebElement lifeResourceShortDescription;

    //Organization's URL
    @AndroidFindBy(xpath = "//*[@text='Organization's URL']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Organization's URL\"]/following-sibling::XCUIElementTypeTextView[1]" )
    public WebElement lifeResourceURL;

    //Organization's Phone
    @AndroidFindBy(xpath = "//*[@text='Organization's Phone']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Organization's Phone\"]/following-sibling::XCUIElementTypeTextView" )
    public WebElement lifeResourcePhone;

    //Organization's Address
    @AndroidFindBy(xpath = "//*[@text='Organization's Address']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Location Services']/following-sibling::XCUIElementTypeTextView" )
    public WebElement lifeResourceAddress;

    //Organization's Email
    @AndroidFindBy(xpath = "//*[@text='Organization's Email']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Organization's Email\"]/following-sibling::XCUIElementTypeTextView" )
    public WebElement lifeResourceEmail;

    //Organization's Notes
    @AndroidFindBy(xpath = "//*[@text='Notes']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Notes']/following-sibling::XCUIElementTypeTextView" )
    public WebElement lifeResourceNotes;

    //Categories
    @AndroidFindBy(xpath = "//*[@text='Abuse']")
    @iOSXCUITFindBy(accessibility = "Abuse" )
    public WebElement lifeResourceAbuse;

    @AndroidFindBy(xpath = "//*[@text='Addiction']")
    @iOSXCUITFindBy(accessibility = "Addiction" )
    public WebElement lifeResourceAddiction;

    @AndroidFindBy(xpath = "//*[@text='Clothing']")
    @iOSXCUITFindBy(accessibility = "Clothing" )
    public WebElement lifeResourceClothing;

    @AndroidFindBy(xpath = "//*[@text='Education']")
    @iOSXCUITFindBy(accessibility = "Education" )
    public WebElement lifeResourceEducation;

    @AndroidFindBy(xpath = "//*[@text='Emergency Response']")
    @iOSXCUITFindBy(accessibility = "Emergency Response" )
    public WebElement lifeResourceEmergencyResponse;

    @AndroidFindBy(xpath = "//*[@text='Family Relations']")
    @iOSXCUITFindBy(accessibility = "Family Relations" )
    public WebElement lifeResourceFamilyRelations;

    @AndroidFindBy(xpath = "//*[@text='Finances']")
    @iOSXCUITFindBy(accessibility = "Finances" )
    public WebElement lifeResourceFinances;

    @AndroidFindBy(xpath = "//*[@text='Food']")
    @iOSXCUITFindBy(accessibility = "Food" )
    public WebElement lifeResourceFood;

    @AndroidFindBy(xpath = "//*[@text='Housing']")
    @iOSXCUITFindBy(accessibility = "Housing" )
    public WebElement lifeResourceHousing;

    @AndroidFindBy(xpath = "//*[@text='Legal']")
    @iOSXCUITFindBy(accessibility = "Legal" )
    public WebElement lifeResourceLegal;

    @AndroidFindBy(xpath = "//*[@text='Medical']")
    @iOSXCUITFindBy(accessibility = "Medical" )
    public WebElement lifeResourceMedical;

    @AndroidFindBy(xpath = "//*[@text='Mental and Emotional Health']")
    @iOSXCUITFindBy(accessibility = "Mental and Emotional Health" )
    public WebElement lifeResourceMentalAndEmotionalHealth;

    @AndroidFindBy(xpath = "//*[@text='Preparedness']")
    @iOSXCUITFindBy(accessibility = "Preparedness" )
    public WebElement lifeResourcePreparedness;

    @AndroidFindBy(xpath = "//*[@text='Transportation']")
    @iOSXCUITFindBy(accessibility = "Transportation" )
    public WebElement lifeResourceTransportation;

    @AndroidFindBy(xpath = "//*[@text='Work']")
    @iOSXCUITFindBy(accessibility = "Work" )
    public WebElement lifeResourceWork;

    //Leader Only Switch
    @AndroidFindBy(xpath = "//*[@text='Show details to leaders only']")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeSwitch[@name='Show details to leaders only, For resources not for public view. Shows only organization’s name and description and directs members to contact leaders regarding the resource']/XCUIElementTypeSwitch" )
    public WebElement lifeResourceLeaderOnlySwitch;

    //Save Button
    @AndroidFindBy(xpath = "//*[@text='SAVE']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Save' AND type == 'XCUIElementTypeOther'")
    public WebElement lifeResourceSave;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Cancel' AND type == 'XCUIElementTypeOther'")
    public WebElement lifeResourceCancel;

    //Edit Button
    @AndroidFindBy(xpath = "//*[@content-desc='Edit Life Resource']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit\"]")
    public WebElement lifeResourceEdit;

    //Delete Button
    @AndroidFindBy(xpath = "//*[@content-desc='Delete Life Resource']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Trash\"]")
    public WebElement lifeResourceDelete;

   //Delete Confirm Button
   @AndroidFindBy(xpath = "//*[@text=\"DELETE\"]")
   @iOSXCUITFindBy(accessibility = "Delete Life Resource")
   public WebElement lifeResourceConfirmDelete;

}
