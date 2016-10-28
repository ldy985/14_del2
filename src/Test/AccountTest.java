package Test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Matt_Lab on 25/10/2016.
 */
public class AccountTest {
    //creates a account object
    private final Game.Account account = new Game.Account();

    @Test
    public void addBalance() throws Exception {
        
        account.addBalance(100);

        //tests if the addBalance works
        assertEquals(1100, account.getBalance());
    }

    @Test
    public void getBalance() throws Exception {

        //tests if the getBalance returns the right amount and if the starting balance is 1000 points
        assertEquals(1000, account.getBalance());
    }


}



