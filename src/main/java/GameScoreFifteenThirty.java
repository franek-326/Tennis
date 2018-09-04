public class GameScoreFifteenThirty implements GameScore {

    @Override
    public String getScoreName() {
        return "Fifteen - Thirty";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreThirtyThirty());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreFifteenForty());
    }
}
