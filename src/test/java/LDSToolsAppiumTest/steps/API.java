package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.LifeResources.LifeResource;
import LDSToolsAppium.API.LifeResources.Resource;
import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class API {

    HelperMethods myHelper = new HelperMethods();
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> memberList = new ArrayList<String>();
    int responseCode;
    int urlStatus;
    HashMap<String, String> listMap = new HashMap<>();
    LifeResource testLR = new LifeResource();


    @Given("a {string} account checks the Class and Quorum Attendance right")
    public void aMemberAccountChecksTheClassAndQuorumAttendanceRight(String memberCalling) throws Exception {
        String[] callingRights;
//        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Maplewood 2nd");
        memberList = apiTest.getClassAndQuorumRights(callingRights[1], "39373");
    }

    @Given("a {string} account checks the Reports")
    public void aMemberAccountChecksTheReports(String memberCalling) throws Exception {
        String[] callingRights;
//        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Maplewood 2nd");
        urlStatus = apiTest.getApiResponseCode( "reports?units=39373" , callingRights[1] );
    }

    @Then("the Reports {string} are visible")
    public void theReportsStatusAreVisible(String status) {
        if (status.equalsIgnoreCase("true")) {
            Assert.assertTrue(urlStatus >= 200 && urlStatus <= 299);
        }
        if (status.equalsIgnoreCase("false")) {
            Assert.assertTrue(urlStatus >= 400);
        }
    }


    @Then("the Class and Quorum editable field is {string}")
    public void theClassAndQuorumEditableFieldIsStatus(String status) throws Exception {
        for (String memberStatus : memberList) {
            System.out.println("Member Status: " + memberStatus + " Should be: " + status);
            Assert.assertTrue(memberStatus.equalsIgnoreCase(status));
        }
    }

    @Given("a {string} goes to the {string}")
    public void aMemberGoesToTheUrl(String member, String url) throws Exception {
        String[] callingRights;
//        callingRights = myHelper.getMemberNameFromList(member, "Centinela 1st");
        callingRights = myHelper.getMemberNameFromList(member, "Maplewood 2nd");
        urlStatus = apiTest.getApiResponseCode( url, callingRights[1] );
    }



    @Then("the status should be {string}")
    public void theStatusShouldBeStatus(String status) throws Exception {
        if (status.equalsIgnoreCase("Success")) {
            Assert.assertTrue(urlStatus >= 200 && urlStatus <= 299);
        }
        if (status.equalsIgnoreCase("Error")) {
            Assert.assertTrue(urlStatus >= 400);
        }
    }

    @Given("a member creates a list")
    public void aMemberCreatesAList() throws Exception {
        responseCode = apiTest.postListTest("ee4a2b31-a913-442a-9cef-70722cb55f3c", "TEST API",51, "50eff3b6-10c2-4caf-9c18-f070e41fc1ca", "mbthomas74");
        Assert.assertEquals(responseCode, 200);
    }

    @Then("the new list will be displayed")
    public void theNewListWillBeDisplayed() throws Exception {
        listMap = apiTest.getListNames("mbthomas74");
        Assert.assertTrue(listMap.containsKey("TEST API"));
    }

    @And("the list is deleted")
    public void theListIsDeleted() throws Exception {
        responseCode = apiTest.listDelete("TEST API", "mbthomas74");
        Assert.assertEquals(responseCode, 200);
    }

    @Then("the list will not be displayed")
    public void theListWillNotBeDisplayed() throws Exception {
        listMap = apiTest.getListNames("mbthomas74");
        Assert.assertFalse(listMap.containsKey("TEST API"));
    }

    @When("a {string} gets the life resources for the {string}")
    public void aMemberGetsTheLifeResourcesForTheUnit(String member, String unit) throws Exception {
        testLR = apiTest.getLifeResource("dsoneil", "502278");
    }

    @Then("the {string} {string} {string} {string} will match")
    public void theLRtoCheckPhoneEmailUrlWillMatch(String LRtoCheck, String phone, String email, String url) {
        String myPhone = null;
        String myEmail = null;
        String myUrl = null;

        for (Resource myResource: testLR.getResources()) {
//            System.out.println(myResource.getName());
            if (myResource.getName().equalsIgnoreCase(LRtoCheck)) {
//                System.out.println(myResource.getUrl());
                if (myResource.getPhone() == null) {
                    myPhone = "";
                } else {
                    myPhone = myResource.getPhone();
                }
                if (myResource.getEmail() == null) {
                    myEmail = "";
                } else {
                    myEmail = myResource.getEmail();
                }
                if (myResource.getUrl() == null) {
                    myUrl = "";
                } else {
                    myUrl = myResource.getUrl();
                }
            }
        }
        Assert.assertEquals(myPhone, phone);
        Assert.assertEquals(myEmail, email);
        Assert.assertEquals(myUrl, url);
    }


//    public API() {
//        Given("^a <member> account checks the Class and Quorum Attendance right$", () -> {
//        });
//    }
}
