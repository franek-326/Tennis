public class TennisGame implements Game {
    private GameScore currentScore;

    TennisGame() {
        setScore(GameScores.createGameScoreLoveLove());
    }

    public void wonPoint(String player) {
        if (player.equals("player1")) {
            currentScore.pointForPlayer1(this);
        } else {
            currentScore.pointForPlayer2(this);
        }
    }

    public String getScore() {
        return currentScore.getScoreName();
    }

    public void setScore(GameScore newScore) {
        this.currentScore = newScore;
    }

}
