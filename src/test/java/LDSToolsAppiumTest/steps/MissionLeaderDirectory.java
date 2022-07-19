package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MissionLeaderDirectory extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    SettingsScreen mySettings = new SettingsScreen(driver);
    DirectoryScreen myDirectory = new DirectoryScreen(driver);
    MemberToolsAPI apiTest = new MemberToolsAPI();
    WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
    String pageSource;

    @Given("a member {string} logs in")
    public void aMemberLogsIn(String memberLogin) throws Exception {
        LOGGER.info("a member " + memberLogin + "logs in");
        myHelper.proxyLogin(memberLogin);
        myHelper.enterPin("1", "1", "3", "3");
    }


    @When("they check their Mission under Directory")
    public void theyCheckTheirMissionUnderDirectory() throws Exception {
        myDirectory.chooseUnit("Ukraine");
    }

    @Then("they should see a list of their missionaries")
    public void theyShouldSeeAListOfTheirMissionaries() throws Exception {
//        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(pageSource.contains("Gallafent"));
        searchForMemberCheckResultsMissionary("Gallafent, Zachary");
    }

    @When("they select a missionary under their mission")
    public void theySelectAMissionaryUnderTheirMission() throws Exception {
        myDirectory.chooseUnit("Ukraine");
        Thread.sleep(2000);
//        System.out.println(myBasePage.getSourceOfPage());
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myDirectory.searchAndClickReturnedMissionary("Gallafent, Zachary ");
        } else {
            myDirectory.searchAndClickReturnedMissionary("Gallafent, Zachary");
        }

    }

    @Then("they should have contact information")
    public void theyShouldHaveContactInformation() throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Gallafent"));
        Assert.assertTrue(pageSource.contains("801-885-2556"));
        Assert.assertTrue(pageSource.contains("zachary@compguy.com"));
    }


    @When("the Whats New Page is displayed")
    public void theWhatsNewPageIsDisplayed() throws Exception {
        myMenu.selectMenu(myMenu.help);
        myWhatsNew.helpWhatsNew.click();
    }

    @Then("the missionary opt in will be displayed")
    public void theMissionaryOptInWillBeDisplayed() throws Exception {
        pageSource = myBasePage.getSourceOfPage();
//        Assert.assertTrue(pageSource.contains("Former Mission Leader"));
        Assert.assertTrue(pageSource.contains("Ukraine"));
        Assert.assertTrue(pageSource.contains("Kumferman"));
        Assert.assertTrue(pageSource.contains("Rizley"));
    }

    @Given("a Mission President companion logs in")
    public void aMissionPresidentCompanionLogsIn() throws Exception {
        myHelper.proxyLogin("kumfyid");
        myHelper.enterPin("1", "1", "3", "3");
    }



    @When("the Settings page is selected")
    public void theSettingsPageIsSelected() throws Exception {
        myMenu.selectMenu(myMenu.settings);
        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myBasePage.scrollToTextGeneral("Mission Leader Access");
        } else {
            //select ios menu but it doesn't always show up.
            myBasePage.waitForElementThenClick(mySettings.missionLeaderLimitedVisibility);
//            System.out.println(myBasePage.getSourceOfPage());
        }
    }

    @Then("the Returned Missionary info should be marked private")
    public void theReturnedMissionaryInfoShouldBeMarkedPrivate()  throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            Assert.assertTrue(pageSource.contains("Orange items"));
            Assert.assertTrue(pageSource.contains("private"));
            Assert.assertTrue(pageSource.contains("do not share"));
        } else {
            //No way to test in ios yet
        }
    }


    public void toggleMissionLeaderAccess(String onOrOff) throws Exception {
        String toggleStatus;
        List<WebElement> toggleButton = new ArrayList<>();
//        toggleButton = driver.get().findElements(By.xpath("//android.widget.TextView[@resource-id='org.lds.ldstools.alpha:id/secondaryTextView']/following-sibling::org.lds.ldstools.alpha:id/switchView"));
        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myMenu.selectMenu(myMenu.settings);
            myBasePage.scrollToTextGeneral("Refresh Data"); //This might need to be something different
//            toggleButton = driver.get().findElements(By.xpath("//android.widget.TextView[@resource-id='org.lds.ldstools.alpha:id/secondaryTextView']/following-sibling::org.lds.ldstools.alpha:id/switchView"));
            toggleButton = driver.get().findElements(By.xpath("//android.widget.TextView[contains(@text, 'Texas Houston')]/following-sibling::android.widget.Switch"));
        } else {
            myMenu.selectMenu(myMenu.settings);
            myBasePage.waitForElementThenClick(mySettings.missionLeaderLimitedVisibility);
            Thread.sleep(2000);
            toggleButton = driver.get().findElements(By.xpath("//XCUIElementTypeSwitch"));
        }

        for (WebElement missionLeaderButton: toggleButton) {
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                toggleStatus = missionLeaderButton.getAttribute("value");
            } else {
                toggleStatus = missionLeaderButton.getAttribute("checked");
            }

            if (onOrOff.equalsIgnoreCase("on")) {
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    if (toggleStatus.equalsIgnoreCase("1")) {
                        System.out.println("Button is on - nothing to do");
                    } else {
                        System.out.println("Button is off - turning on");
                        missionLeaderButton.click();
                    }
                } else {
                    if (toggleStatus.equalsIgnoreCase("true")) {
                        System.out.println("Button is on - nothing to do");
                    } else {
                        System.out.println("Button is off - turning on");
                        missionLeaderButton.click();
                    }
                }

            } else {
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    if (toggleStatus.equalsIgnoreCase("1")) {
                        System.out.println("Button is on - turning off");
                        missionLeaderButton.click();
                    } else {
                        System.out.println("Button is off - nothing to do");
                    }
                } else {
                    if (toggleStatus.equalsIgnoreCase("true")) {
                        System.out.println("Button is on - turning off");
                        missionLeaderButton.click();
                    } else {
                        System.out.println("Button is off - nothing to do");
                    }
                }

            }
        }
    }


    @Given("a returned missionary logs in and Mission Leader is turned off")
    public void aReturnedMissionaryLogsInAndMissionLeaderIsTurnedOff() throws Exception {
        myHelper.proxyLogin("sariahelizabethrobinson");
        myHelper.enterPin("1", "1", "3", "3");
        toggleMissionLeaderAccess("off");
        //Need a long sleep to make sure the buttons are off.
        Thread.sleep(10000);
        myBasePage.waitForElementThenClick(myBasePage.backButton);
        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myMenu.selectMenu(myMenu.settings);
        }
        myBasePage.waitForElementThenClick(mySettings.signOut);
        myBasePage.waitForElementThenClick(myBasePage.alertOK);
    }



    @Then("the Mission President will not see the Returned Missionary")
    public void theMissionPresidentWillNotSeeTheReturnedMissionary() throws Exception {
//        System.out.println(myBasePage.getSourceOfPage());
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myDirectory.chooseUnit("Texas Houston East Mission 2020 - 2023");
        } else {
            myDirectory.chooseUnit("Texas Houston East Mission 2020-2023");
        }

        Thread.sleep(1000);
        Assert.assertFalse(searchForMemberCheckResultsMissionary("Robinson, Sariah"));
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.waitForElementThenClick(myBasePage.cancel);
        }
        myMenu.selectMenu(myMenu.settings);
        myBasePage.waitForElementThenClick(mySettings.signOut);
        myBasePage.waitForElementThenClick(myBasePage.alertOK);
        cleanUpForRemove();
    }

    public void cleanUpForRemove() throws Exception {
        myHelper.proxyLogin("sariahelizabethrobinson");
        myHelper.enterPin("1", "1", "3", "3");
        toggleMissionLeaderAccess("on");

    }

    public Boolean searchForMemberCheckResultsMissionary(String myUser) throws Exception {
        String tempMyUser = myUser.toLowerCase();
        Boolean myReturnStatus;
        List<WebElement> options;
        myDirectory.searchBar.sendKeys(myUser);

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            options= driver.get().findElements(By.xpath("//XCUIElementTypeStaticText[@value='" + myUser + "']"));
        } else {
            options= driver.get().findElements(By.xpath("//android.widget.TextView[@text='" + myUser + "']"));
        }
        myReturnStatus = !options.isEmpty();
        return myReturnStatus;

    }





}
