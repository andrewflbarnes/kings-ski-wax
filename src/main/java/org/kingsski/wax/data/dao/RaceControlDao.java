// Kings Ski Club 2017

package org.kingsski.wax.data.dao;

import org.kingsski.wax.data.RaceControl;

import java.util.List;

/**
 * DAO for dealing with interactions between {@link RaceControl} objects and the
 * database. This is an extension of the {@link RaceOrganiserDao}.
 *
 * @author Barnesly
 */
public interface RaceControlDao extends RaceOrganiserDao {

    /**
     * @param raceControl the {@link RaceControl} to retrieve
     * @return the {@link RaceControl} if successful, null otherwise
     */
    RaceControl getRaceControl(RaceControl raceControl) throws NonExistentRaceControlException;

    /**
     * @param league The name of the league which we are adding a race control for
     * @return the most recently created {@link RaceControl}
     * @throws NonExistentRaceControlException
     */
    RaceControl getLastRaceControl(String league) throws NonExistentRaceControlException;

    /**
     * @return a list of all {@link RaceControl}s
     */
    List<RaceControl> getAllRaceControl();

    /**
     * Adds a new control entry to the RACE_CONTROL table.
     * <p>
     * Note that if the return object is not set to an appropriate {@link RaceControl}
     * variable it can be retrieved later using getLastRaceControl()
     *
     * @param league The name of the league which we are adding a race control for
     * @return the {@link RaceControl} object if the new control was added successfully,
     * null otherwise
     */
    RaceControl addNewRaceControl(String league);

    class NonExistentRaceControlException extends Exception {
        private static final long serialVersionUID = 1L;

        public NonExistentRaceControlException(String reason) {
            super(reason);
        }
    }

}
