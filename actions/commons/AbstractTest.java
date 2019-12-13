package commons;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    public AndroidDriver driver;

    public AndroidDriver configPax(){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "21d5ac3d19037ece");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9");
        cap.setCapability("appPackage", "com.qupworld.pegasuspax");
        cap.setCapability("appActivity", "com.qup.pegasus.ui.launch.LauncherActivity");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability("skipDeviceInitialization", "false");
        cap.setCapability("skipServerInstallation", "false");
        cap.setCapability("noReset", "false");


        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        return driver;
    }
}
