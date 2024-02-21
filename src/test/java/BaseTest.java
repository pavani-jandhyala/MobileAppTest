import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected AndroidDriver<MobileElement> driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability("deviceName", "OnePlus CPH2401 API 33");
        capabilities.setCapability("udid","DAPVON7DW8TGVCB6");
        capabilities.setCapability("appPackage", "com.fivemobile.thescore");
        capabilities.setCapability("appActivity", "com.fivemobile.thescore.ui.MainActivity");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("autoDismissAlerts", true);
        //capabilities.setCapability("autoAcceptAlerts", true);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //@After Method
    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
