package game.players;

import game.Move;

public abstract class Player {
    protected String name;
    private int wins;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void logWinGame(){
        wins++;
    }

    public int getWins() {
        return wins;
    }

    public abstract Move chooseMove();
}