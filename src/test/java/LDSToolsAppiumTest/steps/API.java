package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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


    @Given("a {string} account checks the Class and Quorum Attendance right")
    public void aMemberAccountChecksTheClassAndQuorumAttendanceRight(String memberCalling) throws Exception {
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        memberList = apiTest.getClassAndQuorumRights(callingRights[1], "21628");
    }

    @Given("a {string} account checks the Reports")
    public void aMemberAccountChecksTheReports(String memberCalling) throws Exception {
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        urlStatus = apiTest.getApiResponseCode( "reports?units=21628" , callingRights[1] );
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
        responseCode = apiTest.postListTest("ee4a2b31-a913-442a-9cef-70722cb55f3c", "TEST API",51, "50eff3b6-10c2-4caf-9c18-f070e41fc1ca");
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




//    public API() {
//        Given("^a <member> account checks the Class and Quorum Attendance right$", () -> {
//        });
//    }
}
