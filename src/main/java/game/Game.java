package game;

import game.players.Player;

public class Game {
    private int rounds = 0;
    private final Player player1;
    private final Player player2;



    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playRound() {
        System.out.println("Game " + (rounds + 1));
        Move move1 = player1.chooseMove();
        Move move2 = player2.chooseMove();

        System.out.println(player1.getName() + " chose: " + move1);
        System.out.println(player2.getName() + " chose: " + move2);

        Player winner = defineWinner(move1, move2);
        if (winner != null){
            System.out.println(winner.getName() + " wins!");
            winner.logWinGame();
        } else {
            System.out.println("It's a draw!");
        }
        rounds ++;
    }

    private Player defineWinner(Move move1, Move move2) {
        if (move1 == move2) {
            return null;
        } else if ((move1 == Move.ROCK && move2 == Move.SCISSORS) ||
                (move1 == Move.PAPER && move2 == Move.ROCK) ||
                (move1 == Move.SCISSORS && move2 == Move.PAPER)) {
            return player1;
        } else {
            return player2;
        }
    }

    public void printStats() {
        System.out.println("Rounds played: " + rounds);

        int draws = rounds - player1.getWins() - player2.getWins();
        System.out.println("Draw games: "+ draws);

        System.out.println(player1.getName() + " won: " + player1.getWins());
        System.out.println(player2.getName() + " won: " + player2.getWins());
    }
}
