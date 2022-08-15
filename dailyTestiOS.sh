#!/bin/bash
cd /Users/zmaxfield/Documents/workspace/qa-membertools-all
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDailyTests.xml
sleep 30
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDaily.xml
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDailyTestsCucumber4sim.xml
sleep 30
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports1/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyCucumber1.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports2/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyCucumber2.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports3/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyCucumber3.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports4/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyCucumber4.json
