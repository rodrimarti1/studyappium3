package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppium.Screen.TemplesScreen;
import LDSToolsAppiumTest.HelperMethods;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ClassAndQuorum extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ReportsScreen myReports = new ReportsScreen(driver);
    DirectoryScreen myDirectory = new DirectoryScreen(driver);
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> memberList = new ArrayList<String>();
    List<String> visibleDates = new ArrayList<String>();
    String pageSource;

    @Given("a {string} logs in and is on the Class and Quorum Attendance page")
    public void aLeaderLogsInAndIsOnTheClassAndQuorumAttendancePage(String memberCalling) throws Exception {
        LOGGER.info("a " + memberCalling + " logs in and is on the Class and Quorum Attendance page");
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
        myBasePage.waitForElementThenClick(myReports.classAndQuorumAttendanceReport);
    }

    @When("a {string} is searched for")
    public void aMemberRecordIsSearchedFor(String memberRecord) throws Exception {
        LOGGER.info("a " + memberRecord + " is searched for");
        searchClassAndQuorum(memberRecord);
    }


    @Then("the class and quorum attendance {string} will be displayed")
    public void theRecordWillBeDisplayed(String memberRecord) throws Exception {
        LOGGER.info("the record will be displayed");
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(myBasePage.checkNoCaseList(memberRecord, pageSource, "Contains"));
    }


    @And("the attendance {string} be edited")
    public void theAttendanceCanBeEdited(String editRights) throws Exception{
        LOGGER.info("the attendance " + editRights + " be edited");
        System.out.println("Not sure if needed?");
    }


    @Given("a {string} account checks the Class and Quorum Attendance for the API")
    public void aLeaderAccountChecksTheClassAndQuorumAttendanceForTheAPI(String memberCalling) throws Exception {
        LOGGER.info("a " + memberCalling + " account checks the Class and Quorum Attendance for the API");
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        memberList = apiTest.getClassAndQuorumRights(callingRights[1], "21628");
    }


    @Then("the editable field is {string}")
    public void theEditableFieldIsStatus(String status) {
        LOGGER.info("the editable field is " + status);
        for (String memberStatus : memberList) {
            System.out.println("Member Status: " + memberStatus + " Should be: " + status);
            Assert.assertTrue(memberStatus.equalsIgnoreCase(status));
        }
    }

    @Given("a member of the bishopric logs in and is on the Class and Quorum Attendance page")
    public void aMemberOfTheBishopricLogsInAndIsOnTheClassAndQuorumAttendancePage() throws Exception {
        LOGGER.info("a member of the bishopric logs in and is on the Class and Quorum Attendance page");
        visibleDates.clear();
        String[] callingRights;
        callingRights = myHelper.getMemberNameFromList("BISHOP", "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
        myBasePage.waitForElementThenClick(myReports.classAndQuorumAttendanceReport);
    }

    @When("week one is marked attended")
    public void weekOneIsMarkedAttended() throws Exception {
        LOGGER.info("week one is marked attended");
        Thread.sleep(1000);
        clearAllAttendance("Anderson, Lisa");
        Thread.sleep(1000);
        searchClassAndQuorum("Anderson, Lisa");
        Thread.sleep(500);
        getWeekElement("week1", "main").click();
    }


    @Then("week one will have a check mark")
    public void weekOneWillHaveACheckMark() throws Exception {
        LOGGER.info("week one will have a check mark");
        myBasePage.backButton.click();
        myBasePage.waitForElementThenClick(myReports.classAndQuorumAttendanceReport);
        searchClassAndQuorum("Anderson, Lisa");
        Assert.assertTrue(getWeekAttendanceStatus("week1", "main").equalsIgnoreCase("attended"));
        //Clean Up
        Thread.sleep(500);
        getWeekElement("week1", "main").click();
        myBasePage.backButton.click();
    }


    @When("filters is selected")
    public void filtersIsSelected() throws Exception {
        LOGGER.info("filters is selected");
        myReports.classAndQuorumFilter.click();
    }

    @Then("a list of classes will be displayed")
    public void aListOfClassesWillBeDisplayed() throws Exception {
        LOGGER.info("a list of classes will be displayed");
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Aaronic Priesthood"));
        Assert.assertTrue(pageSource.contains("Elders Quorum"));
        Assert.assertTrue(pageSource.contains("Primary"));
        Assert.assertTrue(pageSource.contains("Relief Society"));
        Assert.assertTrue(pageSource.contains("Sunday School"));
        Assert.assertTrue(pageSource.contains("Young Women"));
    }

    @When("I select a class")
    public void iSelectAClass() throws Exception {
        LOGGER.info("I select a class");
        myBasePage.waitForElementThenClick(myReports.classAndQuorumFilterAaronic);
        myBasePage.waitForElementThenClick(myReports.classAndQuorumFilterDeaconsQuorum);
    }

    @Then("The class list will be displayed")
    public void theClassListWillBeDisplayed() throws Exception {
        LOGGER.info("The class list will be displayed");
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains("Andrews"));
        Assert.assertTrue(pageSource.contains("Male"));
        Assert.assertTrue(pageSource.contains("Deacons"));
    }

    @When("a member record is selected")
    public void aMemberRecordIsSelected() throws Exception{
        LOGGER.info("a member record is selected");
        clearAllAttendance("Rickett, Dylan");
        searchClassAndQuorum("Rickett, Dylan");
        Thread.sleep(500);
        getWeekElement("week1", "main").click();
        Thread.sleep(500);
//        System.out.println(myBasePage.getSourceOfPage());
        getWeekElement("week3", "main").click();
        Thread.sleep(500);
        myBasePage.backButton.click();
        myBasePage.waitForElementThenClick(myReports.classAndQuorumAttendanceReport);
        searchClassAndQuorum("Rickett, Dylan");
        Thread.sleep(500);
        clickMemberRecord("Rickett, Dylan");
        Thread.sleep(1000);
    }

    @Then("the individual attendance should be displayed")
    public void theIndividualAttendanceShouldBeDisplayed() throws Exception {
        LOGGER.info("the individual attendance should be displayed");
        Assert.assertTrue(getWeekAttendanceStatus("week1", "detail").equalsIgnoreCase("attended"));
        Assert.assertTrue(getWeekAttendanceStatus("week2", "detail").equalsIgnoreCase("not attended"));
        Assert.assertTrue(getWeekAttendanceStatus("week3", "detail").equalsIgnoreCase("attended"));
        Assert.assertTrue(getWeekAttendanceStatus("week4", "detail").equalsIgnoreCase("not attended"));
        //Clean Up
        Thread.sleep(500);
        getWeekElement("week1", "detail").click();
        Thread.sleep(500);
        getWeekElement("week3", "detail").click();
        Thread.sleep(500);
        myBasePage.backButton.click();
        Thread.sleep(1000);
        myBasePage.backButton.click();
    }


    @Then("the {string} member {string} either {string} or will not be displayed")
    public void theClassAndQuorumMemberMemberRecordEitherWillOrWillNotBeDisplayed(String classAndQuorum, String memberRecord, String will) throws Exception {
        LOGGER.info("the " + classAndQuorum + " member " + memberRecord + " either " + will + " or will not be displayed");
        pageSource = myBasePage.getSourceOfPage();
        if (will.equalsIgnoreCase("true")) {
            Assert.assertTrue(myBasePage.checkNoCaseList(memberRecord, pageSource, "Contains"));
        } else {
            Assert.assertFalse(myBasePage.checkNoCaseList(memberRecord, pageSource, "Contains"));
        }
    }

    @Then("the member {string} will {string} be displayed")
    public void theMemberMemberRecordElderWillWillElderBeDisplayed(String memberRecordElder, String willElder) throws Exception{
        LOGGER.info("the member " + memberRecordElder + " will " + willElder + " be displayed");
        checkIfMemberIsDisplayed(memberRecordElder, willElder);
    }


    public void checkIfMemberIsDisplayed(String memberRecord, String status) throws Exception {
        String foundName = null;
        MobileElement elementToCheck;
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
//            elementToCheck = (MobileElement) driver.get().findElement(By.name(memberRecord));
            if(!driver.get().findElements(By.name(memberRecord)).isEmpty()) {
                foundName = driver.get().findElement(By.name(memberRecord)).getAttribute("value");
            } else {
                foundName = "NOT FOUND!";
            }
        } else {
//            elementToCheck = (MobileElement) driver.get().findElement(By.id("org.lds.ldstools.alpha:id/nameTextView"));
            Thread.sleep(1000);
            if(!driver.get().findElements(By.id("org.lds.ldstools.alpha:id/nameTextView")).isEmpty()) {
                Thread.sleep(1000);
                foundName = driver.get().findElement(By.id("org.lds.ldstools.alpha:id/nameTextView")).getAttribute("text");
            } else {
                foundName = "NOT FOUND!";
            }
        }
        foundName = foundName.trim();

        System.out.println("Member Record: " + memberRecord);
        System.out.println("Found Name: "  + foundName);

        if (status.equalsIgnoreCase("true")) {
            Assert.assertTrue(memberRecord.equalsIgnoreCase(foundName));
//            Assert.assertTrue(myBasePage.checkNoCaseList(memberRecord, foundName, "Contains"));
        } else {
            Assert.assertFalse(memberRecord.equalsIgnoreCase(foundName));
//            Assert.assertFalse(myBasePage.checkNoCaseList(memberRecord, foundName, "Contains"));
        }
        myReports.classAndQuorumClearSearch.click();
        Thread.sleep(500);
    }


    public void clickMemberRecord(String myText) throws Exception {
        //Bug in iOS
        if(myBasePage.getOS().equals("ios")) {
//            System.out.println(myBasePage.getSourceOfPage());
//            Thread.sleep(2000);
            driver.get().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + myText + "']")).click();
