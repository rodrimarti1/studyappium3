#!/bin/bash
cd /Users/zmaxfield/Documents/workspace/qa-membertools-all
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidSmoke.xml
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidSmokeOneCucumber.xml
sleep 30
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidSmokeCucumber.json
