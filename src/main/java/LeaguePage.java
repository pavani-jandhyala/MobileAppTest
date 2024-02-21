import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeaguePage {
    private AndroidDriver<MobileElement> driver;
    private static final Logger log = LoggerFactory.getLogger(LeaguePage.class);


    public LeaguePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isLeaguePageOpened(){
        log.info("League Page is opened with Leagues ");
        Boolean leaguesTitle = driver.findElement(By.id("com.fivemobile.thescore:id/titleTextView")).getText().equalsIgnoreCase("Leagues");
        return leaguesTitle;
    }
}
