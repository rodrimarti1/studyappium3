package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.en.And;
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
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/newPaymentRequestFab")
    @AndroidFindBy(accessibility = "New Payment Request")
//    @iOSXCUITFindBy(accessibility = "New Payment Request")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'New Payment Request')]")
    public WebElement paymentRequestsAdd;

    //Add Myself
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addMyselfButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Myself']")
    @iOSXCUITFindBy(accessibility = "Add Myself")
    public WebElement paymentRequestsAddMyself;

    //Add Other Payee
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addOtherButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Other Payee']")
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
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/purposeEditText")
    @AndroidFindBy(xpath = "//*[@text='Purpose']/../..")
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
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/addReceiptTopButton")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Add supporting documentation']/following-sibling::android.widget.Button")
//    @iOSXCUITFindBy(accessibility = "Add Receipt, Hand written receipts are also acceptable")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add Receipt\"]")
    public WebElement paymentRequestsAddReceipt;

    //Take a picture small button
    @AndroidFindBy(xpath = "//*[@text='Take a picture']")
    public WebElement paymentRequestsTakeAPictureSmall;

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

    //Location button
    @AndroidFindBy(xpath = "//*[contains(@text, 'While using the app')]")
    public WebElement paymentRequestsCameraLocation;

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

    //Camera Button #4
    //TODO: iOS code
    @AndroidFindBy(xpath = "//*[@content-desc='Shutter']")
    @iOSXCUITFindBy(accessibility = "Payment Requests")
    public WebElement paymentRequestsCameraButton4;

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

    //Category Search
    @AndroidFindBy(xpath = "//*[@text='Search Categories']/../..")
    public WebElement paymentRequestsCategorySearch;

    //Category iOS
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Category']/following-sibling::XCUIElementTypeButton")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Category']/following-sibling::XCUIElementTypeImage[@name='Forward']")
    public WebElement paymentRequestsCategoryiOS;

    //Category Android
//    @AndroidFindBy(xpath = "//*[@text='Categories and Amounts']/../following-sibling::android.widget.EditText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Category']")
    public WebElement paymentRequestsCategoryAndroid;

    //Amount iOS
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public WebElement paymentRequestsAmountiOS;

    //Categories and Anounts label
    @iOSXCUITFindBy(accessibility = "Categories and Amounts")
    public WebElement paymentRequestCategoriesAndAmountsLabel;

    //Amount
//    @AndroidFindBy(xpath = "//*[@content-desc='Remove Category']/../following-sibling::android.view.View")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Amount']")
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
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/oneButton")
    @AndroidFindBy(xpath = "//*[@text='1']/..")
    public WebElement paymentRequestsKey1;

    //Amount key 2
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/twoButton")
    @AndroidFindBy(xpath = "//*[@text='2']/..")
    public WebElement paymentRequestsKey2;

    //Amount key 3
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/threeButton")
    @AndroidFindBy(xpath = "//*[@text='3']/..")
    public WebElement paymentRequestsKey3;

    //Amount key 4
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fourButton")
    @AndroidFindBy(xpath = "//*[@text='4']/..")
    public WebElement paymentRequestsKey4;

    //Amount key 5
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fiveButton")
    @AndroidFindBy(xpath = "//*[@text='5']/..")
    public WebElement paymentRequestsKey5;

    //Amount key 6
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/sixButton")
    @AndroidFindBy(xpath = "//*[@text='6']/..")
    public WebElement paymentRequestsKey6;

    //Amount key 7
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/sevenButton")
    @AndroidFindBy(xpath = "//*[@text='7']/..")
    public WebElement paymentRequestsKey7;

    //Amount key 8
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/eightButton")
    @AndroidFindBy(xpath = "//*[@text='8']/..")
    public WebElement paymentRequestsKey8;

    //Amount key 9
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/nineButton")
    @AndroidFindBy(xpath = "//*[@text='9']/..")
    public WebElement paymentRequestsKey9;

    //Amount key 0
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/zeroButton")
    @AndroidFindBy(xpath = "//*[@text='0']/..")
    public WebElement paymentRequestsKey0;

    //Amount key Delete
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/deleteButton")
    @AndroidFindBy(xpath = "//*[@content-desc='Delete'][1]/..")
    public WebElement paymentRequestsKeyDelete;

    //Amount key Enter
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/enterButton")
    @AndroidFindBy(xpath = "//*[@text='0']/../following-sibling::android.view.View")
    public WebElement paymentRequestsKeyEnter;



    //Add Category Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/button")
    @iOSXCUITFindBy(accessibility = "＋ Add category and amount")
    public WebElement paymentRequestsAddCategory;


    //Save Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/saveButton")
    @AndroidFindBy(xpath = "//*[@content-desc='Navigate up']")
    @iOSXCUITFindBy(accessibility = "Save")
    public WebElement paymentRequestsSaveButton;


    //Submit Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/submitButton")
    @AndroidFindBy(xpath = "//*[@text='Submit']/..")
    @iOSXCUITFindBy(accessibility = "Submit")
    public WebElement paymentRequestsSubmitButton;

    //No Button
    @iOSXCUITFindBy(accessibility = "No")
    public WebElement paymentRequestsNoButton;

    //Yes Button
    @iOSXCUITFindBy(accessibility = "Yes")
    public WebElement paymentRequestsYesButton;


    //Expenses
    //Expenses
    @AndroidFindBy(xpath = "//*[@text='Expenses']")
    @iOSXCUITFindBy(accessibility = "Expenses")
    public WebElement financeExpenses;

    //Payment Type
    @AndroidFindBy(xpath = "//*[@text='Payment Type']")
