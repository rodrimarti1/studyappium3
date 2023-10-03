package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.Households.ApiHousehold;
import LDSToolsAppium.API.Households.Email;
import LDSToolsAppium.API.Households.Member;
import LDSToolsAppium.API.Households.Phone;
import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryEditScreen;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppiumTest.HelperMethods;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.Month;

//Business Requirements
//https://confluence.churchofjesuschrist.org/display/MSR/Privacy+Controls+-+Business+Requirements

public class Visibility extends BaseDriver {
    HelperMethods myHelper = new HelperMethods();
    BasePage myBasePage = new BasePage(driver);
    MenuScreen myMenu = new MenuScreen(driver);
    DirectoryEditScreen myDirectoryEdit = new DirectoryEditScreen(driver);
    DirectoryScreen myDirectory = new DirectoryScreen(driver);
    String pageSource;
    ApiHousehold myHousehold;
    Member oneMember;
    MemberToolsAPI apiTest = new MemberToolsAPI();
    String birthMonth;
    String birthDay;
    String birthYear;
    String age;

    @Given("the proxy {string} logs in")
    public void theProxyLogsIn(String userName) throws Exception {
        myHelper.proxyLogin(userName);
        myHelper.enterPin("1", "1", "3", "3");
    }


    @Given("a {string} logs in to the visibility pop up page")
    public void aLogsInToTheVisibilityPopUpPage(String userName) throws Exception {
        myHelper.proxyLogin(userName);
        myHelper.enterPinStayOnVisibilityPopUp("1", "1", "3", "3");
    }


