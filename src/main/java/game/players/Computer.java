package game.players;

import game.Move;

import java.util.Random;

public class Computer extends Player {
    Random random = new Random();

    public Computer() {
        super("Computer");
    }

    @Override
    public Move chooseMove() {
        return Move.values()[random.nextInt(Move.values().length)];
    }
}
