package cli_SDK;

import io.github.lambdatest.SmartUIResults;
import io.github.lambdatest.SmartUISnapshot;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.*;

public class CloudTest extends BaseClassCliCloud {

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
    // Fetch SmartUI results for this session
    System.out.println("Fetching SmartUI results for session...");
    Object sessionResults = SmartUIResults.smartuiResults(driver);
    System.out.println("Session Results: " + sessionResults);

    // Fetch SmartUI results for the entire build
    System.out.println("Fetching SmartUI results for build...");
    Object buildResults = SmartUIResults.smartuiResults();
    System.out.println("Build Results: " + buildResults);
  }

}
