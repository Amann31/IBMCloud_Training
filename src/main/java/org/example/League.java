package org.example;

public class League {
    private String leagueName;
    private Integer leagueYear;
    private String leagueSeason;

    public League() {
    }

    public League(String leagueName, Integer leagueYear, String leagueSeason) {
        this.leagueName = leagueName;
        this.leagueYear = leagueYear;
        this.leagueSeason = leagueSeason;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public Integer getLeagueYear() {
        return leagueYear;
    }

    public void setLeagueYear(Integer leagueYear) {
        this.leagueYear = leagueYear;
    }

    public String getLeagueSeason() {
        return leagueSeason;
    }

    public void setLeagueSeason(String leagueSeason) {
        this.leagueSeason = leagueSeason;
    }
}
