public class GameScoreLoveForty implements GameScore {
    @Override
    public String getScoreName() {
        return "Love - Forty";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreFifteenForty());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreWinForPlayer2());
    }
}
