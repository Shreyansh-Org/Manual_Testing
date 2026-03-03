package realDevice;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ZupeeHooksHindiIos extends BaseClassRealDeviceIos{

  @Test
  public void test() throws InterruptedException {
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
    Thread.sleep(5000);
    System.out.println("Taking ToDo Page Screenshot");
    Map<String, Object> config = new HashMap<>();
    config.put("screenshotName", "first");
    config.put("fullPage", true);
    config.put("uploadChunks", true);
    config.put("pageCount", 20);
    driver.executeScript("smartui.takeScreenshot", config);
  }

}
