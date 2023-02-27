package LDSToolsAppiumTest;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;

import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.MissionaryScreen;
import LDSToolsAppium.Screen.OrganizationsScreen;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class OrganizationsScreenTest extends BaseDriver {


    @Test (groups = {"smoke1", "smoke", "all1", "all", "daily", "daily3"})
    public void organizationTest_BISHOP() throws Exception {
        organizationTestCheckSub("BISHOP");
    }

    @Test (groups = {"all2", "all"})
    public void organizationTest_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        organizationTestCheckSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void organizationTest_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        organizationTestCheckSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void organizationTest_WARD_CLERK() throws Exception {
        organizationTestCheckSub("WARD_CLERK");
    }

    @Test(groups = {"all1", "all"})
    public void organizationTest_WARD_ASSISTANT_CLERK() throws Exception {
        organizationTestCheckSub("WARD_ASSISTANT_CLERK");
    }

    @Test(groups = {"all2", "all"})
    public void organizationTest_WARD_EXECUTIVE_SECRETARY() throws Exception {
        organizationTestCheckSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test(groups = {"all3", "all"})
    public void organizationTest_MEMBER1() throws Exception {
        organizationTestCheckSub("MEMBER1");
    }

    @Test(groups = {"all4", "all"})
    public void organizationTest_MEMBER2() throws Exception {
        organizationTestCheckSub("MEMBER2");
    }

    @Test(groups = {"all1", "all", "daily", "daily1", "jft"})
    public void organizationTest_ELDERS_QUORUM_PRESIDENT() throws Exception {
        organizationTestCheckSub("ELDERS_QUORUM_PRESIDENT");
    }

    @Test(groups = {"all2", "all"})
    public void organizationTest_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        organizationTestCheckSub("ELDERS_QUORUM_FIRST_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void organizationTest_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        organizationTestCheckSub("ELDERS_QUORUM_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void organizationTest_ELDERS_QUORUM_SECRETARY() throws Exception {
        organizationTestCheckSub("ELDERS_QUORUM_SECRETARY");
    }

    @Test(groups = {"all1", "all", "daily", "daily2"})
    public void organizationTest_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        organizationTestCheckSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test(groups = {"all2", "all"})
    public void organizationTest_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        organizationTestCheckSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void organizationTest_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        organizationTestCheckSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all", "daily", "daily4"})
    public void organizationTest_YOUNG_WOMEN_PRESIDENT() throws Exception {
        organizationTestCheckSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test(groups = {"all1", "all"})
    public void organizationTest_WOMEN_SECOND_COUNSELOR() throws Exception {
        organizationTestCheckSub("WOMEN_SECOND_COUNSELOR");
    }

    @Test(groups = {"all2", "all"})
    public void organizationTest_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
        organizationTestCheckSub("SUNDAY_SCHOOL_FIRST_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void organizationTest_WARD_MISSION_LEADER() throws Exception {
        organizationTestCheckSub("WARD_MISSION_LEADER");
    }

    public void organizationTestCheckSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        organizationTestCheckNewRights(Integer.parseInt(callingRights[2]), callingRights[1]);
    }

    public void organizationTestCheckNewRights(int rights, String userName) throws Exception {
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        

        myMenu.selectMenu(myMenu.organizations);
        
        getBishopricInfo(rights);

        getEldersQuorum(rights, userName);

        getReliefSociety(rights, userName);

        getYoungMenInfo(rights, userName);

        getYoungWomenInfo(rights, userName);

        getSundaySchoolInfo(rights, userName);

        getPrimaryInfo(rights, userName);

    }



    @Test (groups = {"all2", "all", "daily", "daily4"})
    public void organizationStakeHighPriestQuorum_BISHOP() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("BISHOP");
    }

    @Test (groups = {"all1", "all"})
    public void organizationStakeHighPriestQuorum_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void organizationStakeHighPriestQuorum_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void organizationStakeHighPriestQuorum_WARD_CLERK() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("WARD_CLERK");
    }

    @Test(groups = {"all2", "all"})
    public void organizationStakeHighPriestQuorum_WARD_ASSISTANT_CLERK() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("WARD_ASSISTANT_CLERK");
    }

    @Test(groups = {"all1", "all"})
    public void organizationStakeHighPriestQuorum_WARD_EXECUTIVE_SECRETARY() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test(groups = {"all4", "all"})
    public void organizationStakeHighPriestQuorum_MEMBER1() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("MEMBER1");
    }

    @Test(groups = {"all3", "all"})
    public void organizationStakeHighPriestQuorum_MEMBER2() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("MEMBER2");
    }

    @Test(groups = {"all2", "all", "daily", "daily1"})
    public void organizationStakeHighPriestQuorum_ELDERS_QUORUM_PRESIDENT() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("ELDERS_QUORUM_PRESIDENT");
    }

    @Test(groups = {"all1", "all"})
    public void organizationStakeHighPriestQuorum_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("ELDERS_QUORUM_FIRST_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void organizationStakeHighPriestQuorum_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("ELDERS_QUORUM_SECOND_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void organizationStakeHighPriestQuorum_ELDERS_QUORUM_SECRETARY() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("ELDERS_QUORUM_SECRETARY");
    }

    @Test(groups = {"all2", "all", "daily", "daily2"})
    public void organizationStakeHighPriestQuorum_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test(groups = {"all1", "all"})
    public void organizationStakeHighPriestQuorum_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void organizationStakeHighPriestQuorum_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test(groups = {"all3", "all", "daily", "daily3"})
    public void organizationStakeHighPriestQuorum_YOUNG_WOMEN_PRESIDENT() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test(groups = {"all2", "all"})
    public void organizationStakeHighPriestQuorum_WOMEN_SECOND_COUNSELOR() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("WOMEN_SECOND_COUNSELOR");
    }

