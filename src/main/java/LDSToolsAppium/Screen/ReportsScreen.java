package LDSToolsAppium.Screen;

import LDSToolsAppium.BaseDriver;
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



public class ReportsScreen extends BasePage {

    public ReportsScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver );
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Reports Main Screen ******************

    //Action and Interview List
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Action and Interview List']")
    @iOSXCUITFindBy(accessibility = "Action and Interview List")
    public WebElement actionAndInterviewListReport;

    //Birthday List
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Birthday List']")
    @iOSXCUITFindBy(accessibility = "Birthday List")
    public WebElement birthdayListtReport;

    //Home Teaching
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home Teaching']")
    @iOSXCUITFindBy(accessibility = "Home Teaching")
    public WebElement homeTeachingReport;

    //Members Moved In
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members Moved In']")
    @iOSXCUITFindBy(accessibility = "Members Moved In")
    public WebElement membersMovedInReport;

    //Members Moved Out
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members Moved Out']")
    @iOSXCUITFindBy(accessibility = "Members Moved Out")
    public WebElement membersMovedOutReport;

    //Move In and Out Report
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Move In and Out Report']")
    @iOSXCUITFindBy(accessibility = "Move In and Out Report")
    public WebElement membersMoveInAndOutReport;

    //Move In and Out Report
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Move In and Out Report']")
    @iOSXCUITFindBy(accessibility = "Move In and Out Report")
    public WebElement moveInAndOutReport;

    //Move Records In and Out
    @AndroidFindBy(xpath = "//*[@text='Move Records In and Out']")
    @iOSXCUITFindBy(accessibility = "Move Records In and Out")
    public WebElement moveRecordsInAndOut;

    //Move In and Out Report In tab
    @AndroidFindBy(xpath = "//*[@text='In']")
//    @iOSXCUITFindBy(accessibility = "Members Moved In")
    @iOSXCUITFindBy(accessibility = "Move In")
    public WebElement moveReportInTab;

    //Move In and Out Report Out tab
    @AndroidFindBy(xpath = "//*[@text='Out']")
//    @iOSXCUITFindBy(accessibility = "Members Moved Out")
    @iOSXCUITFindBy(accessibility = "Move Out")
    public WebElement moveReportOutTab;


    //Members with Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members with Callings']")
    @iOSXCUITFindBy(accessibility = "Members with Callings")
    public WebElement membersWithCallingsReport;

    //Members without Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members without Callings']")
    @iOSXCUITFindBy(accessibility = "Members without Callings")
    public WebElement membersWithOutCallingsReport;

    //Missionary Progress Record
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Missionary Progress Record']")
    @iOSXCUITFindBy(accessibility = "Missionary Progress Record")
    public WebElement missionaryProgressRecordReport;

    //New Members
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New Members']")
    @iOSXCUITFindBy(accessibility = "New Members")
    public WebElement newMembersReport;

    //Temple Recommend Status
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Temple Recommend Status']")
    @iOSXCUITFindBy(accessibility = "Temple Recommend Status")
    public WebElement templeRecommendStatusReport;

    //Unit Statistics
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unit Statistics']")
    @iOSXCUITFindBy(accessibility = "Unit Statistics")
    public WebElement unitStatisticsReport;

    //Quarterly Report
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Quarterly Report']")
    @iOSXCUITFindBy(accessibility = "Quarterly Report")
    public WebElement quarterlyReport;


    //Youth Recommend Status
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Youth Recommend Status']")
    @iOSXCUITFindBy(accessibility = "Youth Recommend Status")
    public WebElement youthRecommendStatusReport;

    //Visiting Teaching
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Visiting Teaching']")
    @iOSXCUITFindBy(accessibility = "Visiting Teaching")
    public WebElement visitingTeachingsReport;

    //Sacrament Attendance
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sacrament Attendance']")
    @iOSXCUITFindBy(accessibility = "Sacrament Attendance")
    public WebElement sacramentAttendanceReport;

    //Progress Record - renamed to Covenant Path Progress
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Progress Record']")
    @AndroidFindBy(xpath = "//*[@text='Covenant Path Progress']")
    @iOSXCUITFindBy(accessibility = "Covenant Path Progress")
    public WebElement progressRecordReport;

    //Class and Quorum Attendance
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Class and Quorum Attendance']")
    @iOSXCUITFindBy(accessibility = "Class and Quorum Attendance")
    public WebElement classAndQuorumAttendanceReport;

    //Ordinances
    @AndroidFindBy(xpath = "//*[@text='Record Ordinances']")
    @iOSXCUITFindBy(accessibility = "Record Ordinances")
    public WebElement ordinancesReport;



    //Sort
    @iOSXCUITFindBy(accessibility = "Sort")
    public WebElement sortReport;

    //Filters
    @iOSXCUITFindBy(accessibility = "Filters")
    public WebElement sortFilters;


    //Cancel
    @iOSXCUITFindBy(accessibility = "Cancel")
    public WebElement cancelSort;

    //Name
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"name\")]")
    @iOSXCUITFindBy(accessibility = "Name")
    public  WebElement nameSort;

    //Organization
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"organization\")]")
    @iOSXCUITFindBy(accessibility = "Organization")
    public  WebElement organizationSort;

    //Duration
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"duration\")]")
    @iOSXCUITFindBy(accessibility = "Duration")
    public  WebElement durationSort;

    //Not Set Apart
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"not set apart\")]")
    @iOSXCUITFindBy(accessibility = "Not Set Apart")
    public  WebElement notSetApartSort;

    //All
