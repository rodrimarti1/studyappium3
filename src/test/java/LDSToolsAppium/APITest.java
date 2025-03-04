package LDSToolsAppium;

import LDSToolsAppium.API.*;
import LDSToolsAppium.API.Expenses.*;
import LDSToolsAppium.API.Households.ApiHousehold;
import LDSToolsAppium.API.Households.Email;
import LDSToolsAppium.API.Households.Member;
import LDSToolsAppium.API.Households.Phone;
import LDSToolsAppium.API.LifeResources.Contact;
import LDSToolsAppium.API.LifeResources.LifeResource;
import LDSToolsAppium.API.LifeResources.Resource;
//import LDSToolsAppium.API.ApiFinanceMethod;
//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
//import com.google.gson.reflect.TypeToken;
//import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.TypeKey;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;

import LDSToolsAppium.API.QuarterlyReport.Convert;
import LDSToolsAppium.API.QuarterlyReport.Entry;
import LDSToolsAppium.API.QuarterlyReport.QuarterlyReport;
import LDSToolsAppium.API.QuarterlyReport.Section;
import LDSToolsAppiumTest.steps.Expenses;
import LDSToolsAppiumTest.steps.Visibility;
import org.jboss.aerogear.security.otp.Totp;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.desktop.SystemEventListener;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

import org.apache.commons.codec.binary.Base64;


public class APITest {

    List<String> memberList = new ArrayList<String>();
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> reportNameToCheck = new ArrayList<>();
    String rawData;

//    111074 - AburnHill
//    258598 - Fagamalo 2nd
//    39373 - Maplewood 2nd
//    356832 - Foxhill ward
    // 111856 = WJ 21st

    String unitNumber = "21628";
    String proxyLogin = "mbthomas74";

    String accessToken;
    String idToken;
    HashMap<String, String> listMap = new HashMap<>();

//    "a1479b4c-df02-4454-bdb6-576f12473193"

    @BeforeTest
    public void setup() throws Exception {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL %4$-7s [%3$s] %5$s %6$s%n");
    }

//    @Test
    public void restAssuredTest() throws Exception {
        String testURL;
        apiTest.loginCred();

    }

//    @Test
    public void ResponseCheck() throws Exception {
        int urlStatus;
        urlStatus = apiTest.getApiResponseCode("households", "mbthomas74");
        System.out.println("STATUS: " + urlStatus);
    }

//    @Test
    public void BearerTokenCheck() throws Exception {
        apiTest.getAccessToken();
    }

//    @Test
    public void QRTest() throws Exception {
        QuarterlyReport testQR = new QuarterlyReport();
        testQR = apiTest.getQuarterlyReport("dsoneil", "39373", "2022", 4);
//        testQR = apiTest.getQuarterlyReport("mbthomas74", "21628", "2022", 4);
        System.out.println(testQR.getQuarter());
        System.out.println(testQR.getYear());
        System.out.println(testQR.getSubmitDate());
        for (Section mySection: testQR.getSections()) {
            System.out.println( mySection.getName());
            for (Entry myEntry : mySection.getEntries()) {
                System.out.println(myEntry.getName());
                System.out.println("Actual: "+ myEntry.getActual());
                System.out.println("Potential: " + myEntry.getPotential());
//                System.out.println("Type: " + myEntry.getType());
//                System.out.println("Editable: " + myEntry.getEditable());
            }
            System.out.println("******************************************");
        }
        for (Convert myConvert: testQR.getConverts()) {
            System.out.println(myConvert.getDisplayName());
        }
    }

    //Life Resource make sure the unit it the Stake
//    @Test
    public void LifeResourceTest() throws Exception {
        LifeResource testLR = new LifeResource();
        testLR = apiTest.getLifeResource("dsoneil", "502278");
        Map<String, Object> myMap = new HashMap<>();
        String value;

        for (Resource myResource: testLR.getResources()) {
            System.out.println("Name: " + myResource.getName());
            System.out.println("Church Resource: " + myResource.getChurchResource());
            System.out.println("Uuid: " + myResource.getUuid());
            System.out.println("Limited Visibility: " + myResource.getLimitedVisibility());
            if (myResource.getTags() != null) {
                for (String myTag: myResource.getTags()) {
                    System.out.println(myTag);
                }
            }

            myMap = myResource.getAdditionalProperties();
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
            }
        }
    }

//    @Test
    public void createLifeResourceTest() throws Exception {
        int responseCode = 0;
        LifeResource testLR = new LifeResource();
        Resource myResource = new Resource();
        Contact myContact = new Contact();
        List<String> tagList = new ArrayList<>();
        List<Resource> resourceList = new ArrayList<>();

        //Create Contact
        myContact.setDisplayName("Test Contact");
        myContact.setPhone("801-867-5309");

        //Create Tag
        tagList.add("f6638875-aa67-45ae-bb62-60290bfa6d53");

        //Create the Resource
        myResource.setName("Automated Test One");
        myResource.setChurchResource(false);
        myResource.setAddress("3740 W Market Center Dr, Riverton, UT 84065");
        myResource.setContact(myContact);
        myResource.setDescription("Automated test one description");
        myResource.setEmail("testemail@gmail.com");
        myResource.setLimitedVisibility(false);
        myResource.setNotes("Automated Notes");
        myResource.setPhone("999-888-7777");
        myResource.setUrl("https://www.google.com");
        myResource.setTags(tagList);

        resourceList.add(myResource);

        //Create the Life Resource
        testLR.setUnitNumber(502278);
        testLR.setResources(resourceList);


        responseCode = apiTest.createLifeResource("502278", "deanandrewandersen", myResource);
        System.out.println("CODE: " + responseCode);

    }

