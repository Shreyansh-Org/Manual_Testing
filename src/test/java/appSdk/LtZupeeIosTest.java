package appSdk;

import Common.config;
import io.appium.java_client.AppiumDriver;
import io.github.lambdatest.SmartUIAppSnapshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LtZupeeIosTest {

  public static String userName = config.getUsername();
  public static String accessKey = config.getAccessKey();
  String projectToken= "33627706#01K312FH3CM9TNSH3ANTWH9H0H#App_Sdk_Ignore/select";

  AppiumDriver<?> driver;

  @Test
  public void test() throws Exception {

    DesiredCapabilities caps = new DesiredCapabilities();
    Map<String, Object> ltOptions = new HashMap<>();
    ltOptions.put("deviceName", ".*");
    ltOptions.put("app", "lt://APP10160301691751961219396618");  // Enter your app url
    ltOptions.put("isRealMobile", true);
    ltOptions.put("platformName", "Ios");
    ltOptions.put("build", "Java - Ios");
    ltOptions.put("name", "Swag Labs Ios");
    ltOptions.put("w3c", true);
    ltOptions.put("autoGrantPermissions", true);
    caps.setCapability("lt:options", ltOptions);

    driver = new AppiumDriver<>(
      new URL("https://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"), caps);

    driver.findElementByXPath("//*[@name=\"हिंदी (Hindi)\"]").click();
    Thread.sleep(5000);
    driver.findElementByXPath("//*[@name=\"+91 अपना फ़ोन नंबर दर्ज करें\"]").sendKeys("8068540274");
    Thread.sleep(5000);
    driver.findElementByXPath("//*[@name=\"Button - स्वीकार करें और आगे बढ़ें\"]").click();
    Thread.sleep(2000);
    driver.findElementByXPath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"{0} पर भेजा गया OTP दर्ज करें\"]]/*[1]/*[@type=\"XCUIElementTypeTextField\"]").sendKeys("5");
    Thread.sleep(2000);
    driver.findElementByXPath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"{0} पर भेजा गया OTP दर्ज करें\"]]/*[2]/*[@type=\"XCUIElementTypeTextField\"]").sendKeys("4");
    Thread.sleep(2000);
    driver.findElementByXPath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"{0} पर भेजा गया OTP दर्ज करें\"]]/*[3]/*[@type=\"XCUIElementTypeTextField\"]").sendKeys("9");
    Thread.sleep(2000);
    driver.findElementByXPath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"{0} पर भेजा गया OTP दर्ज करें\"]]/*[4]/*[@type=\"XCUIElementTypeTextField\"]").sendKeys("1");
    Thread.sleep(2000);
    driver.findElementByXPath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"{0} पर भेजा गया OTP दर्ज करें\"]]/*[5]/*[@type=\"XCUIElementTypeTextField\"]").sendKeys("2");
    Thread.sleep(2000);
    driver.findElementByXPath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"{0} पर भेजा गया OTP दर्ज करें\"]]/*[6]/*[@type=\"XCUIElementTypeTextField\"]").sendKeys("2");
    Thread.sleep(5000);
    driver.findElementByXPath("//*[@name=\"ZUPEE अड्डा\"]").click();
    Thread.sleep(5000);
    driver.findElementByXPath("//*[@name=\"सभी देखें\" and ./following-sibling::*[@label=\"नए प्लेयर्स / न्यूबीज\"]]/*[2]").click();
    Thread.sleep(5000);

    SmartUIAppSnapshot smartUI= new SmartUIAppSnapshot();
    Map<String,String> config= new HashMap<>();
    config.put("projectToken", projectToken);
    config.put("deviceName","Test Device");
    config.put("fullPage","true");
    config.put("cropStatusBar","false");
    config.put("cropFooter","false");

    smartUI.start(config);
    smartUI.smartuiAppSnapshot(driver,"ZupeeIos",config);
    smartUI.stop();

    driver.quit();
  }

}
