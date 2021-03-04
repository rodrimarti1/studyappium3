package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.WhatsNewScreen;
import org.testng.Assert;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.awt.*;


public class WhatsNewScreenTest extends BaseDriver {

    @Test (groups = {"all1", "all", "smoke", "smoke1", "jft"})
    public void whatsNewSimple() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);

        myHelper.proxyLogin("kroqbandit");

        myHelper.enterPinKeepWhatsNew("1", "1", "3", "3");
        Thread.sleep(2000);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("What's New", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Photo Downloading", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("Class and Quorum", pageSource, "Contains"));


        myWhatsNew.whatsNewDone.click();

        
        // Click on Later then Directory
        if (!myBasePage.getOS().equals("ios")) {
            Thread.sleep(2000);
            myHelper.checkForLater();
            Thread.sleep(2000);
            myBasePage.waitForElement(myMenu.directory);
            myMenu.organizations.click();
            Thread.sleep(1000);
            myMenu.selectMenu(myMenu.directory);
            Thread.sleep(2000);
        }

    }

}
