#!/bin/bash
cd /Users/zmaxfield/Documents/workspace/qa-membertools-all
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyDirectoryEdit.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyDirectoryEdit.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyDirectory.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyDirectory.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCalendar.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyCalendar.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyMeetinghouses.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyMeetinghouses.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyMinistering.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyMinistering.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyMissionary.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyMissionary.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyOrganization.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyOrganization.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyPin.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyPin.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyReports.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyReports.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyTemples.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyTemples.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyWhatsNew.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyWhatsNew.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCucumberMoveRecords.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyMoveRecords.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCucumberPrayerRoll.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyPrayerRoll.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCucumberClassAndQuorum.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyClassAndQuorum.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCucumberClassAndQuorumVisitor.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyClassAndQuorumVisitor.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCucumberLists.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyLists.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCucumberListsWithSample.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyListsWithSample.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCucumberMissionLeaderDirectory.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyMissionLeaderDirectory.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCucumberOktaLogin.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyOktaLogin.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCucumberPaymentRequests.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyPaymentRequests.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCucumberProgressRecord.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyProgressRecord.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCucumberQuarterlyReport.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyQuarterlyReport.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyCucumberSacramentAttendance.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailySacrementAttendance.json
sleep 30