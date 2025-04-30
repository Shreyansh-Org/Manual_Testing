package realDevice;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import java.util.Map;


public class RealDeviceWebSnapshot {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        String prodAccessKey = "VwbQQouOr96dC0EI7uzHXIiXPzsn167YntkH0kOKdyuHttQlNi";
        String prodHub = "@mobile-hub.lambdatest.com/wd/hub";
        String prodAppName = "lt://APP10160471311738663046985118";
        String prodDeviceIos = "iPhone 11";
        String prodDeviceAndroid = "Galaxy S23+";

        String stageAccessKey = "pPo1zJArNnbmjlX533dkCskxhgV0onbsR0i7sdUcEHU3fgMjrH";
        String stageHub = "@mobile-hub-zeeshan-mobile-dev.lambdatestinternal.com/wd/hub";
        //String stageHub = "@stage-mobile-hub.lambdatestinternal.com/wd/hub";
        String stageAppName = "lt://APP10104401731739789386707496";
        String stageDeviceIos = "iPhone 12 Pro Max";
        String stageDeviceAndroid = "Pixel 5";
        boolean prodEnv = false;

        String userName = "zeeshans";
        String accessKey = prodEnv ? prodAccessKey : stageAccessKey;


        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("deviceName", prodEnv ? prodDeviceAndroid : stageDeviceAndroid);
//        ltOptions.put("deviceName", prodEnv ? prodDeviceIos : stageDeviceIos);
        ltOptions.put("isRealMobile", true);
        ltOptions.put("platformName", "Android");
        //ltOptions.put("platformName", "iOS");
        //ltOptions.put("build", "Java - Android-Web");
        ltOptions.put("name", "Sample Test Java-Android");
        ltOptions.put("w3c", true);
        ltOptions.put("video", true);
        ltOptions.put("visual", true);
        ltOptions.put("smartUI.project", "RealDeviceCodedRegion_01");
        capabilities.setCapability("lt:options", ltOptions);
        //capabilities.setCapability("autoWebview", true);

        AppiumDriver driver = new AppiumDriver(
                new URL("https://" + userName + ":" + accessKey + (prodEnv ? prodHub : stageHub)), capabilities);

        try {
            driver.get("https://ipinfo.io/");

            Thread.sleep(3000);

            Map<String, Object> config = new HashMap<>();
            config.put("fullPage", true);

            config.put("smartScroll", true);
            config.put("screenshotName", "ss-01");

            // Define the ignoreDOM property with CSS selectors
            Map<String, Object> ignoreDOM = new HashMap<>();
            ignoreDOM.put("xpath", new String[]{
                    "//div[@ RealDeviceCodedRegion_01]"
            });
            config.put("getDomBoxes", true);
            config.put("ignoreDOM", ignoreDOM);
            config.put("pageCount", 20);

            driver.executeScript("smartui.takeScreenshot",config);
            System.out.println("Screenshot Captured");
            driver.executeScript("lambda-status=passed");
        } catch (AssertionError a) {
            driver.executeScript("lambda-status=failed");
            a.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}