//    @Test
    public void findLifeResourceAndDelete() throws Exception {
//        String unitNumber, String proxyLogin, String resourceName
        int responseCode = 0;
        String unitNumber = "502278";
        String proxyLogin = "deanandrewandersen";
        String resourceName = "string";
        LifeResource testLR = new LifeResource();
        testLR = apiTest.getLifeResource(proxyLogin, unitNumber);
        for (Resource myResource: testLR.getResources()) {
            System.out.println("Name: " + myResource.getName());
            if (myResource.getName().equalsIgnoreCase(resourceName)) {
                System.out.println("Name: " + myResource.getName());
                System.out.println("Uuid: " + myResource.getUuid());
                responseCode = apiTest.lifeResourceDelete(myResource, proxyLogin);
            }
        }
        System.out.println("CODE: " + responseCode);
    }


//    @Test
    public void apiCheck() throws Exception {
        int responseCode = 0;

        Map<String, Object> myMap = new HashMap<>();
//        Expenses myExpense = new Expenses();
//        myExpense.apiCleanUpExpenses();


//        reportNameToCheck =  apiTest.getAllExpenses("mbthomas74", "21628");
//        for (String listItem : reportNameToCheck) {
//            System.out.println(listItem);
//        }


//        "memberUuid": "31bc045c-6907-4897-ac52-3f0b8cdf521f", 2nd Counselor
//                "memberMrn": "000-6134-4079",
//                "name": "Loeb, Andrew Jacob"

//        "memberUuid": "8c4b71ab-3d01-49ff-8699-41ec6116f993", 1st Counselor
//                "memberMrn": "000-4691-5133",
//                "name": "Iuta, Lafaele Brando"

//        "memberUuid": "e463aaf9-573f-4d17-8364-d4f4112cb517", Bishop
//                "memberMrn": "000-2205-6416",
//                "name": "Thomas, Mark Barrett"
//
//        "memberUuid": "ff9318a2-0643-428b-b5cf-7ee410aed21a", Ward Clerk
//                "memberMrn": "002-0909-565A",
//                "name": "Stephenson, Robert Wyman"

//        "uuid": "e7c584ab-cdf8-46c5-add9-898b22b25d1b",       Relief Society Pres
//                "displayName": "Bridgeman, Pamela Gwenn",

//        "uuid": "e8251ac7-2caf-4e9b-b297-8a8833611bc9", Relief Society 1st Councilor
//                "displayName": "Olson, Sonja",

//        "uuid": "d33a7122-a7cb-4538-90b0-02436034c610",           EQ Pres
//                "displayName": "Martinez, Cesar L.",

//        Ward Missionary - 9
//        Elders Quorum - 22
//        Relief Socity - 25
//        Activities - 315
//        FSY - 952


//  Create Payment Request
        responseCode = apiTest.createPaymentRequest(2921, "e463aaf9-573f-4d17-8364-d4f4112cb517", "Test Two", 21628, 952, 776, "mbthomas74");
        System.out.println("CODE: " + responseCode);

        //Relief Society
        responseCode = apiTest.createPaymentRequest(2921, "2ec59248-cb2e-452b-83a3-79fdf4847ea3", "Relief Society Automated Test", 21628, 25, 5399, "sharonstelter");
        System.out.println("CODE: " + responseCode);

//        responseCode = apiTest.createPaymentRequest(2921, "e8251ac7-2caf-4e9b-b297-8a8833611bc9", "Relief Society Automated Test #2", 21628, 25, 2299, "sonjalacrisolson");
//        System.out.println("CODE: " + responseCode);

        //Elders Quorum
        responseCode = apiTest.createPaymentRequest(2921, "d33a7122-a7cb-4538-90b0-02436034c610", "Elders Quorum Automated Test", 21628, 22, 6743, "clmarti");
        System.out.println("CODE: " + responseCode);

//        responseCode = apiTest.createPaymentRequest(2921, "d33a7122-a7cb-4538-90b0-02436034c610", "Elders Quorum Automated Test #2", 21628, 22, 6223, "clmarti");
//        System.out.println("CODE: " + responseCode);

        //Bishopric 1st Counselor
        responseCode = apiTest.createPaymentRequest(2921, "8c4b71ab-3d01-49ff-8699-41ec6116f993", "Activities Automated Test", 21628, 315, 14999, "lafaele40");
        System.out.println("CODE: " + responseCode);

//        responseCode = apiTest.createPaymentRequest(2921, "8c4b71ab-3d01-49ff-8699-41ec6116f993", "Activities Automated Test #2", 21628, 315, 20099, "lafaele40");
//        System.out.println("CODE: " + responseCode);

//  Rename payment requests? - change to delete when delete works
        //TODO: when the finance guys fixes this try again
        //Search for expense id by purpose?
//        String TestAuthenticationInterceptor@2b037cfc returned a response with no body;
//        int myId = 0;
//        String myType = null;
//        myMap = apiTest.getExpensesDetail("mbthomas74", "21628", "Test Two");
//        if (!myMap.isEmpty()) {
//            for (String mapKey: myMap.keySet()) {
//                String key = mapKey.toString();
//                if (myMap.get(mapKey) == null) {
//                    value = "";
//                } else {
//                    value = myMap.get(mapKey).toString();
//                }
//                System.out.println(key + " - " + value);
//            }
//
//            myId = (int) myMap.get("id");
//            myType = (String) myMap.get("type");
//            responseCode = apiTest.expenseDelete(myId, myType, "mbthomas74");
//            System.out.println("CODE: " + responseCode);
//
//        }




//        myMap = apiTest.getExpensesDetail("mbthomas74", "21628", "Test One");
//        for (String mapKey: myMap.keySet()) {
//            String key = mapKey.toString();
//            String value = myMap.get(mapKey).toString();
//            System.out.println(key + " - " + value);
//        }


        //Members Moved Out
//        memberList = apiTest.getNamesFromMembersMovedOut("mbthomas74", "21628");
//        //        memberList = apiTest.getInfoFromMinisteringBrothers("mbthomas74",  "21628", "sisters");
//        for (String reportName: memberList) {
//            System.out.println("Report Name: " + reportName);
//        }



        //List Tests
//        responseCode = apiTest.postListTest("7d9c46fd-958f-4a91-8c74-7ef41a297c55,2d608fa5-ed9a-460e-b220-270214c6e9bb", "Change List Name",51, "a1479b4c-df02-4454-bdb6-576f12473193", "julieryan");
//        Assert.assertEquals(responseCode, 200);
//
//        responseCode = apiTest.postListTest("7d9c46fd-958f-4a91-8c74-7ef41a297c55,2d608fa5-ed9a-460e-b220-270214c6e9bb", "My Member List",52, "a1479b4c-df02-4454-bdb6-576f12473194", "julieryan");
//        Assert.assertEquals(responseCode, 200);
//
//        responseCode = apiTest.postListTest("dbe8087d-4308-461c-8a5f-decb6e03f06d,2d608fa5-ed9a-460e-b220-270214c6e9bb", "Delete This List",53, "a1479b4c-df02-4454-bdb6-576f12473195", "julieryan");
//        Assert.assertEquals(responseCode, 200);


//        //Delete all lists
//        listMap = apiTest.getListNames("julieryan");
//        for (String listToDelete: listMap.keySet()) {
//            System.out.println(listToDelete);
//            responseCode = apiTest.listDelete(listToDelete, "julieryan");
//        }






//        responseCode = apiTest.postListTest("ee4a2b31-a913-442a-9cef-70722cb55f3c,16e090cf-d980-47da-b537-75b1040fe85e", "TEST API",51, "50eff3b6-10c2-4caf-9c18-f070e41fc1ca", "mbthomas74");
//        Assert.assertEquals(responseCode, 200);
//
//        listMap = apiTest.getListNames("mbthomas74");
//        Assert.assertTrue(listMap.containsKey("TEST API"));
//
//        responseCode = apiTest.listDelete("TEST API", "mbthomas74");
//        Assert.assertEquals(responseCode, 200);
//
//        listMap = apiTest.getListNames("mbthomas74");
//        Assert.assertFalse(listMap.containsKey("TEST API"));

    }

