package appSdk;

import Common.config;
import com.google.gson.Gson;
import io.appium.java_client.AppiumDriver;
import io.github.lambdatest.SmartUIAppSnapshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.*;

public class LtSwagLabsAndroidTest {

  public static String userName = config.getUsername();
  public static String accessKey = config.getAccessKey();
  String projectToken= System.getenv("PROJECT_TOKEN")!=null?System.getenv("PROJECT_TOKEN"):"33627706#01K718DRADKDBR58CA56YYQC4Z#GS_page_count_issue";

  WebElement currElement;
  AppiumDriver<?> driver;

  public final String inputUsername= "//*[@content-desc=\"test-Username\"]"; //standard_user
  public final String inputPassword= "//*[@content-desc=\"test-Password\"]"; //secret_sauce
  public final String btnLogin= "//*[@content-desc=\"test-LOGIN\"]";


  @Test
  public void test() throws Exception {

    DesiredCapabilities caps = new DesiredCapabilities();
    Map<String, Object> ltOptions = new HashMap<>();
    ltOptions.put("deviceName", ".*");
    ltOptions.put("app", "lt://APP1016054801766748701560918");  // Enter your app url
    ltOptions.put("isRealMobile", true);
    ltOptions.put("platformName", "Android");
//    ltOptions.put("platformVersion","13");
    ltOptions.put("build", "Java - Android");
    ltOptions.put("name", "Swag labs Android");
    ltOptions.put("w3c", true);
    ltOptions.put("autoGrantPermissions", true);
//    ltOptions.put("smartUI.project", "testing_556");
    caps.setCapability("lt:options", ltOptions);

    driver = new AppiumDriver<>(
      new URL("https://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"), caps);

//    driver = new AppiumDriver<>(
//      new URL("https://"+userName+":"+accessKey+"@stage-mobile-hub.lambdatestinternal.com/wd/hub"), caps);

    Objects.requireNonNull(config.waitUntilElementIsPresent(driver, 10, "//*[@content-desc=\"test-Username\"]")).click();

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
    config.put("pageCount","25");
    config.put("uploadChunks","true");
    config.put("fullPage","true");
//    config.put("preciseScroll","true");
    List<String> ignoreXpath= Arrays.asList("//*[@text=\"Sauce Labs Backpack\"]"
      ,"//*[@text=\"Sauce Labs Onesie\"]","//*[@text=\"PRODUCTS\"]","//*[@text=\"Terms of Service | Privacy Policy\"]"
      ,"//*[@text=\"© 2025 Sauce Labs. All Rights Reserved.\"]","//*[@class=\"android.view.ViewGroup\" and ./parent::*[@content-desc=\"test-Modal Selector Button\"]]/*[@class=\"android.view.ViewGroup\"]/*[@class=\"android.widget.ImageView\"]"
      ,"//*[@class=\"android.widget.ImageView\" and ./parent::*[@content-desc=\"test-Toggle\"]]","//*[@class=\"android.widget.ImageView\" and ./preceding-sibling::*[@content-desc=\"test-Menu\"]]"
      ,"//*[@class=\"android.view.ViewGroup\" and ./parent::*[@content-desc=\"test-PRODUCTS\"]]/*[2]/*[2]/*[@class=\"android.view.ViewGroup\"]/*[@class=\"android.widget.ImageView\"]"
      ,"//*[@text=\"Sauce Labs Bolt T-Shirt\"]","//*[@content-desc=\"test-ADD TO CART\" and ./preceding-sibling::*[@text=\"$15.99\"]]"
      ,"//*[@class=\"android.widget.ImageView\" and ./following-sibling::*[@text=\"Test.allTheThings() T-Shirt (Red)\"]]"
      ,"//*[@text=\"Sauce Labs Onesie\"]","//*[@text=\"$7.99\"]","//*[@text=\"Test.allTheThings() T-Shirt (Red)\"]");
    Map<String, Object> ignoreBoxesMap = new HashMap<>();
    ignoreBoxesMap.put("xpath",ignoreXpath);
    Gson gson= new Gson();
//    config.put("ignoreBoxes",gson.toJson(ignoreBoxesMap));


    smartUI.start(config);
    smartUI.smartuiAppSnapshot(driver,"SwagLabsAndroid",config);
    smartUI.stop();

    driver.quit();

  }

}
