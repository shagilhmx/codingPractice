package SnakeAndLadder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

class SnakeAndLadder {
    public static void main(String[] args) throws FileNotFoundException, NoSuchElementException {
        int noOfSnakes, noOfladders, noOfPlayers, boardSize;
        Scanner in = new Scanner(
                new FileReader("/Users/cepl/code/CodingProblems/codingPractice/SnakeAndLadder/input.txt"));
        boardSize = in.nextInt();
        Dice dice = new Dice(in.nextInt());
        noOfSnakes = in.nextInt();
        List<Jumper> snakes = new ArrayList<>();
        for (int i = 0; i < noOfSnakes; i++) {
            int startPoint = in.nextInt();
            int endPoint = in.nextInt();

            Jumper snake = new Jumper(startPoint, endPoint);
            snakes.add(snake);
        }

        noOfladders = in.nextInt();
        List<Jumper> ladders = new ArrayList<>();
        for (int i = 0; i < noOfladders; i++) {
            int startPoint = in.nextInt();
            int endPoint = in.nextInt();

            Jumper ladder = new Jumper(startPoint, endPoint);
            ladders.add(ladder);
        }

        Map<String, Integer> playerCurrentPosition = new HashMap<>();
        noOfPlayers = in.nextInt();
        Queue<Player> allPlayers = new LinkedList<>();
        for (int i = 0; i < noOfPlayers; i++) {
            String name = in.next();
            Player playerName = new Player(name, i + 1);
            allPlayers.offer(playerName);

            playerCurrentPosition.put(name, 0);
        }

        GameBoard gb = new GameBoard(dice, allPlayers, snakes, ladders, playerCurrentPosition, boardSize);
        gb.startGame();
        in.close();
    }
}
