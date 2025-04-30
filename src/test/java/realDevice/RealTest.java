package realDevice;

import io.github.lambdatest.SmartUIAppSnapshot;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RealTest extends BaseClassRealDevice {

    @Test
    public void test01() throws Exception{
        String build= "Build01";
        String projectToken= "33627706#3268ec0a-ed28-4d8f-98f2-ff6e0e4447fc#GS_12";
        String ssName= "ss-02";

        SmartUIAppSnapshot smartUIAppSnapshot= new SmartUIAppSnapshot();

        Map<String,String> startConfig= new HashMap<>();
        startConfig.put("projectToken",projectToken);

        Map<String,String> ssConfig1 = new HashMap<>();
        ssConfig1.put("deviceName","Google pixel 9");
        ssConfig1.put("platform","");

        Map<String,String> ssConfig2 = new HashMap<>();
        ssConfig2.put("deviceName","Google pixel 8");
        ssConfig2.put("platform","");

        Map<String,String> ssConfig3 = new HashMap<>();
        ssConfig3.put("deviceName","iPhone 15");
        ssConfig3.put("platform","");

        Map<String,String> ssConfig4 = new HashMap<>();
        ssConfig4.put("deviceName","iPhone 16");
        ssConfig4.put("platform","");

        Map<String,String> ssConfig5 = new HashMap<>();
        ssConfig5.put("deviceName","Samsung s24");
        ssConfig5.put("platform","");

        Map<String,String> ssConfig6 = new HashMap<>();
        ssConfig6.put("deviceName","Samsung s21");
        ssConfig6.put("platform","");

        smartUIAppSnapshot.start(startConfig);
        smartUIAppSnapshot.smartuiAppSnapshot(driver,ssName, ssConfig1);
        smartUIAppSnapshot.smartuiAppSnapshot(driver,ssName,ssConfig2);
        smartUIAppSnapshot.smartuiAppSnapshot(driver,ssName,ssConfig3);
        smartUIAppSnapshot.smartuiAppSnapshot(driver,ssName,ssConfig4);
        smartUIAppSnapshot.smartuiAppSnapshot(driver,ssName,ssConfig5);
        smartUIAppSnapshot.smartuiAppSnapshot(driver,ssName,ssConfig6);
        smartUIAppSnapshot.stop();
    }
}
