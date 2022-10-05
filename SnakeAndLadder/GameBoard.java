package SnakeAndLadder;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameBoard {
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> ladders;
    private List<Jumper> snakes;
    private Map<String, Integer> playerCurrentPosition;
    int boardSize;

    GameBoard(Dice dice, Queue<Player> nextTurn, List<Jumper> ladders, List<Jumper> snakes,
            Map<String, Integer> playerCurrentPosition, int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.ladders = ladders;
        this.snakes = snakes;
        this.playerCurrentPosition = playerCurrentPosition;
        this.boardSize = boardSize;
    }

    void startGame() {
        while (nextTurn.size() > 1) {
            Player player = nextTurn.poll();
            int currentPosition = playerCurrentPosition.get(player.getPlayerName());
            int diceValue = dice.rollDice();
            int nextCell = currentPosition + diceValue;

            if (nextCell > boardSize)
                nextTurn.offer(player);
            else if (nextCell == boardSize)
                System.out.println(player.getPlayerName() + " won the game ");
            else {
                int[] nextPosition = new int[1];
                boolean[] b = new boolean[2];
                nextPosition[0] = nextCell;

                snakes.forEach(v -> {
                    if (v.startPoint == nextCell) {
                        nextPosition[0] = v.endPoint;
                        b[1] = true;
                    }
                });

                if (nextPosition[0] != nextCell && b[1])
                    System.out.println(player.getPlayerName() + " rolled a " + diceValue + " and moved from "
                            + currentPosition + " to " + nextCell);

                ladders.forEach(v -> {
                    if (v.startPoint == nextCell) {
                        nextPosition[0] = v.endPoint;
                        b[0] = true;
                    }
                });

                if (nextPosition[0] != nextCell && b[0])
                    System.out.println(player.getPlayerName() + " rolled a " + diceValue + " and moved from "
                            + currentPosition + " to " + nextCell);

                if (nextPosition[0] == boardSize)
                    System.out.println(player.getPlayerName() + " won the game ");
                else {
                    playerCurrentPosition.put(player.getPlayerName(), nextPosition[0]);
                    if (b[0] || b[1])
                        System.out.println(player.getPlayerName() + " rolled a " + diceValue + " and moved from "
                                + nextCell + " to " + nextPosition[0]);

                    else
                        System.out.println(player.getPlayerName() + " rolled a " + diceValue + " and moved from "
                                + currentPosition + " to " + nextCell);
                    nextTurn.offer(player);
                }
            }
        }
    }

}
