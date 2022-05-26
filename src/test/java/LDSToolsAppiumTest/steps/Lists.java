package LDSToolsAppiumTest.steps;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.ListsScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.commons.lang.WordUtils;
import org.testng.Assert;

import java.util.List;


public class Lists extends BaseDriver  {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ListsScreen myLists = new ListsScreen(driver);
    String pageSource;
    String numberOfListMembers;


    @Given("a list user signs in")
    public void aListUserSignsIn() throws Exception {
        LOGGER.info("a list user signs in");
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
        myLists.listsOk.click();
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

        //Todo: this should be its own sub.
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
        myLists.deleteAllLists();
    }



    private void deleteThisList() throws Exception {
        //Add a new List
        myBasePage.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys("Delete This List");
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("adams, noel carl", "Adams, Noel Carl");
        myLists.addMemberToList("monge, emma", "Monge, Emma");

        myBasePage.waitForElementThenClick(myLists.listsBackButton);
        Thread.sleep(2000);
    }

    private void myMemberList() throws Exception {
        myBasePage.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys("My Member List");
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("boat, steven", "Boat, Steven");
        myLists.addMemberToList("monge, emma", "Monge, Emma");

        myBasePage.waitForElementThenClick(myLists.listsBackButton);
        Thread.sleep(2000);
    }

    private void changeMyListName() throws Exception {
        myBasePage.waitForElementThenClick(myLists.listsAddList);
        myLists.listsName.sendKeys("Change List Name");
        myLists.listsOk.click();

        //Add a member to the list
        myLists.addMemberToList("boat, steven", "Boat, Steven");
        myLists.addMemberToList("monge, emma", "Monge, Emma");

        myBasePage.waitForElementThenClick(myLists.listsBackButton);
        Thread.sleep(2000);
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



}
