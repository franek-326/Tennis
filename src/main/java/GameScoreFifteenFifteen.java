public class GameScoreFifteenFifteen implements GameScore {

    @Override
    public String getScoreName() {
        return "Fifteen - Fifteen";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreThirtyFifteen());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore((GameScores.createGameScoreFifteenThirty()));
    }
}
