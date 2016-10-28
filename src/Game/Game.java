package Game;

/**
 * Created by razze on 26-10-2016.
 */
public class Game {

    public static void main(String[] args) {


        // The GUI generates the fields on the board
        GameController.generateFields();

        // The gameStart() method is called to start the game
        GameController.gameStart();

    }
}