//    @Test
    public void createExpense() throws Exception {
        int responseCode = 0;
        //  Create Payment Request
        responseCode = apiTest.createPaymentRequest(2921, "e463aaf9-573f-4d17-8364-d4f4112cb517", "Test Two", 21628, 952, 776, "mbthomas74");
        System.out.println("CODE: " + responseCode);

        //Relief Society
        responseCode = apiTest.createPaymentRequest(2921, "2ec59248-cb2e-452b-83a3-79fdf4847ea3", "Relief Society Automated Test", 21628, 25, 5399, "sharonstelter");
        System.out.println("CODE: " + responseCode);

        //Elders Quorum
        responseCode = apiTest.createPaymentRequest(2921, "d33a7122-a7cb-4538-90b0-02436034c610", "Elders Quorum Automated Test", 21628, 22, 6743, "clmarti");
        System.out.println("CODE: " + responseCode);


        //Bishopric 1st Counselor
        responseCode = apiTest.createPaymentRequest(2921, "8c4b71ab-3d01-49ff-8699-41ec6116f993", "Activities Automated Test", 21628, 315, 14999, "lafaele40");
        System.out.println("CODE: " + responseCode);


//        responseCode = apiTest.createPaymentRequest(8880, "533356e1-66c5-49dc-b37b-13a416594413", "Test Two ZZZZ", 39373, 952, 776, "dsoneil");
//        System.out.println("CODE: " + responseCode);


    }

//    @Test
    //Not working
    public void createExpenseByObject() throws Exception {
        int responseCode = 0;

        Random rand = new Random();
//        int randomNumber = rand.nextInt((10000 - 99999) + 1) + 10000;
        int randomNumber = rand.nextInt(10001) + 99990;

        Expense myExpense = new Expense();
        Payee myPayee = new Payee();
        Charge myCharge = new Charge();
        SubmittedBy mySubmittedby = new SubmittedBy();
        Receipt myReceipt = new Receipt();
        List<Charge> listCharge = new ArrayList<>();
        List<Receipt> listReceipts = new ArrayList<>();

        //Payee
        myPayee.setMemberUuid("6909882b-16ef-41d2-80be-6de55a88011a");
        myPayee.setId(32902952);
        myPayee.setName("Angers, Donna");

        //Charges
        myCharge.setCategoryId(315);
        myCharge.setAmount(1234);
        listCharge.add(myCharge);

        //Submittedby
        mySubmittedby.setMemberUuid("e463aaf9-573f-4d17-8364-d4f4112cb517");
        mySubmittedby.setMemberMrn("000-2205-6416");
        mySubmittedby.setName("Thomas, Mark Barrett");

        //Receipt
        myReceipt.setName("TEST1234");
        listReceipts.add(myReceipt);

//        myExpense.setId(0);
        myExpense.setType("EXPENSE");
        myExpense.setUnitNumber(21628);
        myExpense.setAccountId(2921);
        myExpense.setStatus("SUBMITTED");
        myExpense.setPayee(myPayee);
        myExpense.setPurpose("API Automated Test " + randomNumber);
        myExpense.setCharges(listCharge);
        myExpense.setPaymentMethodId(10);
        myExpense.setExpenseDistribution(false);
        myExpense.setSubmittedDate("2023-05-15");
        myExpense.setSubmittedBy(mySubmittedby);
        myExpense.setReceipts(listReceipts);

        responseCode = apiTest.createExpenseWithObject(myExpense, "mbthomas74");
        System.out.println("Response Code: " + responseCode);

    }

