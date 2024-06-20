package game.players;

import game.Move;

import java.util.Scanner;
public class User extends Player {
    private Scanner scanner;

    public User() {
        super("User");
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move chooseMove() {
        System.out.print(name + ", please enter your move (ROCK, PAPER, SCISSORS): ");
        String userInput = scanner.nextLine().toUpperCase();

        // Validate user input
        while (!userInput.equals("ROCK") && !userInput.equals("PAPER") && !userInput.equals("SCISSORS")) {
            System.out.print("Invalid move. Please enter ROCK, PAPER, or SCISSORS: ");
            userInput = scanner.nextLine().toUpperCase();
        }

        return Move.valueOf(userInput);
    }
}