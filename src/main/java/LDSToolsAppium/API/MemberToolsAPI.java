package LDSToolsAppium.API;


import LDSToolsAppium.API.LifeResources.LifeResource;
import LDSToolsAppium.API.QuarterlyReport.Convert;
import LDSToolsAppium.API.QuarterlyReport.QuarterlyReport;
import LDSToolsAppium.API.QuarterlyReport.Section;
import com.google.gson.reflect.TypeToken;
import com.google.gson.*;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;


import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;
import java.lang.reflect.Type;


@CucumberOptions()
public class MemberToolsAPI extends AbstractTestNGCucumberTests {

    Response householdAPI = null;
    String baseURL = "https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/";


    //Login credentials for the API
    public OkHttpClient loginCred() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        loggingInterceptor.redactHeader("Authorization");
        loggingInterceptor.redactHeader("Cookie");

//        // Encode data on your side using BASE64
//        byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
//        System.out.println("encoded value is " + new String(bytesEncoded));
//
//        // Decode data on other side, by processing encoded data
//        byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
//        System.out.println("Decoded value is " + new String(valueDecoded));


        byte[] decodeBytes = Base64.decodeBase64("U25AazNTcDE3MjAyMg==");

        TestWam2CredentialsManager credentialsManager = new TestWam2CredentialsManager("zmaxfield", new String(decodeBytes));

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new TestAuthenticationInterceptor(new TestAuthenticationManager(credentialsManager)))
                .addInterceptor(loggingInterceptor)
                .connectTimeout(Duration.ofSeconds(360))
                .writeTimeout(Duration.ofSeconds(360))
                .readTimeout(Duration.ofSeconds(360))
                .build();

        return httpClient;
    }


    public Request requestURL() {
        Request request = new Request.Builder()
                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/organizations?units=21628")
//                .url("https://identity-util-service-int.churchofjesuschrist.org/api/checkSession")
//                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/user")
                .addHeader("X-Proxy-User" , "mbthomas74")
                .build();
        return request;
    }

    public Request requestProxyURL(String apiUrl, String proxyUser ) {
        Request request = new Request.Builder()
                .url(apiUrl)
                .addHeader("X-Proxy-User" , proxyUser)
                .build();
        return request;
    }

    public Request requestURLNoProxyUser(String apiUrl ) {
        Request request = new Request.Builder()
                .url(apiUrl)
                .build();
        return request;
    }


    //Test Request
    public void apiRequest() {
        OkHttpClient httpClient = loginCred();
        Request request = requestURL();
        JsonParser parser = new JsonParser();
        String responseData;
//        String myPositions = "";
        ArrayList<String> myPositions = new ArrayList<String>();


        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();
            System.out.println("Response String: " + responseData);
            JsonElement jsonElement = parser.parse(responseData);
            System.out.println("Json element to String: " + jsonElement.toString());
            if (jsonElement instanceof JsonObject) {
                System.out.println("JSON Object!");
                System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
            } else if (jsonElement instanceof JsonArray) {
                System.out.println("JSON Array!");
//                JsonArray jsonData = new JsonArray(((JsonArray) jsonElement).size());
                JsonArray jsonData = jsonElement.getAsJsonArray();

                for (JsonElement orgName : jsonData) {
                    JsonObject orgObject = orgName.getAsJsonObject();
                    String myUuid = orgObject.get("uuid").getAsString();
                    String myOrgName = orgObject.get("name").getAsString();
                    String myUnitNumber = orgObject.get("unitNumber").getAsString();
                    String myOrgTypes = orgObject.get("orgTypes").getAsString();
//                    String myPositions = orgObject.get("positions").getAsString();
//                    String myPositions = orgObject.getAsJsonArray("positions").getAsString();
                    if (orgObject.has("positions")) {
                        JsonArray positionsArray = orgObject.getAsJsonArray("positions");
                        for (JsonElement posElement : positionsArray ) {
//                        JsonObject orgPos = posElement.getAsJsonObject();
                            myPositions.add(posElement.getAsString());
                        }
                    }



                    System.out.println("****************************");
                    System.out.println("uuid: " + myUuid);
                    System.out.println("Org Name: " + myOrgName);
                    System.out.println("Unit Number: " + myUnitNumber);
                    System.out.println("Org Type: " + myOrgTypes);
                    System.out.println("Positions: " + myPositions);
                    System.out.println("****************************");
                }
            }

//            System.out.println(jsonData);
//            JsonObject rootObj = parser.parse(jsonData).getAsJsonObject();




//            JsonObject jsonObject = (new JsonParser()).parse(jsonData).getAsJsonObject();
//            System.out.println("Name: " + jsonObject.get("name").getAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getOrganizationMembers(String organizationName, String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiOrganizationList = new TypeToken<ArrayList<ApiOrganization>>(){}.getType();

        responseData = getOrganizationJson(unitNumber, proxyLogin);
//            System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
            System.out.println("JSON Object!");
            System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiOrganization> testOrg = gson.fromJson(jsonElement, apiOrganizationList);

            for (ApiOrganization myOrg : testOrg) {
                System.out.println("Organizations: " + myOrg.getName());
                if (myOrg.getName().equalsIgnoreCase(organizationName)) {
                    if (myOrg.getPositions() != null) {
                        for (String onePosition : myOrg.getPositions()) {
                            memberNames.add(getNameFromUuid(onePosition, unitNumber, proxyLogin, "position"));
                        }
                    }
                }
            }
        }

        return memberNames;

    }

    public List<String> getChildOrganizationMembers(String organizationName, String proxyLogin, String unitNumber) throws Exception {
//        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiOrganizationList = new TypeToken<ArrayList<ApiOrganization>>(){}.getType();

        responseData = getOrganizationJson(unitNumber, proxyLogin);
//            System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
            System.out.println("JSON Object!");
            System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiOrganization> testOrg = gson.fromJson(jsonElement, apiOrganizationList);

            for (ApiOrganization myOrg : testOrg) {
//                    System.out.println("Organizations: " + myOrg.getName());
                if (myOrg.getChildOrgs() != null) {
                    for (ChildOrg childOrgs : myOrg.getChildOrgs()) {
//                            System.out.println("Child Org: " + childOrgs.getName());
                        if (childOrgs.getName().equalsIgnoreCase(organizationName)) {
//                                System.out.println("Found - " + organizationName);
                            if (childOrgs.getPositions() != null ) {
//                                    System.out.println("Positions: " + childOrgs.getPositions());
                                for (String onePosition : childOrgs.getPositions()) {
                                    memberNames.add(getNameFromUuid(onePosition, unitNumber, proxyLogin, "position"));
                                }

                            }
                        }
                    }
                }
            }
        }

        return memberNames;

    }

    //This is for 2nd level child orgs like - Priests Quorum Presidency
    public List<String> getChild2OrganizationMembers(String organizationName, String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiOrganizationList = new TypeToken<ArrayList<ApiOrganization>>(){}.getType();

        responseData = getOrganizationJson(unitNumber, proxyLogin);
//            System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
            System.out.println("JSON Object!");
            System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiOrganization> testOrg = gson.fromJson(jsonElement, apiOrganizationList);

            for (ApiOrganization myOrg : testOrg) {
//                    System.out.println("Organizations: " + myOrg.getName());
                if (myOrg.getChildOrgs() != null) {
                    for (ChildOrg childOrgs : myOrg.getChildOrgs()) {
//                        System.out.println("Child Org: " + childOrgs.getName());
                        if (childOrgs.getChildOrgs() != null) {
                            for (ChildOrg_ childOrgs2 : childOrgs.getChildOrgs()) {
//                                System.out.println("Child Org 2: " + childOrgs2.getName());
                                if (childOrgs2.getName().equalsIgnoreCase(organizationName)) {
//                                    System.out.println("Found - " + organizationName);
                                    if (childOrgs2.getPositions() != null ) {
//                                        System.out.println("Positions: " + childOrgs2.getPositions());
                                        for (String onePosition : childOrgs2.getPositions()) {
                                            memberNames.add(getNameFromUuid(onePosition, unitNumber, proxyLogin, "position"));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return memberNames;

    }

    public List<String> getChildOrganizationClasses(String organizationName, String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiOrganizationList = new TypeToken<ArrayList<ApiOrganization>>(){}.getType();

        responseData = getOrganizationJson(unitNumber, proxyLogin);
//            System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
            System.out.println("JSON Object!");
            System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiOrganization> testOrg = gson.fromJson(jsonElement, apiOrganizationList);

            for (ApiOrganization myOrg : testOrg) {
//                System.out.println("Organizations: " + myOrg.getName());
                if (myOrg.getName().equalsIgnoreCase(organizationName)) {
                    if (myOrg.getChildOrgs() != null) {
                        for (ChildOrg childOrgs : myOrg.getChildOrgs()) {
//                            System.out.println("Child Org: " + childOrgs.getName());
                            memberNames.add(childOrgs.getName());
                        }
                    }
                }
            }
        }

        return memberNames;

    }


    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getOrganizationJson (String unitNumber, String proxyLogin) throws IOException {
        proxyLogin = "mbthomas74";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/organization" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/organizations?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/organization" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }

    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getUserAccountsJson (String unitNumber, String position) throws IOException {
        String responseData = "";
        File organizationFile = new File("ConfigFiles/accounts" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestURLNoProxyUser("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/admin/users/accounts?positions=" + position + "&units="+ unitNumber );

//        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
//                try  {
////                    FileWriter myWriter = new FileWriter("organization.json");
//                    FileWriter myWriter = new FileWriter(organizationFile);
//                    myWriter.write(responseData);
//                    myWriter.flush();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

            } catch (IOException e) {
                e.printStackTrace();
            }
//        } else {
//            try {
//                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/accounts" + unitNumber + ".json")), StandardCharsets.UTF_8);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }

        return responseData;
    }



    public String getHouseholdJson (String unitNumber, String proxyLogin) throws IOException {
        proxyLogin = "mbthomas74";
        String responseData = "";
        File householdFile = new File("ConfigFiles/households" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/households?units=" + unitNumber, proxyLogin );


        if (!householdFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
                    FileWriter myWriter = new FileWriter(householdFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/households" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }


    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getReportJson (String unitNumber, String proxyLogin) throws IOException {
//        proxyLogin = "mbthomas74";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/reports" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/reports?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/reports" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }

    public String getQRJson (String unitNumber, String proxyLogin, String year, int quarter) throws IOException {
        String responseData = "";

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/quarterly-reports?units="+ unitNumber + "&year=" + year + "&quarter=" + quarter, proxyLogin );

        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseData;
    }

    public String getLifeResourceJson(String unitNumber, String proxyLogin) throws IOException {
        String responseData = "";

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/life-resources?units="+ unitNumber, proxyLogin );

        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseData;
    }


    public int getApiResponseCode (String apiService, String proxyLogin) throws IOException {
        int responseCode = 0;

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/"+apiService, proxyLogin); //Stage
//        Request request = requestProxyURL("https://wam-membertools-api-test.churchofjesuschrist.org/api/v4/"+apiService, proxyLogin); //Test
//        Request request = requestProxyURL("https://wam-membertools-api.churchofjesuschrist.org/api/v4/"+apiService, proxyLogin); //Prod - doesn't work

        Headers resHeader;


        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
//            responseData = response.body().string();
            responseCode = response.code();
            System.out.println("CODE: " + response.code());
            System.out.println("Message: " + response.message());

        } catch (IOException e) {
            e.printStackTrace();
        }



        return responseCode;
    }


    public String getApiInfoTEST (String unitNumber, String proxyLogin) throws IOException {
        String responseData = "";

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/reports?units="+ unitNumber, proxyLogin );
        Headers resHeader;


        try (Response response = httpClient.newCall(request).execute()) {

            assert response.body() != null;
            responseData = response.body().string();
            System.out.println("CODE: " + response.code());
            System.out.println("Message: " + response.message());

            System.out.println("*******************************************");
            resHeader = response.headers();
            for (int i = 0; i < resHeader.size(); i++) {
                System.out.println(resHeader.name(i) + ": " + resHeader.value(i));
            }
            System.out.println("*******************************************");



        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("*******************************************");
        System.out.println(responseData);
        System.out.println("*******************************************");


        return responseData;
    }

    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getReportUnitStatsJson (String unitNumber, String proxyLogin) throws IOException {
        proxyLogin = "mbthomas74";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/reportsUnitStats" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/reports/unit-statistics?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/reportsUnitStats" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }

    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getReportsActionAndInterview(String unitNumber, String proxyLogin) throws IOException {
        proxyLogin = "mbthomas74";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/reportsActionAndInterview" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/reports/action-interviews?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/reportsActionAndInterview" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }

    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getMissionaryJson (String unitNumber, String proxyLogin) throws IOException {
        proxyLogin = "mbthomas74";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/missionary" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/missionaries?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/missionary" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }


    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getCovenantPathJson(String unitNumber, String proxyLogin) throws IOException {
        String responseData = "";
        File organizationFile = new File("ConfigFiles/covenantPath" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/covenant-path?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/covenantPath" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }


    public String getFinanceExpenses(String unitNumber, String proxyLogin) throws IOException {
        String responseData = "";
        File organizationFile = new File("ConfigFiles/expenses" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/finances/expenses?units="+ unitNumber, proxyLogin );


        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }







    public int postListTest(String listMembers, String listName, int listSort, String listOwner, String proxyUser) throws IOException {
        int responseData = 0;
        String[] listOfMembers = null;
        listOfMembers = listMembers.split(",");
        String json;
//        String json = "{" +
//                "  \"members\": [" +
//                "      \"ee4a2b31-a913-442a-9cef-70722cb55f3c\"" +
//                "  ]," +
//                "  \"name\": \"TEST API\"," +
//                "  \"removed\": false," +
//                "  \"sort\": 51," +
//                "  \"uuid\": \"50eff3b6-10c2-4caf-9c18-f070e41fc1ca\"" +
//                "}";

        JSONObject jsonPost = new JSONObject();
//        jsonPost.put("members", new String[] {listMembers});
        jsonPost.put("members", listOfMembers);
        jsonPost.put("name", listName);
        jsonPost.put("removed",false);
        jsonPost.put("sort", listSort);
        jsonPost.put("uuid", listOwner);

        json = jsonPost.toString();

        System.out.println(json);




        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);

        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = new Request.Builder()
                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/lists")
                .addHeader("X-Proxy-User" , proxyUser)
                .post(body)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
//            assert response.body() != null;
//            responseData = response.body().string();
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }


    public int listDelete(String listName, String proxyUser) throws Exception {
        int responseData = 0;
        String listUuid = "";
        HashMap<String, String> listMap = new HashMap<>();

        listMap = getListNames(proxyUser);

        if (listMap.containsKey(listName)) {
            listUuid = listMap.get(listName);
            System.out.println("UUID: " + listUuid);
        }

        OkHttpClient httpClient = loginCred();
        Request request = new Request.Builder()
                .delete()
                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/lists/" + listUuid)
                .addHeader("X-Proxy-User" , proxyUser)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }





    public String getListsFromProxy(String proxyLogin) throws IOException {
        String responseData = "";
        File organizationFile = new File("ConfigFiles/lists" + proxyLogin + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();

        Request request = new Request.Builder()
                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/lists")
                .addHeader("X-Proxy-User" , proxyLogin)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();
            try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                FileWriter myWriter = new FileWriter(organizationFile);
                myWriter.write(responseData);
                myWriter.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }






    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getClassQuorumJson(String unitNumber, String proxyLogin) throws IOException {
        String responseData = "";
        File organizationFile = new File("ConfigFiles/classquorum" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/reports/class-quorum-attendance?units="+ unitNumber, proxyLogin );


        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();
            try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                FileWriter myWriter = new FileWriter(organizationFile);
                myWriter.write(responseData);
                myWriter.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }

    public HashMap<String, String> getListNames(String proxyLogin) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiLists myApiLists = new ApiLists();
        ArrayList<String> listNames = new ArrayList<String>();
        Type apiLists = new TypeToken<ArrayList<ApiLists>>(){}.getType();
        HashMap<String, String> listMap = new HashMap<>();


        responseData = getListsFromProxy(proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myApiLists = gson.fromJson(jsonElement, ApiLists.class);
//            System.out.println(myApiLists);


        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiLists> testGetList = gson.fromJson(jsonElement, apiLists);
            for(ApiLists list : testGetList) {
               listMap.put(list.getName(), list.getUuid());
            }
        }

        return listMap;
    }

    public List<String> getAllExpenses(String proxyLogin, String unitNumber) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiFinance myFinance = new ApiFinance();
//        HashMap myMap = new HashMap();
        Map<String, Object> myMap = new HashMap<>();
//        ArrayList<String> memberNames = new ArrayList<String>();
//        List<String> foundExpense = null;
        List<String> foundExpense = new ArrayList<String>();
        Type apiFinance = new TypeToken<ArrayList<ApiFinance>>(){}.getType();
        responseData = getFinanceExpenses(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myFinance = gson.fromJson(jsonElement, ApiFinance.class);


        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiFinance> testExpenses = gson.fromJson(jsonElement, apiFinance);
            for(ApiFinance unit : testExpenses) {
                List<Expense> myExpenses = unit.getExpenses();
                for (Expense myFinanceRequest: myExpenses) {
//                    foundExpense.add(myFinanceRequest.getPurpose());
                    foundExpense.add(myFinanceRequest.getStatus());
                    System.out.println(myFinanceRequest.getType());
                }
            }
        }

        return foundExpense;
    }

    public Map<String, Object> getExpensesDetail(String proxyLogin, String unitNumber, String purposeSearch) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiFinance myFinance = new ApiFinance();
//        HashMap myMap = new HashMap();
        Map<String, Object> myMap = new HashMap<>();
//        ArrayList<String> memberNames = new ArrayList<String>();
        List<String> foundExpense = null;
        Type apiFinance = new TypeToken<ArrayList<ApiFinance>>(){}.getType();
        responseData = getFinanceExpenses(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myFinance = gson.fromJson(jsonElement, ApiFinance.class);


        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiFinance> testExpenses = gson.fromJson(jsonElement, apiFinance);
            for(ApiFinance unit : testExpenses) {
                List<Expense> myExpenses = unit.getExpenses();
                for (Expense myFinanceRequest: myExpenses) {
                    if (myFinanceRequest.getPurpose().equalsIgnoreCase(purposeSearch)) {
//                        System.out.println(myFinanceRequest.getPurpose());
                        myMap.put("prupose", myFinanceRequest.getPurpose());
                        myMap.put("id", myFinanceRequest.getId());
                        myMap.put("date", myFinanceRequest.getSubmittedDate());
                        myMap.put("receiptCount", myFinanceRequest.getReceiptCount());
                        myMap.put("payeeId", myFinanceRequest.getPayee().getId());
                        myMap.put("payeeName", myFinanceRequest.getPayee().getName());
                        myMap.put("unitNumber", myFinanceRequest.getUnitNumber());
                        myMap.put("type", myFinanceRequest.getType());
                        List<Charge> myCharge = myFinanceRequest.getCharges();
                        for (Charge chargeData : myCharge) {
                            myMap.put("categoryId", chargeData.getCategoryId());
                            myMap.put("amount", chargeData.getAmount());
                        }
                    }
                }
            }
        }

        return myMap;
    }

    public List<ApiFinanceDetail> getExpensesByStatus(String proxyLogin, String unitNumber, String expenseStatus) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        List<ApiFinanceDetail> expenseList = new ArrayList<ApiFinanceDetail>();
        ApiFinance myFinance = new ApiFinance();

//        HashMap myMap = new HashMap();
        Map<String, Object> myMap = new HashMap<>();
//        ArrayList<String> memberNames = new ArrayList<String>();
        List<String> foundExpense = null;
        Type apiFinance = new TypeToken<ArrayList<ApiFinance>>(){}.getType();
        responseData = getFinanceExpenses(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myFinance = gson.fromJson(jsonElement, ApiFinance.class);


        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiFinance> testExpenses = gson.fromJson(jsonElement, apiFinance);
            for(ApiFinance unit : testExpenses) {
                List<Expense> myExpenses = unit.getExpenses();
                for (Expense myFinanceRequest: myExpenses) {
//                    System.out.println(myFinanceRequest.getStatus());
                    if (myFinanceRequest.getStatus().equalsIgnoreCase(expenseStatus)) {
                        ApiFinanceDetail expenseDetail = new ApiFinanceDetail();
//                        System.out.println(myFinanceRequest.getId());
//                        System.out.println(myFinanceRequest.getStatus());
//                        System.out.println(myFinanceRequest.getPurpose());
//                        expenseList.add(myFinanceRequest.getId().toString());

                        expenseDetail.setPurpose(myFinanceRequest.getPurpose());
                        expenseDetail.setId(myFinanceRequest.getId());
                        expenseDetail.setSubmittedDate(myFinanceRequest.getSubmittedDate());
                        expenseDetail.setApproveRejectedDate(myFinanceRequest.getApprovedRejectedDate());
//                        expenseDetail.setReceiptCount(myFinanceRequest.getReceiptCount()); //todo: check for null
                        expenseDetail.setAccountId(myFinanceRequest.getAccountId());
//                        expenseDetail.setPaymentMethodId(myFinanceRequest.getPaymentMethodId()); //todo: check for null
//                        expenseDetail.setPayeeId(myFinanceRequest.getPayee());
                        expenseDetail.setStatus(myFinanceRequest.getStatus());
                        expenseDetail.setType(myFinanceRequest.getType());

                        expenseList.add(expenseDetail);
                    }
                }
            }
        }

//        System.out.println("************************************************");
//        for (ApiFinanceDetail expenseDetailItem: expenseList) {
//            System.out.println(expenseDetailItem.getPurpose());
//            System.out.println(expenseDetailItem.getId());
//            System.out.println(expenseDetailItem.getType());
//        }
//        System.out.println("************************************************");

        return expenseList;
    }


    public int createPaymentRequest(int accountId, String payeeUuid, String purpose, int unitNumber, int categoryId, int amount, String proxyUser) throws IOException {
        int responseData = 0;

        String json;

        JSONArray arrayCharges = new JSONArray();
        JSONObject jsonCharges = new JSONObject();
        jsonCharges.put("categoryId", categoryId);
        jsonCharges.put("amount", amount);
        arrayCharges.put(jsonCharges);

        JSONObject jsonPost = new JSONObject();
        jsonPost.put("accountId", accountId);
        jsonPost.put("charges", arrayCharges);
        jsonPost.put("payeeUuid", payeeUuid);
        jsonPost.put("purpose", purpose);
        jsonPost.put("unitNumber", unitNumber);



        json = jsonPost.toString();

        System.out.println(json);


        MultipartBody multiBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("request", null, RequestBody.create(MediaType.parse("application/json"), json))
//                .addFormDataPart("application/json", json)
                .addFormDataPart("receipts", "cereal-receipt.jpeg",
                    RequestBody.create(MediaType.parse("image/jpeg"), new File("cereal-receipt.jpeg")))
                .build();

//        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = new Request.Builder()
                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/finances/reimbursement")
//                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/finances/expenses")
                .addHeader("X-Proxy-User" , proxyUser)
//                .header("Content-Type", "application/json; charset=UTF-8")
                .post(multiBody)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
//            assert response.body() != null;
//            responseData = response.body().string();
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;

        //        JSONObject jsonAddress = new JSONObject();
//        jsonAddress.put("city", "Hawthorne");
//        jsonAddress.put("postalCode", "90250-6906");
//        jsonAddress.put("state", "California");
//        jsonAddress.put("street1", "4480 W 137th P1");


//
//        JSONObject jsonPayee = new JSONObject();
//        jsonPayee.put("id" , 1264650);
//        jsonPayee.put("name", "Thomas, Mark Barrett");
//        jsonPayee.put("memberUuid", "e463aaf9-573f-4d17-8364-d4f4112cb517");
//        jsonPayee.put("memberMrn", "000-2205-6416");
//        jsonPayee.put("address", jsonAddress);


//        JSONObject jsonReceipts = new JSONObject();
//        jsonReceipts.put("id", "{8F39BADA-4B0F-4D54-8DFD-4050A2B9EF22}");
//        jsonReceipts.put("name", "passed.png");
//
//        JSONObject jsonSubmittedBy = new JSONObject();
//        jsonSubmittedBy.put("id" , 1264650);
//        jsonSubmittedBy.put("name", "Thomas, Mark Barrett");
//        jsonSubmittedBy.put("memberUuid", "e463aaf9-573f-4d17-8364-d4f4112cb517");
//        jsonSubmittedBy.put("memberMrn", "000-2205-6416");


//        jsonPost.put("type", "REIMBURSEMENT_REQUEST");
//        jsonPost.put("advancement", true);
//        jsonPost.put("status", "SUBMITTED");
//        jsonPost.put("payee", jsonPayee);
//        jsonPost.put("submittedDate", "2022-07-01");
//        jsonPost.put("receipts", jsonReceipts);
//        jsonPost.put("submittedBy", jsonSubmittedBy);

    }




    public int updateExpensePurpose(int expenseId, String purpose, String proxyUser) throws IOException {
        int responseData = 0;

        String json;

        JSONObject jsonPost = new JSONObject();
        jsonPost.put("purpose", purpose);


        json = jsonPost.toString();

        System.out.println(json);


        MultipartBody multiBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("request", null, RequestBody.create(MediaType.parse("application/json"), json))
//                .addFormDataPart("application/json", json)
//                .addFormDataPart("receipts", "passed.png",
//                    RequestBody.create(MediaType.parse("image/png"), new File("passed.png")))
                .build();

//        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = new Request.Builder()
                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/finances/expenses/" + expenseId)
                .addHeader("X-Proxy-User" , proxyUser)
//                .header("Content-Type", "application/json; charset=UTF-8")
                .put(multiBody)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
//            assert response.body() != null;
//            responseData = response.body().string();
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;

    }


    public int expenseDelete(int expenseId, String expenseType, String proxyUser) throws Exception {
        int responseData = 0;
        String listUuid = "";
        HashMap<String, String> listMap = new HashMap<>();


        OkHttpClient httpClient = loginCred();
        Request request = new Request.Builder()
                .delete()
                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/finances/expenses/" + expenseId + "?type=" + expenseType)
                .addHeader("X-Proxy-User" , proxyUser)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }


    public List<String> getAccounts(String unitNumber, String accountPosition) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiAccount myAccount = new ApiAccount();
        ArrayList<String> memberNames = new ArrayList<String>();

        Map<String, Object> myMap = new HashMap<>();
        int accountInt = Integer.parseInt(accountPosition);

        List<String> foundExpense = null;
        Type apiAccount = new TypeToken<ArrayList<ApiAccount>>(){}.getType();
        responseData = getUserAccountsJson(unitNumber, accountPosition);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
//            myAccount = gson.fromJson(jsonElement, ApiAccount.class);


        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiAccount> testAccount = gson.fromJson(jsonElement, apiAccount);
            for(ApiAccount foundMember : testAccount) {
                int myCounter = 1;
                myMap.put("ldsAccountId", foundMember.getLdsAccountId());
                myMap.put("username", foundMember.getUsername());
                myMap.put("member", foundMember.getMember());
                myMap.put("homeUnits", foundMember.getHomeUnits());
                for(PositionAccount positions: foundMember.getPositions()) {
                    if (positions.getId().equals(accountInt)) {
                        memberNames.add(foundMember.getUsername());
                    }
                    myMap.put("id" + myCounter, positions.getId());
                    myMap.put("type" + myCounter, positions.getType());
                    myMap.put("unitNumber" + myCounter, positions.getUnitNumber());
                    myCounter++;
                }
            }
        }
//        for (String myUsername: memberNames) {
//            System.out.println("LIST NAME: " + myUsername);
//        }

        return memberNames;
    }





    public List<String> getCovenantPathNames(String proxyLogin, String unitNumber, String progressRecordType) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiCovenantPath myCovenantPath = new ApiCovenantPath();
        ArrayList<String> memberNames = new ArrayList<String>();
        Type apiCovenantPath = new TypeToken<ArrayList<ApiCovenantPath>>(){}.getType();
        responseData = getCovenantPathJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myCovenantPath = gson.fromJson(jsonElement, ApiCovenantPath.class);


        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiCovenantPath> testCovenantPath = gson.fromJson(jsonElement, apiCovenantPath);
            for(ApiCovenantPath name : testCovenantPath) {
                if (progressRecordType.contains("new")) {
                    if (name.getStatus().equalsIgnoreCase("NEW_MEMBER")) {
                        memberNames.add(name.getDisplayName());
                    }
                } else {
                    if (!name.getStatus().equalsIgnoreCase("NEW_MEMBER")) {
                        memberNames.add(name.getDisplayName());
                    }
                }
            }
        }

        return memberNames;
    }


    public List<String> getCovenantPathUserDetails(String proxyLogin, String unitNumber, String userName) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiCovenantPath myCovenantPath = new ApiCovenantPath();
        ArrayList<String> memberNames = new ArrayList<String>();
        Type apiCovenantPath = new TypeToken<ArrayList<ApiCovenantPath>>(){}.getType();
        responseData = getCovenantPathJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myCovenantPath = gson.fromJson(jsonElement, ApiCovenantPath.class);


        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiCovenantPath> testCovenantPath = gson.fromJson(jsonElement, apiCovenantPath);
            for(ApiCovenantPath name : testCovenantPath) {
                if (name.getDisplayName().equalsIgnoreCase(userName)) {
                    System.out.println("Name: " + name.getDisplayName());
                    System.out.println("Sac Missed: " + name.getSacramentMeetingsMissed());
                    System.out.println("Baptism Goal Date: " + name.getBaptismGoalDate());
                    System.out.println("Confirmation Date: " + name.getConfirmationDate());
                    System.out.println("Endowment Eligibility Date: " + name.getEndowmentEligibilityDate());
                    System.out.println("First Taught: " + name.getFirstTaught());
                    System.out.println("Friends Display: " + name.getFriendsDisplay());
                    System.out.println("Status: " + name.getStatus());
                    System.out.println("Address: " + name.getAddress());
                    System.out.println("Opted Out: " + name.getOptedOut());
                    System.out.println("Sort Name: " + name.getSortName());
                    System.out.println("Next Appointment: " + name.getNextAppointment());
                    System.out.println("Priesthood Eligibility: " + name.getPriesthoodEligibility());
                    System.out.println("Sealed to Parents: " + name.getSealedToParents());
                    System.out.println("Sealed to Spouse: " + name.getSealedToSpouse());
                }
            }
        }

        return memberNames;
    }


    public List<String> getClassAndQuorum(String proxyLogin, String unitNumber, String weekToCheck) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiClassQuorumAttendance myClassQuorumAttendance = new ApiClassQuorumAttendance();
        ArrayList<String> memberNames = new ArrayList<String>();
        Type apiClassQuorumAttendance = new TypeToken<ArrayList<ApiClassQuorumAttendance>>(){}.getType();
        responseData = getClassQuorumJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


        if (jsonElement instanceof JsonObject) {
            System.out.println("JSON Object!");
            myClassQuorumAttendance = gson.fromJson(jsonElement, ApiClassQuorumAttendance.class);

        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiClassQuorumAttendance> testClassQuorumAttendance = gson.fromJson(jsonElement, apiClassQuorumAttendance);
            for (ApiClassQuorumAttendance testItem : testClassQuorumAttendance) {
                for (Week oneWeek : testItem.getWeeks()) {
//                    System.out.println("Week Name: " + oneWeek.getWeek());
                    if (oneWeek.getWeek().equalsIgnoreCase(weekToCheck)) {
//                        System.out.println("Week Found!");
                        if (oneWeek.getAttended() != null ) {
                            for (String oneUser : oneWeek.getAttended()) {
//                                System.out.println("Name from UUID: " + getNameFromUuid(oneUser, unitNumber, proxyLogin, "personal"));
                                memberNames.add(getNameFromUuid(oneUser, unitNumber, proxyLogin, "personal"));
                            }
                        }
                    }
                }
            }
        }

        return memberNames;
    }

    public List<String> getClassAndQuorumRights(String proxyLogin, String unitNumber) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiClassQuorumAttendance myClassQuorumAttendance = new ApiClassQuorumAttendance();
        ArrayList<String> memberNames = new ArrayList<String>();
        Type apiClassQuorumAttendance = new TypeToken<ArrayList<ApiClassQuorumAttendance>>(){}.getType();
        responseData = getClassQuorumJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


        if (jsonElement instanceof JsonObject) {
            System.out.println("JSON Object!");
            myClassQuorumAttendance = gson.fromJson(jsonElement, ApiClassQuorumAttendance.class);

        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiClassQuorumAttendance> testClassQuorumAttendance = gson.fromJson(jsonElement, apiClassQuorumAttendance);
            for (ApiClassQuorumAttendance testItem : testClassQuorumAttendance) {
                for (Week oneWeek : testItem.getWeeks()) {
//                    System.out.println("Week Name: " + oneWeek.getWeek());
                    System.out.println("Editable: " +oneWeek.getEditable());

//                    if (oneWeek.getWeek().equalsIgnoreCase(weekToCheck)) {
////                        System.out.println("Week Found!");
//                        if (oneWeek.getAttended() != null ) {
//                            for (String oneUser : oneWeek.getAttended()) {
////                                System.out.println("Name from UUID: " + getNameFromUuid(oneUser, unitNumber, proxyLogin, "personal"));
//                                memberNames.add(getNameFromUuid(oneUser, unitNumber, proxyLogin, "personal"));
//                            }
//                        }
//                    }
                }
            }
        }

        return memberNames;
    }



    public int getCovenantPathUserSacramentMissed(String proxyLogin, String unitNumber, String userName) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiCovenantPath myCovenantPath = new ApiCovenantPath();
        ArrayList<String> memberNames = new ArrayList<String>();
        Type apiCovenantPath = new TypeToken<ArrayList<ApiCovenantPath>>(){}.getType();
        responseData = getCovenantPathJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
        int sacramentMissed = 0;

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myCovenantPath = gson.fromJson(jsonElement, ApiCovenantPath.class);


        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiCovenantPath> testCovenantPath = gson.fromJson(jsonElement, apiCovenantPath);
            for(ApiCovenantPath name : testCovenantPath) {
                if (name.getDisplayName().equalsIgnoreCase(userName)) {
                    System.out.println("Sac Missed: " + name.getSacramentMeetingsMissed());
                    sacramentMissed = name.getSacramentMeetingsMissed();
                }
            }
        }

        return sacramentMissed;
    }




    public String getNameFromUuid( String uuidPersonal, String unitNumber, String proxyLogin, String returnType) throws IOException {
        proxyLogin = "mbthomas74";
        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/households?units=" + unitNumber, proxyLogin );
        JsonParser parser = new JsonParser();
        String responseData;
//        String myPositions = "";
        ArrayList<String> myPositions = new ArrayList<String>();
        Gson gson = new Gson();

        Type apiHousehold = new TypeToken<ArrayList<ApiHousehold>>(){}.getType();

        String memberName = "";

        responseData = getHouseholdJson(unitNumber, proxyLogin);

//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
//        System.out.println("Json element to String GET NAME FROM UUID: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
//            System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiHousehold> testHouseHold = gson.fromJson(jsonElement, apiHousehold);

            for (ApiHousehold household : testHouseHold) {
//                    System.out.println(household.getDisplayName());
//                    System.out.println(household.getUuid());
                for (Member searchForMember : household.getMembers()) {
//                        System.out.println("Household: uuid - Search For Member: " + searchForMember.getUuid());
//                        System.out.println("Household: Display Name - Search For Member: " + searchForMember.getDisplayName());
//                        System.out.println("Household: SEARCH FOR: " + uuidPersonal);
                    for (Member personalMember : household.getMembers()) {
//                        System.out.println("Personal: SEARCH FOR: " + uuidPersonal);
//                        System.out.println("Personal: uuid: " + personalMember.getUuid());
//                        System.out.println("Personal: Display Name: " + personalMember.getDisplayName());
//                        System.out.println("Positions uuid: " + personalMember.getPositions());
                        if (returnType.equalsIgnoreCase("personal")) {
                            if (personalMember.getUuid().equalsIgnoreCase(uuidPersonal)) {
                                memberName = personalMember.getDisplayName();
                            }
                        }
                        if (personalMember.getPositions() != null ) {
                            for (Position onePosition : personalMember.getPositions()) {
//                                System.out.println("Positions uuid: " + onePosition.getUuid());
//                                System.out.println("##### Position Name: " + onePosition.getName());
                                if (returnType.equalsIgnoreCase("position")) {
                                    if (onePosition.getUuid().equalsIgnoreCase(uuidPersonal)) {
                                        memberName = personalMember.getDisplayName();
//                                    System.out.println("*******Found*******" + memberName);
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }


        return memberName;

    }

    //This is to get the ordinances
    //TODO: make this return MAP to get all info?
    public List<String> getPersonalInfoFromName( String memberToFind, String unitNumber, String proxyLogin) throws IOException {
        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/households?units=" + unitNumber, proxyLogin );
        JsonParser parser = new JsonParser();
        String responseData;
//        String myPositions = "";
        ArrayList<String> myPositions = new ArrayList<String>();
        Gson gson = new Gson();

        Type apiHousehold = new TypeToken<ArrayList<ApiHousehold>>(){}.getType();


        ArrayList<String> memberNames = new ArrayList<String>();

        responseData = getHouseholdJson(unitNumber, proxyLogin);

//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
//        System.out.println("Json element to String GET NAME FROM UUID: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
//            System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiHousehold> testHouseHold = gson.fromJson(jsonElement, apiHousehold);

            for (ApiHousehold household : testHouseHold) {
//                System.out.println(household.getDisplayName());
//                System.out.println(household.getUuid());
                for (Member searchForMember : household.getMembers()) {
//                    System.out.println("Household: uuid - Search For Member: " + searchForMember.getUuid());
//                    System.out.println("Household: Display Name - Search For Member: " + searchForMember.getDisplayName());
                    if (searchForMember.getDisplayName().contains(memberToFind)) {
                        memberNames.add(searchForMember.getUuid());
                        memberNames.add(searchForMember.getDisplayName());
                        memberNames.add(searchForMember.getPriesthood());
                        if ((searchForMember.getOrdinances() != null)) {
                            for(Ordinance ordinances : searchForMember.getOrdinances()) {
                                memberNames.add(ordinances.getDate());
                                memberNames.add(ordinances.getType());
                                memberNames.add(ordinances.getOfficiator());
                            }
                        }
                    }
                }
            }
        }

        return memberNames;
    }

    public String getUdidFromName( String memberToFind, String unitNumber, String proxyLogin) throws IOException {
        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/households?units=" + unitNumber, proxyLogin );
        JsonParser parser = new JsonParser();
        String responseData;
//        String myPositions = "";
        ArrayList<String> myPositions = new ArrayList<String>();
        Gson gson = new Gson();

        Type apiHousehold = new TypeToken<ArrayList<ApiHousehold>>(){}.getType();


        String memberName = "";

        responseData = getHouseholdJson(unitNumber, proxyLogin);

//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);
//        System.out.println("Json element to String GET NAME FROM UUID: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
//            System.out.println("Name: " + ((JsonObject) jsonElement).get("name").getAsString());
        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiHousehold> testHouseHold = gson.fromJson(jsonElement, apiHousehold);

            for (ApiHousehold household : testHouseHold) {
//                System.out.println(household.getDisplayName());
//                System.out.println(household.getUuid());
                for (Member searchForMember : household.getMembers()) {
//                    System.out.println("Household: uuid - Search For Member: " + searchForMember.getUuid());
//                    System.out.println("Household: Display Name - Search For Member: " + searchForMember.getDisplayName());
                    if (searchForMember.getDisplayName().contains(memberToFind)) {
                        memberName = searchForMember.getUuid();
                    }
                }
            }
        }

        return memberName;
    }

//TODO: This needs help
    public int ordinanceDelete(String memberName, String proxyUnit, String proxyLogin) throws Exception {
        int responseData = 0;
        String json;
        String listUuid = "";
        String memberUdid = "";

        //        String json = "{" +
//                "  \"members\": [" +
//                "      \"ee4a2b31-a913-442a-9cef-70722cb55f3c\"" +
//                "  ]," +
//                "  \"name\": \"TEST API\"," +
//                "  \"removed\": false," +
//                "  \"sort\": 51," +
//                "  \"uuid\": \"50eff3b6-10c2-4caf-9c18-f070e41fc1ca\"" +
//                "}";

        memberUdid = getUdidFromName(memberName, proxyUnit, proxyLogin);

        JSONObject ordinances = new JSONObject();
        ordinances.put("type", "ORDAIN_PRIEST");

        JSONArray ordArray = new JSONArray();
        ordArray.put(ordinances);

        JSONObject jsonPost = new JSONObject();
//        jsonPost.put("memberUuid", memberUdid);
        jsonPost.put("ordinances", ordArray);


        JSONArray membersArray = new JSONArray();
        membersArray.put(jsonPost);

        JSONObject jsonMain = new JSONObject();
        jsonMain.put("members", membersArray);
        jsonMain.put("memberUuid", memberUdid);



        json = jsonMain.toString();

        System.out.println(json);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        StringBuilder contentBuilder = new StringBuilder();



        OkHttpClient httpClient = loginCred();
        Request request = new Request.Builder()
                .url("https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/admin/ordinances/priesthood")
                .addHeader("X-Proxy-User" , "mbthomas74")
                .post(body)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }


    //This will return a list of reports
    public List<String> getReportNames(String proxyLogin, String unitNumber) throws Exception {
//        proxyLogin = "mbthomas74";
//        unitNumber = "21628";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);

            for (ReportUnit access : myReport.getAccess().getUnits()) {
//                System.out.println("Unit Number : " + access.getUnitNumber().toString());
//                System.out.println("Reports : " + access.getReports().toString());
                for (Object listReportName : access.getReports().toArray()) {
//                    System.out.println("One Report: " + listReportName.toString());
                    memberNames.add(listReportName.toString());
                }
            }


        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }


        return memberNames;

    }

    public List<String> getNamesFromActionInterviewReports(String reportName, String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);


            for (ReportActionInterview actionInterview : myReport.getActionInterviews()) {
//                System.out.println("Unit Number: " + actionInterview.getUnitNumber().toString());
//                System.out.println("Name: " + actionInterview.getName());
//                System.out.println("Description: " + actionInterview.getDescription());
//                System.out.println("Type: " + actionInterview.getType());
//                System.out.println("Members: " + actionInterview.getMembers().toString());
                if (actionInterview.getName().contains(reportName)) {
                    for (Member myMembers : actionInterview.getMembers()) {
//                        System.out.println("One Member: " + myMembers.getUuid());
//                        System.out.println("One Member Name: " + getNameFromUuid( myMembers.getUuid(), unitNumber, proxyLogin, "personal"));
                        memberNames.add(getNameFromUuid( myMembers.getUuid(), unitNumber, proxyLogin, "personal"));
                    }
                }
            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }


        return memberNames;

    }

    public List<String> getNamesFromMembersMovedOut(String proxyLogin, String unitNumber) throws Exception {
//        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);


            for (ReportMembersMovedOut membersMovedOut : myReport.getMembersMovedOut()) {
//                System.out.println("Unit Number: " + membersMovedOut.getUnitNumber().toString());
//                System.out.println("Display Name: " + membersMovedOut.getDisplayName());
//                System.out.println("Moved Out Date: " + membersMovedOut.getPriorUnitMoveOutDate());
//                System.out.println("Next Unit: " + membersMovedOut.getNextUnit());
//                System.out.println("Members: " + actionInterview.getMembers().toString());
                memberNames.add(membersMovedOut.getDisplayName());

            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }


        return memberNames;

    }

    public List<String> getNamesTempleRecommendStatusActive(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);

            for (ReportUnitStatistic myUnitStats : myReport.getUnitStatistics()) {
//                System.out.println("Unit Number: " + myUnitStats.getEndowedWithRecommendUuids().toString());
                for (String memberList : myUnitStats.getEndowedWithRecommendUuids()) {
                    memberNames.add(getNameFromUuid( memberList, unitNumber, proxyLogin, "personal"));
//                    memberNames.add(memberList);
                    Collections.sort(memberNames);
                }
            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }

        return memberNames;

    }

    public List<String> getNamesTempleRecommendStatusAll(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);

            for (ReportUnitStatistic myUnitStats : myReport.getUnitStatistics()) {
//                System.out.println("Unit Number: " + myUnitStats.getEndowedWithRecommendUuids().toString());
                for (String memberList : myUnitStats.getEndowedAdultsUuids()) {
                    memberNames.add(getNameFromUuid( memberList, unitNumber, proxyLogin, "personal"));
//                    memberNames.add(memberList);
                    Collections.sort(memberNames);
                }
            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }

        return memberNames;

    }

    public List<String> getNewMembers(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);

            if (myReport.getNewMembers() != null ) {
                for (ReportNewMember myNewMember : myReport.getNewMembers()) {
                    memberNames.add(getNameFromUuid( myNewMember.getUuid(), unitNumber, proxyLogin, "personal"));
                }
            }


        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }

        return memberNames;

    }

    public List<String> getNamesFromNewMembers(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);


            for (ReportNewMember newMember : myReport.getNewMembers()) {
                System.out.println("Unit Number: " + newMember.getUnitNumber().toString());
                System.out.println("Uuid: " + newMember.getUuid());

                memberNames.add(getNameFromUuid( newMember.getUuid(), unitNumber, proxyLogin, "personal"));

            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }


        return memberNames;

    }



    public List<String> getInfoFromMinisteringBrothers(String proxyLogin, String unitNumber, String reportType) throws Exception {
//        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReports myReport = new ApiReports();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();

        responseData = getReportJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReport = gson.fromJson(jsonElement, ApiReports.class);

            if (reportType.equalsIgnoreCase("brothers")) {
                for (ReportMinisteringBrother ministeringBrother : myReport.getMinisteringBrothers()) {
//                    System.out.println("Unit Number: " + ministeringBrother.getDistricts().toString());
                    for (ReportDistrict myDistrict : ministeringBrother.getDistricts()) {
//                    System.out.println("District Name: " + myDistrict.getName());
                        // Send district name
                        memberNames.add(myDistrict.getName());
                    }
                }
            } else {
                for (ReportMinisteringSister ministeringSister : myReport.getMinisteringSisters()) {
//                    System.out.println("Unit Number: " + ministeringSister.getDistricts().toString());
                    for (ReportDistrict_ myDistrict : ministeringSister.getDistricts()) {
//                    System.out.println("District Name: " + myDistrict.getName());
                        // Send district name
                        memberNames.add(myDistrict.getName());
                    }
                }
            }




        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiReportList);

        }


        return memberNames;

    }


    //This will get the first 6 Unit Stat Numbers
    public List<String> getReportUnitStatsNumbers(String proxyLogin, String unitNumber) throws Exception {
//        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReportUnitStat myReportUnitStats = new ApiReportUnitStat();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportUnitStat = new TypeToken<ArrayList<ApiReportUnitStat>>(){}.getType();

        responseData = getReportUnitStatsJson(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReportUnitStats = gson.fromJson(jsonElement, ApiReportUnitStat.class);



//            for (ReportNewMember newMember : myReportUnitStats.getNewMembers()) {
//                System.out.println("Unit Number: " + newMember.getUnitNumber().toString());
//                System.out.println("Uuid: " + newMember.getUuid());
//
//                memberNames.add(getNameFromUuid( newMember.getUuid(), unitNumber, proxyLogin, "personal"));
//
//            }

        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReportUnitStat> testReport = gson.fromJson(jsonElement, apiReportUnitStat);
            for (ApiReportUnitStat reportName : testReport) {
                memberNames.add(reportName.getTotalMembers().toString());
                memberNames.add(reportName.getMen().toString());
                memberNames.add(reportName.getHighPriests().toString());
                memberNames.add(reportName.getElders().toString());
                memberNames.add(reportName.getProspectiveElders().toString());
                memberNames.add(reportName.getWomen().toString());
            }

        }


        return memberNames;

    }

    public List<String> getNamesActionAndInterviewReports(String reportToGet, String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiReportActionAndInterview myReportActionAndInterview = new ApiReportActionAndInterview();

        ArrayList<String> memberNames = new ArrayList<String>();

        Type apiReportListActionAndInterview = new TypeToken<ArrayList<ApiReportActionAndInterview>>(){}.getType();

        responseData = getReportsActionAndInterview(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myReportActionAndInterview = gson.fromJson(jsonElement, ApiReportActionAndInterview.class);


//            System.out.println("Type: " + myReportActionAndInterview.getType());

//            for (ActionAndInterviewMember myMember : myReportActionAndInterview.getMembers()) {
//                System.out.println("Unit Number: " + membersMovedOut.getUnitNumber().toString());
//                System.out.println("Display Name: " + membersMovedOut.getDisplayName());
//                System.out.println("Moved Out Date: " + membersMovedOut.getPriorUnitMoveOutDate());
//                System.out.println("Next Unit: " + membersMovedOut.getNextUnit());
//                System.out.println("Members: " + actionInterview.getMembers().toString());
//                memberNames.add(membersMovedOut.getDisplayName());
//
//            }

        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReportActionAndInterview> testReport = gson.fromJson(jsonElement, apiReportListActionAndInterview);
            for (ApiReportActionAndInterview actionAndInterview : testReport) {
                if (actionAndInterview.getName().equalsIgnoreCase(reportToGet)) {
                    for (ActionAndInterviewMember myMember: actionAndInterview.getMembers()) {
//                        System.out.println("Member: " + myMember.getUuid());
                        memberNames.add(getNameFromUuid( myMember.getUuid(), unitNumber, proxyLogin, "personal"));
                    }
                }
            }
        }


        return memberNames;

    }





    public List<String> getAssignedMissionaries(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiMissionary myMissionary = new ApiMissionary();

        ArrayList<String> memberNames = new ArrayList<String>();

//        Type apiReportList = new TypeToken<ArrayList<ApiReports>>(){}.getType();
        Type apiMissionary = new TypeToken<ArrayList<ApiMissionary>>(){}.getType();

        responseData = getMissionaryJson(unitNumber, proxyLogin);

//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);


//            System.out.println("Json element to String ORG: " + jsonElement.toString());
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myMissionary = gson.fromJson(jsonElement, ApiMissionary.class);

            if (myMissionary.getAssigned() != null) {
                for (Assigned assignedMissionary : myMissionary.getAssigned()) {
//                System.out.println("Assigned: " + assignedMissionary.getMission().toString() );
//                System.out.println("Unit Numbers: " + assignedMissionary.getUnitNumbers().toString());
//                System.out.println("Area ID: " + assignedMissionary.getAreaId().toString());
//                System.out.println("Email: " + assignedMissionary.getEmail().toString());
//                System.out.println("Phone: " + assignedMissionary.getPhone().toString());

                    for (Missionary missionaries : assignedMissionary.getMissionaries()) {
//                    System.out.println("Missionaries Display Name: " + missionaries.getDisplayName());
//                    System.out.println("Missionaries Preferred Name: " + missionaries.getPreferredName());
                        memberNames.add(missionaries.getPreferredName());
                    }
                }
            }


        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiMissionary);

        }


        return memberNames;

    }

    public List<String> getServingMissionaries(String proxyLogin, String unitNumber) throws Exception {
        proxyLogin = "mbthomas74";
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiMissionary myMissionary = new ApiMissionary();
        ArrayList<String> memberNames = new ArrayList<String>();
        Type apiMissionary = new TypeToken<ArrayList<ApiMissionary>>(){}.getType();

        responseData = getMissionaryJson(unitNumber, proxyLogin);
        JsonElement jsonElement = parser.parse(responseData);


        if (jsonElement instanceof JsonObject) {
            myMissionary = gson.fromJson(jsonElement, ApiMissionary.class);

            if (myMissionary.getServing() != null) {
                for (Serving servingMissionaries : myMissionary.getServing()) {
//                System.out.println("Display Name: " + servingMissionaries.getDisplayName() );
                    System.out.println("Preferred Name: " + servingMissionaries.getPreferredName());
                    memberNames.add(servingMissionaries.getPreferredName());
                }
            }


        } else if (jsonElement instanceof JsonArray) {
//                System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiReports> testReport = gson.fromJson(jsonElement, apiMissionary);

        }


        return memberNames;

    }


    public QuarterlyReport getQuarterlyReport(String proxyLogin, String unitNumber, String year, int quarter) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        QuarterlyReport myQuarterlyReport = new QuarterlyReport();
        Type QuarterlyReport = new TypeToken<ArrayList<QuarterlyReport>>(){}.getType();

        //Get the data
        responseData = getQRJson(unitNumber, proxyLogin, year, quarter);
        JsonElement jsonElement = parser.parse(responseData);

        //Check if the json is an object or array
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");

        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<QuarterlyReport> testReport = gson.fromJson(jsonElement, QuarterlyReport);
            for (QuarterlyReport quarterlyReport: testReport) {
                myQuarterlyReport = quarterlyReport;
            }

        }

        return myQuarterlyReport;

    }

    public LifeResource getLifeResource(String proxyLogin, String unitNumber) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        LifeResource myLifeResource = new LifeResource();
        Type LifeResource = new TypeToken<ArrayList<LifeResource>>(){}.getType();

        //Get the data
        responseData = getLifeResourceJson(unitNumber, proxyLogin);
        JsonElement jsonElement = parser.parse(responseData);

        //Check if the json is an object or array
        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");

        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<LifeResource> testReport = gson.fromJson(jsonElement, LifeResource);
            for (LifeResource lrReport: testReport) {
                myLifeResource = lrReport;
            }

        }

        return myLifeResource;

    }


}
