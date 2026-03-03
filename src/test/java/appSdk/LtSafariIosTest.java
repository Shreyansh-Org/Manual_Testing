package appSdk;

import com.google.gson.Gson;
import io.github.lambdatest.SmartUIAppSnapshot;
import org.testng.annotations.Test;
import realDevice.BaseClassRealDeviceIos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LtSafariIosTest extends BaseClassRealDeviceIos {

  String projectToken= "33627706#01KHQXS9FC209RTPMWGZT39WX1#Omni_Testing_shreyansh_09";

  @Test
  public void test() throws Exception {

    driver.get("https://www.lambdatest.com");

    Thread.sleep(1000);

    SmartUIAppSnapshot smartUIAppSnapshot= new SmartUIAppSnapshot();
    Map<String,String> startConfig= new HashMap<>();
    startConfig.put("projectToken",projectToken);
    Map<String,String> config = new HashMap<>();
    config.put("deviceName","S24");
    config.put("platform","");


    List<String> xpathSelect = Arrays.asList(
      "/html/body/div[1]/div[1]/section[2]/div/div/div[1]/ul[1]/li[3]/div/div[1]"
    );
    List<String> xpathIgnore = Arrays.asList(
      "//a[@aria-label=\"Visit LambdaTest homepage\"]"
      ,"//h2[text()=\"Quality Engineering Transformation by Experts\"]"
      ,"//p[text()=\"Browser Testing\"]/../.."
      ,"//h2[text()=\"Our Core Products\"]"
      ,"//h1[text()=\"Power Your Software Testing with\"]"
    );
    Map<String, Object> ignoreBoxesMap = new HashMap<>();
    Map<String, Object> selectBoxesMap = new HashMap<>();
    ignoreBoxesMap.put("xpath", xpathIgnore);
    selectBoxesMap.put("xpath", xpathSelect);
    Gson gson = new Gson();
    config.put("ignoreBoxes", gson.toJson(ignoreBoxesMap));
    config.put("selectBoxes", gson.toJson(selectBoxesMap));

    config.put("fullPage", "false");
    config.put("testType", "web");
    config.put("buildName","b12");

    smartUIAppSnapshot.start(startConfig);
    smartUIAppSnapshot.smartuiAppSnapshot(driver,"IosWeb", config);
    smartUIAppSnapshot.stop();

    driver.quit();

  }

}
