package webhook;

import Common.config;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseClassWebhook extends config {

    //***************************************************************

    public RemoteWebDriver driver;
    public String githubURL = System.getenv("GITHUB_URL");

    @BeforeClass
    public void setup() throws MalformedURLException {

        Map<String,String> map= getStageConfig();

        String username = getUsername();
        String authkey = getAccessKey();
        String hub = map.get("hub");

        DesiredCapabilities browserOptions = new DesiredCapabilities();
        browserOptions.setCapability("browserName", "safari");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", authkey);
        ltOptions.put("platform","macos sonoma");
//        ltOptions.put("fixedIP","10.244.36.216");
        ltOptions.put("project", projectName);
        ltOptions.put("smartUI.project", projectName);
//        ltOptions.put("smartUI.build","b1");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "testNG-testNG");
//        ltOptions.put("tunnel",true);
        browserOptions.setCapability("lt:options", ltOptions);
        browserOptions.setCapability("selenium_version", "4.8.0");

        if (githubURL != null) {
            Map<String, String> github = new HashMap<String, String>();
            github.put("url",githubURL);
            browserOptions.setCapability("github", github);
            System.out.println("Github url Received successfully : "+githubURL);
        }

        String remoteUrl= "https://" + username + ":" + authkey + hub;
        System.out.println(remoteUrl);
        driver = new RemoteWebDriver(new URL(remoteUrl), browserOptions);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
