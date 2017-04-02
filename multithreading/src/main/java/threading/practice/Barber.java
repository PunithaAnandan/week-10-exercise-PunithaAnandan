package threading.practice;

/**
 * Created by Punitha Anandan on 3/31/2017.
 */
class Barber implements Runnable
{
    Bshop shop;

    public Barber(Bshop shop)
    {
        this.shop = shop;
    }
    public void run()
    {
        try
        {
            Thread.sleep(10);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Barber started..");
        while(true)
        {
            shop.cutHair();
        }
    }
}
