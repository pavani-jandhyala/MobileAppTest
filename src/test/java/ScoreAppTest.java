import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ScoreAppTest extends BaseTest{

    @Test(dataProvider = "League", dataProviderClass = TestData.class)
    public void testFavLeagueData(String league,String team, String subTab,String measure,String leader) {

        HomePage homePage = new HomePage(driver);

        //Open Page and select favourite league
        homePage.selectFavLeague(league);
        //Open League Page
        homePage.openLeagueTeamPage(league);
        //Verify that the expected page opens correctly
        Assert.assertTrue(homePage.isLeagueSelected(league));
    }

    @Test(dataProvider = "LeagueTeam", dataProviderClass = TestData.class)
    public void testLeagueTeamData(String league,String team, String subTab,String measure,String leader)  {

        //Open Page and select favourite league
        HomePage homePage = new HomePage(driver);

        //Select favourite Team
        homePage.selectFavTeam(league,team);
        homePage.selectLeague(league);

        //Tap on a LEADERS sub-tab of League
        SubTabPage subTabPage = homePage.goToLeadersTab(subTab);

        // Verify that you are on the correct tab and that the data is displayed correctly
        Assert.assertTrue(subTabPage.isLeaderDisplayed(measure,leader));
        LeaguePage leaguePage=subTabPage.navigateLeaguesBack();
        Assert.assertTrue(leaguePage.isLeaguePageOpened());

    }


//
    @Test(dataProvider = "Team", dataProviderClass = TestData.class)
    public void testTeamData(String league,String team, String favTeam, String subTab,String measure){
        HomePage homePage = new HomePage(driver);
        homePage.selectFavTeam(league,team);
        //homePage.selectLeague(league);
        homePage.openLeagueTeamPage(favTeam);
        SubTabPage subTabPage = homePage.goToTeamStatsTab(subTab);
        //Verify TeamStats page displayed correctly
        //Assert.assertTrue(subTabPage.isTeamStatsDisplayed(measure));

        //Verify that back navigation returns you to the previous page correctly
        subTabPage.navigateBack();
        Assert.assertTrue(homePage.isHomePageOpened());

    }
}
