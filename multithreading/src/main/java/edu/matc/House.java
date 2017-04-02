package edu.matc;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * Created by Punitha Anandan on 3/27/2017.
 */
public class House {

    private final Logger log = Logger.getLogger(this.getClass());
    int maxChildCount;
    List<TrickOrTreater> listTrickOrTreater;

    public House()
    {
        maxChildCount = 10;
        listTrickOrTreater = new LinkedList<TrickOrTreater>();
    }

    public void giveCandy()
    {
        log.info("Give candy method starts");
        TrickOrTreater trickOrTreater;
        out.println("Riley watches TV.");
        synchronized (listTrickOrTreater)
        {

            while(listTrickOrTreater.size()==0)
            {
                out.println("Riley is waiting for trickOrTreaters.");
                try
                {
                    listTrickOrTreater.wait();
                }
                catch(InterruptedException interruptedException)
                {
                    //iex.printStackTrace();
                    log.error("InterruptedException" + interruptedException);
                }
            }
            out.println("Riley answers the door");
            //log.info("Riley answers the door");
            trickOrTreater = (TrickOrTreater) ((LinkedList<?>)listTrickOrTreater).poll();
        }
        long duration=3;
        try
        {
            out.println("Riley gives candy");
            //log.info("Riley gives candy");
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException interruptedException)
        {
            //log.error("InterruptedException" + interruptedException);
        }
        out.println("Completed giving candy to "+trickOrTreater.getName() + " in "+ duration + " seconds.");
        log.info("End of giving candy method");
    }

    public void add(TrickOrTreater trickOrTreater) throws InterruptedException {
        log.info("TrickOrTreater starts adding in the Linked List ");
        out.println(trickOrTreater.getName()+" is created");
        synchronized (listTrickOrTreater)
        {
            if(listTrickOrTreater.size()== maxChildCount)
            {
               out.println("TrickOrTreater Exists...Bypass the house");
               log.info("TrickOrTreater Exists...Bypass the house");
               return ;
            }

            ((LinkedList<TrickOrTreater>)listTrickOrTreater).offer(trickOrTreater);
            out.println(trickOrTreater.getName()+" rings doorbell");
                if(listTrickOrTreater.size()==1)
                listTrickOrTreater.notify();
                log.info("End of adding TrickOrTreaters in the Linked List");
        }
    }
}


