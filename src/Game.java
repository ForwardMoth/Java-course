import java.util.Scanner;

public class Game {
    private static Player player1;
    private static Player player2;
    private static Scanner scanner = new Scanner(System.in);

    public static void run() {
        System.out.println("Starting new game...");
        startGame();

        System.out.println("Ending the game...");
    }

    private static void startGame() {
        printPlayer("1");
        player1 = new Player(askName());
        printPlayer("2");
        player2 = new Player(askName());
    }

    private static void printPlayer(String playerNumber){
        System.out.print("Player " + playerNumber + ". ");
    }

    private static String askName() {
        System.out.println("Enter your name: ");
        return scanner.nextLine();
    }
}
