package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class OrganizationsScreen extends BasePage {

    public OrganizationsScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Organizations Main Screen ******************


    //Organizations Dropdown
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Organizations']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Organizations']")
    public WebElement organizationsDropdown;

    //Savaii Samoa Fagamalo Stake
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Savaii Samoa Fagamalo Stake']")
    @iOSXCUITFindBy(accessibility = "Savaii Samoa Fagamalo Stake")
    public WebElement savaiiStake;

    //Inglewood California Stake
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Inglewood California Stake']")
    @iOSXCUITFindBy(accessibility = "Inglewood California Stake")
    public WebElement inglewoodStake;

    //Fagamalo 1st Ward
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Fagamalo 1st Ward']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Fagamalo 1st Ward')]")
//    @iOSXCUITFindBy(accessibility = "//XCUIElementTypeStaticText[@name=\" Fagamalo 1st Ward\"]")
    public WebElement fagamalo1stWard;

    //  ****************** Organizations Stake ******************
    //Stake Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Presidency']")
    @iOSXCUITFindBy(accessibility = "Stake Presidency")
    public WebElement stakePresidencyOrg;

    //High Priests Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Priests Quorum']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"High Priests Quorum\"]")
    public WebElement highPriestsQuorumOrg;

    //High Priests Quorum Members
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Priests Quorum Members']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"All High Priests Quorum Members\"]")
    public WebElement highPriestsQuorumMembersOrg;


    //High Council
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Council']")
    @iOSXCUITFindBy(accessibility = "High Council")
    public WebElement highCouncilOrg;

    //Patriarch
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Patriarch']")
    @iOSXCUITFindBy(accessibility = "Patriarch")
    public WebElement patriarchOrg;

    //Stake Relief Society
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Relief Society']")
    @iOSXCUITFindBy(accessibility = "Stake Relief Society")
    public WebElement stakeReliefSocietyOrg;

    //Stake Young Men
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Young Men']")
    @iOSXCUITFindBy(accessibility = "Stake Young Men")
    public WebElement stakeYoungMenOrg;

    //Stake Young Women
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Young Women']")
    @iOSXCUITFindBy(accessibility = "Stake Young Women")
    public WebElement stakeYoungWomenOrg;

    //Stake Sunday School
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Sunday School']")
    @iOSXCUITFindBy(accessibility = "Stake Sunday School")
    public WebElement stakeSundaySchoolOrg;

    //Stake Primary
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Primary']")
    @iOSXCUITFindBy(accessibility = "Stake Primary")
    public WebElement stakePrimaryOrg;

    //Stake Family History
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stake Family History']")
    @iOSXCUITFindBy(accessibility = "Stake Family History")
    public WebElement stakeFamilyHistoryOrg;


    //  ****************** Organizations Ward ******************
    //Bishopric
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bishopric']")
    @iOSXCUITFindBy(accessibility = "Bishopric")
    public WebElement bishopricOrg;

    //High Priests Group
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Priests Group']")
    @iOSXCUITFindBy(accessibility = "High Priests Group")
    public WebElement highPriestsOrg;

    //Elders Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Elders Quorum']")
    @iOSXCUITFindBy(accessibility = "Elders Quorum")
    public WebElement eldersQuorumOrg;

    //Relief Society
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Relief Society']")
    @iOSXCUITFindBy(accessibility = "Relief Society")
    public WebElement reliefSocietyOrg;

    //Young Men
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Aaronic Priesthood Quorums']")
    @iOSXCUITFindBy(accessibility = "Aaronic Priesthood Quorums")
    public WebElement youngMenOrg;

    //Young Women
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Women']")
    @iOSXCUITFindBy(accessibility = "Young Women")
    public WebElement youngWomenOrg;

    //Sunday School
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sunday School']")
    @iOSXCUITFindBy(accessibility = "Sunday School")
    public WebElement sundaySchoolOrg;

    //Primary
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary']")
    @iOSXCUITFindBy(accessibility = "Primary")
    public WebElement primaryOrg;

    //Ward Missionaries
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ward Missionaries']")
    @iOSXCUITFindBy(accessibility = "Ward Missionaries")
    public WebElement wardMissionariesOrg;

    //Other Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Other Callings']")
    @iOSXCUITFindBy(accessibility = "Other Callings")
    public WebElement otherCallingsOrg;



    // ****************** High Priests ******************
    //High Priests Group Leadership
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='High Priests Group Leadership']")
    @iOSXCUITFindBy(accessibility = "High Priests Group Leadership")
    public WebElement highPriestsLeadership;

    //High Priests Home Teaching District Supervisors
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home Teaching District Supervisors']")
    @iOSXCUITFindBy(accessibility = "Home Teaching District Supervisors")
    public WebElement highPriestsHTDistrictSuper;

    //High Priests All Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All High Priests Group Members")
    public WebElement highPriestsAllMembers;

    // ****************** Elders Quorum ******************
    //Elders Quorum Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Elders Quorum Presidency']")
    @iOSXCUITFindBy(accessibility = "Elders Quorum Presidency")
    public WebElement eldersQuorumPresidency;

    //Elders Quorum Home Teaching District Supervisors
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home Teaching District Supervisors']")
    @iOSXCUITFindBy(accessibility = "Home Teaching District Supervisors")
    public WebElement eldersHTDistrictSuper;

    //Elders Quorum All Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Elders Quorum Members")
    public WebElement eldersAllMembers;

    // ****************** Relief Society ******************
    //Relief Society Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Relief Society Presidency']")
    @iOSXCUITFindBy(accessibility = "Relief Society Presidency")
    public WebElement reliefSocietyPresidency;

    //Relief Society Ministering
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ministering']")
    @iOSXCUITFindBy(accessibility = "Ministering")
    public WebElement reliefSocietyVisitingTeaching;

    //Relief Society Music
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Music']")
    @iOSXCUITFindBy(accessibility = "Music")
    public WebElement reliefSocietyMusic;

    //Relief Society All Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Relief Society Members")
    public WebElement reliefSocietyAllMembers;

    // ****************** Young Men ******************
    //Young Men Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Men Presidency']")
    @iOSXCUITFindBy(accessibility = "Young Men Presidency")
    public WebElement youngMenPresidency;

    //Priests Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Priests Quorum']")
    @iOSXCUITFindBy(accessibility = "Priests Quorum")
    public WebElement priestsQuorum;

    //Priests Quorum Presidency