//    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all\")]")
    @AndroidFindBy(xpath = "//*[@text='All']")
    @iOSXCUITFindBy(accessibility = "All")
    public  WebElement allSort;

    //Male
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"male\")]")
    @iOSXCUITFindBy(accessibility = "Male")
    public  WebElement maleSort;

    //Female
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"female\")]")
    @iOSXCUITFindBy(accessibility = "Female")
    public  WebElement femaleSort;

    //Active
//    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"active\")]")
    @AndroidFindBy(xpath = "//*[@text='Active']")
    @iOSXCUITFindBy(accessibility = "Active")
    public  WebElement activeSort;

    //Expiring
//    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"expiring\")]")
    @AndroidFindBy(xpath = "//*[@text='Expiring']")
    @iOSXCUITFindBy(accessibility = "Expiring")
    public  WebElement expiringSort;

    //Expired
//    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"expired\")]")
    @AndroidFindBy(xpath = "//*[@text='Expired']")
    @iOSXCUITFindBy(accessibility = "Expired")
    public  WebElement expiredSort;

    //Other
//    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"other\")]")
    @AndroidFindBy(xpath = "//*[@text='Other']")
    @iOSXCUITFindBy(accessibility = "Other")
    public  WebElement otherSort;

    //All recommends
    @AndroidFindBy(xpath = "//*[@text='All recommends']")
    public  WebElement allRecommendsSort;

    //Proxy Baptisms and Confirmations
    @AndroidFindBy(xpath = "//*[@text='Proxy Baptisms and Confirmations']")
    public  WebElement proxyBaptismsAndConfirmationsSort;

    //Regular
    @AndroidFindBy(xpath = "//*[@text='Regular']")
    public  WebElement regularSort;

    //Youth
    @AndroidFindBy(xpath = "//*[@text='Youth']")
    public  WebElement youthSort;

    //Never Issued
//    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"never issued\")]")
    @AndroidFindBy(xpath = "//*[@text='Never Issued']")
    @iOSXCUITFindBy(accessibility = "Never Issued")
    public  WebElement neverIssuedSort;

    //Unordained
//    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"unordained\")]")
    @AndroidFindBy(xpath = "//*[@text='Unordained']")
    @iOSXCUITFindBy(accessibility = "Unordained")
    public  WebElement unordainedSort;

    //Not Baptized
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"not baptized\")]")
    @iOSXCUITFindBy(accessibility = "Not Baptized")
    public  WebElement notBaptizedSort;



    //*************************************************************************************
    //********************* Action and Interview List *************************************
    //*************************************************************************************


    //Children Approaching Baptism Age
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Children Approaching Baptism Age']")
    @iOSXCUITFindBy(accessibility = "Children Approaching Baptism Age")
    public WebElement childrenApproachingBaptismAgeReport;

    //Unbaptized Members
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unbaptized Members']")
    @iOSXCUITFindBy(accessibility = "Unbaptized Members")
    public WebElement unbaptizedMembersReport;

    //Overdue Aaronic Priesthood Ordinations
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Overdue Aaronic Priesthood Ordinations'][@resource-id='org.lds.ldstools:id/reportTextView']")
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Overdue Aaronic Priesthood Ordinations'][contains(@resource-id, 'reportTextView')]")
//    @AndroidFindBy(xpath = "//android.view.View[@clickable='true']/android.widget.TextView[@text='Overdue Aaronic Priesthood Ordinations']")
    @AndroidFindBy(xpath = "//android.view.View[@clickable='true']/android.view.View/android.widget.TextView[@text='Overdue Aaronic Priesthood Ordinations']")
