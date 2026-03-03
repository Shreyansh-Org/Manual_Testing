package appSdk;

import Common.config;
import io.appium.java_client.ios.IOSDriver;
import io.github.lambdatest.SmartUIAppSnapshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LtMirrorIosTest {

  public static String userName = config.getUsername();
  public static String accessKey = config.getAccessKey();
  String projectToken= System.getenv("PROJECT_TOKEN")!=null?System.getenv("PROJECT_TOKEN"):"33627706#01K718DRADKDBR58CA56YYQC4Z#GS_page_count_issue";

  WebElement currElement;
  IOSDriver<?> driver;

  public final String btnRemindMeLater= "//*[@value=\"Remind Me Later\"]";
  public final String btnOptOut= "//*[@value=\"Opt Out\"]";


  @Test
  public void test() throws Exception {

    DesiredCapabilities caps = new DesiredCapabilities();
    Map<String, Object> ltOptions = new HashMap<>();
    ltOptions.put("deviceName", ".*");
    ltOptions.put("app", "lt://APP1016059531764154037775798");  // Enter your app url
    ltOptions.put("isRealMobile", true);
    ltOptions.put("platformName", "Ios");
    ltOptions.put("build", "Java - Ios");
    ltOptions.put("name", "Swag Labs Ios");
    ltOptions.put("w3c", true);
    ltOptions.put("autoGrantPermissions", true);
    caps.setCapability("lt:options", ltOptions);

    driver = new IOSDriver<>(
      new URL("https://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"), caps);

//    driver = new IOSDriver<>(
//      new URL("https://"+userName+":"+accessKey+"@stage-mobile-hub.lambdatestinternal.com/wd/hub"), caps);

    currElement= config.waitUntilElementIsPresent(driver,10,btnRemindMeLater);
    if(currElement != null){
      currElement.click();
    }
    currElement= config.waitUntilElementIsPresent(driver,10,btnOptOut);
    if(currElement != null){
      currElement.click();
    }

    config.staticWait(3000);

    SmartUIAppSnapshot smartUI= new SmartUIAppSnapshot();
    Map<String,String> config= new HashMap<>();
    config.put("projectToken", projectToken);
    config.put("deviceName","Test Device");
    config.put("fullPage","true");
    config.put("pageCount","25");
    config.put("uploadChunks","true");
    config.put("cropStatusBar","false");
    config.put("cropFooter","false");

    smartUI.start(config);
    smartUI.smartuiAppSnapshot(driver,"MirrorIos",config);
    smartUI.stop();

    driver.quit();

  }

  @Test
  public void error() throws Exception {

    SmartUIAppSnapshot smartUI= new SmartUIAppSnapshot();

    Map<String,String> config= new HashMap<>();
    config.put("projectToken", System.getenv("PROJECT_TOKEN")!=null?System.getenv("PROJECT_TOKEN"):"33627706#01K718DRADKDBR58CA56YYQC4Z#GS_page_count_issue");
    config.put("deviceName","Test Device");
    config.put("fullPage","true");
    config.put("pageCount","25");
    config.put("uploadChunks","true");
    config.put("cropStatusBar","false");
    config.put("cropFooter","false");

    smartUI.start(config);
    smartUI.stop();

    driver.quit();

  }

}
