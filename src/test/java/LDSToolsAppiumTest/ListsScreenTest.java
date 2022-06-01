package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.CalendarsScreen;
import LDSToolsAppium.Screen.ListsScreen;
import LDSToolsAppium.Screen.MenuScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ListsScreenTest extends BaseDriver {


//    @Test(groups = {"smoke3", "smoke", "all3", "all", "daily", "daily1", "jft"})
    @Test(groups = {"depreciated"})
    public void listsSimpleTest() throws Exception {
        String pageSource;
        String numberOfListMembers;

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Login and enter in PIN
//        myHelper.loginUAT("LDSTools33", "password1");
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        //Check for existing Lists and delete if found
        Thread.sleep(2000);
        myLists.deleteAllLists();

        //Add a new List
        myBase.waitForElementThenClick(myLists.listsAddList);
//        System.out.println(myBase.getSourceOfPage());
        myLists.listsName.sendKeys("New Automated List");
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("barker, susan", "Barker, Susan");
//        System.out.println(myBase.getSourceOfPage());
        myBase.waitForElementThenClick(myLists.listsBackButton);

        Thread.sleep(2000);

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers("New Automated List");
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("1", numberOfListMembers);

        //Check the list members
        myLists.selectListName("New Automated List");
        Thread.sleep(4000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList("barker", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("susan", pageSource, "Contains"));
        myBase.backButton.click();
        Thread.sleep(2000);

        //Delete the List
        myLists.deleteList("New Automated List");

        //Make Sure the List is deleted
        Thread.sleep(2000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertFalse(myBase.checkNoCaseList("New Automated List", pageSource, "Contains"));

    }

    //TODO: Need to update user
    @Test(groups = {"depreciated"})
//    @Test(groups = {"all3", "all"})
    public void listsMultipleSyncTest() throws Exception {
        String pageSource;
        String numberOfListMembers;

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Login and enter in PIN
//        myHelper.loginUAT("LDSTools25", "password1");
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        //Check for existing Lists and delete if found
        Thread.sleep(2000);
        myLists.deleteAllLists();


        //Add a new List
        myBase.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys("Test List 1");
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("lovell, heather", "Lovell, Heather");
        myLists.addMemberToList("lovell, kyler", "Lovell, Kyler");
        myLists.addMemberToList("carter, earon", "Carter, Earon");
        myLists.addMemberToList("carter, genie", "Carter, Genie");
        myLists.addMemberToList("carter, tanya", "Carter, Tanya");
        myLists.addMemberToList("casas, sarai", "Casas, Sarai");
        myBase.waitForElementThenClick(myLists.listsBackButton);

        Thread.sleep(2000);

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers("Test List 1");
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("6", numberOfListMembers);

        //Check the list members
        checkListMembers();



        //Logout - Login
        myMenu.menuLogOut();
//        myHelper.loginUAT("LDSTools25", "password1");
        myHelper.proxyLogin("darthjohn");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        //Check the list members
        checkListMembers();

        //Delete the List
        myLists.deleteList("Test List 1");

        //Make Sure the List is deleted
        Thread.sleep(5000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertFalse(myBase.checkNoCaseList("Test List 1", pageSource, "Contains"));

    }


    //Now a Cucumber Test
    @Test(groups = {"depreciated"})
//    @Test(groups = {"all4", "all"})
    public void listsMaxOutName() throws Exception {
        String pageSource;
        String numberOfListMembers;

//        String longName = "Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit Ten Digit";
        String longName = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
//        String longName = "Test One";

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Login and enter in PIN
        myHelper.loginUAT("LDSTools21", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        //Check for existing Lists and delete if found
        Thread.sleep(2000);
        myLists.deleteAllLists();


        //Add a new List
        myBase.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys(longName);
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("lds20", "LDS20");
        myLists.addMemberToList("lds21", "LDS21");
        myLists.addMemberToList("lds22", "LDS22");
        myBase.waitForElementThenClick(myLists.listsBackButton);

        Thread.sleep(2000);

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(longName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("3", numberOfListMembers);

        //Do a sync
        myMenu.selectMenu(myMenu.sync);
        myHelper.syncTools();


        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        Thread.sleep(2000);

        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList(longName, pageSource, "Contains"));

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(longName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("3", numberOfListMembers);


        //Delete the List
        myLists.deleteList(longName);

        //Make Sure the List is deleted
        Thread.sleep(5000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertFalse(myBase.checkNoCaseList(longName, pageSource, "Contains"));


    }

    //Cucumber test now
    @Test(groups = {"depreciated"})
//    @Test(groups = {"all4", "all"})
    public void listsOtherNames() throws Exception {
        String pageSource;
        String numberOfListMembers;

        String longName = "!@#$%^&*(){}[]~~//??.,<>;;;;;";

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Login and enter in PIN
        myHelper.loginUAT("LDSTools21", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        //Check for existing Lists and delete if found
        Thread.sleep(2000);
        myLists.deleteAllLists();


        //Add a new List
        myBase.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys(longName);
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("lds20", "LDS20");
        myLists.addMemberToList("lds21", "LDS21");
        myLists.addMemberToList("lds22", "LDS22");
        myBase.waitForElementThenClick(myLists.listsBackButton);

        Thread.sleep(2000);

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(longName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("3", numberOfListMembers);

        //Do a sync
        myMenu.selectMenu(myMenu.sync);
        myHelper.syncTools();


        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        Thread.sleep(2000);

        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList(longName, pageSource, "Contains"));

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(longName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("3", numberOfListMembers);


        //Delete the List
        myLists.deleteList(longName);

        //Make Sure the List is deleted
        Thread.sleep(5000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertFalse(myBase.checkNoCaseList(longName, pageSource, "Contains"));


    }


    //iOS has had problems with & in the name
    //Cucumber test now
    @Test(groups = {"depreciated"})
//    @Test(groups = {"all3", "all"})
    public void listsOtherNamesAnd() throws Exception {
        String pageSource;
        String numberOfListMembers;

        String longName = "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&";

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Login and enter in PIN
        myHelper.loginUAT("LDSTools21", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        //Check for existing Lists and delete if found
        Thread.sleep(2000);
        myLists.deleteAllLists();

        //Add a new List
        myBase.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys(longName);
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("lds20", "LDS20");
        myLists.addMemberToList("lds21", "LDS21");
        myLists.addMemberToList("lds22", "LDS22");
        myBase.waitForElementThenClick(myLists.listsBackButton);

        Thread.sleep(2000);

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(longName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("3", numberOfListMembers);

        //Do a sync
        myMenu.selectMenu(myMenu.sync);
        myHelper.syncTools();


        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        Thread.sleep(2000);

        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList(longName, pageSource, "Contains"));

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(longName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("3", numberOfListMembers);


        //Delete the List
        myLists.deleteList(longName);

        //Make Sure the List is deleted
        Thread.sleep(5000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertFalse(myBase.checkNoCaseList(longName, pageSource, "Contains"));


    }



    //Cucumber test now
    @Test(groups = {"depreciated"})
//    @Test(groups = {"all3", "all"})
    public void listsDelete() throws Exception {
        String pageSource;
        String numberOfListMembers;


        String listName = "Delete Test";


        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Login and enter in PIN
        myHelper.loginUAT("LDSTools22", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        //Check for existing Lists and delete if found
        Thread.sleep(2000);
        myLists.deleteAllLists();


        //Add a new List
        myBase.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys(listName);
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("lds20", "LDS20");
        myLists.addMemberToList("lds21", "LDS21");
        myLists.addMemberToList("lds22", "LDS22");
        myBase.waitForElementThenClick(myLists.listsBackButton);

        Thread.sleep(2000);

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(listName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("3", numberOfListMembers);

        //Do a sync
        myMenu.selectMenu(myMenu.sync);
        myHelper.syncTools();


        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        Thread.sleep(2000);

        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList(listName, pageSource, "Contains"));

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(listName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("3", numberOfListMembers);


        //Delete the List
        myLists.deleteList(listName);

        //Make Sure the List is deleted
        Thread.sleep(5000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertFalse(myBase.checkNoCaseList(listName, pageSource, "Contains"));

        //Do a sync
        myMenu.selectMenu(myMenu.sync);
        myHelper.syncTools();
        Thread.sleep(2000);

        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        //Make Sure the List is deleted
        Thread.sleep(5000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertFalse(myBase.checkNoCaseList(listName, pageSource, "Contains"));


    }

    //Cucumber test now
    @Test(groups = {"depreciated"})
//    @Test(groups = {"all4", "all"})
    public void listsEdit() throws Exception {
        String pageSource;
        String numberOfListMembers;


        String listName = "Edit Test";


        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Login and enter in PIN
        myHelper.loginUAT("LDSTools23", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        Thread.sleep(2000);
        myMenu.selectMenu(myMenu.lists);

        //Check for existing Lists and delete if found
        Thread.sleep(2000);
        myLists.deleteAllLists();

        setupListData(listName);

        //Do a sync
        myMenu.selectMenu(myMenu.sync);
        myHelper.syncTools();


        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        Thread.sleep(2000);

        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList(listName, pageSource, "Contains"));

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(listName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("6", numberOfListMembers);


        //Edit the list
        myLists.selectListName(listName);
        listsEditCheckAllTrue();

        //Remove Member
        myLists.deleteMemberFromList("Tools, LDS32");
        listsEditCheckLDS22False();

        myBase.waitForElementThenClick(myLists.listsBackButton);
        Thread.sleep(2000);
        if (!getRunningOS().equals("ios")) {
            myBase.waitForElementThenClick(myLists.listsBackButton);
            Thread.sleep(2000);
        }


        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(listName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("5", numberOfListMembers);

        //Check list
        myLists.selectListName(listName);
        listsEditCheckLDS22False();
        myBase.waitForElementThenClick(myLists.listsBackButton);
        Thread.sleep(2000);

        //Sync
        myMenu.selectMenu(myMenu.sync);
        myHelper.syncTools();

        //Check list
        myMenu.selectMenu(myMenu.lists);
        Thread.sleep(2000);
        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(listName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("5", numberOfListMembers);

        myLists.selectListName(listName);
        listsEditCheckLDS22False();
        myBase.waitForElementThenClick(myLists.listsBackButton);
        Thread.sleep(2000);


        //Delete the List
        myLists.deleteList(listName);

        //Make Sure the List is deleted
        Thread.sleep(5000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertFalse(myBase.checkNoCaseList(listName, pageSource, "Contains"));

    }

    //Cucumber test now
    @Test(groups = {"depreciated"})
//    @Test(groups = {"all4", "all"})
    public void listsLargeNumberOfMembers() throws Exception {
        String pageSource;
        String numberOfListMembers;


        String listName = "Large List";


        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        HelperMethods myHelper = new HelperMethods();
        MenuScreen myMenu = new MenuScreen(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Login and enter in PIN
        myHelper.loginUAT("LDSTools23", "password1");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        Thread.sleep(2000);
        myMenu.selectMenu(myMenu.lists);

        //Check for existing Lists and delete if found
        Thread.sleep(2000);
        myLists.deleteAllLists();

        setupListDataLarge(listName);

        //Do a sync
        myMenu.selectMenu(myMenu.sync);
        myHelper.syncTools();


        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        Thread.sleep(2000);

        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList(listName, pageSource, "Contains"));

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(listName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("39", numberOfListMembers);

        checkListMembersLarge(listName);
        Thread.sleep(2000);

        //Delete the List
        myLists.deleteList(listName);

        //Make Sure the List is deleted
        Thread.sleep(5000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertFalse(myBase.checkNoCaseList(listName, pageSource, "Contains"));

    }









    private void listsEditCheckAllTrue() throws Exception {
        String pageSource;
        BasePage myBase = new BasePage(driver);
        Thread.sleep(4000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList("Tools", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS30", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS31", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS32", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS33", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS34", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS35", pageSource, "Contains"));
    }

    private void listsEditCheckLDS22False() throws Exception {
        String pageSource;
        BasePage myBase = new BasePage(driver);
        Thread.sleep(4000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList("Tools", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS30", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS31", pageSource, "Contains"));
        Assert.assertFalse(myBase.checkNoCaseList("LDS32", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS33", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS34", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS35", pageSource, "Contains"));
    }



    private void setupListDataLarge(String listName) throws Exception {
        String numberOfListMembers;

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Add a new List
        myBase.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys(listName);
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("lds1", "LDS1");
        myLists.addMemberToList("lds3", "LDS3");
        myLists.addMemberToList("lds5", "LDS5");
        myLists.addMemberToList("lds6", "LDS6");
        myLists.addMemberToList("lds7", "LDS7");
        myLists.addMemberToList("lds8", "LDS8");
        myLists.addMemberToList("lds9", "LDS9");
        myLists.addMemberToList("lds10", "LDS10");
        myLists.addMemberToList("lds11", "LDS11");
        myLists.addMemberToList("lds12", "LDS12");
        myLists.addMemberToList("lds13", "LDS13");
        myLists.addMemberToList("lds14", "LDS14");
        myLists.addMemberToList("lds15", "LDS15");
        myLists.addMemberToList("lds16", "LDS16");
        myLists.addMemberToList("lds17", "LDS17");
        myLists.addMemberToList("lds18", "LDS18");
        myLists.addMemberToList("lds19", "LDS19");
        myLists.addMemberToList("lds20", "LDS20");
        myLists.addMemberToList("lds21", "LDS21");
        myLists.addMemberToList("lds22", "LDS22");
        myLists.addMemberToList("lds23", "LDS23");
        myLists.addMemberToList("lds24", "LDS24");
        myLists.addMemberToList("lds25", "LDS25");
        myLists.addMemberToList("lds26", "LDS26");
        myLists.addMemberToList("lds27", "LDS27");
        myLists.addMemberToList("lds28", "LDS28");
        myLists.addMemberToList("lds29", "LDS29");
        myLists.addMemberToList("lds30", "LDS30");
        myLists.addMemberToList("lds31", "LDS31");
        myLists.addMemberToList("lds32", "LDS32");
        myLists.addMemberToList("lds33", "LDS33");
        myLists.addMemberToList("lds34", "LDS34");
        myLists.addMemberToList("lds35", "LDS35");
        myLists.addMemberToList("lds36", "LDS36");
        myLists.addMemberToList("lds37", "LDS37");
        myLists.addMemberToList("lds38", "LDS38");
        myLists.addMemberToList("lds39", "LDS39");

        if (getRunningOS().equals("ios")) {
            myLists.addMemberToList("lds2 ", "LDS2");
            myLists.addMemberToList("lds4 ", "LDS4");
        } else {
            myLists.addMemberToList("tools, lds2", "LDS2");
            myLists.addMemberToList("tools, lds4", "LDS4");
        }


        myBase.waitForElementThenClick(myLists.listsBackButton);

        Thread.sleep(2000);

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(listName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("39", numberOfListMembers);


    }


    private void checkListMembersLarge(String listName) throws Exception {
        String pageSource;
//        String checkMember;
//        String checkMember2;
        int myCounter = 0;

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        ListsScreen myLists = new ListsScreen(driver);

        myLists.selectListName(listName);
        Thread.sleep(4000);


        pageSource = myBase.getSourceOfPage();

//        do {
//            checkMember = myLists.getLastListMember();
//            myBase.scrollDownAndroidUIAutomator("0");
//            Thread.sleep(4000);
//            pageSource = pageSource + myBase.getSourceOfPage();
//            checkMember2 = myLists.getLastListMember();
//            myCounter++;
//
//        } while (!checkMember.equals(checkMember2) || (myCounter < 5)) ;

        if (!getRunningOS().equals("ios")) {
            do {
                myBase.scrollDownAndroidUIAutomator("0");
                pageSource = pageSource + myBase.getSourceOfPage();
                myCounter++;
            } while (myCounter < 5);
        }


        Assert.assertTrue(myBase.checkNoCaseList("Tools", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS1", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS2", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS3", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS4", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS5", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS6", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS7", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS8", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS9", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS10", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS11", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS12", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS13", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS14", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS15", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS16", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS17", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS18", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS19", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS20", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS21", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS22", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS23", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS24", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS25", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS26", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS27", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS28", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS29", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS30", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS31", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS32", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS33", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS34", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS35", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS36", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS37", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS38", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("LDS39", pageSource, "Contains"));


        myBase.backButton.click();
        Thread.sleep(2000);
    }



    private void setupListData(String listName) throws Exception {
//        String pageSource;
        String numberOfListMembers;

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        ListsScreen myLists = new ListsScreen(driver);


        //Add a new List
        myBase.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys(listName);
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("lds30", "LDS30");
        myLists.addMemberToList("lds31", "LDS31");
        myLists.addMemberToList("lds32", "LDS32");
        myLists.addMemberToList("lds33", "LDS33");
        myLists.addMemberToList("lds34", "LDS34");
        myLists.addMemberToList("lds35", "LDS35");
        myBase.waitForElementThenClick(myLists.listsBackButton);

        Thread.sleep(2000);

        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(listName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("6", numberOfListMembers);


    }






    private void checkListMembers() throws Exception {
        String pageSource;

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        ListsScreen myLists = new ListsScreen(driver);

        myLists.selectListName("Test List 1");
        Thread.sleep(4000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList("jones", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("elizabeth", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("marvin", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("michael", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("william", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("gabrielle", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("Donqwel", pageSource, "Contains"));
        myBase.backButton.click();
        Thread.sleep(2000);
    }






}
