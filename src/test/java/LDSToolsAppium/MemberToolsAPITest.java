package LDSToolsAppium;

import LDSToolsAppium.API.MemberToolsAPI;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MemberToolsAPITest {

    public MemberToolsAPITest() {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL %4$-7s [%3$s] %5$s %6$s%n");
    }

    @Test
    public void testToolsService() throws Exception {
        MemberToolsAPI apiTest = new MemberToolsAPI();
        List<String> memberList = new ArrayList<String>();

        memberList = apiTest.getChildOrganizationMembers("History", "kroqbandit", "21628");
//        memberList = apiTest.getChildOrganizationClasses("Other Callings", "kroqbandit", "21628");


//        memberList = apiTest.getOrganizationMembers("Bishopric", "kroqbandit", "21628");
//        new MemberToolsAPI().getOrganizationMembers("Elders Quorum Presidency", "kroqbandit", "21628");

        System.out.println("LIST!");
        for (String memberName : memberList) {
            System.out.println(memberName);
        }
    }
}