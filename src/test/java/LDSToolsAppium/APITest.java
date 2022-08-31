package LDSToolsAppium;

import LDSToolsAppium.API.MemberToolsAPI;
//import LDSToolsAppium.API.ApiFinance;
//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
//import com.google.gson.reflect.TypeToken;
//import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.TypeKey;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;

import LDSToolsAppiumTest.steps.Expenses;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import java.awt.*;
import java.io.File;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;

import org.apache.commons.codec.binary.Base64;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class APITest {

    List<String> memberList = new ArrayList<String>();
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> reportNameToCheck = new ArrayList<>();
    String rawData;

//    111074 - AburnHill
//    258598 - Fagamalo 2nd
//    39373 - Maplewood 2nd
//    356832 - Foxhill ward

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

    @Test
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
//        String value;
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



        for (String callingId: unitMap.keySet()) {
            memberList = apiTest.getAccounts("111074", callingId);
            for (String myUsername: memberList) {
//                System.out.println("Calling Username: " + myUsername);
                callingAndLoginName.add(callingId + "," + unitMap.get(callingId)  + "," + myUsername );
            }
        }

        Collections.sort(callingAndLoginName);

        for (String loginWithCalling : callingAndLoginName) {
            System.out.println(loginWithCalling);
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
