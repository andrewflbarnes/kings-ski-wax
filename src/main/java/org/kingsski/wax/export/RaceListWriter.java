package org.kingsski.wax.export;

import org.kingsski.wax.data.Race;
import org.kingsski.wax.data.Team;

import java.io.File;
import java.util.List;

/**
 * Well, let's hope this back of fuckery ends up working.
 *
 * @author Barnesly
 */
public interface RaceListWriter {
    /**
     * Generates a PDF containing a table of the races to be run
     *
     * @param races The ordered list of {@link Race}s which are to be added
     * @param teamsList The {@link List} of {@link Team}s which will be used to lookup team names
     * @param outputFile The file to output to
     * @return true if the PDF was successfully generated, false otherwise
     */
    boolean writeRaceList(List<Race> races, List<Team> teamsList, File outputFile, String encoding);
}
