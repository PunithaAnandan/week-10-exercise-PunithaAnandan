package threading.practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Punitha Anandan on 3/31/2017.
 */
class CustomerGenerator implements Runnable
{
    Bshop shop;

    public CustomerGenerator(Bshop shop)
    {
        this.shop = shop;
    }

    public void run()
    {
        while(true)
        {
            Customer customer = new Customer(shop);
            customer.setInTime(new Date());
            Thread thcustomer = new Thread(customer);
            customer.setName("Customer Thread "+thcustomer.getId());
            thcustomer.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }

}
