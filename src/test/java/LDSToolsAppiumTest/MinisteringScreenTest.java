package LDSToolsAppiumTest;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class MinisteringScreenTest extends BaseDriver {


    @Test (groups = {"all3", "all", "smoke", "smoke4", "daily", "daily4"})
    public void ministeringScreenCheck() throws Exception {
        String pageSource;
        List<String> memberList = new ArrayList<String>();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList("BISHOP", "Centinela 1st");

        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");


        myMenu.selectMenu(myMenu.reports);
//        Thread.sleep(2000);
        myBasePage.waitForElement(myMinistering.ministeringBrothersReport);
        pageSource = myBasePage.getSourceOfPage();


        Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Sisters", pageSource, "Contains"));


        myMinistering.ministeringBrothersReport.click();

        Thread.sleep(2000);
        memberList = apiTest.getInfoFromMinisteringBrothers("mbthomas74",  "21628", "brothers");
        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Companionships Interviewed", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Assigned Households", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Unassigned Households", pageSource, "Contains"));

        for(String ministeringReport: memberList) {
            Assert.assertTrue(pageSource.contains(ministeringReport));
        }


        myBasePage.backAltButton.click();
        Thread.sleep(1000);

        myMinistering.ministeringSistersReport.click();

        Thread.sleep(2000);
        memberList = apiTest.getInfoFromMinisteringBrothers("mbthomas74",  "21628", "sisters");
        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("Companionships Interviewed", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Assigned Sisters", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Unassigned Sisters", pageSource, "Contains"));

        for(String ministeringReport: memberList) {
            Assert.assertTrue(pageSource.contains(ministeringReport));
        }

        myBasePage.backAltButton.click();


    }




    @Test (groups = {"all2", "all", "smoke", "smoke2", "daily", "daily1",})
    public void ministeringBasic_BISHOP() throws Exception {
        ministeringBasicSub("BISHOP");
    }

    @Test (groups = {"all3", "all"})
    public void ministeringBasic_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        ministeringBasicSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void ministeringBasic_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        ministeringBasicSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test(groups = {"all1", "all"})
    public void ministeringBasic_WARD_CLERK() throws Exception {
        ministeringBasicSub("WARD_CLERK");
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_WARD_ASSISTANT_CLERK() throws Exception {
        ministeringBasicSub("WARD_ASSISTANT_CLERK");
    }

    @Test(groups = {"all3", "all"})
    public void ministeringBasic_WARD_EXECUTIVE_SECRETARY() throws Exception {
        ministeringBasicSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test(groups = {"all4", "all"})
    public void ministeringBasic_MEMBER1() throws Exception {
        ministeringBasicSub("MEMBER1");
    }

    @Test(groups = {"all1", "all"})
    public void ministeringBasic_MEMBER2() throws Exception {
        ministeringBasicSub("MEMBER2");
    }

    @Test(groups = {"all2", "all", "daily", "daily2"})
    public void ministeringBasic_ELDERS_QUORUM_PRESIDENT() throws Exception {
        ministeringBasicSub("ELDERS_QUORUM_PRESIDENT");
    }
//
//    @Test(groups = {"all3", "all"})
//    public void ministeringBasic_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
//        ministeringBasicSub("ELDERS_QUORUM_FIRST_COUNSELOR");
//    }
//
//    @Test(groups = {"all4", "all"})
//    public void ministeringBasic_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
//        ministeringBasicSub("ELDERS_QUORUM_SECOND_COUNSELOR");
//    }
//
//    @Test(groups = {"all1", "all"})
//    public void ministeringBasic_ELDERS_QUORUM_SECRETARY() throws Exception {
//        ministeringBasicSub("ELDERS_QUORUM_SECRETARY");
//    }

    @Test(groups = {"all2", "all", "daily", "daily3"})
    public void ministeringBasic_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        ministeringBasicSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test(groups = {"all3", "all"})
    public void ministeringBasic_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        ministeringBasicSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void ministeringBasic_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        ministeringBasicSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test(groups = {"all1", "all", "daily", "daily4"})
    public void ministeringBasic_YOUNG_WOMEN_PRESIDENT() throws Exception {
        ministeringBasicSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test(groups = {"all2", "all"})
    public void ministeringBasic_WOMEN_SECOND_COUNSELOR() throws Exception {
        ministeringBasicSub("WOMEN_SECOND_COUNSELOR");
    }

//    @Test(groups = {"all3", "all"})
//    public void ministeringBasic_SUNDAY_SCHOOL_PRESIDENT() throws Exception {
//        ministeringBasicSub("SUNDAY_SCHOOL_PRESIDENT");
//    }
//
//    @Test(groups = {"all4", "all"})
//    public void ministeringBasic_WARD_MISSION_LEADER() throws Exception {
//        ministeringBasicSub("WARD_MISSION_LEADER");
//    }




    public void ministeringBasicCheckNewRights(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights >= 4) {
            myMenu.selectMenu(myMenu.reports);
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();


            Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Sisters", pageSource, "Contains"));


            myMinistering.ministeringBrothersReport.click();

            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();

            Assert.assertTrue(myBasePage.checkNoCaseList("Companionships Interviewed", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Assigned Households", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Unassigned Households", pageSource, "Contains"));

            myBasePage.backAltButton.click();
            Thread.sleep(1000);

            myMinistering.ministeringSistersReport.click();

            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();

            Assert.assertTrue(myBasePage.checkNoCaseList("Companionships Interviewed", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Assigned Sisters", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Unassigned Sisters", pageSource, "Contains"));

            myBasePage.backAltButton.click();

        }

        if (rights == 1){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }
    
    
    
    
    
    
    
    
    

    public void ministeringBasicCheck(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();


            Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Brothers", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Ministering Sisters", pageSource, "Contains"));


            myMinistering.ministeringBrothersReport.click();

            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();

            Assert.assertTrue(myBasePage.checkNoCaseList("Companionships Interviewed", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Assigned Households", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Unassigned Households", pageSource, "Contains"));

            myBasePage.backAltButton.click();

            myMinistering.ministeringSistersReport.click();

            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();

            Assert.assertTrue(myBasePage.checkNoCaseList("Companionships Interviewed", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Assigned Sisters", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Unassigned Sisters", pageSource, "Contains"));

            myBasePage.backAltButton.click();

        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }


    public void ministeringUnassignedHouseholdsCheckSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        ministeringUnassignedHouseholdsCheckNewRights(Integer.parseInt(callingRights[2]));
    }


    @Test (groups = {"all4", "all", "daily", "daily2"})
    public void ministeringUnassignedHouseholds_BISHOP() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("BISHOP");
    }

    @Test (groups = {"all3", "all"})
    public void ministeringUnassignedHouseholds_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test(groups = {"all1", "all"})
    public void ministeringUnassignedHouseholds_WARD_CLERK() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("WARD_CLERK");
    }

    @Test(groups = {"all4", "all"})
    public void ministeringUnassignedHouseholds_WARD_ASSISTANT_CLERK() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("WARD_ASSISTANT_CLERK");
    }

    @Test(groups = {"all3", "all"})
    public void ministeringUnassignedHouseholds_WARD_EXECUTIVE_SECRETARY() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_MEMBER1() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("MEMBER1");
    }

    @Test(groups = {"all1", "all"})
    public void ministeringUnassignedHouseholds_MEMBER2() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("MEMBER2");
    }

    @Test(groups = {"all4", "all", "daily", "daily1"})
    public void ministeringUnassignedHouseholds_ELDERS_QUORUM_PRESIDENT() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("ELDERS_QUORUM_PRESIDENT");
    }

