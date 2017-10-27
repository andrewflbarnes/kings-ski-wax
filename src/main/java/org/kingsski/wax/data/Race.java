// Kings Ski Club 2017

package org.kingsski.wax.data;

import org.kingsski.wax.data.dao.RaceDao;

/**
 * <p>
 * Object containing details of Races. Fields are analogous with the database.
 * </p>
 *
 * <p>
 * The {@link RaceDao} performs
 * retrievals into, adds from and updates from this object type.
 * </p>
 */
public class Race implements Comparable<Race> {
    private static final String[] groups = {
            "A", "E", "B", "F", "C", "G", "D", "H",
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII" };

    private int controlId;
    private String league;
    private int roundNo;
    private String set;
    private String division;
    private String group;
    private int raceNo;
    private int teamOne;
    private int teamTwo;
    private int teamWin;
    private String teamOneDsq;
    private String teamTwoDsq;
    private boolean next;

    /**
     * Standard constructor
     */
    public Race() {
        // Empty default constructor
    }

    /**
     * Standard constructor for a new {@link Race}
     *
     * @param controlId The controlId associated with this race
     * @param league The league associated with this race
     * @param roundNo The roundNo associated with this race
     * @param set The set associated with this race
     * @param division The division this race belongs to
     * @param raceNo The number of this race in the current round
     * @param teamOne The first team competing
     * @param teamTwo The second team competing
     * @param teamWin The winner of the race
     * @param teamOneDsq The reason the first team was disqualified
     * @param teamTwoDsq The reason the second team was disqualified
     * @param next true if this is the next race being run, false otherwise
     */
    public Race(int controlId, String league, int roundNo, String set,
                String division, String group, int raceNo, int teamOne,
                int teamTwo, int teamWin, String teamOneDsq, String teamTwoDsq, boolean next) {
        this.controlId = controlId;
        this.league = league;
        this.roundNo = roundNo;
        this.set = set;
        this.division = division;
        this.group = group;
        this.raceNo = raceNo;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.teamWin = teamWin;
        this.teamOneDsq = teamOneDsq;
        this.teamTwoDsq = teamTwoDsq;
        this.next = next;
    }

    /**
     * Convenience constructor which clones another instance
     *
     * @param raceToCopy The {@link Race} to be cloned.
     */
    public Race(Race raceToCopy) {
        this.controlId = raceToCopy.getControlId();
        this.league = raceToCopy.getLeague();
        this.roundNo = raceToCopy.getRoundNo();
        this.set = raceToCopy.getSet();
        this.division = raceToCopy.getDivision();
        this.group = raceToCopy.getGroup();
        this.raceNo = raceToCopy.getRaceNo();
        this.teamOne = raceToCopy.getTeamOne();
        this.teamTwo = raceToCopy.getTeamTwo();
        this.teamWin = raceToCopy.getTeamWin();
        this.teamOneDsq = raceToCopy.getTeamOneDsq();
        this.teamTwoDsq = raceToCopy.getTeamTwoDsq();
        this.next = raceToCopy.isNext();
    }

    /**
     * @return the control ID this race is being run under
     */
    public int getControlId() {
        return controlId;
    }

    /**
     * @param controlId
     *            the control ID this race is being run under
     */
    public void setControlId(int controlId) {
        this.controlId = controlId;
    }

    /**
     * @return the league this race is being run under
     */
    public String getLeague() {
        return league;
    }

    /**
     * @param league
     *            the league this race is being run under
     */
    public void setLeague(String league) {
        this.league = league;
    }

    /**
     * @return the round number this race is being run under
     */
    public int getRoundNo() {
        return roundNo;
    }

    /**
     * @param roundNo
     *            the round number this race is being run under
     */
    public void setRoundNo(int roundNo) {
        this.roundNo = roundNo;
    }

    /**
     * @return the set this race is being run under
     */
    public String getSet() {
        return set;
    }

    /**
     * @param set the set this race is being run under
     */
    public void setSet(String set) {
        this.set = set;
    }

    /**
     * @return the division this race is being run under
     */
    public String getDivision() {
        return division;
    }

    /**
     * @param division
     *            the division this race is being run under
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * @return the group name this race is being run under
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group the group name this race is being run under
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * @return the race number of this race
     */
    public int getRaceNo() {
        return raceNo;
    }

    /**
     * @param raceNo
     *            the race number of this race
     */
    public void setRaceNo(int raceNo) {
        this.raceNo = raceNo;
    }

    /**
     * @return the team ID of team 1
     */
    public int getTeamOne() {
        return teamOne;
    }

    /**
     * @param teamOne
     *            the team ID of team 1
     */
    public void setTeamOne(int teamOne) {
        this.teamOne = teamOne;
    }

    /**
     * @return the team ID of team 2
     */
    public int getTeamTwo() {
        return teamTwo;
    }

    /**
     * @param teamTwo
     *            the team ID of team 2
     */
    public void setTeamTwo(int teamTwo) {
        this.teamTwo = teamTwo;
    }

    /**
     * @return 1 if team 1 has won, 2 if team 2 has one, 0 if neither has won
     */
    public int getTeamWin() {
        return teamWin;
    }

    /**
     * @param teamWin
     *            1 if team 1 has won, 2 if team 2 has one, 0 if neither has won
     */
    public void setTeamWin(int teamWin) {
        this.teamWin = teamWin;
    }

    /**
     * @return empty or null if team one has not been disqualified, otherwise
     *         the text associated with the disqualification
     */
    public String getTeamOneDsq() {
        return teamOneDsq;
    }

    /**
     * @param teamOneDsq
     *            empty or null if team one has not been disqualified, otherwise
     *            the text associated with the disqualification
     */
    public void setTeamOneDsq(String teamOneDsq) {
        this.teamOneDsq = teamOneDsq;
    }

    /**
     * @return the empty or null if team two has not been disqualified, otherwise
     *         the text associated with the disqualification
     */
    public String getTeamTwoDsq() {
        return teamTwoDsq;
    }

    /**
     * @return true if this is the next race we are running, false otherwise
     */
    public boolean isNext() {
        return next;
    }

    /**
     * @param next true if this is the next race we are running, false otherwise
     */
    public void setNext(boolean next) {
        this.next = next;
    }

    /**
     * @param teamTwoDsq
     *            the empty or null if team two has not been disqualified,
     *            otherwise the text associated with the disqualification
     */
    public void setTeamTwoDsq(String teamTwoDsq) {
        this.teamTwoDsq = teamTwoDsq;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Race another) {
        // Order by the division, then group ID, then race number finally

        int check = this.division.toUpperCase().toCharArray()[0] - another.division.toUpperCase().toCharArray()[0];

        if (check == 0) {
            // Find ordinal version of the group
            int ordThis = 0;
            int ordAnother = 0;
            for (int i = 0, n = groups.length; i < n; i++) {
                if (this.group.equalsIgnoreCase(groups[i])) {
                    ordThis = i;
                }
                if (another.group.equalsIgnoreCase(groups[i])) {
                    ordAnother = i;
                }
            }
            check = ordThis - ordAnother;
        }
        if (check == 0) {
            check = this.raceNo - another.raceNo;
        }

        return check;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "id " + this.controlId + ", division " + this.division + ", set "
                + this.roundNo + ", race " + this.raceNo + ", team " + this.teamOne + " vs team " + this.teamTwo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (Race.class.equals(obj.getClass())) {
            Race other = (Race)obj;

            if (this.league == null
                    || this.set == null
                    || this.division == null
                    || this.group == null) {
                return false;
            }

            return this.controlId == other.controlId &&
                    this.league.equals(other.getLeague()) &&
                    this.roundNo == other.roundNo &&
                    this.set.equals(other.getSet()) &&
                    this.division.equals(other.getDivision()) &&
                    this.group.equals(other.getGroup()) &&
                    this.raceNo == other.raceNo &&
                    this.teamOne == other.teamOne &&
                    this.teamTwo == other.teamTwo;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + controlId;
        result = prime * result + (league == null ? 0 : league.hashCode());
        result = prime * result + roundNo;
        result = prime * result + (set == null ? 0 : set.hashCode());
        result = prime * result + (division == null ? 0 : division.hashCode());
        result = prime * result + (group == null ? 0 : group.hashCode());
        result = prime * result + raceNo;
        result = prime * result + teamOne;
        result = prime * result + teamTwo;

        return result;
    }

    public static class RaceBuilder {
        private Race race = new Race();

        public RaceBuilder() {}

        public Race build() {
            return new Race(race);
        }

        public RaceBuilder reset() {
            race = new Race();
            return this;
        }

        public RaceBuilder setControlId(int controlId) {
            race.setControlId(controlId);
            return this;
        }

        public RaceBuilder setLeague(String league) {
            race.setLeague(league);
            return this;
        }

        public RaceBuilder setRoundNo(int roundNo) {
            race.setRoundNo(roundNo);
            return this;
        }

        public RaceBuilder setSet(String set) {
            race.setSet(set);
            return this;
        }

        public RaceBuilder setDivision(String division) {
            race.setDivision(division);
            return this;
        }

        public RaceBuilder setGroup(String group) {
            race.setGroup(group);
            return this;
        }

        public RaceBuilder setRaceNo(int raceNo) {
            race.setRaceNo(raceNo);
            return this;
        }

        public RaceBuilder setTeamOne(int teamOne) {
            race.setTeamOne(teamOne);
            return this;
        }

        public RaceBuilder setTeamTwo(int teamTwo) {
            race.setTeamTwo(teamTwo);
            return this;
        }

        public RaceBuilder setTeamWin(int teamWin) {
            race.setTeamWin(teamWin);
            return this;
        }

        public RaceBuilder setTeamOneDsq(String teamOneDsq) {
            race.setTeamOneDsq(teamOneDsq);
            return this;
        }

        public RaceBuilder setTeamTwoDsq(String teamTwoDsq) {
            race.setTeamTwoDsq(teamTwoDsq);
            return this;
        }

        public RaceBuilder setNext(boolean next) {
            race.setNext(next);
            return this;
        }
    }
}
