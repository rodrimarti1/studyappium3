package LDSToolsAppium.Screen;

import LDSToolsAppium.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import java.util.*;
import org.testng.Assert;




public class DirectoryScreen extends BasePage {

    public DirectoryScreen(ThreadLocal<AppiumDriver> driver) {
        super(driver);
        Duration myDuration = Duration.ofSeconds(10);
        PageFactory.initElements(new AppiumFieldDecorator(driver.get(), myDuration), this);
    }


    // ****************** Directory Main Screen ******************

    // ****************** Directory Dropdown ******************
    //Directory Dropdown
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Directory']")
    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[1]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Directory' AND type == 'XCUIElementTypeStaticText'")
//    @iOSXCUITFindBy(accessibility = "Directory")
    public WebElement directoryDropdown;

    //Unit Selected
//    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resouce-id='ab_toolbar']/android.widget.TextView[2]")
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/drop_arrow" )
    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[1]" )
//    @iOSXCUITFindBy(xpath = "//*[@name='LDS_Tools.DirectoryView']//XCUIElementTypeStaticText[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, '▾')]/XCUIElementTypeButton")
    public WebElement unitSelected;


    // ****************** Search ******************
    //Search Directory
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterEditText")
    @AndroidFindBy(xpath = "//*[@text='Search']/../..")
//    @iOSXCUITFindBy(accessibility = "Search")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Search'")
    public  WebElement searchBar;

    //Clear Search
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/clearTextImageButton")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public WebElement searchCancel;


    // ****************** Directory Users ******************
    // Picture
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/individual_thumbnail_image_view")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='missing'])")
    @iOSXCUITFindBy(accessibility = "missing")
    public WebElement thumbNail;


    // ****************** Sort ******************
    //Sort Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterMenuImageButton")
    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[2]")
    //@AndroidFindBy(xpath = "//*[@resource-id='filterMenuImageButton']")
    @iOSXCUITFindBy(accessibility = "Sort")
//    @iOSXCUITFindBy(accessibility = "Sort Options")
    public  WebElement directorySort;

    //Households
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Households']")
    @AndroidFindBy(xpath = "//android.widget.ScrollView//*[@text='Household']")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"Household\")]")
    public  WebElement sortHousehold;

    //Individuals
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Individuals']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Name']")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"Name\")]")
    public  WebElement sortIndividual;


    // ****************** Edit ******************
    //Edit Button
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/edit_fab")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Information']/..")
    @iOSXCUITFindBy(accessibility = "Edit")
    public  WebElement directoryEdit;



    // ********** iOS Expand Buttons **********
    //Household Members
    //@iOSXCUITFindBy(iOSNsPredicate = "name == 'HOUSEHOLD MEMBERSOpen Drawer' AND type == 'XCUIElementTypeButton'")
    @iOSXCUITFindBy(accessibility = "View Household")
    public  WebElement householdMembers;

    //Home Teaching Visiting Teaching
    //@iOSXCUITFindBy(iOSNsPredicate = "name == 'HOME AND VISITING TEACHINGOpen Drawer' AND type == 'XCUIElementTypeButton'")
    //@iOSXCUITFindBy(iOSNsPredicate = "name == 'MINISTERINGOpen Drawer' AND type == 'XCUIElementTypeButton'")
    @iOSXCUITFindBy(accessibility = "Ministering")
    public  WebElement htvt;

    //Callings and Classes
    //@iOSXCUITFindBy(iOSNsPredicate = "name == 'CALLINGS AND CLASSESOpen Drawer' AND type == 'XCUIElementTypeButton'")
    @iOSXCUITFindBy(accessibility = "Callings and Classes")
    public  WebElement callingsAndClasses;

    //Membership Information
    //@iOSXCUITFindBy(iOSNsPredicate = "name == 'MEMBERSHIP INFORMATIONOpen Drawer' AND type == 'XCUIElementTypeButton'")
    @iOSXCUITFindBy(accessibility = "Membership Information")
    public  WebElement memebershipInformation;

    //Show Record Number
    @iOSXCUITFindBy(accessibility = "Show Record Number")
    public WebElement showRecordNumber;

    //Account Password
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    public WebElement accountPassword;

    //OK on Account Password
    @iOSXCUITFindBy(accessibility = "OK")
    public WebElement accountPasswordOK;

    //Cancel on Account Password
    @iOSXCUITFindBy(accessibility = "Cancel")
    public WebElement accountPasswordCancel;



    // ********** Android Elements **********
    //Tab Contact
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"contact\")]")
    public  WebElement tabContact;

    //Tab Household
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"household\")]")
    public  WebElement tabHousehold;

    //Tab Callings
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"callings and classes\")]")
    public  WebElement tabCallings;

    //Tab Home and Visiting Teaching
    //@AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"home and visiting teaching\")]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"ministering\")]")
    public  WebElement tabHTVT;

    //Tab Membership
