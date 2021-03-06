// Kings Ski Club 2017

package org.kingsski.wax.configure.races;

import org.kingsski.wax.data.RaceControl;
import org.kingsski.wax.data.dao.DaoFactory;
import org.kingsski.wax.export.RaceListWriter;

/**
 * <p>
 * Delegation class which generates the races to run.
 * </p>
 * <p>
 * Races are generated based on a {@link RaceControl} and set number. The
 * control defines the league and control id for which to generate races. The
 * set number dictates what kind of implementation is required:
 * <ol>
 * <li>
 * Races are generated based on the number of teams currently set for each club
 * under the corresponding control id and league.</li>
 * <li>
 * Races are generated based on the results of the first set of races under the
 * corresponding control id and league.</li>
 * </ol>
 * </p>
 */
public class RaceConfigurer {

    /**
     * Generates the races for the required set under the control id and league
     * in the {@link RaceControl} parameter.
     *
     * @param daoFactory  The {@link DaoFactory} which will provide DAOs to this instance
     * @param writer      The {@link RaceListWriter} which will produce a file containing the races
     * @param control     The {@link RaceControl} containing the league and control id
     *                    for race generation is required.
     * @param raceSet     Which set of races need to be generated (i.e. 1, 2 or 3)
     * @param isKnockouts true if this is a knockout set, false otherwise
     */
    public static void generateRaces(final DaoFactory daoFactory, final RaceListWriter writer, final RaceControl control, final int raceSet, boolean isKnockouts) {
        switch (raceSet) {
            case 1:
                new RaceConfigurerSetOne(daoFactory, writer, control).execute();
                break;
            case 2:
            case 3:
                new RaceConfigurerSetTwo(daoFactory, writer, control, raceSet, isKnockouts).execute();
                break;
            default:
                throw new InvalidSetException("Invalid race set: " + String.valueOf(raceSet));
        }

    }

    /**
     * Unchecked exception thrown when an invalid round number is passed for configuration
     */
    public static class InvalidSetException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        /**
         * Constructor
         *
         * @param reason The reason the exception was raised
         */
        public InvalidSetException(String reason) {
            super(reason);
        }
    }

}
