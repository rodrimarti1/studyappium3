package LDSToolsAppiumTest;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DirectoryEditScreenTest extends BaseDriver {

    @Test (groups = {"all3", "all", "smoke", "smoke4", "daily", "daily3", "jft"})
    public void directoryEditScreenCheck() throws Exception {
        String pageSource;
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);

        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList("BISHOP", "Centinela 1st");

        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Martinez, Cesar L.");

        if (myBasePage.checkForElement(myDirectory.allowWhileUsingApp)) {
            myDirectory.allowWhileUsingApp.click();
        }

        Assert.assertTrue(myDirectory.directoryEdit.isDisplayed());
        myEditDirectory.editUserOpen();

        Assert.assertTrue(myEditDirectory.directoryEditHouseholdPhone.isDisplayed());
        Assert.assertTrue(myEditDirectory.directoryEditPersonalPhone.isDisplayed());
        Assert.assertTrue(myEditDirectory.directoryEditPersonalEmail.isDisplayed());
        Assert.assertTrue(myEditDirectory.directoryEditHouseholdEmail.isDisplayed());

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myEditDirectory.householdVisibilityLimit.click();
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(pageSource.contains("STAKE VISIBILITY"));
            Assert.assertTrue(pageSource.contains("WARD VISIBILITY"));
            Assert.assertTrue(pageSource.contains("PRIVATE"));
            myEditDirectory.stakeVisibility.click();
//            myEditDirectory.visiblityCancel.click();


            myEditDirectory.personalVisibility.click();
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(pageSource.contains("Image"));
            Assert.assertTrue(pageSource.contains("Phone"));
            Assert.assertTrue(pageSource.contains("Email"));
//            myEditDirectory.cancelButton.click();
            myEditDirectory.doneButton.click();

            Thread.sleep(2000);

            myEditDirectory.householdVisibility.click();
            pageSource = myBasePage.getSourceOfPage();
            Assert.assertTrue(pageSource.contains("Image"));
            Assert.assertTrue(pageSource.contains("Phone"));
            Assert.assertTrue(pageSource.contains("Email"));
            Assert.assertTrue(pageSource.contains("Address"));
            Assert.assertTrue(pageSource.contains("Show on Map"));
//            myEditDirectory.cancelButton.click();
            myEditDirectory.doneButton.click();

        } else {
            myEditDirectory.directoryPrivacyTab.click();
            pageSource = myBasePage.getSourceOfPage();
//            Assert.assertTrue(pageSource.contains("Image"));
            Assert.assertTrue(pageSource.contains("Photo"));
            Assert.assertTrue(pageSource.contains("Phone"));
            Assert.assertTrue(pageSource.contains("Email"));
//            myEditDirectory.visiblityCancel.click();
            myEditDirectory.menuSave.click();
        }
    }





    //TODO: Need to update sometimes fails. Timing issue?
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"smoke4", "smoke", "all2", "all", "daily", "daily1"})
    public void editCurrentUser() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);

        //Login and enter in PIN
//        myHelper.loginUAT("LDSTools44", "password1");
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Beeson, Adam");


        myEditDirectory.clearPhoneAndEmail();


        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        myEditDirectory.directoryEditPersonalPhone.sendKeys("1(801)240-0104");
        myEditDirectory.directoryEditHouseholdPhone.sendKeys("(801) 867-5309");
        myEditDirectory.directoryEditPersonalEmail.sendKeys("personal@gmail.com");
        if (getRunningOS().equals("ios")) {
            driver.get().findElement(By.name("Return")).click();
        }

        myEditDirectory.directoryEditHouseholdEmail.sendKeys("home@gmail.com");

        savingMemberInfo();

        Thread.sleep(3000);

        pageSource = myDirectory.getDirectoryUserData();
//        System.out.println(pageSource);

        //pageSource = getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));


        myBasePage.backToDirectory();


        //myHelper.runSync();
        myMenu.menuLogOut();
//        myHelper.loginUAT("LDSTools44", "password1");
        Thread.sleep(20000);


        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");

