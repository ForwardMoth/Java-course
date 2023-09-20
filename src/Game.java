import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Player player1;
    private static Player player2;
    private static Scanner scanner = new Scanner(System.in);

    private static int gameTurn;


    public static void run() {
        System.out.println("Starting new game...");
        startGame();
        placementShips();
        chooseGameTurn();
        startPlaying();
        System.out.println("Ending the game...");
    }

    private static void placementShips(){
        if ((isDevelopment()))
            placementTestShips();
        else
            placementGameShips();
    }

    private static boolean isDevelopment() {
        System.out.println("Choose your mode (Development - 1, Game - 0)");
        return Integer.parseInt(scanner.nextLine()) == 1;
    }

    private static void startGame() {
        printPlayer("1");
        player1 = new Player(askName());
        printPlayer("2");
        player2 = new Player(askName());
    }

    private static void startPlaying() {
//        while(player1.isAlive() & player2.isAlive()) {
//
//        }
    }

    private static void chooseGameTurn() {
        Random rand = new Random();
        gameTurn = rand.nextInt(2);
        System.out.println("Player " + getCurrentPlayer().getName() + " is starting game.");
    }

    private static Player getCurrentPlayer() {
        return (gameTurn == 0) ? player1 : player2;
    }

    private static void placementTestShips() {
        String[] testShipsPlayer1 = new String[]{"A1 A4",
                                                 "C1 E1", "D10 F10",
                                                 "B8 B9", "J3 J4", "H9 I9",
                                                 "I1", "G2", "G6", "D6"};
        String[] testShipsPlayer2 = new String[]{"B2 B5",
                                                 "E8 G8", "H3 J3",
                                                 "A8 A9", "E1 F1", "F5 G5",
                                                 "J1", "J7", "D6", "I10"};
        player1.fillTestShips(testShipsPlayer1);
        player2.fillTestShips(testShipsPlayer2);
    }

    private static void placementGameShips() {
        player1.fillShips(scanner);
        player2.fillShips(scanner);
    }

    private static void printPlayer(String playerNumber){
        System.out.print("Player " + playerNumber + ". ");
    }

    private static String askName() {
        System.out.println("Enter your name: ");
        return scanner.nextLine();
    }
}