//    @Test(groups = {"all1", "all"})
//    public void organizationStakeHighPriestQuorum_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
//        organizationStakeHighPriestQuorumCheckSub("SUNDAY_SCHOOL_FIRST_COUNSELOR");
//    }

    @Test(groups = {"all4", "all"})
    public void organizationStakeHighPriestQuorum_WARD_MISSION_LEADER() throws Exception {
        organizationStakeHighPriestQuorumCheckSub("WARD_MISSION_LEADER");
    }

    public void organizationStakeHighPriestQuorumCheckSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        organizationStakeHighPriestQuorumNewRights(Integer.parseInt(callingRights[2]), callingRights[1]);
    }


    //Todo: API test needed.
    public void organizationStakeHighPriestQuorumNewRights(int rights, String userName) throws Exception {
        // ********* Constructor **********
        MenuScreen myMenu = new MenuScreen(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myMenu.selectMenu(myMenu.organizations);
        myBasePage.waitForElementThenClick(myOrg.organizationsDropdown);
        Thread.sleep(500);
        myBasePage.waitForElementThenClick(myOrg.inglewoodStake);
        Thread.sleep(500);
        myBasePage.waitForElementThenClick(myOrg.highPriestsQuorumOrg);
        Thread.sleep(2000);

        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Arce", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Martin", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Anthony", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Davis", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Brandon", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Callahan", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Scott", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Carlson", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lloyd", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Cox", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tom", pageSource, "Contains"));


        myBasePage.navigateUp.click();
    }
    
    

//    @Test(dataProvider = "Members", groups = {"all2", "all"})
    public void organizationStakeHighPriestQuorum(String userName, String passWord, String rightsString, String calling) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        BasePage myBasePage = new BasePage(driver);


        //Login and enter in PIN
        myHelper.proxyLogin(userName);
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.organizations);
        Thread.sleep(2000);
        myOrg.organizationsDropdown.click();
        myOrg.inglewoodStake.click();
        myOrg.highPriestsQuorumOrg.click();
