package LDSToolsAppiumTest.steps;

import LDSToolsAppium.BaseDriver;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppiumTest.HelperMethods;


import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class SacramentAttendance extends BaseDriver {
    BasePage myBasePage = new BasePage(driver);
    HelperMethods myHelper = new HelperMethods();
    MenuScreen myMenu = new MenuScreen(driver);
    ReportsScreen myReports = new ReportsScreen(driver);
    String pageSource;



    @Given("a {string} is on the Sacrament Attendance page")
    public void aMemberIsOnTheSacramentAttendancePage(String memberCalling) throws Exception {
        LOGGER.info("a " + memberCalling + " is on the Sacrament Attendance page");
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
        if (!myBasePage.checkForElement(myReports.sacramentAttendanceReport)) {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }
        myBasePage.waitForElementThenClick(myReports.sacramentAttendanceReport);
        cleanup();
        myBasePage.waitForElementThenClick(myReports.sacramentAttendanceReport);
    }

    @When("{string} is entered in the {string}")
    public void isEnteredInThe(String valueToEnter, String fieldToEnter) throws Exception  {
        LOGGER.info(valueToEnter + " is entered in the " + fieldToEnter);
        WebElement sacToEnter;
        //Need to scroll down or iOS cannot see the elements.
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.scrollDownIOS();
//            System.out.println(myBasePage.getSourceOfPage());
            myBasePage.scrollUpIOS();
        }
        Thread.sleep(2000);
        clickElement(fieldToEnter);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            sacToEnter = getSunday(fieldToEnter);
            sacToEnter.clear();
            sacToEnter.sendKeys(valueToEnter);
            myBasePage.keyboardReturn.click();
        } else {
            Thread.sleep(2000);
//            System.out.println(myBasePage.getSourceOfPage());
            myReports.sacramentAttendanceDialogEditField.sendKeys(valueToEnter);
            myReports.sacramentAttendanceDialogOk.click();
            Thread.sleep(2000);
        }
        iShouldSee(valueToEnter);
        myBasePage.backButton.click();
//        System.out.println(myBasePage.getSourceOfPage());
        Thread.sleep(500);
        if (!myBasePage.checkForElement(myReports.sacramentAttendanceReport)) {
            myBasePage.scrollDownAndroidUIAutomator("0");
        }
        myBasePage.waitForElement(myReports.sacramentAttendanceReport);
        myReports.sacramentAttendanceReport.click();
        Thread.sleep(5000);
    }

    @Then("I should see {string}")
    public void iShouldSee(String searchItem) throws Exception {
        LOGGER.info("I should see " + searchItem);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertTrue(pageSource.contains(searchItem));
    }

    @Then("I should see {string} in the {string}")
    public void iShouldSeeInThe(String textToCheck, String fieldToCheck) throws Exception {
        LOGGER.info("I should see " + textToCheck + " in the " + fieldToCheck);
        Thread.sleep(2000);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.scrollDownIOS();
            myBasePage.scrollUpIOS();
        }
        String textFromElement = getTextFromElement(fieldToCheck);
        Assert.assertTrue(textToCheck.contains(textFromElement));
    }

    @Given("a {string} is on the Reports page")
    public void aIsOnTheReportsPage(String memberCalling) throws Exception {
        LOGGER.info("a " + memberCalling + " is on the Reports page");
        String[] callingRights;
        HelperMethods myHelper = new HelperMethods();
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        myHelper.proxyLogin(callingRights[1]);
        myHelper.enterPin("1", "1", "3", "3");
        myMenu.selectMenu(myMenu.reports);
    }

    @Then("I should not see {string}")
    public void iShouldNotSee(String searchItem) throws Exception {
        LOGGER.info("I should not see " + searchItem);
        pageSource = myBasePage.getSourceOfPage();
        Assert.assertFalse(pageSource.contains(searchItem));
    }


    @When("a {string} is entered using the counter")
    public void aIsEnteredUsingTheCounter(String counterNumber) throws Exception {
        LOGGER.info("a " + counterNumber + " is entered using the counter");
        WebElement sacToEnter;
        int counterTotal;
        counterTotal = Integer.parseInt(counterNumber);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.scrollDownIOS();
            Thread.sleep(500);
            myBasePage.scrollUpIOS();
            Thread.sleep(2000);
            clickElement("First Date Field");
            sacToEnter = getSunday("First Date Field");
            sacToEnter.clear();
//            Thread.sleep(2000);
            sacToEnter.sendKeys("0");
            myBasePage.waitForElement(myReports.sacramentAttendanceCounterIcon);
//            myBasePage.keyboardReturn.click();
//            Thread.sleep(2000);
        }
