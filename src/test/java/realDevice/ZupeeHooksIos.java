package realDevice;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ZupeeHooksIos extends BaseClassRealDeviceIos {

  public final String btnEnglish= "//*[@label=\"English\"]";
  public final String inputPhone= "//*[@name=\"enter amount here\"]";
  public final String btnContinue= "//*[@name=\"Button text - Accept & Continue\"]";
  public final String inputOtp1= "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[1]/*[@type=\"XCUIElementTypeTextField\"]";
  public final String inputOtp2= "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[2]/*[@type=\"XCUIElementTypeTextField\"]";
  public final String inputOtp3= "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[3]/*[@type=\"XCUIElementTypeTextField\"]";
  public final String inputOtp4= "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[4]/*[@type=\"XCUIElementTypeTextField\"]";
  public final String inputOtp5= "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[5]/*[@type=\"XCUIElementTypeTextField\"]";
  public final String inputOtp6= "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[6]/*[@type=\"XCUIElementTypeTextField\"]";
  public final String btnRefer= "//*[@name=\"Refer\"]";


  @Test
  public void test() throws Exception {
    
    currElement= waitUntilElementIsPresent(driver,20,btnEnglish);
    if(currElement!=null) {
      currElement.click();
    }
    currElement= waitUntilElementIsPresent(driver,10,inputPhone);
    if(currElement!=null) {
      currElement.sendKeys("8252113477");
    }
    currElement= waitUntilElementIsPresent(driver,10,btnContinue);
    if(currElement!=null) {
      currElement.click();
    }
    currElement= waitUntilElementIsPresent(driver,10,inputOtp1);
    if(currElement!=null) {
      currElement.sendKeys("8");
    }
    currElement= waitUntilElementIsPresent(driver,10,inputOtp2);
    if(currElement!=null) {
      currElement.sendKeys("8");
    }
    currElement= waitUntilElementIsPresent(driver,10,inputOtp3);
    if(currElement!=null) {
      currElement.sendKeys("7");
    }
    currElement= waitUntilElementIsPresent(driver,10,inputOtp4);
    if(currElement!=null) {
      currElement.sendKeys("6");
    }
    currElement= waitUntilElementIsPresent(driver,10,inputOtp5);
    if(currElement!=null) {
      currElement.sendKeys("7");
    }
    currElement= waitUntilElementIsPresent(driver,10,inputOtp6);
    if(currElement!=null) {
      currElement.sendKeys("6");
    }
    currElement= waitUntilElementIsPresent(driver,10,btnRefer);
    if(currElement!=null) {
      currElement.click();
    }

    Thread.sleep(10000);

    Map<String, Object> config = new HashMap<>();
    config.put("screenshotName", "Zupee page screenshot");
    config.put("fullPage", true);
    config.put("pageCount", 10);
//        config.put("swipeHeight", 4);
    config.put("footerHeight", 1500);

    Map<String, Object> ignoreDOM = new HashMap<>();

    ignoreDOM.put("xpath", new String[]{
      "//*[@name=\"Friend ke sign up karne pe, aapko ₹5 & aapke friend ko ₹10\"]",
      "//*[@type=\"XCUIElementTypeOther\" and ./parent::*[@type=\"XCUIElementTypeWebView\" and ./following-sibling::*[@name=\"Horizontal scroll bar, 1 page\"]]]/*[@type=\"XCUIElementTypeOther\"]/*[@type=\"XCUIElementTypeOther\"]/*[@type=\"XCUIElementTypeOther\"]/*[8]",
      "//*[@name=\"Share on WhatsApp\"]",
      "//*[@name=\"Adda\"]",
      "//*[@label=\"Sauce Labs Onesie\"]",
      "//*[@type=\"XCUIElementTypeOther\" and ./parent::*[@name=\"ADD TO CART\" and ./preceding-sibling::*[@label=\"$7.99\"]]]"
    });

    config.put("getDomBoxes", true);
    config.put("selectDOM", ignoreDOM);

    driver.executeScript("smartui.takeScreenshot", config);
  }

}