//        if (getRunningOS().equals("ios")) {
//            myOrg.highPriestsQuorumMembersOrg.click();
//        }
        Thread.sleep(2000);

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Arce", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Martin", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Anthony", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Dozier", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Paul", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ronald", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Callahan", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Scott", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Carlson", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lloyd", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Cox", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Tom", pageSource, "Contains"));


        myBasePage.backButton.click();

//        if (getRunningOS().equals("ios")) {
//            myBasePage.backButton.click();
//        }


    }

    private void getBishopricInfo(int rights) throws Exception {
//        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);


        //Data from Web page
        List<String> myList;

        //Data from android list
        ArrayList<String> androidList = new ArrayList<>();

        myBasePage.waitForElementThenClick(myOrg.bishopricOrg);
//        myOrg.bishopricOrg.click();


        //TODO: Get JSON then check to see what tools shows
        bishopricData();


//        if (rights <= 3) {
//            //Go to web and get all users
//            myList = myWeb.getAllMembersOnPage("OrganizationsMenu", "Bishopric", false);
//          myBasePage.compareWebData(myList, androidList, true);
//        } else {
//            Thread.sleep(2000);
//            bishopricData();
//        }

//        System.out.println(myBasePage.getSourceOfPage());
        myBasePage.backAltButton.click();
        Thread.sleep(1000);
    }

    private void bishopricData() throws Exception {
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Thomas", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mark", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Bishopric First Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Iuta", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Brando", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Bishopric Second Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Loeb", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Andrew", pageSource, "Contains"));

//        Assert.assertTrue(myBasePage.checkNoCaseList("Ward Executive Secretary", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Salas", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Ian", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Ward Clerk", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Stephenson", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Robert", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Ward Assistant Clerk", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ryan", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ken", pageSource, "Contains"));

    }


//    private void getHighPriestsGroupInfo(int rights) throws Exception {
//        String pageSource;
//        BasePage myBasePage = new BasePage(driver);
//        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
//
//
//
//        //Data from Web page
//        List<String> myList = new ArrayList<String>();
//
//        //Data from android list
//        List<String> androidList = new ArrayList<String>();
//
//
//        myOrg.highPriestsOrg.click();
//
//
//        if (rights <= 3) {
//            myOrg.highPriestsLeadership.click();
//            Thread.sleep(1000);
//            //Check web data vs LDS Tools
//            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "High Priests Group", "HighPriestGroupLeadership", false);
//            myBasePage.compareWebData(myList, androidList, true);
//
//            myBasePage.backAltButton.click();
//            myOrg.highPriestsHTDistrictSuper.click();
//
//            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "High Priests Group", "HighPriestGroupDistrictSupervisors", false);
//            myBasePage.compareWebData(myList, androidList, true);
//
//            myBasePage.backAltButton.click();
//            myOrg.highPriestsAllMembers.click();
//
//
//            myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "High Priests Group", "HighPriestGroupMembers", false);
//            myBasePage.compareWebData(myList, androidList, true);
//
//        } else {
//            myOrg.highPriestsLeadership.click();
//
//            Thread.sleep(2000);
//            pageSource = myBasePage.getSourceOfPage();
//            Assert.assertTrue(myBasePage.checkNoCaseList("Group Leader", pageSource, "Contains"));
//            Assert.assertTrue(myBasePage.checkNoCaseList("Faamoe", pageSource, "Contains"));
//            Assert.assertTrue(myBasePage.checkNoCaseList("Panapa", pageSource, "Contains"));
//
//            Assert.assertTrue(myBasePage.checkNoCaseList("First Assistant", pageSource, "Contains"));
//            Assert.assertTrue(myBasePage.checkNoCaseList("Tools", pageSource, "Contains"));
//            Assert.assertTrue(myBasePage.checkNoCaseList("LDS17", pageSource, "Contains"));
//
//            Assert.assertTrue(myBasePage.checkNoCaseList("Second Assistant", pageSource, "Contains"));
//            Assert.assertTrue(myBasePage.checkNoCaseList("LDS19", pageSource, "Contains"));
//            Assert.assertTrue(myBasePage.checkNoCaseList("LDS18", pageSource, "Contains"));
//
//            myBasePage.backAltButton.click();
//            myOrg.highPriestsHTDistrictSuper.click();
//            Thread.sleep(2000);
//
//            pageSource = myBasePage.getSourceOfPage();
//            Assert.assertTrue(myBasePage.checkNoCaseList("Home Teaching District Supervisor", pageSource, "Contains"));
//            Assert.assertTrue(myBasePage.checkNoCaseList("Tools", pageSource, "Contains"));
//            Assert.assertTrue(myBasePage.checkNoCaseList("LDS50", pageSource, "Contains"));
//            myBasePage.backAltButton.click();
//            Thread.sleep(1000);
//        }
//
//
//        if(getRunningOS().equals("ios")) {
//            myBasePage.backAltButton.click();
//            Thread.sleep(1000);
//        }
//        myBasePage.backAltButton.click();
//        Thread.sleep(1000);
//
//    }


    private void getEldersQuorum(int rights, String userName) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();
        //Data from API
        List<String> myList = new ArrayList<String>();


        myBasePage.waitForElementThenClick(myOrg.eldersQuorumOrg);
        myBasePage.waitForElementThenClick(myOrg.eldersQuorumPresidency);

        myList = apiTest.getChildOrganizationMembers("Elders Quorum Presidency", userName, "21628");
        //The following members are marked private.
        if (rights <= 3) {
            myList.remove("Smith, Gabriel");
            myList.remove("Loeb, Andrew");
        }
        myBasePage.apiCheckData(myList);

        if(getRunningOS().equals("ios")) {
            myBasePage.waitForElementThenClick(myBasePage.backAltButton);
            Thread.sleep(1000);
        }
