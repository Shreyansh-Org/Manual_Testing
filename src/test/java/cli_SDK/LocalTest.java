package cli_SDK;

import io.github.lambdatest.SmartUISnapshot;
import org.openqa.selenium.*;
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
    selectDOM.put("xpath", selectXpathSelectors);
//    selectDOM.put("elements",elements);
    selectOptions.put("selectDOM", selectDOM);

    Map<String, Object> ignoreOptions = new HashMap<>();
    ignoreOptions.put("sync",true);
    List<String> ignoreXpath = Arrays.asList(selectors);
    Map<String, Object> ignoreDOM = new HashMap<>();
    ignoreDOM.put("xpath", ignoreXpath);
//    ignoreDOM.put("elements", elements);
    ignoreOptions.put("ignoreDOM", ignoreDOM);

    SmartUISnapshot.smartuiSnapshot(driver, "ignoreSelect", selectOptions);
  }

  @Test
  public void localTunnel() throws Exception {
    driver.get("http://localhost:3000/");
    SmartUISnapshot.smartuiSnapshot(driver, "local_01");
  }

  @Test
  public void swagLabs() throws Exception {

    driver.get("https://www.saucedemo.com/v1/");
    String input = "//input[@id=\"user-name\"]";
    currElement = waitUntilElementIsPresent(driver, 5, input);
    currElement.sendKeys("standard_user");
    Map<String, Object> options = new HashMap<>();
    Map<String, Object> ignoreDOM = new HashMap<>();
    ignoreDOM.put("xpath", new String[] { "//input[@id='user-name']" });
    options.put("selectDOM", ignoreDOM);
    SmartUISnapshot.smartuiSnapshot(driver, "LoginPage", options);
    String password = "//input[@data-test=\"password\"]";
    currElement = waitUntilElementIsPresent(driver, 5, password);
    currElement.sendKeys("secret_sauce");
    String loginBtn = "//input[@id=\"login-button\"]";
    currElement = waitUntilElementIsPresent(driver, 5, loginBtn);
    currElement.click();
    SmartUISnapshot.smartuiSnapshot(driver, "HomePage", options);
    String cart = "//a[@href=\"./cart.html\"]";
    currElement = waitUntilElementIsPresent(driver, 5, cart);
    currElement.click();
    SmartUISnapshot.smartuiSnapshot(driver, "Cart");
    String sideNav = "//button[text()=\"Open Menu\"]";
    currElement = waitUntilElementIsPresent(driver, 5, sideNav);
    currElement.click();
    String aboutBtn = "//a[@id=\"about_sidebar_link\"]";
    currElement = waitUntilElementIsPresent(driver, 5, aboutBtn);
    Thread.sleep(3000);
    currElement.click();
    SmartUISnapshot.smartuiSnapshot(driver, "About");
    driver.get("https://ipinfo.io/");
    Thread.sleep(3000);
    Map<String, Object> ipInfoIgnoreDom = new HashMap<>();
    ipInfoIgnoreDom.put("xpath", new String[] { "//div[@id=\"api-requests\"]" });
    Map<String, Object> ipInfoOptions = new HashMap<>();
    ipInfoOptions.put("ignoreDOM", ipInfoIgnoreDom);
    SmartUISnapshot.smartuiSnapshot(driver, "ipInfo", ipInfoOptions);
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
  public void layout_01() throws Exception {
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
  public void manyUrls() throws Exception {
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm");
    driver.get("https://ipinfo.io/");
    SmartUISnapshot.smartuiSnapshot(driver, "Ip-info");
    driver.get("https://fast.com/");
    SmartUISnapshot.smartuiSnapshot(driver, "fast");
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm1");
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm2");
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm3");
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver, "TestI4");
    driver.get("https://demo.testim.io/login");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm5");
    driver.get("https://demo.testim.io/login");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm6");
    driver.get("https://demo.testim.io/login");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm7");
    driver.get("https://demo.testim.io/login");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm8");
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm9");
    driver.get("https://demo.testim.io/login");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm10");
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm11");
    driver.get("https://demo.testim.io/login");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm12");
    driver.get("https://demo.testim.io/login");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm13");
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm14");
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm15");
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver, "TestIm16");
    driver.get("https://ltqa-frontend.lambdatestinternal.com/dynamic-data-testing");
    SmartUISnapshot.smartuiSnapshot(driver, "`!\"#$%&'    ()*+,-./:;<=>?@[\\\\]^_\\`{|}~`; ");
    driver.get("https://demo.testim.io/");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_01");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_02");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_03");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_04");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_05");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_06");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_07");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_08");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_09");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_10");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_11");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_12");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_13");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_14");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_15");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_16");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_17");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_18");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_19");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_20");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_21");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_22");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_23");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_24");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_25");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_26");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_27");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_28");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_29");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_30");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_31");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_32");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_33");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_34");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_35");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_36");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_37");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_38");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_39");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_40");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_41");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_42");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_43");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_44");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_45");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_46");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_47");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_48");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_49");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_50");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_51");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_52");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_53");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_54");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_55");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_56");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_57");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_58");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_59");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_60");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_61");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_62");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_63");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_64");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_65");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_66");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_67");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_68");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_69");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_70");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_71");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_72");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_73");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_74");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_75");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_76");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_77");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_78");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_79");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_80");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_81");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_82");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_83");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_84");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_85");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_86");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_87");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_88");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_89");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_90");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_91");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_92");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_93");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_94");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_95");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_96");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_97");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_98");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_99");
    SmartUISnapshot.smartuiSnapshot(driver, "MultiSelect_100");
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
    config.put("element", locator);

    SmartUISnapshot.smartuiSnapshot(driver,"elementSnapshot",config);
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
