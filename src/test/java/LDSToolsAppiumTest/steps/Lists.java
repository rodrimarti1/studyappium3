package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.ListsScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.commons.lang.WordUtils;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Lists extends BaseDriver  {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ListsScreen myLists = new ListsScreen(driver);
    String pageSource;
    String numberOfListMembers;
    MemberToolsAPI apiTest = new MemberToolsAPI();


    @Given("a list user signs in")
    public void aListUserSignsIn() throws Exception {
        LOGGER.info("a list user signs in");
        myHelper.proxyLogin("julieryan");
        myHelper.enterPin("1", "1", "3", "3");
    }

    @Given("a list with sample setup user signs in")
    public void aListWithSampleSetupUserSignsIn() throws Exception{
        LOGGER.info("a list with sample setup user signs in");
        //Delete all lists
        deleteListAPI();
//        myLists.deleteAllLists();
        //Create Delete this list
        deleteThisList();
        //Create My Member List
        myMemberList();
        //Create Change My Name
        changeMyListName();
        myHelper.proxyLogin("julieryan");
        myHelper.enterPin("1", "1", "3", "3");
    }

    @And("is on the list page")
    public void isOnTheListPage() throws Exception {
        LOGGER.info("is on the list page");
        myMenu.selectMenu(myMenu.lists);
        //Check for existing Lists and delete if found
        Thread.sleep(2000);
        myLists.deleteAllLists();
    }

    @And("is on the list page with sample")
    public void isOnTheListPageWithSample() throws Exception {
        LOGGER.info("is on the list page with sample");
        LOGGER.info("is on the list page");
        myMenu.selectMenu(myMenu.lists);
        Thread.sleep(2000);
    }


    @Given("a user is logged in and on the Lists page")
    public void aUserIsLoggedInAndOnTheListsPage() throws Exception {
        myHelper.proxyLogin("julieryan");
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.lists);
        //Check for existing Lists and delete if found
        Thread.sleep(2000);
        myLists.deleteAllLists();
    }


    @When("I add a New List")
    public void iAddANewList() throws Exception{
        myBasePage.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys("New Automated List");
        myLists.listsOk.click();
    }

    @When("I add a List {string}")
    public void iAddAList(String listName) throws Exception {
        myBasePage.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys(listName);
        myBasePage.waitForElementThenClick(myLists.listsOk);
//        myLists.listsOk.click();
        Thread.sleep(500);
    }


    @And("I add members to the list")
    public void iAddMembersToTheList() throws Exception {
        //Add a member to the list
        myLists.addMemberToList("lovell, heather", "Lovell, Heather");
        myBasePage.waitForElementThenClick(myLists.listsBackButton);
        Thread.sleep(2000);
    }

    @Then("the {string} with the members should be displayed.")
    public void theWithTheMembersShouldBeDisplayed(String listName) throws Exception {
        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers(listName);
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("1", numberOfListMembers);

        //Check the list members
        myLists.selectListName(listName);
        Thread.sleep(4000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("barker", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("susan", pageSource, "Contains"));
        myBasePage.backButton.click();
        Thread.sleep(2000);

        //Delete the List
//        myLists.deleteList("New Automated List");
        myLists.deleteList(listName);

        //Make Sure the List is deleted
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList(listName, pageSource, "Contains"));
    }


    @And("I add six members to the list")
    public void iAddSixMembersToTheList() throws Exception {
        //Add a member to the list
        myLists.addMemberToList("lovell, heather", "Lovell, Heather");
        myLists.addMemberToList("lovell, kyler", "Lovell, Kyler");
        myLists.addMemberToList("carter, earon", "Carter, Earon");
        myLists.addMemberToList("carter, genie", "Carter, Genie");
        myLists.addMemberToList("carter, tanya", "Carter, Tanya");
        myLists.addMemberToList("casas, sarai", "Casas, Sarai");
        myBasePage.waitForElementThenClick(myLists.listsBackButton);
    }




    @Then("the {string} six members should be displayed on the list")
    public void theSixMembersShouldBeDisplayedOnTheList(String listName) throws Exception {
        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers("Test List 1");
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("6", numberOfListMembers);

        //Check the list members
        checkListMembers();

        //Logout - Login
        myMenu.menuLogOut();
//        myHelper.loginUAT("LDSTools25", "password1");
        myHelper.proxyLogin("julieryan");
        myHelper.enterPin("1", "1", "3", "3");

        //Go to Lists
        myMenu.selectMenu(myMenu.lists);

        //Check the list members
        checkListMembers();

        //Delete the List
        myLists.deleteList("Test List 1");

        //Make Sure the List is deleted
        Thread.sleep(5000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("Test List 1", pageSource, "Contains"));

    }


    @And("members are added to the list")
    public void membersAreAddedToTheList(List<String> membersToAdd ) throws Exception {
        String memberToClickOn;
        for (String oneMember : membersToAdd ) {
            memberToClickOn = WordUtils.capitalize(oneMember);
            System.out.println("Member to Add: " + oneMember);
            System.out.println("Member to click on: " + memberToClickOn);
            myLists.addMemberToList(oneMember, memberToClickOn);
        }
        myBasePage.waitForElementThenClick(myLists.listsBackButton);
    }


    @And("sample lists are setup")
    public void sampleListsAreSetup() throws Exception {
        LOGGER.info("sample lists are setup");
        //Delete all lists
        myLists.deleteAllLists();

        //Create Delete this list
        deleteThisList();
        //Create My Member List
        myMemberList();
        //Create Change My Name
        changeMyListName();

    }

    @When("the list {string} is deleted")
    public void theListIsDeleted(String listName) throws Exception {
        LOGGER.info("the list " + listName + " is deleted");
        myLists.deleteList(listName);
    }

    @Then("the list {string} will be deleted")
    public void theListWillBeDeleted(String listName) throws Exception {
        LOGGER.info("the list " + listName + " will be deleted");
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(pageSource.contains(listName));
        Assert.assertTrue(pageSource.contains("My Member List"));
        Assert.assertTrue(pageSource.contains("Change List Name"));
        //Cleanup
        deleteListAPI();
//        myLists.deleteAllLists();
    }

    @When("a member {string} is deleted from {string}")
    public void aMemberIsDeletedFrom(String oneMember, String listName) throws Exception {
        LOGGER.info("a member " + oneMember + " is deleted from " + listName);
        myLists.selectListName(listName);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            oneMember = swapNames(oneMember);
        }
        myLists.deleteMemberFromList(oneMember);
        myBasePage.waitForElementThenClick(myLists.listsBackButton);
        Thread.sleep(2000);
    }


    @Then("the member {string} will be deleted from {string}")
    public void theMemberWillBeDeletedFrom(String memberToCheck, String listName) throws Exception {
        LOGGER.info("the member " + memberToCheck + " will be deleted from " + listName );
        myLists.selectListName(listName);
        pageSource = myBasePage.getSourceOfPage();
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            memberToCheck = swapNames(memberToCheck);
        }
        Assert.assertFalse(pageSource.contains(memberToCheck));
        Assert.assertTrue(pageSource.contains("Monge"));

        deleteListAPI();
    }

    @When("a list is created with a large number of members")
    public void aListIsCreatedWithALargeNumberOfMembers() throws Exception {
        LOGGER.info("a list is created with a large number of members");
        List<String> membersToAdd = new ArrayList<String>();
        membersToAdd.add("adams, dewayne");
        membersToAdd.add("adams, zachary");
        membersToAdd.add("agcaoili, lisa");
        membersToAdd.add("anderson, lisa");
        membersToAdd.add("arabia, jaclyn");
        membersToAdd.add("arabia, norma");
        membersToAdd.add("arabia, roman");
        membersToAdd.add("arce, malakhi");
        membersToAdd.add("austin, joseph");
        membersToAdd.add("auton, daniel");
        membersToAdd.add("auton, james");
        membersToAdd.add("ayon, stephanie");
        membersToAdd.add("banuelos, bruno");
        membersToAdd.add("barker, susan");
        membersToAdd.add("barton, reilly");
        membersToAdd.add("bearden, olivia");
        membersToAdd.add("carter, earon");
        membersToAdd.add("carter, tanya");
        membersToAdd.add("benn, hattie");
        iAddAList("Large Number Of Members");
        membersAreAddedToTheList(membersToAdd );

    }

    @Then("the large number list will be created")
    public void theLargeNumberListWillBeCreated() throws Exception {
        LOGGER.info("the large number list will be created");
        //Check the expected number of members in the list
        numberOfListMembers = myLists.getNumberOfListMembers("Large Number Of Members");
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("19", numberOfListMembers);

        //Check the list members
        myLists.selectListName("Large Number Of Members");
        Thread.sleep(4000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("adams", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("lisa", pageSource, "Contains"));
        myBasePage.backButton.click();
        Thread.sleep(2000);

        //Delete the List
//        myLists.deleteList("New Automated List");
        myLists.deleteList("Large Number Of Members");

        //Make Sure the List is deleted
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(myBasePage.checkNoCaseList("Large Number Of Members", pageSource, "Contains"));

    }


    @When("the device is rotated")
    public void theDeviceIsRotated() throws Exception {
        LOGGER.info("the device is rotated");
        rotateListNameCheck();
//        driver.get().rotate(ScreenOrientation.LANDSCAPE);
        driver.get().setSetting("orientation","LANDSCAPE");

        rotateListNameCheck();
//        driver.get().rotate(ScreenOrientation.PORTRAIT);
        driver.get().setSetting("orientation","PORTRAIT");
        rotateListNameCheck();
    }

    @Then("the information for the lists setup will be visible")
    public void theInformationForTheListsSetupWillBeVisible() throws Exception {
        LOGGER.info("the information for the lists setup will be visible");
        myLists.selectListName("My Member List");
        rotateMyMemberListCheck();
//        driver.get().rotate(ScreenOrientation.LANDSCAPE);
        driver.get().setSetting("orientation","LANDSCAPE");
        rotateMyMemberListCheck();
//        driver.get().rotate(ScreenOrientation.PORTRAIT);
        driver.get().setSetting("orientation","PORTRAIT");
        rotateMyMemberListCheck();
        myBasePage.backButton.click();

        deleteListAPI();
//        myLists.deleteAllLists();
    }

    @When("a list name is changed")
    public void aListNameIsChanged() throws Exception {
        LOGGER.info("a list name is changed");
        myLists.editListName("Change List Name", "New List Name");
    }

    @Then("the list name will be updated")
    public void theListNameWillBeUpdated() throws Exception {
        LOGGER.info("the list name will be updated");
        numberOfListMembers = myLists.getNumberOfListMembers("New List Name");
        System.out.println("Number of List Members: " + numberOfListMembers);
        Assert.assertEquals("2", numberOfListMembers);
        //Check the list members
        myLists.selectListName("New List Name");
        Thread.sleep(4000);
        myBasePage.backButton.click();

        deleteListAPI();
//        myLists.deleteAllLists();

    }

    private void rotateMyMemberListCheck() throws Exception {
        Thread.sleep(4000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("boat", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("monge", pageSource, "Contains"));
    }

    private void rotateListNameCheck() throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Delete This List"));
        Assert.assertTrue(pageSource.contains("My Member List"));
        Assert.assertTrue(pageSource.contains("Change List Name"));
    }



    private void deleteThisList() throws Exception {
        int responseCode = 0;
        responseCode = apiTest.postListTest("dbe8087d-4308-461c-8a5f-decb6e03f06d,2d608fa5-ed9a-460e-b220-270214c6e9bb", "Delete This List",53, "a1479b4c-df02-4454-bdb6-576f12473195", "julieryan");
        Assert.assertEquals(responseCode, 200);

//        myBasePage.waitForElementThenClick(myLists.listsAddList);
//        myLists.listsName.sendKeys("Delete This List");
//        myLists.listsOk.click();
//
//        //Add a member to the list
//        myLists.addMemberToList("adams, noel carl", "Adams, Noel Carl");
//        myLists.addMemberToList("monge, emma", "Monge, Emma");
//
//        myBasePage.waitForElementThenClick(myLists.listsBackButton);
//        Thread.sleep(2000);
    }

    private void myMemberList() throws Exception {
        int responseCode = 0;
        responseCode = apiTest.postListTest("7d9c46fd-958f-4a91-8c74-7ef41a297c55,2d608fa5-ed9a-460e-b220-270214c6e9bb", "My Member List",52, "a1479b4c-df02-4454-bdb6-576f12473194", "julieryan");
        Assert.assertEquals(responseCode, 200);
//
//        myBasePage.waitForElementThenClick(myLists.listsAddList);
//        myLists.listsName.sendKeys("My Member List");
//        myLists.listsOk.click();
//
//        //Add a member to the list
//        myLists.addMemberToList("boat, steven", "Boat, Steven");
//        myLists.addMemberToList("monge, emma", "Monge, Emma");
//
//        myBasePage.waitForElementThenClick(myLists.listsBackButton);
//        Thread.sleep(2000);
    }

    private void changeMyListName() throws Exception {
        int responseCode = 0;
        responseCode = apiTest.postListTest("7d9c46fd-958f-4a91-8c74-7ef41a297c55,2d608fa5-ed9a-460e-b220-270214c6e9bb", "Change List Name",51, "a1479b4c-df02-4454-bdb6-576f12473193", "julieryan");
        Assert.assertEquals(responseCode, 200);

//        myBasePage.waitForElementThenClick(myLists.listsAddList);
//        myLists.listsName.sendKeys("Change List Name");
//        myLists.listsOk.click();
//
//        //Add a member to the list
//        myLists.addMemberToList("boat, steven", "Boat, Steven");
//        myLists.addMemberToList("monge, emma", "Monge, Emma");
//
//        myBasePage.waitForElementThenClick(myLists.listsBackButton);
//        Thread.sleep(2000);
    }


    private void deleteListAPI() throws Exception {
        int responseCode = 0;
        HashMap<String, String> listMap = new HashMap<>();
        listMap = apiTest.getListNames("julieryan");
        for (String listToDelete: listMap.keySet()) {
            System.out.println(listToDelete);
            responseCode = apiTest.listDelete(listToDelete, "julieryan");
        }
    }


    private void checkListMembers() throws Exception {
        String pageSource;

        // ********* Constructor **********
        BasePage myBase = new BasePage(driver);
        ListsScreen myLists = new ListsScreen(driver);

        myLists.selectListName("Test List 1");
        Thread.sleep(4000);
        pageSource = myBase.getSourceOfPage();
        Assert.assertTrue(myBase.checkNoCaseList("Susan", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("Audrey", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("Jacqueline", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("John", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("Steven", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("Rachel", pageSource, "Contains"));
        myBase.backButton.click();
        Thread.sleep(2000);
    }


    private String swapNames(String givenName) throws Exception {
        String firstName = givenName.substring(0, givenName.indexOf(" "));
        String lastName = givenName.substring(givenName.indexOf(" "));
        String cName =  lastName + ", " + firstName;
        cName = cName.trim();
        return cName;
    }



}
