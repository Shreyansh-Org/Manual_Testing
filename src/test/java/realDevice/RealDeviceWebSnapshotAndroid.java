package realDevice;

import Common.config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import java.util.Map;


public class RealDeviceWebSnapshotAndroid extends config {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        String prodHub = "@mobile-hub.lambdatest.com/wd/hub";

        String stageHub = "@stage-mobile-hub.lambdatestinternal.com/wd/hub";
        boolean prodEnv = true;
        String device = "Pixel 7 Pro";

        String userName = "shreyanshc";
        String accessKey = "LT_WUaUMWBJGtWoVK1Kq1XKgwPDT8QnZsPFP4Ue93cz69dUMsU";
//        String buildName= generateRandomString(8);
        String buildName= device;
        String projectName= "RealDevice_03";


        DesiredCapabilities androidCapabilities = new DesiredCapabilities();
        Map<String, Object> ltAndroidOptions = new HashMap<>();
        ltAndroidOptions.put("deviceName", device);
        ltAndroidOptions.put("isRealMobile", true);
        ltAndroidOptions.put("platformName", "Android");
        ltAndroidOptions.put("name", "Sample Test Java-Android");
        ltAndroidOptions.put("w3c", true);
        ltAndroidOptions.put("video", true);
        ltAndroidOptions.put("visual", true);
        ltAndroidOptions.put("smartUI.project", projectName);
        ltAndroidOptions.put("smartUI.build", buildName);
        ltAndroidOptions.put("dedicatedProxy",true);
        androidCapabilities.setCapability("lt:options", ltAndroidOptions);
        androidCapabilities.setCapability("selenium_version", "4.8.0");

        String url= "https://" + userName + ":" + accessKey + (prodEnv ? prodHub : stageHub);

        AppiumDriver<MobileElement> androidDriver = new AppiumDriver<MobileElement>(
                new URL(url), androidCapabilities);

        try {
            androidDriver.get("https://qa.goldman.com/");

            WebElement currElement= waitUntilElementIsPresent(androidDriver,10,"//input[@data-target='user-id']");
            assert currElement != null;
            currElement.sendKeys("client5");
            currElement= waitUntilElementIsPresent(androidDriver,10,"//input[@class='form-control form-control-right-icon']");
            assert  currElement != null;
            currElement.sendKeys("simple123");
            currElement= waitUntilElementIsPresent(androidDriver,10,"//button[@type='submit']");
            assert currElement != null;
            currElement.click();

            Map<String, Object> config2 = new HashMap<>();
            config2.put("screenshotName", "ss-02");

            // Define the ignoreDOM property with CSS selectors
            Map<String, Object> ignoreDOM = new HashMap<>();
            ignoreDOM.put("xpath", new String[]{
                    "//div[@class='module-content module-content--plain ']","//div[@class='card square border rounded card-hover ']","//div[@class='d-lg-inline-block text-lg-left']"
            });
            config2.put("getDomBoxes", true);
            config2.put("ignoreDOM", ignoreDOM);

            Thread.sleep(10000);

            Map<String,Object> config1= new HashMap<>();
            config1.put("getDomBoxes", true);
            config1.put("ignoreDOM", ignoreDOM);
            config1.put("screenshotName","ss-01");

            androidDriver.executeScript("smartui.takeScreenshot",config1);

            androidDriver.executeScript("arguments[0].scrollIntoView(true);",waitUntilElementIsPresent(androidDriver,20,"//div[@class='d-lg-inline-block text-lg-left']"));

            Thread.sleep(10000);

            androidDriver.executeScript("smartui.takeScreenshot", config2);

            Thread.sleep(10000);

            System.out.println("Screenshot Captured");
            androidDriver.executeScript("lambda-status=passed");
        } catch (AssertionError a) {
            androidDriver.executeScript("lambda-status=failed");
            a.printStackTrace();
        } finally {
            androidDriver.quit();
        }
    }
}