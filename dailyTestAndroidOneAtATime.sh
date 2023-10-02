#!/bin/bash
cd /Users/zmaxfield/Documents/workspace/qa-membertools-all
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyDirectoryEdit.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDailyDirectoryEdit.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyDirectory.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDailyDirectory.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCalendar.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDailyCalendar.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyMeetinghouses.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDailyMeetinghouses.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyMinistering.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDailyMinistering.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyMissionary.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDailyMissionary.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyOrganization.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDailyOrganization.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyPin.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDailyPin.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyReports.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDailyReports.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyTemples.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDailyTemples.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyWhatsNew.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDailyWhatsNew.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCucumberMoveRecords.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyMoveRecords.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCucumberPrayerRoll.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyPrayerRoll.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCucumberClassAndQuorum.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyClassAndQuorum.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCucumberClassAndQuorumVisitor.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyClassAndQuorumVisitor.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCucumberLists.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyLists.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCucumberListsWithSample.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyListsWithSample.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCucumberMissionLeaderDirectory.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyMissionLeaderDirectory.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCucumberOktaLogin.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyOktaLogin.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCucumberPaymentRequests.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyPaymentRequests.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCucumberProgressRecord.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyProgressRecord.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCucumberQuarterlyReport.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyQuarterlyReport.json
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDaily/AndroidDailyCucumberSacramentAttendance.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailySacrementAttendance.json
sleep 30