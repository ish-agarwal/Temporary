package test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Board {
    int maxPosition;
    List<Player> playerList;
    Map<Integer, Move> boardMap;
    int maxIterations = 10;

    public void populateBoard(int n, int players) {
        maxPosition = n * n;
        System.out.println("Winning position is : " + maxPosition);
        System.out.println("Number of players : " + players);
//        int randomNum = ThreadLocalRandom.current().nextInt(1, n + 1);
        boardMap = new HashMap<>();

        boardMap.put(2, new Move(10, 2));
        boardMap.put(5, new Move(15, 5));
        boardMap.put(20, new Move(20, 4));
        boardMap.put(15, new Move(15, 3));

        playerList = new ArrayList<>();
        IntStream.range(1, players + 1).forEach(num -> playerList.add(new Player(num)));
    }

    public void play() {
        int playerPosition;
        while (maxIterations != 0) {
            for (Player player : playerList) {
                System.out.println("Currently playing :::: player-" + player.getPlayerID() + " at position : " + player.getPosition());
                int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
                System.out.println("Diced rolled for number : " + randomNum);
                if (player.getPosition() + randomNum <= maxPosition) {
                    playerPosition = player.getPosition() + randomNum;
                    if (playerPosition == maxPosition) {
                        System.out.println("New position of player-" + player.getPlayerID() + " is : " + playerPosition);
                        System.out.println("Winner of the game by maxPosition is player-" + player.getPlayerID());
                        return;
                    }
                    Move move = boardMap.get(playerPosition);
                    if (move != null)
                        playerPosition = move.getHead() == playerPosition ? move.getTail() : move.getHead();
                    player.setPosition(playerPosition);
                }
                System.out.println("New position of player-" + player.getPlayerID() + " is : " + player.getPosition());
            }
            maxIterations--;
        }
        System.out.println("Winner of the game by max iterations is player-" + playerList.stream().max(Comparator.comparing(Player::getPosition)).get().getPlayerID());
    }
}
