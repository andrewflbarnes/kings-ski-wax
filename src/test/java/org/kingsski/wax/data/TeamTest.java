package org.kingsski.wax.data;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Team}
 */
public class TeamTest {
    private static final int SCORE_FIRST = 10000;
    private static final int SCORE_SECOND = 1000;
    private static final int SCORE_THIRD = 100;
    private static final int SCORE_FOURTH = 10;
    private static final int SCORE_FIFTH = 1;
    private static final int SCORE_LOW_BALANCER = 9;

    private static Team teamOne;
    private static Team teamTwo;
    private static Team teamThree;

    /**
     * Setup method called before each test to intialise {@link Team} objects which will be used
     * in the tests
     */
    @BeforeClass
    public static void setup() {
        // Use magnitude scores to make checks easier
        teamOne = new Team();
        teamOne.setScoreR1(SCORE_FOURTH);
        teamOne.setScoreR2(SCORE_FIFTH);
        teamOne.setScoreR3(SCORE_SECOND);
        teamOne.setScoreR4(SCORE_FIRST);
        teamOne.setScoreR5(SCORE_THIRD);

        // Same total score as teamOne but has a higher fourth round score
        teamTwo = new Team();
        teamTwo.setScoreR1(SCORE_FOURTH);
        teamTwo.setScoreR2(SCORE_FIFTH);
        teamTwo.setScoreR3(SCORE_SECOND);
        teamTwo.setScoreR4(SCORE_FIRST + SCORE_THIRD);
        teamTwo.setScoreR5(0);

        // Higher total score than teamOne but lower ordering
        teamThree = new Team();
        teamThree.setScoreR1(SCORE_LOW_BALANCER);
        teamThree.setScoreR2(SCORE_LOW_BALANCER);
        teamThree.setScoreR3(SCORE_SECOND);
        teamThree.setScoreR4(SCORE_FIRST);
        teamThree.setScoreR5(SCORE_THIRD);
    }

    /**
     * Test for retrieving the ordered scores
     */
    @Test
    public void testOrderedScoreRetrieval() {
        assertEquals(SCORE_FIRST, teamOne.getOrderedScore1());
        assertEquals(SCORE_SECOND, teamOne.getOrderedScore2());
        assertEquals(SCORE_THIRD, teamOne.getOrderedScore3());
        assertEquals(SCORE_FOURTH, teamOne.getOrderedScore4());
        assertEquals(SCORE_FIFTH, teamOne.getOrderedScore5());
    }

    /**
     * Test for retrieving the ordered totals
     */
    @Test
    public void testOrderedScoreTotalRetrieval() {
        assertEquals(SCORE_FIRST + SCORE_SECOND + SCORE_THIRD + SCORE_FOURTH + SCORE_FIFTH, teamOne.getOrderedTotal(5));
        assertEquals(SCORE_FIRST + SCORE_SECOND + SCORE_THIRD + SCORE_FOURTH, teamOne.getOrderedTotal(4));
        assertEquals(SCORE_FIRST + SCORE_SECOND + SCORE_THIRD, teamOne.getOrderedTotal(3));
        assertEquals(SCORE_FIRST + SCORE_SECOND, teamOne.getOrderedTotal(2));
        assertEquals(SCORE_FIRST, teamOne.getOrderedTotal(1));
    }

    /**
     * Test for team sorting using the compareTo method. The test compares drawn and undrawn teams
     */
    @Test
    public void testCompareTeams() {
        // teamOne and teamTwo are drawn but teamTwo has the better ordering
        // teamThree has the highest score but lower ordering
        ArrayList<Team> teamList = new ArrayList<Team>(3);
        teamList.add(teamTwo);
        teamList.add(teamOne);
        teamList.add(teamThree);

        Collections.sort(teamList);

        assertEquals(teamThree, teamList.get(0));
        assertEquals(teamTwo, teamList.get(1));
        assertEquals(teamOne, teamList.get(2));
    }
}
