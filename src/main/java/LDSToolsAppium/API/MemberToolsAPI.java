package LDSToolsAppium.API;

import LDSToolsAppium.Web.GetBearerTokenWeb;
import LDSToolsAppium.API.Expenses.ApiFinanceMethod;
import LDSToolsAppium.API.Expenses.Expense;
import LDSToolsAppium.API.Households.ApiHousehold;
import LDSToolsAppium.API.Households.Member;
import LDSToolsAppium.API.Households.Ordinance;
import LDSToolsAppium.API.Households.Position;
import LDSToolsAppium.API.LifeResources.LifeResource;
import LDSToolsAppium.API.LifeResources.Resource;
import LDSToolsAppium.API.QuarterlyReport.QuarterlyReport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.*;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;


import org.apache.commons.codec.binary.Base64;
import org.jboss.aerogear.security.otp.Totp;
import org.json.JSONArray;
import org.json.JSONException;
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
//    String baseURL = "https://wam-membertools-api-stage.churchofjesuschrist.org/api/v4/"; //OLD
    String baseURL = "https://membertools-api-stage.churchofjesuschrist.org/api/v4/"; //NEW
//    String baseURL;

    String username = "testuser";
    String password = "testpassword";
    String twoFactor = "123456";

    String bearerToken = "  Bearer " + "eyJraWQiOiJVSXdsb1Iwc19JM2VvUzlrZjJJaGUyeENzRHdqb1ZBUTIxc1ZuUmVHcUQ0IiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULldxWEI1V0dUdlYxeE95Xzc4LWZya2dsVXJoRDlNYkxSd2ZJb2NjaHRkRUkiLCJpc3MiOiJodHRwczovL2lkLmNodXJjaG9mamVzdXNjaHJpc3Qub3JnL29hdXRoMi9kZWZhdWx0IiwiYXVkIjoiYXBpOi8vZGVmYXVsdCIsImlhdCI6MTY4MDE4Nzc4MCwiZXhwIjoxNjgwMTkxMzgwLCJjaWQiOiIwb2FrdzZpZzdtRU0zNUpaeTM1NyIsInVpZCI6IjAwdTF4ZHgzZWdsZUNSQjZDMzU3Iiwic2NwIjpbIm9wZW5pZCIsImNtaXNpZCIsInByb2ZpbGUiXSwiYXV0aF90aW1lIjoxNjgwMTg3Nzc5LCJjaHVyY2hDTUlTSUQiOiI5MDY3NjI0NTIiLCJzdWIiOiIzNTA3MjExOTY1OTkzMzMwIiwiZmlyc3ROYW1lIjoiWmFkZSBFdmVyZXR0IiwibGFzdE5hbWUiOiJNYXhmaWVsZCIsImNodXJjaENNSVNVVUlEIjoiZGRkYTZiNWQtZjJhOC00NTQ3LWI1YTUtMDUyNTM1YTNkMjEyIiwiY2h1cmNoQWNjb3VudElEIjoiMzUwNzIxMTk2NTk5MzMzMCIsImRpc3BsYXlOYW1lIjoiWmFkZSBNYXhmaWVsZCIsInBlcnNvbmFsRW1haWwiOiJ6YWRlbWF4ZmllbGRAZ21haWwuY29tIn0.RHcBppm3T2LAd4TD_7ndDYJbsYX1sXz-tQgLpTEot18OMoAwB5p-oyQSA-sf40UX1vmEa2tNTEBYOQHsZFDo9PsXf_TI0xE1SaSvUmkmOtKx3SD9_2aneaaV3b8uG5FF_kOLANHyqJ9MpKCpZ5yWimNEE30pBPQSzuzgwTIxaXZQGicU--zExISW4ZUIB6u4yEOz2g5EHjIFoy2TaJj_ReZbxo8XlVVnxdR-TRUoRt-1UCAFZQGzTisL4pHyuAT8DjdtIvu9vvgvf-eGg8GjpzGsNtYgMsN2_iU544gWLIyR8Ud-YCiTMl-2gKxS5GZSQKY1EGvvMNcxv3jFvj8l2w";

    public void bearerTokenRefresh() throws Exception {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = HttpUrl.parse("https://id.churchofjesuschrist.org/oauth2/default/v1/token");
        getInfoFromProperties();
        byte[] decodeBytes = Base64.decodeBase64(password);
        String credential = Credentials.basic(username, new String(decodeBytes));

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("grant_type", "password");
            jsonObject.put("username", username);
            jsonObject.put("password", new String(decodeBytes));
            jsonObject.put("scope", "openid");
            jsonObject.put("client_id", "0oakw6ig7mEM35JZy357");
//            jsonObject.put("client_id", Arrays.toString((Base64.encodeBase64("0oakw6ig7mEM35JZy357".getBytes()))));
            jsonObject.put("redirect_url", "https://membertools-api-stage.churchofjesuschrist.org/api/swagger-ui/oauth2-redirect.html");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        MediaType JSON = MediaType.parse("application/x-www-form-urlencoded");
        // put your json here
        RequestBody body = RequestBody.create(JSON, jsonObject.toString());


        Request request = new Request.Builder()
                .url(url)
//                .addHeader("grant_type", "authorization_code")
//                .addHeader("Authorization", "Basic " + Base64.encodeBase64("0oakw6ig7mEM35JZy357: ".getBytes()))
                .addHeader("Authorization", credential)
//                .addHeader("client_id", Arrays.toString((Base64.encodeBase64("0oakw6ig7mEM35JZy357".getBytes()))))
//                .addHeader("client_id", clientId)
//                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .post(body)
//                .post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), "grant_type=authorization_code"))
                .build();
        Response response = client.newCall(request).execute();
        JSONObject json = new JSONObject(response.body().string());
        System.out.println("JSON: " + json);
        String token = json.getString("access_token");
        System.out.println("TOKEN: "  + token);
    }

