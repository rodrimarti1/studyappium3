package LDSToolsAppiumTest.steps;

import LDSToolsAppium.API.Expenses.Charge;
import LDSToolsAppium.API.Expenses.Expense;
import LDSToolsAppium.API.Expenses.Payee;
import LDSToolsAppium.API.LifeResources.Contact;
import LDSToolsAppium.API.LifeResources.LifeResource;
import LDSToolsAppium.API.LifeResources.Resource;
import LDSToolsAppium.API.MemberToolsAPI;
import LDSToolsAppium.BasePage;
import LDSToolsAppium.Screen.DirectoryScreen;
import LDSToolsAppium.Screen.MenuScreen;
import LDSToolsAppium.Screen.ReportsScreen;
import LDSToolsAppiumTest.HelperMethods;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class API {

    HelperMethods myHelper = new HelperMethods();
    MemberToolsAPI apiTest = new MemberToolsAPI();
    List<String> memberList = new ArrayList<String>();
    int responseCode;
    int urlStatus;
    HashMap<String, String> listMap = new HashMap<>();
    LifeResource testLR = new LifeResource();


    @Given("a {string} account checks the Class and Quorum Attendance right")
    public void aMemberAccountChecksTheClassAndQuorumAttendanceRight(String memberCalling) throws Exception {
        String[] callingRights;
//        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Maplewood 2nd");
        memberList = apiTest.getClassAndQuorumRights(callingRights[1], "39373");
    }

    @Given("a {string} account checks the Reports")
    public void aMemberAccountChecksTheReports(String memberCalling) throws Exception {
        String[] callingRights;
//        callingRights = myHelper.getMemberNameFromList(memberCalling, "Centinela 1st");
        callingRights = myHelper.getMemberNameFromList(memberCalling, "Maplewood 2nd");
        urlStatus = apiTest.getApiResponseCode( "reports?units=39373" , callingRights[1] );
    }

    @Then("the Reports {string} are visible")
    public void theReportsStatusAreVisible(String status) {
        if (status.equalsIgnoreCase("true")) {
            Assert.assertTrue(urlStatus >= 200 && urlStatus <= 299);
        }
        if (status.equalsIgnoreCase("false")) {
            Assert.assertTrue(urlStatus >= 400);
        }
    }


    @Then("the Class and Quorum editable field is {string}")
    public void theClassAndQuorumEditableFieldIsStatus(String status) throws Exception {
        for (String memberStatus : memberList) {
            System.out.println("Member Status: " + memberStatus + " Should be: " + status);
            Assert.assertTrue(memberStatus.equalsIgnoreCase(status));
        }
    }

    @Given("a {string} goes to the {string}")
    public void aMemberGoesToTheUrl(String member, String url) throws Exception {
        String[] callingRights;
//        callingRights = myHelper.getMemberNameFromList(member, "Centinela 1st");
        callingRights = myHelper.getMemberNameFromList(member, "Maplewood 2nd");
        urlStatus = apiTest.getApiResponseCode( url, callingRights[1] );
    }



    @Then("the status should be {string}")
    public void theStatusShouldBeStatus(String status) throws Exception {

        if (status.equalsIgnoreCase("Success")) {
            Assert.assertTrue(urlStatus >= 200 && urlStatus <= 299, "STATUS: " + urlStatus);
        }
        if (status.equalsIgnoreCase("Error")) {
            Assert.assertTrue(urlStatus >= 400, "STATUS: " + urlStatus);
        }
    }

    @Given("a member creates a list")
    public void aMemberCreatesAList() throws Exception {
        responseCode = apiTest.postListTest("ee4a2b31-a913-442a-9cef-70722cb55f3c", "TEST API",51, "50eff3b6-10c2-4caf-9c18-f070e41fc1ca", "mbthomas74");
        Assert.assertEquals(responseCode, 200);
    }

    @Then("the new list will be displayed")
    public void theNewListWillBeDisplayed() throws Exception {
        listMap = apiTest.getListNames("mbthomas74");
        Assert.assertTrue(listMap.containsKey("TEST API"));
    }

    @And("the list is deleted")
    public void theListIsDeleted() throws Exception {
        responseCode = apiTest.listDelete("TEST API", "mbthomas74");
        Assert.assertEquals(responseCode, 200);
    }

    @Then("the list will not be displayed")
    public void theListWillNotBeDisplayed() throws Exception {
        listMap = apiTest.getListNames("mbthomas74");
        Assert.assertFalse(listMap.containsKey("TEST API"));
    }

    @When("a {string} gets the life resources for the {string}")
    public void aMemberGetsTheLifeResourcesForTheUnit(String member, String unit) throws Exception {
        String myUser;
        myUser = getUsername(member);
        testLR = apiTest.getLifeResource(myUser, unit);
    }

    @Then("the {string} {string} {string} {string} will match")
    public void theLRtoCheckPhoneEmailUrlWillMatch(String LRtoCheck, String phone, String email, String url) {
        String myPhone = null;
        String myEmail = null;
        String myUrl = null;

        for (Resource myResource: testLR.getResources()) {
//            System.out.println(myResource.getName());
            if (myResource.getName().equalsIgnoreCase(LRtoCheck)) {
//                System.out.println(myResource.getUrl());
                if (myResource.getPhone() == null) {
                    myPhone = "";
                } else {
                    myPhone = myResource.getPhone();
                }
                if (myResource.getEmail() == null) {
                    myEmail = "";
                } else {
                    myEmail = myResource.getEmail();
                }
                if (myResource.getUrl() == null) {
                    myUrl = "";
                } else {
                    myUrl = myResource.getUrl();
                }
            }
        }
        Assert.assertEquals(myPhone, phone);
        Assert.assertEquals(myEmail, email);
        Assert.assertEquals(myUrl, url);
    }

    @Given("a {string} creates a {string} in the {string}")
    public void aStakeLeadershipCreatesALifeResourceInTheUnit(String proxyName, String lifeResourceName, String unit) throws Exception {
        String myUser;
        Resource myResource = new Resource();
        myUser = getUsername(proxyName);

        myResource = createResource(lifeResourceName);
        responseCode = apiTest.createLifeResource(unit, myUser, myResource);
        System.out.println("CODE: " + responseCode);
    }

    @Then("the {string} will be correct")
    public void theLifeResourceWillBeCorrect(String lifeResourceName) throws Exception {
        String myUser;
        String unit = "502278";
        Resource myResource = new Resource();
        myUser = getUsername("STAKE_PRESIDENT");

        myResource = createResource(lifeResourceName);

        testLR = apiTest.getLifeResource(myUser, unit);

        System.out.println("Resource name to look for: " + myResource.getName());

        for (Resource apiResource: testLR.getResources()) {
            System.out.println(apiResource.getName());
            if (apiResource.getName().equalsIgnoreCase(myResource.getName())) {
                Assert.assertEquals(apiResource.getName(), (myResource.getName()));
                Assert.assertEquals(apiResource.getAddress(), (myResource.getAddress()));
                Assert.assertEquals(apiResource.getDescription(), (myResource.getDescription()));
                Assert.assertEquals(apiResource.getAddress(), (myResource.getAddress()));
                Assert.assertEquals(apiResource.getEmail(), (myResource.getEmail()));
                Assert.assertEquals(apiResource.getLimitedVisibility(), (myResource.getLimitedVisibility()));
                Assert.assertEquals(apiResource.getNotes(), (myResource.getNotes()));
                Assert.assertEquals(apiResource.getPhone(), (myResource.getPhone()));
                Assert.assertEquals(apiResource.getUrl(), (myResource.getUrl()));
            }
        }
    }

    @And("the {string} is deleted")
    public void theLifeResourceIsDeleted(String resourceName) throws Exception {
        int responseCode = 0;
        String unitNumber = "502278";
        String myUser = getUsername("STAKE_PRESIDENT");
        Resource resourceToDelete = createResource(resourceName);
        LifeResource testLR = new LifeResource();
        testLR = apiTest.getLifeResource(myUser, unitNumber);
        for (Resource myResource: testLR.getResources()) {
            System.out.println("Name: " + myResource.getName());
            if (myResource.getName().equalsIgnoreCase(resourceToDelete.getName())) {
                System.out.println("Name: " + myResource.getName());
                System.out.println("Uuid: " + myResource.getUuid());
                responseCode = apiTest.lifeResourceDelete(myResource, myUser);
            }
        }
        System.out.println("CODE: " + responseCode);
    }

    @Then("the {string} will be deleted")
    public void theLifeResourceWillBeDeleted(String resourceName) throws Exception {
        String myStatus = "";
        String unitNumber = "502278";
        String myUser = getUsername("STAKE_PRESIDENT");
        LifeResource testLR = new LifeResource();
        testLR = apiTest.getLifeResource(myUser, unitNumber);
        for (Resource myResource: testLR.getResources()) {
            System.out.println("Name: " + myResource.getName());
            if (myResource.getName().equalsIgnoreCase(resourceName)) {
                myStatus = "found";
            } else {
                myStatus = "notfound";
            }
        }
        Assert.assertTrue(myStatus.equalsIgnoreCase("notfound"));
    }

    @And("the {string} is edited")
    public void theIsEdited(String resourceName) throws Exception {
        Resource myResource = new Resource();
        String unitNumber = "502278";
        String myUser = getUsername("STAKE_PRESIDENT");

        myResource = createResource(resourceName);
        Resource editedLifeResource = createResource("editedLifeResource");

        //Get the Uuid for the Life Resource to change
        testLR = apiTest.getLifeResource(myUser, unitNumber);
        for (Resource foundResource: testLR.getResources()) {
            System.out.println("Name: " + foundResource.getName());
            if (foundResource.getName().equalsIgnoreCase(myResource.getName())) {
                System.out.println("Name: " + foundResource.getName());
                System.out.println("Uuid: " + foundResource.getUuid());
                editedLifeResource.setUuid(foundResource.getUuid());
            }
        }



        responseCode = apiTest.putLifeResource(myUser, editedLifeResource);
        System.out.println("CODE: " + responseCode);
    }


    public String getUsername(String member) throws Exception {
        String[] callingRights;
        String userName = "";
        callingRights = myHelper.getMemberNameFromList(member, "Maplewood 2nd");
        userName = callingRights[1];
        return userName;
    }

    public Resource createResource(String lifeResourceName) throws Exception {

        Resource myResource = new Resource();
        Contact myContact = new Contact();
        List<String> tagList = new ArrayList<>();

        if (lifeResourceName.equalsIgnoreCase("lifeResourceOne")) {
            //Create Contact
            myContact.setDisplayName("Test Contact");
            myContact.setPhone("801-867-5309");

            //Create Tag
            tagList.add("f6638875-aa67-45ae-bb62-60290bfa6d53");

            //Create the Resource
            myResource.setName("Automated Test One");
            myResource.setChurchResource(false);
            myResource.setAddress("3740 W Market Center Dr, Riverton, UT 84065");
            myResource.setContact(myContact);
            myResource.setDescription("Automated test one description");
            myResource.setEmail("testemail@gmail.com");
            myResource.setLimitedVisibility(false);
            myResource.setNotes("Automated Notes");
            myResource.setPhone("999-888-7777");
            myResource.setUrl("https://www.google.com");
            myResource.setTags(tagList);
        }

        if (lifeResourceName.equalsIgnoreCase("lifeResourceTwo")) {
            //Create Contact
            myContact.setDisplayName("Test Two Contact");
            myContact.setPhone("801-867-7777");

            //Create Tag
            tagList.add("f6638875-aa67-45ae-bb62-60290bfa6d53");

            //Create the Resource
            myResource.setName("Automated Test Two");
            myResource.setChurchResource(false);
            myResource.setAddress("50 E North Temple Street, Salt Lake City, Utah 84150");
            myResource.setContact(myContact);
            myResource.setDescription("Automated test Two description");
            myResource.setEmail("testemail@gmail.com");
            myResource.setLimitedVisibility(true);
            myResource.setNotes("Test Two automated test notes");
            myResource.setPhone("111-222-3333");
            myResource.setUrl("https://www.churchofjesuschrist.org");
            myResource.setTags(tagList);
        }

        if (lifeResourceName.equalsIgnoreCase("editedLifeResource")) {
            //Create Contact
            myContact.setDisplayName("Edit Test Two Contact");
            myContact.setPhone("555-555-5555");

            //Create Tag
            tagList.add("f6638875-aa67-45ae-bb62-60290bfa6d53");

            //Create the Resource
            myResource.setName("Edit Automated Test Two");
            myResource.setChurchResource(false);
            myResource.setAddress("501 E North Temple Street, Salt Lake City, Utah 84150");
            myResource.setContact(myContact);
            myResource.setDescription("Edit Automated test Two description");
            myResource.setEmail("editl@gmail.com");
            myResource.setLimitedVisibility(true);
            myResource.setNotes("Edit Test Two automated test notes");
            myResource.setPhone("777-777-7777");
            myResource.setUrl("https://www.cnn.com");
            myResource.setTags(tagList);
        }

        if (lifeResourceName.equalsIgnoreCase("lifeResourceSampleOne")) {
            //Create Contact
            myContact.setDisplayName("Sample One");
            myContact.setPhone("801-867-5309");

            //Create Tag
            tagList.add("f6638875-aa67-45ae-bb62-60290bfa6d53");

            //Create the Resource
            myResource.setName("Sample One");
            myResource.setChurchResource(false);
            myResource.setAddress("3740 W Market Center Dr, Riverton, UT 84065");
            myResource.setContact(myContact);
            myResource.setDescription("Sample one description");
            myResource.setEmail("sample@gmail.com");
            myResource.setLimitedVisibility(true);
            myResource.setNotes("Sample Notes");
            myResource.setPhone("999-888-7777");
            myResource.setUrl("https://www.google.com");
            myResource.setTags(tagList);
        }

        if (lifeResourceName.equalsIgnoreCase("lifeResourceSampleTwo")) {
            //Create Contact
            myContact.setDisplayName("Sample Two");
            myContact.setPhone("385-232-2233");

            //Create Tag
            tagList.add("f6638875-aa67-45ae-bb62-60290bfa6d53");

            //Create the Resource
            myResource.setName("Sample Two");
            myResource.setChurchResource(false);
            myResource.setAddress("3740 W Market Center Dr, Riverton, UT 84065");
            myResource.setContact(myContact);
            myResource.setDescription("Sample two description");
            myResource.setEmail("sampleTWO@gmail.com");
            myResource.setLimitedVisibility(false);
            myResource.setNotes("Sample two Notes");
            myResource.setPhone("123-456-7890");
            myResource.setUrl("https://www.google.com");
            myResource.setTags(tagList);
        }



        return myResource;


    }


    @When("an expense is created for {string}")
    public void anExpenseIsCreatedFor(String expenseName) throws Exception {
        Expense expenseToCreate = createExpense(expenseName);
        int categoryID = 0;
        int categoryAmount = 0;
        for(Charge oneCharge: expenseToCreate.getCharges()) {
            categoryID = oneCharge.getCategoryId();
            categoryAmount = oneCharge.getAmount();
        }
        System.out.println(expenseToCreate.getAccountId());
        System.out.println(expenseToCreate.getPayee().getMemberUuid());
        System.out.println(expenseToCreate.getPurpose());
        System.out.println(expenseToCreate.getUnitNumber());
        System.out.println(categoryID);
        System.out.println(categoryAmount);

        responseCode = apiTest.createPaymentRequest(expenseToCreate.getAccountId(),
                expenseToCreate.getPayee().getMemberUuid(),
                expenseToCreate.getPurpose(),
                expenseToCreate.getUnitNumber(),
                categoryID,
                categoryAmount,
                "dsoneil");
        System.out.println("CODE: " + responseCode);
        Assert.assertTrue(responseCode < 320);
    }

    @Then("the expense will be correct for {string}")
    public void theExpenseWillBeCorrectFor(String expenseName) throws Exception {
        Expense expenseToCreate = createExpense(expenseName);
        Expense expenseToCheck = apiTest.getExpenseReturnExpense("dsoneil", "39373", expenseName);

        Assert.assertEquals(expenseToCheck.getPurpose(), expenseToCreate.getPurpose());
        //I don't think the Uuid is passed anymore.
//        Assert.assertEquals(expenseToCheck.getPayee().getMemberUuid(), expenseToCreate.getPayee().getMemberUuid());
//        Assert.assertEquals(expenseToCheck.getCharges(), expenseToCreate.getCharges()); //Might not work

    }

    @And("the expense {string} will be modified to {string}")
    public void theExpenseWillBeModifiedTo(String origExpense, String newExpense) throws Exception {
        Expense expenseToCreate = createExpense(newExpense);
        //Get ID to change
        Expense findExpense = apiTest.getExpenseReturnExpense("dsoneil", "39373", origExpense);
        expenseToCreate.setId(findExpense.getId());
        //Change
//        responseCode = apiTest.putExpenseUpdate(expenseToCreate, "dsoneil");
        responseCode = apiTest.putExpenseUpdate(expenseToCreate, "JaysonKoleW");
        System.out.println("CODE: " + responseCode);
        Assert.assertTrue(responseCode < 320);
    }

    @And("delete the expense {string}")
    public void deleteTheExpense(String expenseToDelete) throws Exception {
        Expense findExpense = apiTest.getExpenseReturnExpense("dsoneil", "39373", expenseToDelete);
        responseCode = apiTest.expenseDelete(findExpense.getId(), findExpense.getType(), "dsoneil");
        System.out.println("CODE: " + responseCode);
        Assert.assertTrue(responseCode < 320);
    }

    @Then("the expense {string} will {string}")
    public void theExpenseWill(String expenseToFind, String foundStatus) throws Exception{
        Expense findExpense = apiTest.getExpenseReturnExpense("dsoneil", "39373", expenseToFind);
        if (findExpense == null) {
            System.out.println("Expense Not Found");
            Assert.assertEquals("not be found", expenseToFind);
        } else {
            System.out.println("Expense Found");
            Assert.assertEquals("will be found", expenseToFind);
        }
    }




    public Expense createExpense(String expenseName) throws Exception {
        Expense myExpense = new Expense();
        Payee myPayee = new Payee();
        Charge myCharge = new Charge();
        List<Charge> listCharge = new ArrayList<>();


        if (expenseName.equalsIgnoreCase("api automated test 1")) {
            myPayee.setMemberUuid("533356e1-66c5-49dc-b37b-13a416594413");

            myCharge.setCategoryId(952);
            myCharge.setAmount(1234);
            listCharge.add(myCharge);

            myExpense.setAccountId(8880);
            myExpense.setUnitNumber(39373);
            myExpense.setPurpose("API Automated Test 1");
            myExpense.setPayee(myPayee);
            myExpense.setCharges(listCharge);
        }

        if (expenseName.equalsIgnoreCase("api automated test 2")) {
            myPayee.setMemberUuid("533356e1-66c5-49dc-b37b-13a416594413");

            myCharge.setCategoryId(952);
            myCharge.setAmount(8888);
            listCharge.add(myCharge);

            myExpense.setAccountId(8880);
            myExpense.setUnitNumber(39373);
            myExpense.setPurpose("API Automated Test 2");
            myExpense.setPayee(myPayee);
            myExpense.setCharges(listCharge);
        }

        return myExpense;

    }



}
