package realDevice;

import org.testng.annotations.Test;

import java.util.HashMap;

public class SwagLabsHooksIos extends BaseClassRealDeviceIos {

  @Test
  public void test(){
    driver.get("https://ipinfo.io/");
    HashMap<String,Object> config= new HashMap<>();
    config.put("screenshotName", "ip-info");
    config.put("fullPage",true);
    driver.executeScript("smartui.takeScreenshot",config);
  }
}
