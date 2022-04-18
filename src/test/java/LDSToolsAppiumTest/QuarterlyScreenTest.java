package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.MinisteringScreen;
import LDSToolsAppium.Screen.QuarterlyReportScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class QuarterlyScreenTest extends BaseDriver {

    //TODO: Need API tests
//    @Test ( groups = {"all3", "all", "daily", "daily3", "smoke", "smoke3", "jft"} )
    @Test ( groups = {"broken"})
    public void quarterlyReportBasic() throws Exception {
        String pageSource;
        int rights;
        HelperMethods myHelper = new HelperMethods();
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        ReportsScreen myReport = new ReportsScreen(driver);
        QuarterlyReportScreen myQuarterly = new QuarterlyReportScreen(driver);


        myHelper.proxyLogin("mbthomas74");
        rights = 8;
        myHelper.enterPin("1", "1", "3", "3");



        if (rights >= 4) {
            myMenu.selectMenu(myMenu.reports);
            myBasePage.waitForElementThenClick(myReport.quarterlyReport);

            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(myBasePage.checkNoCaseList("Indicators", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Members", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Adults", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Youth", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Children", pageSource, "Contains"));
            Assert.assertTrue(myBasePage.checkNoCaseList("Converts", pageSource, "Contains"));

        } else {
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertFalse(myBasePage.checkNoCaseList("Reports", pageSource, "Contains"));
        }
    }


}
