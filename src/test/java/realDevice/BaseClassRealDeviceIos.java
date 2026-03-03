package realDevice;

import Common.config;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BaseClassRealDeviceIos extends config {


  protected AppiumDriver<?> driver;

  @BeforeClass
  public void setup() throws MalformedURLException {

    Map<String,String> map= getProdConfig();

    String username = System.getenv("LT_USERNAME") == null
      ? "Your LT Username"
      : System.getenv("LT_USERNAME");
    String authkey = System.getenv("LT_ACCESS_KEY") == null
      ? "Your LT AccessKey"
      : System.getenv("LT_ACCESS_KEY");
    String hub = map.get("mobileHub");

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "ios");
    capabilities.setCapability("deviceName",".*");
//    capabilities.setCapability("platformVersion","");
//    capabilities.setCapability("app", map.get("appId"));
//    capabilities.setCapability("deviceOrientation", "landscape");
    capabilities.setCapability("smartUI.project", "Shreyansh_FullPageWeb_Ios");
    capabilities.setCapability("idleTimeout", 30);
    capabilities.setCapability("queueTimeout", 500);
    capabilities.setCapability("autoGrantPermissions", true);
    capabilities.setCapability("autoAcceptAlerts", true);
    capabilities.setCapability("isRealMobile", true);
    capabilities.setCapability("visual",true);

    String remoteUrl= "https://" + username + ":" + authkey + hub;
    System.out.println(remoteUrl);

    driver= new AppiumDriver<>(new URL(remoteUrl), capabilities);

  }

  @AfterClass
  public void tearDown(){
    driver.quit();
  }
}
