package realDevice;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ZupeeHooksAndroid extends BaseClassRealDeviceAndroid {

  public final String btnEnglish = "//*[@text=\"English\"]";
  public final String inputPhone = "//*[@text=\"Enter your phone number\"]";
  public final String btnContinue = "//*[@text=\"Accept & Continue\"]";
  public final String inputOtp1 = "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[1]/*[@type=\"XCUIElementTypeTextField\"]";
  public final String inputOtp2 = "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[2]/*[@type=\"XCUIElementTypeTextField\"]";
  public final String inputOtp3 = "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[3]/*[@type=\"XCUIElementTypeTextField\"]";
  public final String inputOtp4 = "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[4]/*[@type=\"XCUIElementTypeTextField\"]";
  public final String inputOtp5 = "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[5]/*[@type=\"XCUIElementTypeTextField\"]";
  public final String inputOtp6 = "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[6]/*[@type=\"XCUIElementTypeTextField\"]";
  public final String btnClose = "//*[@name=\"close\"]";

  @Test
  public void test() throws Exception {

    Thread.sleep(10000);
    Map<String, Object> ignoreDOM = new HashMap<>();

    //    ignoreDOM.put("id",
    //      new String[] { "in.ludo.supremegold:id/languageGrid1", "in.ludo.supremegold:id/languageGrid1ArrowIv", });

    ignoreDOM.put("coordinates", new String[] { "500,1200,100,500","100,200,100,200","200,100,200,100","6000,5000,10000,11000" });

    Map<String, Object> config = new HashMap<>();
    config.put("screenshotName", "Zupee page screenshot");
    config.put("fullPage", true);
    config.put("getDomBoxes", true);
    config.put("pageCount", 10);
    //    config.put("swipeHeight", 4);
    config.put("ignoreDOM", ignoreDOM);

    driver.executeScript("smartui.takeScreenshot", config);
  }

}