//    @iOSXCUITFindBy(xpath = "//*[@name='Overdue Aaronic Priesthood Ordinations'][2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Overdue Aaronic Priesthood Ordinations'])[2]")
    public WebElement overdueAaronicPriesthoodOrdinationsReport;

    //Young Single Adult Interviews
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Single Adult Interviews']")
    @iOSXCUITFindBy(accessibility = "Young Single Adult Interviews")
    public WebElement youngSingleAdultInterviewsReport;

    //Bishop's Youth Interviews
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishop’s Youth Interviews']")
    @iOSXCUITFindBy(accessibility = "Bishop’s Youth Interviews")
    public WebElement bishopsYouthInterviewsReport;

    //Bishopric Counselor Youth Interviews
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishopric Counselor Youth Interviews']")
    @iOSXCUITFindBy(accessibility = "Bishopric Counselor Youth Interviews")
    public WebElement bishopricCounselorYouthInterviewsReport;

    //Young Men Approaching Mission Age
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Men Approaching Mission Age']")
    @iOSXCUITFindBy(accessibility = "Young Men Approaching Mission Age")
    public WebElement youngMenApproachingMissionAgeReport;

    //Men Who Have Not Served a Mission
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Men Who Have Not Served a Mission']")
    @iOSXCUITFindBy(accessibility = "Men Who Have Not Served a Mission")
    public WebElement menWhoHaveNotServedaMissionReport;

    //Potential Missionary Couples
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Potential Missionary Couples']")
    @iOSXCUITFindBy(accessibility = "Potential Missionary Couples")
    public WebElement potentialMissionaryCouplesReport;




    //*************************************************************************************
    //********************* Missionary Progress Record ************************************
    //*************************************************************************************

    //Missionary Progress Filter
    @AndroidFindBy(accessibility = "Filters")
    @iOSXCUITFindBy(accessibility = "Filter")
    public  WebElement missionaryProgressFilter;

    //Missionary Progress Investigators with Baptism Date
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterInvestigatorsWithBaptismDateSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label='Investigators with Baptism Date']")
    public  WebElement mpInvestigatorsWithBaptismDate;

    //Missionary Progress Progressing Investigators
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterProgressingInvestigatorsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Progressing Investigators\"]")
    public  WebElement mpProgressingInvestigators;

    //Missionary Progress New Investigators
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterNewInvestigatorsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"New Investigators\"]")
    public  WebElement mpNewInvestigators;

    //Missionary Progress Other Investigators
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterOtherInvestigatorsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Other Investigators\"]")
    public  WebElement mpOtherInvestigators;

    //Missionary Progress Potential Investigators
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterPotentialInvestigatorsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Potential Investigators\"]")
    public  WebElement mpPotentialInvestigators;

    //Missionary Progress Recent Converts
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterRecentConvertsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Recent Converts\"]")
    public  WebElement mpRecentConverts;


    //Missionary Progress Members Being Taught
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterMembersBeingTaughtSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Members Being Taught\"]")
    public  WebElement mpMembersBeingTaught;

    //Missionary Progress Save
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/menu_item_save")
    public  WebElement mpSave;

    //Missionary Progress Expand Filter
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterHeaderArrow")
    public  WebElement mpExpandFilter;


    //Missionary Progress Remove Filter Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/removeFiltersButton")
    @iOSXCUITFindBy(accessibility = "Remove")
    public  WebElement mpRemoveFilterButton;

    //Missionary Progress Received a Visit
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterReceivedAVisitTextView")
    @iOSXCUITFindBy(accessibility = "Received a Visit")
    public  WebElement mpReceivedAVisit;

    //Missionary Progress Attended Sacrament
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterSacramentAttendanceTextView")
    @iOSXCUITFindBy(accessibility = "Attended Sacrament")
    public  WebElement mpAttendedSacrament;

    //Missionary Progress Assigned
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterFellowshippersTextView")
    @iOSXCUITFindBy(accessibility = "Assigned")
    public  WebElement mpAssigned;

    //Missionary Progress Last Week
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last Week\"]")
    @iOSXCUITFindBy(accessibility = "Last Week")
    public  WebElement mpLastWeek;

    //Missionary Progress Last 2 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 2 Weeks\"]")
    @iOSXCUITFindBy(accessibility = "Last 2 Weeks")
    public  WebElement mpLast2Weeks;

    //Missionary Progress Last 3 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 3 Weeks\"]")
    @iOSXCUITFindBy(accessibility = "Last 3 Weeks")
    public  WebElement mpLast3Weeks;

    //Missionary Progress Last 4 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 4 Weeks\"]")
    @iOSXCUITFindBy(accessibility = "Last 4 Weeks")
    public  WebElement mpLast4Weeks;

    //Missionary Progress Last 5 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 5 Weeks\"]")
    @iOSXCUITFindBy(accessibility = "Last 5 Weeks")
    public  WebElement mpLast5Weeks;

    //Missionary Progress All
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"All\"]")
    @iOSXCUITFindBy(accessibility = "All")
    public  WebElement mpAll;

    //Missionary Progress Cancel
    @AndroidFindBy(xpath = "//*[@text=\"Cancel\"]")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  WebElement mpCancel;


    //*************************************************************************************
    //******************************** Progress Record ************************************
    //*************************************************************************************

    //New Members
    @AndroidFindBy(xpath = "//*[@text='New Members']")
    @iOSXCUITFindBy(accessibility = "New Members")
    public  WebElement prNewMembers;

    //People being taught
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PEOPLE BEING TAUGHT']")
    @iOSXCUITFindBy(accessibility = "People Being Taught")
    public  WebElement prPeopleBeingTaught;

    //Search Field
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterEditText")
    @iOSXCUITFindBy(accessibility = "Search")
    public  WebElement prSearchField;


    //Cancel Search
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/clearTextImageButton")
    @iOSXCUITFindBy(accessibility = "Clear text")
    public WebElement prClearSearch;


    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/drop_arrow" )
    @iOSXCUITFindBy(xpath = "//*[@name='LDS_Tools.OneWorkView']//XCUIElementTypeStaticText[2]")
    public WebElement prUnitSelected;




    // ************ Sacrament Attendance Page

    //Sacrament Attendance First Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week1EditText")
    public  WebElement sacramentAttendanceFirstWeek;


    //Sacrament Attendance Second Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week2EditText")
    public  WebElement sacramentAttendanceSecondWeek;


    //Sacrament Attendance Third Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week3EditText")
    public  WebElement sacramentAttendanceThirdWeek;


    //Sacrament Attendance Fourth Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week4EditText")
    public  WebElement sacramentAttendanceFourthWeek;

    //Sacrament Attendance Fifth Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week5EditText")
    public  WebElement sacramentAttendanceFifthWeek;

    //Sacrament Attendance Dialog Edit Field
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/editText")
    public  WebElement sacramentAttendanceDialogEditField;

    //Sacrament Attendance Cancel
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/button2")
    public  WebElement sacramentAttendanceDialogCancel;

    //Sacrament Attendance Ok
    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    public  WebElement sacramentAttendanceDialogOk;

    //Sacrament Attendance Counter Icon
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/text_input_end_icon")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Counter']")
    @iOSXCUITFindBy(accessibility = "sacramentCounterIcon")
    public  WebElement sacramentAttendanceCounterIcon;



    //Sacrament Attendance Add Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/counterTextView")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tap to add, longpress to edit']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeButton[1]")
    public  WebElement sacramentAttendanceAddButton;


    //Sacrament Attendance Minus Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/decrementFab")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Decrease Count']")
