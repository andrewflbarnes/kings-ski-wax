package org.kingsski.wax.data.dao;

/**
 * <p>
 * An interface for a factory which returns instances of DAOs required by the race organiser.
 * </p>
 * <p>
 * Provides methods for returning instances of each of:
 * <ul>
 * <li>{@link RaceOrganiserDao}</li>
 * <li>{@link RaceDao}</li>
 * <li>{@link ClubDao}</li>
 * <li>{@link RaceControlDao}</li>
 * <li>{@link TeamDao}</li>
 * </ul>
 * </p>
 *
 * @author Barnesly
 */
public interface DaoFactory {

    /**
     * @return An implementation of {@link RaceOrganiserDao}
     */
    RaceOrganiserDao newRaceOrganiserDaoInstance();

    /**
     * @return An implementation of {@link RaceDao}
     */
    RaceDao newRaceDaoInstance();

    /**
     * @return An implementation of {@link ClubDao}
     */
    ClubDao newClubDaoInstance();

    /**
     * @return An implementation of {@link RaceControlDao}
     */
    RaceControlDao newRaceControlDaoInstance();

    /**
     * @return An implementation of {@link TeamDao}
     */
    TeamDao newTeamDaoInstance();
}
