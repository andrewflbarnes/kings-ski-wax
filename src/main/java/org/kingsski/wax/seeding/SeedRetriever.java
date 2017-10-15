// Kings Ski Club 2017

package org.kingsski.wax.seeding;

import org.kingsski.wax.data.Team;

import java.util.List;

/**
 * Defines an interface for the retrieval of {@link Team}s and their seeding information
 */
public interface SeedRetriever {

    /**
     * Retrieve the seed information for {@link Team}s
     *
     * @return The List of {@link Team}s and the seed information for them which was retrieved
     */
    List<Team> getSeeds();
}