//        System.out.println(myBasePage.getSourceOfPage());
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        Thread.sleep(1000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        Thread.sleep(1000);

    }

    private void eldersQuorumData() throws Exception{
        String pageSource;
        BasePage myBasePage = new BasePage(driver);

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum President", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Adam", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Beeson", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum First Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Smith", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Gabriel", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum Second Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Loeb", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Andrew", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum Secretary", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Murillo", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("David Edgardo", pageSource, "Contains"));

    }


    private void getReliefSociety(int rights, String userName) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();

        //Data from Web page
        List<String> myList = new ArrayList<String>();

        //Data from android list
        List<String> androidList = new ArrayList<String>();

        myBasePage.waitForElementThenClick(myOrg.reliefSocietyOrg);
        myBasePage.waitForElementThenClick(myOrg.reliefSocietyPresidency);

        myList = apiTest.getChildOrganizationMembers("Relief Society Presidency", userName, "21628");

        //The following members are marked private.
        if (rights <= 3) {
            myList.remove("Rodriguez, Erika");
        }
        myBasePage.apiCheckData(myList);


        if(getRunningOS().equals("ios")) {
            myBasePage.waitForElementThenClick(myBasePage.backAltButton);
//            myBasePage.backAltButton.click();
            Thread.sleep(1000);
        }
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        Thread.sleep(2000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
//        myBasePage.backAltButton.click();
//        Thread.sleep(1000);

    }

    private void reliefSocietyData() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Relief Society President", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Bridgeman", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Pamela", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Relief Society First Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lolohea", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Blair", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Relief Society Second Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Callahan", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Jennifer", pageSource, "Contains"));

//        Assert.assertTrue(myBasePage.checkNoCaseList("Relief Society Secretary", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Williams", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Patricia Irene", pageSource, "Contains"));
    }


    private void getYoungMenInfo(int rights, String userName) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();

        //Data from Web page
        List<String> myList = new ArrayList<String>();

        myBasePage.waitForElementThenClick(myOrg.youngMenOrg);


        // Priests Quorum Presidency