//    String authBaseURL = "https://dev-858572-admin.okta.com";
    String authBaseURL = "https://id.churchofjesuschrist.org";
//    String authBaseURL = "https://id.churchofjesuschrist.org";

    public String getAccessToken() throws Exception{
//        HttpUrl url = HttpUrl.parse("https://id.churchofjesuschrist.org");
        HttpUrl authnUrl = HttpUrl.parse(authBaseURL + "/api/v1/authn");
        OkHttpClient client = new OkHttpClient();
//        String clientId = "0oa3geius7uFlksa9357";
        String clientId = "0oakw6ig7mEM35JZy357";



        getInfoFromProperties();
        byte[] decodeBytes = Base64.decodeBase64(password);
//        String credential = Credentials.basic(username, new String(decodeBytes));

//        String CHARSET = "StandardCharset.UTF_8.name()";
        String CHARSET = "UTF-8";
        String USER_AGENT_HEADER = "User-Agent";
        String ACCEPT_CHARSET = "Accept-Charset";

        String userAgent = "MemberTools-Test";

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", username);
            jsonObject.put("password", new String(decodeBytes));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MediaType JSON = MediaType.parse("application/json;charset=UTF-8");
        // put your json here
        RequestBody body = RequestBody.create(JSON, jsonObject.toString());



        Request authnRequest = new Request.Builder()
                .url(authnUrl)
                .cacheControl(CacheControl.FORCE_NETWORK) // Do not use any caching what so ever.
                .addHeader(ACCEPT_CHARSET, CHARSET)
                .addHeader(USER_AGENT_HEADER, userAgent)
                .post(body)
             .build();
        Response response = client.newCall(authnRequest).execute();
        System.out.println(response.code());
        JSONObject json = new JSONObject(response.body().string());

        System.out.println(json);

        if (!json.getString("status").equalsIgnoreCase("mfa_required")) {
            throw new IllegalStateException("Failed initial auth");
        }


        String stateToken = json.getString("stateToken");
        JSONArray factors = json.getJSONObject("_embedded").getJSONArray("factors");
        System.out.println(factors.toString());
        JSONObject totpFactor = null;

        for (int i = 0; i < factors.length(); i++) {
            JSONObject factor = factors.getJSONObject(i);
            if (factor.getString("factorType").equalsIgnoreCase("token:software:totp")) {
                totpFactor = factor;
                break;
            }
        }

        if (totpFactor == null) {
            throw new IllegalStateException("Missing totp Factor");
        }


        String passCode = twoFactorTest();
//        System.out.println(passCode);

        JSONObject mfaJson = new JSONObject();
        try {
            mfaJson.put("stateToken", stateToken);
            mfaJson.put("passCode", passCode);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // put your json here
        RequestBody mfaBody = RequestBody.create(JSON, mfaJson.toString());

        HttpUrl mfaUrl = HttpUrl.parse(authBaseURL + "/api/v1/authn/factors").newBuilder()
                .addPathSegment(totpFactor.getString("id"))
                .addPathSegment("verify")
                .build();

        Request mfaRequest = new Request.Builder()
                .url(mfaUrl)
                .cacheControl(CacheControl.FORCE_NETWORK) // Do not use any caching what so ever.
                .addHeader(ACCEPT_CHARSET, CHARSET)
                .addHeader(USER_AGENT_HEADER, userAgent)
                .post(mfaBody)
                .build();
        Response mfaResponse = client.newCall(mfaRequest).execute();
        System.out.println("MFA Response Code: " + mfaResponse.code());
        JSONObject mfaJson2 = new JSONObject(mfaResponse.body().string());

        System.out.println(mfaJson2);


        String sessionToken = mfaJson2.getString("sessionToken");
        System.out.println("Session Token: " + sessionToken);

        if (!mfaJson2.getString("status").equalsIgnoreCase("success") || sessionToken == null)  {
            throw new IllegalStateException("Failed totp challenge");
        }

        String state = UUID.randomUUID().toString();

//        HttpUrl authorizeUrl = HttpUrl.parse(authBaseURL + "/oauth2/default/v1/authorize").newBuilder()
        HttpUrl authorizeUrl = HttpUrl.parse(authBaseURL + "/oauth2/default/v1/authorize").newBuilder()
//                .addEncodedQueryParameter("client_id", "0oakw6ig7mEM35JZy357") //Zade
//                .addEncodedQueryParameter("client_id", "0oa35dhlu2aNHfpZp357") //From Jeff - dev ten
                .addEncodedQueryParameter("client_id", clientId)
                .addEncodedQueryParameter("response_type", "code")
//                .addEncodedQueryParameter("scope", "openid profile offline_access cmisid")
                .addEncodedQueryParameter("scope", "openid profile offline_access")
                .addEncodedQueryParameter("redirect_uri", "https://membertools-api-stage.churchofjesuschrist.org/api/swagger-ui/oauth2-redirect.html")
//                .addEncodedQueryParameter("redirect_uri", "https://mobileandroid")
                .addEncodedQueryParameter("state", state)
                .addEncodedQueryParameter("sessionToken", sessionToken)

//                .addPathSegment(totpFactor.getString("factorId"))
//                .addPathSegment("verify")
                .build();
        //https://id.churchofjesuschrist.org/oauth2/default/v1/authorize?client_id=0oa35dhlu2aNHfpZp357&response_type=code&scope=openid%20profile%20offline_access%20cmisid&redirect_uri=https://mobileandroid&state=c01910b9-bb6f-4560-8d84-cf7a77b0a6f3&sessionToken=20111NFUR2FgkLte5LZa3iFwHvUhRXQLCf5o04gCxnJQ6F-Ofio-gis
        //https://id.churchofjesuschrist.org/oauth2/default/v1/authorize?client_id=0oa3geius7uFlksa9357&response_type=code&scope=openid%20profile%20offline_access%20cmisid&redirect_uri=https://mobileandroid&state=eff3c66d-23cc-4893-86d7-b5dda7d54176&sessionToken=20111g9EWM12iLxlYDNlLynvLGrZOyNSUGj9_JGV5eVGbFRQugYHI2n
        System.out.println("Authorization URL " + authorizeUrl);

        Request authorizeRequest = new Request.Builder()
                .cacheControl(CacheControl.FORCE_NETWORK) // Do not use any caching what so ever.
                .url(authorizeUrl)
                .addHeader(ACCEPT_CHARSET, CHARSET)
                .addHeader(USER_AGENT_HEADER, userAgent)
                .build();

        Response authorizeResponse = client.newBuilder().followRedirects(false).build().newCall(authorizeRequest).execute();
        String redirect = authorizeResponse.header("Location");
        System.out.println("Response Code " + authorizeResponse.code());
        System.out.println("Authorize Response Body");
        System.out.println(authorizeResponse.body().string());
        System.out.println("Redirect");
        System.out.println(redirect);
        System.out.println("Response Location " + authorizeResponse.header("Location"));
        System.out.println("Redirect Location " + redirect);
//        String responseAuthUrl = authorizeResponse.header("Location");
//        HttpUrl responseAuthHttpUrl = HttpUrl.parse(responseAuthUrl).newBuilder().build();


        HttpUrl redirectUrl = HttpUrl.parse(redirect);
        String code = redirectUrl.queryParameter("code");
        String authState = redirectUrl.queryParameter("state");

        if (code == null) {
            throw new IllegalStateException("Missing auth code");
        }

        if (!state.equals(authState)) {
            throw new IllegalStateException("Auth state does not match");
        }

        FormBody formBody = new FormBody.Builder()
                .add("code", code)
                .add("client_id", clientId)
//                .add("client_secret", oauthConfiguration.clientSecret)
                .add("grant_type", "authorization_code")
                .add("redirect_uri", "https://membertools-api-stage.churchofjesuschrist.org/api/swagger-ui/oauth2-redirect.html")
//.add("nonce", authRequest.naonce)
//.add("code_verifier", codeVerifier)
                .build();

        HttpUrl tokenUrl = HttpUrl.parse(authBaseURL + "/oauth2/default/v1/token");


        Request tokenRequest = new Request.Builder()
                .url(tokenUrl)
                .addHeader("Accept-Charset", CHARSET)
                .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + CHARSET)
                .post(formBody)
                .build();

        Response tokenResponse = client.newCall(tokenRequest).execute();

        JSONObject tokenJson = new JSONObject(tokenResponse.body().string());
        System.out.println(tokenJson);

        String accessToken = tokenJson.getString("access_token");
        if (accessToken == null) {
            throw new IllegalStateException("Missing access token");
        }

        return accessToken;


    }

    public String twoFactorTest() throws Exception {
        String otpKeyStr = twoFactor; // <- this 2FA secret key.
        Totp totp = new Totp(otpKeyStr);
        String twoFactorCode = totp.now(); // <- got 2FA coed at this time!
        System.out.println(twoFactorCode);
        return twoFactorCode;
    }



    //Login credentials for the API
    public OkHttpClient loginCred() throws Exception {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        loggingInterceptor.redactHeader("Authorization");
        loggingInterceptor.redactHeader("Cookie");

        getInfoFromProperties();

        byte[] decodeBytes = Base64.decodeBase64(password);

        TestWam2CredentialsManager credentialsManager = new TestWam2CredentialsManager(username, new String(decodeBytes));

        OkHttpClient httpClient = new OkHttpClient.Builder()
//                .addInterceptor(new TestAuthenticationInterceptor(new TestAuthenticationManager(credentialsManager)))
                .addInterceptor(loggingInterceptor)
                .connectTimeout(Duration.ofSeconds(360))
                .writeTimeout(Duration.ofSeconds(360))
                .readTimeout(Duration.ofSeconds(360))
                .build();

        return httpClient;
    }

    public void getInfoFromProperties() throws Exception {
        try (InputStream input = Files.newInputStream(Paths.get("ConfigFiles/config.properties"))) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);


            username = (prop.getProperty("db.user"));
            password = prop.getProperty("db.password");
            twoFactor = prop.getProperty("db.twoFactor");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getBearerTokenFromSelenium() throws Exception {
        GetBearerTokenWeb myTokenTest = new GetBearerTokenWeb();
        String tempBearerToken = myTokenTest.readBearerTokenFile();
        bearerToken = "  Bearer " + tempBearerToken;
    }


    public Request requestURL() throws Exception {
        getBearerTokenFromSelenium();
        Request request = new Request.Builder()
                .url(baseURL + "organizations?units=21628")
                .addHeader("Authorization", bearerToken)
//                .url("https://identity-util-service-int.churchofjesuschrist.org/api/checkSession")
//                .url(baseURL + "user")
                .addHeader("X-Proxy-User" , "mbthomas74")
                .build();
        return request;
    }

    public Request requestProxyURL(String apiUrl, String proxyUser ) throws Exception {
        getBearerTokenFromSelenium();
        Request request = new Request.Builder()
                .url(apiUrl)
                .addHeader("Authorization", bearerToken)
                .addHeader("X-Proxy-User" , proxyUser)
                .build();
        return request;
    }

    public Request requestURLNoProxyUser(String apiUrl ) throws Exception {
        getBearerTokenFromSelenium();
        Request request = new Request.Builder()
                .addHeader("Authorization", bearerToken)
                .url(apiUrl)
                .build();
        return request;
    }


    //Test Request
    public void apiRequest() throws Exception {
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
        } catch (Exception e) {
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
    public String getOrganizationJson (String unitNumber, String proxyLogin) throws Exception {
        proxyLogin = "mbthomas74";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/organization" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "organizations?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/organization" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }

    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getUserAccountsJson (String unitNumber, String position) throws Exception {
        String responseData = "";
        File organizationFile = new File("ConfigFiles/accounts" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestURLNoProxyUser(baseURL + "admin/users/accounts?positions=" + position + "&units="+ unitNumber );

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
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

            } catch (Exception e) {
                e.printStackTrace();
            }
//        } else {
//            try {
//                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/accounts" + unitNumber + ".json")), StandardCharsets.UTF_8);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }

        return responseData;
    }



    public String getHouseholdJson (String unitNumber, String proxyLogin) throws Exception {
//        proxyLogin = "mbthomas74";
        String responseData = "";
        File householdFile = new File("ConfigFiles/households" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "households?units=" + unitNumber, proxyLogin );


        if (!householdFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
                    FileWriter myWriter = new FileWriter(householdFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/households" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }


    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getReportJson (String unitNumber, String proxyLogin) throws Exception {
//        proxyLogin = "mbthomas74";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/reports" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "reports?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/reports" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }

    public String getQRJson (String unitNumber, String proxyLogin, String year, int quarter) throws Exception {
        String responseData = "";

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "quarterly-reports?units="+ unitNumber + "&year=" + year + "&quarter=" + quarter, proxyLogin );

        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseData;
    }

    public String getLifeResourceJson(String unitNumber, String proxyLogin) throws Exception {
        String responseData = "";

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "life-resources?units="+ unitNumber, proxyLogin );

        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseData;
    }


    public int getApiResponseCode (String apiService, String proxyLogin) throws Exception {
        int responseCode = 0;

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + apiService, proxyLogin); //Stage
//        Request request = requestProxyURL("https://wam-membertools-api-test.churchofjesuschrist.org/api/v4/"+apiService, proxyLogin); //Test
//        Request request = requestProxyURL("https://wam-membertools-api.churchofjesuschrist.org/api/v4/"+apiService, proxyLogin); //Prod - doesn't work

        Headers resHeader;


        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
//            responseData = response.body().string();
            responseCode = response.code();
            System.out.println("CODE: " + response.code());
            System.out.println("Message: " + response.message());

        } catch (Exception e) {
            e.printStackTrace();
        }



        return responseCode;
    }


    public String getApiInfoTEST (String unitNumber, String proxyLogin) throws Exception {
        String responseData = "";

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "reports?units="+ unitNumber, proxyLogin );
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



        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("*******************************************");
        System.out.println(responseData);
        System.out.println("*******************************************");


        return responseData;
    }

    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getReportUnitStatsJson (String unitNumber, String proxyLogin) throws Exception {
        proxyLogin = "mbthomas74";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/reportsUnitStats" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "reports/unit-statistics?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/reportsUnitStats" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }

    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getReportsActionAndInterview(String unitNumber, String proxyLogin) throws Exception {
        proxyLogin = "mbthomas74";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/reportsActionAndInterview" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "reports/action-interviews?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/reportsActionAndInterview" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }

    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getMissionaryJson (String unitNumber, String proxyLogin) throws Exception {
        proxyLogin = "mbthomas74";
        String responseData = "";
        File organizationFile = new File("ConfigFiles/missionary" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "missionaries?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/missionary" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }


    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getCovenantPathJson(String unitNumber, String proxyLogin) throws Exception {
        String responseData = "";
        File organizationFile = new File("ConfigFiles/covenantPath" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "covenant-path?units="+ unitNumber, proxyLogin );

        if (!organizationFile.exists()) {
            try (Response response = httpClient.newCall(request).execute()) {
                assert response.body() != null;
                responseData = response.body().string();
                try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                    FileWriter myWriter = new FileWriter(organizationFile);
                    myWriter.write(responseData);
                    myWriter.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                responseData = new String(Files.readAllBytes(Paths.get("ConfigFiles/covenantPath" + unitNumber + ".json")), StandardCharsets.UTF_8);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return responseData;
    }


    public String getFinanceExpenses(String unitNumber, String proxyLogin) throws Exception {
        String responseData = "";
        File organizationFile = new File("ConfigFiles/expenses" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "finances/expenses?units="+ unitNumber, proxyLogin );


        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;
    }







    public int postListTest(String listMembers, String listName, int listSort, String listOwner, String proxyUser) throws Exception {
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

        getBearerTokenFromSelenium();
        OkHttpClient httpClient = loginCred();
        Request request = new Request.Builder()
                .url(baseURL + "lists")
                .addHeader("Authorization", bearerToken)
                .addHeader("X-Proxy-User" , proxyUser)
                .post(body)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
//            assert response.body() != null;
//            responseData = response.body().string();
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (Exception e) {
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

        getBearerTokenFromSelenium();
        OkHttpClient httpClient = loginCred();
        Request request = new Request.Builder()
                .delete()
                .addHeader("Authorization", bearerToken)
                .url(baseURL + "lists/" + listUuid)
                .addHeader("X-Proxy-User" , proxyUser)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;
    }





    public String getListsFromProxy(String proxyLogin) throws Exception {
        String responseData = "";
        File organizationFile = new File("ConfigFiles/lists" + proxyLogin + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        getBearerTokenFromSelenium();
        Request request = new Request.Builder()
                .addHeader("Authorization", bearerToken)
                .url(baseURL + "lists")
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

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;
    }






    //TODO: Need a file check for the date then delete if older than 3 or so days?
    public String getClassQuorumJson(String unitNumber, String proxyLogin) throws Exception {
        String responseData = "";
        File organizationFile = new File("ConfigFiles/classquorum" + unitNumber + ".json");
        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "reports/class-quorum-attendance?units="+ unitNumber, proxyLogin );


        try (Response response = httpClient.newCall(request).execute()) {
            assert response.body() != null;
            responseData = response.body().string();
            try  {
//                    FileWriter myWriter = new FileWriter("organization.json");
                FileWriter myWriter = new FileWriter(organizationFile);
                myWriter.write(responseData);
                myWriter.flush();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
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

//    public List<String> getAllExpenses(String proxyLogin, String unitNumber) throws Exception {
//        JsonParser parser = new JsonParser();
//        String responseData;
//        Gson gson = new Gson();
//        ApiFinance myFinance = new ApiFinance();
////        HashMap myMap = new HashMap();
//        Map<String, Object> myMap = new HashMap<>();
////        ArrayList<String> memberNames = new ArrayList<String>();
////        List<String> foundExpense = null;
//        List<String> foundExpense = new ArrayList<String>();
//        Type apiFinance = new TypeToken<ArrayList<ApiFinance>>(){}.getType();
//        responseData = getFinanceExpenses(unitNumber, proxyLogin);
////        System.out.println("Response String: " + responseData);
//        JsonElement jsonElement = parser.parse(responseData);
//
//        if (jsonElement instanceof JsonObject) {
////            System.out.println("JSON Object!");
//            myFinance = gson.fromJson(jsonElement, ApiFinance.class);
//
//
//        } else if (jsonElement instanceof JsonArray) {
//            System.out.println("JSON Array!");
//            JsonArray jsonData = jsonElement.getAsJsonArray();
//            List<ApiFinance> testExpenses = gson.fromJson(jsonElement, apiFinance);
//            for(ApiFinance unit : testExpenses) {
//                List<Expense> myExpenses = unit.getExpenses();
//                for (Expense myFinanceRequest: myExpenses) {
////                    foundExpense.add(myFinanceRequest.getPurpose());
//                    foundExpense.add(myFinanceRequest.getStatus());
//                    System.out.println(myFinanceRequest.getType());
//                }
//            }
//        }
//
//        return foundExpense;
//    }


    public List<ApiFinanceMethod> getAllExpenses2(String proxyLogin, String unitNumber) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        List<String> foundExpense = null;
        Gson gson = new Gson();
        LDSToolsAppium.API.Expenses.Expense allExpense = new LDSToolsAppium.API.Expenses.Expense();
        List<ApiFinanceMethod> getAllTheExpenses = null;

//        Type apiFinance = new TypeToken<ArrayList<LDSToolsAppium.API.Expenses.Expense>>(){}.getType();
        Type apiFinance = new TypeToken<ArrayList<ApiFinanceMethod>>() {
        }.getType();
        responseData = getFinanceExpenses(unitNumber, proxyLogin);

        JsonElement jsonElement = parser.parse(responseData);


        if (jsonElement instanceof JsonObject) {
            allExpense = gson.fromJson(jsonElement, LDSToolsAppium.API.Expenses.Expense.class);
        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
//            List<LDSToolsAppium.API.Expenses.Expense> getAllTheExpenses = gson.fromJson(jsonElement, apiFinance);
            getAllTheExpenses = gson.fromJson(jsonElement, apiFinance);
//            System.out.println(getAllTheExpenses);
//            System.out.println("SIZE: " + getAllTheExpenses.size());

//            for (ApiFinanceMethod oneExpense : getAllTheExpenses) {
//                System.out.println("Unit Number: " + oneExpense.getUnitNumber());
//                System.out.println("Month: " + oneExpense.getMonth());
//                for (LDSToolsAppium.API.Expenses.Expense testExp : oneExpense.getExpenses()) {
//                    System.out.println("ID: " + testExp.getId());
//                    System.out.println("Status: " + testExp.getStatus());
//                    System.out.println("Purpose: " + testExp.getPurpose());
//                    System.out.println("Payee: " + testExp.getPayee());
//                    System.out.println("Account ID: " + testExp.getAccountId());
//                    System.out.println("Submitted By: " + testExp.getSubmittedBy());
//                    System.out.println("Submitted Date: " + testExp.getSubmittedDate());
//                }
//
//
//            }


        }


        return getAllTheExpenses;
    }

    //Todo: change to return an object
    public Map<String, Object> getExpensesDetail(String proxyLogin, String unitNumber, String purposeSearch) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiFinanceMethod myFinance = new ApiFinanceMethod();
//        HashMap myMap = new HashMap();
        Map<String, Object> myMap = new HashMap<>();
//        ArrayList<String> memberNames = new ArrayList<String>();
        List<String> foundExpense = null;
        Type apiFinance = new TypeToken<ArrayList<ApiFinanceMethod>>(){}.getType();
        responseData = getFinanceExpenses(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myFinance = gson.fromJson(jsonElement, ApiFinanceMethod.class);


        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiFinanceMethod> testExpenses = gson.fromJson(jsonElement, apiFinance);
            for(ApiFinanceMethod unit : testExpenses) {
                List<LDSToolsAppium.API.Expenses.Expense> myExpenses = unit.getExpenses();
                for (LDSToolsAppium.API.Expenses.Expense myFinanceRequest: myExpenses) {
                    if (myFinanceRequest.getPurpose().equalsIgnoreCase(purposeSearch)) {
//                        System.out.println(myFinanceRequest.getPurpose());
                        myMap.put("prupose", myFinanceRequest.getPurpose());
                        myMap.put("id", myFinanceRequest.getId());
                        myMap.put("date", myFinanceRequest.getSubmittedDate());
//                        myMap.put("receiptCount", myFinanceRequest.getReceiptCount());
                        myMap.put("receiptCount", myFinanceRequest.getReceipts().size());
                        myMap.put("payeeId", myFinanceRequest.getPayee().getId());
                        myMap.put("payeeName", myFinanceRequest.getPayee().getName());
                        myMap.put("unitNumber", myFinanceRequest.getUnitNumber());
                        myMap.put("type", myFinanceRequest.getType());
                        List<LDSToolsAppium.API.Expenses.Charge> myCharge = myFinanceRequest.getCharges();
                        for (LDSToolsAppium.API.Expenses.Charge chargeData : myCharge) {
                            myMap.put("categoryId", chargeData.getCategoryId());
                            myMap.put("amount", chargeData.getAmount());
                        }
                    }
                }
            }
        }

        return myMap;
    }

    public Expense getExpenseReturnExpense(String proxyLogin, String unitNumber, String purposeSearch) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        ApiFinanceMethod myFinance = new ApiFinanceMethod();
        Expense expenseToReturn = new Expense();
//        HashMap myMap = new HashMap();
        Map<String, Object> myMap = new HashMap<>();
//        ArrayList<String> memberNames = new ArrayList<String>();
        List<String> foundExpense = null;
        Type apiFinance = new TypeToken<ArrayList<ApiFinanceMethod>>(){}.getType();
        responseData = getFinanceExpenses(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myFinance = gson.fromJson(jsonElement, ApiFinanceMethod.class);


        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiFinanceMethod> testExpenses = gson.fromJson(jsonElement, apiFinance);
            for(ApiFinanceMethod unit : testExpenses) {
                List<LDSToolsAppium.API.Expenses.Expense> myExpenses = unit.getExpenses();
                for (LDSToolsAppium.API.Expenses.Expense myFinanceRequest: myExpenses) {
                    if (myFinanceRequest.getPurpose().equalsIgnoreCase(purposeSearch)) {
                        expenseToReturn = myFinanceRequest;
                    }
                }
            }
        }

        return expenseToReturn;
    }

    public List<ApiFinanceDetail> getExpensesByStatus(String proxyLogin, String unitNumber, String expenseStatus) throws Exception {
        JsonParser parser = new JsonParser();
        String responseData;
        Gson gson = new Gson();
        List<ApiFinanceDetail> expenseList = new ArrayList<ApiFinanceDetail>();
        ApiFinanceMethod myFinance = new ApiFinanceMethod();

//        HashMap myMap = new HashMap();
        Map<String, Object> myMap = new HashMap<>();
//        ArrayList<String> memberNames = new ArrayList<String>();
        List<String> foundExpense = null;
        Type apiFinance = new TypeToken<ArrayList<ApiFinanceMethod>>(){}.getType();
        responseData = getFinanceExpenses(unitNumber, proxyLogin);
//        System.out.println("Response String: " + responseData);
        JsonElement jsonElement = parser.parse(responseData);

        if (jsonElement instanceof JsonObject) {
//            System.out.println("JSON Object!");
            myFinance = gson.fromJson(jsonElement, ApiFinanceMethod.class);


        } else if (jsonElement instanceof JsonArray) {
            System.out.println("JSON Array!");
            JsonArray jsonData = jsonElement.getAsJsonArray();
            List<ApiFinanceMethod> testExpenses = gson.fromJson(jsonElement, apiFinance);
            for(ApiFinanceMethod unit : testExpenses) {
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


    public int createPaymentRequest(int accountId, String payeeUuid, String purpose, int unitNumber, int categoryId, int amount, String proxyUser) throws Exception {
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
        getBearerTokenFromSelenium();
        Request request = new Request.Builder()
                .url(baseURL + "finances/reimbursement")
//                .url(baseURL + "finances/expenses")
                .addHeader("X-Proxy-User" , proxyUser)
                .addHeader("Authorization", bearerToken)
//                .header("Content-Type", "application/json; charset=UTF-8")
                .post(multiBody)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
//            assert response.body() != null;
//            responseData = response.body().string();
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;

    }


    public int putExpenseUpdate(Expense expenseToUpdate, String proxyUser) throws Exception {
        int responseData = 0;
        Gson gsonTest = new Gson();
        String json;


        json = gsonTest.toJson(expenseToUpdate);
        System.out.println(json);


        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);

        StringBuilder contentBuilder = new StringBuilder();

        getBearerTokenFromSelenium();
        OkHttpClient httpClient = loginCred();
        Request request = new Request.Builder()
                .url(baseURL + "finances/expenses/" + expenseToUpdate.getId())
                .addHeader("Authorization", bearerToken)
                .addHeader("X-Proxy-User", proxyUser)
                .put(body)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
//            assert response.body() != null;
//            responseData = response.body().string();
            System.out.println("Response: " + response.code());
            responseData = response.code();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;


    }


    public int updateExpensePurpose(int expenseId, String purpose, String proxyUser) throws Exception {
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
        getBearerTokenFromSelenium();
        Request request = new Request.Builder()
                .url(baseURL + "finances/expenses/" + expenseId)
                .addHeader("Authorization", bearerToken)
                .addHeader("X-Proxy-User" , proxyUser)
//                .header("Content-Type", "application/json; charset=UTF-8")
                .put(multiBody)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
//            assert response.body() != null;
//            responseData = response.body().string();
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;

    }


    public int expenseDelete(int expenseId, String expenseType, String proxyUser) throws Exception {
        int responseData = 0;
        String listUuid = "";
        HashMap<String, String> listMap = new HashMap<>();


        OkHttpClient httpClient = loginCred();
        getBearerTokenFromSelenium();
        Request request = new Request.Builder()
                .delete()
                .url(baseURL + "finances/expenses/" + expenseId + "?type=" + expenseType)
                .addHeader("X-Proxy-User" , proxyUser)
                .addHeader("Authorization", bearerToken)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (Exception e) {
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
//                System.out.println("USERNAME: " + foundMember.getUsername());
//                System.out.println("MEMBER: " +  foundMember.getMember());
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




    public String getNameFromUuid( String uuidPersonal, String unitNumber, String proxyLogin, String returnType) throws Exception {
        proxyLogin = "mbthomas74";
        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "households?units=" + unitNumber, proxyLogin );
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
    public List<String> getPersonalInfoFromName( String memberToFind, String unitNumber, String proxyLogin) throws Exception {
        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "households?units=" + unitNumber, proxyLogin );
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

    public String getUdidFromName( String memberToFind, String unitNumber, String proxyLogin) throws Exception {
        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "households?units=" + unitNumber, proxyLogin );
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

    public List<ApiHousehold> getHouseholdInfo( String unitNumber, String proxyLogin) throws Exception {
        OkHttpClient httpClient = loginCred();
        Request request = requestProxyURL(baseURL + "households?units=" + unitNumber, proxyLogin);
        JsonParser parser = new JsonParser();
        String responseData;
        List<ApiHousehold> testHouseHold = null;
//        String myPositions = "";
        ArrayList<String> myPositions = new ArrayList<String>();
        Gson gson = new Gson();

        Type apiHousehold = new TypeToken<ArrayList<ApiHousehold>>() {}.getType();


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
            testHouseHold = gson.fromJson(jsonElement, apiHousehold);

//            for (ApiHousehold household : testHouseHold) {
////                System.out.println(household.getDisplayName());
////                System.out.println(household.getUuid());
//                for (Member searchForMember : household.getMembers()) {
////                    System.out.println("Household: uuid - Search For Member: " + searchForMember.getUuid());
////                    System.out.println("Household: Display Name - Search For Member: " + searchForMember.getDisplayName());
//                    if (searchForMember.getDisplayName().contains(memberToFind)) {
//                        memberName = searchForMember.getUuid();
//                    }
//                }
//            }
        }

        return testHouseHold;
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
        getBearerTokenFromSelenium();
        Request request = new Request.Builder()
                .url(baseURL + "admin/ordinances/priesthood")
                .addHeader("X-Proxy-User" , "mbthomas74")
                .addHeader("Authorization", bearerToken)
                .post(body)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (Exception e) {
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

    public int createLifeResource(String unitNumber, String proxyUser, Resource lifeResource) throws Exception {
        int responseData = 0;
        Gson gsonTest = new Gson();
        String json;


        json = gsonTest.toJson(lifeResource);
        System.out.println(json);


        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);

        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        getBearerTokenFromSelenium();
        Request request = new Request.Builder()
                .url(baseURL + "life-resources")
                .addHeader("Authorization", bearerToken)
                .addHeader("X-Proxy-User", proxyUser)
                .post(body)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
//            assert response.body() != null;
//            responseData = response.body().string();
            System.out.println("Response: " + response.code());
            responseData = response.code();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;

    }

    public int lifeResourceDelete(Resource myResource, String proxyUser) throws Exception {
        int responseData = 0;
        String listUuid = "";




        OkHttpClient httpClient = loginCred();
        getBearerTokenFromSelenium();
        Request request = new Request.Builder()
                .delete()
                .url(baseURL + "life-resources/" + myResource.getUuid())
                .addHeader("X-Proxy-User" , proxyUser)
                .addHeader("Authorization", bearerToken)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println("Response: "  + response.code());
            responseData = response.code();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;
    }

    public int putLifeResource( String proxyUser, Resource lifeResource) throws Exception {
        int responseData = 0;
        Gson gsonTest = new Gson();
        String json;


        json = gsonTest.toJson(lifeResource);
        System.out.println(json);


        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);

        StringBuilder contentBuilder = new StringBuilder();

        OkHttpClient httpClient = loginCred();
        getBearerTokenFromSelenium();
        Request request = new Request.Builder()
                .url(baseURL + "life-resources/" + lifeResource.getUuid())
                .addHeader("X-Proxy-User", proxyUser)
                .addHeader("Authorization", bearerToken)
                .put(body)
                .build();


        try (Response response = httpClient.newCall(request).execute()) {
//            assert response.body() != null;
//            responseData = response.body().string();
            System.out.println("Response: " + response.code());
            responseData = response.code();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;

    }







}
