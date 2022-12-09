package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.WordUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.List;


public class LifeResources extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    LDSToolsAppium.Screen.LifeResources myLifeResources = new LDSToolsAppium.Screen.LifeResources(driver);
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> memberList = new ArrayList<String>();
    String pageSource;


    @Given("a {string} logs in and is on the Life Resources page")
    public void aLogsInAndIsOnTheLifeResourcesPage(String memberCalling) throws Exception {
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Maplewood 2nd");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.lifeResources);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            if (myBasePage.checkForElement(myLifeResources.allowWhileUsingApp)) {
                myLifeResources.allowWhileUsingApp.click();
            }
        }
    }

    @When("a {string} is selected")
    public void aIsSelected(String lifeResourceName) throws Exception {
        myBasePage.clickByText(lifeResourceName);
        Thread.sleep(500);
    }

    @Then("the information will be displayed")
    public void theInformationWillBeDisplayed(List<String> infoToCheck) throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        for (String oneItem : infoToCheck ) {
            Assert.assertTrue(pageSource.contains(oneItem));
        }
    }


    @When("a {string} is searched for in Life Resources")
    public void aIsSearchedForInLifeResources(String itemToSearch) throws Exception {
        String lowerCaseItemToSearch = itemToSearch.toLowerCase();
        myLifeResources.lifeResourceSearch.sendKeys(lowerCaseItemToSearch);
        Thread.sleep(500);
    }

    @When("a {string} is selected in Life Resources")
    public void aCategoryIsSelectedInLifeResources(String category) throws Exception {
        myBasePage.waitForElementThenClick( myLifeResources.lifeResourceCategory);
        Thread.sleep(1000);
        myBasePage.clickByTextName(category);
    }


    @Then("the Life Resource {string} will be displayed")
    public void theLifeResourceCategoryResourceWillBeDisplayed(String categoryResource) throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains(categoryResource));
    }

    @And("the Life Resource {string} will not be displayed")
    public void theLifeResourceNotDisplayedWillNotBeDisplayed(String notDisplayed) throws Exception{
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(pageSource.contains(notDisplayed));
    }
}
