public class GameScoreLoveFifteen implements GameScore {

    @Override
    public String getScoreName() {
        return "Love - Fifteen";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreFifteenFifteen());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreLoveThirty());
    }
}
