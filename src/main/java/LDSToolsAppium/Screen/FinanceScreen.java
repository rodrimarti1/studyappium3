package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
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
    public MobileElement financePaymentRequests;

    //Add Payment Requests
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/newPaymentRequestFab")
    @iOSXCUITFindBy(accessibility = "＋ New Payment Request")
    public MobileElement paymentRequestsAdd;

    //Add Myself
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addMyselfButton")
    @iOSXCUITFindBy(accessibility = "Add Myself")
    public MobileElement paymentRequestsAddMyself;

    //Add Other Payee
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addOtherButton")
    @iOSXCUITFindBy(accessibility = "Add Other Payee")
    public MobileElement paymentRequestsAddOther;

    //Search
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterEditText")
    @iOSXCUITFindBy(accessibility = "Search")
    public MobileElement paymentRequestsSearch;

    //Add Payee Fab
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fab")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsAddPayeeFab;



    //Select this payee
    @iOSXCUITFindBy(accessibility = "Select this Payee")
    public MobileElement paymentRequestsSelectThisPayee;

    //Add Purpose
    @iOSXCUITFindBy(accessibility = "＋ Add Purpose")
    public MobileElement paymentRequestsAddPurpose;

    //Purpose
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/purposeEditText")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'")
    public MobileElement paymentRequestsPurpose;

    //Purpose Counter
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/textinput_counter")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'")
    public MobileElement paymentRequestsCounter;

    //Purpose submit button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/submitButton")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'")
    public MobileElement paymentRequestsPurposeSubmit;


    //Account
    //TODO: iOS code
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/accountAutoCompleteTextView")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsAccount;

    //Purpose page add button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fab")
    @iOSXCUITFindBy(accessibility = "OK")
    public MobileElement paymentRequestsPurposeAddButton;



    //Payment Information

    //Add Receipt
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addReceiptTopButton")
    @iOSXCUITFindBy(accessibility = "receipt")
    public MobileElement paymentRequestsAddReceipt;

    //Take a Picture
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/takePhotoTextView")
    @iOSXCUITFindBy(accessibility = "Take a picture")
    public MobileElement paymentRequestsTakeAPicture;

    //Choose a file
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/chooseFileTextView")
    @iOSXCUITFindBy(accessibility = "Choose a file")
    public MobileElement paymentRequestsChooseAFile;

    //Photo Gallery
    @iOSXCUITFindBy(accessibility = "Photo Gallery")
    public MobileElement paymentRequestsPhotoGallery;

    //Image to select
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[3]")
    public MobileElement paymentRequestsImageToSelect;

    //Camera Button
    //TODO: iOS code
    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'picture')]")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsCameraButton;

    //Camera Button #2
    //TODO: iOS code
    @AndroidFindBy(xpath = "//*[contains(@text, 'picture')]")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsCameraButton2;

    //Camera Button #3
    //TODO: iOS code
    @AndroidFindBy(xpath = "//*[@content-desc='Take photo']")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsCameraButton3;

    //Camera Done
    @AndroidFindBy(xpath = "//*[@content-desc='Done']")
    public MobileElement paymentRequestsCameraButtonDone;

    //Camera OK
    @AndroidFindBy(xpath = "//*[@text='OK']")
    public MobileElement paymentRequestsCameraButtonOK;


    //Category Top View Group
    //Category
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.Spinner")
    @iOSXCUITFindBy(accessibility = "Category: Select Category")
    public MobileElement paymentRequestsCategoryGroup1Spinner;

    //Category iOS
    @iOSXCUITFindBy(accessibility = "Category")
    public MobileElement paymentRequestsCategoryiOS;

    //Amount iOS
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public MobileElement paymentRequestsAmountiOS;

    //Amount
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "Amount")
    public MobileElement paymentRequestsCategoryGroup1Amount;

    //Category2
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]//android.widget.Spinner")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsCategoryGroup2Spinner;

    //Amount2
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]//android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsCategoryGroup2Amount;


    //Category3
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.view.ViewGroup[4]//android.widget.Spinner")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsCategoryGroup3Spinner;

    //Amount3
    //TODO: iOS code
    @AndroidFindBy(xpath = "//android.view.ViewGroup[4]//android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public MobileElement paymentRequestsCategoryGroup3Amount;




    //Amount key 1
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/oneButton")
    public MobileElement paymentRequestsKey1;

    //Amount key 2
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/twoButton")
    public MobileElement paymentRequestsKey2;

    //Amount key 3
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/threeButton")
    public MobileElement paymentRequestsKey3;

    //Amount key 4
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fourButton")
    public MobileElement paymentRequestsKey4;

    //Amount key 5
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fiveButton")
    public MobileElement paymentRequestsKey5;

    //Amount key 6
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/sixButton")
    public MobileElement paymentRequestsKey6;

    //Amount key 7
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/sevenButton")
    public MobileElement paymentRequestsKey7;

    //Amount key 8
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/eightButton")
    public MobileElement paymentRequestsKey8;

    //Amount key 9
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/nineButton")
    public MobileElement paymentRequestsKey9;

    //Amount key 0
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/zeroButton")
    public MobileElement paymentRequestsKey0;

    //Amount key Delete
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/deleteButton")
    public MobileElement paymentRequestsKeyDelete;

    //Amount key Enter
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/enterButton")
    public MobileElement paymentRequestsKeyEnter;



    //Add Category Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/button")
    @iOSXCUITFindBy(accessibility = "＋ Add category and amount")
    public MobileElement paymentRequestsAddCategory;


    //Save Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/saveButton")
    @iOSXCUITFindBy(accessibility = "Save")
    public MobileElement paymentRequestsSaveButton;


    //Submit Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/submitButton")
    @iOSXCUITFindBy(accessibility = "Submit")
    public MobileElement paymentRequestsSubmitButton;

    //No Button
    @iOSXCUITFindBy(accessibility = "No")
    public MobileElement paymentRequestsNoButton;

    //Yes Button
    @iOSXCUITFindBy(accessibility = "Yes")
    public MobileElement paymentRequestsYesButton;


}
