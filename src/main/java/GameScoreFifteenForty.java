public class GameScoreFifteenForty implements GameScore {
    @Override
    public String getScoreName() {
        return "Fifteen - Forty";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreThirtyForty());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreWinForPlayer2());
    }
}
