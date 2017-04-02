package edu.matc;

import org.apache.log4j.Logger;

import static java.lang.System.out;

/**
 * Created by Punitha Anandan on 3/27/2017.
 */
public class Riley implements Runnable {
    private final Logger log = Logger.getLogger(this.getClass());
    House house;

    public Riley(House house)
    {
        this.house = house;
    }
    public void run()
    {
        log.info("Trick-Or-Treating begins..");
        try
        {
            Thread.sleep(1);
        }
        catch(InterruptedException interruptedException)
        {
            //iex.printStackTrace();
            log.error("InterruptedException" + interruptedException);
        }

        out.println("Trick-Or-Treating begins..");
        while(true) {
            house.giveCandy();
        }
    }
}