//    @Test
    public void getAllExpensesForUnit() throws Exception {
        Map<String, Object> myMap = new HashMap<>();
//        List<String> expenseList = new ArrayList<>();
        List<ApiFinanceMethod> expenseList = null;
        //Search for expense id by purpose?
        String value;

//        expenseList = apiTest.getAllExpenses("mbthomas74", "21628");
//        if (!expenseList.isEmpty()) {
//            for (String expenseStatus: expenseList) {
//                System.out.println(expenseStatus);
//            }
//        }

        expenseList = apiTest.getAllExpenses2("mbthomas74", "21628");

        for (ApiFinanceMethod oneMonthExpense : expenseList) {
            System.out.println("Unit Number: " + oneMonthExpense.getUnitNumber());
            System.out.println("Month: " + oneMonthExpense.getMonth());
            System.out.println("*****************************************");
            System.out.println(" ");
            for (LDSToolsAppium.API.Expenses.Expense testExp : oneMonthExpense.getExpenses()) {
                System.out.println("ID: " + testExp.getId());
                System.out.println("Status: " + testExp.getStatus());
                System.out.println("Purpose: " + testExp.getPurpose());
                System.out.println("Account ID: " + testExp.getAccountId());
//                System.out.println("Submitted By Name: " + testExp.getSubmittedBy().getName()); //Can be null
                System.out.println("Submitted Date: " + testExp.getSubmittedDate());
                System.out.println("Payee Name: " + testExp.getPayee().getName());
                System.out.println("Payee ID: " + testExp.getPayee().getId());
                System.out.println("Member Uuid ID: " + testExp.getPayee().getMemberUuid());
                System.out.println("Member MRN: " + testExp.getPayee().getMemberMrn());
                System.out.println("Type: " + testExp.getType());
                System.out.println("Advancement: " + testExp.getAdvancement());




                if (testExp.getApprovedRejectedBy() != null) {
                    System.out.println("Approved Rejected By Name : " + testExp.getApprovedRejectedBy().getName());
                } else {
                    System.out.println("Approved Rejected By Name : NULL" );
                }

                if (testExp.getApprovedRejectedDate() != null) {
                    System.out.println("Approved Rejected Date : " + testExp.getApprovedRejectedDate());
                } else {
                    System.out.println("Approved Rejected Date : NULL" );
                }


                for(Charge testCharge : testExp.getCharges()) {
                    System.out.println("Category ID: " + testCharge.getCategoryId());
                    System.out.println("Amount: " + testCharge.getAmount());
                }
                System.out.println("-------------------------------");
            }
        }
    }

//    @Test
    public void getExpenseDetail() throws Exception {
        String value;
        Map<String, Object> myMap = new HashMap<>();
        myMap =  apiTest.getExpensesDetail("dsoneil", "39373", "API Automated Test 1");
        for (String mapKey: myMap.keySet()) {
                String key = mapKey.toString();
                if (myMap.get(mapKey) == null) {
                    value = "";
                } else {
                    value = myMap.get(mapKey).toString();
                }
                System.out.println(key + " - " + value);
            }
    }

//    @Test
    public void getExpenseDetailByObject() throws Exception {
        Expense foundExpense = new Expense();
//        foundExpense = apiTest.getExpenseReturnExpense("dsoneil", "39373", "test1234"); //Submitted - Electronic transfer
//        foundExpense = apiTest.getExpenseReturnExpense("dsoneil", "39373", "PR"); //Payment Request
//        foundExpense = apiTest.getExpenseReturnExpense("dsoneil", "39373", "Expense One 8862.0"); //Submitted Expense
//        foundExpense = apiTest.getExpenseReturnExpense("dsoneil", "39373", "Expense One 6648.0"); //Rejected
//        foundExpense = apiTest.getExpenseReturnExpense("dsoneil", "39373", "Expense One 1427.0"); //Checks to print
//        foundExpense = apiTest.getExpenseReturnExpense("dsoneil", "39373", "Paint night"); //In Summary - done
//        foundExpense = apiTest.getExpenseReturnExpense("RaphaelQueiroz", "236977", "Zzz test zzz"); //In Summary - done
        foundExpense = apiTest.getExpenseReturnExpense("mbthomas74", "21628", "test1"); //In Summary - done

        ApprovedRejectedBy myApprovedRejectedBy = new ApprovedRejectedBy();


        System.out.println("Purpose: " + foundExpense.getPurpose());
        System.out.println("Status: " + foundExpense.getStatus());
        System.out.println("Reference Number: " + foundExpense.getReferenceNumber());
        System.out.println("Payment Method ID: " + foundExpense.getPaymentMethodId());
        System.out.println("Type: " + foundExpense.getType());


        if (foundExpense.getReceipts() != null) {
            for (Receipt myReceipt : foundExpense.getReceipts()) {
                System.out.println("Receipt Name: " + myReceipt.getName());
                System.out.println("Receipt ID: " + myReceipt.getId());
            }
        } else {
            System.out.println("No Receipt");
        }


        for (Charge myCharge: foundExpense.getCharges()) {
            System.out.println("Category ID: " + myCharge.getCategoryId());
            System.out.println("Category Amount: " + myCharge.getAmount());
        }


        if (foundExpense.getApprovedRejectedBy() != null) {
            System.out.println("Approved - Rejected Date: " + foundExpense.getApprovedRejectedDate());
            System.out.println("Approved - Rejected By: " + foundExpense.getApprovedRejectedBy().getName());
        } else {
            System.out.println("No Approved - Rejected Data" );
        }

        if (foundExpense.getSubmittedBy() != null) {
            System.out.println("Submitted By: " + foundExpense.getSubmittedBy().getName());
        } else {
            System.out.println("No Submitted Data" );
        }

        //Add rejected stuff to object
        //Submittedby
        myApprovedRejectedBy.setMemberUuid("e463aaf9-573f-4d17-8364-d4f4112cb517");
        myApprovedRejectedBy.setMemberMrn("000-2205-6416");
        myApprovedRejectedBy.setName("Thomas, Mark Barrett");

        foundExpense.setApprovedRejectedDate("2023-05-16");
        foundExpense.setApprovedRejectedBy(myApprovedRejectedBy);
//        foundExpense.setStatus("REJECTED");
        foundExpense.setReasonForRejection("Incorrect amount");


        int myResponse = apiTest.updateExpenseWithObject(foundExpense, "mbthomas74");
        System.out.println("Response: " + myResponse);

    }



