package cli_SDK;

import Common.config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClassCliLocal extends config {

    WebDriver driver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--headless");  // Run in headless mode
        options.addArguments("--no-sandbox");  // Bypass OS security model
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("Chrome Driver initiated");

    }

    @AfterClass
    public void tearDown(){

        driver.quit();

    }

}
