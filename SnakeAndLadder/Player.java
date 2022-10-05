package SnakeAndLadder;

public class Player {
    private String playerName;
    private int id;

    Player(String playerName, int id) {
        this.id = id;
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
