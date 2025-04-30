package realDevice;

import org.testng.annotations.Test;

public class RealDeviceTest extends BaseClassRealDevice{

    @Test
    public void testOne(){
        driver.get("https://ipinfo.io/");
        driver.executeScript("smartui.takeScreenshot=ss-01");
    }

}
