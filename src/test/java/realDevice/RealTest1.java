package realDevice;

import io.github.lambdatest.SmartUIAppSnapshot;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RealTest1 extends BaseClassRealDevice {

    @Test
    public void test01() throws Exception{
        String build= "";
        String projectToken= "";
        String ssName= "ss-01";

        SmartUIAppSnapshot smartUIAppSnapshot= new SmartUIAppSnapshot();
        Map<String,String> config= new HashMap<>();
        config.put("projectToken", projectToken);
        config.put("buildName", build);
        config.put("deviceName", "iphone15");
//		config.put("platform","ios 11");

        Map<String,String> config1= new HashMap<>();
        config1.put("projectToken", projectToken);
        config1.put("buildName", build);
        config1.put("deviceName", "Samsung s21");
//		config1.put("platform","Android 12");

        Map<String,String> config2= new HashMap<>();
        config2.put("projectToken", projectToken);
        config2.put("buildName", build);
        config2.put("deviceName", "iphone16");
        config2.put("platform","ios 10");

        Map<String,String> config3= new HashMap<>();
        config3.put("projectToken", projectToken);
        config3.put("buildName", build);
        config3.put("deviceName", "Samsung s23");
        config3.put("platform","Android 9");

        smartUIAppSnapshot.start();
        smartUIAppSnapshot.smartuiAppSnapshot(driver,ssName,config);
        smartUIAppSnapshot.smartuiAppSnapshot(driver,ssName,config1);
        smartUIAppSnapshot.smartuiAppSnapshot(driver,ssName,config2);
        smartUIAppSnapshot.smartuiAppSnapshot(driver,ssName,config3);
        smartUIAppSnapshot.stop();
    }
}
