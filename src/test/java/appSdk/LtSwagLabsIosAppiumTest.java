package appSdk;

import com.google.gson.Gson;
import io.github.lambdatest.SmartUIAppSnapshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import realDevice.BaseClassRealDeviceIos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LtSwagLabsIosAppiumTest extends BaseClassRealDeviceIos {

  String projectToken= "33627706#01K718DRADKDBR58CA56YYQC4Z#GS_page_count_issue";

  WebElement currElement;

  public final String inputUsername= "//*[@name=\"test-Username\"]"; //standard_user
  public final String inputPassword= "//*[@name=\"test-Password\"]"; //secret_sauce
  public final String btnLogin= "//*[@name=\"test-LOGIN\"]";


  @Test
  public void test() throws Exception {

    currElement= waitUntilElementIsPresent(driver,10,inputUsername);
    assert currElement != null;
    currElement.sendKeys("standard_user");
    currElement= waitUntilElementIsPresent(driver,10,inputPassword);
    assert currElement != null;
    currElement.sendKeys("secret_sauce");
    currElement= waitUntilElementIsPresent(driver,10,btnLogin);
    assert currElement != null;
    currElement.click();

    staticWait(5);

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
