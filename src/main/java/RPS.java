import game.Game;
import game.players.Computer;
import game.players.Player;
import game.players.User;

import java.util.Scanner;

/*
 It is designed to be simple, readable and maintainable code and to fulfill current requirements.
 In case of increasing the complexity, following could be done:
 - managing of user interactions could be extracted to user interface layer
 - introduce game logic layer to isolate the rules and logic of the game
 */

public class RPS {

    public static void main(String[] args) {
        System.out.println("Welcome to Paper Rock Scissors ");

        Player user = new User();
        Player computer = new Computer();
        Game game = new Game(user,computer);

        boolean continueGame;
        do {
            game.playRound();
            continueGame = askPlayAgain(user);
        } while (continueGame);

        game.printStats();

    }

    private static boolean askPlayAgain(Player user) {
        boolean playAgain;
        System.out.println("--------");
        System.out.print(user.getName() + ", do you want to play one more game? (YES, NO) ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine().toUpperCase();

        // Validate user input
        while (!userInput.equals("YES") && !userInput.equals("NO")) {
            System.out.print("Invalid input. Please enter YES or NO: ");
            userInput = scanner.nextLine().toUpperCase();
        }
        playAgain = userInput.equals("YES");

        System.out.println("--------");
        return playAgain;
    }
}