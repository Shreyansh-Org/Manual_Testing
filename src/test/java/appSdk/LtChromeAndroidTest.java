package appSdk;

import com.google.gson.Gson;
import io.github.lambdatest.SmartUIAppSnapshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import realDevice.BaseClassRealDeviceAndroid;

import java.util.*;

public class LtChromeAndroidTest extends BaseClassRealDeviceAndroid {

  String projectToken= System.getenv("PROJECT_TOKEN")!=null?System.getenv("PROJECT_TOKEN"):"2355379#01KJAHZK9V26N5V6EMNFD8Q1ZK#Omni_Prod_01";

  @Test
  public void test() throws Exception {

    driver.get("https://ipinfo.io/");
    currElement= waitUntilElementIsPresent(driver,10,"//button[text()=\"Accept\"]");
    assert currElement != null;
    currElement.click();

    SmartUIAppSnapshot smartUI= new SmartUIAppSnapshot();
    Map<String,String> config= new HashMap<>();
    config.put("projectToken", projectToken);
    config.put("buildName","b1");
    config.put("deviceName","Test Device");
    config.put("cropStatusBar","false");
    config.put("cropFooter","false");
    config.put("fullPage","false");
    config.put("testType","web");
    List<String> ignoreXpath= Arrays.asList("//div[@id=\"api-requests\"]"
      ,"(//img[@alt=\"IPinfo - Comprehensive IP address data, IP geolocation API and database\"])[1]"
      ,"(//img[@alt=\"Open menu\"])[1]","(//img[@alt=\"IPinfo - Comprehensive IP address data, IP geolocation API and database\"])[2]"
      ,"//strong[text()=\"Reliable & scalable\"]","//strong[text()=\"Here for the long run\"]","//video"
      ,"(//img[@alt=\"Geolocation\"]/parent::div)[1]");
    Map<String, Object> ignoreBoxesMap = new HashMap<>();
    ignoreBoxesMap.put("xpath",ignoreXpath);
    Gson gson= new Gson();
    config.put("ignoreBoxes",gson.toJson(ignoreBoxesMap));


    smartUI.start(config);
    smartUI.smartuiAppSnapshot(driver,"AndroidWeb",config);
    smartUI.stop();

  }

}