//        listsDirectoryUnit();


        //Search for logged in user
//        myDirectory.searchAndClick("Tools, LDS44");
        myDirectory.searchAndClick("Beeson, Adam");


        pageSource = myDirectory.getDirectoryUserData();

        Assert.assertTrue(myBasePage.checkNoCaseList("Beeson, Adam", pageSource, "Contains"));

        //Check the users name, address membership number etc...
        Assert.assertTrue(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));

        Thread.sleep(2000);
        myEditDirectory.clearPhoneAndEmail();


        Thread.sleep(2000);
        myBasePage.scrollDownTEST(-400);
        Thread.sleep(1000);
        myBasePage.backToDirectory();

        //Search for logged in user
//        myDirectory.searchAndClick("Tools, LDS44");
//
//        pageSource = myDirectory.getDirectoryUserData();
//        Assert.assertTrue(myBasePage.checkNoCaseList("Tools, LDS44", pageSource, "Contains"));
//
//
//        Thread.sleep(3000);
//        Assert.assertFalse(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
//        Assert.assertFalse(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));


    }

    //TODO: Need to update
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"smoke3", "smoke", "all3", "all"})
    public void editCurrentUserCancel() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
//        myHelper.loginUAT("LDSTools44", "password1");
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");

//        myDirectory.searchAndClick("Tools, LDS44");
        myDirectory.searchAndClick("Beeson, Adam");


        myEditDirectory.clearPhoneAndEmail();

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        myEditDirectory.directoryEditPersonalPhone.sendKeys("1(801)240-0104");
        myEditDirectory.directoryEditHouseholdPhone.sendKeys("(801) 867-5309");
        myEditDirectory.directoryEditPersonalEmail.sendKeys("personal@gmail.com");
        myEditDirectory.directoryEditHouseholdEmail.sendKeys("home@gmail.com");

        myEditDirectory.cancelButton.click();
        if (!getRunningOS().equals("ios")) {
            myBasePage.alertOK.click();
        }

        Thread.sleep(3000);
        pageSource = myDirectory.getDirectoryUserData();

        Assert.assertFalse(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));


    }

    //TODO: Need to update
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"smoke4", "smoke", "all4", "all"})
    public void editOtherUser() throws Exception {
        String pageSource;

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        //Login and enter in PIN
//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("mbthomas74");
        myHelper.enterPin("1", "1", "3", "3");

//        myDirectory.searchAndClick("Tools, LDS44");
        myDirectory.searchAndClick("Beeson, Adam");


        myEditDirectory.clearPhoneAndEmail();

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        myEditDirectory.directoryEditPersonalPhone.sendKeys("1(801)240-0104");
        myEditDirectory.directoryEditHouseholdPhone.sendKeys("(801) 867-5309");
        myEditDirectory.directoryEditPersonalEmail.sendKeys("personal@gmail.com");
        myEditDirectory.directoryEditHouseholdEmail.sendKeys("home@gmail.com");

        savingMemberInfo();

        pageSource = myDirectory.getDirectoryUserData();

        //pageSource = getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));


        myBasePage.backToDirectory();

        //myDirectory.sortToHousehold();

        //myHelper.runSync();


        myMenu.menuLogOut();
//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("mbthomas74");
        myHelper.enterPin("1", "1", "3", "3");

        listsDirectoryUnit();

        //Search for logged in user
//        myDirectory.searchAndClick("Tools, LDS44");
        myDirectory.searchAndClick("Beeson, Adam");

        pageSource = myDirectory.getDirectoryUserData();

        Assert.assertTrue(myBasePage.checkNoCaseList("Beeson, Adam", pageSource, "Contains"));

        //Check the users name, address membership number etc...
        Assert.assertTrue(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertTrue(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));

        Thread.sleep(2000);
        myEditDirectory.clearPhoneAndEmail();

        Thread.sleep(2000);
        myBasePage.scrollDownTEST(-400);
        Thread.sleep(1000);
        myBasePage.backToDirectory();

        myMenu.menuLogOut();
//        myHelper.loginUAT("LDSTools3", "toolstester");
        myHelper.proxyLogin("mbthomas74");
        myHelper.enterPin("1", "1", "3", "3");

//        listsDirectoryUnit();

        //Search for logged in user
//        myDirectory.searchAndClick("Tools, LDS44");
        myDirectory.searchAndClick("Beeson, Adam");

        pageSource = myDirectory.getDirectoryUserData();
        Assert.assertTrue(myBasePage.checkNoCaseList("Beeson, Adam", pageSource, "Contains"));


        Thread.sleep(3000);
        Assert.assertFalse(myBasePage.checkNoCaseList("1(801)240-0104", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("(801) 867-5309", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("personal@gmail.com", pageSource, "Contains"));
        Assert.assertFalse(myBasePage.checkNoCaseList("home@gmail.com", pageSource, "Contains"));


    }

    //TODO: Need to update
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"smoke1", "smoke", "all1", "all"})
    public void editPhoneInvalid() throws Exception {

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);

        //Login and enter in PIN