//        myOrg.priestsQuorum.click();
        myBasePage.waitForElementThenClick(myOrg.priestsQuorum);
        Thread.sleep(2000);
//        System.out.println(myBasePage.getSourceOfPage());
//        myOrg.priestsQuorumPresidency.click();
        myBasePage.waitForElementThenClick(myOrg.priestsQuorumPresidency);
        myList = apiTest.getChild2OrganizationMembers("Priests Quorum Presidency", userName, "21628");
        myBasePage.apiCheckData(myList);
        Thread.sleep(2000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);

        // Priests Quorum Adult Leaders
//        System.out.println(myBasePage.getSourceOfPage());
//        myOrg.priestsQuorumAdultLeaders.click();
        Thread.sleep(2000);
        if (myBasePage.checkForElement(myOrg.priestsQuorumAdultLeaders)) {
            //        myBasePage.waitForElementThenClick(myOrg.priestsQuorumAdultLeaders);
            myOrg.priestsQuorumAdultLeaders.click();
            myList = apiTest.getChild2OrganizationMembers("Priests Quorum Adult Leaders", userName, "21628");
            myBasePage.apiCheckData(myList);
            Thread.sleep(2000);
            myBasePage.waitForElementThenClick(myBasePage.backAltButton);
            Thread.sleep(2000);
        }
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        Thread.sleep(2000);



        // Teachers Quorum Presidency
        myBasePage.waitForElementThenClick(myOrg.teachersQuorum);
        Thread.sleep(1000);
        myBasePage.waitForElementThenClick(myOrg.teachersQuorumPresidency);
        myList = apiTest.getChild2OrganizationMembers("Teachers Quorum Presidency", userName, "21628");
        myBasePage.apiCheckData(myList);
        Thread.sleep(2000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);

//        // Teachers Quorum Adult Leaders
//        myOrg.teachersQuorumAdultLeaders.click();
//        myList = apiTest.getChild2OrganizationMembers("Teachers Quorum Adult Leaders", userName, "21628");
//        myBasePage.apiCheckData(myList);
//        Thread.sleep(2000);
//        myBasePage.waitForElementThenClick(myBasePage.backAltButton);

        Thread.sleep(2000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        Thread.sleep(2000);
        // Deacons Quorum
        myBasePage.waitForElementThenClick(myOrg.deaconsQuorum);
        Thread.sleep(1000);
        myBasePage.waitForElementThenClick(myOrg.deaconsQuorumPresidency);
//        myOrg.deaconsQuorum.click();
//        myOrg.deaconsQuorumPresidency.click();
        myList = apiTest.getChild2OrganizationMembers("Deacons Quorum Presidency", userName, "21628");
        myBasePage.apiCheckData(myList);
        Thread.sleep(2000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        Thread.sleep(2000);

        // Deacons Quorum Adult Leaders
        myBasePage.waitForElementThenClick(myOrg.deaconsQuorumAdultLeaders);
//        myOrg.deaconsQuorumAdultLeaders.click();
        myList = apiTest.getChild2OrganizationMembers("Deacons Quorum Adult Leaders", userName, "21628");
        myBasePage.apiCheckData(myList);
        Thread.sleep(2000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        Thread.sleep(2000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);


        Thread.sleep(500);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        Thread.sleep(1000);


    }


    private void aaronicPriesthoodQuorumsPresidency() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();

//        Assert.assertTrue(myBasePage.checkNoCaseList("Young Men President", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Arriaza", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Hyrum Isaac", pageSource, "Contains"));
//
//        Assert.assertTrue(myBasePage.checkNoCaseList("Young Men First Counselor", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Romriell", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Alex", pageSource, "Contains"));
//
//        Assert.assertTrue(myBasePage.checkNoCaseList("Young Men Second Counselor", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Del Real Cortes", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Juan Carlos", pageSource, "Contains"));
//
//        Assert.assertTrue(myBasePage.checkNoCaseList("Young Men Secretary", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Ika", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Sam", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Advisor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lousiale", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Roy Kali Tomu", pageSource, "Contains"));

    }



    private void getYoungWomenInfo(int rights, String userName) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver );
        MemberToolsAPI apiTest = new MemberToolsAPI();
        //Data from Web page
        List<String> myList = new ArrayList<String>();

        myBasePage.waitForElementThenClick(myOrg.youngWomenOrg);
        Thread.sleep(1000);

        // Young Women Presidency
        myBasePage.waitForElementThenClick(myOrg.youngWomenPresidency);