//            driver.get().findElement(By.name("chevron")).click();
        } else {
            driver.get().findElement(By.xpath("//android.widget.TextView[@text='" + myText + "']")).click();
        }
    }


    public void clearAllAttendance(String memberRecord) throws Exception {
        searchClassAndQuorum(memberRecord);
        visibleDates = getVisibleDates();
        if (getWeekAttendanceStatus("week1", "main").equalsIgnoreCase("attended")) {
            getWeekElement("week1", "main").click();
            Thread.sleep(2000);
        }

        if (getWeekAttendanceStatus("week2", "main").equalsIgnoreCase("attended")) {
            getWeekElement("week2", "main").click();
            Thread.sleep(2000);
        }

        if (getWeekAttendanceStatus("week3", "main").equalsIgnoreCase("attended")) {
            getWeekElement("week3", "main").click();
            Thread.sleep(2000);
        }

        if (getWeekAttendanceStatus("week4", "main").equalsIgnoreCase("attended")) {
            getWeekElement("week4", "main").click();
            Thread.sleep(2000);
        }


        myBasePage.backButton.click();
        myBasePage.waitForElementThenClick(myReports.classAndQuorumAttendanceReport);
    }

    public List<String> getVisibleDates() throws Exception {
        String tempDate;
        String shortDate;
        String attendedStatus;
        String[] dateArray = new String[0];
        if (visibleDates.isEmpty()) {
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                for (int x = 2; x <= 5; x++) {
//                    Thread.sleep(2000);
//                    System.out.println(myBasePage.getSourceOfPage());
                    tempDate = (driver.get().findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[" + x + "]")).getAttribute("value"));
//                    System.out.println("TEMP DATE: "  + tempDate);
//                    System.out.println(myBasePage.getSourceOfPage());
                    dateArray = tempDate.split(":");
                    shortDate = dateArray[0];
                    attendedStatus = dateArray[1];
                    visibleDates.add(shortDate);
                }
            } else {
                for (int y = 1; y <= 5 ; y++) {
                    visibleDates.add(driver.get().findElement(By.xpath("//android.widget.FrameLayout[contains(@resource-id, 'week" + y + "')]//android.widget.TextView")).getAttribute("text"));
                }
            }

            for (String dateToDisplay : visibleDates) {
                System.out.println("DATE: " + dateToDisplay);
            }
        }

        return visibleDates;
    }

    public String getWeekAttendanceStatus(String weekName, String pageType) throws Exception {
        String returnStatus = null;
        MobileElement weekCheckBox;

        System.out.println("Week: " + weekName);
        System.out.println("Page Type: " + pageType);
        weekCheckBox = getWeekElement(weekName, pageType);
        if (myBasePage.getOS().contains("ios")) {
            returnStatus = weekCheckBox.getAttribute("name");
            if (returnStatus.contains("not")) {
                returnStatus = "not attended";
            } else {
                returnStatus = "attended";
            }
        } else {
            returnStatus = weekCheckBox.getAttribute("selected");
            System.out.println("Return Status: " + returnStatus);
            if (returnStatus.equalsIgnoreCase("false")) {
                returnStatus = "not attended";
            } else {
                returnStatus = "attended";
            }
        }

        return returnStatus;
    }

    public MobileElement getWeekElement(String weekName, String pageType) throws Exception{
        MobileElement returnElement = null;
        List<String> dateToCheck;
        String numberOnly;
        dateToCheck = getVisibleDates();
        switch(weekName) {
            case "week1":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeStaticText[contains(@name, '" + dateToCheck.get(0) +"')]"));
                } else {
                    if (pageType.equalsIgnoreCase("main")) {
                        returnElement = myReports.classAndQuorumFirstWeek;
                    } else {
                        System.out.println("Detail check for week 1");
                        numberOnly = dateToCheck.get(0).replaceAll("[^0-9]", "");
                        System.out.println("Number Only: " + numberOnly);
                        returnElement = (MobileElement) driver.get().findElement(By.xpath(
                                "//android.widget.TextView[@text = '" + numberOnly +"']"));
                    }

                }
                break;
            case "week2":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeStaticText[contains(@name, '" + dateToCheck.get(1) +"')]"));
                } else {
                    if (pageType.equalsIgnoreCase("main")) {
                        returnElement = myReports.classAndQuorumSecondWeek;
                    } else {
                        System.out.println("Detail check for week 2");
                        numberOnly = dateToCheck.get(1).replaceAll("[^0-9]", "");
                        System.out.println("Number Only: " + numberOnly);
                        returnElement = (MobileElement) driver.get().findElement(By.xpath(
                                "//android.widget.TextView[@text = '" + numberOnly +"']"));
                    }

                }

                break;
            case "week3":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeStaticText[contains(@name, '" + dateToCheck.get(2) +"')]"));
                } else {
                    if (pageType.equalsIgnoreCase("main")) {
                        returnElement = myReports.classAndQuorumThirdWeek;
                    } else {
                        numberOnly = dateToCheck.get(2).replaceAll("[^0-9]", "");
                        returnElement = (MobileElement) driver.get().findElement(By.xpath(
                                "//android.widget.TextView[@text = '" + numberOnly +"']"));
                    }

                }

                break;
            case "week4":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeStaticText[contains(@name, '" + dateToCheck.get(3) +"')]"));
                } else {
                    if (pageType.equalsIgnoreCase("main")) {
                        returnElement = myReports.classAndQuorumFourthWeek;
                    } else {
                        numberOnly = dateToCheck.get(3).replaceAll("[^0-9]", "");
                        returnElement = (MobileElement) driver.get().findElement(By.xpath(
                                "//android.widget.TextView[@text = '" + numberOnly +"']"));
                    }

                }

                break;

            case "week5":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (MobileElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeStaticText[contains(@name, '" + dateToCheck.get(4) +"')]"));
                } else {
                    if (pageType.equalsIgnoreCase("main")) {
                        returnElement = myReports.classAndQuorumFifthWeek;
                    } else {
                        numberOnly = dateToCheck.get(4).replaceAll("[^0-9]", "");
                        returnElement = (MobileElement) driver.get().findElement(By.xpath(
                                "//android.widget.TextView[@text = '" + numberOnly +"']"));
                    }

                }

                break;
            default:
                System.out.println("Element not found!");
        }
        return returnElement;
    }



    public void searchClassAndQuorum(String memberToSearch) throws Exception {
        myReports.classAndQuorumSearch.setValue(memberToSearch);
        //Done button?
    }

    public MobileElement getVisitorField(String category, String weekNumber) throws Exception{
        MobileElement myElement = null;
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            category = category.toUpperCase();
            myElement = (MobileElement) driver.get().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + category + "']/following-sibling::XCUIElementTypeTextField[" + weekNumber + "]"));
        } else {
//            System.out.println(myBasePage.getSourceOfPage());
            myElement = (MobileElement) driver.get().findElement(By.xpath("//*[@text='" + category + "']/following-sibling::android.widget.EditText[" + weekNumber + "]"));
        }

        return  myElement;
    }

    @Given("a {string} logs in and is on the Class and Quorum Attendance visitors page")
    public void aLogsInAndIsOnTheClassAndQuorumAttendanceVisitorsPage(String memberCalling) throws Exception {
        LOGGER.info("a " + memberCalling + " logs in and is on the Class and Quorum Attendance visitors page");
        String[] callingRights;
//        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Maplewood 2nd");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
        myBasePage.waitForElementThenClick(myReports.classAndQuorumAttendanceReport);
//        System.out.println(myBasePage.getSourceOfPage());
        myBasePage.waitForElementThenClick(myReports.classAndQuorumVisitors);
        clearVisitor(memberCalling);
    }


    @When("{string} is entered in the {string} in the {string} field")
    public void visitorIsEnteredInTheClassInTheWeekNumberField(String visitorNumber, String visitorClass, String weekNumber) throws Exception {
        LOGGER.info(visitorNumber + " is entered in the " + visitorClass + " in the " + weekNumber + " field");
        MobileElement myElement = null;
        if (visitorClass.equalsIgnoreCase("men") || (visitorClass.equalsIgnoreCase("women") || (visitorClass.equalsIgnoreCase("young men")))) {
            if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                myBasePage.scrollDownIOS();
            } else {
                myBasePage.scrollDownAndroidUIAutomator("0");
            }
            Thread.sleep(2000);
        } else {
            Thread.sleep(2000);
        }
        myElement = getVisitorField(visitorClass, weekNumber);
        myElement.clear();
        myElement.setValue(visitorNumber);

    }

    @Then("{string} will be saved in the {string} {string} field attendance")
    public void visitorWillBeSavedInTheClassWeekNumberFieldAttendance(String visitorNumber, String visitorClass, String weekNumber) throws Exception {
        LOGGER.info(visitorNumber + " will be saved in the " +visitorClass + " " +  weekNumber + " field attendance");
        MobileElement myElement = null;
        String foundText;
        myBasePage.waitForElementThenClick(myReports.classAndQuorumVisitors);
        if (visitorClass.equalsIgnoreCase("men") || (visitorClass.equalsIgnoreCase("women") || (visitorClass.equalsIgnoreCase("young men")))) {
            myBasePage.scrollDownAndroidUIAutomator("0");
            Thread.sleep(1000);
        }
        myElement = getVisitorField(visitorClass, weekNumber);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            foundText = myElement.getAttribute("value");
        } else {
            foundText = myElement.getAttribute("text");
        }
        Assert.assertEquals(foundText, visitorNumber);

    }

    @Then("the visitor {string} will be displayed")
    public void theVisitorClassWillBeDisplayed(String visitorClass )  throws Exception {
        LOGGER.info("the visitor " + visitorClass + " will be displayed");
        String pageSource;
        List<String> classList;
        pageSource = myBasePage.getSourceOfPage();
        visitorClass = visitorClass.toLowerCase();
        pageSource = visitorClass.toLowerCase();
        if (visitorClass.contains(",")) {
            myBasePage.scrollDownAndroidUIAutomator("0");
            pageSource = pageSource + myBasePage.getSourceOfPage();
            classList = getVisitorListFromString(visitorClass);
            for (String oneClass: classList) {
                Assert.assertTrue(pageSource.contains(oneClass));
            }
        } else {
            Assert.assertTrue(pageSource.contains(visitorClass));
        }

    }

    @And("the visitor {string} will not be displayed")
    public void theVisitorNoClassWillNotBeDisplayed(String noClass) throws Exception {
        LOGGER.info("the visitor " + noClass + " will not be displayed");
        String pageSource;
        List<String> noClassList;
        pageSource = myBasePage.getSourceOfPage();
        noClass = noClass.toLowerCase();
        pageSource = pageSource.toLowerCase();
        if (noClass.equalsIgnoreCase("none")) {
            System.out.println("Nothing to do here");
        } else {
            noClassList = getVisitorListFromString(noClass);
            for (String oneClass: noClassList) {
                Assert.assertFalse(pageSource.contains(oneClass));
            }
        }

    }

    public List<String> getVisitorListFromString(String visitorClass) throws Exception {
        String[] myArray = visitorClass.split(",");
        List<String> myList = Arrays.asList(myArray);
        return myList;
    }

    public void clearVisitor(String memberCalling) throws Exception {
        List<String> visitorClass = new ArrayList<>();
        if (memberCalling.contains("ELDERS")) {
            visitorClass.add("Men");
        }

        if (memberCalling.contains("RELIEF")) {
            visitorClass.add("Women");
        }

        if (memberCalling.contains("YOUNG_WOMEN")) {
            visitorClass.add("Young Women");
        }

        if (memberCalling.contains("YOUNG_MEN")) {
            visitorClass.add("Young Men");
        }

        if (memberCalling.contains("PRIMARY")) {
            visitorClass.add("Children");
        }

        if (memberCalling.contains("SUNDAY")) {
            visitorClass.add("Young Women");
            visitorClass.add("Young Men");
            visitorClass.add("Women");
            visitorClass.add("Men");
        }

        if (memberCalling.contains("BISHOP")) {
            visitorClass.add("Children");
            visitorClass.add("Young Women");
            visitorClass.add("Young Men");
            visitorClass.add("Women");
            visitorClass.add("Men");
        }



        MobileElement myElement = null;
        String weekNumber;

        Thread.sleep(2000);

        for (String myClass: visitorClass) {
            if (myClass.equalsIgnoreCase("men") || (myClass.equalsIgnoreCase("women") || (myClass.equalsIgnoreCase("young men")))) {
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    myBasePage.scrollDownIOS();
                } else {
                    myBasePage.scrollDownAndroidUIAutomator("0");
                }
                Thread.sleep(1000);
            }
            for (int myCounter = 1; myCounter < 6; myCounter++ ) {
                weekNumber = String.valueOf(myCounter);
                myElement = getVisitorField(myClass,weekNumber);
                myElement.clear();
                myElement.setValue("0");
            }
        }
        myBasePage.waitForElementThenClick(myReports.classAndQuorumVisitorsDone);
        myBasePage.waitForElementThenClick(myReports.classAndQuorumVisitors);

    }


    @And("the done button is pressed")
    public void theDoneButtonIsPressed() throws Exception {
        LOGGER.info("the done button is pressed");
        myBasePage.waitForElementThenClick(myReports.classAndQuorumVisitorsDone);
    }

    @And("the cancel button is pressed")
    public void theCancelButtonIsPressed() throws Exception {
        LOGGER.info("the cancel button is pressed");
        myBasePage.waitForElementThenClick(myReports.classAndQuorumVisitorsCancel);
    }
}
