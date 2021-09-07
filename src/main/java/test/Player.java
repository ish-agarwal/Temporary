package test;

public class Player {
    int position;
    int playerID;

    public Player(int playerID) {
        this.position = 1;
        this.playerID = playerID;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
}