//        System.out.println(myBasePage.getSourceOfPage());
        myReports.sacramentAttendanceCounterIcon.click();
        counterPressAdd(counterTotal);
        iShouldSee(counterNumber);
        myReports.sacramentAttendanceCounterSave.click();
        Thread.sleep(2000);
    }

    @When("a {string} is entered using the counter without saving")
    public void aIsEnteredUsingTheCounterWithoutSaving(String counterNumber) throws Exception{
        LOGGER.info("a " + counterNumber + " is entered using the counter without saving");
        WebElement sacToEnter;
        int counterTotal;
        counterTotal = Integer.parseInt(counterNumber);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myBasePage.scrollDownIOS();
            Thread.sleep(500);
            myBasePage.scrollUpIOS();
            Thread.sleep(2000);
            clickElement("First Date Field");
            sacToEnter = getSunday("First Date Field");
            sacToEnter.clear();
//            Thread.sleep(2000);
            sacToEnter.sendKeys("0");
            myBasePage.waitForElement(myReports.sacramentAttendanceCounterIcon);
//            myBasePage.keyboardReturn.click();
//            Thread.sleep(2000);
        }
        myReports.sacramentAttendanceCounterIcon.click();
        counterPressAdd(counterTotal);
    }

    @And("a {string} is entered in using the minus counter")
    public void aIsEnteredInUsingTheMinusCounter(String counterNumber) throws Exception{
        LOGGER.info("a " + counterNumber + " is entered in using the minus counter");
        int counterTotal;
        counterTotal = Integer.parseInt(counterNumber);
//        myReports.sacramentAttendanceCounterIcon.click();
        counterPressMinus(counterTotal);
        iShouldSee(counterNumber);
        myReports.sacramentAttendanceCounterSave.click();
        Thread.sleep(2000);
    }

    @When("a {int} {int} {int} {int} is entered using the counter and next section")
    public void aIsEnteredUsingTheCounterAndNextSection(int firstNumber, int secondNumber, int thirdNumber, int fourthNumber) throws Exception {
        LOGGER.info("a " + firstNumber + secondNumber + thirdNumber + fourthNumber + " is entered using the counter and next section");
        Thread.sleep(2000);
        myReports.sacramentAttendanceCounterIcon.click();
        counterPressAdd(firstNumber);
        myReports.sacramentAttendanceCounterNextSection.click();
        counterPressAdd(secondNumber);
        myReports.sacramentAttendanceCounterNextSection.click();
        counterPressAdd(thirdNumber);
        myReports.sacramentAttendanceCounterNextSection.click();
        counterPressAdd(fourthNumber);
        myReports.sacramentAttendanceCounterNextSection.click();
        myReports.sacramentAttendanceCounterSave.click();
    }

    public void counterPressAdd(int myCounter) throws Exception {
        for (int x = 1; x <= myCounter; x++) {
            myReports.sacramentAttendanceAddButton.click();
        }
    }

    public void counterPressMinus(int myCounter) throws Exception {
        for (int x = 1; x <= myCounter; x++) {
//            System.out.println(myBasePage.getSourceOfPage());
            myReports.sacramentAttendanceMinusButton.click();
        }
    }

    public void clickElement(String elementName) throws Exception {
        WebElement myElement = null;
        myElement = getSunday(elementName);
        myElement.click();
    }

    public String getTextFromElement(String elementName) throws Exception {
        String myText = null;
        WebElement myElement = null;
        myElement = getSunday(elementName);
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
            myText = myElement.getAttribute("value");
        } else {
            myText = myElement.getAttribute("Text");
        }

