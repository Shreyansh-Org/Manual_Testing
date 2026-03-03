package appSdk;

import Common.config;
import com.google.gson.Gson;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.lambdatest.SmartUIAppSnapshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LtSwagLabsIosTest {

  public static String userName = config.getUsername();
  public static String accessKey = config.getAccessKey();
  String projectToken= "33627706#01K312FH3CM9TNSH3ANTWH9H0H#App_Sdk_Ignore/select";

  WebElement currElement;
  AppiumDriver<?> driver;

  public final String inputUsername= "//*[@name=\"test-Username\"]"; //standard_user
  public final String inputPassword= "//*[@name=\"test-Password\"]"; //secret_sauce
  public final String btnLogin= "//*[@name=\"test-LOGIN\"]";


  @Test
  public void test() throws Exception {

    DesiredCapabilities caps = new DesiredCapabilities();
    Map<String, Object> ltOptions = new HashMap<>();
    ltOptions.put("deviceName", ".*");
    ltOptions.put("app", "lt://APP1016054571751545800814497");  // Enter your app url
    ltOptions.put("isRealMobile", true);
    ltOptions.put("platformName", "Ios");
    ltOptions.put("build", "Java - Ios");
    ltOptions.put("name", "Swag Labs Ios");
    ltOptions.put("w3c", true);
    ltOptions.put("autoGrantPermissions", true);
    caps.setCapability("lt:options", ltOptions);

    driver = new IOSDriver<>(
      new URL("https://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"), caps);

    currElement= config.waitUntilElementIsPresent(driver,10,inputUsername);
    assert currElement != null;
    currElement.sendKeys("standard_user");
    currElement= config.waitUntilElementIsPresent(driver,10,inputPassword);
    assert currElement != null;
    currElement.sendKeys("secret_sauce");
    currElement= config.waitUntilElementIsPresent(driver,10,btnLogin);
    assert currElement != null;
    currElement.click();

    config.staticWait(5);

    SmartUIAppSnapshot smartUI= new SmartUIAppSnapshot();
    Map<String,String> config= new HashMap<>();
    config.put("projectToken", projectToken);
    config.put("deviceName","Test Device");
    config.put("cropStatusBar","false");
    config.put("cropFooter","false");
    config.put("fullPage","true");
    config.put("preciseScroll","true");
    List<String> ignoreXpath= Arrays.asList("//*[@label=\"Sauce Labs Backpack\"]"
    ,"//*[@value=\"PRODUCTS\"]","//*[@name=\"test-Toggle\"]"
    ,"//*[@type=\"XCUIElementTypeOther\" and ./parent::*[@name=\"test-Modal Selector Button\"]]/*[@type=\"XCUIElementTypeOther\"]"
    ,"//*[@name=\"assets/src/img/sauce-pullover.jpg\"]"
    ,"//*[@name=\"assets/src/img/bolt-shirt.jpg\"]","//*[@name=\"assets/src/img/red-tatt.jpg\"]"
    ,"//*[@type=\"XCUIElementTypeOther\" and ./parent::*[@name=\"ADD TO CART\" and ./preceding-sibling::*[@label=\"$49.99\"]]]"
    ,"//*[@name=\"assets/src/img/red-onesie.jpg\"]","//*[@name=\"© 2025 Sauce Labs. All Rights Reserved.\"]","//*[@label=\"Sauce Labs Fleece Jacket\"]");
    Map<String, Object> ignoreBoxesMap = new HashMap<>();
    ignoreBoxesMap.put("xpath",ignoreXpath);
    Gson gson= new Gson();
    config.put("ignoreBoxes",gson.toJson(ignoreBoxesMap));

    smartUI.start(config);
    smartUI.smartuiAppSnapshot(driver,"SwagLabsIos",config);
    smartUI.stop();

    driver.quit();

  }

}
