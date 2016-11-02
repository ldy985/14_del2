package Game;


// Game entrypoint.
public class Game {

    public static void main(String[] args) {

        // The GUI generates the fields on the board
        GameController.initializeGui();

        // The startGame() method is called to startGame the game
        GameController.startGame();

    }
}
