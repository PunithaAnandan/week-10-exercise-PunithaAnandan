package edu.matc;

import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by Punitha Anandan on 3/27/2017.
 */
public class TrickOrTreater implements Runnable{
    private final Logger log = Logger.getLogger(this.getClass());
    String name;
    Date inTime;

    House house;

    public TrickOrTreater(House house)
    {
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void run()
    {
        log.info("goForTrickOrTreat method call here");
        try {
            goForTrickOrTreat();
        } catch (InterruptedException interruptedException) {
            //e.printStackTrace();
            log.error("InterruptedException" + interruptedException);
        }
    }

    private synchronized void goForTrickOrTreat() throws InterruptedException {
        house.add(this);
    }
}