    @When("Your Information Visibility page is displayed")
    public void yourInformationVisibilityPageIsDisplayed() throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Your Information Visibility"));
    }


    @Then("the Your Information Visibility information will be correct")
    public void theYourInformationVisibilityInformationWillBeCorrect() throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Your Information Visibility"));
        Assert.assertTrue(pageSource.contains("Understand who can view your information"));
        Assert.assertTrue(pageSource.contains("Because of the scriptural mandate to number, name, and nourish all in Christ’s Church (see Moroni 6:4–5), those with some callings will be able to access data that a member has selected for limited visibility. Those with access include stake and ward organization presidencies and those who have been delegated responsibility to minister and be ministered to."));

        Assert.assertTrue(myBasePage.checkForElement(myBasePage.visibilityPopUpAcknowledge));
    }


    @When("your personal information page is displayed")
    public void yourPersonalInformationPageIsDisplayed() throws Exception {
        myBasePage.visibilityPopUpAcknowledge.click();
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Your Information Visibility"));
        Assert.assertTrue(pageSource.contains("Decide your information's visibility"));
    }

    @Then("the personal information will be correct for {string}")
    public void thePersonalInformationWillBeCorrectFor(String memberName) throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        myBasePage.newScrollDown();
        pageSource = pageSource + myBasePage.getSourceOfPage();
        getHouseholdAndMemberInfoFromApi(memberName);
        Assert.assertTrue(pageSource.contains("Your Information Visibility"));
        Assert.assertTrue(pageSource.contains("Decide your information's visibility"));

        Assert.assertTrue(pageSource.contains("Visible to stake members"));
        Assert.assertTrue(pageSource.contains("Full Name"));
        Assert.assertTrue(pageSource.contains("Birth Year and Age"));
        Assert.assertTrue(pageSource.contains("Preferred Name"));
        Assert.assertTrue(pageSource.contains("Individual Photo"));
        Assert.assertTrue(pageSource.contains("Mailing Address"));
        Assert.assertTrue(pageSource.contains("Address"));
        Assert.assertTrue(pageSource.contains("Email"));
        for (Email myEmail: oneMember.getEmails()) {
            System.out.println(myEmail.getEmail());
            Assert.assertTrue(pageSource.contains(myEmail.getEmail()));
        }
        Assert.assertTrue(pageSource.contains("Phone"));
        for (Phone myPhone: oneMember.getPhones()) {
            System.out.println(myPhone.getE164());
//            Assert.assertTrue(pageSource.contains(myPhone.getE164().substring(myPhone.getE164().length() - 4)));
            Assert.assertTrue(pageSource.contains(convertPhoneNumber(myPhone.getE164())));
        }

        Assert.assertTrue(pageSource.contains("Visible to ward members"));
        Assert.assertTrue(pageSource.contains("Household Photo"));

        Assert.assertTrue(pageSource.contains("Visible to stake and ward organization presidencies"));
        Assert.assertTrue(pageSource.contains("Birthday and Month"));

        getAge(oneMember.getBirthDate());
        Assert.assertTrue(pageSource.contains(birthMonth));
        Assert.assertTrue(pageSource.contains(birthDay));

        Assert.assertTrue(myBasePage.checkForElement(myDirectoryEdit.editVisibilityButton));
        Assert.assertTrue(myBasePage.checkForElement(myBasePage.visibilityPopUpNext));
        Assert.assertTrue(myBasePage.checkForElement(myBasePage.visibilityPopUpBack));

        //Press the Edit visibility button
        myDirectoryEdit.editVisibilityButton.click();
        Thread.sleep(500);
        verifyInformationVisibilityDirectoryPage(memberName);
        myDirectoryEdit.closeEditVisibility.click();

    }

    @When("your Data settings page is displayed")
    public void yourDataSettingsPageIsDisplayed() throws Exception {
        myBasePage.visibilityPopUpNext.click();
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Data Settings"));
        Assert.assertTrue(pageSource.contains("Decide what data is downloaded"));
    }

    @Then("the Data settings page information will be correct")
    public void theDataSettingsPageInformationWillBeCorrect() throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Data Settings"));
        Assert.assertTrue(pageSource.contains("Decide what data is downloaded"));

        Assert.assertTrue(pageSource.contains("Updating"));
        Assert.assertTrue(pageSource.contains("Automatically, Wi-Fi only"));

        Assert.assertTrue(pageSource.contains("Photos"));
        Assert.assertTrue(pageSource.contains("Download ward and stake individual and household photos"));
        Assert.assertTrue(pageSource.contains("Download a photo of every temple"));

        Assert.assertTrue(pageSource.contains("Downloading photos could use a large amount of data"));

        Assert.assertTrue(myBasePage.checkForElement(myDirectoryEdit.editDataSettings));
        Assert.assertTrue(myBasePage.checkForElement(myBasePage.visibilityPopUpDone));
        Assert.assertTrue(myBasePage.checkForElement(myBasePage.visibilityPopUpBack));

        myDirectoryEdit.editDataSettings.click();
        Thread.sleep(500);
        //TODO: Check info and toggles
        myBasePage.dragHandleScrollAway();


        Assert.assertFalse(myBasePage.checkForElement(myBasePage.visibilityPopUpNext));
        Assert.assertFalse(myBasePage.checkForElement(myBasePage.visibilityPopUpAcknowledge));
    }

    @And("is on the Directory Page")
    public void isOnTheDirectoryPage() throws Exception {
        myMenu.selectMenu(myMenu.directory);
    }


    @When("the visibility settings are displayed for {string}")
    public void theVisibilitySettingsAreDisplayedFor(String userNameToSearch) throws Exception {
        myDirectory.searchAndClick(userNameToSearch);
        if (myBasePage.checkForElement(myDirectory.allowWhileUsingApp)) {
            myDirectory.allowWhileUsingApp.click();
        }
        //Change to scroll to text?
        myBasePage.newScrollDown();
        myDirectoryEdit.editInformationButton.click();
    }

    @Then("the visibility information will be correct for {string}")
    public void theVisibilityInformationWillBeCorrect(String memberName) throws Exception {
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Information Visibility"));
        Assert.assertTrue(myBasePage.checkForElement(myDirectoryEdit.helpEditVisibility));
        verifyInformationVisibilityDirectoryPage(memberName);
    }



    //Birth day and Month, Birth year and Age, phone, email, address, lat long?, ward clerk?
    public void verifyInformationVisibilityDirectoryPage(String memberName) throws Exception {
        getHouseholdAndMemberInfoFromApi(memberName);
        getAge(oneMember.getBirthDate());
        pageSource = myBasePage.getSourceOfPage();
        //Title Page will be different depending on how you get there.
        Assert.assertTrue(myBasePage.checkForElement(myDirectoryEdit.closeEditVisibility));


        //Name, Birthday and Age
        Assert.assertTrue(pageSource.contains("Name, Birthday and Age"));
        Assert.assertTrue(pageSource.contains("Full Name"));
        Assert.assertTrue(pageSource.contains(oneMember.getDisplayName()));
        Assert.assertTrue(pageSource.contains("Visible to stake members"));

        Assert.assertTrue(pageSource.contains("Preferred Name"));
        Assert.assertTrue(pageSource.contains(oneMember.getPreferredName()));
        Assert.assertTrue(pageSource.contains("Visible to stake members"));

        Assert.assertTrue(pageSource.contains("Birth Year and Age"));
        Assert.assertTrue(pageSource.contains(birthYear));
        Assert.assertTrue(pageSource.contains(age));
        Assert.assertTrue(pageSource.contains("Visible to stake members")); //This should change

        Assert.assertTrue(pageSource.contains("Birth Day and Month"));
        Assert.assertTrue(pageSource.contains(birthMonth));
        Assert.assertTrue(pageSource.contains(birthDay));
        Assert.assertTrue(myDirectoryEdit.birthDayAndMonthGetVisibility
                .getText()
                .equalsIgnoreCase(getVisibilitySettingFromApi(oneMember
                        .getPrivacy()
                        .getBirthDate())));

        //Page down here
        myBasePage.newScrollToText("Email");
        pageSource = pageSource + myBasePage.getSourceOfPage();

        Assert.assertTrue(pageSource.contains("Photo"));
        Assert.assertTrue(myDirectoryEdit.personalPhotoGetVisibility
                .getText()
                .equalsIgnoreCase(getVisibilitySettingFromApi(oneMember
                        .getPrivacy()
                        .getPhoto())));
    }

    public String getVisibilitySettingFromApi(String apiSetting) throws Exception {
        String returnString = null;
        if (apiSetting.equalsIgnoreCase("STAKE")) {
            returnString = "Visible to stake members";
        }
        if (apiSetting.equalsIgnoreCase("WARD")) {
            returnString = "Visible to ward members";
        }
        if (apiSetting.equalsIgnoreCase("LEADERS")) {
            returnString = "Visible to stake and ward organization presidencies";
        }

        System.out.println(returnString);
        return returnString;
    }

    public void getHouseholdAndMemberInfoFromApi(String memberName ) throws Exception {
        myHousehold = apiTest.getPersonalInfoFromNameAPI(memberName, "39373", "dsoneil");
        System.out.println(myHousehold.getFamilyName());
        for(Member searchFormember: myHousehold.getMembers()) {
            System.out.println(searchFormember.getDisplayName());
            if (searchFormember.getOfficialName().equalsIgnoreCase(memberName)) {
                System.out.println("Found: " + searchFormember.getDisplayName());
                oneMember = searchFormember;
            }
        }
    }



    public void getAge(String birthDate) throws Exception {
        LocalDate dob = LocalDate.parse(birthDate);

        int monthInt = dob.getMonthValue();
        int day = dob.getDayOfMonth();
        int year = dob.getYear();
        int ageInt = LocalDate.now().getYear() - dob.getYear();

        Month monthName = Month.of(monthInt);
        birthMonth = monthName.toString();
        System.out.println(birthMonth);
        birthMonth = birthMonth.toLowerCase();
        birthMonth = birthMonth.substring(0, 1).toUpperCase() + birthMonth.substring(1);
        System.out.println(birthMonth);
        birthDay = Integer.toString(day);
        birthYear = Integer.toString(year);
        age = Integer.toString(ageInt);
    }

    public String convertPhoneNumber(String inputNumber) throws Exception {
        String returnPhoneNumber;
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber formattedNumber = phoneUtil.parse(inputNumber, "US");
        System.out.println(formattedNumber.toString());
        System.out.println(phoneUtil.format(formattedNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL));
        returnPhoneNumber = phoneUtil.format(formattedNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
        return returnPhoneNumber;
    }



}