//    @iOSXCUITFindBy(accessibility = "minus.circle")
    @iOSXCUITFindBy(accessibility = "remove")
    public  WebElement sacramentAttendanceMinusButton;


    //Sacrament Attendance Next Section
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/sectionButton")
    public  WebElement sacramentAttendanceCounterNextSection;

    //Sacrament Attendance Counter Save Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/saveButton")
    @AndroidFindBy(xpath = "//*[contains(@text,'Save')]")



    @iOSXCUITFindBy(accessibility = "Save")
    public  WebElement sacramentAttendanceCounterSave;


    //************* Class and Quorum Attendance ******************

    //Class and Quorum - Search
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterEditText")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Search']/..")
    @iOSXCUITFindBy(accessibility = "Search")
    public  WebElement classAndQuorumSearch;

    //Class and Quorum - Clear Search
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/clearTextImageButton")
    @iOSXCUITFindBy(accessibility = "Clear text")
    public  WebElement classAndQuorumClearSearch;


    //Class and Quorum First Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week1")
    public  WebElement classAndQuorumFirstWeek;


    //Class and Quorum Second Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week2")
    public  WebElement classAndQuorumSecondWeek;


    //Class and Quorum Third Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week3")
    public  WebElement classAndQuorumThirdWeek;

    //Class and Quorum Fourth Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week4")
    public  WebElement classAndQuorumFourthWeek;

    //Class and Quorum Fifth Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week5")
    public  WebElement classAndQuorumFifthWeek;

    //Class and Quorum - Filters
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/iconImageView")
    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    @iOSXCUITFindBy(accessibility = "Filter")
    public  WebElement classAndQuorumFilter;

    //Class and Quorum - Filters - All
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Classes and Quorums']")
    @iOSXCUITFindBy(accessibility = "All")
    public  WebElement classAndQuorumFilterAll;

    //Class and Quorum - Filters - All Aaronic
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Aaronic Priesthood Quorums']")
    @iOSXCUITFindBy(accessibility = "Aaronic Priesthood Quorums")
    public  WebElement classAndQuorumFilterAaronic;

    //Class and Quorum - Filters - All Classes
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Classes']")
    @iOSXCUITFindBy(accessibility = "All")
    public  WebElement classAndQuorumFilterAaronicAllClasses;

    //Class and Quorum - Filters - Deacons Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Deacons Quorum']")
    @iOSXCUITFindBy(accessibility = "Deacons Quorum")
    public  WebElement classAndQuorumFilterDeaconsQuorum;

    //Class and Quorum - Filters - Teachers Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Teachers Quorum']")
    @iOSXCUITFindBy(accessibility = "Teachers Quorum")
    public  WebElement classAndQuorumFilterTeachersQuorum;

    //Class and Quorum - Filters - Priests Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Priests Quorum']")
    @iOSXCUITFindBy(accessibility = "Priests Quorum")
    public  WebElement classAndQuorumFilterPriestsQuorum;

    //Class and Quorum - Filters - Elders Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Elders Quorum']")
    @iOSXCUITFindBy(accessibility = "Elders Quorum")
    public  WebElement classAndQuorumFilterEldersQuorum;

    //Class and Quorum - Filters - Primary
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary']")
    @iOSXCUITFindBy(accessibility = "Primary")
    public  WebElement classAndQuorumFilterPrimary;


    //Class and Quorum Visitors