//    @Test(groups = {"all3", "all"})
//    public void ministeringUnassignedHouseholds_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
//        ministeringUnassignedHouseholdsCheckSub("ELDERS_QUORUM_FIRST_COUNSELOR");
//    }
//
//    @Test(groups = {"all2", "all"})
//    public void ministeringUnassignedHouseholds_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
//        ministeringUnassignedHouseholdsCheckSub("ELDERS_QUORUM_SECOND_COUNSELOR");
//    }
//
//    @Test(groups = {"all1", "all"})
//    public void ministeringUnassignedHouseholds_ELDERS_QUORUM_SECRETARY() throws Exception {
//        ministeringUnassignedHouseholdsCheckSub("ELDERS_QUORUM_SECRETARY");
//    }

    @Test(groups = {"all4", "all", "daily", "daily3"})
    public void ministeringUnassignedHouseholds_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test(groups = {"all3", "all"})
    public void ministeringUnassignedHouseholds_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test(groups = {"all2", "all"})
    public void ministeringUnassignedHouseholds_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test(groups = {"all1", "all", "daily", "daily4"})
    public void ministeringUnassignedHouseholds_YOUNG_WOMEN_PRESIDENT() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test(groups = {"all4", "all"})
    public void ministeringUnassignedHouseholds_WOMEN_SECOND_COUNSELOR() throws Exception {
        ministeringUnassignedHouseholdsCheckSub("WOMEN_SECOND_COUNSELOR");
    }

