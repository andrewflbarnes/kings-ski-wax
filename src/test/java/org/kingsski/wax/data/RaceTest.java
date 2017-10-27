package org.kingsski.wax.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

public class RaceTest {

    private static final int CONTROL_1 = 1;
    private static final int CONTROL_2 = 2;
    private static final String LEAGUE_N = "Northern";
    private static final String LEAGUE_S = "Southern";
    private static final int RND_1 = 1;
    private static final int RND_2 = 2;
    private static final String SET_1 = "1";
    private static final String SET_K = "Knockouts";
    private static final String DIV_M = "M";
    private static final String DIV_L = "L";
    private static final String GROUP_1 = "GROUP1";
    private static final String GROUP_2 = "GROUP2";
    private static final int NO_1 = 1;
    private static final int NO_2 = 2;
    private static final int TEAM_1 = 1;
    private static final int TEAM_2 = 2;
    private static final int TEAM_3 = 3;
    private static final String DUMMY = "DUMMY";

    // Base race
    private static final Race RACE_1A = new Race(CONTROL_1, LEAGUE_N, RND_1, SET_K, DIV_M, GROUP_1, NO_1, TEAM_1, TEAM_2, 0, null, null, false);
    // Identical to 1A
    private static final Race RACE_1B = new Race(CONTROL_1, LEAGUE_N, RND_1, SET_K, DIV_M, GROUP_1, NO_1, TEAM_1, TEAM_2, 0, null, null, false);
    // Identical to 1A other than transient fields
    private static final Race RACE_1C = new Race(CONTROL_1, LEAGUE_N, RND_1, SET_K, DIV_M, GROUP_1, NO_1, TEAM_1, TEAM_2, 999, DUMMY, DUMMY, true);
    // Different controlId
    private static final Race RACE_1S = new Race(CONTROL_2, LEAGUE_S, RND_1, SET_K, DIV_M, GROUP_1, NO_1, TEAM_1, TEAM_2, 0, null, null, false);
    // Different group
    private static final Race RACE_1T = new Race(CONTROL_1, LEAGUE_S, RND_1, SET_K, DIV_M, GROUP_2, NO_1, TEAM_1, TEAM_2, 0, null, null, false);
    // Different league
    private static final Race RACE_1U = new Race(CONTROL_1, LEAGUE_S, RND_1, SET_K, DIV_M, GROUP_1, NO_1, TEAM_1, TEAM_2, 0, null, null, false);
    // Different round
    private static final Race RACE_1V = new Race(CONTROL_1, LEAGUE_N, RND_2, SET_K, DIV_M, GROUP_1, NO_1, TEAM_1, TEAM_2, 0, null, null, false);
    // Different set
    private static final Race RACE_1W = new Race(CONTROL_1, LEAGUE_N, RND_1, SET_1, DIV_M, GROUP_1, NO_1, TEAM_1, TEAM_2, 0, null, null, false);
    // Different division
    private static final Race RACE_1X = new Race(CONTROL_1, LEAGUE_N, RND_1, SET_K, DIV_L, GROUP_1, NO_1, TEAM_1, TEAM_2, 0, null, null, false);
    // Different team 1
    private static final Race RACE_1Y = new Race(CONTROL_1, LEAGUE_N, RND_1, SET_K, DIV_M, GROUP_1, NO_1, TEAM_3, TEAM_2, 0, null, null, false);
    // Different team 2
    private static final Race RACE_1Z = new Race(CONTROL_1, LEAGUE_N, RND_1, SET_K, DIV_M, GROUP_1, NO_1, TEAM_1, TEAM_3, 0, null, null, false);
    // Different race number
    private static final Race RACE_2A = new Race(CONTROL_1, LEAGUE_N, RND_1, SET_K, DIV_M, GROUP_1, NO_2, TEAM_1, TEAM_2, 0, null, null, false);
    // all null/0
    private static final Race RACE_NULL = new Race(0, null, 0, null, null, null, 0, 0, 0, 0, null, null, false);

    @Test
    public void testConstructor() {
        final int winner = 1;
        final String dsq1 = "DSQ 1";
        final String dsq2 = "DSQ_2";
        final boolean next = true;

        Race race = new Race(CONTROL_1, LEAGUE_N, RND_1, SET_1, DIV_L, GROUP_1, NO_1, TEAM_1, TEAM_2, winner, dsq1, dsq2, next);

        assertEquals(CONTROL_1, race.getControlId());
        assertEquals(LEAGUE_N, race.getLeague());
        assertEquals(RND_1, race.getRoundNo());
        assertEquals(SET_1, race.getSet());
        assertEquals(DIV_L, race.getDivision());
        assertEquals(GROUP_1, race.getGroup());
        assertEquals(NO_1, race.getRaceNo());
        assertEquals(TEAM_1, race.getTeamOne());
        assertEquals(TEAM_2, race.getTeamTwo());
        assertEquals(winner, race.getTeamWin());
        assertEquals(dsq1, race.getTeamOneDsq());
        assertEquals(dsq2, race.getTeamTwoDsq());
        assertEquals(next, race.isNext());
    }

