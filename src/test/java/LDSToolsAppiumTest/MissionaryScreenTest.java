package LDSToolsAppiumTest;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class MissionaryScreenTest extends BaseDriver {


    @Test (groups = {"smoke3", "smoke", "all3", "all", "daily", "daily1"})
    public void missionaryTest_BISHOP() throws Exception {
        missionaryTestCheckSub("BISHOP");
    }

    @Test (groups = {"all2", "all"})
    public void missionaryTest_BISHOPRIC_FIRST_COUNSELOR() throws Exception {
        missionaryTestCheckSub("BISHOPRIC_FIRST_COUNSELOR");
    }

    @Test(groups = {"all1", "all"})
    public void missionaryTest_BISHOPRIC_SECOND_COUNSELOR() throws Exception {
        missionaryTestCheckSub("BISHOPRIC_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void missionaryTest_WARD_CLERK() throws Exception {
        missionaryTestCheckSub("WARD_CLERK");
    }

    @Test(groups = {"all3", "all"})
    public void missionaryTest_WARD_ASSISTANT_CLERK() throws Exception {
        missionaryTestCheckSub("WARD_ASSISTANT_CLERK");
    }

    @Test(groups = {"all2", "all"})
    public void missionaryTest_WARD_EXECUTIVE_SECRETARY() throws Exception {
        missionaryTestCheckSub("WARD_EXECUTIVE_SECRETARY");
    }

    @Test(groups = {"all1", "all"})
    public void missionaryTest_MEMBER1() throws Exception {
        missionaryTestCheckSub("MEMBER1");
    }

    @Test(groups = {"all4", "all"})
    public void missionaryTest_MEMBER2() throws Exception {
        missionaryTestCheckSub("MEMBER2");
    }

    @Test(groups = {"all3", "all", "daily", "daily2"})
    public void missionaryTest_ELDERS_QUORUM_PRESIDENT() throws Exception {
        missionaryTestCheckSub("ELDERS_QUORUM_PRESIDENT");
    }

    @Test(groups = {"all2", "all"})
    public void missionaryTest_ELDERS_QUORUM_FIRST_COUNSELOR() throws Exception {
        missionaryTestCheckSub("ELDERS_QUORUM_FIRST_COUNSELOR");
    }

    @Test(groups = {"all1", "all"})
    public void missionaryTest_ELDERS_QUORUM_SECOND_COUNSELOR() throws Exception {
        missionaryTestCheckSub("ELDERS_QUORUM_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all"})
    public void missionaryTest_ELDERS_QUORUM_SECRETARY() throws Exception {
        missionaryTestCheckSub("ELDERS_QUORUM_SECRETARY");
    }

    @Test(groups = {"all3", "all", "daily", "daily3"})
    public void missionaryTest_RELIEF_SOCIETY_PRESIDENT() throws Exception {
        missionaryTestCheckSub("RELIEF_SOCIETY_PRESIDENT");
    }

    @Test(groups = {"all2", "all"})
    public void missionaryTest_RELIEF_SOCIETY_FIRST_COUNSELOR() throws Exception {
        missionaryTestCheckSub("RELIEF_SOCIETY_FIRST_COUNSELOR");
    }

    @Test(groups = {"all1", "all"})
    public void missionaryTest_RELIEF_SOCIETY_SECOND_COUNSELOR() throws Exception {
        missionaryTestCheckSub("RELIEF_SOCIETY_SECOND_COUNSELOR");
    }

    @Test(groups = {"all4", "all", "daily", "daily4"})
    public void missionaryTest_YOUNG_WOMEN_PRESIDENT() throws Exception {
        missionaryTestCheckSub("YOUNG_WOMEN_PRESIDENT");
    }

    @Test(groups = {"all3", "all"})
    public void missionaryTest_WOMEN_SECOND_COUNSELOR() throws Exception {
        missionaryTestCheckSub("WOMEN_SECOND_COUNSELOR");
    }

    @Test(groups = {"all2", "all"})
    public void missionaryTest_SUNDAY_SCHOOL_FIRST_COUNSELOR() throws Exception {
        missionaryTestCheckSub("SUNDAY_SCHOOL_FIRST_COUNSELOR");
    }

    @Test(groups = {"all1", "all"})
    public void missionaryTest_WARD_MISSION_LEADER() throws Exception {
        missionaryTestCheckSub("WARD_MISSION_LEADER");
    }

    public void missionaryTestCheckSub(String callingForMember) throws Exception {
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(callingForMember, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        missionaryTestCheckNewRights(Integer.parseInt(callingRights[2]));
    }

    public void missionaryTestCheckNewRights(int rights) throws Exception {
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();
        List<String> memberList = new ArrayList<String>();
        List<String> memberListIos = new ArrayList<String>();

        String pageSource;
        String memberFirstName;
        String memberLastName;

        myMenu.selectMenu(myMenu.missionary);

        myBasePage.waitForElementThenClick(myMissionary.sendReferralButton);
        myBasePage.waitForElementThenClick(myMissionary.cancelReferralButton);
        pageSource = myMissionary.getMissionaryPage();

        //Check Assigned Missionaries
        memberList = apiTest.getAssignedMissionaries("mbthomas74", "21628");
        myBasePage.apiCheckDataPageSource(memberList, pageSource);

        //Check Serving Missionaries
        memberList = apiTest.getServingMissionaries("mbthomas74", "21628");
        myBasePage.apiCheckDataPageSource(memberList, pageSource);

        //Check Ward Missionaries
        memberList = apiTest.getOrganizationMembers("Ward Missionaries", "mbthomas74", "21628");
        if (getRunningOS().equalsIgnoreCase("ios")) {
            memberListIos = myBasePage.swapLastNameCommaFirstName(memberList);
            memberList = memberListIos;
        }
        myBasePage.apiCheckDataPageSource(memberList, pageSource);
    }


//    @Test(dataProvider = "Members", groups = {"smoke3", "smoke", "all3", "all"})
    public void missionaryTest(String userName, String passWord, String rightsString, String calling) throws Exception {
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();
        List<String> memberList = new ArrayList<String>();
        List<String> memberListIos = new ArrayList<String>();

        String pageSource;
        String memberFirstName;
        String memberLastName;
        int rights = Integer.parseInt(rightsString);

        myHelper.proxyLogin(userName);
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.missionary);

        myMissionary.sendReferralButton.click();
        Thread.sleep(3000);
        myMissionary.cancelReferralButton.click();
        pageSource = myMissionary.getMissionaryPage();

        //Check Assigned Missionaries
        memberList = apiTest.getAssignedMissionaries("mbthomas74", "21628");
        myBasePage.apiCheckDataPageSource(memberList, pageSource);

        //Check Serving Missionaries
        memberList = apiTest.getServingMissionaries("mbthomas74", "21628");
        myBasePage.apiCheckDataPageSource(memberList, pageSource);

        //Check Ward Missionaries
        memberList = apiTest.getOrganizationMembers("Ward Missionaries", "mbthomas74", "21628");
        if (getRunningOS().equalsIgnoreCase("ios")) {
            memberListIos = myBasePage.swapLastNameCommaFirstName(memberList);
            memberList = memberListIos;
        }
        myBasePage.apiCheckDataPageSource(memberList, pageSource);

    }


    @Test(groups = {"all4", "all", "daily", "daily2", "jft"})
    public void missionaryOtherUnits() throws Exception {
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        String unitNumber;


        //Login and enter in PIN
        myHelper.proxyLogin("mbthomas74");
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.missionary);
        myBasePage.waitForElementThenClick(myMissionary.sendReferralButton);
        Thread.sleep(500);
        myBasePage.waitForElementThenClick(myMissionary.cancelReferralButton);

        //Centinela 1st Ward
        unitNumber = "21628";
        checkMissionaryByUnit(unitNumber);

        chooseUnit("Centinela 2nd Ward (Tongan)");
        unitNumber = "129798";
        checkMissionaryByUnit(unitNumber);

        chooseUnit("El Segundo Ward");
        unitNumber = "76228";
        checkMissionaryByUnit(unitNumber);

        chooseUnit("Figueroa Ward (Spanish)");
        unitNumber = "216496";
        checkMissionaryByUnit(unitNumber);

        chooseUnit("Southwest Los Angeles Branch");
        unitNumber = "141399";
        checkMissionaryByUnit(unitNumber);

        //iOS has 2 spaces between ward name and 1st ward
        if (getRunningOS().equalsIgnoreCase("ios")) {
            chooseUnit("Westchester  1st Ward");
        } else {
            chooseUnit("Westchester 1st Ward");
        }
        unitNumber = "21970";
        checkMissionaryByUnit(unitNumber);

        chooseUnit("Westchester 3rd Ward (Tongan)");
        unitNumber = "179388";
        checkMissionaryByUnit(unitNumber);

    }








    //TODO: Update for Social Media
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"all4", "all", "daily", "daily1", "jft"})
    public void missionaryReferralTest() throws Exception {
        //String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        String pageSource;

        //Login and enter in PIN

        myHelper.proxyLogin("Katalinav");
//        myHelper.loginUAT("LDSTools30", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        myMenu.selectMenu(myMenu.missionary);

        myMissionary.sendReferralButton.click();


        Thread.sleep(2000);
        //Check to see if the Members info is correct
        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(myBasePage.checkNoCaseList("310-8443946", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("katalina@clearfreight.com", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("zmaxfield", pageSource, "Contains"));

        myMissionary.referralName.setValue("Auto Test Name");
        myMissionary.referralPhone.setValue("801-867-5309");

        //System.out.println(myBasePage.getSourceOfPage());
        myBasePage.scrollToTextGeneral("Email");

        myMissionary.referralEmail.setValue("autotest@gmail.com");

        myBasePage.scrollToTextGeneral("Locate on Map");

        myMissionary.referralLocateOnMap.click();

        Thread.sleep(4000);

        //printPageSource();


        //Check to see if locations services has been turned on.
        if (getRunningOS().equals("ios")) {
            Thread.sleep(4000);
            myBasePage.allowWhileUsingApp.click();
//            driver.get().switchTo().alert().accept();

        } else {
            if (myBasePage.checkForElement(myBasePage.alertOK)) {
                myBasePage.alertOK.click();
                Thread.sleep(2000);
                myBasePage.allowWhileUsingApp.click();
            }
        }



        Thread.sleep(2000);
        myMissionary.referralMapSearch.setValue("920 Mocking Bird Ln, Sunnyvale");
        Thread.sleep(10000);

        myBasePage.clickByText("920 Mockingbird Ln, Sunnyvale, CA, USA");
        Thread.sleep(5000);


        if (getRunningOS().equals("ios")) {
            myBasePage.iosClickUseThisLocation();
        } else {
            myMissionary.referralUseThisLocation.click();
        }

        //Need a check for the text
        myBasePage.waitUnitlTextIsGone("Saving");


        //Need to finish this
        //clickButton("MissRefPreferredLang", "id", "pred");

        Thread.sleep(2000);

        if(getRunningOS().equals("ios")) {
            myBasePage.scrollDownIOS();
            myMissionary.referralAddMessageButton.click();
        } else {
            myBasePage.scrollToTextGeneral("SEND");
        }
//        System.out.println(myBasePage.getSourceOfPage());
        myMissionary.referralMessageField.setValue("Hello this is a test");

        if (getRunningOS().equals("ios")) {
            //driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Message']/following-sibling::XCUIElementTypeImage[@name='minus']")).click();
//            System.out.println(myBasePage.getSourceOfPage());
            myMissionary.referralCancelMessage.click();
            Thread.sleep(2000);
            myBasePage.scrollDownIOS();
            //driver.hideKeyboard();
            //myBasePage.scrollToText("MESSAGE FOR THE MISSIONARIES");
        }

        //printPageSource();
//        System.out.println(myBasePage.getSourceOfPage());
        myMissionary.referralSendReferral.click();

        //Check for icon to disappear
        Thread.sleep(4000);
        if (getRunningOS().equals("ios")) {
            myBasePage.waitUnitlTextIsGone("Processing");
        } else {
            myBasePage.waitUnitlTextIsGone("Sending Referral");
        }


        //Check Nice message
        Thread.sleep(20000);
//        myBasePage.alertOK.click();


//        There is something wrong with the Missionary progress in UAT
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Auto Test Name", pageSource, "Contains"));

        //Check referral
        myBasePage.clickByTextContains("Auto Test Name");

        Thread.sleep(2000);
        pageSource = driver.get().getPageSource();
        if (myBasePage.getOS().equals("mac")) {
            myBasePage.scrollDownTEST(400);
        } else {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }

        Thread.sleep(4000);
        pageSource = pageSource + driver.get().getPageSource();

        if (myBasePage.getOS().equals("mac")) {
            myBasePage.scrollDownTEST(400);
        } else {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }

        Thread.sleep(4000);
        pageSource = pageSource + driver.get().getPageSource();
        pageSource = pageSource.toLowerCase();
        if (pageSource.contains("pending")) {
            Assert.assertTrue(myBasePage.checkNoCaseList("status", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("pending assignment to missionaries", pageSource, "Contains"));
        } else {
            Assert.assertTrue(myBasePage.checkNoCaseList("Status", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Assigned to California San Jose Mission", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Elder", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("California San Jose Mission Office", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("408-578-9794", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Bishop", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Rodney B. Norling", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("408-733-8125", pageSource, "Contains"));

            if (myBasePage.getOS().equals("ios")) {
                Assert.assertTrue(myBasePage.checkNoCaseList("408-614-3854", pageSource, "Contains"));
                Assert.assertTrue(myBasePage.checkNoCaseList("@missionary.org", pageSource, "Contains"));

            }
        }



        //Remove Referral
        if (getRunningOS().equals("ios")) {
            myMissionary.referralRemove.click();
            myBasePage.alertOK.click();
        } else {
            myBasePage.backButton.click();
            myMissionary.referralOverflowButton.click();
            myMissionary.referralRemove.click();
//            myBasePage.alertOK.click();
            Thread.sleep(1000);
//            System.out.println(myBasePage.getSourceOfPage());
            myMissionary.referralRemoveFromList.click();
        }




    }

    //TODO: Need to update user
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"all4", "all"})
    public void missionaryReferralNoContactInfo() throws Exception {
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);


        String pageSource;

        //Login and enter in PIN
        myHelper.loginUAT("LDSTools45", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        //Make sure that the email and phone are blank
        myDirectory.searchAndClick("Tools, LDS45");
        myEditDirectory.clearPhoneAndEmail();
        myBasePage.backToDirectory();


        myMenu.selectMenu(myMenu.missionary);
        myMissionary.sendReferralButton.click();
        Thread.sleep(2000);

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("Please update your individual email or phone number in Tools before sending a referral", pageSource, "Contains"));

//        System.out.println(pageSource);

        myMissionary.referralUpdateIndividualInformation.click();

        myEditDirectory.directoryEditPersonalPhone.sendKeys("1(801)240-0104");

        myEditDirectory.menuSave.click();
        myBasePage.waitUnitlTextIsGone("Saving");
        Thread.sleep(6000);

        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("Please update your individual email or phone number in Tools before sending a referral", pageSource, "Contains"));


        //Clean up
        myBasePage.backButton.click();
        myMenu.selectMenu(myMenu.directory);
        myDirectory.searchAndClick("Tools, LDS45");
        myEditDirectory.clearPhoneAndEmail();
        myBasePage.backButton.click();



    }

    private void checkMissionaryByUnit(String unitNumber) throws Exception {
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        MemberToolsAPI apiTest = new MemberToolsAPI();
        List<String> memberList = new ArrayList<String>();
        List<String> memberListIos = new ArrayList<String>();


        String pageSource;
        pageSource = myMissionary.getMissionaryPage();

        //Check Assigned Missionaries
        memberList = apiTest.getAssignedMissionaries("mbthomas74", unitNumber);
        myBasePage.apiCheckDataPageSource(memberList, pageSource);

        //Check Serving Missionaries
        memberList = apiTest.getServingMissionaries("mbthomas74", unitNumber);
        myBasePage.apiCheckDataPageSource(memberList, pageSource);

        //Check Ward Missionaries
        memberList = apiTest.getOrganizationMembers("Ward Missionaries", "mbthomas74", unitNumber);
        if (getRunningOS().equalsIgnoreCase("ios")) {
            memberListIos = myBasePage.swapLastNameCommaFirstName(memberList);
            memberList = memberListIos;
        }
        myBasePage.apiCheckDataPageSource(memberList, pageSource);
    }


    private void chooseUnit(String myUnit) throws Exception {
        MissionaryScreen myMissionary = new MissionaryScreen(driver);
        //Choose different Unit
        myMissionary.unitSelector.click();
        Thread.sleep(2000);
        if (getRunningOS().equalsIgnoreCase("ios")) {
            driver.get().findElement(By.xpath("//*[contains(@name,'" + myUnit + "')]")).click();
        } else {
            driver.get().findElement(By.xpath("//*[contains(@text,'" + myUnit + "')]")).click();
        }

    }



}
