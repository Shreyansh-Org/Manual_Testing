package webhook;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChromeTest extends BaseClassWebhook {

    @Test
    public void test01() throws InterruptedException {
        System.out.println("Loading Url");

        driver.get("https://www.lambdatest.com/");
        Thread.sleep(5000);

        driver.executeScript("smartui.takeScreenshot=home-page");
        Thread.sleep(1000);

        driver.get("https://www.lambdatest.com/pricing");
        Thread.sleep(5000);

        driver.executeScript("smartui.takeScreenshot=pricing-page");
        Thread.sleep(1000);

        driver.get("https://www.lambdatest.com/support/docs/");
        Thread.sleep(5000);
        driver.executeScript("smartui.takeScreenshot=docs");
        System.out.println("TestNGSmartUIChrome TestFinished");
    }

    @Test
    public void ipInfoFullPage(){

        Map<String, Object> options = new HashMap<>();

        List<String> selectCSSSelectors = Arrays.asList("h1.heading-h1");
        Map<String, List<String>> selectDOM = new HashMap<>();
        selectDOM.put("cssSelector", selectCSSSelectors);

        List<String> ignoreID = Arrays.asList("api-requests");
        List<String> ignoreCSSSelectors = Arrays.asList(".overflow-hidden section:first-of-type",".overflow-hidden section:nth-of-type(2)", "section:nth-of-type(6) .swiper", "section:nth-of-type(7) .swiper");
        Map<String, List<String>> ignoreDOM = new HashMap<>();
        ignoreDOM.put("id", ignoreID);
        ignoreDOM.put("cssSelector", ignoreCSSSelectors);

        options.put("selectDOM",selectDOM);
        options.put("ignoreDOM", ignoreDOM);
        options.put("fullPage",true);
        options.put("smartScroll",true);

        driver.get("https://ipinfo.io/");
        driver.executeScript("smartui.takeScreenshot=ss-01",options);
    }

    @Test
    public void ipInfo(){

        Map<String,List<String>> ignoreDOM= new HashMap<>();
        List<String> ignoreElements= Arrays.asList("h1.heading-h1");
        ignoreDOM.put("cssSelector",ignoreElements);

        Map<String,Object> options1= new HashMap<>();
        options1.put("ignoreDOM",ignoreDOM);

        Map<String,Object> options2= new HashMap<>();
        options2.put("ignoreDOM",ignoreDOM);
        options2.put("fullPage",true);

        Map<String,Object> options3= new HashMap<>();
        options3.put("ignoreDOM",ignoreDOM);
        options3.put("fullPage",true);
        options3.put("smartScroll",true);

        driver.get("https://ipinfo.io/");
        driver.executeScript("smartui.takeScreenshot=ss-01",options1);
        driver.executeScript("smartui.takeScreenshot=ss-02",options2);
        driver.executeScript("smartui.takeScreenshot=ss-03",options3);
    }

    @Test
    public void ipInfo1(){

        List<String> xpath = Arrays.asList("//div[@id=\"api-requests\"]");
        Map<String, List<String>> ignoreDOM = new HashMap<>();
        ignoreDOM.put("xpath", xpath);

        Map<String,Object> options1= new HashMap<>();
        options1.put("ignoreDOM",ignoreDOM);

        Map<String,Object> options2= new HashMap<>();
        options2.put("ignoreDOM",ignoreDOM);
        options2.put("fullPage",true);

        Map<String,Object> options3= new HashMap<>();
        options3.put("ignoreDOM",ignoreDOM);
        options3.put("fullPage",true);
        options3.put("smartScroll",true);

        driver.get("https://ipinfo.io/");
        driver.executeScript("smartui.takeScreenshot=ss-01",options1);
        driver.executeScript("smartui.takeScreenshot=ss-02",options2);
        driver.executeScript("smartui.takeScreenshot=ss-03",options3);
    }

    @Test
    public void ipInfo2(){
        Map<String, Object> config = new HashMap<>();
        config.put("fullPage", true);

        config.put("smartScroll", true);
        config.put("screenshotName", "ss-01");

        // Define the ignoreDOM property with CSS selectors
        Map<String, Object> ignoreDOM = new HashMap<>();
        ignoreDOM.put("xpath", new String[]{
                "//div[@id=\"api-requests\"]"
        });
        config.put("getDomBoxes", true);
        config.put("ignoreDOM", ignoreDOM);
        config.put("pageCount", 20);
        driver.get("https://ipinfo.io/");
        driver.executeScript("smartui.takeScreenshot=ss-01",config);
    }

    @Test
    public void ipinfo3(){
        driver.get("https://ipinfo.io/");
        driver.executeScript("smartui.takeScreenshot=sample-screenshot");
        driver.executeScript("smartui.takeScreenshot=sample-screenshot-1");
    }

    @Test
    public void ignoreSelectTesting(){

        Map<String,Object> options= new HashMap<>();
        Map<String,List<String>> ignoreDOM = new HashMap<>();
        List<String> ids= Arrays.asList("speed-value");
        ignoreDOM.put("id",ids);
        options.put("ignoreDOM",ignoreDOM);

        driver.get("https://fast.com/");
        driver.executeScript("smartui.takeScreenshot=ss-01",options);

    }

    @Test
    public void egifter(){

        Map<String,List<String>> ignoreDOM= new HashMap<>();
        List<String> cssSelectors= Arrays.asList(".h1");
        ignoreDOM.put("cssSelector",cssSelectors);

        Map<String,Object> options1= new HashMap<>();
        options1.put("ignoreDOM",ignoreDOM);

        Map<String,Object> options2= new HashMap<>();
        options2.put("ignoreDOM",ignoreDOM);
        options2.put("fullPage",true);

        Map<String,Object> options3= new HashMap<>();
        options3.put("ignoreDOM",ignoreDOM);
        options3.put("fullPage",true);
        options3.put("smartScroll",true);

        driver.get("https://hillcrest.oxfordgiftcardplus.ca/");
        driver.executeScript("smartui.takeScreenshot=ss-01",options1);
        driver.executeScript("smartui.takeScreenshot=ss-02",options2);
        driver.executeScript("smartui.takeScreenshot=ss-03",options3);

    }


}