//        myOrg.youngWomenPresidency.click();
        myList = apiTest.getChildOrganizationMembers("Young Women Presidency", userName, "21628");
        myBasePage.apiCheckData(myList);
        Thread.sleep(2000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);

        // Young Women 12-18
        myBasePage.waitForElementThenClick(myOrg.youngWomen12to18);
        Thread.sleep(1000);
        myBasePage.waitForElementThenClick(myOrg.youngWomenClassPresidency);
//        myOrg.youngWomen12to18.click();
//        myOrg.youngWomenClassPresidency.click();
        myList = apiTest.getChildOrganizationMembers("Young Women 12-18", userName, "21628");
        myBasePage.apiCheckData(myList);
        Thread.sleep(2000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);


        Thread.sleep(1000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        Thread.sleep(1000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        Thread.sleep(1000);

    }

    private void youngWomenPresidency() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Young Women President", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lambson", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Rosette Ulayan", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Young Women First Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ruiz", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Cristina", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Young Women Second Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sapau", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lillyan", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Young Women Secretary", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Salas Teran", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Alaide", pageSource, "Contains"));

    }




    private void getSundaySchoolInfo(int rights, String userName) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();
        //Data from Web page
        List<String> myList = new ArrayList<String>();
        List<String> childOrgs = new ArrayList<>();

        myBasePage.waitForElementThenClick(myOrg.sundaySchoolOrg);
        Thread.sleep(1000);
        childOrgs = apiTest.getChildOrganizationClasses("Sunday School", userName, "21628");

        //TODO: Unassigned Teachers matches Sunday School and Primary need to have a check for Sunday School or Primary
        for (String childOrgName : childOrgs) {
            if (childOrgName.contains("Unassigned")) {
                System.out.println("Skipping Unassigned for now!");
            } else {
                if (getRunningOS().equalsIgnoreCase("ios")) {
                    driver.get().findElement(By.name(childOrgName)).click();
                } else {
                    driver.get().findElement(By.xpath("//android.widget.TextView[@text='" + childOrgName + "']")).click();
                }
                myList = apiTest.getChildOrganizationMembers(childOrgName, userName, "21628");
                myBasePage.apiCheckData(myList);
                Thread.sleep(2000);
                myBasePage.waitForElementThenClick(myBasePage.backAltButton);
                Thread.sleep(1000);
            }

        }

        Thread.sleep(1000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);


    }



