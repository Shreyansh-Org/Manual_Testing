package realDevice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import java.util.Map;


public class RealDeviceWebSnapshotAndroidFinal {

    private static final String USERNAME = "shreyanshc";
    private static final String AUTHKEY = "LT_WUaUMWBJGtWoVK1Kq1XKgwPDT8QnZsPFP4Ue93cz69dUMsU";
    private static final String CLIENT_USERNAME = "client5";
    private static final String CLIENT_PASSWORD = "simple123";

    public static WebElement waitUntilElementIsPresent(WebDriver driver, long time, String element){
        WebDriverWait wait= new WebDriverWait(driver,time);
        try{
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
        }catch(Exception ignored){
            return null;
        }
    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        String prodHub = "@mobile-hub.lambdatest.com/wd/hub";
        String projectName= "RealDevice_03";


        DesiredCapabilities androidCapabilities = new DesiredCapabilities();
        Map<String, Object> ltAndroidOptions = new HashMap<>();
        ltAndroidOptions.put("deviceName", "Pixel 9 Pro XL");
        ltAndroidOptions.put("isRealMobile", true);
        ltAndroidOptions.put("platformName", "Android");
        ltAndroidOptions.put("name", "Sample Test Java-Android");
        ltAndroidOptions.put("w3c", true);
        ltAndroidOptions.put("video", true);
        ltAndroidOptions.put("visual", true);
        ltAndroidOptions.put("smartUI.project", projectName);
        ltAndroidOptions.put("dedicatedProxy",true);
        androidCapabilities.setCapability("lt:options", ltAndroidOptions);
        androidCapabilities.setCapability("selenium_version", "4.8.0");

        String url= "https://" + USERNAME + ":" + AUTHKEY + prodHub;

        AppiumDriver<MobileElement> androidDriver = new AppiumDriver<MobileElement>(
                new URL(url), androidCapabilities);

        try {
            androidDriver.get("https://qa.goldman.com/");

            WebElement currElement= waitUntilElementIsPresent(androidDriver,10,"//input[@data-target='user-id']");
            assert currElement != null;
            currElement.sendKeys(CLIENT_USERNAME);
            currElement= waitUntilElementIsPresent(androidDriver,10,"//input[@class='form-control form-control-right-icon']");
            assert  currElement != null;
            currElement.sendKeys(CLIENT_PASSWORD);
            currElement= waitUntilElementIsPresent(androidDriver,10,"//button[@type='submit']");
            assert currElement != null;
            currElement.click();

            Map<String, Object> config = new HashMap<>();
            config.put("screenshotName", "ss-02");
            Map<String, Object> ignoreDOM = new HashMap<>();
            ignoreDOM.put("xpath", new String[]{
                    "//div[@class='module-content module-content--plain ']","//div[@class='card square border rounded card-hover ']","//div[@class='d-lg-inline-block text-lg-left']"
            });
            config.put("getDomBoxes", true);
            config.put("ignoreDOM", ignoreDOM);

            Thread.sleep(20000);

            Map<String,Object> config1= new HashMap<>();
            config1.put("getDomBoxes", true);
            config1.put("ignoreDOM", ignoreDOM);
            config1.put("screenshotName","ss-01");

            androidDriver.executeScript("smartui.takeScreenshot",config1);

            androidDriver.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            Thread.sleep(10000);
            WebDriverWait wait = new WebDriverWait(androidDriver, 10);
            WebElement maskElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='d-lg-inline-block text-lg-left']")));
            androidDriver.executeScript("arguments[0].style.visibility = 'hidden';",maskElement);

            androidDriver.executeScript("smartui.takeScreenshot", config);

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