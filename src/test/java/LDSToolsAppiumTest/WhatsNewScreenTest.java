package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.HelpScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.PinScreen;
import LDSToolsAppium.Screen.WhatsNewScreen;
import org.testng.Assert;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.awt.*;


public class WhatsNewScreenTest extends BaseDriver {

    @Test (groups = {"all1", "all", "smoke", "smoke1", "daily", "daily1", "jft"})
    public void whatsNewSimple() throws Exception {
        String pageSource;
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        WhatsNewScreen myWhatsNew = new WhatsNewScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        HelpScreen myHelpPage = new HelpScreen(driver);

        myHelper.proxyLogin("mbthomas74");

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myHelper.enterPin("1", "1", "3", "3");
            myMenu.selectMenu(myMenu.help);
            myBasePage.waitForElementThenClick(myHelpPage.helpWhatsNew);
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("What's New", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Expenses", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Recording Quorum and Class Visitors", pageSource, "Contains"));
        } else {
            myHelper.enterPinKeepWhatsNew("1", "1", "3", "3");
            Thread.sleep(2000);
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("What's New", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Expenses", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Recording Quorum and Class Visitors", pageSource, "Contains"));
            myBasePage.waitForElementThenClick(myWhatsNew.whatsNewDone);
        }



    }

}
