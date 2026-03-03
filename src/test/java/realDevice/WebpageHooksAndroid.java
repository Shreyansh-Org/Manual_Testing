package realDevice;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Objects;

public class WebpageHooksAndroid extends BaseClassRealDeviceAndroid{

  @Test
  public void minitab() throws InterruptedException {
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    driver.executeScript("smartui.takeFullPageScreenshot=rd-hook-android");
  }
}
