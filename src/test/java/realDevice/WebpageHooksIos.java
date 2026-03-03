package realDevice;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Objects;

public class WebpageHooksIos extends BaseClassRealDeviceIos{

  @Test
  public void webFullPage() throws InterruptedException {
    driver.get("https://ltqa-frontend.lambdatestinternal.com/");
    Thread.sleep(10000);
    driver.executeScript("smartui.takeFullPageScreenshot=webFullPage");
  }

  @Test
  public void minitab() throws InterruptedException {
    driver.get("https://www.minitab.com/en-us/?otgeo=us%5C%5C%5C%5Cu0026mboxOverride.browserIp=3.247.255.255");
    Objects.requireNonNull(waitUntilElementIsPresent(driver, 10, "//button[@id=\"onetrust-accept-btn-handler\"]")).click();
    Thread.sleep(10000);
    HashMap<String,Object> config= new HashMap<>();
    config.put("headerHeight", 350);
    config.put("uploadChunks",true);
    config.put("pageCount",20);
    config.put("swipeHeight", 5);
    config.put("footerHeight", 350);
    driver.executeScript("smartui.takeFullPageScreenshot=minitab",config);
  }

}
