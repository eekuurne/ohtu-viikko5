package ohtu;

import java.util.HashMap;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1;
    private String player2;

    private final int GOAL = 4;
    private final int NEEDED_DIFFERENCE = 2;

    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void wonPoint(String player) {
        if (player.equals(player1)) {
            player1Score += 1;
        } else if (player.equals(player2)) {
            player2Score += 1;
        }
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return equalScore();
        } else if (player1Score >= GOAL || player2Score >= GOAL) {
            return overGoal();
        } else {
            return scoreNames().get(player1Score) + "-" + scoreNames().get(player2Score);
        }
    }

    private String equalScore() {
        if (player1Score >= GOAL) {
            return "Deuce";
        }
        return scoreNames().get(player1Score) + "-All";
    }

    private String overGoal() {
        if (player1Score - player2Score >= NEEDED_DIFFERENCE) {
            return "Win for " + player1;
        } else if (player1Score - player2Score <= -NEEDED_DIFFERENCE) {
            return "Win for " + player2;
        } else if (player1Score - player2Score > 0 && player1Score - player2Score < NEEDED_DIFFERENCE) {
            return "Advantage " + player1;
        } else {
            return "Advantage " + player2;
        }
    }

    private HashMap<Integer, String> scoreNames() {
        HashMap<Integer, String> scoreNames = new HashMap<>();
        scoreNames.put(0, "Love");
        scoreNames.put(1, "Fifteen");
        scoreNames.put(2, "Thirty");
        scoreNames.put(3, "Forty");
        return scoreNames;
    }
}