//        myHelper.loginUAT("LDSTools43", "password1");
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");

//        myDirectory.searchAndClick("Tools, LDS43");
        myDirectory.searchAndClick("Beeson, Adam");


        myEditDirectory.clearPhoneAndEmail();

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        myEditDirectory.directoryEditPersonalPhone.sendKeys("123456789012345678901234567890123456789012345678901234567890badbadleroybrown");
        saveInvalid("phone");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalPhone.clear();

//        myEditDirectory.directoryEditPersonalPhone.sendKeys("##################*************())()()()(()())(()()()");
//        saveInvalid("phone");
//        myEditDirectory.directoryEditPersonalPhone.clear();

        myEditDirectory.directoryEditPersonalPhone.sendKeys("     801     867             5309$");
        saveInvalid("phone");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalPhone.clear();

        myEditDirectory.directoryEditPersonalPhone.sendKeys("!@#$%^&*()_+!@#@#$$%$%^%*^*&(&*)");
        saveInvalid("phone");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalPhone.clear();

        myEditDirectory.directoryEditHouseholdPhone.sendKeys("123456789012345678901234567890123456789012345678901234567890badbadleroybrown");
        saveInvalid("phone");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalPhone.clear();

        myEditDirectory.directoryEditHouseholdPhone.sendKeys("##################*************())()()()(()())(()()()");
        saveInvalid("phone");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalPhone.clear();

        myEditDirectory.directoryEditHouseholdPhone.sendKeys("     801     867             5309$");
        saveInvalid("phone");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalPhone.clear();

        myEditDirectory.directoryEditHouseholdPhone.sendKeys("!@#$%^&*()_+!@#@#$$%$%^%*^*&(&*)");
        saveInvalid("phone");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalPhone.clear();

        savingMemberInfo();

    }

    //TODO: Need to update
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"smoke1", "smoke", "all1", "all"})
    public void editEmailInvalid() throws Exception {

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);

//        myHelper.loginUAT("LDSTools43", "password1");
        myHelper.proxyLogin("adambee");
        myHelper.enterPin("1", "1", "3", "3");

//        myDirectory.searchAndClick("Tools, LDS43");
        myDirectory.searchAndClick("Beeson, Adam");



        myEditDirectory.clearPhoneAndEmail();

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        myEditDirectory.directoryEditPersonalEmail.sendKeys("hello there");
        saveInvalid("email");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalEmail.clear();

        myEditDirectory.directoryEditPersonalEmail.sendKeys("notatsign.com");
        saveInvalid("email");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalEmail.clear();

        myEditDirectory.directoryEditPersonalEmail.sendKeys("nodotafterthe@sign");
        saveInvalid("email");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalEmail.clear();

        myEditDirectory.directoryEditPersonalEmail.sendKeys("!@#$%^&*()_+!@#@#$$%$%^%*^*&(&*)");
        saveInvalid("email");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalEmail.clear();

        myEditDirectory.directoryEditHouseholdEmail.sendKeys("hello there");
        saveInvalid("email");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalEmail.clear();

        myEditDirectory.directoryEditHouseholdEmail.sendKeys("notatsign.com");
        saveInvalid("email");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalEmail.clear();

        myEditDirectory.directoryEditHouseholdEmail.sendKeys("nodotafterthe@sign");
        saveInvalid("email");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalEmail.clear();

        myEditDirectory.directoryEditHouseholdEmail.sendKeys("!@#$%^&*()_+!@#@#$$%$%^%*^*&(&*)");
        saveInvalid("email");
        myEditDirectory.editUserOpen();