//    private void sundaySchoolClassSub(WebElement className, String subReport) throws Exception {
//        String pageSource;
//        BasePage myBasePage = new BasePage(driver);
//        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
//        List<String> myList = new ArrayList<String>();
//        //Data from android list
//        List<String> androidList = new ArrayList<String>();
//        String macAllMembers = "All " + className + " Members";
//        String classAllMembers = subReport + "Members";
//
//
//        className.click();
//        myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Sunday School", subReport, false);
//        myBasePage.compareWebData(myList, androidList, true);
//
//        //Select all members
//        myOrg.generalAllMembers.click();
//        myList = myWeb.getAllMembersInOrganization("OrganizationsMenu", "Sunday School", classAllMembers, false);
//        myBasePage.compareWebData(myList, androidList, true);
//
//        //Back to Sunday School
//        if (getRunningOS().equals("ios")) {
//            myBasePage.backAltButton.click();
//        }
//        myBasePage.backAltButton.click();
//    }


    private void getPrimaryInfo(int rights, String userName) throws Exception {
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();
        //Data from Web page
        List<String> myList = new ArrayList<String>();
        List<String> childOrgs = new ArrayList<>();

        myBasePage.waitForElementThenClick(myOrg.primaryOrg);
        Thread.sleep(1000);
        childOrgs = apiTest.getChildOrganizationClasses("Primary", userName, "21628");

        //TODO: Unassigned Teachers matches Sunday School and Primary need to have a check for Sunday School or Primary
        for (String childOrgName : childOrgs) {
            if (childOrgName.contains("Unassigned") || (childOrgName.contains("Music") || (childOrgName.contains("Girls")) )) {
                System.out.println("Skipping Unassigned for now!");
            } else {
                if (getRunningOS().equalsIgnoreCase("ios")) {
                    driver.get().findElement(By.name(childOrgName)).click();
                } else {
                    if (!myBasePage.checkForText(childOrgName)) {
                        myBasePage.scrollDownAndroidUIAutomator("0");
                    }
                    driver.get().findElement(By.xpath("//android.widget.TextView[@text='" + childOrgName + "']")).click();
                }
                myList = apiTest.getChildOrganizationMembers(childOrgName, userName, "21628");
                myBasePage.apiCheckData(myList);
                Thread.sleep(2000);
                myBasePage.waitForElementThenClick(myBasePage.backAltButton);
                Thread.sleep(1000);
            }

        }

        Thread.sleep(2000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);


    }


    private void primaryPresidency() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Primary President", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sofia", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("", pageSource, "Contains"));

//        Assert.assertTrue(myBasePage.checkNoCaseList("Primary First Counselor", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Maldonado", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Jacqueline", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Primary Second Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lambert", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Audrey", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Primary Secretary", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Uriostegui", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Stephanie", pageSource, "Contains"));

    }


    private void getOtherInfo(int rights, String userName) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        OrganizationsScreen myOrg = new OrganizationsScreen(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();
        //Data from Web page
        List<String> myList = new ArrayList<String>();
        List<String> childOrgs = new ArrayList<>();

        myOrg.otherCallingsOrg.click();
        childOrgs = apiTest.getChildOrganizationClasses("Other Callings", userName, "21628");

        for (String childOrgName : childOrgs) {
            if (getRunningOS().equalsIgnoreCase("ios")) {
                driver.get().findElement(By.name(childOrgName)).click();
            } else {
                driver.get().findElement(By.xpath("//android.widget.TextView[@text='" + childOrgName + "']")).click();
            }
            myList = apiTest.getChildOrganizationMembers(childOrgName, userName, "21628");
            myBasePage.apiCheckData(myList);
            Thread.sleep(2000);
            myBasePage.waitForElementThenClick(myBasePage.backAltButton);
            Thread.sleep(1000);
        }




        myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        Thread.sleep(1000);
        myBasePage.waitForElementThenClick(myBasePage.backAltButton);

    }


    //    @Test(dataProvider = "Members", groups = {"smoke1", "smoke", "all1", "all"})
    public void organizationTest(String userName, String passWord, String rightsString, String calling) throws Exception {
        //String pageSource;
        int rights = Integer.parseInt(rightsString);

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);


        //Login and enter in PIN
//        myHelper.loginUAT(userName, passWord);
        myHelper.proxyLogin(userName);
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.organizations);
//        if (rights <= 3) {
//            myWeb.openPageLogIn("https://lcr-uat.lds.org", userName, passWord);
//        }


        getBishopricInfo(rights);

        getEldersQuorum(rights, userName);

        getReliefSociety(rights, userName);

        getYoungMenInfo(rights, userName);

        getYoungWomenInfo(rights, userName);

        getSundaySchoolInfo(rights, userName);

        getPrimaryInfo(rights, userName);



//        getOtherInfo(rights);
        //getHighPriestsGroupInfo(rights);

    }


}
