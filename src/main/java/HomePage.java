import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    private AndroidDriver<MobileElement> driver;
    @AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
    private MobileElement continueButtonElement;


    @AndroidFindBy(id="com.fivemobile.thescore:id/btn_disallow")
    private MobileElement disAllowElement;

    @AndroidFindBy(id="com.android.permissioncontroller:id/grant_dialog")
    private MobileElement allowNotificationElement;


    @AndroidFindBy(id= "com.fivemobile.thescore:id/action_button_text")
    private MobileElement doneButtonElement;

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_deny_button")
    private MobileElement notifDenyElement;

    @AndroidFindBy(id="com.fivemobile.thescore:id/dismiss_modal")
    private MobileElement dismissModalElement;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Leaders\")")
    private MobileElement leadersTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Team Stats\")")
    private MobileElement teamStatsTab;

    @AndroidFindBy(id= "com.fivemobile.thescore:id/search_bar_text_view")
    private MobileElement searchBar;
    public HomePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectFavLeague(String league){
        //Click on GetStarted button
        continueButtonElement.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MobileElement recyclerView = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.fivemobile.thescore:id/recyclerView\"))"));

        MobileElement item = recyclerView.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().textContains(\"" + league + "\")"));

        //Select the favourite league
        item.click();

        //Click on Continue button
        continueButtonElement.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        disAllowElement.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isLeagueSelected(String league) {
        // Implement verification that the page is opened
        String xpath = String.format("//android.widget.LinearLayout[@content-desc='%s']", league);
        MobileElement selectedFavLeagueElement = driver.findElement(By.xpath(xpath));
        selectedFavLeagueElement.click();
        if (selectedFavLeagueElement.isDisplayed())

            return true;
        else
            return false;

    }

    public void selectFavTeam(String league,String team){
        continueButtonElement.click();//GetStarted Button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        continueButtonElement.click();//Continue Button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        disAllowElement.click();//May be Later button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select specific league
        String xpath = String.format("//android.widget.LinearLayout[@content-desc='%s']", league);
        MobileElement selectedFavLeagueElement = driver.findElement(By.xpath(xpath));
        selectedFavLeagueElement.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        MobileElement el=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"" +team+ "\"]"));
        el.click();
        continueButtonElement.click();
        doneButtonElement.click();
        notifDenyElement.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dismissModalElement.click();
        log.info("Home Page is displayed with selected Team");
    }

    public void selectLeague(String league){
        //select Leagues option
        driver.findElementByAccessibilityId("Leagues").click();
        driver.findElement(By.id("com.fivemobile.thescore:id/header_right_text")).click();

        MobileElement leagueId=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/league_name_text\" and @text=\"" + league + "\"]"));
        leagueId.click();
        }

    public void openLeagueTeamPage(String league){
        String leagueTeamXpath = String.format("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/label\" and @text='%s']", league);
        MobileElement leagueTeamElement = driver.findElement(By.xpath(leagueTeamXpath));
        leagueTeamElement.click();
    }

    public SubTabPage goToLeadersTab(String subTab)  {
        leadersTab.click();
        MobileElement leadersElement = driver.findElement(By.xpath("//android.widget.TextView[@text=\"LEADERS\"]"));
        if(leadersElement.getText().equalsIgnoreCase(subTab)) {
            log.info("LEADERS tab is opened");
        }
        return new SubTabPage(driver);
    }

    public SubTabPage goToTeamStatsTab(String team){
        teamStatsTab.click();
        return new SubTabPage(driver);
    }



    public boolean isHomePageOpened() {
        //MobileElement favoritesTab = driver.findElementByAccessibilityId(Favorites);
        log.info("Home Page is opened with search bar and displayed League name and Team name ");
        return searchBar.isEnabled();
    }

}