//    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'Presidency')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Priests Quorum Presidency']")
    @iOSXCUITFindBy(accessibility = "Priests Quorum Presidency")
    public WebElement priestsQuorumPresidency;

    //Priests Quorum Adult Leaders
//    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"Priests Quorum Adult Leaders\")]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Priests Quorum Adult Leaders']")
    @iOSXCUITFindBy(accessibility = "Priests Quorum Adult Leaders")
    public WebElement priestsQuorumAdultLeaders;

    //All Priests Quorum Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Priests Quorum Members")
    public WebElement priestsQuorumMembersAll;

    //Teachers Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Teachers Quorum']")
    @iOSXCUITFindBy(accessibility = "Teachers Quorum")
    public WebElement teachersQuorum;

    //Teachers Quorum Presidency
//    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"Teachers Quorum Presidency\")]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Teachers Quorum Presidency']")
    @iOSXCUITFindBy(accessibility = "Teachers Quorum Presidency")
    public WebElement teachersQuorumPresidency;

    //Teachers Quorum Adult Leaders
//    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"Teachers Quorum Adult Leaders\")]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Teachers Quorum Adult Leaders']")
    @iOSXCUITFindBy(accessibility = "Teachers Quorum Adult Leaders")
    public WebElement teachersQuorumAdultLeaders;

    //All Priests Quorum Members
//    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Teachers Quorum Members']")
    @iOSXCUITFindBy(accessibility = "All Teachers Quorum Members")
    public WebElement teachersQuorumMembersAll;

    //Deacons Quorum
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Deacons Quorum']")
    @iOSXCUITFindBy(accessibility = "Deacons Quorum")
    public WebElement deaconsQuorum;

    //Deacons Quorum Presidency
//    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Deacons Quorum Presidency']")
    @iOSXCUITFindBy(accessibility = "Deacons Quorum Presidency")
    public WebElement deaconsQuorumPresidency;

    //Deacons Quorum Adult Leaders
//    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"Deacons Quorum Adult Leaders\")]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Deacons Quorum Adult Leaders']")
    @iOSXCUITFindBy(accessibility = "Deacons Quorum Adult Leaders")
    public WebElement deaconsQuorumAdultLeaders;

    //All Deacons Quorum Members
