import game.Game;
import game.Move;
import game.players.Computer;
import game.players.Player;
import game.players.User;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class RPSGameTest {

    @Test
    public void testComputerChooseMove() {
        Computer computer = new Computer();
        assertNotNull(computer.chooseMove());
    }

    @Test
    public void testUserChooseMoveValidInput() {
        String input = "ROCK\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        User user = new User();
        assertEquals(Move.ROCK, user.chooseMove());
    }

    @Test
    public void testUserChooseMoveInvalidInputThenValidInput() {
        String input = "Invalid\nPAPER\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        User user = new User();
        assertEquals(Move.PAPER, user.chooseMove());
    }

    @Test
    public void testPlayRoundDraw() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Player player1 = new User() {
            @Override
            public Move chooseMove() {
                return Move.ROCK; // Forces user to choose ROCK
            }
        };
        Player player2 = new Computer() {
            @Override
            public Move chooseMove() {
                return Move.ROCK; // Forces computer to choose ROCK
            }
        };

        Game game = new Game(player1, player2);
        game.playRound();

        assertTrue(outContent.toString().contains("It's a draw!"));
    }

    @Test
    public void testPlayRoundUserWins() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Player player1 = new User() {
            @Override
            public Move chooseMove() {
                return Move.PAPER; // Forces user to choose PAPER
            }
        };
        Player player2 = new Computer() {
            @Override
            public Move chooseMove() {
                return Move.ROCK; // Forces computer to choose ROCK
            }
        };

        Game game = new Game(player1, player2);
        game.playRound();

        assertTrue(outContent.toString().contains("User wins!"));
    }

    @Test
    public void testPlayRound_ComputerWins() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Player player1 = new User() {
            @Override
            public Move chooseMove() {
                return Move.ROCK; // Forces user to choose ROCK
            }
        };
        Player player2 = new Computer() {
            @Override
            public Move chooseMove() {
                return Move.PAPER; // Forces computer to choose PAPER
            }
        };

        Game game = new Game(player1, player2);
        game.playRound();

        assertTrue(outContent.toString().contains("Computer wins!"));
    }
}