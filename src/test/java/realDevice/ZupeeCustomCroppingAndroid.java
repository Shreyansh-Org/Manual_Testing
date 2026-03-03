package realDevice;

import Common.config;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;


public class ZupeeCustomCroppingAndroid {
  private static AppiumDriver driver;

  public static void main(String[] args) {
    String prodHub = "@mobile-hub.lambdatest.com/wd/hub";
    String prodAppName = "lt://APP10160341071747032377111756";
    String prodDevice = "iPhone 16 Pro";

    String stageHub = "@mobile-hub-zmobile-dev.lambdatestinternal.com/wd/hub";
    //        String stageHub = "@stage-mobile-hub.lambdatestinternal.com/wd/hub";
    String stageAppName =  "lt://APP1010423811749550563279124";
    String stageDevice = "Redmi Note 9";
    boolean prodEnv = false;

    String userName = config.getUsername();
    String accessKey = config.getAccessKey();
    String hub = prodEnv ? prodHub : stageHub;
    String appName = prodEnv ? prodAppName : stageAppName;
    String deviceName = prodEnv ? prodDevice : stageDevice;

    try {
      setupAppiumDriver(userName, accessKey, hub, appName, deviceName);
      runTestWithImprovedFlow();
    } catch (Exception e) {
      System.err.println("Test execution failed: " + e.getMessage());
      e.printStackTrace();
    } finally {
      if (driver != null) {
        driver.quit();
        System.out.println("Driver session ended");
      }
    }
  }

  /**
   * Sets up the Appium driver with the specified capabilities
   */
  private static void setupAppiumDriver(String userName, String accessKey, String hub, String appName, String deviceName) throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    Map<String, Object> ltOptions = new HashMap<>();

    ltOptions.put("app", appName);
    ltOptions.put("deviceName", deviceName);
    ltOptions.put("platformName", "android");
    ltOptions.put("isRealMobile", true);
    ltOptions.put("name", "Zupee");
    ltOptions.put("w3c", true);
    ltOptions.put("video", true);
    ltOptions.put("visual", true);
    ltOptions.put("smartUI.project", "Zupee-Project-IOS");
    ltOptions.put("autoGrantPermissions", false);
    ltOptions.put("smartUI.cropStatusBar", true);

    capabilities.setCapability("lt:options", ltOptions);

    System.out.println("Setting up Appium driver...");
    URL url = new URL("https://" + userName + ":" + accessKey + hub);
    driver = new AppiumDriver(url, capabilities);
    System.out.println("Driver setup successful");
  }

  /**
   * Executes the automated test flow
   */
  private static void runTestWithImprovedFlow() {
    try {
      System.out.println("Starting test execution...");

      // Create a reusable wait object for explicit waits
      WebDriverWait wait = new WebDriverWait(driver, 30);

      // Select English language
      clickWhenAvailable(wait, "//*[@name=\"English\"]", "English language option");

      // Enter mobile number
      enterText(wait, "//*[@name=\"enter amount here\"]", "8252113477", "Phone number field");

      // Click Accept & Continue
      clickWhenAvailable(wait, "//*[@name=\"Button - Accept & Continue\"]", "Accept & Continue button");

      // Enter OTP code
      enterOTP(wait);

      clickWhenAvailable(wait, "//*[@name=\"Refer\"]", "Refer tab");
      //            clickWhenAvailable(wait, "//*[@name=\"Adda\"]", "Adda tab");

      // Navigate to Account section
      //            clickWhenAvailable(wait, "//*[@name=\"Account\"]", "Account tab");
      //            clickWhenAvailable(wait, "//*[@name=\"VIEW MORE OPTIONS\"]", "More options");

      // Click profile subtitle
      //            clickWhenAvailable(wait, "//*[@name=\"profileSubTitle\"]", "Profile subtitle");

      // Take screenshot for reporting
      pauseFor(10000);
      Map<String, Object> config = new HashMap<>();
      config.put("screenshotName", "Zupee page screens8");
      config.put("fullPage", true);
      config.put("pageCount", 10);
      //      config.put("cropHeader",true);
      //      config.put("cropFooter",true);
      config.put("swipeHeight", 4);
      config.put("uploadChunks",true);
      config.put("footerHeight", 700);

      Map<String, Object> ignoreDOM = new HashMap<>();

      Map<String, Object> selectDOM = new HashMap<>();

      //            selectDOM.put("xpath", new String[]{
      //                    "//*[@name=\"Account\"]",
      //            });
      //
      //            ignoreDOM.put("coordinates", new String[]{
      //                    "0,200,0,500",
      //            });
      //            config.put("getDomBoxes", true);
      //            config.put("ignoreDOM", ignoreDOM);
      //            config.put("selectDOM", selectDOM);

      driver.executeScript("smartui.takeScreenshot", config);
      System.out.println("Test completed successfully");
    } catch (Exception e) {
      System.err.println("Error during test execution: " + e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * Clicks on an element when it becomes available
   */
  private static void clickWhenAvailable(WebDriverWait wait, String xpath, String elementName) {
    try {
      System.out.println("Waiting for " + elementName);
      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
      element.click();
      System.out.println("Clicked on " + elementName);
    } catch (Exception e) {
      System.err.println("Failed to click on " + elementName);
      throw e;
    }
  }

  /**
   * Enters text into a field when it becomes available
   */
  private static void enterText(WebDriverWait wait, String xpath, String text, String fieldName) {
    try {
      System.out.println("Waiting for " + fieldName);
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
      element.clear();
      element.sendKeys(text);
      System.out.println("Entered text in " + fieldName);
    } catch (Exception e) {
      System.err.println("Failed to enter text in " + fieldName);
      throw e;
    }
  }

  /**
   * Enters OTP code characters one by one
   */
  private static void enterOTP(WebDriverWait wait) {
    try {
      // otp: 887676
      wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[1]/*[@type=\"XCUIElementTypeTextField\"]")
      )).sendKeys("8");

      wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[2]/*[@type=\"XCUIElementTypeTextField\"]")
      )).sendKeys("8");

      wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[3]/*[@type=\"XCUIElementTypeTextField\"]")
      )).sendKeys("7");

      wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[4]/*[@type=\"XCUIElementTypeTextField\"]")
      )).sendKeys("6");

      wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[5]/*[@type=\"XCUIElementTypeTextField\"]")
      )).sendKeys("7");

      wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Enter OTP sent to {0}\"]]/*[6]/*[@type=\"XCUIElementTypeTextField\"]")
      )).sendKeys("6");
      System.out.println("OTP entry completed");
    } catch (Exception e) {
      System.err.println("Failed to enter OTP code");
      throw e;
    }
  }

  /**
   * Pauses execution for the specified milliseconds
   */
  private static void pauseFor(long milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