//    @AndroidFindBy(xpath = "//android.widget.Button[@text='VISITORS']")
    @AndroidFindBy(xpath = "//*[@text='Visitors']")
//    Have to use xpath for iOS the page source is too big for the other methods
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Add Visitors')]")
    public WebElement classAndQuorumVisitors;

    //Class and Quorum Visitors Done - Save
    @AndroidFindBy(xpath = "//*[@content-desc='Save']")
    @iOSXCUITFindBy(accessibility = "Done")
    public WebElement classAndQuorumVisitorsDone;

    //Class and Quorum Visitors Cancel
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'toolbar')]/android.widget.ImageButton")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public WebElement classAndQuorumVisitorsCancel;

    //*************************************************************************************
    //************************************* Ordinances ************************************
    //*************************************************************************************


    //Ordinances- Add
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fab")
    @iOSXCUITFindBy(accessibility = "Add")
    public  WebElement ordinancesAdd;

    //Ordinances-Filter
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/iconImageView")
    @iOSXCUITFindBy(accessibility = "Filter")
    public  WebElement ordinancesFilter;


    //Record Aaronic Priesthood Ordination
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Record Aaronic Priesthood Ordination")
    public  WebElement ordinancesAaronicPriesthood;

    //Submit Melchizedek Priesthood Ordination
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Submit Melchizedek Priesthood Ordination")
    public  WebElement ordinancesMelchizedekPriesthood;

    //Ordination Search for Member
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Search")
    public  WebElement ordinancesSearch;

    //Ordination Select Priesthood Office
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Priesthood Office")
    public  WebElement ordinancesPriesthoodOffice;

    //Ordination Deacon
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Deacon")
    public  WebElement ordinancesDeacon;

    //Ordination Teacher
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Teacher")
    public  WebElement ordinancesTeacher;

    //Ordination Priest
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Priest")
    public  WebElement ordinancesPriest;

    //Ordination Elder
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Elder")
    public  WebElement ordinancesElder;

    //Ordination High Priest
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "High Priest")
    public  WebElement ordinancesHighPriest;

    //Ordination Date Picker
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Date Picker")
    public  WebElement ordinancesDatePicker;

    //Ordination Officiator
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Officiator")
    public  WebElement ordinancesOfficiator;

    //Ordination Member of Ward or Branch
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Member of Ward or Branch")
    public  WebElement ordinancesMemberOfWardOrBranch;

    //Ordination Member Outside of Ward or Branch
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Member Outside of Ward or Branch")
    public  WebElement ordinancesMemberOutsideOfWardOrBranch;

    //Ordination Switch Bishop has interviewed...
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSwitch'")
    public  WebElement ordinancesMemberBishopInterviewSwitch;

    //Ordination Record Button
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Record")
    public  WebElement ordinancesRecord;

    //Ordination Submit Button
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Record")
    public  WebElement ordinancesSubmit;

    //Ordination Cancel Button
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  WebElement ordinancesCancel;


    // **************************************** Move In and Out ****************************************
    //Main Move in and out page
    //In Tab
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Move record in'][1]")
    @iOSXCUITFindBy(accessibility = "In")
    public  WebElement moveRecordsInTab;

    //Out Tab
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Move record out'][1]")
    @iOSXCUITFindBy(accessibility = "Out")
    public  WebElement moveRecordsOutTab;

    //In Button
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Move record in']/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Inbox' AND type == 'XCUIElementTypeButton'")
    public  WebElement moveRecordsInButton;

    //Out Button
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Move record out'][2]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Outbox' AND type == 'XCUIElementTypeButton'")
    public  WebElement moveRecordsOutButton;

    //Cancel Button
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Close\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextView'")
    public  WebElement moveRecordsCancelButton;

    //MRN
    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextView'")
    public  WebElement moveRecordsMRNField;

    //More Options Switch
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='More Search Options']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='More Search Options']/XCUIElementTypeSwitch")
    public  WebElement moveRecordsMoreSearchOptions;

    //Name
    @AndroidFindBy(xpath = "//*[@text='Name']")
    @iOSXCUITFindBy(xpath = "//*[@name='Name']")
    public  WebElement moveRecordsName;

    //Birth Date
    @AndroidFindBy(xpath = "//*[@text='Birth Date']")
    @iOSXCUITFindBy(accessibility = "Date Picker")
    public  WebElement moveRecordsBirthDate;

        //Birth Date Edit Button
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mtrl_picker_header_toggle")
        public  WebElement moveRecordsBirthDateEditButton;

        //Birth Date Edit Field
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/textinput_placeholder")
        public  WebElement moveRecordsBirthDateEditField;

        //Birth Date Cancel
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/cancel_button")
        public  WebElement moveRecordsBirthDateCancelButton;

        //Birth Date OK
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/confirm_button")
        public  WebElement moveRecordsBirthDateOkButton;

    //Gender
    @AndroidFindBy(xpath = "//*[@text='Gender']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Optional']")
    public  WebElement moveRecordsGender;

    //Country
    @AndroidFindBy(xpath = "//*[@text='Country']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Country, Optional' AND type == 'XCUIElementTypeButton'")
    public  WebElement moveRecordsCountry;

    //Country address to move to
    @AndroidFindBy(xpath = "//*[@text='Country']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Country, Select' AND type == 'XCUIElementTypeButton'")
    public  WebElement moveRecordsCountry2;


    //Next
    @AndroidFindBy(xpath = "//*[@text='NEXT']")
    @iOSXCUITFindBy(accessibility = "Next")
    public  WebElement moveRecordsNext;

    //Address Selector
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Dropdown menu']/android.widget.EditText")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Address, Address Known'")
    public  WebElement moveRecordsAddressSelector;

        //Address Known
        @AndroidFindBy(xpath = "//*[@text='Address Known']")
        @iOSXCUITFindBy(accessibility = "Address Known")
        public  WebElement moveRecordsAddressKnown;

        //Address Unchanging
        @AndroidFindBy(xpath = "//*[@text='Address Unchanging']")
        @iOSXCUITFindBy(accessibility = "Address Unchanging")
        public  WebElement moveRecordsAddressUnchanging;

        //Joining a Household
        @AndroidFindBy(xpath = "//*[@text='Joining a Household']")
        @iOSXCUITFindBy(accessibility = "Joining a Household")
        public  WebElement moveRecordsJoiningAHousehold;

    //Locate On Map
    @AndroidFindBy(xpath = "//*[@text='LOCATE ON MAP']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Locate on Map' AND type == 'XCUIElementTypeButton'")
    public  WebElement moveRecordsLocateOnMap;

    //Address 1
    @AndroidFindBy(xpath = "//*[@text='Address 1']")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='Address 1']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Address 1' AND type == 'XCUIElementTypeStaticText'")
    public  WebElement moveRecordsAddress1;

    //Address 2
    @AndroidFindBy(xpath = "//*[@text='Address 2']")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='Address 2']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Address 2' AND type == 'XCUIElementTypeStaticText'")
    public  WebElement moveRecordsAddress2;

    //City
    @AndroidFindBy(xpath = "//*[@text='City']")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='City']//XCUIElementTypeTextView")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'City' AND type == 'XCUIElementTypeStaticText'")
    public  WebElement moveRecordsCity;

    //State or Province
    @AndroidFindBy(xpath = "//*[@text='State or Province']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='State or Province, Select']")
    public  WebElement moveRecordsStateOrProvince;

    //Postal Code
    @AndroidFindBy(xpath = "//*[@text='Postal Code']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Postal Code']")
    public  WebElement moveRecordsPostalCode;


    //Move Records In
    @AndroidFindBy(xpath = "//*[@text='MOVE RECORDS IN']")
    @iOSXCUITFindBy(accessibility = "Move In")
    public  WebElement moveRecordsMoveRecordsIn;

    //Discard Move
    @AndroidFindBy(xpath = "//*[@content-desc='Discard Move']")
    @iOSXCUITFindBy(accessibility = "Trash")
    public  WebElement moveRecordsDiscardMove;

    //Discard Button
    @AndroidFindBy(xpath = "//*[@text='DISCARD']")
    @iOSXCUITFindBy(accessibility = "OK")
    public  WebElement moveRecordsDiscardButton;


    //Quarterly Report Unit Selector
    @AndroidFindBy(xpath ="//*[@text='Quarterly Report']")
    @iOSXCUITFindBy(xpath ="//*[contains(@name, 'Quarterly Report')]")
    public  WebElement unitSelectorQR;







    public void saveMissonaryProgressFilter() throws Exception {
        if (getOS().equals("ios")) {
            backButton.click();
        } else {
            mpSave.click();
            mpExpandFilter.click();
        }

    }


    public void selectSort(WebElement myElement) throws Exception {
        if (getOS().equals("ios")) {
            sortReport.click();
            myElement.click();
        } else {
            myElement.click();
        }

    }

    public void selectFilters(WebElement myElement) throws Exception {
        if (getOS().equals("ios")) {
            sortFilters.click();
            myElement.click();
        } else {

            myElement.click();
        }

    }





    //Calendar
    //@AndroidFindBy(xpath = "//*[@text='Calendar']")
    //@iOSXCUITFindBy(iOSNsPredicate = "name == 'Calendars'")
    //public  WebElement calendar;


}
