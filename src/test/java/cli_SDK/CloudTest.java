package cli_SDK;

import io.github.lambdatest.SmartUISnapshot;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloudTest extends BaseClassCliCloud {

    @Test
    public void test1() throws Exception {
        Map<String, Object> ignoreOptions = new HashMap<>();
        List<String> ignoreID = Arrays.asList("api-requests");
        List<String> ignoreCSSSelectors = Arrays.asList(".overflow-hidden section:first-of-type",
                ".overflow-hidden section:nth-of-type(2)", "section:nth-of-type(6) .swiper", "section:nth-of-type(7) .swiper");
        Map<String, List<String>> ignoreDOM = new HashMap<>();
        ignoreDOM.put("id", ignoreID);
        ignoreDOM.put("cssSelector", ignoreCSSSelectors);
        ignoreOptions.put("ignoreDOM", ignoreDOM);

        Map<String, Object> selectOptions = new HashMap<>();
        List<String> selectID = Arrays.asList("api-requests");
        List<String> selectCSSSelectors = Arrays.asList("h1.heading-h1");
        Map<String, List<String>> selectDOM = new HashMap<>();
        selectDOM.put("cssSelector", selectCSSSelectors);
        selectDOM.put("id",selectID);
        selectOptions.put("selectDOM", selectDOM);

        System.out.println("Loading Url");
        driver.get("https://ipinfo.io/");
        SmartUISnapshot.smartuiSnapshot(driver, "ignoreOptionsScreenshot", ignoreOptions);
        Thread.sleep(2000);
        SmartUISnapshot.smartuiSnapshot(driver, "selectOptionsScreenshot", selectOptions);
        Thread.sleep(1000);
        System.out.println("Test Finished");
    }

    @Test
    public void test2() throws Exception {
        Map<String, Object> ignoreOptions = new HashMap<>();
        List<String> ignoreCSSSelectors = Arrays.asList(".speed-results-container");
        Map<String, List<String>> ignoreDOM = new HashMap<>();
        ignoreDOM.put("cssSelector", ignoreCSSSelectors);
        ignoreOptions.put("ignoreDOM", ignoreDOM);

        Map<String, Object> selectOptions = new HashMap<>();
        List<String> selectCSSSelectors = Arrays.asList(".speed-results-container");
        Map<String, List<String>> selectDOM = new HashMap<>();
        selectDOM.put("cssSelector", selectCSSSelectors);
        selectOptions.put("selectDOM", selectDOM);

        System.out.println("Loading Url");
        driver.get("https://fast.com/");
        Thread.sleep(3000);
        SmartUISnapshot.smartuiSnapshot(driver, "ignoreOptionsScreenshot", ignoreOptions);
        Thread.sleep(2000);
        SmartUISnapshot.smartuiSnapshot(driver, "selectOptionsScreenshot", selectOptions);
        Thread.sleep(1000);
        System.out.println("Test Finished");
    }

    @Test
    public void test3() throws Exception {
        Map<String, Object> ignoreOptions = new HashMap<>();
        List<String> ignoreCSSSelectors = Arrays.asList("h2");
        Map<String, List<String>> ignoreDOM = new HashMap<>();
        ignoreDOM.put("cssSelector", ignoreCSSSelectors);
        ignoreOptions.put("ignoreDOM", ignoreDOM);

        Map<String, Object> selectOptions = new HashMap<>();
        List<String> selectCSSSelectors = Arrays.asList("h2");
        Map<String, List<String>> selectDOM = new HashMap<>();
        selectDOM.put("cssSelector", selectCSSSelectors);
        selectOptions.put("selectDOM", selectDOM);

        System.out.println("Loading Url");
        driver.get("https://bsky-users.theo.io/");
        Thread.sleep(3000);
        SmartUISnapshot.smartuiSnapshot(driver, "ignoreOptionsScreenshot", ignoreOptions);
        Thread.sleep(2000);
        SmartUISnapshot.smartuiSnapshot(driver, "selectOptionsScreenshot", selectOptions);
        Thread.sleep(1000);
        System.out.println("Test Finished");
    }

    @Test
    public void test4() throws Exception {
        driver.get("https://worlds-highest-website.com/");
        SmartUISnapshot.smartuiSnapshot(driver, "ignoreOptionsScreenshot");
    }

    @Test
    public void cloudTunnel() throws Exception {
        driver.get("http://localhost:5173/");
        SmartUISnapshot.smartuiSnapshot(driver,"Tunnel_01");
        Thread.sleep(3000);
    }

    @Test
    public void swagLabs() throws Exception {

        driver.get("https://www.saucedemo.com/v1/");
        String input= "//input[@id=\"user-name\"]";
        currElement= waitUntilElementIsPresent(driver,5,input);
        currElement.sendKeys("654321");
        Map<String,Object> options= new HashMap<>();
        Map<String,Object> ignoreDOM= new HashMap<>();
        ignoreDOM.put("xpath",new String[]{"//input[@id='user-name']"});
        options.put("ignoreDOM",ignoreDOM);
        SmartUISnapshot.smartuiSnapshot(driver,"ss-01",options);

    }

    @Test
    public void localTunnel() throws Exception {
        driver.get("http://localhost:3001/");
        Thread.sleep(3000);
        SmartUISnapshot.smartuiSnapshot(driver,"local_01");
    }

}
