package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.Expenses.Charge;
import LDSToolsAppium.API.Expenses.Expense;
import LDSToolsAppium.API.Expenses.Payee;
import LDSToolsAppium.API.Expenses.Receipt;
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
import org.openqa.selenium.By;
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
    PaymentRequests myPaymentRequests = new PaymentRequests();
    int responseCode;
    String pageSource;
    String payeeName = "";
    String myPurpose = "";
    String myReferenceNumber = "";
    Expense expenseRequest = new Expense();
    String userName = "";
    String unitNumber = "";



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
        Thread.sleep(4000);
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

        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.scrollDownIOS();
        } else {
            myBasePage.newScrollDown();
        }

        myBasePage.waitForElementThenClick(myFinance.financePaymentReceipt);
        myBasePage.waitForElementThenClick(myFinance.financePaymentReceiptApprove);

        myBasePage.waitForElementThenClick(myFinance.financePaymentApprove);

        //Need a big wait?
        //maybe a wait for element - text?
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.waitForElementThenClick(myFinance.financeSecondSubmitButton);
//            myBasePage.scrollUpIOS();
        } else {
            myBasePage.newScrollUp();
        }


        Thread.sleep(20000);

    }

    @When("the {string} with the {string} is Approved with the {string}")
    public void theExpensePayeeWithTheExpenseAmountIsApprovedWithThePaymentType(String expensePayee, String expenseAmount, String paymentType) throws Exception {
        LOGGER.info("an " +  expensePayee + " with the " + expenseAmount + " is Approved with the " + paymentType);
        String pageSource;

        selectExpenseByAmount(expenseAmount, "approve");

        Thread.sleep(500);
        pageSource = myBasePage.getSourceOfPage();
        String amountWithDot = addDotToAmount(expenseAmount);

        Assert.assertTrue(pageSource.contains(amountWithDot));
        Assert.assertTrue(pageSource.contains(expensePayee));
        pageSource = pageSource.toLowerCase();
        paymentType = paymentType.toLowerCase();
        Assert.assertTrue(pageSource.contains(paymentType));

//        myBasePage.waitForElementThenClick(myFinance.financePaymentType);
//        if (paymentType.equalsIgnoreCase("check")) {
//            myBasePage.waitForElementThenClick(myFinance.financePaymentTypeCheck);
//        } else {
//            myBasePage.waitForElementThenClick(myFinance.financePaymentTypeElectronicACHTransfer);
//        }

        myBasePage.newScrollIosAndroid();
        if (paymentType.equalsIgnoreCase("Advance payment")) {
            myBasePage.waitForElementThenClick(myFinance.financePaymentApprove);
        } else {
            myBasePage.waitForElementThenClick(myFinance.financePaymentReceipt);
            myBasePage.waitForElementThenClick(myFinance.financePaymentReceiptApprove);
            myBasePage.waitForElementThenClick(myFinance.financePaymentApprove);
        }


        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.waitForElementThenClick(myFinance.financePaymentApprove);
        } else {
            myBasePage.newScrollUp();
        }
        //Need a big wait?
        //maybe a wait for element - text?
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

        //Todo: Waiting for bug fix on iOS https://jira.churchofjesuschrist.org/browse/MMIP-6858
