package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class config {

    //***************************Common config***********************

    public String projectName= System.getenv("PROJECT")==null?"Web_project":System.getenv("PROJECT");
    public String ssName= "screenShot_01";
    public WebElement currElement;

    //***************************Prod config*************************

    public Map<String,String> getProdConfig(){
        Map<String,String> prod = new HashMap<>();
        prod.put("hub","@hub.lambdatest.com/wd/hub");
        prod.put("mobileHub","@mobile-hub.lambdatest.com/wd/hub");
        prod.put("appId","lt://APP10160192331760621657282881"); //SwagLabsAndroid
        return prod;
    }

    //***************************Stage config************************

    public Map<String,String> getStageConfig(){
        Map<String,String> stage= new HashMap<>();
        stage.put("hub","@stage-hub.lambdatestinternal.com/wd/hub");
        stage.put("mobileHub","@stage-mobile-hub.lambdatestinternal.com/wd/hub");
        stage.put("appId","lt://APP10104591941759912870527478"); //swagLabsAndroid
        return stage;
    }

    //***************************Dev config**************************

    public Map<String,String> getDevConfig(){
        Map<String,String> dev= new HashMap<>();
        dev.put("hub","@hub-selenium-version-dev.lambdatestinternal.com/wd/hub");
        dev.put("mobileHub","@mobile-hub-zsmobile-dev.lambdatestinternal.com/wd/hub");
        dev.put("appId","lt://APP1010431951753799108083772"); //MirrorIos
        return dev;
    }

    //***************************Common Functions************************

    public static WebElement waitUntilElementIsPresent(WebDriver driver, long time, String element){
        WebDriverWait wait= new WebDriverWait(driver,time);
        try{
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
        }catch(Exception ignored){
            return null;
        }
    }

    public static String generateRandomString(int length) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final SecureRandom RANDOM = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

  public void safeExecuteScript(RemoteWebDriver driver, String screenshotName, String script, Object args) {
    try {
      if (args != null) {
        driver.executeScript(script, args);
      } else {
        driver.executeScript(script);
      }
    } catch (Exception e) {
      System.out.println("Failed with screenshot name: " + screenshotName);
    }
  }


}
