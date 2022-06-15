package LDSToolsAppium;

import LDSToolsAppium.Screen.*;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class MobileDevApp {
    private final AppiumDriver driver2;

    public MobileDevApp(AppiumDriver driver) {
        this.driver2 = driver;
    }

    //Mobile Dev
    public MobileDevMain mobileDevMain() throws Exception {
        return new MobileDevMain(driver2);
    }


}