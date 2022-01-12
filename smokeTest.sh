#!/bin/bash
cd /Users/zmaxfield/Documents/workspace/qa-membertools-all
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSSmokeTwoSim.xml
sleep 30
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSSmoke.xml
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSSmokeTwoSimCucumber.xml
sleep 30
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports1/CucumberTestReport.json /Users/zmaxfield/Documents/iOSSmokeCucumber1.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports2/CucumberTestReport.json /Users/zmaxfield/Documents/iOSSmokeCucumber2.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports3/CucumberTestReport.json /Users/zmaxfield/Documents/iOSSmokeCucumber3.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports4/CucumberTestReport.json /Users/zmaxfield/Documents/iOSSmokeCucumber4.json
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidSmokeTestsMultiple.xml
sleep 30
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidSmoke.xml
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidSmokeTestsMultipleCucumber.xml
sleep 30
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports1/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidSmokeCucumber1.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports2/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidSmokeCucumber2.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports3/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidSmokeCucumber3.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports4/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidSmokeCucumber4.json