//    @Test(groups = {"all3", "all"})
//    public void ministeringUnassignedHouseholds_SUNDAY_SCHOOL_PRESIDENT() throws Exception {
//        ministeringUnassignedHouseholdsCheckSub("SUNDAY_SCHOOL_PRESIDENT");
//    }
//
//    @Test(groups = {"all2", "all"})
//    public void ministeringUnassignedHouseholds_WARD_MISSION_LEADER() throws Exception {
//        ministeringUnassignedHouseholdsCheckSub("WARD_MISSION_LEADER");
//    }

    public void ministeringUnassignedHouseholdsCheckNewRights(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights >= 4) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringBrothersReport.click();
            Thread.sleep(2000);
            myMinistering.unassignedHouseholds.click();
            Thread.sleep(2000);

            //For some reason the pageSource is broken for this page in iOS.
            if (getRunningOS().equalsIgnoreCase("ios")) {
//                pageSource = myBasePage.getSourceOfPage();
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(pageSource.contains("Adams"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }


            myBasePage.waitForElementThenClick(myBasePage.backAltButton);
            Thread.sleep(2000);
            myBasePage.waitForElementThenClick(myBasePage.backAltButton);

            Thread.sleep(2000);
            myMinistering.ministeringSistersReport.click();
            Thread.sleep(2000);
            myMinistering.unassignedSisters.click();
            Thread.sleep(4000);


            if (getRunningOS().equalsIgnoreCase("ios")) {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(pageSource.contains("Arabia"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Ayon", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }

            myBasePage.waitForElementThenClick(myBasePage.backAltButton);
            Thread.sleep(2000);
            myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        }

        if (rights == 3){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    public void ministeringUnassignedHouseholdsCheck(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringBrothersReport.click();
            Thread.sleep(2000);
            myMinistering.unassignedHouseholds.click();
            Thread.sleep(2000);

            //For some reason the pageSource is broken for this page in iOS.
            if (getRunningOS().equalsIgnoreCase("ios")) {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(pageSource.contains("Adams"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }


            myBasePage.waitForElementThenClick(myBasePage.backAltButton);
            Thread.sleep(2000);
            myBasePage.waitForElementThenClick(myBasePage.backAltButton);


            myMinistering.ministeringSistersReport.click();
            Thread.sleep(2000);
            myMinistering.unassignedSisters.click();
            Thread.sleep(4000);


            if (getRunningOS().equalsIgnoreCase("ios")) {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(pageSource.contains("Adams"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }


            myBasePage.waitForElementThenClick(myBasePage.backAltButton);
            Thread.sleep(2000);
            myBasePage.waitForElementThenClick(myBasePage.backAltButton);
        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }



    @Test (groups = {"all2", "all", "daily", "daily3"})
    public void ministeringAssignedHouseholds_BISHOP() throws Exception {
        ministeringAssignedHouseholdsSub("BISHOP");
    }

    @Test (groups = {"all3", "all"})
    public void ministeringAssignedHouseholds_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        ministeringAssignedHouseholdsSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void ministeringAssignedHouseholds_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        ministeringAssignedHouseholdsSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test(groups = {"all1", "all"})
    public void ministeringAssignedHouseholds_WARD_CLERK() throws Exception {
        ministeringAssignedHouseholdsSub("WARD_CLERK");
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_WARD_ASSISTANT_CLERK() throws Exception {
        ministeringAssignedHouseholdsSub("WARD_ASSISTANT_CLERK");
    }

    @Test(groups = {"all3", "all"})
    public void ministeringAssignedHouseholds_WARD_EXECUTIVE_SECRETARY() throws Exception {
        ministeringAssignedHouseholdsSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test(groups = {"all4", "all"})
    public void ministeringAssignedHouseholds_MEMBER1() throws Exception {
        ministeringAssignedHouseholdsSub("MEMBER1");
    }

    @Test(groups = {"all1", "all"})
    public void ministeringAssignedHouseholds_MEMBER2() throws Exception {
        ministeringAssignedHouseholdsSub("MEMBER2");
    }

    @Test(groups = {"all2", "all", "daily", "daily1"})
    public void ministeringAssignedHouseholds_ELDERS_QUORUM_PRESIDENT() throws Exception {
        ministeringAssignedHouseholdsSub("ELDERS_QUORUM_PRESIDENT");
    }

//    @Test(groups = {"all3", "all"})
//    public void ministeringAssignedHouseholds_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
//        ministeringAssignedHouseholdsSub("ELDERS_QUORUM_FIRST_COUNSELOR");
//    }
//
//    @Test(groups = {"all4", "all"})
//    public void ministeringAssignedHouseholds_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
//        ministeringAssignedHouseholdsSub("ELDERS_QUORUM_SECOND_COUNSELOR");
//    }
//
//    @Test(groups = {"all1", "all"})
//    public void ministeringAssignedHouseholds_ELDERS_QUORUM_SECRETARY() throws Exception {
//        ministeringAssignedHouseholdsSub("ELDERS_QUORUM_SECRETARY");
//    }

    @Test(groups = {"all2", "all", "daily", "daily2"})
    public void ministeringAssignedHouseholds_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        ministeringAssignedHouseholdsSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test(groups = {"all3", "all"})
    public void ministeringAssignedHouseholds_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        ministeringAssignedHouseholdsSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void ministeringAssignedHouseholds_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        ministeringAssignedHouseholdsSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test(groups = {"all1", "all", "daily", "daily4"})
    public void ministeringAssignedHouseholds_YOUNG_WOMEN_PRESIDENT() throws Exception {
        ministeringAssignedHouseholdsSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedHouseholds_WOMEN_SECOND_COUNSELOR() throws Exception {
        ministeringAssignedHouseholdsSub("WOMEN_SECOND_COUNSELOR");
    }

//    @Test(groups = {"all3", "all"})
//    public void ministeringAssignedHouseholds_SUNDAY_SCHOOL_PRESIDENT() throws Exception {
//        ministeringAssignedHouseholdsSub("SUNDAY_SCHOOL_PRESIDENT");
//    }
//
//    @Test(groups = {"all4", "all"})
//    public void ministeringAssignedHouseholds_WARD_MISSION_LEADER() throws Exception {
//        ministeringAssignedHouseholdsSub("WARD_MISSION_LEADER");
//    }


    public void ministeringAssignedHouseholdsSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedHouseholdsCheckNewRights(Integer.parseInt(callingRights[2]));
    }

    public void ministeringAssignedHouseholdsCheckNewRights(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights >= 4 ) {
            myMenu.selectMenu(myMenu.reports);
            myBasePage.waitForElementThenClick(myMinistering.ministeringBrothersReport);
            Thread.sleep(1000); //should not need this.
            myBasePage.waitForElementThenClick(myMinistering.assignedHouseholds);


            Thread.sleep(2000);

            //For some reason the pageSource is broken for this page in iOS.
            if (getRunningOS().equalsIgnoreCase("ios")) {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(pageSource.contains("Adams"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }

        }

        if (rights == 1){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    public void ministeringAssignedHouseholdsCheck(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringBrothersReport.click();
            myMinistering.assignedHouseholds.click();

            Thread.sleep(2000);

            //For some reason the pageSource is broken for this page in iOS.
            if (getRunningOS().equalsIgnoreCase("ios")) {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(pageSource.contains("Adams"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }

        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }



    @Test (groups = {"all3", "all", "smoke", "smoke3", "daily", "daily4"})
    public void companionshipsElders_BISHOP() throws Exception {
        companionshipsEldersSub("BISHOP");
    }

    @Test (groups = {"all2", "all"})
    public void companionshipsElders_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        companionshipsEldersSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test(groups = {"all1", "all"})
    public void companionshipsElders_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        companionshipsEldersSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void companionshipsElders_WARD_CLERK() throws Exception {
        companionshipsEldersSub("WARD_CLERK");
    }

    @Test(groups = {"all3", "all"})
    public void companionshipsElders_WARD_ASSISTANT_CLERK() throws Exception {
        companionshipsEldersSub("WARD_ASSISTANT_CLERK");
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_WARD_EXECUTIVE_SECRETARY() throws Exception {
        companionshipsEldersSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test(groups = {"all1", "all"})
    public void companionshipsElders_MEMBER1() throws Exception {
        companionshipsEldersSub("MEMBER1");
    }

    @Test(groups = {"all4", "all"})
    public void companionshipsElders_MEMBER2() throws Exception {
        companionshipsEldersSub("MEMBER2");
    }

//    @Test(groups = {"all3", "all", "daily", "daily1"})
//    public void companionshipsElders_ELDERS_QUORUM_PRESIDENT() throws Exception {
//        companionshipsEldersSub("ELDERS_QUORUM_PRESIDENT");
//    }
//
//    @Test(groups = {"all2", "all"})
//    public void companionshipsElders_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
//        companionshipsEldersSub("ELDERS_QUORUM_FIRST_COUNSELOR");
//    }
//
//    @Test(groups = {"all1", "all"})
//    public void companionshipsElders_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
//        companionshipsEldersSub("ELDERS_QUORUM_SECOND_COUNSELOR");
//    }
//
//    @Test(groups = {"all4", "all"})
//    public void companionshipsElders_ELDERS_QUORUM_SECRETARY() throws Exception {
//        companionshipsEldersSub("ELDERS_QUORUM_SECRETARY");
//    }

    @Test(groups = {"all3", "all", "daily", "daily2"})
    public void companionshipsElders_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        companionshipsEldersSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsElders_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        companionshipsEldersSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test(groups = {"all1", "all"})
    public void companionshipsElders_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        companionshipsEldersSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all", "daily", "daily3"})
    public void companionshipsElders_YOUNG_WOMEN_PRESIDENT() throws Exception {
        companionshipsEldersSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test(groups = {"all3", "all"})
    public void companionshipsElders_WOMEN_SECOND_COUNSELOR() throws Exception {
        companionshipsEldersSub("WOMEN_SECOND_COUNSELOR");
    }

//    @Test(groups = {"all2", "all"})
//    public void companionshipsElders_SUNDAY_SCHOOL_PRESIDENT() throws Exception {
//        companionshipsEldersSub("SUNDAY_SCHOOL_PRESIDENT");
//    }
//
//    @Test(groups = {"all1", "all"})
//    public void companionshipsElders_WARD_MISSION_LEADER() throws Exception {
//        companionshipsEldersSub("WARD_MISSION_LEADER");
//    }

    public void companionshipsEldersSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsEldersCheckNewRights(Integer.parseInt(callingRights[2]));
    }

    public void companionshipsEldersCheckNewRights(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights >= 4) {
            myMenu.selectMenu(myMenu.reports);
            myBasePage.waitForElementThenClick(myMinistering.ministeringBrothersReport);
//            myMinistering.ministeringBrothersReport.click();


            myMinistering.validateDistrict("EQ President");
            myMinistering.validateDistrict("First Counselor");
            myMinistering.validateDistrict("Second Counselor");

            //Select District 1
            myMinistering.selectDistrict("EQ President");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Martinez", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Darth", pageSource, "Contains"));

            myBasePage.backAltButton.click();

            //Select District 2
            myMinistering.selectDistrict("First Counselor");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Lambson", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Fitzgerald", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Vader", pageSource, "Contains"));

            myBasePage.backAltButton.click();

            //Select District 3
            myMinistering.selectDistrict("Second Counselor");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Ryan", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Solo", pageSource, "Contains"));

            myBasePage.backAltButton.click();
        }

        if (rights == 1){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }


    public void companionshipsEldersCheck(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringBrothersReport.click();


            myMinistering.validateDistrict("EQ President");
            myMinistering.validateDistrict("First Counselor");
            myMinistering.validateDistrict("Second Counselor");

            //Select District 1
            myMinistering.selectDistrict("EQ President");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Bryson", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Darth", pageSource, "Contains"));

            myBasePage.backAltButton.click();

            //Select District 2
            myMinistering.selectDistrict("First Counselor");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Lambson", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Smith", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Vader", pageSource, "Contains"));

            myBasePage.backAltButton.click();

            //Select District 3
            myMinistering.selectDistrict("Second Counselor");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Ryan", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Solo", pageSource, "Contains"));

            myBasePage.backAltButton.click();
        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }


    @Test (groups = {"all1", "all", "daily", "daily1" })
    public void unassignedSisters_BISHOP() throws Exception {
        unassignedSistersSub("BISHOP");
    }

    @Test (groups = {"all2", "all"})
    public void unassignedSisters_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        unassignedSistersSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void unassignedSisters_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        unassignedSistersSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void unassignedSisters_WARD_CLERK() throws Exception {
        unassignedSistersSub("WARD_CLERK");
    }

    @Test(groups = {"all1", "all"})
    public void unassignedSisters_WARD_ASSISTANT_CLERK() throws Exception {
        unassignedSistersSub("WARD_ASSISTANT_CLERK");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_WARD_EXECUTIVE_SECRETARY() throws Exception {
        unassignedSistersSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test(groups = {"all3", "all"})
    public void unassignedSisters_MEMBER1() throws Exception {
        unassignedSistersSub("MEMBER1");
    }

    @Test(groups = {"all4", "all"})
    public void unassignedSisters_MEMBER2() throws Exception {
        unassignedSistersSub("MEMBER2");
    }

    @Test(groups = {"all1", "all", "daily", "daily2"})
    public void unassignedSisters_ELDERS_QUORUM_PRESIDENT() throws Exception {
        unassignedSistersSub("ELDERS_QUORUM_PRESIDENT");
    }

//    @Test(groups = {"all2", "all"})
//    public void unassignedSisters_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
//        unassignedSistersSub("ELDERS_QUORUM_FIRST_COUNSELOR");
//    }
//
//    @Test(groups = {"all3", "all"})
//    public void unassignedSisters_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
//        unassignedSistersSub("ELDERS_QUORUM_SECOND_COUNSELOR");
//    }
//
//    @Test(groups = {"all4", "all"})
//    public void unassignedSisters_ELDERS_QUORUM_SECRETARY() throws Exception {
//        unassignedSistersSub("ELDERS_QUORUM_SECRETARY");
//    }

    @Test(groups = {"all1", "all", "daily", "daily2"})
    public void unassignedSisters_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        unassignedSistersSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test(groups = {"all2", "all"})
    public void unassignedSisters_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        unassignedSistersSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void unassignedSisters_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        unassignedSistersSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void unassignedSisters_YOUNG_WOMEN_PRESIDENT() throws Exception {
        unassignedSistersSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test(groups = {"all1", "all"})
    public void unassignedSisters_WOMEN_SECOND_COUNSELOR() throws Exception {
        unassignedSistersSub("WOMEN_SECOND_COUNSELOR");
    }

//    @Test(groups = {"all2", "all"})
//    public void unassignedSisters_SUNDAY_SCHOOL_PRESIDENT() throws Exception {
//        unassignedSistersSub("SUNDAY_SCHOOL_PRESIDENT");
//    }
//
//    @Test(groups = {"all3", "all"})
//    public void unassignedSisters_WARD_MISSION_LEADER() throws Exception {
//        unassignedSistersSub("WARD_MISSION_LEADER");
//    }

    public void unassignedSistersSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        unassignedSistersCheckNewRights(Integer.parseInt(callingRights[2]));
    }

    public void unassignedSistersCheckNewRights(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights >= 4) {
            myMenu.selectMenu(myMenu.reports);
            myBasePage.waitForElementThenClick(myMinistering.ministeringSistersReport);
            Thread.sleep(2000);

            myBasePage.waitForElementThenClick(myMinistering.unassignedSisters);
            Thread.sleep(2000);
            //For some reason the pageSource is broken for this page in iOS.
            if (getRunningOS().equalsIgnoreCase("ios")) {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(pageSource.contains("Arabia"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Ayon", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
            }
        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    public void unassignedSistersCheck(int rights, String calling) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringSistersReport.click();
            Thread.sleep(2000);

            if (calling.equals("elders") || (calling.equals("wardcouncil"))) {
                if (getRunningOS().equals("ios")) {
                    myMinistering.unassignedSisters.click();
                    Thread.sleep(2000);
                    pageSource = myBasePage.getSourceOfPage();
                    Assert.assertTrue(pageSource.contains("Adams"));
                    Assert.assertFalse(pageSource.contains("Skywalker"));
                } else {
                    pageSource = myBasePage.getSourceOfPage();
                    Assert.assertFalse(myBasePage.checkNoCaseList("Unassigned Households", pageSource, "Contains"));
                }
            } else {
                myMinistering.unassignedSisters.click();
                Thread.sleep(2000);
                //For some reason the pageSource is broken for this page in iOS.
                if (getRunningOS().equalsIgnoreCase("ios")) {
                    pageSource = myBasePage.getSourceOfPage();
                    Assert.assertTrue(pageSource.contains("Adams"));
                    Assert.assertFalse(pageSource.contains("Skywalker"));
                } else {
                    pageSource = myBasePage.getSourceOfPage();
                    Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
                    Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
                }

            }
        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }


    @Test (groups = {"all4", "all", "smoke", "smoke4", "daily", "daily2", "jft"})
    public void ministeringAssignedSisters_BISHOP() throws Exception {
        ministeringAssignedSistersSub("BISHOP");
    }

    @Test (groups = {"all3", "all"})
    public void ministeringAssignedSisters_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        ministeringAssignedSistersSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        ministeringAssignedSistersSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test(groups = {"all1", "all"})
    public void ministeringAssignedSisters_WARD_CLERK() throws Exception {
        ministeringAssignedSistersSub("WARD_CLERK");
    }

    @Test(groups = {"all4", "all"})
    public void ministeringAssignedSisters_WARD_ASSISTANT_CLERK() throws Exception {
        ministeringAssignedSistersSub("WARD_ASSISTANT_CLERK");
    }

    @Test(groups = {"all3", "all"})
    public void ministeringAssignedSisters_WARD_EXECUTIVE_SECRETARY() throws Exception {
        ministeringAssignedSistersSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_MEMBER1() throws Exception {
        ministeringAssignedSistersSub("MEMBER1");
    }

    @Test(groups = {"all1", "all"})
    public void ministeringAssignedSisters_MEMBER2() throws Exception {
        ministeringAssignedSistersSub("MEMBER2");
    }

    @Test(groups = {"all4", "all", "daily", "daily2"})
    public void ministeringAssignedSisters_ELDERS_QUORUM_PRESIDENT() throws Exception {
        ministeringAssignedSistersSub("ELDERS_QUORUM_PRESIDENT");
    }

//    @Test(groups = {"all3", "all"})
//    public void ministeringAssignedSisters_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
//        ministeringAssignedSistersSub("ELDERS_QUORUM_FIRST_COUNSELOR");
//    }
//
//    @Test(groups = {"all2", "all"})
//    public void ministeringAssignedSisters_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
//        ministeringAssignedSistersSub("ELDERS_QUORUM_SECOND_COUNSELOR");
//    }
//
//    @Test(groups = {"all1", "all"})
//    public void ministeringAssignedSisters_ELDERS_QUORUM_SECRETARY() throws Exception {
//        ministeringAssignedSistersSub("ELDERS_QUORUM_SECRETARY");
//    }

    @Test(groups = {"all4", "all", "daily", "daily3"})
    public void ministeringAssignedSisters_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        ministeringAssignedSistersSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test(groups = {"all3", "all"})
    public void ministeringAssignedSisters_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        ministeringAssignedSistersSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test(groups = {"all2", "all"})
    public void ministeringAssignedSisters_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        ministeringAssignedSistersSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test(groups = {"all1", "all", "daily", "daily4"})
    public void ministeringAssignedSisters_YOUNG_WOMEN_PRESIDENT() throws Exception {
        ministeringAssignedSistersSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test(groups = {"all4", "all"})
    public void ministeringAssignedSisters_WOMEN_SECOND_COUNSELOR() throws Exception {
        ministeringAssignedSistersSub("WOMEN_SECOND_COUNSELOR");
    }

//    @Test(groups = {"all3", "all"})
//    public void ministeringAssignedSisters_SUNDAY_SCHOOL_PRESIDENT() throws Exception {
//        ministeringAssignedSistersSub("SUNDAY_SCHOOL_PRESIDENT");
//    }
//
//    @Test(groups = {"all2", "all"})
//    public void ministeringAssignedSisters_WARD_MISSION_LEADER() throws Exception {
//        ministeringAssignedSistersSub("WARD_MISSION_LEADER");
//    }

    public void ministeringAssignedSistersSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        ministeringAssignedSistersCheckNewRights(Integer.parseInt(callingRights[2]));
    }

    public void ministeringAssignedSistersCheckNewRights(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights >= 4 ) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringSistersReport.click();
            Thread.sleep(2000);
            myMinistering.assignedSisters.click();

            Thread.sleep(2000);

            if (getRunningOS().equalsIgnoreCase("ios")) {
//                pageSource = myBasePage.getSourceOfPage();
                myBasePage.scrollDownIOS();
                pageSource = myBasePage.getSourceOfPage();
                System.out.println(pageSource);
                Assert.assertTrue(pageSource.contains("Adams"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Lisa", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Binks", pageSource, "Contains"));
            }


        }

        if (rights == 1){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }

    public void ministeringAssignedSistersCheck(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringSistersReport.click();
            Thread.sleep(2000);
            myMinistering.assignedSisters.click();

            Thread.sleep(2000);

            if (getRunningOS().equalsIgnoreCase("ios")) {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(pageSource.contains("Adams"));
                Assert.assertFalse(pageSource.contains("Skywalker"));
            } else {
                pageSource = myBasePage.getSourceOfPage();
                Assert.assertTrue(myBasePage.checkNoCaseList("Adams", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Binks", pageSource, "Contains"));
            }


        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }



    @Test (groups = {"all4", "all", "daily", "daily3"})
    public void companionshipsSisters_BISHOP() throws Exception {
        companionshipsSistersSub("BISHOP");
    }

    @Test (groups = {"all1", "all"})
    public void companionshipsSisters_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        companionshipsSistersSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        companionshipsSistersSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void companionshipsSisters_WARD_CLERK() throws Exception {
        companionshipsSistersSub("WARD_CLERK");
    }

    @Test(groups = {"all4", "all"})
    public void companionshipsSisters_WARD_ASSISTANT_CLERK() throws Exception {
        companionshipsSistersSub("WARD_ASSISTANT_CLERK");
    }

    @Test(groups = {"all1", "all"})
    public void companionshipsSisters_WARD_EXECUTIVE_SECRETARY() throws Exception {
        companionshipsSistersSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_MEMBER1() throws Exception {
        companionshipsSistersSub("MEMBER1");
    }

    @Test(groups = {"all3", "all"})
    public void companionshipsSisters_MEMBER2() throws Exception {
        companionshipsSistersSub("MEMBER2");
    }

    @Test(groups = {"all4", "all", "daily", "daily2"})
    public void companionshipsSisters_ELDERS_QUORUM_PRESIDENT() throws Exception {
        companionshipsSistersSub("ELDERS_QUORUM_PRESIDENT");
    }

//    @Test(groups = {"all1", "all"})
//    public void companionshipsSisters_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
//        companionshipsSistersSub("ELDERS_QUORUM_FIRST_COUNSELOR");
//    }
//
//    @Test(groups = {"all2", "all"})
//    public void companionshipsSisters_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
//        companionshipsSistersSub("ELDERS_QUORUM_SECOND_COUNSELOR");
//    }
//
//    @Test(groups = {"all3", "all"})
//    public void companionshipsSisters_ELDERS_QUORUM_SECRETARY() throws Exception {
//        companionshipsSistersSub("ELDERS_QUORUM_SECRETARY");
//    }

    @Test(groups = {"all4", "all", "daily", "daily4"})
    public void companionshipsSisters_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        companionshipsSistersSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test(groups = {"all1", "all"})
    public void companionshipsSisters_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        companionshipsSistersSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test(groups = {"all2", "all"})
    public void companionshipsSisters_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        companionshipsSistersSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test(groups = {"all3", "all"})
    public void companionshipsSisters_YOUNG_WOMEN_PRESIDENT() throws Exception {
        HelperMethods myHelper = new HelperMethods();
        myHelper.proxyLogin("rosettelambson");
        myHelper.enterPin("1", "1", "3", "3");
        companionshipsSistersCheck(3);
    }


    public void companionshipsSistersSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheckNewRights(Integer.parseInt(callingRights[2]));
    }

    public void companionshipsSistersCheckNewRights(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights >= 4) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringSistersReport.click();

            myMinistering.validateDistrict("RS - 1st Counselor");
            myMinistering.validateDistrict("RS - 2nd Counselor");

            //Select District 1
            myMinistering.selectDistrict("RS - 1st Counselor");
            Thread.sleep(4000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Callahan", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS16", pageSource, "Contains"));
            myBasePage.backAltButton.click();

            //Select District 2
            myMinistering.selectDistrict("RS - 2nd Counselor");
            Thread.sleep(4000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Callahan", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS16", pageSource, "Contains"));
            myBasePage.backAltButton.click();
        }

        if (rights == 1){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }

    }

    public void companionshipsSistersCheck(int rights) throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        MinisteringScreen myMinistering = new MinisteringScreen(driver);

        if (rights <= 3) {
            myMenu.selectMenu(myMenu.reports);
            myMinistering.ministeringSistersReport.click();

            myMinistering.validateDistrict("RS - 1st Counselor");
            myMinistering.validateDistrict("RS - 2nd Counselor");

            //Select District 1
            myMinistering.selectDistrict("RS - 1st Counselor");
            Thread.sleep(4000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Callahan", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS16", pageSource, "Contains"));
            myBasePage.backAltButton.click();

            //Select District 2
            myMinistering.selectDistrict("RS - 2nd Counselor");
            Thread.sleep(4000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Callahan", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("LDS16", pageSource, "Contains"));
            myBasePage.backAltButton.click();
        }

        if (rights == 4){
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }

    }

    public void ministeringBasicSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        ministeringBasicCheckNewRights(Integer.parseInt(callingRights[2]));
    }


//    @Test (groups = {"all2", "all", "smoke", "smoke2"})
//    public void ministeringBasic_BISHOP() throws Exception {
//        HelperMethods myHelper = new HelperMethods();
//        myHelper.proxyLogin("mbthomas74");
//        myHelper.enterPin("1", "1", "3", "3");
//        ministeringBasicCheck(1);
//    }


//
//
//    private void assignedMinisteringBrothers() throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        String pageSource;
//
//        myMinistering.filters.click();
//        myMinistering.assignedMinisteringBrothers.click();
//        myMinistering.saveMissonaryProgressFilter();
//
//        Thread.sleep(1000);
//
//        //Check Data
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("AFPTen", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
//
//        //Clear Filter
//        clearFilter(myMinistering.assignedMinisteringBrothers);
//
//    }
//
//    private void notAssignedMinisteringBrothers() throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        String pageSource;
//
//        myMinistering.filters.click();
//        myMinistering.notAssignedMinisteringBrothers.click();
//        myMinistering.saveMissonaryProgressFilter();
//
//        Thread.sleep(1000);
//
//        //Check Data
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Han Solo", pageSource, "Contains"));
//
//        //Clear Filter
//        clearFilter(myMinistering.notAssignedMinisteringBrothers);
//
//    }
//
//    private void newAndMovedInMembers() throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        String pageSource;
//
//        myMinistering.filters.click();
//        myMinistering.newAndMovedInMembers.click();
//        myMinistering.saveMissonaryProgressFilter();
//
//        Thread.sleep(1000);
//
//        //Check Data
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Mene", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Vader", pageSource, "Contains"));
//
//        //Clear Filter
//        clearFilter(myMinistering.newAndMovedInMembers);
//
//    }
//
//    private void ssAges18to30() throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        String pageSource;
//
//        myMinistering.filters.click();
//        myMinistering.singleSistersAges18to30.click();
//        myMinistering.saveMissonaryProgressFilter();
//
//        Thread.sleep(1000);
//
//        //Check Data
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Fagaesea", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Yoda", pageSource, "Contains"));
//
//        //Clear Filter
//        clearFilter(myMinistering.singleSistersAges18to30);
//
//    }
//
//    private void ssAge32AndOlder() throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        String pageSource;
//
//        myMinistering.filters.click();
//        myMinistering.singleSistersAge31AndOver.click();
//        myMinistering.saveMissonaryProgressFilter();
//
//        Thread.sleep(1000);
//        //Check Data
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Mace", pageSource, "Contains"));
//
//        //Clear Filter
//        clearFilter(myMinistering.singleSistersAge31AndOver);
//
//    }
//
//    private void sbAges18to30() throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        String pageSource;
//
//        myMinistering.filters.click();
//        myMinistering.singleBrothersAges18to30.click();
//        myMinistering.saveMissonaryProgressFilter();
//
//        Thread.sleep(1000);
//
//        //Check Data
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Anderson", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Kenobi", pageSource, "Contains"));
//
//        //Clear Filter
//        clearFilter(myMinistering.singleBrothersAges18to30);
//
//    }
//
//    private void sbAge32AndOlder() throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        String pageSource;
//
//        myMinistering.filters.click();
//        myMinistering.singleBrothersAge31AndOver.click();
//        myMinistering.saveMissonaryProgressFilter();
//
//        Thread.sleep(1000);
//
//        //Check Data
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEleven", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Anderson", pageSource, "Contains"));
//
//        //Clear Filter
//        clearFilter(myMinistering.singleBrothersAge31AndOver);
//
//    }
//
//
//
//    //******************* SISTERS **************************
//
//
//    private void assignedMinisteringSisters() throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        String pageSource;
//
//        myMinistering.filters.click();
//        myMinistering.assignedMinisteringSisters.click();
//        myMinistering.saveMissonaryProgressFilter();
//
//        Thread.sleep(1000);
//
//        //Check Data
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Aaron", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Bond", pageSource, "Contains"));
//
//        //Clear Filter
//        clearFilter(myMinistering.assignedMinisteringSisters);
//
//    }
//
//    private void notAssignedMinisteringSisters() throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        String pageSource;
//
//        myMinistering.filters.click();
//        myMinistering.notAssignedMinisteringSisters.click();
//        myMinistering.saveMissonaryProgressFilter();
//
//        Thread.sleep(1000);
//
//        //Check Data
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
//
//        //Clear Filter
//        clearFilter(myMinistering.notAssignedMinisteringSisters);
//
//    }
//
//    private void newAndMovedInMembersSisters() throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        String pageSource;
//
//        myMinistering.filters.click();
//        myMinistering.newAndMovedInMembers.click();
//        myMinistering.saveMissonaryProgressFilter();
//
//        Thread.sleep(1000);
//
//        //Check Data
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Mene", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
//
//        //Clear Filter
//        clearFilter(myMinistering.newAndMovedInMembers);
//
//    }
//
//    private void ssAges18to30Sisters() throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        String pageSource;
//
//        myMinistering.filters.click();
//        myMinistering.singleSistersAges18to30.click();
//        myMinistering.saveMissonaryProgressFilter();
//
//        Thread.sleep(1000);
//
//
//        //Check Data
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Ami", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
//
//        //Clear Filter
//        clearFilter(myMinistering.singleSistersAges18to30);
//
//    }
//
//    private void ssAge32AndOlderSisters() throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        String pageSource;
//
//        myMinistering.filters.click();
//        myMinistering.singleSistersAge31AndOver.click();
//        myMinistering.saveMissonaryProgressFilter();
//
//        Thread.sleep(1000);
//
//        //Check Data
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(myBasePage.checkNoCaseList("AFPEighteen", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("Skywalker", pageSource, "Contains"));
//
//        //Clear Filter
//        clearFilter(myMinistering.singleSistersAge31AndOver);
//
//    }
//

//
//
//    private void clearFilter(WebElement myElement) throws Exception {
//        MinisteringScreen myMinistering = new MinisteringScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//
//        if (getRunningOS().equals("ios")) {
//            myMinistering.filters.click();
//            myElement.click();
//            myBasePage.backAltButton.click();
//        } else {
//            Thread.sleep(1000);
//            //myMinistering.ministeringExpandFilter.click();
//            //Thread.sleep(9000);
//            myMinistering.ministeringRemoveFilter.click();
//        }
//    }
//

    //    @Test (groups = {"all4", "all"})
//    public void ministeringUnassignedHouseholds_BISHOP() throws Exception {
//        HelperMethods myHelper = new HelperMethods();
//        myHelper.proxyLogin("mbthomas74");
//        myHelper.enterPin("1", "1", "3", "3");
//        ministeringUnassignedHouseholdsCheck(1);
//    }





}