//        myEditDirectory.directoryEditPersonalEmail.clear();

        savingMemberInfo();

    }

    //TODO: Need to update
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"smoke1", "smoke", "all1", "all"})
    public void editVisibility() throws Exception {

        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        BasePage myBase = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);
        SyncScreen mySync = new SyncScreen(driver);

        Boolean foundMember;


        //Login and enter in PIN
        myHelper.proxyLogin("dcbryson");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Bryson, David");

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        //Reset Visibility
        myEditDirectory.resetVisibility();
        myEditDirectory.editUserOpen();

        myEditDirectory.setVisibilityHousehold(myEditDirectory.privateLeadershipOnly);

        //myEditDirectory.menuSave.click();

        myBase.backToDirectory();

        mySync.manualUpdate();

        myMenu.menuLogOut();

        Thread.sleep(2000);

        //Make sure members without callings cannot see the members info
        myHelper.proxyLogin("Kimburrell");
        myHelper.enterPin("1", "1", "3", "3");

        listsDirectoryUnit();

        foundMember = myDirectory.searchForMemberCheckResults("Bryson, David");
        Assert.assertFalse(foundMember);
        Thread.sleep(2000);
        myBase.backToDirectory();
        myMenu.menuLogOut();

        //Check Ward Council Access
        myHelper.proxyLogin("RIBITALOT@AOL.COM");
        myHelper.enterPin("1", "1", "3", "3");

        listsDirectoryUnit();

        foundMember = myDirectory.searchForMemberCheckResults("Bryson, David");
        Assert.assertTrue(foundMember);
        Thread.sleep(2000);
        myBase.backToDirectory();
        myMenu.menuLogOut();

        //Reset visibility settings back to normal
        myHelper.proxyLogin("dcbryson");
        myHelper.enterPin("1", "1", "3", "3");

        listsDirectoryUnit();

        myDirectory.searchAndClick("Bryson, David");

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        //Reset Visibility
        myEditDirectory.resetVisibility();
        //myEditDirectory.menuSave.click();
        myBase.backToDirectory();

        mySync.manualUpdate();

        myMenu.menuLogOut();

        Thread.sleep(60000);

        //Make sure everything is back to default
        //Make sure members without callings cannot see the members info
        myHelper.proxyLogin("Kimburrell");
        myHelper.enterPin("1", "1", "3", "3");

        listsDirectoryUnit();

        foundMember = myDirectory.searchForMemberCheckResults("Bryson, David");
        Assert.assertTrue(foundMember);


    }

    //TODO: Need to update
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"all3", "all"})
    public void editVisibilityPersonalEmail() throws Exception {
        visibilityTestSub("personal", "email");
    }

    //TODO: Need to update
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"all4", "all"})
    public void editVisibilityPersonalPhone() throws Exception {
        visibilityTestSub("personal", "phone");
    }

    //TODO: Need to update
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"all2", "all"})
    public void editVisibilityHouseholdEmail() throws Exception {
        visibilityTestSub("household", "email");
    }

    //TODO: Need to update
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"all1", "all"})
    public void editVisibilityHouseholdPhone() throws Exception {
        visibilityTestSub("household", "phone");
    }

    //TODO: Need to update
    @Test(groups = {"needUpdate"})