//    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Payment Type')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Payment Type']/following-sibling::XCUIElementTypeStaticText")
    public WebElement financePaymentType;

    //Payment Type Check
    @AndroidFindBy(xpath = "//*[@text='Check']")
    @iOSXCUITFindBy(xpath = "//*[@name='Check']")
    public WebElement financePaymentTypeCheck;

    //Payment Type Electronic ACH Transfer
    @AndroidFindBy(xpath = "//*[@text='Electronic ACH Transfer']")
    @iOSXCUITFindBy(xpath = "//*[@name='Electronic ACH Transfer']")
    public WebElement financePaymentTypeElectronicACHTransfer;

    //Edit Purpose
    @AndroidFindBy(xpath = "//*[@text='Purpose']/../../EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView")
    public WebElement financePaymentEditPurpose;

    //Receipt
    @AndroidFindBy(xpath = "//*[@content-desc='Review Image']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Close, Selected']/XCUIElementTypeImage")
    public WebElement financePaymentReceipt;

        //Receipt Approve
        @AndroidFindBy(xpath = "//*[@text='APPROVE']")
        @iOSXCUITFindBy(accessibility = "Approve")
        public WebElement financePaymentReceiptApprove;

        //This may change for iOS
        //Receipt Reject
        @AndroidFindBy(xpath = "//*[@text='Reject']")
        @iOSXCUITFindBy(accessibility = "Delete")
        public WebElement financePaymentReceiptReject;

    //Expense Submit
    @AndroidFindBy(xpath = "//*[@text='SUBMIT']")
    @iOSXCUITFindBy(accessibility = "Submit")
    public WebElement financePaymentApprove;

    //Second Submit Button
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Submit'])[2]")
    public WebElement financeSecondSubmitButton;

    //This may change for iOS
    //Expense Delete or Reject
    @AndroidFindBy(xpath = "//*[@text='DELETE']")
    @iOSXCUITFindBy(accessibility = "Reject")
    public WebElement financePaymentReject;


    //Add New Expense
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Enter new expense']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Add\" AND type == \"XCUIElementTypeOther\"")
    public WebElement addNewExpense;

    //Search Field for Payee
//    @AndroidFindBy(xpath = "//*[@content-desc='Search']/following-sibling::android.view.View/android.widget.TextView")
    @AndroidFindBy(xpath = "//*[@text=\"Search\"]/../..")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Search\"")
    public WebElement searchFieldForPayee;

    //Expense Purpose
    @AndroidFindBy(xpath = "//*[@text=\"Purpose\"]/../..")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Purpose\"]/following-sibling::XCUIElementTypeTextView")
    public WebElement expensePurpose;

    //Payment Type Name
    @AndroidFindBy(xpath = "//*[@text=\"Payment Type\"]/../..")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Payment Type\"]/following-sibling::XCUIElementTypeStaticText")
    public WebElement paymentTypeName;

    //Payment Type Arrow Button
    @AndroidFindBy(xpath = "//*[@content-desc='Dropdown menu']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"Forward\"])[1]")
    public WebElement paymentTypeNameArrowButton;

    //Expense Reject Button
    @AndroidFindBy(xpath = "//*[@text=\"Reject\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Reject\"]")
    public WebElement expenseRejectButton;

    //Reason Pulldown
    @AndroidFindBy(xpath = "//*[@text=\"Reason\"]/../..")
    public WebElement rejectReasonPullDown;

    //Expense Reject Reasons
    //Incorrect category
    @AndroidFindBy(xpath = "//*[@text=\"Incorrect category\"]")
    @iOSXCUITFindBy(accessibility = "Incorrect category")
    public WebElement rejectReasonIncorrectCategory;



}
