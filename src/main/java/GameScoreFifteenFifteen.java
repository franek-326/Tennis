public class GameScoreFifteenFifteen implements GameScore {
    @Override
    public String getScoreName() {
        return "Fifteen - Fifteen";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreThirtyFifteen());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore((new GameScoreFifteenThirty()));
    }
}
