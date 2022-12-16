package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.LifeResources.Resource;
import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.LifeResourcesScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppiumTest.HelperMethods;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import java.util.*;

import java.util.List;


public class LifeResources extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    LifeResourcesScreen myLifeResourcesScreen = new LifeResourcesScreen(driver);
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
            if (myBasePage.checkForElement(myLifeResourcesScreen.allowWhileUsingApp)) {
                myLifeResourcesScreen.allowWhileUsingApp.click();
            }
        }
    }

    @When("a {string} is selected")
    public void aIsSelected(String lifeResourceName) throws Exception {
        Thread.sleep(500);
        myBasePage.clickByText(lifeResourceName);
        Thread.sleep(500);
    }

    @Then("the information will be displayed")
    public void theInformationWillBeDisplayed(List<String> infoToCheck) throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        pageSource = pageSource.toLowerCase();
        for (String oneItem : infoToCheck ) {
            oneItem = oneItem.toLowerCase();
            Assert.assertTrue(pageSource.contains(oneItem));
        }
    }


    @When("a {string} is searched for in Life Resources")
    public void aIsSearchedForInLifeResources(String itemToSearch) throws Exception {
        String lowerCaseItemToSearch = itemToSearch.toLowerCase();
        myLifeResourcesScreen.lifeResourceSearch.sendKeys(lowerCaseItemToSearch);
        Thread.sleep(500);
    }

    @When("a {string} is selected in Life Resources")
    public void aCategoryIsSelectedInLifeResources(String category) throws Exception {
        driver.get().setSetting("includeNonModalElements", true);
        driver.get().setSetting("snapshotMaxDepth", 150);


        myBasePage.waitForElementThenClick( myLifeResourcesScreen.lifeResourceCategory);
        Thread.sleep(1000);
        Map<String, Object> myMap = new HashMap<>();
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            System.out.println("Wait to see if page loads");

//            Thread.sleep(20000);
            System.out.println("Done waiting get source of page");

            System.out.println(myBasePage.getSourceOfPage());
            System.out.println("Try to click element");
            WebElement categoryName = driver.get().findElement(By.xpath("//XCUIElementTypeButton[@label='" + category + "']"));
            categoryName.click();
            driver.get().setSetting("includeNonModalElements", false);
            driver.get().setSetting("snapshotMaxDepth", 50);
//            myBasePage.clickElementByCords(categoryName);
        } else {
            myBasePage.clickByTextName(category);
        }
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


    @When("a Life Resource is created {string}")
    public void aLifeResourceIsCreated(String resourceToCreate) throws Exception {
        myLifeResourcesScreen.lifeResourceAddButton.click();
        createLifeResource(resourceToCreate);
    }

    public void createLifeResource(String resourceToCreate) throws Exception {
        if (resourceToCreate.equalsIgnoreCase("Appium Test One")) {
            myLifeResourcesScreen.lifeResourceCertifySwitch.click();
            Thread.sleep(500);
            System.out.println(resourceToCreate);

            myLifeResourcesScreen.lifeResourceOrgName.sendKeys(resourceToCreate);
            myLifeResourcesScreen.lifeResourceShortDescription.click();
            myLifeResourcesScreen.lifeResourceShortDescription.sendKeys("Short Description");
            myLifeResourcesScreen.lifeResourceURL.sendKeys("https://appium.io");

            myBasePage.scrollDownIOS();
//            System.out.println(myBasePage.getSourceOfPage());

//            driver.get().findElement(By.xpath("//XCUIElementTypeKeyboard//XCUIElementTypeButton[@name='Return']")).click();

            myLifeResourcesScreen.lifeResourcePhone.sendKeys("801-867-5309");
            myLifeResourcesScreen.lifeResourceAddress.sendKeys("3740 W Market Center Dr, Riverton, UT 84065");
            myLifeResourcesScreen.lifeResourceEmail.sendKeys("nospam@nospam.com");
            if (myBasePage.getOS().equalsIgnoreCase("android")) {
                myBasePage.newScrollDown();
            } else {
                myBasePage.scrollDownIOS();
            }
            myLifeResourcesScreen.lifeResourceNotes.sendKeys("Appium Test One Notes");
            if (myBasePage.getOS().equalsIgnoreCase("android")) {
                myBasePage.newScrollDown();
            }
            myLifeResourcesScreen.lifeResourceWork.click();
            myLifeResourcesScreen.lifeResourceSave.click();
        }
    }


    @Given("The sample life resources are created")
    public void theSampleLifeResourcesAreCreated() throws Exception {
        API myAPI = new API();
        int responseCode = 0;
        String unit = "502278";
        String proxyName = "STAKE_PRESIDENT";
        Resource myResource = new Resource();
        String myUser = myAPI.getUsername(proxyName);

        myResource = myAPI.createResource("lifeResourceSampleOne");
        responseCode = apiTest.createLifeResource(unit, myUser, myResource);
        System.out.println("CODE: " + responseCode);

        myResource = myAPI.createResource("lifeResourceSampleTwo");
        responseCode = apiTest.createLifeResource(unit, myUser, myResource);
        System.out.println("CODE: " + responseCode);

    }

    @Then("The sample life resource will be displayed")
    public void theSampleLifeResourceWillBeDisplayed() throws Exception {
        API myAPI = new API();
        myAPI.theLifeResourceWillBeCorrect("lifeResourceSampleOne");
        myAPI.theLifeResourceWillBeCorrect("lifeResourceSampleTwo");
    }



    @After("@cleanup")
    public void cleanupBackground() throws Exception {
        API myAPI = new API();
        System.out.println("Running Cleanup");
        myAPI.theLifeResourceIsDeleted("lifeResourceSampleOne");
        myAPI.theLifeResourceIsDeleted("lifeResourceSampleTwo");
    }


    @And("the delete button is pressed")
    public void theDeleteButtonIsPressed() throws Exception {
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.waitForElementThenClick(myLifeResourcesScreen.lifeResourceEdit);
        }
        myBasePage.waitForElementThenClick(myLifeResourcesScreen.lifeResourceDelete);
        myBasePage.waitForElementThenClick(myLifeResourcesScreen.lifeResourceConfirmDelete);
        //Wait for 10 seconds for the resource to be deleted
        Thread.sleep(10000);
    }
}
