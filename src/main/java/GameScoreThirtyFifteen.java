public class GameScoreThirtyFifteen implements GameScore {

    @Override
    public String getScoreName() {
        return "Thirty - Fifteen";
    }

    @Override
    public void pointForPlayer1(Game game) {
        game.setScore(GameScores.createGameScoreFortyFifteen());
    }

    @Override
    public void pointForPlayer2(Game game) {
        game.setScore(GameScores.createGameScoreThirtyThirty());
    }
}