    @Test
    public void testCopyOfConstructor() {
        Race copy = new Race(RACE_1C);

        assertEqualsAndHashCode(RACE_1C, copy);

        assertEquals(RACE_1C.getControlId(), copy.getControlId());
        assertEquals(RACE_1C.getLeague(), copy.getLeague());
        assertEquals(RACE_1C.getRoundNo(), copy.getRoundNo());
        assertEquals(RACE_1C.getSet(), copy.getSet());
        assertEquals(RACE_1C.getDivision(), copy.getDivision());
        assertEquals(RACE_1C.getGroup(), copy.getGroup());
        assertEquals(RACE_1C.getRaceNo(), copy.getRaceNo());
        assertEquals(RACE_1C.getTeamOne(), copy.getTeamOne());
        assertEquals(RACE_1C.getTeamTwo(), copy.getTeamTwo());
        assertEquals(RACE_1C.getTeamWin(), copy.getTeamWin());
        assertEquals(RACE_1C.getTeamOneDsq(), copy.getTeamOneDsq());
        assertEquals(RACE_1C.getTeamTwoDsq(), copy.getTeamTwoDsq());
        assertEquals(RACE_1C.isNext(), copy.isNext());
    }

    @Test
    public void testEquals() {
        assertEqualsAndHashCode(RACE_1A, RACE_1A);

        assertEqualsAndHashCode(RACE_1A, RACE_1B);

        assertEqualsAndHashCode(RACE_1A, RACE_1C);

        assertNotEqualsAndHashCode(RACE_1A, RACE_1S);

        assertNotEqualsAndHashCode(RACE_1A, RACE_1T);

        assertNotEqualsAndHashCode(RACE_1A, RACE_1U);

        assertNotEqualsAndHashCode(RACE_1A, RACE_1V);

        assertNotEqualsAndHashCode(RACE_1A, RACE_1W);

        assertNotEqualsAndHashCode(RACE_1A, RACE_1X);

        assertNotEqualsAndHashCode(RACE_1A, RACE_1Y);

        assertNotEqualsAndHashCode(RACE_1A, RACE_1Z);

        assertNotEqualsAndHashCode(RACE_1A, RACE_2A);

        assertNotEqualsAndHashCode(RACE_1A, RACE_NULL);
    }

    @Test
    public void testRaceBuilder() {
        Race.RaceBuilder builder = new Race.RaceBuilder();
        Race race1 = builder
                .setControlId(RACE_1A.getControlId())
                .setDivision(RACE_1A.getDivision())
                .setGroup(RACE_1A.getGroup())
                .setLeague(RACE_1A.getLeague())
                .setRoundNo(RACE_1A.getRoundNo())
                .setRaceNo(RACE_1A.getRaceNo())
                .setSet(RACE_1A.getSet())
                .setTeamOne(RACE_1A.getTeamOne())
                .setTeamTwo(RACE_1A.getTeamTwo())
                .build();
        Race race2 = builder.build();
        Race race3 = builder
                .reset()
                .setDivision(RACE_1A.getDivision())
                .setGroup(RACE_1A.getGroup())
                .setLeague(RACE_1A.getLeague())
                .setRoundNo(RACE_1A.getRoundNo())
                .setRaceNo(RACE_1A.getRaceNo())
                .setSet(RACE_1A.getSet())
                .setTeamOne(RACE_1A.getTeamOne())
                .setTeamTwo(RACE_1A.getTeamTwo())
                .build();

        assertEquals(race1, race2);
        assertEquals(RACE_1A, race1);
        assertEquals(RACE_1A, race2);
        assertNotSame(race1, race2);
        assertNotSame(RACE_1A, race1);
        assertNotSame(RACE_1A, race2);

        assertNotEquals(RACE_1A, race3);
    }

    private static void assertNotEqualsAndHashCode(Race expected, Race actual) {
        assertEqualsAndHashCode(expected, actual, false);
    }

    private static void assertEqualsAndHashCode(Race expected, Race actual) {
        assertEqualsAndHashCode(expected, actual, true);
    }

    private static void assertEqualsAndHashCode(Race expected, Race actual, boolean shouldBeEqual) {
        if (shouldBeEqual) {
            assertEquals(expected, actual);
            assertEquals(actual, expected);
            assertEquals(expected.hashCode(), actual.hashCode());
        } else {
            assertNotEquals(expected, actual);
            assertNotEquals(actual, expected);
            assertNotEquals(expected.hashCode(), actual.hashCode());
        }
    }
}
