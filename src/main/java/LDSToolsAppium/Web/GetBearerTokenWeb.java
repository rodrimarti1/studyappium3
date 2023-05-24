package LDSToolsAppium.Web;


import com.google.gson.stream.JsonReader;
import io.cucumber.java.hu.De;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.protocol.HTTP;
import org.jboss.aerogear.security.otp.Totp;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v110.network.Network;
import org.openqa.selenium.devtools.v110.network.model.RequestId;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import com.google.gson.*;


public class GetBearerTokenWeb {

    String username = "testuser";
    String password = "testpassword";
    String twoFactor = "123456";

    static ChromeDriver driver;
    DevTools devTools;


    @Test
    public void headerTest() throws Exception {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(),
                entry -> {
                    RequestId requestid = entry.getRequestId();
//                    System.out.println("Request Method : " + entry.getRequest().getMethod());
//                    System.out.println("Request URI : " + entry.getRequest().getUrl());
//                    System.out.println("Request headers:");
                    entry.getRequest().getHeaders().toJson().forEach((k, v) -> System.out.println((k + ":" + v)));
                    Optional<String> postData = entry.getRequest().getPostData();
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    postData.ifPresentOrElse(p -> System.out.println("Request Body: \n" + gson.toJson(JsonParser.parseString(p)) + "\n"),
                            () -> System.out.println("Not request body found \n"));

                });
        driver.get("https://www.booking.com");
    }

    public void setupDriver() throws Exception {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

//        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//        devTools.addListener(Network.requestWillBeSent(),
//                entry -> {
//                    RequestId requestid = entry.getRequestId();
//                    System.out.println("Request Method : " + entry.getRequest().getMethod());
//                    System.out.println("Request URI : " + entry.getRequest().getUrl());
//                    System.out.println("Request headers:");
//                    entry.getRequest().getHeaders().toJson().forEach((k, v) -> System.out.println((k + ":" + v)));
//                    Optional<String> postData = entry.getRequest().getPostData();
//                    Gson gson = new GsonBuilder()
//                            .setPrettyPrinting()
//                            .setLenient()
//                            .create();
////                    postData.ifPresentOrElse(p -> System.out.println("Request Body: \n" + gson.toJson(JsonParser.parseString(p.trim())) + "\n"),
////                            () -> System.out.println("Not request body found \n"));
//
//                    postData.ifPresentOrElse(p -> {
//                                System.out.println("Request Body: \n" + gson.toJson(new JsonReader(new StringReader(p))) + "\n");
//                            },
//                            () -> System.out.println("Not request body found \n"));
//
//                });



        final RequestId[] requestIds = new RequestId[1];
        devTools.send(Network.enable(Optional.of(100000000), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            if (responseReceived.getResponse().getUrl().contains("id.churchofjesuschrist.org")) {
//                System.out.println("URL: " + responseReceived.getResponse().getUrl());
//                System.out.println("Status: " + responseReceived.getResponse().getStatus());
//                System.out.println("Type: " + responseReceived.getType().toJson());
                responseReceived.getResponse().getHeaders().toJson().forEach((k, v) -> System.out.println((k + ":" + v)));
                requestIds[0] = responseReceived.getRequestId();
                String responseBody = devTools.send(Network.getResponseBody(requestIds[0])).getBody();
                if (responseBody.contains("access_token")) {
                    //some parser code > save to file
                    try {
                        parseToken(responseBody);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
//                System.out.println("Response Body: \n" + responseBody + "\n");
            }
        });
    }

    @Test
    public void parseToken(String toParse) throws Exception {
//        String toParse = "{\"token_type\":\"Bearer\",\"expires_in\":3600,\"access_token\":\"eyJraWQiOiJVSXdsb1Iwc19JM2VvUzlrZjJJaGUyeENzRHdqb1ZBUTIxc1ZuUmVHcUQ0IiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULmlqWGliV2hyUG81elNGQV9qZXhhTFRZUnUxZEFlNl9VVW1Qd2V4cjR0ZkEiLCJpc3MiOiJodHRwczovL2lkLmNodXJjaG9mamVzdXNjaHJpc3Qub3JnL29hdXRoMi9kZWZhdWx0IiwiYXVkIjoiYXBpOi8vZGVmYXVsdCIsImlhdCI6MTY4MDE5OTIzMCwiZXhwIjoxNjgwMjAyODMwLCJjaWQiOiIwb2FrdzZpZzdtRU0zNUpaeTM1NyIsInVpZCI6IjAwdTF4ZHgzZWdsZUNSQjZDMzU3Iiwic2NwIjpbIm9wZW5pZCIsImNtaXNpZCIsInByb2ZpbGUiXSwiYXV0aF90aW1lIjoxNjgwMTk5MjI2LCJjaHVyY2hDTUlTSUQiOiI5MDY3NjI0NTIiLCJzdWIiOiIzNTA3MjExOTY1OTkzMzMwIiwiZmlyc3ROYW1lIjoiWmFkZSBFdmVyZXR0IiwibGFzdE5hbWUiOiJNYXhmaWVsZCIsImNodXJjaENNSVNVVUlEIjoiZGRkYTZiNWQtZjJhOC00NTQ3LWI1YTUtMDUyNTM1YTNkMjEyIiwiY2h1cmNoQWNjb3VudElEIjoiMzUwNzIxMTk2NTk5MzMzMCIsImRpc3BsYXlOYW1lIjoiWmFkZSBNYXhmaWVsZCIsInBlcnNvbmFsRW1haWwiOiJ6YWRlbWF4ZmllbGRAZ21haWwuY29tIn0.mEA9Hrm1JjAyFPo9aJuPCmiMqX_8W1S3uXvWTBdiaobams5fOd5zZcofKAFJdocl6Yo0sMIWLbGT7RLe0GbPjBMONFwjt4ZMw20I4XywHqCUVOVtux47ALqCnjzIRXUsp16SWj18f_4e3nl536Z24q8CGdBUcmcnaYssyk65tOTLlq8NlZpijROVCJyQf5QwXAfuzppwhdpwfQndGxDr9NPGtWyLDpxNylBkh105kNoYXdNYM2M4xkpuCF9fCUVGmvDLq6SVO3kVvkcNG8rzD2CHRca0V3XDunAIxhBPyr1-Fa5yhJxkPS0mb8SDgUXqCAIUA_VvsMCAcwUEvUtyyg\",\"scope\":\"openid cmisid profile\",\"id_token\":\"eyJraWQiOiJVSXdsb1Iwc19JM2VvUzlrZjJJaGUyeENzRHdqb1ZBUTIxc1ZuUmVHcUQ0IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiIwMHUxeGR4M2VnbGVDUkI2QzM1NyIsIm5hbWUiOiJaYWRlIE1heGZpZWxkIiwidmVyIjoxLCJpc3MiOiJodHRwczovL2lkLmNodXJjaG9mamVzdXNjaHJpc3Qub3JnL29hdXRoMi9kZWZhdWx0IiwiYXVkIjoiMG9ha3c2aWc3bUVNMzVKWnkzNTciLCJpYXQiOjE2ODAxOTkyMzAsImV4cCI6MTY4MDIwMjgzMCwianRpIjoiSUQuWEJRYmFreE80YUlTUmItNFZ2T0NXVWRPNF9YX3pUY2h5a09rUmtfWUZmayIsImFtciI6WyJvdHAiLCJtZmEiLCJwd2QiXSwiaWRwIjoiMDBvem13Y2lpZndPdUVuMEIzNTYiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ6bWF4ZmllbGQiLCJhdXRoX3RpbWUiOjE2ODAxOTkyMjYsImF0X2hhc2giOiI0NkpLbUM2M0h5UExwVzFtU1d3NktnIiwiY2h1cmNoQ01JU0lEIjoiOTA2NzYyNDUyIiwibGFzdE5hbWUiOiJNYXhmaWVsZCIsImZpcnN0TmFtZSI6IlphZGUgRXZlcmV0dCIsImNodXJjaENNSVNVVUlEIjoiZGRkYTZiNWQtZjJhOC00NTQ3LWI1YTUtMDUyNTM1YTNkMjEyIiwiY2h1cmNoQWNjb3VudElEIjoiMzUwNzIxMTk2NTk5MzMzMCIsImRpc3BsYXlOYW1lIjoiWmFkZSBNYXhmaWVsZCIsInBlcnNvbmFsRW1haWwiOiJ6YWRlbWF4ZmllbGRAZ21haWwuY29tIn0.Fyruuj3vPsJtqto8sbgvRYqLbGhqUu5t_qNoRNFQexx0eXQq3AIte1_ufI42xQJLgdVsx268-nGZv_t0o3nA6Bl5bady3efh9kV-y-aTEWnYXI3Tdj5saq_wssAFJOAigc-K1KExZmWym_NrIXXECE1IzyBWm-iWVOt1u9-Pem5PXvoO0SJvesOZvsldKbivYR3XyEQshAgbPGTEwr1hhGMl1KBWNuW9NVDN4jmxg0_iaH1LUhzUtaUD1_dfTewzdHZa_Mgtx6nmudAB6kaenjqrsTPJqZOI6_iiI9rSXbsxTV0c1hA-fHlpJ5sT1CwtVsBYTLG-IchhgRAtbGuwPQ\"}";
        JsonObject myJson = JsonParser.parseString(toParse).getAsJsonObject();
//        System.out.println(myJson.get("token_type"));
//        System.out.println(myJson.get("expires_in"));
//        System.out.println(myJson.get("access_token"));

        LocalDateTime timeNow = LocalDateTime.now();
//        System.out.println("Time " + timeNow);

        LocalDateTime expireTime = LocalDateTime.now().plusHours(1);
//        System.out.println("Expire Time " + expireTime);

        if (LocalDateTime.now().isBefore(expireTime)) {
            System.out.println("Token is still good!");
        }

        myJson.addProperty("created_time" , timeNow.toString());
        myJson.addProperty("expire_time" , expireTime.toString());




        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String myTest = gson.toJson(myJson);



        writeBearerTokenFile(myTest);

//        System.out.println(myTest);


    }

    @Test
    public String readBearerTokenFile() throws Exception {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSSS");
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String jsonText = readTokenFile();
        JSONObject jsonData = new JSONObject(jsonText);
//        System.out.println(jsonData.get("access_token"));
//        System.out.println(jsonData.get("expire_time"));
//        LocalDateTime expireTime = (LocalDateTime) jsonData.get("expire_time");
        LocalDateTime expireTime = LocalDateTime.parse((CharSequence) jsonData.get("expire_time"), formatter);
        String accessToken = (String) jsonData.get("access_token");

        //Get Local Time
        LocalTime timeNow = LocalTime.now();
//        System.out.println("Time " + timeNow);

        //See if token is still valid
        if (LocalDateTime.now().isBefore(expireTime)) {
            System.out.println("Token is still good!");

        } else {
            getBearerTokenFromSwagger();
            jsonText = readTokenFile();
            jsonData = new JSONObject(jsonText);
            accessToken = (String) jsonData.get("access_token");
        }
//        eyJraWQiOiJVSXdsb1Iwc19JM2VvUzlrZjJJaGUyeENzRHdqb1ZBUTIxc1ZuUmVHcUQ0IiwiYWxnIjoiUlMyNTYifQ
//        System.out.println("******************************");
//        System.out.println(accessToken);
//        System.out.println("******************************");

        return accessToken;
    }

    public String readTokenFile() throws Exception {
        File bearerTokenFile = new File("AppUnderTest/bearerToken.json");
        InputStream bearerFile = Files.newInputStream(bearerTokenFile.toPath());
        String jsonText = IOUtils.toString(bearerFile, "UTF-8");
//        System.out.println(jsonText);
        return jsonText;
    }

    @Test
    public void writeBearerTokenFile(String tokenInfo) throws Exception {
        File bearerTokenFile = new File("AppUnderTest/bearerToken.json");
        try {
            FileWriter myFileWriter = new FileWriter(bearerTokenFile, false);
            myFileWriter.write(tokenInfo);
            myFileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }




    @Test
    public void getBearerTokenFromSwagger() throws Exception {
        setupDriver();
//        captureNetworkCalls();

        getPropInfo();
        byte[] decodeBytes = Base64.decodeBase64(password);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://membertools-api-stage.churchofjesuschrist.org/api/swagger-ui");

        //Not needed anymore
//        WebElement loginName = driver.findElement(By.id("username"));
//        WebElement password = driver.findElement(By.id("password"));
//        WebElement signInButton = driver.findElement(By.id("sign-in"));
//        loginName.sendKeys(username);
//        password.sendKeys(new String(decodeBytes));
//        signInButton.click();

        //Should be on the swagger page.
        Thread.sleep(2000);
        WebElement authorizeButton = driver.findElement(By.xpath("//button[@class='btn authorize unlocked']"));

        authorizeButton.click();

        //Authorize Pop out
        Thread.sleep(2000);

        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        //Check we don't have other windows open already
        assert driver.getWindowHandles().size() == 1;


        WebElement authorizePKCE = driver.findElement(By.xpath("//label[@for='client_secret']/../..//button[@class='btn modal-btn auth authorize button']"));
        authorizePKCE.click();

        //Login Again
        Thread.sleep(4000);

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }


//        System.out.println(driver.getTitle());
//        System.out.println(driver.getPageSource());
//        WebElement oktaUserName = driver.findElement(By.id("okta-signin-username"));
        WebElement oktaUserName = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement oktaNextButton = driver.findElement(By.xpath("//input[@value='Next']"));

        oktaUserName.sendKeys(username);
        oktaNextButton.click();

        Thread.sleep(2000);
        WebElement oktaPassword = driver.findElement(By.id("input73"));
        WebElement verifyPasswordButton = driver.findElement(By.xpath("//input[@value='Verify']"));

        oktaPassword.sendKeys(new String(decodeBytes));
        verifyPasswordButton.click();

        Thread.sleep(2000);
        WebElement oktaTwoFactor = driver.findElement(By.id("input99"));
        WebElement oktaTwoFactorButton = driver.findElement(By.xpath("//input[@value='Verify']"));


        oktaTwoFactor.sendKeys(twoFactorTest());
        oktaTwoFactorButton.click();


        driver.switchTo().window(originalWindow);
        Thread.sleep(5000);
        WebElement closeAuthorize = driver.findElement(By.xpath("//label[@for='client_secret']/../..//button[@class='btn modal-btn auth btn-done button']"));
        closeAuthorize.click();
        WebElement administration = driver.findElement(By.xpath("//*[@id='operations-tag-Administration']/a"));
        administration.click();


        driver.quit();

    }

    public void devToolsGetHeader() throws Exception {
        DevTools devTool = driver.getDevTools();
        devTool.createSession();

    }


    private static void logBrowserConsoleLogs() {

        all(LogType.PERFORMANCE);

    }

    public static void all(String logTypes) {
        System.out.println("================== " + logTypes + "  LOGS =======================");

        List<LogEntry> logEntries = driver.manage().logs().get(logTypes).getAll();
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
        System.out.println("=======================================================");
    }

    public void getPropInfo() throws Exception {
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

    public String twoFactorTest() throws Exception {
        String otpKeyStr = twoFactor; // <- this 2FA secret key.
        Totp totp = new Totp(otpKeyStr);
        String twoFactorCode = totp.now(); // <- got 2FA coed at this time!
        System.out.println(twoFactorCode);
        return twoFactorCode;
    }



}
