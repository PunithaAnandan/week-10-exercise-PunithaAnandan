package edu.matc;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Punitha Anandan on 3/27/2017.
 */
public class TrickOrTreaterGenerator implements Runnable {
    private final Logger log = Logger.getLogger(this.getClass());
    House house;

   public TrickOrTreaterGenerator(House house)
    {
        this.house = house;
    }

    public void run()
    {
        log.info("threadTrickOrTreater create and start in the TrickOrTreaterGenerator class");
        while(true)
        {
            TrickOrTreater trickOrTreater = new TrickOrTreater(house);
            trickOrTreater.setInTime(new Date());
            Thread threadTrickOrTreater = new Thread(trickOrTreater);
            trickOrTreater.setName("Child "+threadTrickOrTreater.getId());
            threadTrickOrTreater.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }
            catch(InterruptedException interruptedException)
            {
                //iex.printStackTrace();
                log.error("InterruptedException" + interruptedException);
            }
        }
    }

}