//    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Deacons Quorum Members']")
    @iOSXCUITFindBy(accessibility = "All Deacons Quorum Members")
    public WebElement deaconsQuorumMembersAll;

    //All Young Men Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Young Men Members")
    public WebElement youngMenMembersAll;


    // ****************** Young Women ******************
    //Young Women Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Women Presidency']")
    @iOSXCUITFindBy(accessibility = "Young Women Presidency")
    public WebElement youngWomenPresidency;

    //Young Women 12-18
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Women 12-18']")
    @iOSXCUITFindBy(accessibility = "Young Women 12-18")
    public WebElement youngWomen12to18;

    //Young Women Class Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Young Women Class Presidency']")
    @iOSXCUITFindBy(accessibility = "Young Women Class Presidency")
    public WebElement youngWomenClassPresidency;

    //Laurel
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Laurel']")
    @iOSXCUITFindBy(accessibility = "Laurel")
    public WebElement laurel;

    //Laurel Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSXCUITFindBy(accessibility = "Laurel Presidency")
    public WebElement laurelPresidency;

    //All Laurel Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Laurel Members")
    public WebElement laurelMembersAll;

    //Mia Maid
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mia Maid']")
    @iOSXCUITFindBy(accessibility = "Mia Maid")
    public WebElement miaMaid;

    //Mia Maid Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSXCUITFindBy(accessibility = "Mia Maid Presidency")
    public WebElement miaMaidPresidency;

    //Mia Maid Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Mia Maid Members")
    public WebElement miaMaidMembersAll;

    //Beehive
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Beehive']")
    @iOSXCUITFindBy(accessibility = "Beehive")
    public WebElement beehive;

    //Beehive Presidency
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"presidency\")]")
    @iOSXCUITFindBy(accessibility = "Beehive Presidency")
    public WebElement beehivePresidency;

    //All Beehive Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Beehive Members")
    public WebElement beehivemMembersAll;

    //All Young Women Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(accessibility = "All Young Women Members")
    public WebElement youngWomenMembersAll;

    // ****************** Sunday School ******************

    //Sunday School Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sunday School Presidency']")
    @iOSXCUITFindBy(accessibility = "Sunday School Presidency")
    public WebElement sundaySchoolPresidency;

    //Gospel Doctrine
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gospel Doctrine']")
    @iOSXCUITFindBy(accessibility = "Gospel Doctrine")
    public WebElement gospelDoctrine;

    //Course 17
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 17']")
    @iOSXCUITFindBy(accessibility = "Course 17")
    public WebElement course17;

    //Course 16
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 16']")
    @iOSXCUITFindBy(accessibility = "Course 16")
    public WebElement course16;

    //Course 15
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 15']")
    @iOSXCUITFindBy(accessibility = "Course 15")
    public WebElement course15;

    //Course 14
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 14']")
    @iOSXCUITFindBy(accessibility = "Course 14")
    public WebElement course14;

    //Course 13
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 13']")
    @iOSXCUITFindBy(accessibility = "Course 13")
    public WebElement course13;

    //Course 12
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Course 12']")
    @iOSXCUITFindBy(accessibility = "Course 12")
    public WebElement course12;


    // ****************** Primary ******************
    //Primary Presidency
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary Presidency']")
    @iOSXCUITFindBy(accessibility = "Primary Presidency")
    public WebElement primaryPresidency;

    //Music
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Music']")
    @iOSXCUITFindBy(accessibility = "Gospel Doctrine")
    public WebElement primaryMusic;

    //Valiant 10
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Valiant 10']")
    @iOSXCUITFindBy(accessibility = "Valiant 10")
    public WebElement valiant10;

    //Valiant 11
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Valiant 11']")
    @iOSXCUITFindBy(accessibility = "Valiant 11")
    public WebElement valiant11;

    //Valiant 9
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Valiant 9']")
    @iOSXCUITFindBy(accessibility = "Valiant 9")
    public WebElement valiant9;

    //Valiant 8
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Valiant 8']")
    @iOSXCUITFindBy(accessibility = "Valiant 8")
    public WebElement valiant8;

    //CTR 7
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CTR 7']")
    @iOSXCUITFindBy(accessibility = "CTR 7")
    public WebElement ctr7;

    //CTR 6
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CTR 6']")
    @iOSXCUITFindBy(accessibility = "CTR 6")
    public WebElement ctr6;

    //CTR 5
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CTR 5']")
    @iOSXCUITFindBy(accessibility = "CTR 5")
    public WebElement ctr5;

    //CTR 4
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CTR 4']")
    @iOSXCUITFindBy(accessibility = "CTR 4")
    public WebElement ctr4;

    //Sunbeam
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sunbeam']")
    @iOSXCUITFindBy(accessibility = "Sunbeam")
    public WebElement sunbeam;

    //Nursery
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nursery']")
    @iOSXCUITFindBy(accessibility = "Nursery")
    public WebElement nursery;

    //Cub Scouts
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cub Scouts']")
    @iOSXCUITFindBy(accessibility = "Cub Scouts")
    public WebElement cubScouts;

    //Eleven-Year-Old Scouts
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Eleven-Year-Old Scouts']")
    @iOSXCUITFindBy(accessibility = "Eleven-Year-Old Scouts")
    public WebElement elevenYearOldScouts;

    //Activity Days
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Activity Days']")
    @iOSXCUITFindBy(accessibility = "Activity Days")
    public WebElement activityDays;



    // ****************** Other ******************
    //Music
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Music']")
    @iOSXCUITFindBy(accessibility = "Music")
    public WebElement otherMusic;



    //General All Members
    @AndroidFindBy(xpath = "//*[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"all members\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Members'")
    public WebElement generalAllMembers;


}
