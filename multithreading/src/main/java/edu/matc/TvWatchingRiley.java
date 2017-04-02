package edu.matc;

/**
 * Created by Punitha Anandan on 3/27/2017.
 */
public class TvWatchingRiley {

    public static void main(String args[])
    {
        House house = new House();

        Riley riley = new Riley(house);
        TrickOrTreaterGenerator trickOrTreaterGenerator = new TrickOrTreaterGenerator(house);

        Thread threadRiley = new Thread(riley);
        Thread threadTrickOrTreaterGenerator= new Thread(trickOrTreaterGenerator);

        threadRiley.start();
        threadTrickOrTreaterGenerator.start();
    }

}

