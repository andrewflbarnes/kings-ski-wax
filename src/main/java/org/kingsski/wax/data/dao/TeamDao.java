package org.kingsski.wax.data.dao;

import org.kingsski.wax.data.Club;
import org.kingsski.wax.data.Team;

import java.util.List;

/**
 * DAO for dealing with interactions between {@link Team} objects and the
 * database. This is an extension of the {@link RaceOrganiserDao}.
 * 
 * @author Barnesly
 */
public interface TeamDao extends RaceOrganiserDao {

    /**
     * Returns the full details for the requested team searching either by -
     * club name, division and division index - team name, division
     *
     * @param team
     *            The Team object containing the details of team being searched
     *            for
     * @return the Team object containing full details if it exists, null
     *         otherwise
     */
    Team getTeam(Team team);

    /**
     * @param teamId
     *            the ID of the {@link Team} to retrieve
     * @return the {@link Team} object if succesful, null otherwise
     */
    Team getTeam(int teamId);

    /**
     * @return a list of all {@link Team}s for the current league
     */
    List<Team> getAllTeams();

    /**
     * @param club
     *            The {@link Club} to filter on
     * @return a list of all {@link Team}s for the club
     */
    List<Team> getTeamsByClub(Club club);

    /**
     * @param division
     *            the division to filter on
     * @return a list of {@link Team}s for the division for the current league
     */
    List<Team> getTeamsByDivision(String division);

    /**
     * @param division
     *            the division to filter on
     * @return a list of seeded {@link Team}s for the division for the current
     *         league
     */
    List<Team> getSeededTeams(String division);

    /**
     * Returns all {@link Team}s for the supplied list of {@link Club}s and
     * divisions who are competing based.
     *
     * NOTE: This assumes the {@link Club} objects already contain the details
     * of how many teams are competing.
     *
     * @param division
     *            the division which is competing
     * @param competingClubs
     *            the list of {@link Club}s which are competing
     * @param league
     *            the league which we are retrieving teams for
     * @return a list of competing {@link Team}s for the given clubs and
     *         division
     */
    List<Team> getCompetingTeams(String division, List<Club> competingClubs, String league);

    /**
     * Gets the requested list of {@link Team}s. If division and/or {@link Club}
     * are supplied they are used as filters If league is not supplied then the
     * current pref_setting_league is used
     *
     * @param club
     *            The {@link Club} to optionally filter on
     * @param division
     *            The division to optionally filter on
     * @param league
     *            The league to filter on
     * @return A List of {@link Team} objects, empty if no corresponding teams
     *         were found
     */
    List<Team> getTeams(Club club, String division, String league);

    /**
     * @param team
     *            the {@link Team} to add
     * @return the {@link Team} object which was added, null otherwise
     */
    Team addTeam(Team team);

    /**
     * @param team
     *            the {@link Team} to delete
     */
    void deleteTeam(Team team);

    /**
     * @param teamId
     *            the ID of the {@link Team} to delete
     */
    void deleteTeam(int teamId);

    /**
     * @param club
     *            the {@link Club} for which all teams should be deleted
     */
    void deleteAllClubTeams(Club club);

    /**
     * Convenience method for updating {@link Team}s. Note that the Team id must
     * be set
     *
     * @param team
     *            The {@link Team} object to be added
     * @param add
     *            If set to true and the team does not already exist then it
     *            will be added
     * @return The {@link Team} object if the update was successful (or an add
     *         was performed if required), null otherwise
     */
    Team updateTeam(Team team, boolean add);

    /**
     * @param league
     *            the league for which {@link Team}s should have their scores
     *            reset
     * @param division
     *            the division under which the {@link Team}s should have their
     *            scores reset
     */
    void resetTeams(String league, String division);

}