public class TennisGame {
    private GameScore currentScore;

    public TennisGame() {
        setScore(new GameScoreLoveLove());
    }

    public void wonPoint(String s) {
        if (s.equals("player1")) {
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
