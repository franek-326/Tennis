public class TennisGame {

    private GameScore score;

    private int player1Score;
    private int player2Score;

    public TennisGame() {
        setScore(new GameScoreLoveLove());

        // TODO finally this will not be needed
        player1Score = 0;
        player2Score = 0;
    }

    public void wonPoint(String s) {
        if (s.equals("player1")) {
            score.pointForPlayer1(this);

            // TODO finally this will not be needed
            player1Score++;
        } else {
            score.pointForPlayer2(this);
            // TODO finally this will not be needed
            player2Score++;
        }
    }


    public String getScore() {
        if (player1Score == player2Score && player1Score == 0) {
            return score.getScoreName();
        } else if (player1Score == 0 && player2Score == 1) {
            return score.getScoreName();
        } else if (player1Score == 1 && player2Score == 0) {
            return score.getScoreName();
        } else if (player1Score == 1 && player2Score == 1) {
            return score.getScoreName();
        } else if (player1Score == 2 && player2Score == 1) {
            return score.getScoreName();
        } else if (player1Score == 1 && player2Score == 2) {
            return score.getScoreName();
        } else if (player1Score == 0 && player2Score == 2) {
            return score.getScoreName();
        } else if (player1Score == 2 && player2Score == 0) {
            return score.getScoreName();
        }


        // TODO finally this will not be needed
        return transformPlayerScoreNumberToScoreName(player1Score, player2Score);

    }


    public void setScore(GameScore newScore) {
        this.score = newScore;
    }


    // TODO finally this will not be needed
    private String transformPlayerScoreNumberToScoreName(int player1Score, int player2Score) {
        String player1ScoreName = "Love";
        String player2ScoreName = "Love";

        if (isAdvantageForPlayer(player1Score, player2Score)) {
            return "Advantage player1";
        }
        if (isAdvantageForPlayer(player2Score, player1Score)) {
            return "Advantage player2";
        }

        if (hasPlayerWon(player1Score, player2Score)) {
            return "Win for player1";
        }
        if (hasPlayerWon(player2Score, player1Score)) {
            return "Win for player2";
        }

        if (isDeuce(player1Score, player2Score)) {
            return "Deuce";
        }

        if (player1Score == 1) {
            player1ScoreName = "Fifteen";
        } else if (player1Score == 2) {
            player1ScoreName = "Thirty";
        } else if (player1Score == 3) {
            player1ScoreName = "Forty";
        }

        if (player2Score == 1) {
            player2ScoreName = "Fifteen";
        } else if (player1Score == 2) {
            player2ScoreName = "Thirty";
        } else if (player1Score == 3) {
            player2ScoreName = "Forty";
        }

        return player1ScoreName + " - " + player2ScoreName;
    }

    private boolean isDeuce(int player1Score, int player2Score) {
        return player1Score >= 3 && player1Score == player2Score;
    }

    /*
        checks if player provided in the first argument has advantage over the other player
        (at least 3 points for both players and
        player with advantage has one point more than the other player)
     */

    private boolean isAdvantageForPlayer(int playerScore, int theOtherPlayerScore) {
        return theOtherPlayerScore >= 3 && playerScore == theOtherPlayerScore + 1;
    }
    /*
        checks if the player provided in the first argument has won
        (at least 4 points and 2 more than the other player)
     */

    private boolean hasPlayerWon(int playerScore, int theOtherPlayerScore) {
        return playerScore >= 4 && playerScore >= theOtherPlayerScore + 2;
    }

}
