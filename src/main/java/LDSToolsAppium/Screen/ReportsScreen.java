package LDSToolsAppium.Screen;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
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
    public MobileElement actionAndInterviewListReport;

    //Birthday List
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Birthday List']")
    @iOSXCUITFindBy(accessibility = "Birthday List")
    public MobileElement birthdayListtReport;

    //Home Teaching
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home Teaching']")
    @iOSXCUITFindBy(accessibility = "Home Teaching")
    public MobileElement homeTeachingReport;

    //Members Moved In
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members Moved In']")
    @iOSXCUITFindBy(accessibility = "Members Moved In")
    public MobileElement membersMovedInReport;

    //Members Moved Out
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members Moved Out']")
    @iOSXCUITFindBy(accessibility = "Members Moved Out")
    public MobileElement membersMovedOutReport;

    //Move In and Out Report
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Move In and Out Report']")
    @iOSXCUITFindBy(accessibility = "Move In and Out Report")
    public MobileElement moveInAndOutReport;

    //Move Records In and Out
    @AndroidFindBy(xpath = "//*[@text='Move Records In and Out']")
    @iOSXCUITFindBy(accessibility = "Move Records In and Out")
    public MobileElement moveRecordsInAndOut;


    //Members with Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members with Callings']")
    @iOSXCUITFindBy(accessibility = "Members with Callings")
    public MobileElement membersWithCallingsReport;

    //Members without Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Members without Callings']")
    @iOSXCUITFindBy(accessibility = "Members without Callings")
    public MobileElement membersWithOutCallingsReport;

    //Missionary Progress Record
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Missionary Progress Record']")
    @iOSXCUITFindBy(accessibility = "Missionary Progress Record")
    public MobileElement missionaryProgressRecordReport;

    //New Members
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New Members']")
    @iOSXCUITFindBy(accessibility = "New Members")
    public MobileElement newMembersReport;

    //Temple Recommend Status
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Temple Recommend Status']")
    @iOSXCUITFindBy(accessibility = "Temple Recommend Status")
    public MobileElement templeRecommendStatusReport;

    //Unit Statistics
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unit Statistics']")
    @iOSXCUITFindBy(accessibility = "Unit Statistics")
    public MobileElement unitStatisticsReport;

    //Quarterly Report
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Quarterly Report']")
    @iOSXCUITFindBy(accessibility = "Quarterly Report")
    public MobileElement quarterlyReport;


    //Youth Recommend Status
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Youth Recommend Status']")
    @iOSXCUITFindBy(accessibility = "Youth Recommend Status")
    public MobileElement youthRecommendStatusReport;

    //Visiting Teaching
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Visiting Teaching']")
    @iOSXCUITFindBy(accessibility = "Visiting Teaching")
    public MobileElement visitingTeachingsReport;

    //Sacrament Attendance
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sacrament Attendance']")
    @iOSXCUITFindBy(accessibility = "Sacrament Attendance")
    public MobileElement sacramentAttendanceReport;

    //Progress Record - renamed to Covenant Path Progress
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Progress Record']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Covenant Path Progress']")
    @iOSXCUITFindBy(accessibility = "Covenant Path Progress")
    public MobileElement progressRecordReport;

    //Class and Quorum Attendance
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Class and Quorum Attendance']")
    @iOSXCUITFindBy(accessibility = "Class and Quorum Attendance")
    public MobileElement classAndQuorumAttendanceReport;

    //Ordinances
    @AndroidFindBy(xpath = "//*[@text='Record Ordinances']")
    @iOSXCUITFindBy(accessibility = "Record Ordinances")
    public MobileElement ordinancesReport;



    //Sort
    @iOSXCUITFindBy(accessibility = "Sort")
    public MobileElement sortReport;

    //Filters
    @iOSXCUITFindBy(accessibility = "Filters")
    public MobileElement sortFilters;


    //Cancel
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement cancelSort;

    //Name
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"name\")]")
    @iOSXCUITFindBy(accessibility = "Name")
    public  MobileElement nameSort;

    //Organization
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"organization\")]")
    @iOSXCUITFindBy(accessibility = "Organization")
    public  MobileElement organizationSort;

    //Duration
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"duration\")]")
    @iOSXCUITFindBy(accessibility = "Duration")
    public  MobileElement durationSort;

    //Not Set Apart
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"not set apart\")]")
    @iOSXCUITFindBy(accessibility = "Not Set Apart")
    public  MobileElement notSetApartSort;

    //All
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all\")]")
    @iOSXCUITFindBy(accessibility = "All")
    public  MobileElement allSort;

    //Male
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"male\")]")
    @iOSXCUITFindBy(accessibility = "Male")
    public  MobileElement maleSort;

    //Female
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"female\")]")
    @iOSXCUITFindBy(accessibility = "Female")
    public  MobileElement femaleSort;

    //Active
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"active\")]")
    @iOSXCUITFindBy(accessibility = "Active")
    public  MobileElement activeSort;

    //Expiring
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"expiring\")]")
    @iOSXCUITFindBy(accessibility = "Expiring")
    public  MobileElement expiringSort;

    //Expired
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"expired\")]")
    @iOSXCUITFindBy(accessibility = "Expired")
    public  MobileElement expiredSort;

    //Other
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"other\")]")
    @iOSXCUITFindBy(accessibility = "Other")
    public  MobileElement otherSort;

    //Never Issued
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"never issued\")]")
    @iOSXCUITFindBy(accessibility = "Never Issued")
    public  MobileElement neverIssuedSort;

    //Unordained
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"unordained\")]")
    @iOSXCUITFindBy(accessibility = "Unordained")
    public  MobileElement unordainedSort;

    //Not Baptized
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"not baptized\")]")
    @iOSXCUITFindBy(accessibility = "Not Baptized")
    public  MobileElement notBaptizedSort;



    //*************************************************************************************
    //********************* Action and Interview List *************************************
    //*************************************************************************************


    //Children Approaching Baptism Age
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Children Approaching Baptism Age']")
    @iOSXCUITFindBy(accessibility = "Children Approaching Baptism Age")
    public MobileElement childrenApproachingBaptismAgeReport;

    //Unbaptized Members
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unbaptized Members']")
    @iOSXCUITFindBy(accessibility = "Unbaptized Members")
    public MobileElement unbaptizedMembersReport;

    //Overdue Aaronic Priesthood Ordinations
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Overdue Aaronic Priesthood Ordinations'][@resource-id='org.lds.ldstools:id/reportTextView']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Overdue Aaronic Priesthood Ordinations'][contains(@resource-id, 'reportTextView')]")
    @iOSXCUITFindBy(xpath = "//*[@name='Overdue Aaronic Priesthood Ordinations'][2]")
    public MobileElement overdueAaronicPriesthoodOrdinationsReport;

    //Young Single Adult Interviews
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Single Adult Interviews']")
    @iOSXCUITFindBy(accessibility = "Young Single Adult Interviews")
    public MobileElement youngSingleAdultInterviewsReport;

    //Bishop's Youth Interviews
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishop’s Youth Interviews']")
    @iOSXCUITFindBy(accessibility = "Bishop’s Youth Interviews")
    public MobileElement bishopsYouthInterviewsReport;

    //Bishopric Counselor Youth Interviews
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishopric Counselor Youth Interviews']")
    @iOSXCUITFindBy(accessibility = "Bishopric Counselor Youth Interviews")
    public MobileElement bishopricCounselorYouthInterviewsReport;

    //Young Men Approaching Mission Age
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Men Approaching Mission Age']")
    @iOSXCUITFindBy(accessibility = "Young Men Approaching Mission Age")
    public MobileElement youngMenApproachingMissionAgeReport;

    //Men Who Have Not Served a Mission
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Men Who Have Not Served a Mission']")
    @iOSXCUITFindBy(accessibility = "Men Who Have Not Served a Mission")
    public MobileElement menWhoHaveNotServedaMissionReport;

    //Potential Missionary Couples
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Potential Missionary Couples']")
    @iOSXCUITFindBy(accessibility = "Potential Missionary Couples")
    public MobileElement potentialMissionaryCouplesReport;




    //*************************************************************************************
    //********************* Missionary Progress Record ************************************
    //*************************************************************************************

    //Missionary Progress Filter
    @AndroidFindBy(accessibility = "Filters")
    @iOSXCUITFindBy(accessibility = "Filter")
    public  MobileElement missionaryProgressFilter;

    //Missionary Progress Investigators with Baptism Date
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterInvestigatorsWithBaptismDateSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label='Investigators with Baptism Date']")
    public  MobileElement mpInvestigatorsWithBaptismDate;

    //Missionary Progress Progressing Investigators
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterProgressingInvestigatorsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Progressing Investigators\"]")
    public  MobileElement mpProgressingInvestigators;

    //Missionary Progress New Investigators
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterNewInvestigatorsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"New Investigators\"]")
    public  MobileElement mpNewInvestigators;

    //Missionary Progress Other Investigators
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterOtherInvestigatorsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Other Investigators\"]")
    public  MobileElement mpOtherInvestigators;

    //Missionary Progress Potential Investigators
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterPotentialInvestigatorsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Potential Investigators\"]")
    public  MobileElement mpPotentialInvestigators;

    //Missionary Progress Recent Converts
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterRecentConvertsSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Recent Converts\"]")
    public  MobileElement mpRecentConverts;


    //Missionary Progress Members Being Taught
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterMembersBeingTaughtSwitchCompat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@label=\"Members Being Taught\"]")
    public  MobileElement mpMembersBeingTaught;

    //Missionary Progress Save
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/menu_item_save")
    public  MobileElement mpSave;

    //Missionary Progress Expand Filter
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterHeaderArrow")
    public  MobileElement mpExpandFilter;


    //Missionary Progress Remove Filter Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/removeFiltersButton")
    @iOSXCUITFindBy(accessibility = "Remove")
    public  MobileElement mpRemoveFilterButton;

    //Missionary Progress Received a Visit
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterReceivedAVisitTextView")
    @iOSXCUITFindBy(accessibility = "Received a Visit")
    public  MobileElement mpReceivedAVisit;

    //Missionary Progress Attended Sacrament
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterSacramentAttendanceTextView")
    @iOSXCUITFindBy(accessibility = "Attended Sacrament")
    public  MobileElement mpAttendedSacrament;

    //Missionary Progress Assigned
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mpFilterFellowshippersTextView")
    @iOSXCUITFindBy(accessibility = "Assigned")
    public  MobileElement mpAssigned;

    //Missionary Progress Last Week
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last Week\"]")
    @iOSXCUITFindBy(accessibility = "Last Week")
    public  MobileElement mpLastWeek;

    //Missionary Progress Last 2 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 2 Weeks\"]")
    @iOSXCUITFindBy(accessibility = "Last 2 Weeks")
    public  MobileElement mpLast2Weeks;

    //Missionary Progress Last 3 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 3 Weeks\"]")
    @iOSXCUITFindBy(accessibility = "Last 3 Weeks")
    public  MobileElement mpLast3Weeks;

    //Missionary Progress Last 4 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 4 Weeks\"]")
    @iOSXCUITFindBy(accessibility = "Last 4 Weeks")
    public  MobileElement mpLast4Weeks;

    //Missionary Progress Last 5 Weeks
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last 5 Weeks\"]")
    @iOSXCUITFindBy(accessibility = "Last 5 Weeks")
    public  MobileElement mpLast5Weeks;

    //Missionary Progress All
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"All\"]")
    @iOSXCUITFindBy(accessibility = "All")
    public  MobileElement mpAll;

    //Missionary Progress Cancel
    @AndroidFindBy(xpath = "//*[@text=\"Cancel\"]")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement mpCancel;


    //*************************************************************************************
    //******************************** Progress Record ************************************
    //*************************************************************************************

    //New Members
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NEW MEMBERS']")
    @iOSXCUITFindBy(accessibility = "New Members")
    public  MobileElement prNewMembers;

    //People being taught
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PEOPLE BEING TAUGHT']")
    @iOSXCUITFindBy(accessibility = "People Being Taught")
    public  MobileElement prPeopleBeingTaught;

    //Search Field
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterEditText")
    @iOSXCUITFindBy(accessibility = "Search")
    public  MobileElement prSearchField;


    //Cancel Search
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/clearTextImageButton")
    @iOSXCUITFindBy(accessibility = "Clear text")
    public MobileElement prClearSearch;




    // ************ Sacrament Attendance Page

    //Sacrament Attendance First Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week1EditText")
    public  MobileElement sacramentAttendanceFirstWeek;


    //Sacrament Attendance Second Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week2EditText")
    public  MobileElement sacramentAttendanceSecondWeek;


    //Sacrament Attendance Third Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week3EditText")
    public  MobileElement sacramentAttendanceThirdWeek;


    //Sacrament Attendance Fourth Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week4EditText")
    public  MobileElement sacramentAttendanceFourthWeek;

    //Sacrament Attendance Fifth Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week5EditText")
    public  MobileElement sacramentAttendanceFifthWeek;

    //Sacrament Attendance Dialog Edit Field
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/editText")
    public  MobileElement sacramentAttendanceDialogEditField;

    //Sacrament Attendance Cancel
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/button2")
    public  MobileElement sacramentAttendanceDialogCancel;

    //Sacrament Attendance Ok
    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    public  MobileElement sacramentAttendanceDialogOk;

    //Sacrament Attendance Counter Icon
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/text_input_end_icon")
    @iOSXCUITFindBy(accessibility = "sacramentCounterIcon")
    public  MobileElement sacramentAttendanceCounterIcon;



    //Sacrament Attendance Add Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/counterTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeButton[1]")
    public  MobileElement sacramentAttendanceAddButton;


    //Sacrament Attendance Minus Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/decrementFab")