//    @AndroidFindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), \"membership information\")]")
    @AndroidFindBy(xpath = "//*[@text='Membership Information']")
//    @AndroidFindBy(accessibility = "Membership Information")
    public  WebElement tabMembership;





    // ********** LAT LONG - GPS **********
    //Household Location
    @iOSXCUITFindBy(accessibility = "Household Location")
    public WebElement gpsHouseholdLocation;

    //Household Location Lat Long
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/latLngTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name = 'Household Location']/following-sibling::XCUIElementTypeStaticText")
    public WebElement gpsHouseholdLocationLatLong;

    //Household Location Pin
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeMap/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther[1]")
    public WebElement gpsHouseholdLocationPin;

    //Household Location Legal - Google
    @AndroidFindBy(xpath ="//android.view.View[@content-desc=\"Google Map\"]/android.widget.RelativeLayout/android.widget.ImageView")
    @iOSXCUITFindBy(accessibility = "Legal")
    public WebElement gpsHouseholdLocationLegal;

    //Adjust Household Location
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/adjustHouseholdLocationButton")
//    @iOSXCUITFindBy(accessibility = "Adjust Household Location")
    @iOSXCUITFindBy(accessibility = "ADJUST HOUSEHOLD LOCATION")
    public WebElement gpsAdjustHouseholdLocation;

    //Adjust Household Location Lowercase
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/adjustHouseholdLocationButton")
//    @iOSXCUITFindBy(accessibility = "Adjust Household Location")
    @iOSXCUITFindBy(accessibility = "Adjust household location")
    public WebElement gpsAdjustHouseholdLocationLowerCase;


    //LAT LONG MAP Stuff
    //Permission Title Allow
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/md_buttonDefaultPositive")
    @iOSXCUITFindBy(accessibility = "Allow")
    public WebElement gpsAllowOK;


    //iOS Buttons Use my location
    @iOSXCUITFindBy(accessibility = "Use my location")
    public WebElement gpsUseMyLocation;


    //iOS Buttons Use my location
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Adjust Household Location\"]")
    public WebElement gpsAdjustLocationButton;


    //GPS Search
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterEditText")
    @iOSXCUITFindBy(accessibility = "Search")
    public WebElement gpsSearch;


    //GPS Use this Location
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/useLocationFab")
    @iOSXCUITFindBy(accessibility = "Use This Location")
    public WebElement gpsUseThisLocation;



    //Errors
    //Household Location Missing