//    @Test
    public void listExpensesAndDelete() throws Exception {
        Map<String, Object> myMap = new HashMap<>();
        List<ApiFinanceDetail> expenseDetailList = new ArrayList<>();
        int responseCode = 0;
        //Search for expense id by purpose?
        String value;
        int myId = 0;
        String myType = null;
        expenseDetailList = apiTest.getExpensesByStatus("mbthomas74", "21628", "SUBMITTED");
        if (!expenseDetailList.isEmpty()) {
            for (ApiFinanceDetail expenseDetail: expenseDetailList) {
                System.out.println("Purpose: " + expenseDetail.getPurpose());
                System.out.println("ID: " + expenseDetail.getId());
                System.out.println("Type: " + expenseDetail.getType());
                System.out.println("Status: " + expenseDetail.getStatus());
//                int myInt = Integer.parseInt(idName);

                if (expenseDetail.getType().equalsIgnoreCase("REIMBURSEMENT_REQUEST")) {
                    responseCode = apiTest.expenseDelete(expenseDetail.getId(), expenseDetail.getType(), "mbthomas74");
                    System.out.println("Response: "  + responseCode);
                }



            }
        }

//        expenseDetailList = apiTest.getExpensesByStatus("mbthomas74", "21628", "APPROVED");
//        if (!expenseDetailList.isEmpty()) {
//            for (ApiFinanceDetail expenseDetail: expenseDetailList) {
//                System.out.println(expenseDetail.getPurpose());
//                System.out.println(expenseDetail.getId());
//                System.out.println(expenseDetail.getType());
////                int myInt = Integer.parseInt(idName);
//
//                responseCode = apiTest.expenseDelete(expenseDetail.getId(), expenseDetail.getType(), "mbthomas74");
//                System.out.println("Response: "  + responseCode);
//            }
//        }

        //Update to Reject?
//        expenseDetailList = apiTest.getExpensesByStatus("mbthomas74", "21628", "PENDING_PRINT");
//        if (!expenseDetailList.isEmpty()) {
//            for (ApiFinanceDetail expenseDetail: expenseDetailList) {
//                System.out.println(expenseDetail.getPurpose());
//                System.out.println(expenseDetail.getId());
//                System.out.println(expenseDetail.getType());
////                int myInt = Integer.parseInt(idName);
//
//                responseCode = apiTest.expenseDelete(expenseDetail.getId(), expenseDetail.getType(), "mbthomas74");
//                System.out.println("Response: "  + responseCode);
//            }
//        }



    }




//    @Test
    public void deleteExpenses() throws Exception {
        Expenses myExpense = new Expenses();
        myExpense.apiDeleteExpense("mbthomas74" , "21628", "FSY Automated Test");
        myExpense.apiDeleteExpense("mbthomas74" , "21628", "Relief Society Automated Test");
        myExpense.apiDeleteExpense("mbthomas74" , "21628", "Elders Quorum Automated Test");
        myExpense.apiDeleteExpense("mbthomas74" , "21628", "Activities Automated Test");
    }

