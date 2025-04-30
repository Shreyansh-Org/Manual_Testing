package cli_SDK;

import Common.config;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseClassCliCloud extends config {

    //***************************************************************

    public RemoteWebDriver driver;
    public String githubURL = System.getenv("GITHUB_URL");

    @BeforeClass
    public void setup() throws MalformedURLException {

        Map<String,String> map= getStageConfig();

        String username = System.getenv("LT_USERNAME") == null
          ? "Your LT Username"
          : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null
          ? "Your LT AccessKey"
          : System.getenv("LT_ACCESS_KEY");
        String hub = map.get("hub");

        ChromeOptions browserOptions = new ChromeOptions();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", authkey);
        ltOptions.put("video", true);
        ltOptions.put("resolution", "1920x1080");
        ltOptions.put("network", true);
        ltOptions.put("build", "Build01");
        ltOptions.put("project", "Project01");
        ltOptions.put("smartUI.project", projectName);
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");
        browserOptions.setCapability("LT:Options", ltOptions);

        if (githubURL != null) {
            Map<String, String> github = new HashMap<String, String>();
            github.put("url",githubURL);
            browserOptions.setCapability("github", github);
        }
        System.out.println(browserOptions);
        String remoteUrl= "https://" + username + ":" + authkey + hub;
        System.out.println(remoteUrl);
        driver = new RemoteWebDriver(new URL(remoteUrl), browserOptions);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