//    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/latLngTextView")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Household Location Missing']")
    @iOSXCUITFindBy(accessibility = "Household Location Missing")
    public WebElement gpsHouseholdLocationMissing;

    //Household Location Missing icon
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/warningImageView")
    @iOSXCUITFindBy(accessibility = "icn_error")
    public WebElement gpsHouseholdLocationErrorIcon;



    //GPS Adjust Location Screen
    //Adjust Location Title House Name
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']/following-sibling::android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='LDS_Tools.PinAdjustMapView']/XCUIElementTypeStaticText/XCUIElementTypeStaticText[1]")
    public WebElement gpsAdjustLocationTitleHouseName;

    //Adjust Location Title
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']/following-sibling::android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='LDS_Tools.PinAdjustMapView']/XCUIElementTypeStaticText/XCUIElementTypeStaticText[2]")
    public WebElement gpsAdjustLocationTitle;

    //Adjust Location Current Location Icon
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/myLocationFab")
    @iOSXCUITFindBy(accessibility = "icon current location")
    public WebElement gpsAdjustLocationCurrentLocation;

    //Adjust Location Current Location Info
    @iOSXCUITFindBy(accessibility = "icon info")
    public WebElement gpsAdjustLocationIconLocation;

    //Adjust Location Search
    @AndroidFindBy(id = "org.lds.ldstools.alpha:id/filterEditText")
    @iOSXCUITFindBy(accessibility = "Empty list")
    public WebElement gpsAdjustLocationSearch;

    //Adjust Location Map Pin
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View")
    @iOSXCUITFindBy(accessibility = "Map pin")
    public WebElement gpsAdjustLocationMapPin;

    //Adjust Location Legal
    @AndroidFindBy(xpath ="//android.view.View[@content-desc=\"Google Map\"]/android.widget.RelativeLayout/android.widget.ImageView")
    @iOSXCUITFindBy(accessibility = "Legal")
    public WebElement gpsAdjustLocationLegal;



    public void clickDirectoryUser(String myUser) throws Exception {
        if (getOS().equals("ios")) {
//            clickByCords(myUser);
//            System.out.println(getSourceOfPage());
//            driver.get().findElement(MobileBy.AccessibilityId(myUser)).click();
//            driver.get().findElement(By.xpath("//XCUIElementTypeButton[@name='" + myUser + "']")).click();
            driver.get().findElement(By.xpath("//XCUIElementTypeButton[contains(@name, \"" + myUser + "\")]")).click();
//            driver.get().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + myUser + "']")).click();
//            driver.get().findElement(MobileBy.AccessibilityId(myUser)).click();
//            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + myUser + "']")).click();
            //driver.findElement(By.xpath("//XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@value, '" + myUser + "')]"));
        } else {
            String appPackage = driver.get().getCapabilities().getCapability("appPackage").toString();
            System.out.println("App Package: " + appPackage);
//            System.out.println(getSourceOfPage());
//            driver.get().findElement(By.xpath("//android.widget.TextView[@resource-id='" + appPackage +":id/name'][@text='" + myUser + "']")).click();
            driver.get().findElement(By.xpath("//android.widget.TextView[@text='" + myUser + "']/../..")).click();
//            driver.findElement(By.xpath("//android.widget.TextView[@id='name'][@text='" + myUser + "']")).click();
        }
    }

    public void sortToHousehold() throws Exception {
        directorySort.click();
        sortHousehold.click();
    }

    public void searchAndClick(String myUser) throws Exception {
        BasePage myBase = new BasePage(driver);
        String tempMyUser = myUser.toLowerCase();



        if (myBase.getOS().equalsIgnoreCase("ios")) {
            myBase.waitForElementThenClick(directorySort);
            Thread.sleep(500);
            myBase.waitForElementThenClick(sortIndividual);
            myBase.waitForElement(searchBar);
        } else {
//            System.out.println(myBase.getSourceOfPage());
            myBase.waitForElementThenClick(directorySort);
            Thread.sleep(500);
            myBase.waitForElementThenClick(sortIndividual);
            myBase.waitForElement(searchBar);
        }

        if (tempMyUser.contains("tools")) {
            String[] parts = myUser.split(", ");
            String part1 = parts[0];
            String part2 = parts[1];
            searchBar.sendKeys(part2);
//            searchBar.setValue(part2);
        } else {
            Thread.sleep(4000);
            searchBar.sendKeys(myUser);
            Thread.sleep(1500);
//            searchBar.setValue(myUser);
        }
        //Just for testing
        Thread.sleep(2000);
//        System.out.println(getSourceOfPage());
        clickDirectoryUser(myUser);
        Thread.sleep(2000);

    }

    public void searchAndClickReturnedMissionary(String myUser) throws Exception {
        searchBar.sendKeys(myUser);
        Thread.sleep(4000);
//        System.out.println(getSourceOfPage());
        clickDirectoryUser(myUser);

    }

    public void searchAndClickHousehold(String myUser) throws Exception {
        String tempMyUser = myUser.toLowerCase();

        directorySort.click();
        sortHousehold.click();

        if (tempMyUser.contains("tools")) {
            String[] parts = myUser.split(", ");
            String part1 = parts[0];
            String part2 = parts[1];
            searchBar.sendKeys(part2);
        } else {
            searchBar.sendKeys(myUser);
        }
        Thread.sleep(2000);
        clickDirectoryUser(myUser);

    }

    public Boolean searchForMemberCheckResults(String myUser) throws Exception {
        String tempMyUser = myUser.toLowerCase();
        Boolean myReturnStatus;
        List<WebElement> options;

        directorySort.click();
        sortIndividual.click();
        Thread.sleep(2000);

        if (tempMyUser.contains("tools")) {
            String[] parts = myUser.split(", ");
            String part1 = parts[0];
            String part2 = parts[1];
            searchBar.sendKeys(part2);
        } else {
            searchBar.sendKeys(myUser);
        }



        if (getOS().equals("ios")) {
            options= driver.get().findElements(By.xpath("//*[@value='" + myUser + "']"));
        } else {
            options= driver.get().findElements(By.xpath("//android.widget.TextView[@text='" + myUser + "']"));
        }

        myReturnStatus = !options.isEmpty();

        return myReturnStatus;

    }


    public String getDirectoryUserData() throws Exception {
        BasePage myBasePage = new BasePage(driver);

        String pageSource = null;
        if (getOS().equals("ios")) {
            //Contact Tab
            Thread.sleep(1000);
            pageSource = pageSource + getSourceOfPage();
            swipeUpIOS();
            pageSource = pageSource + getSourceOfPage();


//            scrollDownIOS();

            Thread.sleep(1000);
            boolean checkForLabel;

            checkForLabel = checkForElement(householdMembers);
            if (checkForLabel) {
               householdMembers.click();
                pageSource = pageSource + getSourceOfPage();
                myBasePage.backButton.click();
                checkForLabel = false;
            }

            checkForLabel = checkForElement(callingsAndClasses);
            if (checkForLabel) {
                callingsAndClasses.click();
                pageSource = pageSource + getSourceOfPage();
                myBasePage.backButton.click();
                checkForLabel = false;
            }

//            scrollDownIOS();
//            System.out.println(myBasePage.getSourceOfPage());
            checkForLabel = checkForElement(memebershipInformation);
            if (checkForLabel) {
                memebershipInformation.click();
//                scrollUpIOS();
                pageSource = pageSource + getSourceOfPage();
//                scrollDownIOS();
                swipeUpIOS();
                pageSource = pageSource + getSourceOfPage();
                swipeUpIOS();
                pageSource = pageSource + getSourceOfPage();
                myBasePage.backButton.click();
                checkForLabel = false;
            }

            checkForLabel = checkForElement(htvt);
            if (checkForLabel) {
                htvt.click();
                pageSource = pageSource + getSourceOfPage();
                myBasePage.backButton.click();
                checkForLabel = false;
            }





        } else {
            boolean myCheck;

            //Contact Tab
            Thread.sleep(1000);
            pageSource = getSourceOfPage();

            for (int myCounter = 1; myCounter <= 3 ; myCounter++) {

                pageSource = pageSource + getSourceOfPage();
//                    myBasePage.newScrollDown();
                myBasePage.newScrollDownSlow();
                Thread.sleep(500);
            }

            tabHousehold.click();
            Thread.sleep(1000);
            pageSource = pageSource + getSourceOfPage();

            myCheck = checkForElement(tabCallings);
            if (myCheck) {
                tabCallings.click();
                Thread.sleep(1000);
                pageSource = pageSource + getSourceOfPage();
            }

            myCheck = checkForElement(tabMembership);
            if (myCheck) {
                //I don't know why this is here twice.
                tabMembership.click();
//                tabMembership.click();

                myBasePage.newScrollUp();
                for (int myCounter = 1; myCounter <= 8 ; myCounter++) {

                    pageSource = pageSource + getSourceOfPage();
//                    myBasePage.newScrollDown();
                    myBasePage.newScrollDownSlow();
                    Thread.sleep(500);
                }
            }


            myCheck = checkForElement(tabHTVT);
            if (myCheck) {
                tabHTVT.click();
                Thread.sleep(1000);
                pageSource = pageSource + getSourceOfPage();
            }

            myCheck = checkForElement(tabHTVT);
            if (myCheck) {
                tabHTVT.click();
                Thread.sleep(1000);
            }

            myCheck = checkForElement(tabCallings);
            if (myCheck) {
                tabCallings.click();
                Thread.sleep(1000);
            }

            myCheck = checkForElement(tabMembership);
            if (myCheck) {
                tabMembership.click();
            }

            myCheck = checkForElement(tabHousehold);
            if (myCheck) {
                tabHousehold.click();
            }

            myCheck = checkForElement(tabContact);
            if (myCheck) {
                tabContact.click();
            }

            pageSource = pageSource + getSourceOfPage();

        }

        return pageSource;

    }


    public void checkAllWardDirectories() throws Exception {
        List<String> StakeWard = new ArrayList<String>();
        List<WebElement> options;
        String myUnit;
        BasePage myBasePage = new BasePage(driver);
        
        
        int pageSize;
        int myCounter = 1;
        Thread.sleep(2000);

        if (myBasePage.getOS().equals("ios")) {
            //directoryDropdown.click();
            unitSelected.click();

            //Get Stake and all Wards
            //options= driver.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell/UIAStaticText"));
            options= driver.get().findElements(By.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText"));

            for (int i = 0 ; i < options.size(); i++ ) {
                System.out.println(options.get(i).getText());
                myUnit = options.get(i).getText();
                myUnit = myUnit.trim();
                System.out.println(myUnit);
                StakeWard.add(myUnit);
            }

            searchCancel.click();
            Thread.sleep(2000);


            //Go through each Stake and Ward to make sure it isn't blank
            for(String StakeWardItem : StakeWard){

                if (!StakeWardItem.contains("Stake")) {
                    Thread.sleep(2000);
                    //directoryDropdown.click();
                    unitSelected.click();
                    Thread.sleep(2000);
                    driver.get().findElement(By.xpath("//*[contains(@name,'" + StakeWardItem + "')]")).click();
                    //displayAllTextViewElements();
                    Thread.sleep(6000);
                    //This will check to see if the first user has text.
                    Assert.assertTrue(checkFirstDirectoryUser());
                }

                if(myCounter == 5){
                    break; // Don't like this need a better solution. 
                }

                myCounter++;
            }

        } else {
            directoryDropdown.click();

            //Get Stake and all Wards
            //options = driver.findElements(By.xpath("//*[@id='list_item']/*[@id='text1']"));
            options = driver.get().findElements(By.xpath("//android.widget.LinearLayout[@resource-id='list_item']/android.widget.TextView[@resource-id='unitNameTextView']"));
            //options = driver.findElements(By.xpath("//android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView"));
            for (int i = 0 ; i < options.size(); i++ ) {
                System.out.println(options.get(i).getText());
                StakeWard.add(options.get(i).getText());
            }
            Thread.sleep(1000);
            directoryDropdown.click();

            //Thread.sleep(1000);
            //pressBackKey();
            Thread.sleep(1000);

            //Go through each Stake and Ward to make sure it isn't blank
            for(String StakeWardItem : StakeWard){

                if (!StakeWardItem.contains("Stake")) {
                    directoryDropdown.click();

                    Thread.sleep(2000);
                    driver.get().findElement(By.xpath("//*[@text='" + StakeWardItem + "']")).click();

                    Assert.assertTrue(checkFirstDirectoryUser());
                }

            }


        }

    }


    public Boolean checkFirstDirectoryUser() throws Exception{
        Boolean myReturnStatus;
        String myString;

        BasePage myBasePage = new BasePage(driver);

        Thread.sleep(6000);

        //String myString = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]")).getText();
        if (myBasePage.getOS().equals("ios")) {
            //myString = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")).getText();
            myString = driver.get().findElement(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")).getText();
            //XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]
        } else {
            //myString = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='text1'][1]")).getText();
            myString = driver.get().findElement(By.xpath("//*[@resource-id='recycler_view']/android.widget.FrameLayout/android.widget.TextView[@resource-id='name']")).getText();
        }



        if (myString.isEmpty()) {
            myReturnStatus = false;
        } else {
            myReturnStatus = true;
            //System.out.println("FOUND USER: " + myString);
        }

        return myReturnStatus;
    }



    public void chooseUnit(String myUnit) throws Exception {
        BasePage myBase = new BasePage(driver);
        MissionaryScreen myMissionary = new MissionaryScreen(driver);

        //Choose different Unit
        Thread.sleep(2000);
        unitSelected.click();
        Thread.sleep(2000);
        if (myBase.getOS().equalsIgnoreCase("ios")) {
            driver.get().findElement(By.xpath("//*[contains(@name,'" + myUnit + "')]")).click();
        } else {
            myBase.newScrollUpUnitList();
            Thread.sleep(500);
//            System.out.println(myBase.getSourceOfPage());
            driver.get().findElement(By.xpath("//*[contains(@text,'" + myUnit + "')]/../..")).click();
        }

    }





}
