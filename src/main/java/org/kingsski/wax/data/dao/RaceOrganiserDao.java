// Kings Ski Club 2017

package org.kingsski.wax.data.dao;

/**
 * <p>
 * A simple DAO which provides limited access and functionality on the SQLite
 * database.
 * </p>
 * <p>
 * <p>
 * The below DAOs are extensions of this interface:
 * <ul>
 * <li>{@link ClubDao}</li>
 * <li>{@link RaceControlDao}</li>
 * <li>{@link RaceDao}</li>
 * <li>{@link TeamDao}</li>
 * </ul>
 * </p>
 *
 * @author Barnesly
 */
public interface RaceOrganiserDao {

    /**
     * @return true if a connection has been opened using the open() method
     */
    boolean isOpen();

    /**
     * Open a writable database connection to the RaceOrganiser database
     */
    void open();

    /**
     * Close the current connection to the RaceOrganiser database
     */
    void close();

    /**
     * Delete the current database
     */
    void deleteDb();

    /**
     * Begin a transaction on the database
     */
    void beginTransactionNonExclusive();

    /**
     * Mark the current transaction on a database as successful
     */
    void setTransactionSuccessful();

    /**
     * End the current transaction on the database
     */
    void endTransaction();

}
