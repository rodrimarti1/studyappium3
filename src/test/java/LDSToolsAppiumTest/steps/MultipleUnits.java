package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class MultipleUnits extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    DirectoryScreen myDirectory = new DirectoryScreen(driver);
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> memberList = new ArrayList<String>();
    String pageSource;


    @Given("a member logs in and is on the Directory page")
    public void aMemberLogsInAndIsOnTheDirectoryPage() throws Exception {
        LOGGER.info("a member logs in and is on the Directory page");
        myHelper.proxyLogin("mckenziebachrach");
        myHelper.enterPin("1", "1", "3", "3");
    }

    @When("the unit selector is pressed")
    public void theUnitSelectorIsPressed() throws Exception {
        LOGGER.info("the unit selector is pressed");
//        myDirectory.directoryDropdown.click();
    }


    @Then("the units should be displayed")
    public void theUnitsShouldBeDisplayed() throws Exception {
        List<String> allUnits = new ArrayList<>();
        LOGGER.info("the units should be displayed");
//        pageSource = myBasePage.getSourceOfPage();
//        System.out.println(pageSource);

        allUnits = getAllUnits();
    }


    public List<String> getAllUnits() throws Exception {
        List<String> StakeWard = new ArrayList<String>();
        List<WebElement> options;
        String myUnit;
        BasePage myBasePage = new BasePage(driver);


        int pageSize;
        int myCounter = 1;
        Thread.sleep(2000);

        if (myBasePage.getOS().equals("ios")) {
            //directoryDropdown.click();
            myDirectory.directoryDropdown.click();

            //Get Stake and all Wards
            //options= driver.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell/UIAStaticText"));
            options= driver.get().findElements(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText"));

            for (int i = 0 ; i < options.size(); i++ ) {
                System.out.println(options.get(i).getText());
                myUnit = options.get(i).getText();
                myUnit = myUnit.trim();
                System.out.println(myUnit);
                StakeWard.add(myUnit);
            }

        } else {
            System.out.println("Check Android");
            myDirectory.directoryDropdown.click();

            //Get Stake and all Wards
            //options = driver.findElements(By.xpath("//*[@id='list_item']/*[@id='text1']"));
            options = driver.get().findElements(By.xpath("//android.widget.LinearLayout[@resource-id='list_item']/android.widget.TextView[@resource-id='unitNameTextView']"));
            //options = driver.findElements(By.xpath("//android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView"));
            for (int i = 0 ; i < options.size(); i++ ) {
                System.out.println(options.get(i).getText());
                StakeWard.add(options.get(i).getText());
            }
            Thread.sleep(1000);

        }

        for (String oneUnit : StakeWard ) {
            System.out.println(oneUnit);
        }

        return StakeWard;

    }

}
