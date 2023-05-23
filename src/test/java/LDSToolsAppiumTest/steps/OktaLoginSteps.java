package LDSToolsAppiumTest.steps;


import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;

import LDSToolsAppium.Screen.LoginPageScreen;

import io.appium.java_client.remote.SupportsContextSwitching;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.binary.Base64;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class OktaLoginSteps extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    LoginPageScreen myLogin = new LoginPageScreen(driver);
    String pageSource;
    String username;
    String password;
    String twoFactor;


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

        Assert.assertTrue(pageSource.contains("Sign In"));
        Assert.assertTrue(pageSource.contains("Username"));
        if (myBasePage.getOS().equals("ios")) {
            Assert.assertTrue(pageSource.contains("Need help signing in?"));

        } else {
            Assert.assertTrue(pageSource.contains("Forgot your username?"));
        }

        goodUserName("zmaxfield");

        //Password Page
        pageSource = myBasePage.getSourceOfPage();
        if (myBasePage.getOS().equals("ios")) {
            Assert.assertTrue(pageSource.contains("Enter your password"));
            Assert.assertTrue(pageSource.contains("Need help signing in?"));
            Assert.assertTrue(pageSource.contains("Next"));

        } else {
            Assert.assertTrue(pageSource.contains("Password"));
            Assert.assertTrue(pageSource.contains("Cancel"));
            Assert.assertTrue(pageSource.contains("Next"));
        }

        goodPassword();

        //2-Step Verification
        pageSource = myBasePage.getSourceOfPage();
        if (myBasePage.getOS().equals("ios")) {
            Assert.assertTrue(pageSource.contains("TRY ANOTHER WAY"));
            Assert.assertTrue(pageSource.contains("Next"));
        } else {
            Assert.assertTrue(pageSource.contains("Cancel"));
            Assert.assertTrue(pageSource.contains("Next"));
        }
        Assert.assertTrue(pageSource.contains("2-Step Verification"));

    }

    @Then("the links will be valid")
    public void theLinksWillBeValid() throws Exception {
//        System.out.println(myBasePage.getSourceOfPage());
        myLogin.troubleSigningIn.click();
        Thread.sleep(600);
        if (getRunningOS().equalsIgnoreCase("ios")) {
            //Account
            myBasePage.waitForText("Account");
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(pageSource.contains("Account Recovery"));
        } else {
            myBasePage.waitForText("account");
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(pageSource.contains("account.churchofjesuschrist.org"));
//            myBasePage.printPageSource();
        }
        browserBack();
        myBasePage.waitForText("Sign In");
        //Terms of use
        Thread.sleep(500);
        myLogin.termsOfUse.click();
        Thread.sleep(1000);
        myBasePage.waitForText("Terms of Use");
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Terms of Use"));
        Thread.sleep(500);
        browserBack();
        myBasePage.waitForText("Sign In");
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            //Privacy Notice
            myLogin.privacyNotice.click();
            Thread.sleep(1000);
            myBasePage.waitForText("Privacy Notice");
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(pageSource.contains("Privacy Notice"));
            browserBack();
            myBasePage.waitForText("Sign In");
        }



    }

    @When("user name {string} is entered")
    public void userNameUserNameIsEntered(String userName) throws Exception {
        goodUserName(userName);
    }

    @And("a password {string} is entered")
    public void aPasswordInvalidPasswordIsEntered(String passWord) throws Exception {
        customPassword(passWord);
    }

    @Then("an invalid password error will be displayed")
    public void anInvalidPasswordErrorWillBeDisplayed() throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            Assert.assertTrue(pageSource.contains("Invalid Password"));
        } else {
            Assert.assertTrue(pageSource.contains("Invalid password"));
            myLogin.invalidPasswordOK.click();
        }
        myLogin.passWord.clear();
    }

    @When("a valid username and password are entered")
    public void aValidUsernameAndPasswordAreEntered() throws Exception {
        goodUserName("zmaxfield");
        goodPassword();
    }

    @And("an {string} is entered")
    public void anInvalidTwoFactorIsEntered(String twoFactor) throws Exception {
        myBasePage.waitForElement(myLogin.twoFactorEdit);
        myLogin.twoFactorEdit.clear();
        myLogin.twoFactorEdit.sendKeys(twoFactor);
        myLogin.nextButton.click();
        Thread.sleep(2000);
    }

    @Then("an invalid two factor error will be displayed")
    public void anInvalidTwoFactorErrorWillBeDisplayed() throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            Assert.assertTrue(pageSource.contains("Invalid Passcode"));
            myLogin.twoFactorEdit.clear();
        } else {
            Assert.assertTrue(pageSource.contains("Try another way to sign in"));
//            myLogin.twoFactorBack.click();
        }

    }

    public void browserBack() throws Exception {
        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            driver.get().navigate().back();
        } else {
            myLogin.doneButton.click();
        }
    }

    public void goodUserName(String userName) throws Exception {
        myLogin.loginName.clear();
        myLogin.loginName.sendKeys(userName);
        myLogin.nextButton.click();
        Thread.sleep(1300);
    }

    public void goodPassword() throws Exception {
        getInfoFromProperties();
        byte[] decodeBytes = Base64.decodeBase64(password);
        myBasePage.waitForElement(myLogin.passWord);
        myLogin.passWord.sendKeys(new String(decodeBytes));
        myLogin.nextButton.click();
        Thread.sleep(1300);
    }

    public void customPassword(String passWord) throws Exception {
        myBasePage.waitForElement(myLogin.passWord);
        myLogin.passWord.sendKeys(passWord);
        myLogin.nextButton.click();
        Thread.sleep(1300);
    }

    public void getInfoFromProperties() throws Exception {
        try (InputStream input = Files.newInputStream(Paths.get("ConfigFiles/config.properties"))) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);

            username = (prop.getProperty("db.user"));
            password = prop.getProperty("db.password");
            twoFactor = prop.getProperty("db.twoFactor");


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



}