//        Assert.assertTrue(pageSource.contains(paymentType));

        apiCleanUpExpenses();
    }

    public String addDotToAmount(String expenseAmount) throws Exception {
        String amountWithDot;
        StringBuilder builder = new StringBuilder(expenseAmount);
        int x = 2;
        builder.insert(builder.length() - x, ".");
        System.out.println(builder);
        amountWithDot = builder.toString();
        return amountWithDot;
    }




    public void selectExpenseByAmount(String expenseAmount, String approveOrReview) throws Exception {
        WebElement amountElement = null;
        String amountWithDot = addDotToAmount(expenseAmount);
        myBasePage.newScrollToText(amountWithDot);
        if (approveOrReview.equalsIgnoreCase("approve")) {
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
//                amountElement = driver.get().findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='EXPENSES TO APPROVE']/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText[@name='"+ expenseAmount +"']"));
//                amountElement = driver.get().findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='"+ amountWithDot +"']"));
                amountElement = driver.get().findElement(AppiumBy.xpath("//*[contains(@name,'"+ amountWithDot +"')]"));
            } else {
//                amountElement = driver.get().findElement(AppiumBy.xpath("//*[@text='Expenses to Approve']/..//*[@text='" + amountWithDot + "']"));
                amountElement = driver.get().findElement(AppiumBy.xpath("//*[contains(@text,'" + amountWithDot + "')]"));
            }
        } else {
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
//                amountElement = driver.get().findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='EXPENSES TO REVIEW']/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText[@name='"+ expenseAmount +"']"));
                amountElement = driver.get().findElement(AppiumBy.xpath("//*[contains(@name,'"+ amountWithDot +"')]"));
            } else {
//                amountElement = driver.get().findElement(AppiumBy.xpath("//*[@text='Expenses to Review']/..//*[@text='" + expenseAmount + "']"));
                amountElement = driver.get().findElement(AppiumBy.xpath("//*[contains(@text,'" + amountWithDot + "')]"));
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


    @Then("the expense will be approved")
    public void theExpenseWillBeApproved() throws Exception {
        LOGGER.info("the expense will be approved");
        System.out.println("Something here!");
    }


    @And("is on the Expenses page")
    public void isOnTheExpensesPage() throws Exception {
        myMenu.selectMenu(myMenu.finance);
        myBasePage.waitForElementThenClick(myFinance.financeExpenses);
    }


    @When("an expense is filled out for  {string} {string} {string} {string} {string} {string} {string}")
    public void anExpenseIsFilledOutFor(String payee, String purpose, String paymentType, String addReceipt, String category, String categoryAmount, String referenceNumber) throws Exception {
        myBasePage.waitForElementThenClick(myFinance.addNewExpense);

        //Payee
        expenseAddAPayee(payee);
        //Purpose
        expenseAddPurpose(purpose);
        //Payment Type
        choosePaymentType(paymentType);
        //Reference Number
        chooseReferenceNumber(referenceNumber);
        //Add Receipt
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            driver.get().findElement(By.xpath("//*[@name='Reference Number']")).click();
            myBasePage.scrollDownIOS();
        }
        myPaymentRequests.addReceiptToPaymentRequest(addReceipt);
        //Set the Category
        myPaymentRequests.categorySub(category);
        //Set the amount
        myPaymentRequests.categoryAmountSub(categoryAmount);

        myFinance.paymentRequestsSubmitButton.click();

        waitForTransmitting();
//        Thread.sleep(60000);

    }

    public void waitForTransmitting() throws Exception {
        //wait for element?
        Thread.sleep(1000);
        myBasePage.waitForElementToDisappear(myFinance.transmittingIcon);
    }


    //Search and add a payee
    public void expenseAddAPayee(String payee) throws Exception {
        //Search for the payee
        Thread.sleep(1500);
        myBasePage.waitForElement(myFinance.searchFieldForPayee);
        myFinance.searchFieldForPayee.sendKeys(payee);
        Thread.sleep(1000);
        //Select the payee
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            driver.get().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + payee + "']")).click();
        } else {
            driver.get().findElement(By.xpath("//android.widget.TextView[@text='" + payee + "']/../..")).click();
        }
    }

    public void expenseAddPurpose(String purpose) throws Exception {
        int min = 1000;
        int max = 9998;
        double randomNumber = Math.random() * (max - min) + min;
        randomNumber = Math.round(randomNumber);
        myPurpose = purpose + " " + randomNumber;
        System.out.println("Purpose: " + myPurpose);
        myFinance.expensePurpose.sendKeys(myPurpose);
    }

    public void choosePaymentType(String paymentType) throws Exception {

        if (paymentType.equalsIgnoreCase("advance payment")) {
            //Turn on Advanced Payment
            myBasePage.waitForElementThenClick(myFinance.advancePaymentButton);
        } else {
            //Get the payment type
            String foundPaymentType;
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                foundPaymentType = myFinance.paymentTypeName.getAttribute("value");
            } else {
                foundPaymentType = myFinance.paymentTypeName.getAttribute("text");
            }
//        System.out.println("Found Payment Type: "  + foundPaymentType);
//        System.out.println("Looking for Payment Type: "  + paymentType);

            if (foundPaymentType.equalsIgnoreCase(paymentType)) {
                System.out.println("Payment Type is set");
            } else {
                myBasePage.waitForElementThenClick(myFinance.paymentTypeNameArrowButton);
                myBasePage.clickByTextName(paymentType);
            }
        }
    }

    public void chooseReferenceNumber(String referenceNumber) throws Exception {
        int min = 1000;
        int max = 9998;
        double randomNumber = Math.random() * (max - min) + min;
        randomNumber = Math.round(randomNumber);
        int randomInt = (int)randomNumber;
        if (referenceNumber.equalsIgnoreCase("none")) {
            System.out.println("No Reference Number");
        } else {
            if (referenceNumber.equalsIgnoreCase("random")) {
                myReferenceNumber = "1" + randomInt;
            } else {
                myReferenceNumber = referenceNumber;
            }
            System.out.println("Reference Number: " + myReferenceNumber);
            myFinance.referenceNumberField.sendKeys(myReferenceNumber);
        }
    }


    @Then("the expense will be processed with  {string} {string} {string} {string} {string} {string}")
    public void theExpenseWillBeProcessedWith(String payee, String status, String type, String addReceipt, String category, String categoryAmount) throws Exception {
        String message = "";
        Boolean receiptPresent = false;
        Expense myApiExpense = new Expense();
        //Check API
        //todo switch to finance object?
//        Map<String, Object> myMap = new HashMap<>();
//        myMap = apiTest.getExpensesDetail("dsoneil", "39373", myPurpose);
//
////        Assert.assertEquals(payee, myMap.get("payeeName").toString());
//        if (myMap.containsKey("amount")) {
//            Assert.assertEquals(categoryAmount, myMap.get("amount").toString());
//
//            //Have to do a contains because the api has the last name and the app doesn't
//            Assert.assertTrue(myMap.get("payeeName").toString().contains(payeeName));
//        }

        myApiExpense = apiTest.getExpenseReturnExpense(userName, unitNumber, myPurpose);
        System.out.println("Purpose: " + myApiExpense.getPurpose());

        Assert.assertTrue(myApiExpense.getStatus().equalsIgnoreCase(status), message);
        Assert.assertTrue(myApiExpense.getType().equalsIgnoreCase(type), message);

        //Check for receipt
        if (myApiExpense.getReceipts() != null) {
            for (Receipt myReceipt : myApiExpense.getReceipts()) {
                System.out.println("Receipt Name: " + myReceipt.getName());
                System.out.println("Receipt ID: " + myReceipt.getId());
            }
            receiptPresent = true;
        } else {
            System.out.println("No Receipt");
            receiptPresent = false;
        }
        if (addReceipt.equalsIgnoreCase("none")) {
            Assert.assertFalse(receiptPresent);
        } else {
            Assert.assertTrue(receiptPresent);
        }



        //Check GUI




        //Reject Expense
//        selectPayeeByName(payee);
//        rejectExpense();
    }

    @Given("a {string} logs in to {string}")
    public void aLogsInTo(String memberCalling, String unit) throws Exception {
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, unit);
        userName = callingRights[1];
        unitNumber = myHelper.getUnitNumber(unit);
        myHelper.proxyLogin(userName);
        myHelper.enterPin("1", "1", "3", "3");
    }



    public void selectPayeeByName(String payeeName) throws Exception {
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            driver.get().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + payeeName + "']")).click();
        } else {
            driver.get().findElement(By.xpath("//*[contains(@text, '" + payeeName + "')]")).click();
        }
    }

    public void rejectExpense() throws Exception {
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.scrollDownIOS();
        }
        myFinance.expenseRejectButton.click();

        if (myBasePage.getOS().equalsIgnoreCase("android")) {
            myFinance.rejectReasonPullDown.click();
            driver.get().setSetting("enableMultiWindows", true);
//            System.out.println(myBasePage.getSourceOfPage());
            myFinance.rejectReasonIncorrectCategory.click();
            myFinance.expenseRejectButton.click();
        } else {
            myFinance.rejectReasonIncorrectCategory.click();
        }


    }


}
