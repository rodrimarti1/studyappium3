package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.FinanceScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
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
        apiCleanUpExpenses();
        //Bishop
        responseCode = apiTest.createPaymentRequest(2921, "e463aaf9-573f-4d17-8364-d4f4112cb517", "FSY Automated Test", 21628, 952, 776, "mbthomas74");
        responseCodeCheck(responseCode);

        //Relief Society
        responseCode = apiTest.createPaymentRequest(2921, "2ec59248-cb2e-452b-83a3-79fdf4847ea3", "Relief Society Automated Test", 21628, 25, 5399, "sharonstelter");
        System.out.println("CODE: " + responseCode);

        //Elders Quorum
        responseCode = apiTest.createPaymentRequest(2921, "d33a7122-a7cb-4538-90b0-02436034c610", "Elders Quorum Automated Test", 21628, 22, 6743, "clmarti");
        responseCodeCheck(responseCode);

        //Bishopric 1st Counselor
        responseCode = apiTest.createPaymentRequest(2921, "8c4b71ab-3d01-49ff-8699-41ec6116f993", "Activities Automated Test", 21628, 315, 14999, "lafaele40");
        responseCodeCheck(responseCode);
    }

    @Then("the default expenses will be setup")
    public void theDefaultExpensesWillBeSetup() throws Exception {
        apiCheckForExpense("FSY Automated Test");
        apiCheckForExpense("Relief Society Automated Test");
        apiCheckForExpense("Elders Quorum Automated Test");
        apiCheckForExpense("Activities Automated Test");
    }



    @Given("a {string} logs in and is on the Expenses page")
    public void aLeaderLogsInAndIsOnTheExpensesPage(String memberCalling) throws Exception {
        LOGGER.info("a " + memberCalling + " logs in and is on the Expenses page");
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.finance);
        Thread.sleep(1000);
        myBasePage.waitForElementThenClick(myFinance.financeExpenses);
    }


    @When("an {string} with the {string} is Reviewed with the {string}")
    public void anExpensePayeeWithTheExpenseAmountIsReviewedWithThePaymentType(String expensePayee, String expenseAmount, String paymentType) throws Exception {
        LOGGER.info("an " +  expensePayee + " with the " + expenseAmount + " is Reviewed with the " + paymentType);

        String pageSource;

        selectExpenseByAmount(expenseAmount, "review");

        Thread.sleep(500);
        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(pageSource.contains(expenseAmount));
        Assert.assertTrue(pageSource.contains(expensePayee));

        myBasePage.waitForElementThenClick(myFinance.financePaymentType);
        if (paymentType.equalsIgnoreCase("check")) {
            myBasePage.waitForElementThenClick(myFinance.financePaymentTypeCheck);
        } else {
            myBasePage.waitForElementThenClick(myFinance.financePaymentTypeElectronicACHTransfer);
        }

        myBasePage.waitForElementThenClick(myFinance.financePaymentReceipt);
        myBasePage.waitForElementThenClick(myFinance.financePaymentReceiptApprove);

        myBasePage.waitForElementThenClick(myFinance.financePaymentApprove);

        //Need a big wait?
        //maybe a wait for element - text?
        myBasePage.newScrollUp();

        Thread.sleep(20000);

    }

    @When("the {string} with the {string} is Approved with the {string}")
    public void theExpensePayeeWithTheExpenseAmountIsApprovedWithThePaymentType(String expensePayee, String expenseAmount, String paymentType) throws Exception {
        LOGGER.info("an " +  expensePayee + " with the " + expenseAmount + " is Approved with the " + paymentType);
        String pageSource;

        selectExpenseByAmount(expenseAmount, "approve");

        Thread.sleep(500);
        pageSource = myBasePage.getSourceOfPage();

        Assert.assertTrue(pageSource.contains(expenseAmount));
        Assert.assertTrue(pageSource.contains(expensePayee));

        myBasePage.waitForElementThenClick(myFinance.financePaymentType);
        if (paymentType.equalsIgnoreCase("check")) {
            myBasePage.waitForElementThenClick(myFinance.financePaymentTypeCheck);
        } else {
            myBasePage.waitForElementThenClick(myFinance.financePaymentTypeElectronicACHTransfer);
        }

        myBasePage.waitForElementThenClick(myFinance.financePaymentReceipt);
        myBasePage.waitForElementThenClick(myFinance.financePaymentReceiptApprove);
        myBasePage.waitForElementThenClick(myFinance.financePaymentApprove);

        //Need a big wait?
        //maybe a wait for element - text?
        myBasePage.newScrollUp();

        Thread.sleep(20000);
    }



    @Then("the expense with {string}, {string} and {string} will be under Expenses to Approve")
    public void theExpenseWithExpensePayeeExpenseAmountAndPaymentTypeWillBeUnderExpensesToApprove(String expensePayee, String expenseAmount, String paymentType) throws Exception {
        LOGGER.info("the expense with " + expensePayee + ", " + expenseAmount + " and " + paymentType +  "will be under Expenses to Approve");
        String pageSource;
        //Make sure filter is on for iOS?
        selectExpenseByAmount(expenseAmount, "approve");
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains(expenseAmount));
        Assert.assertTrue(pageSource.contains(expensePayee));
        Assert.assertTrue(pageSource.contains(paymentType));

        apiCleanUpExpenses();
    }






    public void selectExpenseByAmount(String expenseAmount, String approveOrReview) throws Exception {
        WebElement amountElement = null;
        myBasePage.newScrollToText(expenseAmount);
        if (approveOrReview.equalsIgnoreCase("approve")) {
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                amountElement = driver.get().findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='EXPENSES TO APPROVE']/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText[@name='"+ expenseAmount +"']"));
            } else {
                amountElement = driver.get().findElement(AppiumBy.xpath("//*[@text='Expenses to Approve']/..//*[@text='" + expenseAmount + "']"));
            }
        } else {
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                amountElement = driver.get().findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='EXPENSES TO REVIEW']/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText[@name='"+ expenseAmount +"']"));
            } else {
                amountElement = driver.get().findElement(AppiumBy.xpath("//*[@text='Expenses to Review']/..//*[@text='" + expenseAmount + "']"));
            }
        }

        amountElement.click();
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
        int myCounter = 0;
        do {
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
            myCounter++;
        } while (!myMap.isEmpty() && myCounter < 6);

    }


    @And("the user logs out")
    public void theUserLogsOut() throws Exception {
        LOGGER.info("the user logs out");
        myBasePage.backToDirectory();
        myMenu.menuLogOut();
    }


}
