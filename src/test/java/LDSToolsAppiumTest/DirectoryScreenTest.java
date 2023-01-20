package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.LoginPageScreen;
import LDSToolsAppium.Screen.MenuScreen;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import okhttp3.OkHttpClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class DirectoryScreenTest extends BaseDriver {



    @Test(groups = {"smoke2", "smoke", "all2", "all", "daily", "daily4", "jft"})
    public void directoryScreenTest_BISHOP() throws Exception {
        directoryScreenSub("BISHOP");
    }

    @Test(groups = {"all3", "all"})
    public void directoryScreenTest_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        directoryScreenSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void directoryScreenTest_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        directoryScreenSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test(groups = {"all1", "all"})
    public void directoryScreenTest_WARD_CLERK() throws Exception {
        directoryScreenSub("WARD_CLERK");
    }

    @Test(groups = {"all2", "all"})
    public void directoryScreenTest_WARD_ASSISTANT_CLERK() throws Exception {
        directoryScreenSub("WARD_ASSISTANT_CLERK");
    }

    @Test(groups = {"all3", "all"})
    public void directoryScreenTest_WARD_EXECUTIVE_SECRETARY() throws Exception {
        directoryScreenSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test(groups = {"all4", "all"})
    public void directoryScreenTest_MEMBER1() throws Exception {
        directoryScreenSub("MEMBER1");
    }

    @Test(groups = {"all1", "all"})
    public void directoryScreenTest_MEMBER2() throws Exception {
        directoryScreenSub("MEMBER2");
    }

    @Test(groups = {"all2", "all", "daily", "daily2"})
    public void directoryScreenTest_ELDERS_QUORUM_PRESIDENT() throws Exception {
        directoryScreenSub("ELDERS_QUORUM_PRESIDENT");
    }

    @Test(groups = {"all3", "all"})
    public void directoryScreenTest_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        directoryScreenSub("ELDERS_QUORUM_FIRST_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void directoryScreenTest_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        directoryScreenSub("ELDERS_QUORUM_SECOND_COUNSELOR");
    }

    @Test(groups = {"all1", "all"})
    public void directoryScreenTest_ELDERS_QUORUM_SECRETARY() throws Exception {
        directoryScreenSub("ELDERS_QUORUM_SECRETARY");
    }

    @Test(groups = {"all2", "all", "daily", "daily3"})
    public void directoryScreenTest_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        directoryScreenSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test(groups = {"all3", "all"})
    public void directoryScreenTest_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        directoryScreenSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void directoryScreenTest_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        directoryScreenSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test(groups = {"all1", "all", "daily", "daily4"})
    public void directoryScreenTest_YOUNG_WOMEN_PRESIDENT() throws Exception {
        directoryScreenSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test(groups = {"all2", "all"})
    public void directoryScreenTest_WOMEN_SECOND_COUNSELOR() throws Exception {
        directoryScreenSub("WOMEN_SECOND_COUNSELOR");
    }

//    @Test(groups = {"all3", "all"})
//    public void directoryScreenTest_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
//        directoryScreenSub("SUNDAY_SCHOOL_FIRST_COUNSELOR");
//    }


    @Test(groups = {"all4", "all"})
    public void directoryScreenTest_WARD_MISSION_LEADER() throws Exception {
        directoryScreenSub("WARD_MISSION_LEADER");
    }

    public void directoryJanDickson(int rights ) throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        myDirectory.searchAndClick("Dickson, Jan");

        //Get all info
        Thread.sleep(4000);
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        myBasePage.rightsCheck("Centinela", 4, rights, pageSource);

        myBasePage.rightsCheck("JanDic60@yahoo.com", 4, rights, pageSource);
        myBasePage.rightsCheck("cedickson@sbcglobal.net", 4, rights, pageSource);
        myBasePage.rightsCheck("754-215-9330", 4, rights, pageSource);
        myBasePage.rightsCheck("310-643-8800", 4, rights, pageSource);

        myBasePage.rightsCheck("5420 W 140th St", 4, rights, pageSource);
        myBasePage.rightsCheck("Hawthorne, California 90250-6402", 4, rights, pageSource);

        myBasePage.rightsCheck("33.9", 4, rights, pageSource);
        myBasePage.rightsCheck("-118.3", 4, rights, pageSource);

        //Membership Information
        myBasePage.rightsCheck("MEMBERSHIP INFORMATION", 3, rights, pageSource);
//        myBasePage.rightsCheck("FULL NAME", 2, rights, pageSource);
        myBasePage.rightsCheck("Dickson", 4, rights, pageSource);
        myBasePage.rightsCheck("Emma", 1, rights, pageSource);
        myBasePage.rightsCheck("Jan", 4, rights, pageSource);

        myBasePage.rightsCheck("Temple Recommend", 1, rights, pageSource);


        myBasePage.rightsCheck("Record Number", 1, rights, pageSource);
        myBasePage.rightsCheck("000-1189-3575", 1, rights, pageSource);

        //Birth Date
        myBasePage.rightsCheck("January 20, 1946", 2, rights, pageSource);
        myBasePage.rightsCheck("Birth Date", 3, rights, pageSource);
        if (getRunningOS().equals("ios")) {
            myBasePage.rightsCheck("(74)", 2, rights, pageSource);
            //Temple Recommend
            myBasePage.rightsCheck("November 2021", 1, rights, pageSource);
        } else {
            myBasePage.rightsCheck("- 74", 2, rights, pageSource);
            //Temple Recommend
            myBasePage.rightsCheck("Nov 2021", 1, rights, pageSource);
        }


        //Ordinances
        myBasePage.rightsCheck("Ordinances", 1, rights, pageSource);
        myBasePage.rightsCheck("Baptism", 1, rights, pageSource);
        myBasePage.rightsCheck("February 6, 1954", 1, rights, pageSource);
        myBasePage.rightsCheck("Confirmation", 1, rights, pageSource);
        myBasePage.rightsCheck("February 7, 1954", 1, rights, pageSource);
        myBasePage.rightsCheck("Endowment", 1, rights, pageSource);
        myBasePage.rightsCheck("March 23, 1967", 1, rights, pageSource);


        //Marriage
        myBasePage.rightsCheck("MARRIAGE", 1, rights, pageSource);
        myBasePage.rightsCheck("Spouse", 1, rights, pageSource);
        myBasePage.rightsCheck("Dickson, Clarence Eugene", 1, rights, pageSource);
        myBasePage.rightsCheck("Spouse Birth Date", 1, rights, pageSource);
        myBasePage.rightsCheck("September 9, 1944", 1, rights, pageSource);
        myBasePage.rightsCheck("Marriage Date", 1, rights, pageSource);
        myBasePage.rightsCheck("July 21, 1967", 1, rights, pageSource);
        myBasePage.rightsCheck("Marriage Place", 1, rights, pageSource);
        myBasePage.rightsCheck("Los Angeles, Los Angeles, California", 1, rights, pageSource);
        myBasePage.rightsCheck("Maiden Name", 1, rights, pageSource);

        //Other Information
        myBasePage.rightsCheck("Gender", 3, rights, pageSource);
        myBasePage.rightsCheck("Female", 3, rights, pageSource);
        myBasePage.rightsCheck("Gudmundson, Emma Jan", 1, rights, pageSource);
        myBasePage.rightsCheck("Birthplace", 1, rights, pageSource);
        myBasePage.rightsCheck("Santa Monica, Los Angeles, Cal", 1, rights, pageSource);
        myBasePage.rightsCheck("Birth Country", 1, rights, pageSource);
        myBasePage.rightsCheck("United States", 1, rights, pageSource);
        myBasePage.rightsCheck("Father", 1, rights, pageSource);
        myBasePage.rightsCheck("Gudmundson, Guy Leland", 1, rights, pageSource);
        myBasePage.rightsCheck("Mother", 1, rights, pageSource);
        myBasePage.rightsCheck("Shaffer, Nora", 1, rights, pageSource);
//        myBasePage.rightsCheck("Prior Unit", 2, rights, pageSource);



        //Callings and Classes - New in 3.0.0
        myBasePage.rightsCheck("Sunday School Teacher", 4, rights, pageSource);
//        myBasePage.rightsCheck("Gospel Doctrine", 4, rights, pageSource);
//        myBasePage.rightsCheck("Class Assignments", 3, rights, pageSource);
//        myBasePage.rightsCheck("Relief Society", 3, rights, pageSource);
    }

    public void directoryJanDicksonNewRights(int rights ) throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        myDirectory.searchAndClick("Dickson, Jan");

        //Get all info
        Thread.sleep(4000);
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        myBasePage.rightsCheckNewRights("Centinela", 1, rights, pageSource);

        myBasePage.rightsCheckNewRights("JanDic60@yahoo.com", 1, rights, pageSource);
        myBasePage.rightsCheckNewRights("cedickson@sbcglobal.net", 1, rights, pageSource);
        myBasePage.rightsCheckNewRights("754-215-9330", 1, rights, pageSource);
        myBasePage.rightsCheckNewRights("310-643-8800", 1, rights, pageSource);

        myBasePage.rightsCheckNewRights("5420 W 140th St", 1, rights, pageSource);
        myBasePage.rightsCheckNewRights("Hawthorne, California 90250-6402", 1, rights, pageSource);

        myBasePage.rightsCheckNewRights("33.9", 1, rights, pageSource);
        myBasePage.rightsCheckNewRights("-118.3", 1, rights, pageSource);

        //Membership Information
        myBasePage.rightsCheckNewRights("MEMBERSHIP INFORMATION", 4, rights, pageSource);
//        myBasePage.rightsCheck("FULL NAME", 2, rights, pageSource);
        myBasePage.rightsCheckNewRights("Dickson", 1, rights, pageSource);
        myBasePage.rightsCheckNewRights("Emma", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Jan", 1, rights, pageSource);

        myBasePage.rightsCheckNewRights("Temple Recommend", 6, rights, pageSource);


        myBasePage.rightsCheckNewRights("Record Number", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("000-1189-3575", 6, rights, pageSource);

        //Birth Date
        myBasePage.rightsCheckNewRights("January 20, 1946", 5, rights, pageSource);
        myBasePage.rightsCheckNewRights("Birth Date", 4, rights, pageSource);
        if (getRunningOS().equals("ios")) {
            myBasePage.rightsCheckNewRights("(77)", 5, rights, pageSource);
            //Temple Recommend
            myBasePage.rightsCheckNewRights("October 2023", 6, rights, pageSource);
        } else {
            myBasePage.rightsCheckNewRights("- 77", 5, rights, pageSource);
            //Temple Recommend
            myBasePage.rightsCheckNewRights("Oct 2023", 6, rights, pageSource);
        }


        //Ordinances
        myBasePage.rightsCheckNewRights("Ordinances", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Baptism", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("February 6, 1954", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Confirmation", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("February 7, 1954", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Endowment", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("March 23, 1967", 6, rights, pageSource);


        //Marriage
        myBasePage.rightsCheckNewRights("MARRIAGE", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Spouse", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Dickson, Clarence Eugene", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Spouse Birth Date", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("September 9, 1944", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Marriage Date", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("July 21, 1967", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Marriage Place", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Los Angeles, Los Angeles, California", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Maiden Name", 6, rights, pageSource);

        //Other Information
        myBasePage.rightsCheckNewRights("Gender", 4, rights, pageSource);
        myBasePage.rightsCheckNewRights("Female", 4, rights, pageSource);
        myBasePage.rightsCheckNewRights("Gudmundson, Emma Jan", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Birthplace", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Santa Monica, Los Angeles, Cal", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Birth Country", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("United States", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Father", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Gudmundson, Guy Leland", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Mother", 6, rights, pageSource);
        myBasePage.rightsCheckNewRights("Shaffer, Nora", 6, rights, pageSource);
//        myBasePage.rightsCheck("Prior Unit", 2, rights, pageSource);



        //Callings and Classes - New in 3.0.0
        myBasePage.rightsCheckNewRights("Sunday School Teacher", 1, rights, pageSource);
//        myBasePage.rightsCheck("Gospel Doctrine", 4, rights, pageSource);
//        myBasePage.rightsCheck("Class Assignments", 3, rights, pageSource);
//        myBasePage.rightsCheck("Relief Society", 3, rights, pageSource);
    }




    @Test(groups = {"all3", "all", "daily", "daily1"})
    public void directoryMemberInfoHousehold() throws Exception {

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("mbthomas74");
        myHelper.enterPin("1", "1", "3", "3");

        if (myBasePage.getOS().contains("ios")) {
            myDirectory.searchAndClickHousehold("Ryan, Ken & Julie");
            Thread.sleep(1000);
            myBasePage.clickByTextContains("Ryan, Ken");
        } else {
            myDirectory.searchAndClickHousehold("Ryan, Ken");
        }

//        checkMemberInfoBishop();
//        checkMemberInfoFaimeaitaSeuamuli();
        checkMemberInfoKenRyan();

    }

    @Test(groups = {"all3", "all", "daily", "daily2"})
    public void directoryMemberInfoIndividual() throws Exception {
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);

        //Login and enter in PIN
//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("mbthomas74");
        myHelper.enterPin("1", "1", "3", "3");

        //Search and click on Aaron Jane
        myDirectory.searchAndClick("Ryan, Ken");
//        myDirectory.searchAndClick("Seuamuli, Faimeaita");

//        checkMemberInfoBishop();
//        checkMemberInfoFaimeaitaSeuamuli();
        checkMemberInfoKenRyan();
    }

    @Test(groups = {"goat"}, invocationCount = 10)
    public void directoryLoginTest() throws Exception {
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        String pageSource;

        myHelper.proxyLogin("mbthomas74");
        myHelper.enterPin("1", "1", "3", "3");
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.scrollDownIOS();
        }
        pageSource = myBasePage.getSourceOfPage();
//        System.out.println(pageSource);
        Assert.assertTrue(myBasePage.checkNoCaseList("Directory", pageSource, "Contains"));

        //Just to cause a failure for testing.
//        Assert.assertTrue(myBasePage.checkNoCaseList("WOOKIES!!!!!", pageSource, "Contains"));
    }


    private void checkMemberInfoBishop() throws Exception {
        String pageSource;

        // ********* Constructor **********
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        Assert.assertTrue(myBasePage.checkNoCaseList("Oline", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Vili", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Priesthood Office", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("High Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Record Number", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("052-0013-4906", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 17, 1969", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Baptism", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 27, 1980", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Confirmation", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 27, 1980", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("November 6, 1988", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained High Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("April 20, 2003", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Bishop", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("April 23, 2017", pageSource, "Contains"));


        Assert.assertTrue(myBasePage.checkNoCaseList("Sealed to Parents", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 9, 1983", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Endowment", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("December 11, 2002", pageSource, "Contains"));



        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mailata, Faapepele", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("February 18, 1973", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("March 3, 1996", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Place", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Avao, Savaii, Samoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sealing Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("December 11, 2002", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Temple", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Apia Samoa Temple", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Gender", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Male", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birthplace", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Avao, Savaii, Samoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Country", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Western Samoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Father", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Lealaiauloto, Sao Oline", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mother", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Solo, Melesa Asovale", pageSource, "Contains"));

//        Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Priests Quorum President", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Class Assignments", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("High Priests Quorum", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Gospel Doctrine", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum", pageSource, "Contains"));

    }


    private void checkMemberInfoKenRyan() throws Exception {
        String pageSource;

        // ********* Constructor **********
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        Assert.assertTrue(myBasePage.checkNoCaseList("Ryan", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ken", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Priesthood Office", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("High Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Record Number", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("000-4334-9951", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("May 27, 1962", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Baptism", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("August 8, 1982", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Confirmation", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("August 8, 1982", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("March 27, 1988", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("March 19, 1989", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained High Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("August 6, 2017", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Endowment", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("June 17, 1989", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Sealed to Spouse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("June 24, 1989", pageSource, "Contains"));


        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ryan, Julie Lynn", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("June 5, 1963", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("March 10, 1984", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Place", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Hawthorne, Los Angeles, CA", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sealing Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("June 24, 1989", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Temple", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Los Angeles California Temple", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Gender", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Male", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birthplace", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Redondo Beach, Los Angeles, CA", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Country", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("United States", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Father", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ryan, William Joseph", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mother", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("McElveen, Thelma Amiliea", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Ward Assistant Clerk", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("Sustained", pageSource, "Contains"));
//        Assert.assertTrue(myBasePage.checkNoCaseList("February 25, 2018", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Class Assignments", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Gospel Doctrine", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum", pageSource, "Contains"));

    }




    private void checkMemberInfoFaimeaitaSeuamuli() throws Exception {
        String pageSource;

        // ********* Constructor **********
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();

        //General Information
        Assert.assertTrue(myBasePage.checkNoCaseList("Seuamuli", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Faimeaita", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Priesthood Office", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("High Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Record Number", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("052-0013-5317", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("November 27, 1957", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Baptism", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("November 20, 1984", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Confirmation", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("November 20, 1984", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained Elder", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("April 16, 1995", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Ordained High Priest", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("September 1, 2013", pageSource, "Contains"));


        Assert.assertTrue(myBasePage.checkNoCaseList("Sealed to Spouse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("December 1, 1999", pageSource, "Contains"));


        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Aumoto, Alofa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Spouse Birth Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("August 12, 1961", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("October 20, 1984", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Marriage Place", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Fagamalo, Savaii, Samoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sealing Date", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("December 1, 1999", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Temple", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Apia Samoa Temple", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Gender", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Male", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birthplace", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Avao, Savaii, Samoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Birth Country", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Western Samoa", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Father", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Seuamuli, Seleni", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Mother", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Seleni, Seine", pageSource, "Contains"));

        Assert.assertTrue(myBasePage.checkNoCaseList("Sunday School First Counselor", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Sustained", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("February 25, 2018", pageSource, "Contains"));


        Assert.assertTrue(myBasePage.checkNoCaseList("Class Assignments", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Gospel Doctrine", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Elders Quorum", pageSource, "Contains"));

    }





    @Test(groups = {"notValid"})
    public void directoryMemberInfoNonLeaderNoPassword() throws Exception {
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        if (myBasePage.getOS().equals("ios")) {
            myHelper.proxyLogin("dcbryson");
            myHelper.nonLeaderNoPin();
            myDirectory.searchAndClick("Bryson, David");
            myBasePage.scrollToTextiOS("Membership Information");
            myDirectory.memebershipInformation.click();
        } else {
            System.out.println("Test not valid for Android");
        }

    }


    @Test(groups = {"all2", "all", "daily", "daily3"})
    public void directoryLatLongNoGPS() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login as Bishop
        myHelper.proxyLogin("galok");
//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Alapati, James");

        Assert.assertTrue(myBasePage.checkForElement(myDirectory.gpsHouseholdLocationMissing));

        //Get all info
        pageSource = myDirectory.getDirectoryUserData();
        Assert.assertTrue(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));

    }

//    @Test(groups = {"needUpdate"})
    @Test(groups = {"all3", "all", "daily", "daily4"})
    public void directoryLatLongNoGPSNoCalling() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login as member with no calling
        myHelper.proxyLogin("Afualoma");
//        myHelper.loginUAT("LDSTools5", "toolstester");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Aiulu, Talatau");

        //Get all info
        Thread.sleep(500);
        pageSource = myDirectory.getDirectoryUserData();

        if (myBasePage.getOS().contains("ios")) {
            Assert.assertTrue(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));
        } else {
            Assert.assertFalse(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));
        }

        Assert.assertFalse(myBasePage.checkNoCaseList("Adjust Household Location", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("We're unable to geo-locate your household. Use your GPS to locate it.", pageSource, "Contains"));



    }


    @Test(groups = {"all3", "all", "daily", "daily1"})
    public void directoryLatLongCheckLocation() throws Exception {

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login as Bishop
        myHelper.proxyLogin("galok");
        myHelper.enterPin("1", "1", "3", "3");

//        myDirectory.searchAndClick("Pipi, Mafoe");

        if (myBasePage.getOS().contains("ios")) {
            myDirectory.searchAndClickHousehold("Loion, Leone");
//            myBasePage.clickByTextContains("Pipi");
//            myBasePage.scrollDownIOS();
            myBasePage.scrollToTextGeneral("Adjust Household Location");
        } else {
            myDirectory.searchAndClickHousehold("Loion, Leone");
        }

        Assert.assertTrue(myBasePage.checkForElement(myDirectory.gpsAdjustHouseholdLocationLowerCase));
//        Assert.assertFalse(myBasePage.checkForElement(myDirectory.gpsHouseholdLocationMissing));

    }

    //TODO: LAT - Long Need to update user and use new api
    @Test(groups = {"needUpdate"})
//    @Test(dataProvider = "Members", groups = {"all4", "all"})
    public void directoryLatLongNoGPSChooseLocation(String userName, String passWord, String rightsString, String callingGroup) throws Exception {
        String pageSource;
        int rights = Integer.parseInt(rightsString);


        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        // Reset the Lat Long
        resetLatLong("8999999998895108", "258598");

        //Login and enter in PIN
        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        System.out.println("Calling Group: " + callingGroup);


        myDirectory.searchAndClick("Tools, LDS24");

        if (rights <= 3) {
            Assert.assertTrue(myBasePage.checkForElement(myDirectory.gpsHouseholdLocationMissing));

            myDirectory.gpsAdjustHouseholdLocation.click();
            myDirectory.gpsAllowOK.click();

            Thread.sleep(2000);

            if (getRunningOS().equals("ios")) {
                myDirectory.gpsAdjustLocationButton.click();
            } else {
                myBasePage.allowButton.click();
            }

            myDirectory.gpsSearch.sendKeys("3732 Bryce Canyon Dr, Riverton, Utah");

            Thread.sleep(10000);

            myBasePage.clickByText("3732 Bryce Canyon Dr, Riverton, Utah, USA");
            Thread.sleep(5000);



            if (getRunningOS().equals("ios")) {
                myBasePage.iosClickUseThisLocation();
            } else {
                myDirectory.gpsUseThisLocation.click();
            }

            Thread.sleep(2000);

            pageSource = myBasePage.getSourceOfPage();


            Assert.assertTrue(myBasePage.checkNoCaseList("40.5152", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("-111.9800", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));


            //Log out - Log in check the location
            myBasePage.backToDirectory();

            myMenu.menuLogOut();
            myHelper.loginUAT(userName, passWord);
            myHelper.enterPin("1", "1", "3", "3");

            myDirectory.searchAndClick("Tools, LDS24");

            Thread.sleep(2000);

            pageSource = myBasePage.getSourceOfPage();


            Assert.assertTrue(myBasePage.checkNoCaseList("40.5152", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("-111.9800", pageSource, "Contains"));
            Assert.assertFalse(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));

        } else {

            pageSource = myBasePage.getSourceOfPage();
            if (getRunningOS().equals("ios")) {
                Assert.assertTrue(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Adjust Household Location", pageSource, "Contains"));
            } else {
                Assert.assertFalse(myBasePage.checkNoCaseList("Household Location Missing", pageSource, "Contains"));
                Assert.assertFalse(myBasePage.checkNoCaseList("Adjust Household Location", pageSource, "Contains"));
            }
        }
    }

    private void resetLatLong(String headOfHouseId, String unitNumber) {
        OkHttpClient client = new OkHttpClient();

        try {
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n  \"householdLocations\": [\n    {\n      \"headOfHouseIndividualId\": " + headOfHouseId +",\n      \"unitNbr\": " + unitNumber +"\n    }\n  ]\n}\n");
            Request request = new Request.Builder()
                    .url("https://ws-int.ldschurch.org/MLU-Services/v1.9/Services/rest/member/householdLocation?headOfHouseMemberId=%22" + headOfHouseId + "%22&latitude=null&longitude=null&locallyVerifiedCode=null&unitNbr=" + unitNumber)
                    .post(body)
                    .addHeader("authorization", "Basic ZGlyZWN0b3J5OnNlZWtBbmRGaW5k")
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b82ed705-20f4-ef63-9575-b3b091ffc0bb")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println("Response Code: " + response.code());



        } catch (IOException e) {
            e.printStackTrace();
        }


    }


//    @Test(groups = {"NotUsed"})
//    public void directoryLoginSpeedCheck() throws Exception {
//        long startTime;
//        long endTime;
//        long duration;
//
//        // ********* Constructor **********
//        HelperMethods myHelper = new HelperMethods();
//        DirectoryScreen myDirectory = new DirectoryScreen(driver);
//        MenuScreen myMenu = new MenuScreen(driver);
//        BasePage myBasePage = new BasePage(driver);
//        BaseDriver myBaseDriver = new BaseDriver();
//        LoginPageScreen myLoginPage = new LoginPageScreen(driver);
//
////        byte[] encodeBytes = Base64.encodeBase64("toolstester".getBytes());
////        System.out.println("Encoded Bytes: " + new String(encodeBytes));
//
//
//
//        byte[] decodeBytes = Base64.decodeBase64("UDFrQFNwMTc=");
////        System.out.println("Decoded Bytes: " + new String(decodeBytes));
//
//
//
//        //Copy file to device
//        if (getRunningOS().equalsIgnoreCase("ios")) {
////            ((IOSDriver)driver).pushFile("Image-1.jpg", new File("/Users/zmaxfield/Image-1.jpg"));
////            driver.context("WEBVIEW");
//            if (myBasePage.checkForElement(myHelper.allowButton)) {
//                myHelper.allowButton.click();
//            }
//
////            driver.get("http://10.109.45.163:8000");
//            driver.get("https://www.google.com");
//            Thread.sleep(2000);
//            driver.get("membertools://user/digbads");
//            Thread.sleep(5000);
////            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='DeepLinkTest.html']")).click();
////            Thread.sleep(2000);
////            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Deep Link Test']")).click();
////            Thread.sleep(5000);
////
////            Thread.sleep(5000);
//
////            myLoginPage.loginName.clear();
////            myLoginPage.passWord.clear();
////
////            myLoginPage.loginName.sendKeys("zmaxfield");
////            myLoginPage.passWord.sendKeys(new String(decodeBytes));
////            myLoginPage.signInButton.click();
////            Thread.sleep(20000);
////            System.out.println(driver.getPageSource());
////            driver.context("NATIVE_APP");
//        } else {
//
////            myLoginPage.troubleSigningIn.click();
////            Thread.sleep(5000);
////
////            driver.findElement(By.id("com.android.chrome:id/url_bar")).click();
////            driver.findElement(By.id("com.android.chrome:id/url_bar")).setValue("http://10.0.0.110:8000");
////
////            ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));
////            Thread.sleep(5000);
////            System.out.println(driver.getPageSource());
////            driver.findElement(By.xpath("//*[@text='DeepLinkTest.html']")).click();
////            Thread.sleep(2000);
////            driver.findElement(By.xpath("//*[@text='Deep Link Test']")).click();
////            Thread.sleep(5000);
////            driver.findElement(By.xpath("//*[@text='Open']")).click();
////            Thread.sleep(5000);
//
//           myBaseDriver.adbProxyStart(myBaseDriver.deviceSerial, "digbads");
//
//        }
//
//
//        myLoginPage.loginName.clear();
//        myLoginPage.passWord.clear();
//
//        myLoginPage.loginName.sendKeys("zmaxfield");
//        myLoginPage.passWord.sendKeys(new String(decodeBytes));
//        myLoginPage.signInButton.click();
//        Thread.sleep(30000);
//
//
//
//        Assert.assertTrue(myDirectory.checkFirstDirectoryUser());
//        myMenu.selectMenu(myMenu.settings);
//        Thread.sleep(2000);
//        myMenu.selectMenu(myMenu.directory);
//        Thread.sleep(2000);
//        Assert.assertTrue(myBasePage.checkForElement(myMenu.reports));
//
//
//    }


    @Test(groups = {"notUsed"})
    public void testJunitReport() throws Exception {
        MemberToolsAPI myApi = new MemberToolsAPI();
//        myApi.toolsService();
        myApi.apiRequest();


    }



    @Test(dataProvider = "Members", groups = {"notUsed"})
    public void directoryScrollTest(String userName, String passWord, String rightsString, String callingGroup) throws Exception {
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
        myHelper.loginUAT(userName, passWord);
        myHelper.enterPin("1", "1", "3", "3");

        //myBasePage.scrollDownTEST(100);


        myBasePage.scrollDownAndroidUIAutomator("0");
        Thread.sleep(10000);
        myBasePage.scrollUpAndroidUIAutomator("0");


    }

    public void directoryScreenSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        directoryJanDicksonNewRights(Integer.parseInt(callingRights[2]));
    }



//    @Test(dataProvider = "Members", groups = {"smoke2", "smoke", "all2", "all"})
//    public void directoryScreenTest(String userName, String passWord, String rightsString, String callingGroup) throws Exception {
//        int rights = Integer.parseInt(rightsString);
//        // ********* Constructor **********
//        HelperMethods myHelper = new HelperMethods();
//        //Login and enter in PIN
//        myHelper.proxyLogin(userName);
//        myHelper.enterPin("1", "1", "3", "3");
//        directoryJanDickson(rights);
//    }


//    public void directoryScreenTest_JFT() throws Exception {
//        String[] callingRights;
//        HelperMethods myHelper = new HelperMethods();
//        callingRights = myHelper.getMemberNameFromList("MEMBER1");
//        myHelper.proxyLogin(callingRights[1]);
//        myHelper.enterPin("1", "1", "3", "3");
//        directoryJanDicksonNewRights(Integer.parseInt(callingRights[2]));
//    }


//    @Test(groups = {"smoke2", "smoke", "all2", "all"})
//    public void directoryScreenTest_BISHOP() throws Exception {
//        HelperMethods myHelper = new HelperMethods();
//        myHelper.proxyLogin("mbthomas74");
//        myHelper.enterPin("1", "1", "3", "3");
//        directoryJanDickson(1);
//    }




}
