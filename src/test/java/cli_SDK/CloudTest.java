package cli_SDK;

import io.github.lambdatest.SmartUISnapshot;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.*;

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
        SmartUISnapshot.smartuiSnapshot(driver, "ignoreOptionsScreenshot01", ignoreOptions);
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

    @Test
    public void dynamicPage() throws Exception {
        Map<String,Object> config= new HashMap<>();
        config.put("approvalThreshold","");
        config.put("rejectionThreshold","");
        driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
        SmartUISnapshot.smartuiSnapshot(driver,"dynamicPage",config);
    }

    @Test
    public void veeva1() throws Exception {
        driver.get("https://www.lambdatest.com/");
        HashMap<String ,Object> config = new HashMap<>();
        config.put("sync",true);
        HashMap<String, String> locator = new HashMap<>();
        locator.put("xpath", "//*[@id='content']/div/div[2]/div/div[1]/section/div[1]/div/div/h2");
        config.put("element", locator);
        SmartUISnapshot.smartuiSnapshot(driver,"local");
    }

    @Test
    public void veeva2() throws Exception {
        driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
        HashMap<String ,Object> config = new HashMap<>();
        config.put("sync",true);
        config.put("timeout",30);
        JSONObject res= SmartUISnapshot.smartuiSnapshot(driver,"dynamicPage",config);
        System.out.println("RES: "+res);
    }

    @Test
    public void veeva3() throws Exception {
        driver.get("https://ltqa-frontend.lambdatestinternal.com/layout2");
        HashMap<String ,Object> config = new HashMap<>();
        config.put("sync",true);
        JSONObject res= SmartUISnapshot.smartuiSnapshot(driver,"layout",config);
        System.out.println("RES: "+res);
    }

  @Test
  public void ignoreSelect() throws Exception {

    driver.get("https://ltqa-frontend.lambdatestinternal.com/");

    String[] selectors= {"//h1","//*[@id=\"layout-rca-link--layout2\"]","//h2","//*[@id=\"live-interaction-button\"]","//*[@id=\"feature-security\"]","//*[@id=\"accessibility-link--partial-accessibility-compliance\"]"};
    List<WebElement> elements = new ArrayList<>(List.of());
    for (String selector : selectors) {
      elements.add(waitUntilElementIsPresent(driver, 10, selector));
    }

    Map<String, Object> selectOptions = new HashMap<>();
    selectOptions.put("sync",true);
    List<String> selectXpathSelectors = Arrays.asList(selectors);
    Map<String, Object> selectDOM = new HashMap<>();
    selectDOM.put("xpath", selectXpathSelectors);
    selectDOM.put("elements",elements);
    selectOptions.put("selectDOM", selectDOM);

    Map<String, Object> ignoreOptions = new HashMap<>();
    ignoreOptions.put("sync",true);
    List<String> ignoreXpath = Arrays.asList(selectors);
    Map<String, Object> ignoreDOM = new HashMap<>();
    ignoreDOM.put("xpath", ignoreXpath);
    ignoreDOM.put("elements", elements);
    ignoreOptions.put("ignoreDOM", ignoreDOM);

    driver.navigate().refresh();
    SmartUISnapshot.smartuiSnapshot(driver, "ipInfo_01", selectOptions);
    //    // Fetch SmartUI results for this session
    //    System.out.println("Fetching SmartUI results for session...");
    //    Object sessionResults = SmartUIResults.smartuiResults(driver);
    //    System.out.println("Session Results: " + sessionResults);
    //
    //    // Fetch SmartUI results for the entire build
    //    System.out.println("Fetching SmartUI results for build...");
    //    Object buildResults = SmartUIResults.smartuiResults();
    //    System.out.println("Build Results: " + buildResults);
  }

  @Test
  public void elementScreenshot() throws Exception {
    driver.get("https://www.gov.uk/");
    Map<String,Object> config = new HashMap<>();
    config.put("sync",true);
    HashMap<String, String> locator = new HashMap<>();
    //    locator.put("xpath", "//*[@id='content']/div/div[2]/div/div[1]/section/div[1]/div/div/h2");
    locator.put("xpath","//div");
    WebElement ele= driver.findElement(By.xpath("//div"));
    config.put("element", ele);

    SmartUISnapshot.smartuiSnapshot(driver,"elementSnapshot",config);
    //    // Fetch SmartUI results for this session
    //    System.out.println("Fetching SmartUI results for session...");
    //    Object sessionResults = SmartUIResults.smartuiResults(driver);
    //    System.out.println("Session Results: " + sessionResults);
    //
    //    // Fetch SmartUI results for the entire build
    //    System.out.println("Fetching SmartUI results for build...");
    //    Object buildResults = SmartUIResults.smartuiResults();
    //    System.out.println("Build Results: " + buildResults);
  }

}
