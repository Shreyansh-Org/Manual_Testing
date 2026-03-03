package realDevice;

import Common.config;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BaseClassRealDeviceAndroid extends config {


    protected AppiumDriver<?> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {

        Map<String,String> map= getProdConfig();

        String username = getUsername();
        String authkey = getAccessKey();
        String hub = map.get("mobileHub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName",".*");
//        capabilities.setCapability("platformVersion","15");
//        capabilities.setCapability("deviceOrientation", "landscape");
//        capabilities.setCapability("app", map.get("appId"));
        capabilities.setCapability("smartUI.project", projectName);
//        capabilities.setCapability("smartUI.build","b1");
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
