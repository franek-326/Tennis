public class GameScoreFifteenThirty implements GameScore {
    @Override
    public String getScoreName() {
        return "Fifteen - Thirty";
    }

    @Override
    public void pointForPlayer1(TennisGame game) {
        game.setScore(new GameScoreThirtyThirty());
    }

    @Override
    public void pointForPlayer2(TennisGame game) {
        game.setScore(new GameScoreFifteenForty());
    }
}
