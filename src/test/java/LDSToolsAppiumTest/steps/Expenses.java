package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.FinanceScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class Expenses extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    FinanceScreen myFinance = new FinanceScreen(driver);
    MemberToolsAPI apiTest = new MemberToolsAPI();
    int responseCode;



    @Given("the setup expense for the api is run")
    public void theSetupExpenseForTheApiIsRun() throws Exception {
        //Bishop
        responseCode = apiTest.createPaymentRequest(2921, "e463aaf9-573f-4d17-8364-d4f4112cb517", "FSY Automated Test", 21628, 952, 776, "mbthomas74");
        System.out.println("CODE: " + responseCode);

        //Relief Society
        responseCode = apiTest.createPaymentRequest(2921, "e8251ac7-2caf-4e9b-b297-8a8833611bc9", "Relief Society Automated Test", 21628, 25, 5399, "sonjalacrisolson");
        responseCodeCheck(responseCode);
//        responseCode = apiTest.createPaymentRequest(2921, "e8251ac7-2caf-4e9b-b297-8a8833611bc9", "Relief Society Automated Test #2", 21628, 25, 2299, "sonjalacrisolson");
//        responseCodeCheck(responseCode);

        //Elders Quorum
        responseCode = apiTest.createPaymentRequest(2921, "d33a7122-a7cb-4538-90b0-02436034c610", "Elders Quorum Automated Test", 21628, 22, 6743, "clmarti");
        responseCodeCheck(responseCode);
//        responseCode = apiTest.createPaymentRequest(2921, "d33a7122-a7cb-4538-90b0-02436034c610", "Elders Quorum Automated Test #2", 21628, 22, 6223, "clmarti");
//        responseCodeCheck(responseCode);

        //Bishopric 1st Counselor
        responseCode = apiTest.createPaymentRequest(2921, "8c4b71ab-3d01-49ff-8699-41ec6116f993", "Activities Automated Test", 21628, 315, 14999, "lafaele40");
        responseCodeCheck(responseCode);
//        responseCode = apiTest.createPaymentRequest(2921, "8c4b71ab-3d01-49ff-8699-41ec6116f993", "Activities Automated Test #2", 21628, 315, 20099, "lafaele40");
//        responseCodeCheck(responseCode);
    }

    @Then("the default expenses will be setup")
    public void theDefaultExpensesWillBeSetup() throws Exception {
        apiCheckForExpense("FSY Automated Test");
        apiCheckForExpense("Relief Society Automated Test");
        apiCheckForExpense("Elders Quorum Automated Test");
        apiCheckForExpense("Activities Automated Test");

//        apiCheckForExpense("Relief Society Automated Test #2");
//        apiCheckForExpense("Elders Quorum Automated Test #2");
//        apiCheckForExpense("Activities Automated Test #2");
    }



    public void responseCodeCheck(int responseCode) {
        System.out.println("CODE: " + responseCode);
        Assert.assertTrue(responseCode<399);
    }

    public void apiCheckForExpense(String purpose) throws Exception {
        Map<String, Object> myMap = new HashMap<>();
        String value;
        myMap = apiTest.getExpensesDetail("mbthomas74", "21628", purpose);
        for (String mapKey: myMap.keySet()) {
            String key = mapKey.toString();
            if (myMap.get(mapKey) == null) {
                value = "";
            } else {
                value = myMap.get(mapKey).toString();
            }
            System.out.println(key + " - " + value);
        }
        Assert.assertFalse(myMap.isEmpty());
    }

    public void apiCleanUpExpenses() throws Exception {
        apiDeleteExpense("mbthomas74" , "21628", "FSY Automated Test");
        apiDeleteExpense("mbthomas74" , "21628", "Relief Society Automated Test");
        apiDeleteExpense("mbthomas74" , "21628", "Elders Quorum Automated Test");
        apiDeleteExpense("mbthomas74" , "21628", "Activities Automated Test");
    }

    public void apiDeleteExpense(String proxyUser, String unitNumber, String purpose) throws Exception {
        Map<String, Object> myMap = new HashMap<>();
        String value;
        int myId = 0;
        String myType = null;
        myMap = apiTest.getExpensesDetail(proxyUser, unitNumber, purpose);
        if (!myMap.isEmpty()) {
            for (String mapKey: myMap.keySet()) {
                String key = mapKey.toString();
                if (myMap.get(mapKey) == null) {
                    value = "";
                } else {
                    value = myMap.get(mapKey).toString();
                }
                System.out.println(key + " - " + value);
            }

            myId = (int) myMap.get("id");
            myType = (String) myMap.get("type");
            responseCode = apiTest.expenseDelete(myId, myType, proxyUser);
            System.out.println("CODE: " + responseCode);

        }
    }



}