//    @iOSXCUITFindBy(accessibility = "minus.circle")
    @iOSXCUITFindBy(accessibility = "remove")
    public  MobileElement sacramentAttendanceMinusButton;


    //Sacrament Attendance Next Section
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/sectionButton")
    public  MobileElement sacramentAttendanceCounterNextSection;

    //Sacrament Attendance Counter Save Button
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/saveButton")
    @iOSXCUITFindBy(accessibility = "Save")
    public  MobileElement sacramentAttendanceCounterSave;


    //************* Class and Quorum Attendance ******************

    //Class and Quorum - Search
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterEditText")
    @iOSXCUITFindBy(accessibility = "Search")
    public  MobileElement classAndQuorumSearch;

    //Class and Quorum - Clear Search
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/clearTextImageButton")
    @iOSXCUITFindBy(accessibility = "Clear text")
    public  MobileElement classAndQuorumClearSearch;


    //Class and Quorum First Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week1")
    public  MobileElement classAndQuorumFirstWeek;


    //Class and Quorum Second Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week2")
    public  MobileElement classAndQuorumSecondWeek;


    //Class and Quorum Third Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week3")
    public  MobileElement classAndQuorumThirdWeek;

    //Class and Quorum Fourth Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week4")
    public  MobileElement classAndQuorumFourthWeek;

    //Class and Quorum Fifth Week
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/week5")
    public  MobileElement classAndQuorumFifthWeek;

    //Class and Quorum - Filters
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/iconImageView")
    @iOSXCUITFindBy(accessibility = "Filter")
    public  MobileElement classAndQuorumFilter;

    //Class and Quorum - Filters - All
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Classes and Quorums']")
    @iOSXCUITFindBy(accessibility = "All")
    public  MobileElement classAndQuorumFilterAll;

    //Class and Quorum - Filters - All Aaronic
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Aaronic Priesthood Quorums']")
    @iOSXCUITFindBy(accessibility = "Aaronic Priesthood Quorums")
    public  MobileElement classAndQuorumFilterAaronic;

    //Class and Quorum - Filters - All Classes
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Classes']")
    @iOSXCUITFindBy(accessibility = "All")
    public  MobileElement classAndQuorumFilterAaronicAllClasses;

    //Class and Quorum - Filters - Deacons Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Deacons Quorum']")
    @iOSXCUITFindBy(accessibility = "Deacons Quorum")
    public  MobileElement classAndQuorumFilterDeaconsQuorum;

    //Class and Quorum - Filters - Teachers Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Teachers Quorum']")
    @iOSXCUITFindBy(accessibility = "Teachers Quorum")
    public  MobileElement classAndQuorumFilterTeachersQuorum;

    //Class and Quorum - Filters - Priests Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Priests Quorum']")
    @iOSXCUITFindBy(accessibility = "Priests Quorum")
    public  MobileElement classAndQuorumFilterPriestsQuorum;

    //Class and Quorum - Filters - Elders Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Elders Quorum']")
    @iOSXCUITFindBy(accessibility = "Elders Quorum")
    public  MobileElement classAndQuorumFilterEldersQuorum;

    //Class and Quorum - Filters - Primary
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary']")
    @iOSXCUITFindBy(accessibility = "Primary")
    public  MobileElement classAndQuorumFilterPrimary;


    //Class and Quorum Visitors
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='VISITORS']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Add Visitors'")
    public MobileElement classAndQuorumVisitors;

    //Class and Quorum Visitors Done - Save
    @AndroidFindBy(xpath = "//*[@text='SAVE']")
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement classAndQuorumVisitorsDone;

    //Class and Quorum Visitors Cancel
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'toolbar')]/android.widget.ImageButton")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement classAndQuorumVisitorsCancel;

    //*************************************************************************************
    //************************************* Ordinances ************************************
    //*************************************************************************************


    //Ordinances- Add
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/fab")
    @iOSXCUITFindBy(accessibility = "Add")
    public  MobileElement ordinancesAdd;

    //Ordinances-Filter
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/iconImageView")
    @iOSXCUITFindBy(accessibility = "Filter")
    public  MobileElement ordinancesFilter;


    //Record Aaronic Priesthood Ordination
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Record Aaronic Priesthood Ordination")
    public  MobileElement ordinancesAaronicPriesthood;

    //Submit Melchizedek Priesthood Ordination
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Submit Melchizedek Priesthood Ordination")
    public  MobileElement ordinancesMelchizedekPriesthood;

    //Ordination Search for Member
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Search")
    public  MobileElement ordinancesSearch;

    //Ordination Select Priesthood Office
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Priesthood Office")
    public  MobileElement ordinancesPriesthoodOffice;

    //Ordination Deacon
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Deacon")
    public  MobileElement ordinancesDeacon;

    //Ordination Teacher
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Teacher")
    public  MobileElement ordinancesTeacher;

    //Ordination Priest
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Priest")
    public  MobileElement ordinancesPriest;

    //Ordination Elder
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Elder")
    public  MobileElement ordinancesElder;

    //Ordination High Priest
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "High Priest")
    public  MobileElement ordinancesHighPriest;

    //Ordination Date Picker
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Date Picker")
    public  MobileElement ordinancesDatePicker;

    //Ordination Officiator
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Officiator")
    public  MobileElement ordinancesOfficiator;

    //Ordination Member of Ward or Branch
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Member of Ward or Branch")
    public  MobileElement ordinancesMemberOfWardOrBranch;

    //Ordination Member Outside of Ward or Branch
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Member Outside of Ward or Branch")
    public  MobileElement ordinancesMemberOutsideOfWardOrBranch;

    //Ordination Switch Bishop has interviewed...
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSwitch'")
    public  MobileElement ordinancesMemberBishopInterviewSwitch;

    //Ordination Record Button
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Record")
    public  MobileElement ordinancesRecord;

    //Ordination Submit Button
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Record")
    public  MobileElement ordinancesSubmit;

    //Ordination Cancel Button
    @AndroidFindBy(id = "update")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public  MobileElement ordinancesCancel;


    // **************************************** Move In and Out ****************************************
    //Main Move in and out page
    //In Tab
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Move record in'][1]")
    @iOSXCUITFindBy(accessibility = "In")
    public  MobileElement moveRecordsInTab;

    //Out Tab
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Move record out'][1]")
    @iOSXCUITFindBy(accessibility = "Out")
    public  MobileElement moveRecordsOutTab;

    //In Button
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Move record in']/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Inbox' AND type == 'XCUIElementTypeButton'")
    public  MobileElement moveRecordsInButton;

    //Out Button
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Move record out'][2]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Outbox' AND type == 'XCUIElementTypeButton'")
    public  MobileElement moveRecordsOutButton;

    //Cancel Button
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextView'")
    public  MobileElement moveRecordsCancelButton;

    //MRN
    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextView'")
    public  MobileElement moveRecordsMRNField;

    //More Options Switch
    @AndroidFindBy(xpath = "//android.widget.Switch")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='More Search Options']/XCUIElementTypeSwitch[@name='More Search Options']")
    public  MobileElement moveRecordsMoreSearchOptions;

    //Name
    @AndroidFindBy(xpath = "//android.view.View[@text='Name']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='Name']//XCUIElementTypeTextView")
    public  MobileElement moveRecordsName;

    //Birth Date
    @AndroidFindBy(xpath = "//android.view.View[@text='Birth Date']")
    @iOSXCUITFindBy(accessibility = "Date Picker")
    public  MobileElement moveRecordsBirthDate;

        //Birth Date Edit Button
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/mtrl_picker_header_toggle")
        public  MobileElement moveRecordsBirthDateEditButton;

        //Birth Date Edit Field
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/textinput_placeholder")
        public  MobileElement moveRecordsBirthDateEditField;

        //Birth Date Cancel
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/cancel_button")
        public  MobileElement moveRecordsBirthDateCancelButton;

        //Birth Date OK
        @AndroidFindBy(id = "org.lds.ldstools.alpha:id/confirm_button")
        public  MobileElement moveRecordsBirthDateOkButton;

    //Gender
    @AndroidFindBy(xpath = "//android.view.View[@text='Gender']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Optional']")
    public  MobileElement moveRecordsGender;

    //Country
    @AndroidFindBy(xpath = "//android.view.View[@text='Country']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Country, Optional' AND type == 'XCUIElementTypeButton'")
    public  MobileElement moveRecordsCountry;

    //Country address to move to
    @AndroidFindBy(xpath = "//android.view.View[@text='Country']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Country, Select' AND type == 'XCUIElementTypeButton'")
    public  MobileElement moveRecordsCountry2;


    //Next
    @AndroidFindBy(xpath = "//android.view.View[@text='NEXT']")
    @iOSXCUITFindBy(accessibility = "Next")
    public  MobileElement moveRecordsNext;

    //Address Selector
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Dropdown menu']/android.widget.EditText")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Address, Address Known'")
    public  MobileElement moveRecordsAddressSelector;

        //Address Known
        @AndroidFindBy(xpath = "//android.view.View[@text='Address Known']")
        @iOSXCUITFindBy(accessibility = "Address Known")
        public  MobileElement moveRecordsAddressKnown;

        //Address Unchanging
        @AndroidFindBy(xpath = "//android.view.View[@text='Address Unchanging']")
        @iOSXCUITFindBy(accessibility = "Address Unchanging")
        public  MobileElement moveRecordsAddressUnchanging;

        //Joining a Household
        @AndroidFindBy(xpath = "//android.view.View[@text='Joining a Household']")
        @iOSXCUITFindBy(accessibility = "Joining a Household")
        public  MobileElement moveRecordsJoiningAHousehold;

    //Locate On Map
    @AndroidFindBy(xpath = "//android.view.View[@text='LOCATE ON MAP']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Locate on Map' AND type == 'XCUIElementTypeButton'")
    public  MobileElement moveRecordsLocateOnMap;

    //Address 1
    @AndroidFindBy(xpath = "//android.view.View[@text='Address 1']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='Address 1']//XCUIElementTypeTextView")
    public  MobileElement moveRecordsAddress1;

    //Address 2
    @AndroidFindBy(xpath = "//android.view.View[@text='Address 2']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='Address 2']//XCUIElementTypeTextView")
    public  MobileElement moveRecordsAddress2;

    //City
    @AndroidFindBy(xpath = "//android.view.View[@text='City']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='City']//XCUIElementTypeTextView")
    public  MobileElement moveRecordsCity;

    //State or Province
    @AndroidFindBy(xpath = "//android.view.View[@text='State or Province']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='State or Province, Select']/XCUIElementTypeButton")
    public  MobileElement moveRecordsStateOrProvince;

    //Postal Code
    @AndroidFindBy(xpath = "//android.view.View[@text='Postal Code']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='Postal Code']//XCUIElementTypeTextView")
    public  MobileElement moveRecordsPostalCode;


    //Move Records In
    @AndroidFindBy(xpath = "//android.view.View[@text='MOVE RECORDS IN']")
    @iOSXCUITFindBy(accessibility = "Move In")
    public  MobileElement moveRecordsMoveRecordsIn;

    //Discard Move
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Discard Move']")
    @iOSXCUITFindBy(accessibility = "Trash")
    public  MobileElement moveRecordsDiscardMove;

    //Discard Button
    @AndroidFindBy(xpath = "//android.view.View[@text='DISCARD']")
    @iOSXCUITFindBy(accessibility = "OK")
    public  MobileElement moveRecordsDiscardButton;






    public void saveMissonaryProgressFilter() throws Exception {
        if (getOS().equals("ios")) {
            backButton.click();
        } else {
            mpSave.click();
            mpExpandFilter.click();
        }

    }


    public void selectSort(MobileElement myElement) throws Exception {
        if (getOS().equals("ios")) {
            sortReport.click();
            myElement.click();
        } else {
            myElement.click();
        }

    }

    public void selectFilters(MobileElement myElement) throws Exception {
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
    //public  MobileElement calendar;


}
