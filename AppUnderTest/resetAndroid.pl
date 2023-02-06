#!/usr/bin/perl
@a = ("09251FDD4003MU", "R5CN3032NSW", "R9TN80AQ57J", "emulator-5554");

foreach $i (@a) {
    system("adb -s " . $i . " uninstall org.lds.ldstools.dev");
    system("adb -s " . $i . " uninstall org.lds.ldstools");
    system("adb -s " . $i . " uninstall org.lds.ldstools.alpha");
    system("adb -s " . $i . " uninstall io.appium.uiautomator2.server");
    system("adb -s " . $i . " uninstall io.appium.uiautomator2.server.test");
    system("adb -s " . $i . " uninstall io.appium.unlock");
    system("adb -s " . $i . " uninstall io.appium.settings");
}
exit(0);
