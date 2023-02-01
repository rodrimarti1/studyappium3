package LDSToolsAppiumTest.steps;


import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;

import LDSToolsAppium.Screen.LoginPageScreen;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.codec.binary.Base64;
import org.testng.Assert;

public class OktaLoginSteps extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    LoginPageScreen myLogin = new LoginPageScreen(driver);
    String pageSource;


    @Given("a user opens the app")
    public void aUserOpensTheApp() throws Exception {
        if (myBasePage.checkForElement(myBasePage.allowButton)) {
            myBasePage.allowButton.click();
        }

        myBasePage.waitForElement(myLogin.loginName);
    }


    @Then("the elements will be displayed")
    public void theElementsWillBeDisplayed() throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        byte[] decodeBytes = Base64.decodeBase64("U25AazNTcDE3MjAyMg==");

        Assert.assertTrue(pageSource.contains("Sign In"));
        Assert.assertTrue(pageSource.contains("Username"));
        if (myBasePage.getOS().equals("ios")) {
            Assert.assertTrue(pageSource.contains("Need help signing in?"));

        } else {
            Assert.assertTrue(pageSource.contains("Forgot your username?"));
        }
        myLogin.loginName.clear();
        myLogin.loginName.sendKeys("zmaxfield");
        myLogin.nextButton.click();
        Thread.sleep(1300);

        //Password Page
        pageSource = myBasePage.getSourceOfPage();
        if (myBasePage.getOS().equals("ios")) {
            Assert.assertTrue(pageSource.contains("Enter your password"));
            Assert.assertTrue(pageSource.contains("Need help signing in?"));
            Assert.assertTrue(pageSource.contains("Next"));

        } else {
            Assert.assertTrue(pageSource.contains("Password"));
            Assert.assertTrue(pageSource.contains("CANCEL"));
            Assert.assertTrue(pageSource.contains("NEXT"));
        }


        myBasePage.waitForElement(myLogin.passWord);
        myLogin.passWord.sendKeys(new String(decodeBytes));
        myLogin.nextButton.click();
        Thread.sleep(1300);

        //2-Step Verification
        pageSource = myBasePage.getSourceOfPage();
        if (myBasePage.getOS().equals("ios")) {
            Assert.assertTrue(pageSource.contains("TRY ANOTHER WAY"));
            Assert.assertTrue(pageSource.contains("Next"));
        } else {
            Assert.assertTrue(pageSource.contains("CANCEL"));
            Assert.assertTrue(pageSource.contains("NEXT"));
        }
        Assert.assertTrue(pageSource.contains("2-Step Verification"));

    }

    @Then("the links will be valid")
    public void theLinksWillBeValid() throws Exception {
        myLogin.troubleSigningIn.click();
        //Account
        myBasePage.waitForText("Account");
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Account Recovery"));
        browserBack();
        myBasePage.waitForText("Sign In");
        //Terms of use
        myLogin.termsOfUse.click();
        myBasePage.waitForText("Terms of Use");
        Assert.assertTrue(pageSource.contains("Terms of Use"));
        browserBack();
        myBasePage.waitForText("Sign In");
        //Privacy Notice
        myLogin.privacyNotice.click();
        myBasePage.waitForText("Privacy Notice");
        Assert.assertTrue(pageSource.contains("Privacy Notice"));
        browserBack();
        myBasePage.waitForText("Sign In");


    }

    public void browserBack() throws Exception {
        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            driver.get().navigate().back();
        } else {
            myLogin.doneButton.click();
        }
    }


}
