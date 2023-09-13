#!/bin/bash
cd /Users/zmaxfield/Documents/workspace/qa-membertools-all
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyDirectoryEdit.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyDirectoryEdit.xml
sleep 30
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDaily/iOSDailyDirectory.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDailyDirectory.xml
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