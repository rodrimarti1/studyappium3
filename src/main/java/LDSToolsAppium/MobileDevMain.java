package LDSToolsAppium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MobileDevMain extends BaseDriver {


    public MobileDevMain(AppiumDriver driver2) {
        super();
    }

    public static void main(String[] args) throws Exception {

        MobileDevMain myMobileDevMain = new MobileDevMain("android", "android-mobile-dev-release.apk", "emulator-5554", 200,"UAT");

        myMobileDevMain.mobileDevTeardown();



    }


    public MobileDevMain(String os, String fileName, String testDevice, int startSleepTime, String networkEnvironment) throws Exception {
        super();

//        setUp("android", "android-mobile-dev-release.apk", "emulator-5554", 200);

//        System.out.println("OS: " + os);
//        System.out.println("File Name: " + fileName);
//        System.out.println("Test Device: " + testDevice);
        int systemPort = 8222;



        setUp(os, fileName, testDevice, startSleepTime, systemPort);

        if (driver2.findElement(By.id("devModeCheckBox")).getAttribute("checked").equalsIgnoreCase("false")) {
            driver2.findElement(By.id("devModeCheckBox")).click();
        }

        driver2.findElement(By.id("toolsNetworkEnvAutoCompleteTextView")).clear();
        driver2.findElement(By.id("toolsNetworkEnvAutoCompleteTextView")).sendKeys(networkEnvironment);




    }

    public void mobileDevTeardown() throws Exception {
        System.out.println("Start teardown");
        driver2.quit();

        System.out.println("Stopping the Appium Service");
        myAppiumService.stopAppiumService();

        System.out.println("End teardown");

    }



}
