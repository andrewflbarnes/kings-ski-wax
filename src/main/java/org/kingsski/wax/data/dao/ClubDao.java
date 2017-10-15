// Kings Ski Club 2017

package org.kingsski.wax.data.dao;

import org.kingsski.wax.data.Club;

import java.util.List;

/**
 * DAO for dealing with interactions between {@link Club} objects and the
 * database. This is an extension of the {@link RaceOrganiserDao}.
 */
public interface ClubDao extends RaceOrganiserDao {

    /**
     * @param league if not null then filter by the provided league,
     *               otherwise retrieve all clubs for all leagues
     * @return A list object containing all {@link Club}s, the list is empty if no clubs
     * were retrieved
     */
    List<Club> getClubs(String league);

    /**
     * @param club The {@link Club} to be added
     * @return The {@link Club} object if the add was successful, null otherwise
     */
    Club addClub(Club club);

    /**
     * @param club the {@link Club} to delete
     */
    void deleteClub(Club club);

    /**
     * @param club The {@link Club} to be updated
     * @return The {@link Club} object if the update was successful, null otherwise
     */
    Club updateClub(Club club);

}
