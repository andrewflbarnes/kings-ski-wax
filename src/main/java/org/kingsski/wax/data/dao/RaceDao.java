// Kings Ski Club 2017

package org.kingsski.wax.data.dao;

import org.kingsski.wax.data.Race;

import java.util.List;

/**
 * DAO for dealing with interactions between {@link Race} objects and the
 * database. This is an extension of the {@link RaceOrganiserDao}.
 */
public interface RaceDao extends RaceOrganiserDao {

    /**
     * @param race The {@link Race} object containing the control id, round
     *             number and race number of the race to be retrieved
     * @return The {@link Race} object of the race if successful, null otherwise
     */
    Race getRace(Race race);

    /**
     * @param controlId The control id for the set of races needed
     * @param division  The division of races, use {@code null} for all divisions
     * @param roundNo   The round number, 3 for knockouts, 0 for all rounds
     * @return A List of {@link Race}s associated with the control id and
     * additional parameters
     */
    List<Race> getRaces(int controlId, String division, int roundNo);

    /**
     * @param race The {@link Race} object containing the control id, division,
     *             race number, round number and teams
     * @return The {@link Race} object with the race number set if successful,
     * null otherwise
     */
    Race addRace(Race race);

    /**
     * @param race The {@link Race} object containing the control id, round
     *             number and race number of the race to be deleted
     */
    void deleteRace(Race race);

    /**
     * @param controlId The control ID of the races to be deleted
     * @param roundNo   The round number of the races to be removed
     */
    void deleteRaces(int controlId, int roundNo);

    /**
     * Updates a race entry with winning team and disqualification information
     *
     * @param race The {@link Race} object containing the control id, round
     *             number and race number of the race to be deleted
     * @return The {@link Race} object if successful, null otherwise
     */
    Race updateRace(Race race);

    /**
     * @return The next positive ordinal race number for the race set under the
     * provided control id and round number
     */
    int getNextRaceNo(int controlId, int roundNo);

}
