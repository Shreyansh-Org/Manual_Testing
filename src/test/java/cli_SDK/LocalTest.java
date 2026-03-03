package cli_SDK;

import io.github.lambdatest.SmartUIResults;
import io.github.lambdatest.SmartUISnapshot;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.*;

public class LocalTest extends BaseClassCliLocal {

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
//    selectDOM.put("xpath", selectXpathSelectors);
    selectDOM.put("elements",elements);
    selectOptions.put("selectDOM", selectDOM);

    Map<String, Object> ignoreOptions = new HashMap<>();
    ignoreOptions.put("sync",true);
    List<String> ignoreXpath = Arrays.asList(selectors);
    Map<String, Object> ignoreDOM = new HashMap<>();
//    ignoreDOM.put("xpath", ignoreXpath);
    ignoreDOM.put("elements", elements);
    ignoreOptions.put("ignoreDOM", ignoreDOM);

    SmartUISnapshot.smartuiSnapshot(driver, "ignoreSelect", selectOptions);
    // Fetch SmartUI results for this session
    System.out.println("Fetching SmartUI results for session...");
    Object sessionResults = SmartUIResults.smartuiResults(driver);
    System.out.println("Session Results: " + sessionResults);

    // Fetch SmartUI results for the entire build
    System.out.println("Fetching SmartUI results for build...");
    Object buildResults = SmartUIResults.smartuiResults();
    System.out.println("Build Results: " + buildResults);
  }

  @Test
  public void localTunnel() throws Exception {
    driver.get("http://localhost:3000/");
    SmartUISnapshot.smartuiSnapshot(driver, "local_01");
  }

  @Test
  public void expiredBadSsl() throws Exception {
    driver.get("https://expired.badssl.com/");
    SmartUISnapshot.smartuiSnapshot(driver,"ss-01");
  }

  @Test
  public void longSsName() throws Exception {

    driver.get("https://www.saucedemo.com/v1/");
    String input = "//input[@id=\"user-name\"]";
    currElement = waitUntilElementIsPresent(driver, 5, input);
    currElement.sendKeys("654321");
    Map<String, Object> options = new HashMap<>();
    Map<String, Object> ignoreDOM = new HashMap<>();
    ignoreDOM.put("xpath", new String[] { "//input[@id='user-name']" });
    options.put("selectDOM", ignoreDOM);
    SmartUISnapshot.smartuiSnapshot(driver, generateRandomString(450), options);
    SmartUISnapshot.smartuiSnapshot(driver, generateRandomString(460), options);
    SmartUISnapshot.smartuiSnapshot(driver, generateRandomString(452), options);
    SmartUISnapshot.smartuiSnapshot(driver, generateRandomString(454), options);
    SmartUISnapshot.smartuiSnapshot(driver, generateRandomString(480), options);
    SmartUISnapshot.smartuiSnapshot(driver, generateRandomString(430), options);
    SmartUISnapshot.smartuiSnapshot(driver, generateRandomString(450), options);
    SmartUISnapshot.smartuiSnapshot(driver, generateRandomString(451), options);
    SmartUISnapshot.smartuiSnapshot(driver, generateRandomString(440), options);
    SmartUISnapshot.smartuiSnapshot(driver, generateRandomString(460), options);
    SmartUISnapshot.smartuiSnapshot(driver, generateRandomString(480), options);
    SmartUISnapshot.smartuiSnapshot(driver, generateRandomString(420), options);

  }

  @Test
  public void layout() throws Exception {
    driver.get("https://in.pinterest.com/");
    Map<String, Object> config = new HashMap<>();
    config.put("ignoreType", new String[] { "layout" });
    SmartUISnapshot.smartuiSnapshot(driver, "Pinterest", config);
  }

  @Test
  public void testIm() throws Exception {
    Map<String, Object> ignoreOptions = new HashMap<>();
    List<String> ignoreID = Arrays.asList("time-value");
    Map<String, List<String>> ignoreDOM = new HashMap<>();
    ignoreDOM.put("id", ignoreID);
    ignoreOptions.put("ignoreDOM", ignoreDOM);
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver, "dynamic-page",ignoreOptions);
  }

  @Test
  public void checkBrowserVersion() throws Exception {
    driver.get("https://demo.testim.io/login");
    SmartUISnapshot.smartuiSnapshot(driver, "Version");
  }

  @Test
  public void responsiveDom() throws Exception {
    driver.get("https://www.racv.com.au/travel-experiences/resorts.html");
    Objects.requireNonNull(waitUntilElementIsPresent(driver, 10, "//input[@id='daterange-picker']")).click();
    SmartUISnapshot.smartuiSnapshot(driver,"racv");

    driver.manage().window().setSize(new Dimension(360,720));
    Thread.sleep(10000);
    Map<String, Object> innerMap = new HashMap<>();
    innerMap.put("devices", Arrays.asList("iPhone 14", "Galaxy S23"));
    innerMap.put("fullPage", true);
    innerMap.put("orientation", "portrait");

    // Outer map with key "mobile"
    Map<String, Object> outerMap = new HashMap<>();
    outerMap.put("mobile", innerMap);
    SmartUISnapshot.smartuiSnapshot(driver,"racv",outerMap);
  }

  @Test
  public void elementScreenshot() throws Exception {
    driver.get("https://www.gov.uk/");
    Map<String,Object> config = new HashMap<>();
    config.put("sync",true);
    HashMap<String, String> locator = new HashMap<>();
    locator.put("xpath", "//*[@id='content']/div/div[2]/div/div[1]/section/div[1]/div/div/h2");
//    locator.put("xpath","//div");
    WebElement ele= driver.findElement(By.xpath("//div"));
    config.put("element", ele);

    SmartUISnapshot.smartuiSnapshot(driver,"elementSnapshot",config);
    // Fetch SmartUI results for this session
    System.out.println("Fetching SmartUI results for session...");
    Object sessionResults = SmartUIResults.smartuiResults(driver);
    System.out.println("Session Results: " + sessionResults);

    // Fetch SmartUI results for the entire build
    System.out.println("Fetching SmartUI results for build...");
    Object buildResults = SmartUIResults.smartuiResults();
    System.out.println("Build Results: " + buildResults);
  }

  @Test
  public void slowLoadingPage() throws Exception {
    driver.get("https://www.lambdatest.com/");
    HashMap<String,Object> config = new HashMap<>();

    Map<String, Object> selectOptions = new HashMap<>();
    List<String> selectCSSSelectors = List.of("time-valuekfnkfn");
    Map<String, List<String>> selectDOM = new HashMap<>();
    selectDOM.put("id", selectCSSSelectors);
    selectOptions.put("selectDOM", selectDOM);

    SmartUISnapshot.smartuiSnapshot(driver,"slow",selectOptions);
  }

  @Test
  public void quickScrollToBottom() throws InterruptedException {
    long lastHeight = ((Number) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight")).longValue();
    while (true) {
      ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
      Thread.sleep(2000);

      long newHeight = ((Number) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight")).longValue();
      if (newHeight == lastHeight) {
        break;
      }
      lastHeight = newHeight;
    }
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    Thread.sleep(1000); // wait for 1 second
  }

  @Test
  public void screenshotThreashold() throws Exception {
    Map<String,Object> config= new HashMap<>();
    config.put("approvalThreshold",0);
    config.put("rejectionThreshold",0.01);
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver,"dynamicPage",config);
  }

}
