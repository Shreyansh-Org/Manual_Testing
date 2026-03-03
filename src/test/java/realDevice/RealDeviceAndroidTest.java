package realDevice;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RealDeviceAndroidTest extends BaseClassRealDeviceAndroid {

    public final String btnEnglish= "//*[@name=\"English\"]";
    public final String inputPhone= "//*[@name=\"enter amount here\"]";
    public final String btnContinue= "//*[@name=\"Button - Accept & Continue\"]";
    public final String inputOtp1= "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[1]/*[@type=\"XCUIElementTypeTextField\"]";
    public final String inputOtp2= "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[2]/*[@type=\"XCUIElementTypeTextField\"]";
    public final String inputOtp3= "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[3]/*[@type=\"XCUIElementTypeTextField\"]";
    public final String inputOtp4= "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[4]/*[@type=\"XCUIElementTypeTextField\"]";
    public final String inputOtp5= "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[5]/*[@type=\"XCUIElementTypeTextField\"]";
    public final String inputOtp6= "//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[6]/*[@type=\"XCUIElementTypeTextField\"]";
    public final String btnClose= "//*[@name=\"close\"]";

    @Test
    public void testOne() throws InterruptedException {
        Map<String,Object> config= new HashMap<>();
        config.put("fullPage", true);
        config.put("pageCount", 20);
        config.put("cropStatusBar",true);

        currElement= waitUntilElementIsPresent(driver,10,btnEnglish);
        currElement.click();
        driver.executeScript("smartui.takeScreenshot=ss-01",config);
        currElement= waitUntilElementIsPresent(driver,10,inputPhone);
        currElement.sendKeys("8252113477");
        currElement= waitUntilElementIsPresent(driver,10,btnContinue);
        currElement.click();
        currElement= waitUntilElementIsPresent(driver,10,inputOtp1);
        currElement.sendKeys("8");
        currElement= waitUntilElementIsPresent(driver,10,inputOtp2);
        currElement.sendKeys("8");
        currElement= waitUntilElementIsPresent(driver,10,inputOtp3);
        currElement.sendKeys("7");
        currElement= waitUntilElementIsPresent(driver,10,inputOtp4);
        currElement.sendKeys("6");
        currElement= waitUntilElementIsPresent(driver,10,inputOtp5);
        currElement.sendKeys("7");
        currElement= waitUntilElementIsPresent(driver,10,inputOtp6);
        currElement.sendKeys("6");

        Thread.sleep(10000);

        driver.executeScript("smartui.takeScreenshot=ss-02",config);
    }

}