//    @Test
    public void apiGetUsernames() throws Exception {
        int codeTest = 0;
        int responseCode = 0;

        Map<String, Object> myMap = new HashMap<>();
//        myMap = apiTest.getExpenses("mbthomas74", "21628", "Test One");
//
//        for (String mapKey: myMap.keySet()) {
//            String key = mapKey.toString();
//            String value = myMap.get(mapKey).toString();
//            System.out.println(key + " - " + value);
//        }



//         *********************************
        List<String> callingAndLoginName = new ArrayList<String>();
        List<String> deepLink = new ArrayList<String>();
        List<String> prepForFile = new ArrayList<String>();
        Map<String, String> unitMap = new HashMap<String, String>();
        unitMap.put("4", "BISHOP");
        unitMap.put("54", "BISHOPRIC_FIRST_COUNSELOR");
        unitMap.put("55", "BISHOPRIC_SECOND_COUNSELOR");
        unitMap.put("56", "WARD_EXECUTIVE_SECRETARY");
        unitMap.put("57", "WARD_CLERK");
        unitMap.put("58", "WARD_ASSISTANT_CLERK");
        unitMap.put("138", "ELDERS_QUORUM_PRESIDENT");
        unitMap.put("139", "ELDERS_QUORUM_FIRST_COUNSELOR");
        unitMap.put("140", "ELDERS_QUORUM_SECOND_COUNSELOR");
        unitMap.put("141", "ELDERS_QUORUM_SECRETARY");
        unitMap.put("143", "RELIEF_SOCIETY_PRESIDENT");
        unitMap.put("144", "RELIEF_SOCIETY_FIRST_COUNSELOR");
        unitMap.put("145", "RELIEF_SOCIETY_SECOND_COUNSELOR");
        unitMap.put("146", "RELIEF_SOCIETY_SECRETARY");
        unitMap.put("162", "PRIESTS_QUORUM_ADVISER");
        unitMap.put("163", "TEACHERS_QUORUM_ADVISER");
        unitMap.put("164", "DEACONS_QUORUM_ADVISER");
        unitMap.put("183", "YOUNG_WOMEN_PRESIDENT");
        unitMap.put("184", "YOUNG_WOMEN_FIRST_COUNSELOR");
        unitMap.put("185", "YOUNG_WOMEN_SECOND_COUNSELOR");
        unitMap.put("186", "YOUNG_WOMEN_SECRETARY");
        unitMap.put("204", "SUNDAY_SCHOOL_PRESIDENT");
        unitMap.put("205", "SUNDAY_SCHOOL_FIRST_COUNSELOR");
        unitMap.put("206", "SUNDAY_SCHOOL_SECOND_COUNSELOR");
        unitMap.put("207", "SUNDAY_SCHOOL_SECRETARY");
        unitMap.put("221", "WARD_MISSION_LEADER");
        unitMap.put("210", "PRIMARY_PRESIDENT");
        unitMap.put("211", "PRIMARY_FIRST_COUNSELOR");
        unitMap.put("212", "PRIMARY_SECOND_COUNSELOR");
        unitMap.put("213", "PRIMARY_SECRETARY");
        unitMap.put("214", "PRIMARY_MUSIC_LEADER");
        unitMap.put("215", "PRIMARY_PIANIST");
        unitMap.put("216", "PRIMARY_TEACHER");
        unitMap.put("208", "SUNDAY_SCHOOL_TEACHER");
        unitMap.put("217", "PRIMARY_ACTIVITY_DAYS_LEADER");
        unitMap.put("171", "PRIESTS_QUORUM_FIRST_ASSISTANT");
        unitMap.put("172", "PRIESTS_QUORUM_SECOND_ASSISTANT");
        unitMap.put("173", "PRIESTS_QUORUM_SECRETARY");
        unitMap.put("174", "TEACHERS_QUORUM_PRESIDENT");
        unitMap.put("175", "TEACHERS_QUORUM_FIRST_COUNSELOR");
        unitMap.put("176", "TEACHERS_QUORUM_SECOND_COUNSELOR");
        unitMap.put("177", "DEACONS_QUORUM_PRESIDENT");
        unitMap.put("178", "DEACONS_QUORUM_FIRST_COUNSELOR");
        unitMap.put("179", "DEACONS_QUORUM_SECOND_COUNSELOR");
        unitMap.put("142", "ELDERS_QUORUM_INSTRUCTOR");
        unitMap.put("150", "RELIEF_SOCIETY_TEACHER");
        unitMap.put("12", "BRANCH_PRESIDENT");
        unitMap.put("59", "BRANCH_PRESIDENCY_FIRST_COUNSELOR");
        unitMap.put("60", "BRANCH_PRESIDENCY_SECOND_COUNSELOR");



        for (String callingId: unitMap.keySet()) {
            memberList = apiTest.getAccounts("39373", callingId);
            for (String myUsername: memberList) {
//                System.out.println("Calling Username: " + myUsername);
                callingAndLoginName.add(callingId + "," + unitMap.get(callingId)  + "," + myUsername );
                deepLink.add(unitMap.get(callingId) + " MemberTools://user/" + myUsername + "/stage");
                prepForFile.add(unitMap.get(callingId) + "," + myUsername);
            }
        }

        Collections.sort(callingAndLoginName);
        Collections.sort(deepLink);

        for (String loginWithCalling : callingAndLoginName) {
            System.out.println(loginWithCalling);
        }

        System.out.println("*********************************************************");

        for (String deepLinkMember : deepLink) {
            System.out.println(deepLinkMember);
        }

        System.out.println("*********************************************************");

        for (String prepForFileMember : prepForFile) {
            System.out.println(prepForFileMember);
        }



        //        //Accounts!!
////        memberList = apiTest.getAccounts("39373", "183");
////        for (String myUsername: memberList) {
////            System.out.println("LIST NAME: " + myUsername);
////        }
//
//


        // *********************************


//        // Encode data on your side using BASE64
//        String str = "Your Pass Word to Encode";
//        byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
//        System.out.println("encoded value is " + new String(bytesEncoded));
//
//        // Decode data on other side, by processing encoded data
//        byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
//        System.out.println("Decoded value is " + new String(valueDecoded));








//        Map<String, Object> myMap = new HashMap<>();
//        myMap = apiTest.getExpenses("mbthomas74", "21628", "Qqqqqqqqqqqqq");
//
//        for (String mapKey: myMap.keySet()) {
//            String key = mapKey.toString();
//            String value = myMap.get(mapKey).toString();
//            System.out.println(key + " - " + value);
//        }

        //Ordiance Stuff
//        memberList = apiTest.getPersonalInfoFromName( "Adams, Dewayne", "21628", "mbthomas74");
//        System.out.println(memberList);
//        apiTest.ordinanceDelete("Austin, Joseph", "21628", "mbthomas74");

//        apiTest.ordinanceDelete("Barba, Cristian Jesus", "21628", "mbthomas74");





//        memberList = apiTest.getInfoFromMinisteringBrothers("mbthomas74",  "21628", "sisters");
//        for (String reportName: memberList) {
//            System.out.println("Report Name: " + reportName);
//        }

//        memberList = apiTest.getReportNames("mbthomas74", "21628");
//        rawData = apiTest.getApiInfoTEST(unitNumber, proxyLogin);

//        apiTest.getApiResponseCode("reports?units=21628", "mbthomas74");

//        //List Tests
//        responseCode = apiTest.postListTest("ee4a2b31-a913-442a-9cef-70722cb55f3c", "TEST API",51, "50eff3b6-10c2-4caf-9c18-f070e41fc1ca");
//        Assert.assertEquals(responseCode, 200);
//
//        listMap = apiTest.getListNames("mbthomas74");
//        Assert.assertTrue(listMap.containsKey("TEST API"));
//
//        responseCode = apiTest.listDelete("TEST API", "mbthomas74");
//        Assert.assertEquals(responseCode, 200);
//
//        listMap = apiTest.getListNames("mbthomas74");
//        Assert.assertFalse(listMap.containsKey("TEST API"));





//        apiTest.getApiResponseCode("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/reports/access", "21628", "mbthomas74");
//        apiTest.getApiResponseCode("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/user", "21628", "mbthomas74");
//        apiTest.getApiResponseCode("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/units", "21628", "mbthomas74");
//        apiTest.getApiResponseCode("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/subscriptions", "21628", "mbthomas74");
//        apiTest.getApiResponseCode("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/referrals", "21628", "mbthomas74");
//        apiTest.getApiResponseCode("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/temples", "21628", "mbthomas74");
//        System.out.println("Code: " + codeTest);

//        memberList = apiTest.getReportNames("bradyduck", "111074");


    }

