package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class config {

    //***************************Common config***********************

    public String projectName= "github-integration-demo-cli";
    public String ssName= "screenShot_01";
    public WebElement currElement;


    public static String generateRandomString(int length) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final SecureRandom RANDOM = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    //***************************Prod config*************************

    public Map<String,String> getProdConfig(){
        Map<String,String> prod = new HashMap<>();
        prod.put("hub","@hub.lambdatest.com/wd/hub");
        prod.put("mobileHub","@mobile-hub.lambdatest.com/wd/hub");
        prod.put("appId","lt://APP10104482111741290100293768");
        return prod;
    }

    //***************************Stage config************************

    public Map<String,String> getStageConfig(){
        Map<String,String> stage= new HashMap<>();
        stage.put("hub","@stage-hub.lambdatestinternal.com/wd/hub");
        stage.put("mobileHub","@stage-mobile-hub.lambdatestinternal.com/wd/hub");
        stage.put("appId","lt://APP10104571401742020049593650");
        return stage;
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

}
