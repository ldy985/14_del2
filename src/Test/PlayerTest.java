
package Test;


import static org.junit.Assert.*;


public class PlayerTest {
    Game.Player testPlayer = new Game.Player("Player1");


    @org.junit.Test
    public void getName() throws Exception {
        assertEquals("Player1", testPlayer.getName());
    }

    @org.junit.Test
    public void setIsTurn() throws Exception {
        testPlayer.setIsTurn(true);
        assertEquals(true, testPlayer.getIsTurn());

        testPlayer.setIsTurn(false);
        assertEquals(false, testPlayer.getIsTurn());
    }

}
