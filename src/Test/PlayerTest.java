
package test;


import static org.junit.Assert.*;


public class PlayerTest {
    game.Player testPlayer = new game.Player("Player1");


    @org.junit.Test
    public void getName() throws Exception {
        assertEquals("Player1", testPlayer.getName());
    }

    @org.junit.Test
    public void setPoints() throws Exception {
        testPlayer.setPoints(100);
        assertEquals(100, testPlayer.getPoints());

        testPlayer.setPoints(0);
        assertEquals(0, testPlayer.getPoints());
    }

    @org.junit.Test
    public void setIsTurn() throws Exception {
        testPlayer.setIsTurn(true);
        assertEquals(true, testPlayer.getIsTurn());

        testPlayer.setIsTurn(false);
        assertEquals(false, testPlayer.getIsTurn());
    }

}
