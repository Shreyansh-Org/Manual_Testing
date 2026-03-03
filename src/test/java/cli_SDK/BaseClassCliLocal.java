package cli_SDK;

import Common.config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClassCliLocal extends config {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("3.214.241.254:5432");
        proxy.setSslProxy("3.214.241.254:5432");
//        options.setProxy(proxy);
//        options.addArguments("--headless");  // Run in headless mode
//        options.addArguments("--no-sandbox");  // Bypass OS security model
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("Chrome Driver initiated");

    }

    @AfterMethod
    public void tearDown(){

        driver.quit();

    }

}
