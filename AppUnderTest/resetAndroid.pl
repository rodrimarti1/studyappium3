#!/usr/bin/perl
@a = ("R9TN80AQ57J", "HT69D0204296", "R9TN80AQ57J", "09251FDD4003MU");

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
