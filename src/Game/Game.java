package Game;

/**
 * Created by razze on 26-10-2016.
 */

// Initializes the game.
public class Game {

    public static void main(String[] args) {

        // The GUI generates the fields on the board
        GameController.initializeGui();

        // The startGame() method is called to startGame the game
        GameController.startGame();

    }
}
