#!/bin/bash
cd /Users/zmaxfield/Documents/workspace/qa-membertools-all
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDailyOneDevice.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDaily.xml
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDailyOneCucumber.xml
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyCucumber.json