//        switch(elementName) {
//            case "First Date Field":
//                myText = myReports.sacramentAttendanceFirstWeek.getAttribute("Text");
//                break;
//            case "Second Date Field":
//                myText = myReports.sacramentAttendanceSecondWeek.getAttribute("Text");
//                break;
//            case "Third Date Field":
//                myText = myReports.sacramentAttendanceThirdWeek.getAttribute("Text");
//                break;
//            case "Fourth Date Field":
//                myText = myReports.sacramentAttendanceFourthWeek.getAttribute("Text");
//                break;
//            default:
//                System.out.println("Element not found!");
//        }

        return myText;
    }

    public WebElement getSunday(String elementName) throws Exception {
        WebElement returnElement = null;
        List<String> sundayNumber = getSundaysInCurrentMonth();
        switch(elementName) {
            case "First Date Field":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
//                    System.out.println(myBasePage.getSourceOfPage());
                    returnElement = (WebElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeTable/XCUIElementTypeCell[4]//XCUIElementTypeTextField[@name='" + sundayNumber.get(0) + "']"));
                } else {
                    returnElement = myReports.sacramentAttendanceFirstWeek;
                }
                break;
            case "Second Date Field":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (WebElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeTable/XCUIElementTypeCell[4]//XCUIElementTypeTextField[@name='" + sundayNumber.get(1) + "']"));
                } else {
                    returnElement = myReports.sacramentAttendanceSecondWeek;
                }

                break;
            case "Third Date Field":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (WebElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeTable/XCUIElementTypeCell[4]//XCUIElementTypeTextField[@name='" + sundayNumber.get(2) + "']"));
                } else {
                    returnElement = myReports.sacramentAttendanceThirdWeek;
                }

                break;
            case "Fourth Date Field":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (WebElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeTable/XCUIElementTypeCell[4]//XCUIElementTypeTextField[@name='" + sundayNumber.get(3) + "']"));
                } else {
                    returnElement = myReports.sacramentAttendanceFourthWeek;
                }

                break;

            case "Fifth Date Field":
                if (myBasePage.getOS().equalsIgnoreCase("ios")) {
                    returnElement = (WebElement) driver.get().findElement(By.xpath(
                            "//XCUIElementTypeTable/XCUIElementTypeCell[4]//XCUIElementTypeTextField[@name='" + sundayNumber.get(4) + "']"));
                } else {
                    returnElement = myReports.sacramentAttendanceFifthWeek;
                }

                break;
            default:
                System.out.println("Element not found!");
        }

        return returnElement;
    }

    public List<String> getSundaysInCurrentMonth() {
        List<Date> disable = new ArrayList<>();
        List<String> sundayNumber = new ArrayList<>();
        String myDay;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int month = cal.get(Calendar.MONTH);
        do {
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SUNDAY)
                disable.add(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 1);
        } while (cal.get(Calendar.MONTH) == month);

        SimpleDateFormat fmt = new SimpleDateFormat("EEE M/d/yyyy");
        SimpleDateFormat justDay = new SimpleDateFormat("d");
        for (Date date : disable) {
//            System.out.println(fmt.format(date));
//            fmt.format(date).toString();
//            System.out.println(justDay.format(date));
            myDay = justDay.format(date);
//            System.out.println("Day: " + myDay);
            sundayNumber.add(myDay);
        }

        return sundayNumber;

    }

    public void sacramentAttendanceCleanUp() throws Exception {
        WebElement myElement;
        List<String> fieldName = new ArrayList<>();
        fieldName.add("First Date Field");
        fieldName.add("Second Date Field");
        fieldName.add("Third Date Field");
        fieldName.add("Fourth Date Field");
        fieldName.add("Fifth Date Field");



        //Skipping ios for now
        if (myBasePage.getOS().equalsIgnoreCase("ios")) {
//            myBasePage.backButton.click();
//            myMenu.selectMenu(myMenu.lists);
//            myMenu.selectMenu(myMenu.reports);
//            myReports.sacramentAttendanceReport.click();
//            myBasePage.scrollDownIOS();
//
//            for (String dayToClear : fieldName) {
//                myElement = getSunday(dayToClear);
//                if(checkForEnabled(myElement).equalsIgnoreCase("true")) {
//                    myElement.click();
//                    Thread.sleep(2000);
//                    myElement.click();
//                    myElement.clear();
//                    myElement.sendKeys("0");
//                    myBasePage.keyboardReturn.click();
//                }
//            }

        } else {
            if (checkForEnabled(myReports.sacramentAttendanceFirstWeek).equalsIgnoreCase("true")) {
                myReports.sacramentAttendanceFirstWeek.click();
                myReports.sacramentAttendanceDialogEditField.sendKeys("0");
                myReports.sacramentAttendanceDialogOk.click();
            }
            if (checkForEnabled(myReports.sacramentAttendanceSecondWeek).equalsIgnoreCase("true")) {
                myReports.sacramentAttendanceSecondWeek.click();
                myReports.sacramentAttendanceDialogEditField.sendKeys("0");
                myReports.sacramentAttendanceDialogOk.click();
            }
            if (checkForEnabled(myReports.sacramentAttendanceThirdWeek).equalsIgnoreCase("true")) {
                myReports.sacramentAttendanceThirdWeek.click();
                myReports.sacramentAttendanceDialogEditField.sendKeys("0");
                myReports.sacramentAttendanceDialogOk.click();
            }
            if (checkForEnabled(myReports.sacramentAttendanceFourthWeek).equalsIgnoreCase("true")) {
                myReports.sacramentAttendanceFourthWeek.click();
                myReports.sacramentAttendanceDialogEditField.sendKeys("0");
                myReports.sacramentAttendanceDialogOk.click();
            }
            if (myBasePage.checkForElement(myReports.sacramentAttendanceFifthWeek)) {
                if (checkForEnabled(myReports.sacramentAttendanceFifthWeek).equalsIgnoreCase("true")) {
                    myReports.sacramentAttendanceFifthWeek.click();
                    myReports.sacramentAttendanceDialogEditField.sendKeys("0");
                    myReports.sacramentAttendanceDialogOk.click();
                }
            }

        }

    }

    public String checkForEnabled(WebElement elementToCheck) throws Exception {
        String returnStatus;
        Thread.sleep(500);
        returnStatus = elementToCheck.getAttribute("enabled");
        return  returnStatus;
    }

    @After("@all and @SacramentAttendance and not @nonBishopric")
    public void cleanup() throws Exception {
        LOGGER.info("Cleanup - Sacrament Attendance");
        if(checkForEnabled(getSunday("First Date Field")).equalsIgnoreCase("true")) {
//        if (checkForEnabled(myReports.sacramentAttendanceFirstWeek).equalsIgnoreCase("true")) {
            sacramentAttendanceCleanUp();
            if (myBasePage.getOS().equalsIgnoreCase("android")) {
                myBasePage.scrollDownAndroidUIAutomator("1");
                Thread.sleep(4000);
            }
            myBasePage.backButton.click();
        }
    }



}