//    @Test
    public void encodeDecodeTest() throws Exception {
        // Encode data on your side using BASE64
        String str = "ldsM0b1l3";
        byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
        System.out.println("encoded value is " + new String(bytesEncoded));

         // Decode data on other side, by processing encoded data
        byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
        System.out.println("Decoded value is " + new String(valueDecoded));
    }


//    @Test
    public void configPropertiesTest() throws Exception {
        try (InputStream input = Files.newInputStream(Paths.get("ConfigFiles/config.properties"))) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("db.twoFactor"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));

            Totp totp = new Totp(prop.getProperty("db.twoFactor"));
            String twoFactorCode = totp.now(); // <- got 2FA coed at this time!
            System.out.println(twoFactorCode);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    @Test
    public void getHouseholdInfoForUnit() throws Exception {
        List<ApiHousehold> allHouseholds = new ArrayList<>();
        allHouseholds =  apiTest.getHouseholdInfo( "39373", "dsoneil");
//        System.out.println(allHouseholds);
        for(ApiHousehold household: allHouseholds) {
            System.out.println(" ");
            System.out.println("************************************************");
            System.out.println("Household Display Name: " + household.getDisplayName());
            System.out.println("Household Uuid: " + household.getUuid());
            for(Member oneMember: household.getMembers()) {
                System.out.println("Display Name: " + oneMember.getDisplayName());
                System.out.println("Uuid: " + oneMember.getUuid());
                System.out.println("Privacy BirthDate: " + oneMember.getPrivacy().getBirthDate());
                System.out.println("Privacy Address: " + oneMember.getPrivacy().getAddress());
                System.out.println("Privacy Coordinates: " + oneMember.getPrivacy().getCoordinates());
                System.out.println("Privacy Email: " + oneMember.getPrivacy().getEmail());
                System.out.println("Privacy Phone: " + oneMember.getPrivacy().getPhone());
                System.out.println("Privacy Photo: " + oneMember.getPrivacy().getPhoto());
            }
            System.out.println("************************************************");
            System.out.println(" ");
        }
    }

//    @Test
    public void getInfoFromName() throws Exception {
        ApiHousehold myHousehold = new ApiHousehold();
        myHousehold = apiTest.getPersonalInfoFromNameAPI("Allen, Katana Jean", "39373", "dsoneil");
        System.out.println("Display Name: " + myHousehold.getDisplayName());
        System.out.println("Household Privacy Address: " + myHousehold.getPrivacy().getAddress());
        System.out.println("Household Privacy Coordinates: " + myHousehold.getPrivacy().getCoordinates());
        System.out.println("Household Privacy Photo: " + myHousehold.getPrivacy().getPhoto());
        System.out.println("Household Address: " + myHousehold.getAddress());
        for(Member oneMember: myHousehold.getMembers()) {
            if (oneMember.getOfficialName().equalsIgnoreCase("Allen, Katana Jean")) {
                System.out.println("*****************************************************");
                System.out.println("Member Display Name: " + oneMember.getDisplayName());
                System.out.println("Member Offical Name: " + oneMember.getOfficialName());
                System.out.println("Member Privacy Address: " + oneMember.getPrivacy().getAddress());
                System.out.println("Member Privacy Birthdate: " + oneMember.getPrivacy().getBirthDate());
                System.out.println("Member Birthdate: " + oneMember.getBirthDate());
                System.out.println("Member Privacy Photo: " + oneMember.getPrivacy().getPhoto());
                System.out.println("Member Privacy Phone: " + oneMember.getPrivacy().getPhone());
                for (Phone myPhone: oneMember.getPhones()) {
                    System.out.println(myPhone.getE164());
                    System.out.println(myPhone.getType());
                    System.out.println(myPhone.getNumber());
                }

//                System.out.println("Member Email: " + oneMember.getEmail());
                System.out.println("Member Privacy Coordinates: " + oneMember.getPrivacy().getCoordinates());
//                System.out.println("TEST: " + oneMember.getEmails().toString());
                System.out.println("Member Privacy Email: " + oneMember.getPrivacy().getEmail());
                for (Email myEmail: oneMember.getEmails()) {
                    System.out.println(myEmail.getEmail());
                }
                System.out.println("*****************************************************");
                System.out.println(" ");
            }
        }
    }

    @Test
    public void phoneNumberConvertCheck() throws Exception {
        Visibility myVisibility = new Visibility();
        myVisibility.convertPhoneNumber("+12703638902");
    }

