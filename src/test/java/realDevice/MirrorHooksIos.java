package realDevice;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class MirrorHooksIos extends BaseClassRealDeviceIos {

  public final String btnRemindMeLater= "//*[@value=\"Remind Me Later\"]";
  public final String btnOptOut= "//*[@value=\"Opt Out\"]";

  @Test
  public void test() throws Exception {

    currElement= waitUntilElementIsPresent(driver,10,btnRemindMeLater);
    if (currElement != null) {
      currElement.click();
    } else {
      System.out.println("skipped");
    }
    currElement= waitUntilElementIsPresent(driver,10,btnOptOut);
    if (currElement != null) {
      currElement.click();
    } else {
      System.out.println("skipped");
    }

    Thread.sleep(3000);

    HashMap<String,Object> config= new HashMap<>();
    config.put("screenshotName", "Mirror_ios");
    config.put("fullPage", true);
    config.put("uploadChunks", true);

    Map<String, Object> ignoreDOM = new HashMap<>();
    Map<String, Object> selectDOM = new HashMap<>();

    selectDOM.put("xpath", new String[]{
      "//*[@text=\"QAapp\"]",
    });

    ignoreDOM.put("name", new String[]{
      "navigation_myNews_tab",
      "//*[@name=\"homeFeed_teaser_cell_1\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[1]/*[1]/*[@type=\"XCUIElementTypeImage\"]",
      "//*[@name=\"homeFeed_teaser_cell_1\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]",
      "//*[@name=\"Tab Bar\"]"
    });

    config.put("getDomBoxes", true);
    config.put("ignoreDOM", ignoreDOM);
    //    config.put("selectDOM", selectDOM);

    driver.executeScript("smartui.takeScreenshot",config);

  }
}