//    @Test(groups = {"all4", "all"})
    public void editVisibilityHouseholdAddress() throws Exception {
        visibilityTestSub("household", "address");
    }


    private void visibilityTestSub(String visibilityType, String visibilityItem) throws Exception {
        String pageSource;
        // ********* Constructor **********
        HelperMethods myHelper = new HelperMethods();
        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        BasePage myBase = new BasePage(driver);
        MenuScreen myMenu = new MenuScreen(driver);



        //Login and enter in PIN
        myHelper.proxyLogin("dcbryson");
        myHelper.enterPin("1", "1", "3", "3");

        myDirectory.searchAndClick("Bryson, David");

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        myEditDirectory.directoryEditHouseholdPhone.clear();
        myEditDirectory.directoryEditHouseholdPhone.sendKeys("801-867-5309");

        //Reset Visibility
        myEditDirectory.resetVisibility();
        myEditDirectory.editUserOpen();

        if (visibilityType.equalsIgnoreCase("personal")) {
            if (getRunningOS().equalsIgnoreCase("ios")) {
                myEditDirectory.personalVisibility.click();
            } else {
                myEditDirectory.directoryPrivacyTab.click();
            }
        } else {
            if (getRunningOS().equalsIgnoreCase("ios")) {
                myEditDirectory.householdVisibility.click();
            } else {
                myEditDirectory.directoryPrivacyTab.click();
            }
        }

        if (visibilityType.equalsIgnoreCase("personal")) {
            switch(visibilityItem) {
                case "image":
                    myEditDirectory.imagePersonal.click();
                    break;
                case "phone":
                    myEditDirectory.phonePersonal.click();
                    break;
                case "email":
                    myEditDirectory.emailPersonal.click();
                    break;
            }
        }

        if (visibilityType.equalsIgnoreCase("household")) {
            switch(visibilityItem) {
                case "image":
                    myEditDirectory.imageHousehold.click();
                    break;
                case "phone":
                    myEditDirectory.phoneHousehold.click();
                    break;
                case "email":
                    myBase.scrollToTextScollArea("Show on Map");
                    myEditDirectory.emailHousehold.click();
                    break;
                case "address":
                    myBase.scrollToTextScollArea("Show on Map");
                    myEditDirectory.physicalAddress.click();
                    break;
                case "onmap":
                    myBase.scrollToTextScollArea("Show on Map");
                    myEditDirectory.showOnMap.click();
                    break;
            }
        }


        myEditDirectory.popUpPrivateLeadershipOnly.click();

        if (getRunningOS().equalsIgnoreCase("ios")) {
            myEditDirectory.doneButton.click();
        }
        myEditDirectory.menuSave.click();

        myBase.backToDirectory();
        myMenu.menuLogOut();


        //Make sure members without callings cannot see the private email
        myHelper.proxyLogin("Kimburrell");
        myHelper.enterPin("1", "1", "3", "3");

        listsDirectoryUnit();

        myDirectory.searchAndClick("Bryson, David");
        pageSource = myDirectory.getDirectoryUserData();

        Assert.assertTrue(myBase.checkNoCaseList("David", pageSource, "Contains"));
        if (visibilityType.equalsIgnoreCase("personal")) {
            if (visibilityItem.equalsIgnoreCase("phone")) {
                Assert.assertFalse(myBase.checkNoCaseList("678-654-6185", pageSource, "Contains"));
                Assert.assertTrue(myBase.checkNoCaseList("brysonite@gmail.com", pageSource, "Contains"));
            }
            if (visibilityItem.equalsIgnoreCase("email")) {
                Assert.assertTrue(myBase.checkNoCaseList("678-654-6185", pageSource, "Contains"));
                Assert.assertFalse(myBase.checkNoCaseList("brysonite@gmail.com", pageSource, "Contains"));
            }
        } else {
            Assert.assertTrue(myBase.checkNoCaseList("678-654-6185", pageSource, "Contains"));
            Assert.assertTrue(myBase.checkNoCaseList("brysonite@gmail.com", pageSource, "Contains"));
        }

        if (visibilityType.equalsIgnoreCase("household")) {
            if (visibilityItem.equalsIgnoreCase("phone")) {
                Assert.assertFalse(myBase.checkNoCaseList("801-867-5309", pageSource, "Contains"));
                Assert.assertTrue(myBase.checkNoCaseList("dbcbryson@gmail.com", pageSource, "Contains"));
                //Address
                Assert.assertTrue(myBase.checkNoCaseList("13622 Chadron Ave", pageSource, "Contains"));
                Assert.assertTrue(myBase.checkNoCaseList("Apt 41", pageSource, "Contains"));
                Assert.assertTrue(myBase.checkNoCaseList("Hawthorne, California", pageSource, "Contains"));
                Assert.assertTrue(myBase.checkNoCaseList("90250", pageSource, "Contains"));
            }
            if (visibilityItem.equalsIgnoreCase("email")) {
                Assert.assertTrue(myBase.checkNoCaseList("801-867-5309", pageSource, "Contains"));
                Assert.assertFalse(myBase.checkNoCaseList("dbcbryson@gmail.com", pageSource, "Contains"));
                //Address
                Assert.assertTrue(myBase.checkNoCaseList("13622 Chadron Ave", pageSource, "Contains"));
                Assert.assertTrue(myBase.checkNoCaseList("Apt 41", pageSource, "Contains"));
                Assert.assertTrue(myBase.checkNoCaseList("Hawthorne, California", pageSource, "Contains"));
                Assert.assertTrue(myBase.checkNoCaseList("90250", pageSource, "Contains"));
            }
            if (visibilityItem.equalsIgnoreCase("address")) {
                Assert.assertTrue(myBase.checkNoCaseList("801-867-5309", pageSource, "Contains"));
                Assert.assertTrue(myBase.checkNoCaseList("dbcbryson@gmail.com", pageSource, "Contains"));
                //Address
                Assert.assertFalse(myBase.checkNoCaseList("13622 Chadron Ave", pageSource, "Contains"));
                Assert.assertFalse(myBase.checkNoCaseList("Apt 41", pageSource, "Contains"));
                Assert.assertFalse(myBase.checkNoCaseList("Hawthorne, California", pageSource, "Contains"));
                Assert.assertFalse(myBase.checkNoCaseList("90250", pageSource, "Contains"));
            }
        } else {
            Assert.assertTrue(myBase.checkNoCaseList("801-867-5309", pageSource, "Contains"));
            Assert.assertTrue(myBase.checkNoCaseList("dbcbryson@gmail.com", pageSource, "Contains"));
            //Address
            Assert.assertTrue(myBase.checkNoCaseList("13622 Chadron Ave", pageSource, "Contains"));
            Assert.assertTrue(myBase.checkNoCaseList("Apt 41", pageSource, "Contains"));
            Assert.assertTrue(myBase.checkNoCaseList("Hawthorne, California", pageSource, "Contains"));
            Assert.assertTrue(myBase.checkNoCaseList("90250", pageSource, "Contains"));
        }


        myBase.backToDirectory();
        myMenu.menuLogOut();

        //Make sure members with callings can see the private email
//        myHelper.loginUAT("LDSTools21", "password1");
        myHelper.proxyLogin("RIBITALOT@AOL.COM");
        myHelper.enterPin("1", "1", "3", "3");

        listsDirectoryUnit();

        myDirectory.searchAndClick("Bryson, David");
        pageSource = myDirectory.getDirectoryUserData();

        Assert.assertTrue(myBase.checkNoCaseList("David", pageSource, "Contains"));
        //Personal
        Assert.assertTrue(myBase.checkNoCaseList("678-654-6185", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("brysonite@gmail.com", pageSource, "Contains"));
        //Household
        Assert.assertTrue(myBase.checkNoCaseList("801-867-5309", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("dbcbryson@gmail.com", pageSource, "Contains"));
        //Address
        Assert.assertTrue(myBase.checkNoCaseList("13622 Chadron Ave", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("Apt 41", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("Hawthorne, California", pageSource, "Contains"));
        Assert.assertTrue(myBase.checkNoCaseList("90250", pageSource, "Contains"));
        myBase.backToDirectory();
        myMenu.menuLogOut();



        //Clean up
        myHelper.proxyLogin("dcbryson");
        myHelper.enterPin("1", "1", "3", "3");

        listsDirectoryUnit();

        myDirectory.searchAndClick("Bryson, David");

        myEditDirectory.editUserOpen();
        Thread.sleep(2000);

        //Reset Visibility
        myEditDirectory.resetVisibility();
    }




    private void saveInvalid(String myType) throws Exception {
        boolean failedFound;
        String pageSource;

        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        BasePage myBasePage = new BasePage(driver);

//        if (getRunningOS().equals("ios")) {
//            myEditDirectory.menuSave.click();
//        }

        Thread.sleep(2000);

        if (myType.equals("phone")) {
            myEditDirectory.menuSave.click();
            failedFound = myBasePage.checkForElement(myEditDirectory.saveFailedDialog);
            Assert.assertTrue(failedFound);
            myBasePage.alertOK.click();
        } else {
            if (getRunningOS().equals("ios")) {
                myEditDirectory.menuSave.click();
                failedFound = myBasePage.checkForElement(myEditDirectory.invalidEmail);
            } else {
                myEditDirectory.menuSave.click();
                pageSource = myBasePage.getSourceOfPage();
//                failedFound = myBasePage.checkNoCaseList("you must provide a valid email address", pageSource, "Contains");
                failedFound = myBasePage.checkNoCaseList("Failed", pageSource, "Contains");
                myBasePage.alertOK.click();
            }
            Assert.assertTrue(failedFound);
            if (getRunningOS().equals("ios")) {
                myBasePage.alertOK.click();
            }
        }


    }



    private void savingMemberInfo() throws Exception{
        int myCounter = 0;

        DirectoryScreen myDirectory = new DirectoryScreen(driver);
        DirectoryEditScreen myEditDirectory = new DirectoryEditScreen(driver);
        BasePage myBasePage = new BasePage(driver);

        do {
            myEditDirectory.menuSave.click();
            myBasePage.waitUnitlTextIsGone("Saving");
            Thread.sleep(6000);

            if (myBasePage.checkForAlert()) {
                myBasePage.alertOK.click();
                myCounter++;
                System.out.println("Alert Found: " + myCounter);
            } else {
                myCounter = 6;
            }

        } while (myCounter < 4);

        if (myBasePage.checkForAlert()) {
            myBasePage.alertOK.click();
            myDirectory.directoryEdit.click();
            myBasePage.waitUnitlTextIsGone("Downloading");
            Thread.sleep(6000);
        }
    }


    private void chooseUnit(String myUnit) throws Exception {
        DirectoryEditScreen myDirectoryEdit = new DirectoryEditScreen(driver);
        BasePage myBasePage = new BasePage(driver);
        //Choose different Unit
        System.out.println("Press the selector");
        myDirectoryEdit.unitSelector.click();
        Thread.sleep(2000);
        System.out.println("Choose unit: " + myUnit);

        System.out.println(myBasePage.getSourceOfPage());

        if (getRunningOS().equalsIgnoreCase("ios")) {
            driver.get().findElement(By.xpath("//*[contains(@name,'" + myUnit + "')]")).click();
        } else {
            driver.get().findElement(By.xpath("//*[contains(@text,'" + myUnit + "')]")).click();
        }

    }

    private void listsDirectoryUnit() throws Exception {
        MenuScreen myMenu = new MenuScreen(driver);
        //For some reason after you log out - login the system needs this
        myMenu.selectMenu(myMenu.lists);
        Thread.sleep(1000);
        myMenu.selectMenu(myMenu.directory);
        Thread.sleep(1000);
        chooseUnit("Centinela 1st Ward");
//        chooseUnit("1st Ward");
    }




}
