package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;


public class FinanceScreen extends BasePage {

    public FinanceScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Finance Main Screen ******************
    //Payment Requests
    @AndroidFindBy(xpath = "//*[@text='Payment Requests']")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public WebElement financePaymentRequests;

    //Add Payment Requests
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/newPaymentRequestFab")
    @iOSXCUITFindBy(accessibility = "＋ New Payment Request")
    public WebElement paymentRequestsAdd;

    //Add Myself
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addMyselfButton")
    @iOSXCUITFindBy(accessibility = "Add Myself")
    public WebElement paymentRequestsAddMyself;

    //Add Other Payee
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addOtherButton")
    @iOSXCUITFindBy(accessibility = "Add Other Payee")
    public WebElement paymentRequestsAddOther;

    //Search
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterEditText")
    @iOSXCUITFindBy(accessibility = "Search")
    public WebElement paymentRequestsSearch;

    //Add Payee Fab
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fab")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public WebElement paymentRequestsAddPayeeFab;



    //Select this payee
    @iOSXCUITFindBy(accessibility = "Select this Payee")
    public WebElement paymentRequestsSelectThisPayee;

    //Add Purpose
//    @iOSXCUITFindBy(accessibility = "Purpose")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Required']/following-sibling::XCUIElementTypeTextView")
    public WebElement paymentRequestsAddPurpose;

    //Purpose
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/purposeEditText")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'")
    public WebElement paymentRequestsPurpose;

    //Purpose Counter
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/textinput_counter")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'")
    public WebElement paymentRequestsCounter;

    //Purpose submit button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/submitButton")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'")
    public WebElement paymentRequestsPurposeSubmit;


    //Account
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/accountAutoCompleteTextView")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public WebElement paymentRequestsAccount;

    //Purpose page add button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fab")
    @iOSXCUITFindBy(accessibility = "OK")
    public WebElement paymentRequestsPurposeAddButton;



    //Payment Information

    //Add Receipt
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addReceiptTopButton")
    @iOSXCUITFindBy(accessibility = "Add Receipt, Hand written receipts are also acceptable")
    public WebElement paymentRequestsAddReceipt;

    //Take a Picture
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/takePhotoTextView")
    @iOSXCUITFindBy(accessibility = "Take a picture")
    public WebElement paymentRequestsTakeAPicture;

    //Choose a file
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/chooseFileTextView")
    @iOSXCUITFindBy(accessibility = "Choose a file")
    public WebElement paymentRequestsChooseAFile;

    //Photo Gallery
    @iOSXCUITFindBy(accessibility = "Photo Library")
    public WebElement paymentRequestsPhotoGallery;

    //Image to select
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[3]")
    public WebElement paymentRequestsImageToSelect;

    @iOSXCUITFindBy(accessibility = "Choose")
    public WebElement paymentRequestsImageToSelectChoose;

    //Camera Button
    //TODO: iOS code
    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'picture')]")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public WebElement paymentRequestsCameraButton;

    //Camera Button #2
    //TODO: iOS code
    @AndroidFindBy(xpath = "//*[contains(@text, 'picture')]")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public WebElement paymentRequestsCameraButton2;

    //Camera Button #3
    //TODO: iOS code
    @AndroidFindBy(xpath = "//*[@content-desc='Take photo']")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public WebElement paymentRequestsCameraButton3;

    //Camera Done
    @AndroidFindBy(xpath = "//*[@content-desc='Done']")
    public WebElement paymentRequestsCameraButtonDone;

    //Camera OK
    @AndroidFindBy(xpath = "//*[@text='OK']")
    public WebElement paymentRequestsCameraButtonOK;


    //Category Top View Group
    //Category
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.Spinner")
    @iOSXCUITFindBy(accessibility = "Category: Select Category")
    public WebElement paymentRequestsCategoryGroup1Spinner;

    //Category iOS
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Category']/following-sibling::XCUIElementTypeButton")
    public WebElement paymentRequestsCategoryiOS;

    //Amount iOS
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public WebElement paymentRequestsAmountiOS;

    //Amount
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "Amount")
    public WebElement paymentRequestsCategoryGroup1Amount;

    //Category2
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]//android.widget.Spinner")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public WebElement paymentRequestsCategoryGroup2Spinner;

    //Amount2
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]//android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public WebElement paymentRequestsCategoryGroup2Amount;


    //Category3
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.view.ViewGroup[4]//android.widget.Spinner")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public WebElement paymentRequestsCategoryGroup3Spinner;

    //Amount3
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.view.ViewGroup[4]//android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public WebElement paymentRequestsCategoryGroup3Amount;




    //Amount key 1
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/oneButton")
    public WebElement paymentRequestsKey1;

    //Amount key 2
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/twoButton")
    public WebElement paymentRequestsKey2;

    //Amount key 3
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/threeButton")
    public WebElement paymentRequestsKey3;

    //Amount key 4
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fourButton")
    public WebElement paymentRequestsKey4;

    //Amount key 5
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fiveButton")
    public WebElement paymentRequestsKey5;

    //Amount key 6
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/sixButton")
    public WebElement paymentRequestsKey6;

    //Amount key 7
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/sevenButton")
    public WebElement paymentRequestsKey7;

    //Amount key 8
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/eightButton")
    public WebElement paymentRequestsKey8;

    //Amount key 9
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/nineButton")
    public WebElement paymentRequestsKey9;

    //Amount key 0
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/zeroButton")
    public WebElement paymentRequestsKey0;

    //Amount key Delete
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/deleteButton")
    public WebElement paymentRequestsKeyDelete;

    //Amount key Enter
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/enterButton")
    public WebElement paymentRequestsKeyEnter;



    //Add Category Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/button")
    @iOSXCUITFindBy(accessibility = "＋ Add category and amount")
    public WebElement paymentRequestsAddCategory;


    //Save Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/saveButton")
    @iOSXCUITFindBy(accessibility = "Save")
    public WebElement paymentRequestsSaveButton;


    //Submit Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/submitButton")
    @iOSXCUITFindBy(accessibility = "Submit")
    public WebElement paymentRequestsSubmitButton;

    //No Button
    @iOSXCUITFindBy(accessibility = "No")
    public WebElement paymentRequestsNoButton;

    //Yes Button
    @iOSXCUITFindBy(accessibility = "Yes")
    public WebElement paymentRequestsYesButton;


}
