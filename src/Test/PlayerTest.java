
package Test;


import org.junit.Test;

import static org.junit.Assert.*;


public class PlayerTest {


    Game.Player testPlayer = new Game.Player("Player1");


    @Test
    public void getName() throws Exception {
        assertEquals("Player1", testPlayer.getName());
    }

    @Test
    public void setIsTurn() throws Exception {
        testPlayer.setIsTurn(true);
        assertEquals(true, testPlayer.getIsTurn());

        testPlayer.setIsTurn(false);
        assertEquals(false, testPlayer.getIsTurn());
    }

    @Test
    public void getAccount(){
        assertNotNull(testPlayer.getAccount());
    }
}
