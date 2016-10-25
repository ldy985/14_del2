package Test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Matt_Lab on 25/10/2016.
 */
public class AccountTest {
    //creates a account object
    Game.Account account = new Game.Account();

    @Test
    public void addBalance() throws Exception {


        int balanceBefore = account.getBalance();
        account.addBalance(100);

        //tests if the start balance starts at 1000
        assertEquals(balanceBefore, 1000);

        //tests if the addBalance works
        assertEquals(1100, account.getBalance());
    }

    @Test
    public void getBalance() throws Exception {

        //tests if the getBalance returns the right amount
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void setBalance() throws Exception {

        //sets the balance to 20
        account.setBalance(20);

        //tests if the balance is 20
        assertEquals(20, account.getBalance());
    }

}