//    @Test
    public void timeWaitTest() throws Exception {
        Date myDate = new Date();
        int currentSeconds = myDate.getSeconds();
        System.out.println("Current Seconds: "  + currentSeconds);
        int waitTime = currentSeconds - 60;
        System.out.println("Wait time: "  + waitTime);
        waitTime = waitTime * 1000;
        System.out.println("Wait time in ms: "  + waitTime);
        Thread.sleep(waitTime);
    }




//    @Test
//    public void ReportNameCheckBishop() throws Exception {
//        reportNameToCheck.clear();
//
//        reportNameToCheck.add("ACTION_INTERVIEW");
//        reportNameToCheck.add("BIRTHDAY_LIST");
//        reportNameToCheck.add("KEY_INDICATORS");
//        reportNameToCheck.add("MEMBERS_MOVED_IN");
//        reportNameToCheck.add("MEMBERS_MOVED_OUT");
//        reportNameToCheck.add("MEMBERS_WITH_CALLINGS");
//        reportNameToCheck.add("MEMBERS_WITHOUT_CALLINGS");
//        reportNameToCheck.add("MINISTERING_BROTHERS");
//        reportNameToCheck.add("MINISTERING_BROTHERS_INTERVIEWS");
//        reportNameToCheck.add("MINISTERING_BROTHERS_INTERVIEWS_EDIT");
//        reportNameToCheck.add("MINISTERING_SISTERS");
//        reportNameToCheck.add("MINISTERING_SISTERS_INTERVIEWS");
//        reportNameToCheck.add("MINISTERING_SISTERS_INTERVIEWS_EDIT");
//        reportNameToCheck.add("NEW_MEMBERS");
//        reportNameToCheck.add("QUARTERLY_REPORT");
//        reportNameToCheck.add("SACRAMENT_ATTENDANCE");
//        reportNameToCheck.add("CLASS_QUORUM_ATTENDANCE");
//        reportNameToCheck.add("TEMPLE_RECOMMEND_STATUS");
//        reportNameToCheck.add("UNIT_STATISTICS");
//        reportNameToCheck.add("YOUTH_RECOMMEND_STATUS");
//        reportNameToCheck.add("MISSIONARY_PROGRESS_RECORD");
//
//
//        memberList = apiTest.getReportNames("mbthomas74", "21628");
//
//        System.out.println("Report Name Check Bishop");
//        for(String reportName: reportNameToCheck) {
//            System.out.println("Checking: " + reportName);
//            Assert.assertTrue(memberList.contains(reportName));
//        }
//
//    }

//    @Test
//    public void ReportNameCheckElders() throws Exception {
//        reportNameToCheck.clear();
//
//        reportNameToCheck.add("ACTION_INTERVIEW");
//        reportNameToCheck.add("BIRTHDAY_LIST");
//        reportNameToCheck.add("KEY_INDICATORS");
//        reportNameToCheck.add("MEMBERS_MOVED_IN");
//        reportNameToCheck.add("MEMBERS_MOVED_OUT");
//        reportNameToCheck.add("MEMBERS_WITH_CALLINGS");
//        reportNameToCheck.add("MEMBERS_WITHOUT_CALLINGS");
//        reportNameToCheck.add("MINISTERING_BROTHERS");
//        reportNameToCheck.add("MINISTERING_BROTHERS_INTERVIEWS");
//        reportNameToCheck.add("MINISTERING_BROTHERS_INTERVIEWS_EDIT");
//        reportNameToCheck.add("MINISTERING_SISTERS");
//        reportNameToCheck.add("QUARTERLY_REPORT");
//        reportNameToCheck.add("CLASS_QUORUM_ATTENDANCE");
//        reportNameToCheck.add("UNIT_STATISTICS");
//
//
//
//        memberList = apiTest.getReportNames("bradyduck", "111074");
//
//        System.out.println("Report Name Check Elders");
//        for(String reportName: reportNameToCheck) {
//            System.out.println("Checking: " + reportName);
//            Assert.assertTrue(memberList.contains(reportName));
//        }
//
////        for (String listName: memberList) {
////            System.out.println(listName);
////        }
//
//    }









    //    final private String charset = StandardCharsets.UTF_8.name();
//    final private MediaType applicationJson = MediaType.get("application/json;charset=" + charset);






//    @Test
//    public void apiAuth() {
//        Response resp = RestAssured.given()
//                .formParam("client_id", "ZIUuB0qsmr8Kasdt")
//                .formParam("client_secret", "GZ7ohMinlb5QoN0v0zHgXmUFKOKLcMkC")
//                .formParam("grant_type", "client_credentials")
//                .formParam("scope", "openid")
//                .post("https://ident-int.churchofjesuschrist.org/sso/oauth2/access_token");
//
//        System.out.println("****************************");
//        System.out.println(resp.jsonPath().prettify());
//        System.out.println("****************************");
//        accessToken = resp.jsonPath().get("access_token");
//        idToken = resp.jsonPath().get("id_token");
//
//        Response resp1 = RestAssured.given()
//                .auth()
//                .oauth2(accessToken)
//                .log()
//                .all()
//                .header("Authorization" , "Bearer " + idToken)
//                .header("User-Agent", "Member Tools API Testing")
//                .get("https://mobileauth-int.churchofjesuschrist.org/v1/mobile/login");
////                .get("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/organizations?units=" + unitNumber);
//
//        System.out.println(resp1.getBody().asString());
//        System.out.println(resp1.jsonPath().prettify());
//    }


}
