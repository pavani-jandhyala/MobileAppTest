import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "League")
    public Object[][] getLeagueData() {
        return new Object[][] {
                {"NFL"},
                {"NHL"}
                //{"NFL","Buffalo Bills", "LEADERS", "Passing Yards", "T. Tagovailoa"},
//                {"NHL","Boston Bruins","LEADERS","Points","N. Kucherov"}
        };
    }

    @DataProvider(name = "LeagueTeam")
    public Object[][] getLeagueTeamData() {
        return new Object[][] {
                {"NFL","Buffalo Bills", "LEADERS", "Passing Yards", "T. Tagovailoa"},
//                {"NHL","Boston Bruins","LEADERS","Points","N. Kucherov"}
        };
    }

    @DataProvider(name = "Team")
    public Object[][] getTeamData() {
        return new Object[][] {
                { "NHL","Boston Bruins","BOS","TEAM STATS","OFFENSE STATS"}
        };
    }

    @DataProvider(name = "Player")
    public Object[][] getPlayerData() {
        return new Object[][] {
                { "NFL","Buffalo Bills","PLAYER STATS","PASSING","RECEIVING"}
        };
    }
}
