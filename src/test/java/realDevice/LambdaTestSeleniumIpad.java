package realDevice;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.safari.SafariOptions;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestSeleniumIpad {
    private static final String USERNAME = "shreyanshc";
    private static final String AUTHKEY = "LT_WUaUMWBJGtWoVK1Kq1XKgwPDT8QnZsPFP4Ue93cz69dUMsU";
    private static final String CLIENT_USERNAME = "client5";
    private static final String CLIENT_PASSWORD = "simple123";

    public static int getFullPageHeight(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return ((Long) js.executeScript("return Math.max(document.body.scrollHeight, document.body.offsetHeight, " +
                "document.documentElement.clientHeight, document.documentElement.scrollHeight, " +
                "document.documentElement.offsetHeight);")).intValue();
    }

    public static void maskElements(WebDriver driver,String[] elements){
        WebDriverWait wt= new WebDriverWait(driver,10);
        for(String curr:elements){
            WebElement currElement;
            currElement= wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(curr)));
            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.visibility = 'hidden';",currElement);
        }
    }

    public static void runBrowserTest(String browserName, MutableCapabilities browserOptions, Map<String, Object> caps) throws InterruptedException {
        for (Map.Entry<String, Object> entry : caps.entrySet()) {
            browserOptions.setCapability(entry.getKey(), entry.getValue());
        }
        browserOptions.setCapability("browserName", browserName);

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("https://" + USERNAME + ":" + AUTHKEY + "@hub.lambdatest.com/wd/hub"), browserOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }

        String url = "https://qa.goldman.com/";
        String ss_name = "gs-1";
        driver.get(url);

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement usernameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-target='user-id']")));
            System.out.println("Element found: " + usernameElement.getAttribute("outerHTML"));
            usernameElement.sendKeys(CLIENT_USERNAME);

            WebElement passwordElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='form-control form-control-right-icon']")));
            System.out.println("Password element found: " + passwordElement.getAttribute("outerHTML"));
            passwordElement.sendKeys(CLIENT_PASSWORD);

            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            System.out.println("Submit button found: " + submitButton.getAttribute("outerHTML"));
            submitButton.click();

            Thread.sleep(15000);
            int height = getFullPageHeight(driver);
            System.out.println("height " + height);
            driver.manage().window().maximize();
//            driver.manage().window().setSize(new Dimension(768, 1024));
            Thread.sleep(5000);
            driver.navigate().refresh();
            Thread.sleep(20000);
        } catch (Exception e) {
            System.out.println("Error finding element: " + e.getMessage());
        }

        Map<String, Object> screenshotOptions = new HashMap<>();
        screenshotOptions.put("screenshotName", ss_name);

        Map<String, Object> ignoreDom = new HashMap<>();
        ignoreDom.put("xpath", new String[]{
                "//div[@class='module-content module-content--plain ']","//div[@class='card square border rounded card-hover ']","//div[@class='global-footer']/div"
        });

        screenshotOptions.put("ignoreDOM", ignoreDom);
        screenshotOptions.put("smartScroll", true);


        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        maskElements(driver,new String[]{"//div[@class='module-content module-content--plain ']","//div[@class='d-lg-inline-block text-lg-left']"});
//        js.executeScript("window.scrollTo(0,0);");
        int height = getFullPageHeight(driver);
        driver.manage().window().setSize(new Dimension(768, 1024));
        Thread.sleep(10000);

        Object response = js.executeScript("smartui.takeScreenshot", screenshotOptions);
        System.out.println(response);

        System.out.println("Test Completed");
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        Map<String, Object> caps = new HashMap<>();
        caps.put("platform", "MacOS Catalina");
        caps.put("version", "latest");
        caps.put("build", "TestNG With Java");
        caps.put("name", "basic-test");
        caps.put("smartUI.project", "emulation-boxes-390-parth-4");
        caps.put("selenium_version", "4.0.0");
        caps.put("dedicatedProxy", true);

        runBrowserTest("safari", new SafariOptions(), caps);
    }
}
