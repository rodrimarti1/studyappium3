package LDSToolsAppium;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppiumService {
	public static AppiumDriverLocalService myAppiumService;


	public static void startAppiumService(String os, int myPort) throws Exception {
		System.out.println("OS: " + os);
		System.out.println("PORT: " + myPort);
		String appiumPath = "bad";

		String processorType = System.getProperty("os.arch");
		Map<String, String> map = System.getenv();
//		for (Map.Entry <String, String> entry: map.entrySet()) {
//			System.out.println("Variable Name:- " + entry.getKey() + " Value:- " + entry.getValue());
//			if (entry.getKey().equals("ZAPPIUM_HOME")) {
//				appiumPath = entry.getValue();
//			}
//		}

//		System.out.println("Processor: " + processorType);
//		System.getProperties().list(System.out);
		if (processorType.equalsIgnoreCase("x86_64")) {
			appiumPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";
		} else {
			appiumPath = "/opt/homebrew/lib/node_modules/appium/build/lib/main.js";
		}

//		if (appiumPath.equalsIgnoreCase("bad")) {
//			appiumPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";
//		}
//		assert appiumPath != null;

			//Setup the service
		System.out.println("Creating Appium Service");
		File appiumLogFile = new File("screenshot/myAppiumLog.txt");
		new FileOutputStream(appiumLogFile, false).close();

		myAppiumService = new AppiumServiceBuilder()
//				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withAppiumJS(new File(appiumPath))
				.usingPort(myPort)
				.withIPAddress("127.0.0.1")
				.withLogFile(appiumLogFile)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withArgument(GeneralServerFlag.LOG_LEVEL, "warn")
				.withArgument(GeneralServerFlag.RELAXED_SECURITY)
				.withArgument(() -> "--base-path", "/wd/hub")
//				.withArgument(() -> "--base-path", "/")
				.build();
		System.out.println("Starting Appium");
		myAppiumService.start();
		Thread.sleep(3000);

	}
	
	public boolean appiumServiceRunning() {
		boolean runningStatus = false;
		
		runningStatus = myAppiumService.isRunning();
		System.out.println("Appium Service Running: " + runningStatus);
		
		return runningStatus;
		
	}
	
	public String appiumServiceURL() {
		String stringURL;
		
		stringURL = myAppiumService.getUrl().toString();
		System.out.println("Appium Service URL: " + stringURL);
		
		return stringURL;
		
	}
	
	public void stopAppiumService() {
		myAppiumService.stop();
	}

}