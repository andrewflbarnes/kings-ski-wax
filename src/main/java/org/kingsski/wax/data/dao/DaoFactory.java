package org.kingsski.wax.data.dao;

import android.content.Context;

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
     * @param context
     *            The {@link Context} to associate with the new {@link RaceOrganiserDao}
     *            instance.
     * @return An implementation of {@link RaceOrganiserDao}
     */
    RaceOrganiserDao newRaceOrganiserDaoInstance(Context context);

    /**
     * @param context
     *            The {@link Context} to associate with the new {@link RaceDao}
     *            instance.
     * @return An implementation of {@link RaceDao}
     */
    RaceDao newRaceDaoInstance(Context context);

    /**
     * @param context
     *            The {@link Context} to associate with the new {@link ClubDao}
     *            instance.
     * @return An implementation of {@link ClubDao}
     */
    ClubDao newClubDaoInstance(Context context);

    /**
     * @param context
     *            The {@link Context} to associate with the new {@link RaceControlDao}
     *            instance.
     * @return An implementation of {@link RaceControlDao}
     */
    RaceControlDao newRaceControlDaoInstance(Context context);

    /**
     * @param context
     *            The {@link Context} to associate with the new {@link TeamDao}
     *            instance.
     * @return An implementation of {@link TeamDao}
     */
    TeamDao newTeamDaoInstance(Context context);
}
