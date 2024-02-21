import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubTabPage {
    private static final Logger log = LoggerFactory.getLogger(SubTabPage.class);
    private AndroidDriver<MobileElement> driver;

    public SubTabPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isLeaderDisplayed(String measure,String leader) {
        // Implement verification that the data is correct
        String id = "com.fivemobile.thescore:id/txt_category_name";
        String actualMeasureElement=driver.findElement(By.id(id)).getText();
        Boolean leaderFound=false;
        if(actualMeasureElement.equalsIgnoreCase(measure)){
            String resourceId = "com.fivemobile.thescore:id/big_leader_name";
            MobileElement leaderElement = driver.findElement(By.id(resourceId));
            String actualLeaderName= leaderElement.getText();
            // Verify if the actual leader name matches the expected leader name
            if (actualLeaderName.equalsIgnoreCase(leader)) {
                log.info("Leader found: " + actualLeaderName);
                leaderFound=true;
            } else {
                log.info("Leader not found. Expected: " + leader + ", Actual: " + actualLeaderName);
                leaderFound=false;
            }
        }
        return leaderFound;
    }

    public boolean isTeamStatsDisplayed(String measure) {
        // Implement verification that the data is correct
        MobileElement offensiveStatsElement = driver.findElement(By.xpath("//android.widget.TextView[@text='"+measure+"']"));
        String actualMeasure= offensiveStatsElement.getText();
        log.info("TEAM STATS page displayed");
        return actualMeasure.equalsIgnoreCase(measure);
    }

    public LeaguePage navigateLeaguesBack(){
        driver.navigate().back();
        log.info("Back to Leagues Page");
        return new LeaguePage(driver);

    }
    public HomePage navigateBack() {
        driver.navigate().back();
        log.info("Returned to home page");
        return new HomePage(driver);
    }
}
