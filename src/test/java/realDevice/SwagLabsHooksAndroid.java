package realDevice;

import org.testng.annotations.Test;

import java.util.HashMap;

public class  SwagLabsHooksAndroid extends BaseClassRealDeviceAndroid {

  public final String inputUsername = "//*[@content-desc=\"test-Username\"]"; //standard_user
  public final String inputPassword = "//*[@content-desc=\"test-Password\"]"; //secret_sauce
  public final String btnLogin = "//*[@content-desc=\"test-LOGIN\"]";

  @Test
  public void test() throws Exception {

    HashMap<String, Object> ignoreDOM = new HashMap<>();
    ignoreDOM.put("xpath",new String[] {"//*[@content-desc=\"test-LOGIN\"]"});

    HashMap<String, Object> config = new HashMap<>();
    config.put("screenshotName", "SwagLabs_Android");
//    config.put("fullPage", true);
    config.put("getDomBoxes", false);
//    config.put("headerHeight",500);
    config.put("ignoreDOM", ignoreDOM);

    driver.executeScript("smartui.takeScreenshot",config);
  }

}
