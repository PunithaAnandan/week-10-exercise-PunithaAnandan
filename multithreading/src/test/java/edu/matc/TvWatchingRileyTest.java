package edu.matc;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Punitha Anandan on 3/31/2017.
 */
public class TvWatchingRileyTest extends TestCase {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void testRun() throws Exception {
        {
            logger.info("Just before creating a Riley thread");
            House house = new House();

            Riley riley = new Riley(house);
            //TrickOrTreaterGenerator trickOrTreaterGenerator = new TrickOrTreaterGenerator(house);

            Thread threadRiley = new Thread(riley);
            //Thread threadTrickOrTreaterGenerator= new Thread(trickOrTreaterGenerator);

            threadRiley.start();
            //threadTrickOrTreaterGenerator.start();
        }
    }

}